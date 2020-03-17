let benefit_data = [
  {
    content: '1路   5：40  19：30   20分钟一班',
    content2: '佳丽国际婚纱:0516-89672855',
    postId: 0
  },
  {
    content: '2路   5：40  19：00   5分钟一班',
    content2: '沛县金种子酒业:0516-89613829',
    postId: 1
  },
  {
    content: '6路   5：40  19：00   30分钟一班',
    content2: '沛县中粮白酒:18251590006',
    postId: 2
  },
  {
    content: '9路   5：30  19：00   12分钟一班',
    content2: '沛县医明视力矫正中心:13151997778',
    postId: 3
  },
  {
    content: '16路 6：00  19：30   环线',
    content2: '奥特莱斯沛县名品折扣店:15190655565',
    postId: 4
  },
  {
    content: '1路   5：40  19：30   20分钟一班',
    content2: '佳丽国际婚纱:0516-89672855',
    postId: 5
  },
  {
    content: '2路   5：40  19：00   5分钟一班',
    content2: '沛县金种子酒业:0516-89613829',
    postId: 6
  },
  {
    content: '6路   5：40  19：00   30分钟一班',
    content2: '沛县中粮白酒:18251590006',
    postId: 7
  },
  {
    content: '9路   5：30  19：00   12分钟一班',
    content2: '沛县医明视力矫正中心:13151997778',
    postId: 8
  },
  {
    content: '16路 6：00  19：30   环线',
    content2: '奥特莱斯沛县名品折扣店:15190655565',
    postId: 9
  },
  {
    content: '1路   5：40  19：30   20分钟一班',
    content2: '佳丽国际婚纱:0516-89672855',
    postId: 10
  },
  {

    content: '2路   5：40  19：00   5分钟一班',
    content2: '沛县金种子酒业:0516-89613829',
    postId: 11
  },
  {
    content: '6路   5：40  19：00   30分钟一班',
    content2: '沛县中粮白酒:18251590006',
    postId: 12
  },
  {
    content: '9路   5：30  19：00   12分钟一班',
    content2: '沛县医明视力矫正中心:13151997778',
    postId: 13
  },
  {
    content: '16路 6：00  19：30   环线',
    content2: '奥特莱斯沛县名品折扣店:15190655565',
    postId: 14
  },
];
function setDivcheliang(item){
        var div = '<div class="textdiv"><p class="text">'
    + item.content
    + '</p></div>'
return div
}
function setDivdianhua(item){
        var div = '<div class="textdiv"><p class="text">'
    + item.content2
    + '</p></div>'
return div
}
function setDivhuodong(item){
        var div = '<div class="textdiv"><p class="text">'
    + item
    + '</p></div>'
return div
}
function setDivqita(item){
        var div = '<div class="textdiv"><p class="text">'
    + item
    + '</p></div>'
return div
}
function cheliangbiao(){
    var html='';
    for(var i=0;i<benefit_data.length;i++){
        html+=setDivcheliang(benefit_data[i]);
    }
    document.getElementById('c').style.backgroundColor="#4472ca";
    document.getElementById('d').style.backgroundColor="#ebebeb";
    document.getElementById('h').style.backgroundColor="#ebebeb";
    document.getElementById('q').style.backgroundColor="#ebebeb";
    document.getElementById('bmxx').innerHTML=html;
}
function dianhuaben(){
    var htmldh='';
    for(var i=0;i<benefit_data.length;i++){
        htmldh+=setDivdianhua(benefit_data[i]);
    }
    document.getElementById('c').style.backgroundColor="#ebebeb";
    document.getElementById('d').style.backgroundColor="#4472ca";
    document.getElementById('h').style.backgroundColor="#ebebeb";
    document.getElementById('q').style.backgroundColor="#ebebeb";
    document.getElementById('bmxx').innerHTML=htmldh;
}
function huodong(){
    var htmlhd='';
    var huodongcon="暂无活动";
    for(var i=0;i<100;i++){
        htmlhd+=setDivhuodong(huodongcon);
    }
    document.getElementById('c').style.backgroundColor="#ebebeb";
    document.getElementById('d').style.backgroundColor="#ebebeb";
    document.getElementById('h').style.backgroundColor="#4472ca";
    document.getElementById('q').style.backgroundColor="#ebebeb";
    document.getElementById('bmxx').innerHTML=htmlhd;
}
function qita(){
    var htmlqt='';
    var qitacon="暂无其他";
    for(var i=0;i<100;i++){
        htmlqt+=setDivhuodong(qitacon);
    }
    document.getElementById('c').style.backgroundColor="#ebebeb";
    document.getElementById('d').style.backgroundColor="#ebebeb";
    document.getElementById('h').style.backgroundColor="#ebebeb";
    document.getElementById('q').style.backgroundColor="#4472ca";
    document.getElementById('bmxx').innerHTML=htmlqt;
}
window.onload=cheliangbiao;