/* Dynamic top menu positioning
 *
 */

var num = 50; //number of pixels before modifying styles

$(window).bind('scroll', function () {
    if ($(window).scrollTop() > num) {
        $('.contain-to-grid').addClass('fixed');
    } else {
        $('.contain-to-grid').removeClass('fixed');
    }
});

//USE SCROLL WHEEL FOR THIS FIDDLE DEMO





$(document).foundation();

// below does the "Programs" info switch
$('.is-hover a').on('mouseover', function () {
  var idx = $(this).parent().index() + 2;
  $('.info:nth-child(' + idx + ')').addClass('info-visible');
  $('.info:nth-child(' + idx + ')').siblings().removeClass('info-visible');
});

$('.dropdown').on('mouseout', function () {
  $('.info:nth-child(1)').addClass('info-visible').siblings().removeClass('info-visible');
});


