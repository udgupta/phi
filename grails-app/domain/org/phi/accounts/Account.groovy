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

package org.phi.accounts

import org.phi.office.Office;
import org.phi.accounts.AccountState;
import org.phi.accounts.AccountType;
import org.phi.customers.Customer;
import org.phi.customers.personnel.Personnel;

class Account {

    Office office

    Set accountCustomFields

    Set accountFees

    Integer offsettingAllowable

    Date updatedDate

    String globalAccountNum

    Date closedDate

    Customer customer

    Set accountFlags

    String externalId

    Short updatedBy

    Collection accountPayments

    AccountState accountState

    Personnel personnel

    Short createdBy

    Collection accountStatusChangeHistory

    Set accountNotes

    Integer versionNo

    AccountType accountType

    Date createdDate

}
