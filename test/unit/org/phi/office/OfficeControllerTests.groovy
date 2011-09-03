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



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(OfficeController)
@Mock(Office)
class OfficeControllerTests {

    void testIndex() {
        controller.index()
        assert "/office/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.officeInstanceList.size() == 0
        assert model.officeInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.officeInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.officeInstance != null
        assert view == '/office/create'

        response.reset()

        // TODO: Populate valid properties

        controller.save()

        assert response.redirectedUrl == '/office/show/1'
        assert controller.flash.message != null
        assert Office.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/office/list'


        def office = new Office()

        // TODO: populate domain properties

        assert office.save() != null

        params.id = office.id

        def model = controller.show()

        assert model.officeInstance == office
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/office/list'


        def office = new Office()

        // TODO: populate valid domain properties

        assert office.save() != null

        params.id = office.id

        def model = controller.edit()

        assert model.officeInstance == office
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/office/list'

        response.reset()


        def office = new Office()

        // TODO: populate valid domain properties

        assert office.save() != null

        // test invalid parameters in update
        params.id = office.id

        controller.update()

        assert view == "/office/edit"
        assert model.officeInstance != null

        office.clearErrors()

        // TODO: populate valid domain form parameter
        controller.update()

        assert response.redirectedUrl == "/office/show/$office.id"
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/office/list'

        response.reset()

        def office = new Office()

        // TODO: populate valid domain properties
        assert office.save() != null
        assert Office.count() == 1

        params.id = office.id

        controller.delete()

        assert Office.count() == 0
        assert Office.get(office.id) == null
        assert response.redirectedUrl == '/office/list'
    }
}
