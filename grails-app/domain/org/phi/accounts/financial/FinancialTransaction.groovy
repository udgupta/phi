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

package org.phi.accounts.financial

import org.phi.accounts.financial.FinancialTransaction;
import org.phi.accounts.financial.FinancialActionType;
import org.phi.accounts.AccountTrxn;
import org.phi.customers.personnel.Personnel;
import org.phi.accounts.financial.GLCode;

class FinancialTransaction {

    FinancialTransaction relatedFinancialTrxn

    FinancialActionType financialAction

    BigDecimal postedAmount

    Date postedDate

    Date actionDate

    AccountTrxn accountTrxn

    BigDecimal balanceAmount

    Short debitCreditFlag

    Personnel postedBy

    GLCode glcode

    Short accountingUpdated

    String notes

}
