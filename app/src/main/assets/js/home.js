let home_data = [
  {
    i:'https://s2.ax1x.com/2019/09/05/nui4aT.png',
    t:'老英雄张富清',
    postId: 0,
    id:10,
  },
  {
    i: 'https://s2.ax1x.com/2019/09/05/nuioiF.png',
    t: '塞罕坝精神公益广告——《信念篇》',
    postId: 1,
    id:11,
  },
  {
    i: 'https://s2.ax1x.com/2019/09/05/nuijZ6.png',
    t: '修葺自己的心灵 ——陈数读书篇',
    postId: 2,
    id:12,
  },
  {
    i: 'https://s2.ax1x.com/2019/09/05/nuixIO.png',
    t: '用好每滴水 生活会更美',
    postId: 3,
    id:13,
  },
  {
    i: 'https://s2.ax1x.com/2019/09/05/nuF9RH.png',
    t: '纪念黄大年同志',
    postId: 4,
    id:14,
  },
  {
    i: 'https://s2.ax1x.com/2019/09/05/nuFiQA.png',
    t: '撸起袖子 加油干',
    postId: 5,
    id:15,
  },
  {
    i:'https://s2.ax1x.com/2019/09/05/nuilVK.jpg',
    t:'苏州周边，流动补胎，汽修',
    postId: 0,
    id:20,
  },
  {
    i: 'https://s2.ax1x.com/2019/09/05/nuiJ8H.jpg',
    t: '威霆内饰整改 航空座椅门板方向盘真皮包覆',
    postId: 1,
    id:21,
  },
  {
    i: 'https://s2.ax1x.com/2019/09/05/nuiY2d.jpg',
    t: '补胎，搭火，送油，汽修',
    postId: 2,
    id:22,
  },
  {
    i: 'https://s2.ax1x.com/2019/09/05/nuiBa8.jpg',
    t: '专业玻璃贴膜。隔热膜.磨砂膜.安全。建筑膜。',
    postId: 3,
    id:23,
  },
  {
    i: 'https://s2.ax1x.com/2019/09/05/nuiPbV.png',
    t: '生产安全事故应急条例',
    postId: 0,
    id:30,
  },
  {
    i: 'https://s2.ax1x.com/2019/09/05/nuikUU.png',
    t: '《中国共产党机构编制工作条例》',
    postId: 1,
    id:31,
  },
  {
    i: 'https://s2.ax1x.com/2019/09/05/nuiA5F.png',
    t: '国务院关于实施健康中国行动的意见',
    postId: 2,
    id:32,
  },
  {
    i: 'https://s2.ax1x.com/2019/09/05/nuiVC4.png',
    t: '关于加强非洲猪瘟防控工作的意见',
    postId: 3,
    id:33,
  },
  {
    i: 'https://s2.ax1x.com/2019/09/05/nuiZ8J.png',
    t: '关于促进乡村产业振兴的指导意见',
    postId: 4,
    id:34,
  },
];
function setDiv(item){
        var div = '<div class="homebar"></div><div class="yuanjiao"><div class="homeimg"><img class="img" src="'
    + item.i
    + '" /></div><div class="homeright"><div class="hometxt"><p class="title">'
    + item.t
    + '</p></div><div class="xxyddiv"><p class="xxyd">详细阅读</p></div></div></div>'
return div
}
function creatediv(){
    var html='';
    var i=window.home.home();
    var s=i.split(" ");
    for(var j=0;j<s.length;j++){
        var po=s[j];
        html+=setDiv(home_data[po]);
    }
    document.getElementById('homediv').innerHTML=html;
    divnum(s)
}
function divnum(s){
    var divarry = document.getElementsByClassName('yuanjiao');
    for(var i=0;i<divarry.length;i++){
        divarry[i].onclick=(function close(j){
            return function(){
            var p = s[j];
            window.hometxx.hometxx(home_data[p].id);
            }
        })(i);
    }
}
window.onload=creatediv;