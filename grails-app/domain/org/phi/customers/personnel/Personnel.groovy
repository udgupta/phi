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

import java.util.Date

import org.phi.customers.Address
import org.phi.customers.ImageContent
import org.phi.customers.Name
import org.phi.office.Office
import org.phi.security.User

class Personnel extends User {

    static searchable = {
        only = ['username', 'nationalId', 'email']
        name component:true
    }

    Name name

    Address address

    ImageContent image

    static embedded = ['name', 'address']

    String nationalId

    Date dob

    Integer locale

    String email

    static belongsTo = Office

    static hasMany = [personnelNotes: PersonnelNote, offices: Office]

    static constraints = {
        name nullable: true
        address nullable: true
        image nullable: true
        email email: true, blank: false
    }
}
