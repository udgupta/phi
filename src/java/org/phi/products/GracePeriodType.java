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

package org.phi.products;

public enum GracePeriodType {

    NONE((short) 1), //
    ALL_REPAYMENTS((short) 2), //
    PRINCIPAL_ONLY((short) 3);
    
    private Short value;

    private GracePeriodType(Short value) {
        this.value = value;
    }

    public static boolean isGraceTypeNONE(Short graceTypeValue) {
        return graceTypeValue == null || graceTypeValue.equals(NONE.getValue());
    }

    public Short getValue() {
        return value;
    }

    public static GracePeriodType fromInt(int value) {
        for (GracePeriodType graceTypeConstants : GracePeriodType.values()) {
            if (graceTypeConstants.getValue() == value) {
                return graceTypeConstants;
            }
        }
        throw new RuntimeException("no grace type " + value);
    }

    public String getValueAsString() {
        return value.toString();
    }
}
