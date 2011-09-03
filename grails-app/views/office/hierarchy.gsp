<%@ page import="org.phi.office.Office" %>
<!doctype html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'office.label', default: 'Office')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
        <style>
            #officeTree{
                width:50%;
                margin:5px;
                display:inline-block;
            }
            #officeOptions{
                border: 2px solid green;
                border-radius: 10px 10px 10px 10px;
                box-shadow: 2px 2px 2px 2px grey;
                margin: 15px;
                padding: 10px;
                position: absolute;
                width: 45%;
                line-height: 170%
            }
        </style>
    </head>
    <body>
        <a href="#list-office" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
            </ul>
        </div>
        <div id="officeTree"></div>
        <span id="echoActive"></span>

   <script type="text/javascript">
       $(function(){
            $("#officeTree").dynatree({
                initAjax: {
                    url: "rest"
                 },
                 onActivate: function(node) {
                	 $.get('options?officeId='+node.data.key+"&officeName="+node.data.title, function(data) {
                		 $("#echoActive").html(data);
                		});
                 },
                 onLazyRead: function(node){
                    node.appendAjax({
                        url: "rest/"+node.data.key
                        });
                     }
            });
       });
    </script>
    </body>
</html>
