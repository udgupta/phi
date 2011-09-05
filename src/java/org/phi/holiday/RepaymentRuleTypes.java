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

package org.phi.holiday;


public enum RepaymentRuleTypes {
    SAME_DAY(1, "Same Day"), //
    NEXT_MEETING_OR_REPAYMENT(2, "Next Meeting Or Repayment"), //
    NEXT_WORKING_DAY(3, "Next Working Day"), //
    REPAYMENT_MORATORIUM(4, "Moratorium");

    private Integer key;
    private String name;

    RepaymentRuleTypes(final Integer key, final String name) {
        this.key = key;
        this.name = name;
    }

    public Integer getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public static RepaymentRuleTypes fromKey(final Integer key) {
        for (RepaymentRuleTypes adjustmentRule : values()) {
            if (adjustmentRule.getKey().equals(key)) {
                return adjustmentRule;
            }
        }

        throw new IllegalArgumentException("No " + RepaymentRuleTypes.class.getSimpleName() + " defined for key=" + key);
    }
}