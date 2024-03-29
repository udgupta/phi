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

package org.codehaus.groovy.grails.plugins.springsecurity.acl

class AclSid {

	String sid
	boolean principal

	@Override
	String toString() {
		"AclSid id $id, sid $sid, principal $principal"
	}

	static mapping = {
		version false
	}

	static constraints = {
		principal unique: 'sid'
		sid blank: false, size: 1..255
	}
}
