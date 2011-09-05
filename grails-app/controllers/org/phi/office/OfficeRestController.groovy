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

package org.phi.office

class OfficeRestController {

    def get() {
        def office
        def officeList = []
        if(params.id) {
            office =  Office.findById(params.id)
            for(Office childOffice : office.children.sort{a,b-> a.name.compareTo(b.name)}) {
                officeList.add(buildLazy(childOffice))
            }
        } else {
            office = Office.get(1)
            officeList.add(buildLazy(office))
        }
        render officeList as grails.converters.JSON
    }


    def fullHierarchy() {
        def office = Office.get(1)
        render buildFull(office) as grails.converters.JSON
    }

    private static Map buildLazy(Office office) {
        def map = [:]
        map.put("title", office.name +" ("+ office.level.name+")")
        map.put("key", office.id)
       // if(office.level.level < OfficeLevel.find("select l.level from "+OfficeLevel+" l" ).max()) {
            map.put("isLazy", true)
        //} else {
          //  map.put("isLazy", false)
        //}
        return map
    }

    private static Map buildFull(Office office) {
        def map = [:]
        map.put("title", office.name +" ("+ office.level.name+")")
        map.put("key", office.id)
        def children = []
        for(Office child: office.children) {
            children.add(buildFull(child))
        }
        if(!children.empty) {
            map.put("children", children)
        }
        return map
    }

}
