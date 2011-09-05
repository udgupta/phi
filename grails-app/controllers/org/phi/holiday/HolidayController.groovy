package org.phi.holiday

import org.joda.time.LocalDate
import org.springframework.dao.DataIntegrityViolationException

class HolidayController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [holidayInstanceList: Holiday.list(params), holidayInstanceTotal: Holiday.count()]
    }

    def create() {
        [holidayInstance: new Holiday(params)]
    }

    def save() {
        def holidayInstance = new Holiday()
        holidayInstance.isAppliedFlag = false
        holidayInstance.startDate = new LocalDate(params.startDate)
        holidayInstance.endDate = new LocalDate(params.endDate)
        holidayInstance.name = params.name
        holidayInstance.repaymentRule = RepaymentRuleTypes.fromKey(Integer.parseInt(params.repaymentRule))
        if (!holidayInstance.save(flush: true)) {
            render(view: "create", model: [holidayInstance: holidayInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'holiday.label', default: 'Holiday'), holidayInstance.id])
        redirect(action: "list")
    }

    def edit() {
        def holidayInstance = Holiday.get(params.id)
        if (!holidayInstance && !holidayInstance.isAppliedFlag) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'holiday.label', default: 'Holiday'), params.id])
            redirect(action: "list")
            return
        }

        [holidayInstance: holidayInstance]
    }

    def update() {
        def holidayInstance = Holiday.get(params.id)
        if (!holidayInstance && !holidayInstance.isAppliedFlag) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'holiday.label', default: 'Holiday'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (holidayInstance.version > version) {
                holidayInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'holiday.label', default: 'Holiday')] as Object[],
                          "Another user has updated this Holiday while you were editing")
                render(view: "edit", model: [holidayInstance: holidayInstance])
                return
            }
        }

        holidayInstance.properties = params

        if (!holidayInstance.save(flush: true)) {
            render(view: "edit", model: [holidayInstance: holidayInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'holiday.label', default: 'Holiday'), holidayInstance.id])
        redirect(action: "show", id: holidayInstance.id)
    }
}
