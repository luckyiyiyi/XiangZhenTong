function setDiv(item){
        var div = '<div><p>'
    + item
    + '</p></div>'
return div
}
function creatediv(){
    var html='';
    var i=window.home.home();
    html+=setDiv(i);
    document.getElementById('homediv').innerHTML=html;
}
window.onload=creatediv;