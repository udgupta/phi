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
import org.phi.customers.personnel.Personnel
import org.phi.holiday.Holiday

class Office {

    String name

    OfficeLevel level

    ActiveStateType state

    Address address

    static embedded = ['address']

    static hasOne = [parent: Office]

    static hasMany = [personnels: Personnel,
                      children: Office,
                      holidays: Holiday]

    static constraints = {
        address nullable: true
        parent nullable: true
        name blank: false, unique: true
    }
}
