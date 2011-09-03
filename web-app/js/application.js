if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}

function navBarClickHandler(event) {
	$(".navBar a").removeClass("selected");
	$(event.target).addClass("selected");
}

function addNavBarListeners() {
	$(".navBar a").click(navBarClickHandler);
	$(".navBar a:first-child").click();
}

function setup() {
	addNavBarListeners();
}

$(document).ready(setup)