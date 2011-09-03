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

import org.phi.accounts.ActiveStateType
import org.phi.customers.Address
import org.phi.customers.Name
import org.phi.customers.personnel.Personnel
import org.phi.office.Office
import org.phi.office.OfficeLevel
import org.phi.security.Role
import org.phi.security.UserRole

class BootStrap {

    def springSecurityService

    def now = new Date()

    def init = { servletContext ->

        def userRole = new Role(authority: "ROLE_USER").save()
        def adminRole = new Role(authority: "ROLE_ADMIN").save()

        println "+++++++++++++++++++++++++++++++++++++++"
        println "   creating data "
        println "+++++++++++++++++++++++++++++++++++++++"

        // Office levels
        def headOfficeLevel = new OfficeLevel(level:1, name:"Head Office").save()
        def divisionalOfficeLevel = new OfficeLevel(level:2, name:"Divisional Office").save()
        def areaOfficeLevel = new OfficeLevel(level:3, name:"Area Office").save()
        def branchOfficeLevel = new OfficeLevel(level:4, name:"Branch Office").save()

        def headOffice = new Office(name:"MIFOS HQ",
                                    level:headOfficeLevel,
                                    state:ActiveStateType.ACTIVE,
                                    createdDate:now).save()
        createOffices(headOffice, 1)
        println "created Offices"


        def admin = new Personnel(username        : "admin",
                                  password        : "admin",
                                  enabled         : true,
                                  locale : 1,
                                  email           : "admin@abc.xyz",
                                  dob             : now,
                                  nationalId      : "XE2346D")
                                  .addToOffices(headOffice).save()
        UserRole.create(admin, adminRole)
        println "created admin user"

        for(int i=1; i<21; i++) {
            def uname = new Name(firstName  : "firstName"+i,
                                 middleName : "middleName"+i,
                                 lastName   : "lastName"+i)

            def uaddress = new Address(line1       : "line1 "+i,
                                       line2       : "line2 "+i,
                                       line3       : "line3 "+i,
                                       city        : "Bangalore",
                                       state       : "Karnataka",
                                       country     : "India",
                                       zip         : "560076",
                                       phoneNumber : "8343503945")

            def user = new Personnel(username        : "user"+i,
                                     password        : "user"+i,
                                     enabled         : true,
                                     locale : 1,
                                     email           : "user"+i+"@abc.xyz",
                                     dob             : now,
                                     nationalId      : "RC63FD"+i,
                                     name            : uname,
                                     address         : uaddress)
                                    .addToOffices(Office.findById(i)).save()
            UserRole.create(user, userRole)
            println "created test user "+i
        }
    }

    def destroy = {
    }

    def createOffices(Office office, int level) {
        if(level < 4) {
            for(int i=0; i < 5; i++) {
                OfficeLevel officeLevel = OfficeLevel.findByLevel(level + 1)
                def newOffice = new Office( name   : officeLevel.name +" "+(level+1)+" "+i+" "+ office.name,
                                            level  : officeLevel,
                                            parent : office,
                                            state  : ActiveStateType.ACTIVE,
                                            createdDate:now).save()
                println "created " + newOffice.name
                createOffices(newOffice, level + 1)
            }
        }
    }
}
