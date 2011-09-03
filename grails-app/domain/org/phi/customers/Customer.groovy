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

package org.phi.customers

import org.phi.customers.CustomerMeeting;
import org.phi.customers.Customer;
import org.phi.customers.CustomerAddressDetail;
import org.phi.customers.CustomerLevel;
import org.phi.office.Office;
import org.phi.customers.CustomerHistoricalData;
import org.phi.customers.CustomerStatus;
import org.phi.customers.personnel.Personnel;

class Customer {

    Integer maxChildCount

    CustomerHistoricalData historicalData

    Set customerMovements

    Set children

    Set customerHierarchies

    String searchId

    Personnel formedByPersonnel

    String globalCustNum

    String externalId

    Short updatedBy

    Personnel personnel

    Set customerFlags

    String displayAddress

    Integer versionNo

    Customer parentCustomer

    Short trained

    Set customerNotes

    Date createdDate

    Set nameDetailSet

    Office office

    Date trainedDate

    Set accounts

    Set customFields

    Date updatedDate

    Set customerPositions

    CustomerLevel customerLevel

    Date customerActivationDate

    Short blackListed

    CustomerAddressDetail customerAddressDetail

    Short createdBy

    CustomerMeeting customerMeeting

    Date mfiJoiningDate

    CustomerStatus customerStatus

    String displayName

}
