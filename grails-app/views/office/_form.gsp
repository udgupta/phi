<%@ page import="org.phi.office.Office" %>


<div class="fieldcontain ${hasErrors(bean: officeInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="office.name.label" default="Name" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField required="" name="name" value="${officeInstance?.name}"/>
</div>

<fieldset class="embedded"><legend><g:message code="office.address.label" default="Address" /></legend>

<div class="fieldcontain ${hasErrors(bean: officeInstance, field: 'address.line1', 'error')} ">
	<label for="address.line1">
		<g:message code="office.address.line1.label" default="Line1" />
		
	</label>
	<g:textField name="line1" value="${addressInstance?.line1}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: officeInstance, field: 'address.line2', 'error')} ">
	<label for="address.line2">
		<g:message code="office.address.line2.label" default="Line2" />
		
	</label>
	<g:textField name="line2" value="${addressInstance?.line2}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: officeInstance, field: 'address.line3', 'error')} ">
	<label for="address.line3">
		<g:message code="office.address.line3.label" default="Line3" />
		
	</label>
	<g:textField name="line3" value="${addressInstance?.line3}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: officeInstance, field: 'address.city', 'error')} ">
    <label for="address.city">
        <g:message code="office.address.city.label" default="City" />
        
    </label>
    <g:textField name="city" value="${addressInstance?.city}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: officeInstance, field: 'address.state', 'error')} ">
	<label for="address.state">
		<g:message code="office.address.state.label" default="State" />
		
	</label>
	<g:textField name="state" value="${addressInstance?.state}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: officeInstance, field: 'address.country', 'error')} ">
    <label for="address.country">
        <g:message code="office.address.country.label" default="Country" />
        
    </label>
    <g:textField name="country" value="${addressInstance?.country}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: officeInstance, field: 'address.zip', 'error')} ">
	<label for="address.zip">
		<g:message code="office.address.zip.label" default="Zip" />
		
	</label>
	<g:textField name="zip" value="${addressInstance?.zip}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: officeInstance, field: 'address.phoneNumber', 'error')} ">
    <label for="address.phoneNumber">
        <g:message code="office.address.phoneNumber.label" default="Phone Number" />
        
    </label>
    <g:textField name="phoneNumber" value="${addressInstance?.phoneNumber}"/>
</div>

<g:hiddenField name="officeId" value="${parent.id}"/>

</fieldset>