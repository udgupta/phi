<%@ page import="org.phi.holiday.Holiday"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName" value="${message(code: 'holiday.label', default: 'Holiday')}" />
<title><g:message code="default.list.label" args="[entityName]" />
</title>
</head>
<body>
    <a href="#list-holiday" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;" />
    </a>
    <div class="nav" role="navigation">
        <ul>
            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label" />
            </a>
            </li>
            <li><g:link class="create" action="create">
                    <g:message code="default.new.label" args="[entityName]" />
                </g:link>
            </li>
        </ul>
    </div>
    <div id="list-holiday" class="content scaffold-list" role="main">
        <h1>
            <g:message code="default.list.label" args="[entityName]" />
        </h1>
        <g:if test="${flash.message}">
            <div class="message" role="status">
                ${flash.message}
            </div>
        </g:if>
        <table>
            <thead>
                <tr>
                    <g:sortableColumn property="name" title="${message(code: 'holiday.name.label', default: 'Name')}" />
                    <g:sortableColumn property="startDate" title="${message(code: 'holiday.startDate.label', default: 'Start Date')}" />
                    <g:sortableColumn property="endDate" title="${message(code: 'holiday.endDate.label', default: 'End Date')}" />
                    <g:sortableColumn property="repaymentRule" title="${message(code: 'holiday.repaymentRule.label', default: 'Repayment Rule')}" />
                    <g:sortableColumn property="isAppliedFlag" title="${message(code: 'holiday.isAppliedFlag.label', default: 'Applied')}" />
                    <th><g:message code="holiday.edit" default="Edit" /></th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${holidayInstanceList}" status="i" var="holidayInstance">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">                    
                        <td>
                            ${fieldValue(bean: holidayInstance, field: "name")}
                        </td>
                        <td>
                            ${fieldValue(bean: holidayInstance, field: "endDate")}
                        </td>
                        <td>
                            ${fieldValue(bean: holidayInstance, field: "startDate")}
                        </td>
                        <td>
                            ${fieldValue(bean: holidayInstance, field: "repaymentRule.name")}
                        </td>
                        <td>
                            <g:if test="${holidayInstance.isAppliedFlag}">Yes</g:if>
                            <g:else>No</g:else>
                        </td>
                        <td>
                        <g:link action="edit" id="${holidayInstance.id}">
                            <g:img file="edit-icon.png" />
                        </g:link>
                        </td>
                    </tr>
                </g:each>
            </tbody>
        </table>
        <div class="pagination">
            <g:paginate total="${holidayInstanceTotal}" />
        </div>
    </div>
</body>
</html>
