
modules = {
    common {
        dependsOn 'jquery, jqueryUI, jqueryTree'
        resource url: 'images/favicon.ico'
        resource url: 'images/apple-touch-icon.png'
        resource url: 'images/apple-touch-icon-retina.png'
        resource url: 'css/base.css'
        resource url: 'css/errors.css'
        resource url: 'css/login.css'
        resource url: 'css/mobile.css'
        resource url: 'css/application.css'
        resource url: 'js/application.js'
    }

    jqueryUI {
        resource url: 'jquery/jquery-ui/js/jquery-ui-1.8.16.custom.min.js'
        resource url: 'jquery/jquery-ui/css/south-street/jquery-ui-1.8.16.custom.css'
    }

    jqueryTree {
        resource url: 'jquery/dynatree/skin/ui.dynatree.css'
        resource url: 'jquery/dynatree/jquery.dynatree.js'
    }
}
