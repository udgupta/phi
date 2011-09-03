<%@ page import="org.phi.customers.personnel.Personnel" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'personnel.label', default: 'Personnel')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-personnel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                <li><g:form action="search"><input type='search' name='q' placeholder='search personnel'/></g:form></li>
			</ul>
		</div>
		<div id="list-personnel" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="username" title="${message(code: 'personnel.username.label', default: 'Username')}" />
						<th><g:message code="personnel.name.first.label" default="First Name" /></th>
                        <th><g:message code="personnel.name.last.label" default="Last Name" /></th>
						<g:sortableColumn property="email" title="${message(code: 'personnel.email.label', default: 'Email')}" />
						<g:sortableColumn property="locale" title="${message(code: 'personnel.locale.label', default: 'Language')}" />
                        <g:sortableColumn property="dob" title="${message(code: 'personnel.dob.label', default: 'Date of Birth')}" />
                        <g:sortableColumn property="enabled" title="${message(code: 'personnel.enabled.label', default: 'Enabled')}" />
                        <g:sortableColumn property="accountExpired" title="${message(code: 'personnel.accountExpired.label', default: 'Account Expired')}" />
                        <g:sortableColumn property="accountLocked" title="${message(code: 'personnel.accountLocked.label', default: 'Locked')}" />
                        <g:sortableColumn property="passwordExpired" title="${message(code: 'personnel.passwordExpired.label', default: 'Password Expired')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${personnelInstanceList}" status="i" var="personnelInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="show" id="${personnelInstance.id}">${fieldValue(bean: personnelInstance, field: "username")}</g:link></td>
						<td>${fieldValue(bean: personnelInstance, field: "name.firstName")}</td>
                        <td>${fieldValue(bean: personnelInstance, field: "name.lastName")}</td>
						<td>${fieldValue(bean: personnelInstance, field: "email")}</td>
                        <td>${fieldValue(bean: personnelInstance, field: "locale")}</td>
                        <td>${fieldValue(bean: personnelInstance, field: "dob")}</td>    
						<td><g:formatBoolean boolean="${personnelInstance.enabled}" /></td>
                        <td><g:formatBoolean boolean="${personnelInstance.accountExpired}" /></td>
                        <td><g:formatBoolean boolean="${personnelInstance.accountLocked}" /></td>
                        <td><g:formatBoolean boolean="${personnelInstance.passwordExpired}" /></td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${personnelInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
