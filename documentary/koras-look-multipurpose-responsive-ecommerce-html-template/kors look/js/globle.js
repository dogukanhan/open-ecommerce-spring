$(document).ready(function(){
   $('.sidebar-title').on('click', function(){
			$(this).toggleClass('active').parent().find('.title-toggle').stop().slideToggle('medium');
		})
		
});
$(document).ready(function() {     
      var time = 5; // time in seconds     
	  var $progressBar,
	      $bar, 
          $elem, 
          isPause, 
          tick,
          percentTime;
        //Init the carousel
        $("#main-slider").owlCarousel({
          slideSpeed : 500,
          paginationSpeed : 500,
          singleItem : true,
          afterInit : progressBar,
          afterMove : moved,
          startDragging : pauseOnDragging
        });
     
        //Init progressBar where elem is $("#owl-demo")
        function progressBar(elem){
          $elem = elem;
          //build progress bar elements
          buildProgressBar();
          //start counting
          start();
        }
     
        //create div#progressBar and div#bar then prepend to $("#owl-demo")
        function buildProgressBar(){
          $progressBar = $("<div>",{
            id:"progressBar"
          });
          $bar = $("<div>",{
            id:"bar"
          });
          $progressBar.append($bar).prependTo($elem);
        }
     
        function start() {
          //reset timer
          percentTime = 0;
          isPause = false;
          //run interval every 0.01 second
          tick = setInterval(interval, 10);
        };
     
        function interval() {
          if(isPause === false){
            percentTime += 1 / time;
            $bar.css({
               width: percentTime+"%"
             });
            //if percentTime is equal or greater than 100
            if(percentTime >= 100){
              //slide to next item 
              $elem.trigger('owl.next')
            }
          }
        }
     
        //pause while dragging 
        function pauseOnDragging(){
          isPause = true;
        }
     
        //moved callback
        function moved(){
          //clear interval
          clearTimeout(tick);
          //start again
          start();
        }
     
        //uncomment this to make pause on mouseover 
        // $elem.on('mouseover',function(){
        //   isPause = true;
        // })
        // $elem.on('mouseout',function(){
        //   isPause = false;
        // })
     
    });




	
    $(document).ready(function() {
     
      var owl = $("#fashion-product");
     
      owl.owlCarousel({
          items : 7, //10 items above 1000px browser width
          itemsDesktop : [1000,5], //5 items between 1000px and 901px
          itemsDesktopSmall : [900,3], // betweem 900px and 601px
          itemsTablet: [600,2], //2 items between 600 and 0
          itemsMobile : false, // itemsMobile disabled - inherit from itemsTablet option
		  pagination: false,
      autoPlay:true,
      });
     
      // Custom Navigation Events
      $(".product_next").click(function(){
        owl.trigger('owl.next');
      })
      $(".product_prev").click(function(){
        owl.trigger('owl.prev');
      })
      $(".product_play").click(function(){
        owl.trigger('owl.play',1000); //owl.play event accept autoPlay speed as second parameter
      })
      $(".product_stop").click(function(){
        owl.trigger('owl.stop');
      })
     
    });

/* feature product */
    $(document).ready(function() {
    var owl = $("#featured-products");
    owl.owlCarousel({
          items : 4, //10 items above 1000px browser width
          itemsDesktop : [1000,4], //5 items between 1000px and 901px
          itemsDesktopSmall : [900,2], // betweem 900px and 601px
          itemsTablet: [600,1], //2 items between 600 and 0
          itemsMobile : false, // itemsMobile disabled - inherit from itemsTablet option
		  pagination: false
      });
       // Custom Navigation Events
      $(".featured_next").click(function(){
        owl.trigger('owl.next');
      })
      $(".featured_prev").click(function(){
        owl.trigger('owl.prev');
      })    
    });

/* feature product */
/* Latest News */
    $(document).ready(function() {
      var owl = $("#Latest-News");
      owl.owlCarousel({
          items : 3, //10 items above 1000px browser width
          itemsDesktop : [1000,2], //5 items between 1000px and 901px
          itemsDesktopSmall : [900,2], // betweem 900px and 601px
          itemsTablet: [600,1], //2 items between 600 and 0
          itemsMobile : false, // itemsMobile disabled - inherit from itemsTablet option
		   pagination: false
      });
      // Custom Navigation Events
      $(".Latest_next").click(function(){
        owl.trigger('owl.next');
      })
      $(".Latest_prev").click(function(){
        owl.trigger('owl.prev');
      })
    });
