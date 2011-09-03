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

import org.phi.customers.CustomerLevel
import org.phi.office.Office
import org.phi.products.ProductType
import org.phi.products.ProductCategory
import org.phi.products.PrdStatus

class Product {

    Office office

    Date startDate

    Date updatedDate

    ProductType prdType

    String globalPrdProductNum

    Date endDate

    String currencyCode

    Short updatedBy

    Set questionGroups

    Set collectionProductMix

    String prdProductName

    Short createdBy

    String prdProductShortName

    String description

    Short prdMixFlag

    PrdStatus prdStatus

    Integer versionNo

    Set prdProductNotAllowedId

    Date createdDate

    ProductCategory prdCategory

    CustomerLevel appliesTo

}
