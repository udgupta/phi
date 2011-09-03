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



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(PersonnelController)
@Mock(Personnel)
class PersonnelControllerTests {

    void testIndex() {
        controller.index()
        assert "/personnel/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.personnelInstanceList.size() == 0
        assert model.personnelInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.personnelInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.personnelInstance != null
        assert view == '/personnel/create'

        response.reset()

        // TODO: Populate valid properties

        controller.save()

        assert response.redirectedUrl == '/personnel/show/1'
        assert controller.flash.message != null
        assert Personnel.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/personnel/list'


        def personnel = new Personnel()

        // TODO: populate domain properties

        assert personnel.save() != null

        params.id = personnel.id

        def model = controller.show()

        assert model.personnelInstance == personnel
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/personnel/list'


        def personnel = new Personnel()

        // TODO: populate valid domain properties

        assert personnel.save() != null

        params.id = personnel.id

        def model = controller.edit()

        assert model.personnelInstance == personnel
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/personnel/list'

        response.reset()


        def personnel = new Personnel()

        // TODO: populate valid domain properties

        assert personnel.save() != null

        // test invalid parameters in update
        params.id = personnel.id

        controller.update()

        assert view == "/personnel/edit"
        assert model.personnelInstance != null

        personnel.clearErrors()

        // TODO: populate valid domain form parameter
        controller.update()

        assert response.redirectedUrl == "/personnel/show/$personnel.id"
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/personnel/list'

        response.reset()

        def personnel = new Personnel()

        // TODO: populate valid domain properties
        assert personnel.save() != null
        assert Personnel.count() == 1

        params.id = personnel.id

        controller.delete()

        assert Personnel.count() == 0
        assert Personnel.get(personnel.id) == null
        assert response.redirectedUrl == '/personnel/list'
    }
}
