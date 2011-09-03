/*
 * Copyright (c) 2011 Udai Gupta
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * See also http://www.apache.org/licenses/LICENSE-2.0.html for an
 * explanation of the license and how it is applied.
 */

package org.phi.customers.personnel

import org.phi.customers.Address
import org.phi.customers.ImageContent
import org.phi.customers.Name
import org.phi.office.Office
import org.springframework.dao.DataIntegrityViolationException

class PersonnelController {

    static allowedMethods = [save: "POST", update: "POST"]

    def index() {
        redirect(action: "underOffice", params: params)
    }

    def underOffice() {
        if(!params.officeId){
            redirect(controller: "office", params: params)
        }
        def map = [:]
        Office office = Office.findById(params.officeId)
        def plist = office.personnels
        map.put("personnelInstanceList", plist)
        map.put("personnelInstanceTotal", plist.size())
        map.put("officeInstance", office)
        render(view: "list", model: map)
    }

    def search() {
        def personnelList
        def personnelCount
        if(params.q) {
            params.max = Math.min(params.max ? params.int('max') : 10, 100)
            personnelList = Personnel.search(params.q + "*", params).results
            personnelCount = personnelList.size()
        }
        render(view: "list", model: [personnelInstanceList: personnelList, personnelInstanceTotal: personnelCount])
    }

    def create() {
        def map = [:]
        if(!params.officeId){
            redirect(controller: "office", params: params)
        }

        map.put('officeId', params.officeId)
        map.put('personnelInstance', new Personnel(params))
        map.put('nameInstance', new Name(params))
        map.put('addressInstance', new Address(params))
        return map
    }

    def save() {
        if(!params.officeId){
            redirect(action: "create", params: params)
        }

        def personnelInstance = new Personnel(params)
        def nameInstance = new Name(params)
        def addressInstance = new Address(params)
        personnelInstance.name = nameInstance
        personnelInstance.address = addressInstance
        personnelInstance.addToOffices(Office.findById(params.officeId))


        def f = request.getPart('picture')
        if(f) {
            def okcontents = ['image/png', 'image/jpeg', 'image/gif']
            if (! okcontents.contains(f.getContentType())) {
                flash.message = "Image must be one of: ${okcontents}"
                redirect(action: "create", params: params)
                return
            }

            ImageContent image = new ImageContent()
            image.content =  f.getBytes()
            image.type = f.getContentType()
            personnelInstance.image = image
            log.info("File uploaded: " + image.type)
        }

        if (!personnelInstance.save(flush: true)) {
            render(view: "create", model: [personnelInstance: personnelInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'personnel.label', default: 'Personnel'), personnelInstance.id])
        redirect(action: "show", id: personnelInstance.id)
    }

    def show() {
        def personnelInstance = Personnel.get(params.id)
        if (!personnelInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'personnel.label', default: 'Personnel'), params.id])
            redirect(action: "list")
            return
        }

        [personnelInstance: personnelInstance]
    }

    def edit() {
        def personnelInstance = Personnel.get(params.id)
        if (!personnelInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'personnel.label', default: 'Personnel'), params.id])
            redirect(action: "list")
            return
        }
        def map = [:]
        map.put('personnelInstance', personnelInstance)
        map.put('nameInstance', personnelInstance.name)
        map.put('addressInstance', personnelInstance.address)
        return map
    }

    def update() {
        def personnelInstance = Personnel.get(params.id)
        if (!personnelInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'personnel.label', default: 'Personnel'), params.id])
            redirect(action: "list")
            return
        }

        def f = request.getFile('picture')
        if(!f.empty) {
            def okcontents = ['image/png', 'image/jpeg', 'image/gif']
            if (! okcontents.contains(f.getContentType())) {
                flash.message = "Image must be one of: ${okcontents}"
                redirect(action: "create", params: params)
                return
            }

            ImageContent image = new ImageContent()
            image.content =  f.getBytes()
            image.type = f.getContentType()
            personnelInstance.image = image
            image.save()
            log.info("File uploaded: " + image.type)
        }

        if (params.version) {
            def version = params.version.toLong()
            if (personnelInstance.version > version) {
                personnelInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'personnel.label', default: 'Personnel')] as Object[],
                          "Another user has updated this Personnel while you were editing")
                render(view: "edit", model: [personnelInstance: personnelInstance])
                return
            }
        }

        personnelInstance.properties = params

        if (!personnelInstance.save(flush: true)) {
            render(view: "edit", model: [personnelInstance: personnelInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'personnel.label', default: 'Personnel'), personnelInstance.id])
        redirect(action: "show", id: personnelInstance.id)
    }
}
