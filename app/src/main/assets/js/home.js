function setDiv(item){
        var div = '<div><p>'
    + item
    + '</p><br></div>'
return div
}
function creatediv(){
    var html='';
    var i=window.home.home();
    var s=i.split(" ");
    for(var j=0;j<s.length;j++){
        html+=setDiv(s[j]);
    }
    document.getElementById('homediv').innerHTML=html;
}
window.onload=creatediv;