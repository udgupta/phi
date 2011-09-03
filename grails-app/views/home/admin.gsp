<style>
ul.adminOptions {
	list-style: none outside none;
}
ul.adminOptions li {
    height: 25px;
    margin: 5px;
    padding: 2px 0 0 20px;
    width: 220px;
}
</style>
<div id="displayContent">
    <ul id="adminOptions" class="adminOptions">
        <li><g:link controller="office">Personnel</g:link></li>
        <li><g:link controller="office">Offices</g:link></li>
        <li onclick="showSubOptions('fees')">Fees</li>
        <li>Funds</li>
        <li>Holidays</li>
        <li>Organization Settings</li>
        <li>Bulk Import</li>
        <li>Accounting</li>
        <li>System Information</li>
        <li>Scheduled Tasks</li>
        <li>Products</li>
        <li>Reports</li>
        <li>Additional Questions</li>
        <li>Loan Redo or Reverse</li>
    </ul>
</div>