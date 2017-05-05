/*$(document).ready(function(){
  $(".headingTitle").click(function(){
    alert("Please Fill the form");
    $(this).css("cursor","pointer");

    //  int valueOfWindow=$(window).height;
      console.log("hello");
      
  });
});

$(function() {
    $( document ).tooltip();
});*/

function getHeight(){
    var values=$(window).height();
    return values;
}

$(document).ready(function(){
    var myHeight=getHeight();
    var color=30;
    $(".container").css("height",myHeight);
    console.log(myHeight);
});                         