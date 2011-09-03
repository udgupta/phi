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

package org.phi.master;

import org.phi.accounts.loan.LoanAccount;
import org.phi.accounts.savings.Savings;
import org.phi.customers.center.Center;
import org.phi.customers.client.Client;
import org.phi.customers.group.Group;

public enum MasterEntityType {
    CLIENT(Client.class),
    GROUP(Group.class),
    CENTER(Center.class),
    LOAN_ACCOUNT(LoanAccount.class),
    SAVING_ACCOUNT(Savings.class);

    Class<?> clazz;

    MasterEntityType(Class<?> clazz) {
        this.clazz = clazz;
    }

}
