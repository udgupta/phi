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

package org.phi.questionnaire;

import org.phi.questionnaire.QuestionGroupStateType;

public enum QuestionGroupStateType {
    INACTIVE (false), ACTIVE (true);

    private final boolean state;

    QuestionGroupStateType(boolean state)
    {
        this.state = state;
    }

    public static QuestionGroupStateType getQuestionGroupStateAsEnum(boolean active) {
        return active? ACTIVE : INACTIVE;
    }

    public boolean state() {
        return state;
    }
}
