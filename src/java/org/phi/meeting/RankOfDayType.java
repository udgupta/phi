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

package org.phi.meeting;

import java.util.List;

import java.util.Arrays;

public enum RankOfDayType {

    FIRST ((short) 1),
    SECOND((short) 2),
    THIRD ((short) 3),
    FOURTH((short) 4),
    LAST  ((short) 5);

    private Short value;

    private RankOfDayType(final Short value) {
        this.value = value;
    }

    public Short getValue() {
        return value;
    }

    public static RankOfDayType getRankOfDay(final Integer value) {
        for (RankOfDayType rank : RankOfDayType.values()) {
            if (rank.getValue().equals(value.shortValue())) {
                return rank;
            }
        }
        return null;
    }

    public static RankOfDayType getRankOfDay(final Short value) {
        return getRankOfDay(value.intValue());
    }

    public static List<RankOfDayType> getRankOfDayList() {
        return Arrays.asList(values());
    }

    public String getPropertiesKey() {
        return RankOfDayType.class.getSimpleName()+ "." + toString();
    }
}