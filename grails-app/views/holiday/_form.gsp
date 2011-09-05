<%@ page import="org.phi.holiday.Holiday" %>

<div class="fieldcontain ${hasErrors(bean: holidayInstance, field: 'name', 'error')} ">
    <label for="name">
        <g:message code="holiday.name.label" default="Name" />
    </label>
    <g:textField name="name" value="${holidayInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: holidayInstance, field: 'startDate', 'error')} required">
    <label for="startDate">
        <g:message code="holiday.startDate.label" default="Start Date (included)" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField id="startDate" name="startDate" placeholder="yyyy-mm-dd" value="${holidayInstance?.startDate}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: holidayInstance, field: 'endDate', 'error')} required">
	<label for="endDate">
		<g:message code="holiday.endDate.label" default="End Date (excluded)" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField id="endDate" name="endDate" placeholder="yyyy-mm-dd" value="${holidayInstance?.endDate}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: holidayInstance, field: 'repaymentRule', 'error')} required">
	<label for="repaymentRule">
		<g:message code="holiday.repaymentRule.label" default="Repayment Rule" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="repaymentRule" from="${org.phi.holiday.RepaymentRuleTypes.values()}" required=""
              optionKey="key" optionValue="name"/>
</div>

<div class="fieldcontain required abspos">
    <label for="officeList">
        <g:message code="holiday.selectOffice.label" default="Select Office" />
        <span class="required-indicator">*</span>
    </label>
    <div id="officeTree"></div>
</div>

<style>
 #officeTree {
     margin-left: 26%;
 }
 .abspos {
    position: relative;
 }
</style>
   <r:script>
       $(function(){
            $("#officeTree").dynatree({
                checkbox: true,
                selectMode: 3,
                initAjax: {
                    url: '${g.createLink(url:[controller:'officeRest', action:'fullHierarchy'])}'
                 },
                 onActivate: function(node) {
                     $.get('options?officeId='+node.data.key+"&officeName="+node.data.title, function(data) {
                         $("#echoActive").html(data);
                        });
                 },
            });
            
            $("#startDate").datepicker({ showOn: 'button', dateFormat: 'yy-mm-dd' });
            $("#endDate").datepicker({ showOn: 'button', dateFormat: 'yy-mm-dd' });
       });
    </r:script>

