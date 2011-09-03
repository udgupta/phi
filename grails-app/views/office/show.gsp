<%@ page import="org.phi.office.Office"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName" value="${message(code: 'office.label', default: 'Office')}" />
<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
    <a href="#show-office" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;" /> </a>
    <div class="nav" role="navigation">
        <ul>
            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label" /> </a></li>
            <li><g:link class="list" action="list">
                    <g:message code="default.list.label" args="[entityName]" />
                </g:link></li>
            <li><g:link class="create" action="create" params="[officeId:officeInstance.id]">
                    Create <g:message code="default.new.label" args="[entityName]" /> under ${officeInstance.name}
                </g:link></li>
        </ul>
    </div>
    <div id="show-office" class="content scaffold-show" role="main">
        <h1>
            <g:message code="default.show.label" args="[entityName]" />
        </h1>
        <g:if test="${flash.message}">
            <div class="message" role="status">
                ${flash.message}
            </div>
        </g:if>
        <ol class="property-list office">
            <li class="fieldcontain">
                <span id="name-label" class="property-label"><g:message code="office.name.label" default="Name" />  </span> 
                <span class="property-value" aria-labelledby="name-label"> ${officeInstance.name} </span>
            </li>
            <li class="fieldcontain">
                <span id="state-label" class="property-label"><g:message code="office.state.label" default="State" /> </span> 
                <span class="property-value" aria-labelledby="state-label"><g:fieldValue bean="${officeInstance}" field="state" /> </span>
            </li>
            <li class="fieldcontain">
                <span id="level-label" class="property-label"><g:message code="office.level.label" default="Level" /> </span> 
                <span class="property-value" aria-labelledby="level-label"> ${officeInstance?.level?.name} </span>
            </li>
            <g:if test="${officeInstance?.address}">
                <li class="fieldcontain"><span id="address-label" class="property-label"><g:message code="office.address.label" default="Address" /> </span> <span
                    class="property-value" aria-labelledby="address-label"><g:fieldValue bean="${officeInstance}" field="address" /> </span>
                </li>
            </g:if>
            <g:if test="${officeInstance?.parent}">
                <li class="fieldcontain"><span id="parent-label" class="property-label"><g:message code="office.parent.label" default="Parent Office" /> </span> <span
                    class="property-value" aria-labelledby="parent-label"> <g:link controller="office" action="show" id="${officeInstance?.parent?.id}">
                            ${officeInstance?.parent?.name}
                        </g:link> </span>
                </li>
            </g:if>
            <g:if test="${officeInstance?.children}">
                <li class="fieldcontain"><span id="children-label" class="property-label"><g:message code="office.children.label" default="Children" /> </span> <g:each
                        in="${officeInstance.children}" var="c">
                        <span class="property-value" aria-labelledby="children-label"> <g:link controller="office" action="show" id="${c.id}">
                                ${c?.name}
                            </g:link> </span>
                    </g:each>
                </li>
            </g:if>
            <g:if test="${officeInstance?.holidays}">
                <li class="fieldcontain"><span id="holidays-label" class="property-label"><g:message code="office.holidays.label" default="Holidays" /> </span> <g:each
                        in="${officeInstance.holidays}" var="h">
                        <span class="property-value" aria-labelledby="holidays-label"><g:link controller="holiday" action="show" id="${h.id}">
                                ${h?.encodeAsHTML()}
                            </g:link> </span>
                    </g:each>
                </li>
            </g:if>
            <g:if test="${officeInstance?.personnels}">
                <li class="fieldcontain"><span id="personnel-label" class="property-label"><g:message code="office.personnel.label" default="Personnel" /> </span> <g:each
                        in="${officeInstance.personnels}" var="p">
                        <span class="property-value" aria-labelledby="personnel-label"> <g:link controller="personnel" action="show" id="${p.id}">
                                ${p?.username}
                            </g:link> </span>
                    </g:each>
                </li>
            </g:if>
        </ol>
        <g:form>
            <fieldset class="buttons">
                <g:link class="edit" action="edit" id="${officeInstance?.id}">
                    <g:message code="default.button.edit.label" default="Edit" />
                </g:link>
            </fieldset>
        </g:form>
    </div>
</body>
</html>
