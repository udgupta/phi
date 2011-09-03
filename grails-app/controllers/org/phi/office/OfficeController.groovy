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

package org.phi.office

import org.phi.accounts.ActiveStateType
import org.phi.customers.Address
import org.springframework.dao.DataIntegrityViolationException

class OfficeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "hierarchy", params: params)
    }

    def list() {
        redirect(action: "hierarchy", params: params)
    }

    def hierarchy() {
        [:]
    }

    def options() {
        [officeId: params.officeId, officeName: params.officeName]
    }

    def create() {
        def map = [:]
        if(!params.officeId){
            redirect(controller: "office", params: params)
        }
        map.put('officeId', params.officeId)
        map.put('officeInstance', new Office(params))
        map.put('addressInstance', new Address(params))
        return map
    }

    def save() {
        if(!params.officeId){
            redirect(controller: "office", params: params)
        }
        Office parent = Office.findById(params.officeId)
        def officeInstance = new Office(params)
        def addressInstance = new Address(params)
        officeInstance.address = addressInstance
        officeInstance.state = ActiveStateType.ACTIVE
        officeInstance.parent = parent
        officeInstance.level = OfficeLevel.findByLevel(parent.level.level + 1)
        if (!officeInstance.save(flush: true)) {
            render(view: "create", model: [officeInstance: officeInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'office.label', default: 'Office'), officeInstance.id])
        redirect(action: "show", id: officeInstance.id)
    }

    def show() {
        def officeInstance = Office.get(params.id)
        if (!officeInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'office.label', default: 'Office'), params.id])
            redirect(action: "list")
            return
        }

        [officeInstance: officeInstance]
    }

    def edit() {
        def officeInstance = Office.get(params.id)
        if (!officeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'office.label', default: 'Office'), params.id])
            redirect(action: "list")
            return
        }

        [officeInstance: officeInstance]
    }

    def update() {
        def officeInstance = Office.get(params.id)
        if (!officeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'office.label', default: 'Office'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (officeInstance.version > version) {
                officeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'office.label', default: 'Office')] as Object[],
                          "Another user has updated this Office while you were editing")
                render(view: "edit", model: [officeInstance: officeInstance])
                return
            }
        }

        officeInstance.properties = params

        if (!officeInstance.save(flush: true)) {
            render(view: "edit", model: [officeInstance: officeInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'office.label', default: 'Office'), officeInstance.id])
        redirect(action: "show", id: officeInstance.id)
    }

    def delete() {
        def officeInstance = Office.get(params.id)
        if (!officeInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'office.label', default: 'Office'), params.id])
            redirect(action: "list")
            return
        }

        try {
            officeInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'office.label', default: 'Office'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'office.label', default: 'Office'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
