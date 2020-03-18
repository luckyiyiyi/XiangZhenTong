let welfare_data = [
  {
    welfareimage:'https://s2.ax1x.com/2019/09/05/nui4aT.png',
    welfaretitle:'老英雄张富清',
    postId: 0,
  },
  {
    welfareimage: 'https://s2.ax1x.com/2019/09/05/nuioiF.png',
    welfaretitle: '塞罕坝精神公益广告——《信念篇》',
    postId: 1,
  },
  {
    welfareimage: 'https://s2.ax1x.com/2019/09/05/nuijZ6.png',
    welfaretitle: '修葺自己的心灵 ——陈数读书篇',
    postId: 2,
  },
  {
    welfareimage: 'https://s2.ax1x.com/2019/09/05/nuixIO.png',
    welfaretitle: '用好每滴水 生活会更美',
    postId: 3,
  },
  {
    welfareimage: 'https://s2.ax1x.com/2019/09/05/nuF9RH.png',
    welfaretitle: '纪念黄大年同志',
    postId: 4,
  },
  {
    welfareimage: 'https://s2.ax1x.com/2019/09/05/nuFiQA.png',
    welfaretitle: '撸起袖子 加油干',
    postId: 5,
  },
];
function setDiv(item){
        var div = '<div class="yuanjiao"><div><p class="gyggtitle">'
    + item.welfaretitle
    + '</p></div><div class="gyggimgdiv"><img class="gyggimg" src="'
    + item.welfareimage
    + '"/></div></div>'
return div
}
function creatediv(){
    var html='';
    for(var i=0;i<welfare_data.length;i++){
        html+=setDiv(welfare_data[i]);
    }
    document.getElementById('gyggl').innerHTML=html;
    divnum(welfare_data)
}
function divnum(welfare_data){
    var welfare_data = welfare_data;
    var divarry = document.getElementsByClassName('yuanjiao');
    for(var i=0;i<divarry.length;i++){
        divarry[i].onclick=(function close(j){
            return function(){
                window.gygg.intenttogyggxx(welfare_data[j].postId);
            }
        })(i);
    }
}
window.onload=creatediv;