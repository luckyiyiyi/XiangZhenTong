let MerchantAdvdetail_data = [
  {
    Title:'苏州周边，流动补胎，汽修',
    Image:'https://s2.ax1x.com/2019/09/05/nuilVK.jpg',
    Category:'汽车精品',
    Contact:'小张',
    Address:'吴中',
    Text: '流动补胎，汽修！为您服务联系我时，请说是在58同城看到的，谢谢！',
    postId: 0
  },
  {
    Title: '威霆内饰整改 航空座椅门板方向盘真皮包覆',
    Image: 'https://s2.ax1x.com/2019/09/05/nuiJ8H.jpg',
    Category: '座椅包真皮',
    Contact: '胡经理',
    Address: '常熟  - 斜塘镇',
    Text: '20年经验 精湛工艺苏州苏车汇汽车内饰改装工厂，是苏州地区最专业的汽车真皮内饰改装工厂店，商务房车改装厂，服务于苏州各地区众多4S店，房车改装汽车经销商及装潢店。同时，本公司从制版、制作、安装师傅、检验，原材料选购、硬件设施、工作流程等每道工序及岗位严格控制，实施ISO9001：2000质量管理体系，每道工序严格监控，实行专人作业，保证工艺，及房车商务车的高品质要求。匠心之作，服务，品质说明一切。做工，品质，服务，说明一切。​联系我时，请说是在58同城看到的，谢谢！',
    postId: 1
  },
  {
    Title: '补胎，搭火，送油，汽修',
    Image: 'https://s2.ax1x.com/2019/09/05/nuiY2d.jpg',
    Category: '汽车精品',
    Contact: '王老师',
    Address: '苏州周边',
    Text: '补胎，搭火，送油，汽修，24小时服务联系我时，请说是在58同城看到的，谢谢！',
    postId: 2
  }, 
  {
    Title: '专业玻璃贴膜。隔热膜.磨砂膜.安全。建筑膜。',
    Image: 'https://s2.ax1x.com/2019/09/05/nuiBa8.jpg',
    Category: '玻璃贴膜',
    Contact: '方先生',
    Address: '工业园 ',
    Text: '免费上门免贴：玻璃贴膜/防爆膜/隔热膜/磨砂膜/银行防爆膜/淋浴房玻璃防爆膜/办公室贴膜/大厦贴膜/单向透视膜/幕墙贴膜/医院贴膜/学校贴膜 专业承接全国各地大小建筑玻璃贴膜。\n 玻璃贴膜的好处：\n 1、隔紫外线：紫外线中的长波能穿透玻璃，甚至9英尺的水。玻璃贴膜能隔断95%以上的紫外线。大大降低室内因紫外线引起的家具褪色，延长家具，地毯等的使用寿命。当然也能让您在享受大自然阳光的沐浴时不为紫外线所伤害。\n 2、安全与防爆：普通玻璃在贴膜后，其强度将增强4倍以上，大大增强了玻璃的抗冲击能力，即使遇到地震和台风等强力冲击而发生破裂，飞刀般的碎片也不会四下飞溅。而能将玻璃碎片牢牢地粘在膜上，从而不会对人员造成伤害。\n 3、保留隐私：玻璃贴膜具有优越的单向透视性，不像窗帘，不必牺牲你美丽的视野也能保留隐私，还您自由自在的生活空间。\n 4、节省能源，省电：炎热的夏天，不开空调房间的温度可能是34度，但在玻璃窗上安装了玻璃膜的房间可能只有30度，它高达30%-80%的隔热率为您节省大量的电费。而玻璃膜除了隔热效果外，在冬日更可将20~30%的热能反射回屋内，使屋内更温暖舒适。防眩光，保持眼睛舒适：玻璃膜中有金属反射层，在受到强光的照射时，会将部分光线反射，从而保持室内光线的柔和。\n 5、丰富建筑物的色彩：玻璃贴膜有丰富的色彩，可起到装饰建筑物的作用。联系我时，请说是在58同城看到的，谢谢！',
    postId: 3
  },
];

function setDiv(item){
      var div = '<div><div><p class="title">'
  + item.Title
  + '</p></div><div class="contentimg"><img class="img" src="'
  + item.Image
  + '"/></div><div><p class="category">类别：'
  + item.Category
  + '</p></div><div><p class="contact">联系人：'
  + item.Contact
  + '</p></div><div><p class="address">商家地址：'
  + item.Address
  + '</p></div><div><p class="text">'
  + item.Text
  + '</p></div></div><br>'
return div
}
function create(){
    var html='';
    var i=window.sjggposition.sjggposition();
    html+=setDiv(MerchantAdvdetail_data[i]);
    document.getElementById('sjggxx').innerHTML=html;
}
window.onload=create;
