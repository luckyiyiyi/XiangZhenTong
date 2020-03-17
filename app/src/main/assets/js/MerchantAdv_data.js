let MerchantAdv_data = [
  {
    Title:'苏州周边，流动补胎，汽修',
    Image:'https://s2.ax1x.com/2019/09/05/nuilVK.jpg',
    postId: 0
  },
  {
    Title: '威霆内饰整改 航空座椅门板方向盘真皮包覆',
    Image: 'https://s2.ax1x.com/2019/09/05/nuiJ8H.jpg',
    postId: 1
  },
  {
    Title: '补胎，搭火，送油，汽修',
    Image: 'https://s2.ax1x.com/2019/09/05/nuiY2d.jpg',
    postId: 2
  },
  {
    Title: '专业玻璃贴膜。隔热膜.磨砂膜.安全。建筑膜。',
    Image: 'https://s2.ax1x.com/2019/09/05/nuiBa8.jpg',
    postId: 3
  },
];
function setDiv(item){
        var div = '<div class="yuanjiao"><div><p class="sjggtitle">'
    + item.Title
    + '</p></div><div class="sjggimgdiv"><img class="sjggimg" src="'
    + item.Image
    + '"/></div></div><br>'
return div
}
function creatediv(){
    var html='';
    for(var i=0;i<MerchantAdv_data.length;i++){
        html+=setDiv(MerchantAdv_data[i]);
    }
    document.getElementById('sjggl').innerHTML=html;
    divnum(MerchantAdv_data)
}
function divnum(MerchantAdv_data){
    var MerchantAdv_data = MerchantAdv_data;
    var divarry = document.getElementsByClassName('yuanjiao');
    for(var i=0;i<divarry.length;i++){
        divarry[i].onclick=(function close(j){
            return function(){
                window.sjgg.intenttosjggxx(MerchantAdv_data[j].postId);
            }
        })(i);
    }
}
window.onload=creatediv;