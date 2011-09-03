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

package org.phi.products

import org.phi.products.VariableInstallmentDetails;
import org.phi.master.InterestType;
import org.phi.products.CashFlowDetail;
import org.phi.products.ProductMeeting;
import org.phi.products.GracePeriodType;
import org.phi.products.Product;
import org.phi.accounts.financial.GLCode;

class LoanProduct extends Product {

    VariableInstallmentDetails variableInstallmentDetails

    GracePeriodType gracePeriodType

    Short variableInstallmentsAllowed

    Short waiverInterest

    GLCode principalGLcode

    Short prinDueLastInst

    Set loanAmountFromLastLoan

    Set loanProductFunds

    Short cashFlowCheckEnabled

    Set noOfInstallFromLastLoan

    Short loanCounter

    Double defInterestRate

    ProductMeeting loanProductMeeting

    Set loanProductFees

    Set noOfInstallSameForAllLoan

    Set noOfInstallFromLoanCycle

    Double minInterestRate

    Set loanAmountFromLoanCycle

    Short intDedDisbursement

    Double maxInterestRate

    Short gracePeriodDuration

    CashFlowDetail cashFlowDetail

    InterestType interestTypes

    Set loanAmountSameForAllLoan

    GLCode interestGLcode

}
