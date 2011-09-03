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

public enum WeekDayType {
    SUNDAY   ((short) 1), //
    MONDAY   ((short) 2), //
    TUESDAY  ((short) 3), //
    WEDNESDAY((short) 4), //
    THURSDAY ((short) 5), //
    FRIDAY   ((short) 6), //
    SATURDAY ((short) 7); //

    private Short value;
    private String weekdayName;

    WeekDayType(final Short value) {
        this.value = value;
        this.weekdayName = "";
    }

    public Short getValue() {
        return value;
    }

    /*
     * In Joda time MONDAY=1 and SUNDAY=7, so shift these to SUNDAY=1, SATURDAY=7 to match this class
     */
    public static WeekDayType getJodaWeekDay(final int value) {
        return getWeekDay((value % 7) + 1);
    }

    public static WeekDayType getWeekDay(final int value) {
        for (WeekDayType weekday : WeekDayType.values()) {
            if (weekday.value == value) {
                return weekday;
            }
        }
        throw new RuntimeException("no week day " + value);
    }

    public WeekDayType next() {
        if (this == SATURDAY) {
            return SUNDAY;
        }
        return getWeekDay(value + 1);
    }

    public String getName() {
        return getWeekdayName();
    }

    public String getPropertiesKey() {
        return WeekDayType.class.getSimpleName()+ "." + toString();
    }

    public String getWeekdayName() {
        return this.weekdayName;
    }

    public void setWeekdayName(String weekdayName) {
        this.weekdayName = weekdayName;
    }
}
