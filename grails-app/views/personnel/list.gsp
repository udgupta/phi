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
                <li>
                    <g:link controller="office"> Go Back To Office List </g:link>
                </li>
				<li>
                    <g:link class="create" action="create" params="[officeId:officeInstance.id]">
                        Create <g:message code="default.new.label" args="[entityName]" /> in ${officeInstance.name}
                    </g:link>
                 </li>
                <li><g:form action="search"><input type='search' name='q' placeholder='search personnel'/></g:form></li>
			</ul>
		</div>
		<div id="list-personnel" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /> in <i>${officeInstance.name}</i></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<th><g:message code="personnel.username.label" default="Username" /></th>
						<th><g:message code="personnel.name.first.label" default="First Name" /></th>
                        <th><g:message code="personnel.name.last.label" default="Last Name" /></th>
						<th><g:message code="personnel.email.label" default="Email" /></th>
						<th><g:message code="personnel.locale.label" default="Language" /></th>
                        <th><g:message code="personnel.dob.label" default="Date of Birth" /></th>
                        <th><g:message code="personnel.enabled.label" default="Enabled" /></th>
                        <th><g:message code="personnel.accountExpired.label" default="Account Expired" /></th>
                        <th><g:message code="personnel.accountLocked.label" default="Locked" /></th>
                        <th><g:message code="personnel.passwordExpired.label" default="Password Expired" /></th>
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
