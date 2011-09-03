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

import org.phi.products.LoanProduct
import org.phi.accounts.loan.MaxMinLoanAmount
import org.phi.master.InterestType
import org.phi.meeting.WeekDayType
import org.phi.accounts.loan.LoanAccount
import org.phi.meeting.Meeting
import org.phi.meeting.RankOfDayType
import org.phi.accounts.loan.MaxMinNoOfInstall
import org.phi.accounts.Account
import org.phi.accounts.fund.Fund
import org.phi.accounts.loan.LoanArrearsAging
import org.phi.accounts.loan.LoanSummary
import org.phi.accounts.loan.MaxMinInterestRate
import org.phi.accounts.loan.LoanPerformanceHistory
import org.phi.products.GracePeriodType

class LoanAccount extends Account {

    GracePeriodType gracePeriodType

    BigDecimal loanAmount

    Short intrestAtDisbursement

    Boolean redone

    Short recurMonth

    Short gracePeriodPenalty

    Collection loanActivityDetails

    InterestType interestType

    Date disbursementDate

    LoanPerformanceHistory performanceHistory

    Set accountActionDates

    MaxMinLoanAmount maxMinLoanAmount

    Fund fund

    Meeting loanMeeting

    Integer collateralTypeId

    LoanProduct loanProduct

    LoanSummary loanSummary

    LoanAccount parentAccount

    RankOfDayType monthRank

    Double interestRate

    MaxMinNoOfInstall maxMinNoOfInstall

    Integer businessActivityId

    BigDecimal loanBalance

    Short noOfInstallments

    LoanArrearsAging loanArrearsAging

    WeekDayType monthWeek

    Short gracePeriodDuration

    Short groupFlag

    MaxMinInterestRate maxMinInterestRate

    String collateralNote

}
