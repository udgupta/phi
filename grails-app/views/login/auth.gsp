<head>
<meta name='layout' content='main' />
<title><g:message code="springSecurity.login.title" />
</title>
</head>
<body>
    <g:if test='${flash.message}'>
        <div class='login_message'>${flash.message}</div>
    </g:if>
    <div id='login'>
        <div class='inner'>
            <div class='fheader'>
                <g:message code="springSecurity.login.header" />
            </div>
            <form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
                <p>
                    <label for='username'><g:message code="springSecurity.login.username.label" /> :
                    </label> <input type='text' class='text_' name='j_username' id='username' value='admin' />
                </p>
                <p>
                    <label for='password'><g:message code="springSecurity.login.password.label" /> :
                    </label> <input type='password' class='text_' name='j_password' id='password' value='password' />
                </p>
                <p>
                    <input type='submit' class="submit" value='${message(code: "springSecurity.login.button")}' />
                </p>
            </form>
        </div>
    </div>
    <script type='text/javascript'>(function(){
	document.forms['loginForm'].elements['j_username'].focus();
})();
</script>
</body>