/* feature product */
$(document).ready(function() {
  var owl = $("#special"),
      status = $("#owlStatus");
  owl.owlCarousel({
	items : 1,
	itemsDesktop : [1000,1], //5 items between 1000px and 901px
    itemsDesktopSmall : [900,1], // betweem 900px and 601px
    itemsTablet: [600,1], //2 items between 600 and 0
    itemsMobile : false ,// itemsMobile disabled - inherit from itemsTablet option
    afterAction : afterAction,
	 pagination: false
  });
  function updateResult(pos,value){
    status.find(pos).find(".result").text(value);
  }
  function afterAction(){
    updateResult(".currentItem", this.owl.currentItem + 1);
    updateResult(".owlItems", this.owl.owlItems.length);
  }
        // Custom Navigation Events
      $(".special_next").click(function(){
        owl.trigger('owl.next');
      })
      $(".special_prev").click(function(){
        owl.trigger('owl.prev');
      })
  });
  /* brand logo */
    $(document).ready(function() {
      var owl = $("#brand-logo");
      owl.owlCarousel({
          items : 5, //10 items above 1000px browser width
          itemsDesktop : [1000,3], //5 items between 1000px and 901px
          itemsDesktopSmall : [900,2], // betweem 900px and 601px
          itemsTablet: [600,1], //2 items between 600 and 0
          itemsMobile : false, // itemsMobile disabled - inherit from itemsTablet option
		   pagination: false
      });
      // Custom Navigation Events
      $(".brand_next").click(function(){
        owl.trigger('owl.next');
      })
      $(".brand_prev").click(function(){
        owl.trigger('owl.prev');
      })
    });
/*
/* brand logo */
    $(document).ready(function() {
      var owl = $("#product-detail-view");
      owl.owlCarousel({
          items : 5, //10 items above 1000px browser width
          itemsDesktop : [1000,5], //5 items between 1000px and 901px
          itemsDesktopSmall : [900,5], // betweem 900px and 601px
          itemsTablet: [600,5], //2 items between 600 and 0
          itemsMobile : false, // itemsMobile disabled - inherit from itemsTablet option
		   pagination: false
      });
     
      // Custom Navigation Events
      $(".product_info_next").click(function(){
        owl.trigger('owl.next');
      })
      $(".product_info_prev").click(function(){
        owl.trigger('owl.prev');
      })
    });
  
/* feature product */
    $(document).ready(function() {
      var owl = $("#related-products");
      owl.owlCarousel({
          items : 3, //10 items above 1000px browser width
          itemsDesktop : [1000,3], //5 items between 1000px and 901px
          itemsDesktopSmall : [900,2], // betweem 900px and 601px
          itemsTablet: [600,1], //2 items between 600 and 0
          itemsMobile : false, // itemsMobile disabled - inherit from itemsTablet option
		  pagination: false
      });
      // Custom Navigation Events
      $(".related_next").click(function(){
        owl.trigger('owl.next');
      })
      $(".related_prev").click(function(){
        owl.trigger('owl.prev');
      })
    });

/* feature product */
  
  
function newinFurther(status){
	if ($(document).width()<=479)
	{
		$('.new-further p').on('click', function(){
			$(this).toggleClass('active').parent().find('.toggle-newinFurther').stop().slideToggle('medium');
		})
		$('.new-further').addClass('accordion').find('.toggle-newinFurther').slideUp('fast');
		}
		else if($(document).width() >= 480)
	{
		$('.new-further p').removeClass('active').off().parent().find('.toggle-newinFurther').removeAttr('style').slideDown('fast');
		$('.new-further').removeClass('accordion');
	}
	}
$(document).ready(function(){newinFurther();});
$(window).resize(function(){newinFurther();});


function accordionFooter(status){

	if ($(document).width() <= 991)
	{
		$('#footer h4').on('click', function(){
			$(this).toggleClass('active').parent().find('.toggle-footer').stop().slideToggle('medium');
		})
		$('#footer').addClass('accordion').find('.toggle-footer').slideUp('fast');
	}
	else if($(document).width() >= 992)
	{
		$('#footer h4').removeClass('active').off().parent().find('.toggle-footer').removeAttr('style').slideDown('fast');
		$('#footer').removeClass('accordion');
	}
}
$(document).ready(function(){accordionFooter();});
$(window).resize(function(){accordionFooter();});



    