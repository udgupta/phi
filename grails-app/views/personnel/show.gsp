<%@ page import="org.phi.customers.personnel.Personnel" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'personnel.label', default: 'Personnel')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-personnel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-personnel" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list personnel">
				<g:if test="${personnelInstance?.username}">
				<li class="fieldcontain">
					<span id="username-label" class="property-label"><g:message code="personnel.username.label" default="Username" /></span>
				     <span class="property-value" aria-labelledby="username-label"><g:fieldValue bean="${personnelInstance}" field="username"/></span>
				</li>
				</g:if>
				<g:if test="${personnelInstance?.name?.firstName}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="personnel.name.firstName.label" default="First Name" /></span>
					<span class="property-value" aria-labelledby="name-firstName-label"><g:fieldValue bean="${personnelInstance}" field="name.firstName"/></span>
				</li>
				</g:if>
                <g:if test="${personnelInstance?.name?.middleName}">
                <li class="fieldcontain">
                    <span id="name-label" class="property-label"><g:message code="personnel.name.middleName.label" default="Middle Name" /></span>
                    <span class="property-value" aria-labelledby="name-middleName-label"><g:fieldValue bean="${personnelInstance}" field="name.middleName"/></span>
                </li>
                </g:if>
                <g:if test="${personnelInstance?.name?.lastName}">
                <li class="fieldcontain">
                    <span id="name-label" class="property-label"><g:message code="personnel.name.lastName.label" default="Last Name" /></span>
                    <span class="property-value" aria-labelledby="name-lastName-label"><g:fieldValue bean="${personnelInstance}" field="name.lastName"/></span>
                </li>
                </g:if>
				<g:if test="${personnelInstance?.address}">
				<li class="fieldcontain">
					<span id="address-label" class="property-label"><g:message code="personnel.address.label" default="Address" /></span>
					<span class="property-value" aria-labelledby="address-label">
                                    <g:fieldValue bean="${personnelInstance}" field="address.line1"/><br>
                                    <g:fieldValue bean="${personnelInstance}" field="address.line2"/><br>
                                    <g:fieldValue bean="${personnelInstance}" field="address.line3"/><br>
                                    <g:message code="personnel.address.city.label" default="City" /> -
                                    <g:fieldValue bean="${personnelInstance}" field="address.city"/><br>
                                    <g:message code="personnel.address.state.label" default="State" /> -
                                    <g:fieldValue bean="${personnelInstance}" field="address.state"/><br>
                                    <g:message code="personnel.address.country.label" default="Country" /> -
                                    <g:fieldValue bean="${personnelInstance}" field="address.country"/><br>
                                    <g:message code="personnel.address.zip.label" default="Zip" /> -
                                    <g:fieldValue bean="${personnelInstance}" field="address.zip"/><br>
                                    <g:message code="personnel.address.phone.label" default="Phone" /> -
                                    <g:fieldValue bean="${personnelInstance}" field="address.phoneNumber"/><br>
                    </span>
				</li>
				</g:if>
				<g:if test="${personnelInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="personnel.email.label" default="Email" /></span>
					<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${personnelInstance}" field="email"/></span>
				</li>
				</g:if>
				<g:if test="${personnelInstance?.accountExpired}">
				<li class="fieldcontain">
					<span id="accountExpired-label" class="property-label"><g:message code="personnel.accountExpired.label" default="Account Expired" /></span>
					<span class="property-value" aria-labelledby="accountExpired-label"><g:formatBoolean boolean="${personnelInstance?.accountExpired}" /></span>
				</li>
				</g:if>
				<g:if test="${personnelInstance?.accountLocked}">
				<li class="fieldcontain">
					<span id="accountLocked-label" class="property-label"><g:message code="personnel.accountLocked.label" default="Account Locked" /></span>
					<span class="property-value" aria-labelledby="accountLocked-label"><g:formatBoolean boolean="${personnelInstance?.accountLocked}" /></span>
				</li>
				</g:if>
				<g:if test="${personnelInstance?.dob}">
				<li class="fieldcontain">
					<span id="dob-label" class="property-label"><g:message code="personnel.dob.label" default="Date of birth" /></span>
					<span class="property-value" aria-labelledby="dob-label"><g:formatDate date="${personnelInstance?.dob}" /></span>
				</li>
				</g:if>
				<g:if test="${personnelInstance?.enabled}">
				<li class="fieldcontain">
					<span id="enabled-label" class="property-label"><g:message code="personnel.enabled.label" default="Enabled" /></span>
					<span class="property-value" aria-labelledby="enabled-label"><g:formatBoolean boolean="${personnelInstance?.enabled}" /></span>
				</li>
				</g:if>
				<g:if test="${personnelInstance?.nationalId}">
				<li class="fieldcontain">
					<span id="nationalId-label" class="property-label"><g:message code="personnel.nationalId.label" default="National Id" /></span>
					<span class="property-value" aria-labelledby="nationalId-label"><g:fieldValue bean="${personnelInstance}" field="nationalId"/></span>
				</li>
				</g:if>
				<g:if test="${personnelInstance?.office}">
				<li class="fieldcontain">
					<span id="office-label" class="property-label"><g:message code="personnel.office.label" default="Office" /></span>
						<g:each in="${personnelInstance.office}" var="o">
						<span class="property-value" aria-labelledby="office-label"><g:link controller="office" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></span>
						</g:each>
				</li>
				</g:if>
				<g:if test="${personnelInstance?.passwordExpired}">
				<li class="fieldcontain">
					<span id="passwordExpired-label" class="property-label"><g:message code="personnel.passwordExpired.label" default="Password Expired" /></span>
					<span class="property-value" aria-labelledby="passwordExpired-label"><g:formatBoolean boolean="${personnelInstance?.passwordExpired}" /></span>
				</li>
				</g:if>
			    <g:if test="${personnelInstance?.personnelNotes}">
				<li class="fieldcontain">
					<span id="personnelNotes-label" class="property-label"><g:message code="personnel.personnelNotes.label" default="Personnel Notes" /></span>
						<g:each in="${personnelInstance.personnelNotes}" var="p">
						<span class="property-value" aria-labelledby="personnelNotes-label"><g:link controller="personnelNote" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
				</li>
				</g:if>
				<g:if test="${personnelInstance?.locale}">
				<li class="fieldcontain">
					<span id="locale-label" class="property-label"><g:message code="personnel.locale.label" default="Preferred Locale" /></span>
					<span class="property-value" aria-labelledby="locale-label"><g:fieldValue bean="${personnelInstance}" field="locale"/></span>	
				</li>
				</g:if>
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${personnelInstance?.id}" />
					<g:link class="edit" action="edit" id="${personnelInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
