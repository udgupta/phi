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

public enum ProductType {
    LOAN((short) 1), SAVINGS((short) 2);

    private Short value;

    private ProductType(Short value) {
        this.value = value;
    }

    public Short getValue() {
        return value;
    }

    public static ProductType getProductType(int value) {
        for (ProductType productType : ProductType.values()) {
            if (productType.getValue() == value) {
                return productType;
            }
        }
        throw new RuntimeException("no product type " + value);
    }

    public static ProductType fromInt(Integer productTypeId) {
        return getProductType(productTypeId);
    }
}
