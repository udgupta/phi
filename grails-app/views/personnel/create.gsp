<%@ page import="org.phi.customers.personnel.Personnel" %>
<%@ page import="org.phi.office.Office" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'personnel.label', default: 'Personnel')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-personnel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" controller="office">Office</g:link></li>
			</ul>
		</div>
		<div id="create-personnel" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" />
            <g:if test="${officeId}">
               for  ${Office.findById(officeId).name}
            </g:if>
            </h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div
			</g:if>
			<g:hasErrors bean="${personnelInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${personnelInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:uploadForm action="save" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:uploadForm>
		</div>
	</body>
</html>
