let public_data = [

  {
    publicTitle: '生产安全事故应急条例',
    publicText: '生产安全事故应急条例 第一章　总则 第一条　为了规范生产安全....',
    image: 'https://s2.ax1x.com/2019/09/05/nuiPbV.png',
    postId: 0
  },
  {

    publicTitle: '《中国共产党机构编制工作条例》',
    publicText: '北京8月15日,中央印发了《中国共产党机构编制工作条例》....',
    image: 'https://s2.ax1x.com/2019/09/05/nuikUU.png',
    postId: 1
  },
  {

    publicTitle: '国务院关于实施健康中国行动的意见',
    publicText: '人民健康是民族昌盛和国家富强的重要标志，预防是最经济最....',
    image: 'https://s2.ax1x.com/2019/09/05/nuiA5F.png',
    postId: 2
  },
  {

    publicTitle: '关于加强非洲猪瘟防控工作的意见',
    publicText: '党中央、国务院高度重视非洲猪瘟防控工作。2018年8月非洲....',
    image: 'https://s2.ax1x.com/2019/09/05/nuiVC4.png',
    postId: 3
  },
  {

    publicTitle: '关于促进乡村产业振兴的指导意见',
    publicText: '产业兴旺是乡村振兴的重要基础，是解决农村一切问题的前提....',
    image: 'https://s2.ax1x.com/2019/09/05/nuiZ8J.png',
    postId: 4
  },


];
function setDiv(item){
        var div = '<div class="yuanjiao"><div><p class="wenzitop" >'
    + item.publicTitle
    + '</p></div><div><div class="wenzicontentb"><p class="wenzicontent">'
    + item.publicText
    + '</p></div><div class="contentimg"><img class="contentimgtu" src="'
    + item.image
    + '"/></div></div></div><br>'
return div
}
function creatediv(){
    var html='';
    for(var i=0;i<public_data.length;i++){
        html+=setDiv(public_data[i]);
    }
    document.getElementById('zfzcl').innerHTML=html;
    divnum(public_data)
}
function divnum(public_data){
    var public_data = public_data;
    var divarry = document.getElementsByClassName('yuanjiao');
    for(var i=0;i<divarry.length;i++){
        divarry[i].onclick=(function close(j){
            return function(){
                window.zfzc.intenttozfzcxx(public_data[j].postId);
            }
        })(i);
    }
}
window.onload=creatediv;