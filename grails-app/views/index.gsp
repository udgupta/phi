<!doctype html>
<%@page import="org.phi.customers.personnel.Personnel"%>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Mifos</title>
	</head>
	<body>            
        <div id="topRightCorner">
            <sec:ifLoggedIn>
                <g:link controller="logout">Logout</g:link>
            </sec:ifLoggedIn>            
            <sec:ifNotLoggedIn>
                <g:link controller='login'>Login</g:link>
            </sec:ifNotLoggedIn>
        </div>
        <div class="navBar">
            <g:remoteLink action="search" controller="home" update="content">Home</g:remoteLink>
            <g:remoteLink action="accounts" controller="home" update="content">Clients and Accounts</g:remoteLink>
            <g:remoteLink action="reports" controller="home" update="content">Reports</g:remoteLink>
            <g:remoteLink action="admin" controller="home" update="content">Admin</g:remoteLink>
        </div>
		<div class="quickStart">
            <p>Quick Start</p>
            <div class="clientsLinks">
                <b>Manage Client</b>
                <a href="#">Create Group</a>
                <a href="#">Create Client</a>
            </div>
            <div class="accountsLinks">
                <b>Manage Accounts</b>
                <a href="#">Create Loan</a>
                <a href="#">Create Savings</a>
                <a href="#">Collection Sheet</a>
            </div>
        </div>
        <div id='content' class="homeContent"></div>
        <div >
        </div>
	</body>
</html>
