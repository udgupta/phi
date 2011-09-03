<%@ page import="org.phi.customers.personnel.Personnel"%>
<div class="fieldcontain ${hasErrors(bean: personnelInstance, field: 'username', 'error')} required">
    <label for="username"> <g:message code="personnel.username.label" default="Username" /> <span
        class="required-indicator">*</span> </label>
    <g:textField name="username" required="" value="${personnelInstance?.username}" />
</div>

<div class="fieldcontain ${hasErrors(bean: personnelInstance, field: 'password', 'error')} required">
    <label for="password"> <g:message code="personnel.password.label" default="Password" /> 
    <span class="required-indicator">*</span> </label>
    <g:passwordField name="password" maxlength="15" required="" />
</div>

<div class="fieldcontain ${hasErrors(bean: personnelInstance, field: 'dob', 'error')} required">
    <label for="dob"> <g:message code="personnel.dob.label" default="Date of birth" /> <span
        class="required-indicator">*</span> </label>
    <g:datePicker name="dob" precision="day" value="${personnelInstance?.dob}" />
</div>

<div class="fieldcontain ${hasErrors(bean: personnelInstance, field: 'dob', 'error')}">
    <label for="image"> <g:message code="personnel.image.label" default="Image" /></label>
    <input name="picture" type="file" />
</div>

<div class="fieldcontain ${hasErrors(bean: personnelInstance, field: 'nationalId', 'error')} ">
    <label for="nationalId"> <g:message code="personnel.nationalId.label" default="National Id" /> </label>
    <g:textField name="nationalId" value="${personnelInstance?.nationalId}" />
</div>

<div class="fieldcontain ${hasErrors(bean: personnelInstance, field: 'locale', 'error')} required">
    <label for="locale"> <g:message code="personnel.locale.label" default="Preferred Locale" />
        <span class="required-indicator">*</span> </label>
    <g:field type="number" name="locale" required=""
        value="${fieldValue(bean: personnelInstance, field: 'locale')}" />
</div>
<div class="fieldcontain ${hasErrors(bean: personnelInstance, field: 'email', 'error')} required">
    <label for="email"> <g:message code="personnel.email.label" default="Email" /> <span
        class="required-indicator">*</span> </label>
    <g:field type="email" name="email" required="" value="${personnelInstance?.email}" />
</div>
<fieldset class="embedded">
    <legend>
        <g:message code="personnel.name.label" default="Name" />
    </legend>
    <div class="fieldcontain ${hasErrors(bean: personnelInstance, field: 'name.firstName', 'error')} ">
        <label for="name.firstName"> <g:message code="personnel.name.firstName.label" default="First Name" /> </label>
        <g:textField name="firstName" required="" value="${nameInstance?.firstName}" />
    </div>


    <div class="fieldcontain ${hasErrors(bean: personnelInstance, field: 'name.middleName', 'error')} ">
        <label for="name.middleName"> <g:message code="personnel.name.middleName.label" default="Middle Name" />
        </label>
        <g:textField name="middleName" value="${nameInstance?.middleName}" />
    </div>

    <div class="fieldcontain ${hasErrors(bean: personnelInstance, field: 'name.lastName', 'error')} " >
        <label for="name.lastName"> <g:message code="personnel.name.lastName.label" default="Last Name" /> </label>
        <g:textField name="lastName" required="" value="${nameInstance?.lastName}" />
    </div>
</fieldset>
<fieldset class="embedded">
    <legend>
        <g:message code="personnel.address.label" default="Address" />
    </legend>
    <div class="fieldcontain ${hasErrors(bean: personnelInstance, field: 'address.city', 'error')} ">
        <label for="address.city"> <g:message code="personnel.address.city.label" default="City" /> </label>
        <g:textField name="city" value="${addressInstance?.city}" />
    </div>

    <div class="fieldcontain ${hasErrors(bean: personnelInstance, field: 'address.country', 'error')} ">
        <label for="address.country"> <g:message code="personnel.address.country.label" default="Country" /> </label>
        <g:textField name="country" value="${addressInstance?.country}" />
    </div>

    <div class="fieldcontain ${hasErrors(bean: personnelInstance, field: 'address.line1', 'error')} ">
        <label for="address.line1"> <g:message code="personnel.address.line1.label" default="Line1" /> </label>
        <g:textField name="line1" value="${addressInstance?.line1}" />
    </div>

    <div class="fieldcontain ${hasErrors(bean: personnelInstance, field: 'address.line2', 'error')} ">
        <label for="address.line2"> <g:message code="personnel.address.line2.label" default="Line2" /> </label>
        <g:textField name="line2" value="${addressInstance?.line2}" />
    </div>

    <div class="fieldcontain ${hasErrors(bean: personnelInstance, field: 'address.line3', 'error')} ">
        <label for="address.line3"> <g:message code="personnel.address.line3.label" default="Line3" /> </label>
        <g:textField name="line3" value="${addressInstance?.line3}" />
    </div>

    <div class="fieldcontain ${hasErrors(bean: personnelInstance, field: 'address.phoneNumber', 'error')} ">
        <label for="address.phoneNumber"> <g:message code="personnel.address.phoneNumber.label"
                default="Phone Number" /> </label>
        <g:textField name="phoneNumber" value="${addressInstance?.phoneNumber}" />
    </div>

    <div class="fieldcontain ${hasErrors(bean: personnelInstance, field: 'address.state', 'error')} ">
        <label for="address.state"> <g:message code="personnel.address.state.label" default="State" /> </label>
        <g:textField name="state" value="${addressInstance?.state}" />
    </div>

    <div class="fieldcontain ${hasErrors(bean: personnelInstance, field: 'address.zip', 'error')} ">
        <label for="address.zip"> <g:message code="personnel.address.zip.label" default="Zip" /> </label>
        <g:textField name="zip" value="${addressInstance?.zip}" />
    </div>
</fieldset>
<g:if test="{officeId}">
    <g:hiddenField name="officeId" value="${officeId}"/>
</g:if>
<div class="fieldcontain ${hasErrors(bean: personnelInstance, field: 'personnelNotes', 'error')} ">
    <label for="personnelNotes"> <g:message code="personnel.personnelNotes.label" default="Personnel Notes" />

    </label>

    <ul class="one-to-many">
        <g:each in="${personnelInstance?.personnelNotes?}" var="p">
            <li><g:link controller="personnelNote" action="show" id="${p.id}">
                    ${p?.encodeAsHTML()}
                </g:link></li>
        </g:each>
        <li class="add"><g:link controller="personnelNote" action="create"
                params="['personnel.id': personnelInstance?.id]">
                ${message(code: 'default.add.label', args: [message(code: 'personnelNote.label', default: 'PersonnelNote')])}
            </g:link>
        </li>
    </ul>
</div>
