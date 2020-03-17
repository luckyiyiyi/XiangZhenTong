let work_data = [
  {
    workTitle: '苏州海底捞服务员4千起',
    workMoney: '4000-8000元',
    workPostion: '服务员',
    postId: 0
  },
  {
    workTitle: '越溪站高薪招送餐员+7千',
    workMoney: '5000-9000元/月',
    workPostion: '送餐员',
    postId: 1
  },
  {
    workTitle: '要德火锅招切配包食宿',
    workMoney: '3500-4500元/月',
    workPostion: '后厨',
    postId: 2
  },
  {
    workTitle: '游戏操作员包吃住',
    workMoney: '5000-8000元/月',
    workPostion: '游戏操作员',
    postId: 3
  },
  {
    workTitle: '招聘产线文员',
    workMoney: '4501-5001元/月',
    workPostion: '文员',
    postId: 4
  },
  {
    workTitle: '网页设计/制作助理',
    workMoney: '4000-7000元/月',
    workPostion: '设计助理',
    postId: 5
  },
  {
    workTitle: '万宝店麦果优品诚招收银员',
    workMoney: '3000-5000元/月',
    workPostion: '收银员',
    postId: 6
  },
  {
    workTitle: '青剑湖电信营业员',
    workMoney: '3000-5000元/月',
    workPostion: '营业员',
    postId: 7
  },
];
function setDiv(item){
        var div = '<div class="yuanjiao"><div class="neirong"><div class="grjztitlediv"><p class="grjztitle">'
    + item.workTitle
    + '</p></div><div class="moneypositiondiv"><div class="workmoneydiv"><p class="workmoneycontent">'
    + item.workMoney
    + '</p></div><div class="workPostiondiv"><p class="workPostioncontent">'
    + item.workPostion
    + '</p></div></div></div><div class="shen"><p class="shenzi">申</p></div></div><div class="bar"></div>'
return div
}
function creatediv(){
    var html='';
    for(var i=0;i<work_data.length;i++){
        html+=setDiv(work_data[i]);
    }
    document.getElementById('grjzl').innerHTML=html;
    divnum(work_data)
}
function divnum(work_data){
    var work_data = work_data;
    var divarry = document.getElementsByClassName('yuanjiao');
    for(var i=0;i<divarry.length;i++){
        divarry[i].onclick=(function close(j){
            return function(){
                window.grjz.intenttogrjzxx(work_data[j].postId);
            }
        })(i);
    }
}
window.onload=creatediv;