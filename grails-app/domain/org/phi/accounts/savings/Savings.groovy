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

package org.phi.accounts.savings

import org.phi.products.SavingsAccountType;
import org.phi.accounts.Account;
import org.phi.products.InterestCalcType;
import org.phi.products.SavingsAccountAppliesToType;
import org.phi.accounts.savings.SavingsPerformance;
import org.phi.products.SavingsProduct;

class Savings extends Account {

    Date nextIntPostDate

    InterestCalcType interestCalcType

    SavingsProduct savingsProduct

    Set savingsActivityDetails

    Date activationDate

    BigDecimal savingsBalance

    Double interestRate

    BigDecimal interestToBePosted

    SavingsAccountType savingsType

    BigDecimal recommendedAmount

    SavingsPerformance savingsPerformance

    Set accountActionDates

    Date lastIntPostDate

    SavingsAccountAppliesToType recommendedAmntUnit

}
