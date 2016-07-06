$(document).ready(function() {

	if ( $('#carousel').length >0 ) {
		$('.flexslider_t').flexslider({
			animation: "slide",
			controlNav: "thumbnails"
		});

		$('#carousel').flexslider({
			animation: "slide",
			controlNav: false,
			animationLoop: false,
			slideshow: false,
			itemWidth: 100,
			itemMargin: 0,
			asNavFor: '#slider'
		});
		 
		$('#slider').flexslider({
			animation: "slide",
		  smoothHeight: false,
			controlNav: false,
			animationLoop: false,
			slideshow: false,
			sync: "#carousel"
		});

	}
	else { 
		$('.flexslider').flexslider({
    animation: "slide",
		useCSS: false,
		smoothHeight: false,
		start: function() {
            slides_loaded();
        }
  	});
	}
	
	if ( use_tinyscroller() ) {
		$('#scrollbar1').tinyscrollbar({invertscroll: true});
	}
	else {
		set_scroller_height();
	}
	
	// legacy gazette page
	$('.gazette_list').hide();
	$('#yr2006').show();
	
	$('#gz_choose_year a').click(function(){
			var yr = $(this).text();								  
			$('.gazette_list').fadeOut();
			$('#yr'+yr).fadeIn();
		});  

	$('#nav-open-btn').click(function(){
		  $('#nav-open-btn').hide();
		  //$('#nav-open-btn').removeAttr('style');
			$('#nav-close-btn').show();
	    $('.left-nav').show();
			
			var touchEvents = 'ontouchstart' in document.documentElement;
			if ( touchEvents ) {
				//setTimeout(function() { window.scrollTo(0, 1); }, 0);
				$("body").addClass("nooverflow");
			}
			
			if ( use_tinyscroller() ) {
				$('#scrollbar1').tinyscrollbar({invertscroll: true});
			}
			else {
				set_scroller_height();
			}
			
			_gaq.push(['_trackEvent','nav_menu','click','open']);
		});
	$('#nav-close-btn').click(function(){
		  $('#nav-close-btn').hide();
		  //$('#nav-close-btn').removeAttr('style');
			$('#nav-open-btn').show();
		  $('.left-nav').hide();
	    $('.left-nav').removeAttr('style');
			$("body").removeClass("nooverflow");
			_gaq.push(['_trackEvent','nav_menu','click','close']);
		});
	
	$('html').click(function() {
		if ( $('.left-nav').is(":visible") && $('#nav-close-btn').is(":visible") ) {
		  $('#nav-close-btn').hide();
		  //$('#nav-close-btn').removeAttr('style');
			$('#nav-open-btn').show();
			$('.left-nav').hide();
			$("body").removeClass("nooverflow");
			$('.left-nav').removeAttr('style');
		}
	});

	$('.left-nav, #nav-open-btn').click(function (e){
	    e.stopPropagation();
	});

	//check note-body content. only display "show more" when its content is overflow.
	$('a.show-more').each( function() {
			var notes = $(this).parent().parent().find(".photo-description");
			var note = notes[0];
			if ( notes.height()+1 >= note.scrollHeight ) { //Some browser has scrollHeight bigger that height by 1 even though there is no overflow.
				$(this).parent().hide();
			}
	});
	
	$('a.show-more').click(function(e) {
			var notes = $(this).parent().parent().find(".photo-description");
			if ( $(this).hasClass('show-more') ) {
				var note = notes[0];
				var h = note.scrollHeight;
				notes.animate({
						'height': h
				});
				$(this).removeClass( 'show-more' );
				$(this).addClass( 'show-less' );
				$(this).html("Show Less");
			}
			else {
				notes.animate({
					'height': '65px'
				});
				$(this).removeClass( 'show-less' );
				$(this).addClass( 'show-more' );
				$(this).html("Show More");
			}
			
			e.preventDefault();
	});


});

function getInternetExplorerVersion() {
    var rv = -1; // Return value assumes failure.
    if (navigator.appName == 'Microsoft Internet Explorer') {
        var ua = navigator.userAgent;
        var re = new RegExp("Trident/([0-9]{1,}[\.0-9]{0,})");
        if (re.exec(ua) != null)
            rv = parseFloat(RegExp.$1);
				
				if ( rv==3 ) {
					rv=7; //IE 7
				}
				else if ( rv==4 ) {
					rv=8; //IE 8
				}
				else if ( rv==5 ) {
					rv=9; //IE 9
				}
				else if ( rv==6 ) {
					rv=10; //IE 10
				}
    }
    return rv;
}

function use_tinyscroller() {
	var touchEvents = 'ontouchstart' in document.documentElement;
	//var iOS = /(iPad|iPhone|iPod)/g.test(navigator.userAgent);
	//if ( !touchEvents || iOS ) {
	if ( !touchEvents ) {
		return true;  //Non-touch OS 
	}
	else {
		return false; //Android based
	}
}

function set_scroller_height() {
	$_viewport = $(".viewport");
	var windowHeight = $(window).height();
	var viewportOffset = $_viewport.offset().top;
	var viewportPosition = $_viewport.position().top;
	if (window.matchMedia !== "undefined" && window.matchMedia("(min-width: 1000px)").matches) {
		$_viewport.height(windowHeight - viewportPosition);
	} else {
		$_viewport.height(windowHeight - viewportOffset);
	}
	$_viewport.removeAttr('style');
	$_viewport.attr('style', 'overflow:auto');
	$("#scrollbar1 .scrollbar").hide();
}

function viewport() {
    var e = window, a = 'inner';
    if (!('innerWidth' in window )) {
        a = 'client';
        e = document.documentElement || document.body;
    }
    return { width : e[ a+'Width' ] , height : e[ a+'Height' ] };
}
