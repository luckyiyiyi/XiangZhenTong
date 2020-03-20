let welfaredetail_data = [
  {
    welfareimage: 'https://s2.ax1x.com/2019/09/05/nui4aT.png',
    url:'http://vod.cntv.lxdns.com/flash/mp4video62/TMS/2019/05/24/f42984f4041ba4329d99f95e9800871b_450_h264_418_aac_32.mp4',
    title:'老英雄张富清',
    detail:'老英雄张富清60多年深藏功名，一辈子坚守初心、不改本色，事迹感人。在部队，他保家卫国；到地方，他为民造福。他用自己的朴实纯粹、淡泊名利书写了精彩人生，是广大部队官兵和退役军人学习的榜样。要积极弘扬奉献精神，凝聚起万众一心奋斗新时代的强大力量。',
    postId: 0,
  },
  {
    welfareimage: 'https://s2.ax1x.com/2019/09/05/nuioiF.png',
    url: 'http://vod.cntv.lxdns.com/flash/mp4video62/TMS/2018/04/09/99d9f80b300e1dd31ab251e572fdfc75_450_h264_418_aac_32.mp4',
    title: '塞罕坝精神公益广告——《信念篇》',
    detail: '一代代人接续奋斗，离不开精神的力量。“全党全社会要坚持绿色发展理念，弘扬塞罕坝精神，持之以恒推进生态文明建设”，习近平总书记日前作出重要指示，充分肯定了河北塞罕坝林场建设者的感人事迹，高度概括了牢记使命、艰苦创业、绿色发展的塞罕坝精神，向全党全社会发出了把我们伟大的祖国建设得更加美丽的伟大号召，鼓舞和激励全党全国人民为推进绿色发展、建设生态文明而不懈奋斗。',
    postId: 1,
  },
  {
    welfareimage: 'https://s2.ax1x.com/2019/09/05/nuijZ6.png',
    url: 'http://vod.cntv.lxdns.com/flash/mp4video62/TMS/2018/04/03/afd59334838a7be9f7b8135638375eae_450_h264_418_aac_32.mp4',
    title: '修葺自己的心灵 ——陈数读书篇',
    detail: '央视读书公益广告《陈数篇》，取景于“世界上最孤独的图书馆”。片中表达了陈数与书中人心灵相通，读书，成为她人生中最幸福的一部分。海边图书馆，象征着一颗安静的心，让人可以站在一个角落去面对全世界。影片风格抽象唯美，颇有后现代意味。',
    postId: 2,
  },
  {
    welfareimage: 'https://s2.ax1x.com/2019/09/05/nuixIO.png',
    url: 'http://vod.cntv.lxdns.com/flash/mp4video62/TMS/2018/03/22/ca9bc16118184bf9bf255148cba9ee14_450_h264_418_aac_32.mp4',
    title: '用好每滴水 生活会更美',
    detail: '如果不珍惜水,世界上的最后一滴水就会是人类的眼泪,节约用水, 利在当代, 功在千秋',
    postId: 3,
  },
  {
    welfareimage: 'https://s2.ax1x.com/2019/09/05/nuF9RH.png',
    url: 'http://cntv.vod.cdn.myqcloud.com/flash/mp4video61/TMS/2017/08/21/6842cca134fdab668d271083d8199a16_h264418000nero_aac32.mp4',
    title: '纪念黄大年同志',
    detail: '黄大年，男，广西南宁市人，1958年8月生，汉族。2009年12月，黄大年放弃了在英国优厚的待遇，怀着一腔爱国热情返回祖国，出任吉林大学地球探测科学与技术学院教授。八年时间，他带领团队在航空地球物理领域取得一系列成就。2017年1月8日，黄大年因病逝世，享年58岁。',
    postId: 4,
  },
  {
    welfareimage: 'https://s2.ax1x.com/2019/09/05/nuFiQA.png',
    url: 'http://vod.cntv.lxdns.com/flash/mp4video62/TMS/2017/09/18/d1ee24e906ef0a7421e1633434fc8320_h264418000nero_aac32.mp4',
    title: '撸起袖子 加油干',
    detail: '“撸起袖子加油干”出自习近平2017年新年贺词。“撸起袖子加油干”，是时代赋予我们这一代人的使命，更是我们向未来作出的承诺。2017年2月3日，吉林省委、省政府召开全省“抓环境、抓项目、抓落实”大会。省委书记巴音朝鲁在会上强调，全省上下要迅速行动起来，迅速进入工作状态，迅速掀起真抓实干的热潮，抓环境、抓项目、抓落实，撸起袖子加油干，加快推进吉林老工业基地全面振兴。',
    postId: 5,
  }
];

function setDiv(item){
  var div = '<div><div class="bar"></div><div class="gyggtitlediv"><p class="gyggtitle">'
  + item.title
  + '</p></div><div class="gyggdetaildiv"><p class="gyggdetail">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp简介：'
  + item.detail
  + '</p></div></div><br>'
return div
}
function create(){
    var html='';
    var i=window.gyggposition.gyggposition();
    html+=setDiv(welfaredetail_data[i]);
    document.getElementById('gyggxx').innerHTML=html;
}
window.onload=create;
