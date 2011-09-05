package org.phi.holiday



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(HolidayController)
@Mock(Holiday)
class HolidayControllerTests {

    void testIndex() {
        controller.index()
        assert "/holiday/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.holidayInstanceList.size() == 0
        assert model.holidayInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.holidayInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.holidayInstance != null
        assert view == '/holiday/create'

        response.reset()

        // TODO: Populate valid properties

        controller.save()

        assert response.redirectedUrl == '/holiday/show/1'
        assert controller.flash.message != null
        assert Holiday.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/holiday/list'


        def holiday = new Holiday()

        // TODO: populate domain properties

        assert holiday.save() != null

        params.id = holiday.id

        def model = controller.show()

        assert model.holidayInstance == holiday
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/holiday/list'


        def holiday = new Holiday()

        // TODO: populate valid domain properties

        assert holiday.save() != null

        params.id = holiday.id

        def model = controller.edit()

        assert model.holidayInstance == holiday
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/holiday/list'

        response.reset()


        def holiday = new Holiday()

        // TODO: populate valid domain properties

        assert holiday.save() != null

        // test invalid parameters in update
        params.id = holiday.id

        controller.update()

        assert view == "/holiday/edit"
        assert model.holidayInstance != null

        holiday.clearErrors()

        // TODO: populate valid domain form parameter
        controller.update()

        assert response.redirectedUrl == "/holiday/show/$holiday.id"
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/holiday/list'

        response.reset()

        def holiday = new Holiday()

        // TODO: populate valid domain properties
        assert holiday.save() != null
        assert Holiday.count() == 1

        params.id = holiday.id

        controller.delete()

        assert Holiday.count() == 0
        assert Holiday.get(holiday.id) == null
        assert response.redirectedUrl == '/holiday/list'
    }
}
