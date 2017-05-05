$(document).ready(function(){
    $(".button").mouseover(function(){
        $(this).addClass("btn-success");
    });
    $(".button").mouseleave(function(){
        $(this).removeClass("btn-success");
    });
    
});