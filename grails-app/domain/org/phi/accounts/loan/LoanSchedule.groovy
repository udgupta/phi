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

package org.phi.accounts.loan

import org.phi.accounts.Account;
import org.phi.customers.Customer;

class LoanSchedule {

    Date paymentDate

    BigDecimal principalPaid

    Short paymentStatus

    Customer customer

    BigDecimal miscPenalty

    BigDecimal miscFee

    BigDecimal extraInterestPaid

    Date actionDate

    BigDecimal principal

    BigDecimal miscPenaltyPaid

    BigDecimal interestPaid

    BigDecimal interest

    Integer versionNo

    Account account

    Short installmentId

    Set accountFeesActionDetails

    BigDecimal penaltyPaid

    BigDecimal penalty

    BigDecimal miscFeePaid

    BigDecimal extraInterest

}
