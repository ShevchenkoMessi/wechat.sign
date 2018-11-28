const app = getApp();
Page({
  data: {
    // text:"这是一个页面"  
    array: ["中国", "美国", "巴西", "日本"],
    toast1Hidden: true,
    modalHidden: true,
    modalHidden2: true,
    notice_str: '',
    index: 0,
  },
  toast1Change: function (e) {
    this.setData({ toast1Hidden: true });
  },
  // navigateToSign:function(){
  //   wx:wx.navigateTo({
  //     url: '/pages/index/index',
  //   })
  // },
  // navigateToSign1: function () {
  //   wx: wx.navigateTo({
  //     url: '/pages/personal_teacher_main/personal_teacher_main',
  //   })
  // },
  navigateToSign2: function () {
    wx: wx.navigateTo({
      url: '/pages/mine/mine',
    })
  },
  //弹出确认框  
  modalTap: function (e) {
    this.setData({
      modalHidden: false
    })
  },
  confirm_one: function (e) {
    console.log(e);
    this.setData({
      modalHidden: true,
      toast1Hidden: false,
      notice_str: '提交成功'
    });
  },
  cancel_one: function (e) {
    console.log(e);
    this.setData({
      modalHidden: true,
      toast1Hidden: false,
      notice_str: '取消成功'
    });
  },
  //弹出提示框  
  modalTap2: function (e) {
    this.setData({
      modalHidden2: false
    })
  },
  modalChange2: function (e) {
    this.setData({
      modalHidden2: true
    })
  },
  bindPickerChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      index: e.detail.value
    })
  },
  onLoad: function (options) {
    // 页面初始化 options为页面跳转所带来的参数  
  },
  onReady: function () {
    // 页面渲染完成  
  },
  onShow: function () {
    // 页面显示  
  },
  onHide: function () {
    // 页面隐藏  
  },
  onUnload: function () {
    // 页面关闭  
  },
  formSubmit: function (e) {
    var that = this;
    var path;
    var formData = e.detail.value;
    console.log(formData.role+"<======>"+(formData.role=="student"));
    if(formData.role=="teacher"){
      path = 'http://localhost:5210/wechat.sign/getTeacherInfo';
	   wx.request({
		  url: path,
		  data: {
			userNo:formData.userNo,
			password:formData.password
		  },
		  header: {
			'Content-Type': 'application/json'
		  },
		  success: function (res) {
        if (res.data == "账号或密码错误") {
          wx.showModal({
            title: '提示',
            content: '账号或密码错误',
          })
        }else{
          app.teacherInfo = res.data[0],
          app.classInfo = res.data[1],
          app.courseInfo = res.data[2]
          wx: wx.navigateTo({
            url: '/pages/personal_teacher_main/personal_teacher_main',
          })
        }
		  },
		})
    }else if(formData.role=="student"){
      path = 'http://localhost:5210/wechat.sign/getStuInfo';
		 wx.request({
		  url: path,
		  data: {
			stuNo: formData.userNo,
			password:formData.password
		  },
		  header: {
			'content-type': 'application/json' // 默认值
		  },
		  success: function (res) {
        if(res.data=="账号或密码错误"){
          wx.showModal({
            title: '提示',
            content: '账号或密码错误',
          })
        }else{
        app.stuInfo = res.data[0];
        app.classInfo = res.data[1];
       wx: wx.navigateTo({
         url: '/pages/index/index',
       })
        }  
		  },
		  fail:function(){
			console.log("请求失败")
		  },
		})
    }else if(formData.role == "register"){
      path = 'http://localhost:5210/wechat.sign/getWorkerInfo';
      wx.request({
        url: path,
        data: {
          workerNo: formData.userNo,
          password: formData.password
        },
        header: {
          'content-type': 'application/json' // 默认值
        },
        success: function (res) {
          if (res.data == "账号或密码错误") {
            wx.showModal({
              title: '提示',
              content: '账号或密码错误',
            })
          } else {
            app.workerInfo = res.data;
            that.setData({
              workerInfo: res.data
            });
            wx: wx.navigateTo({
              url: '/pages/mine/mine',
            })
          }
        },
        fail: function () {
          console.log("请求失败")
        },
      })
    }
    console.log("班级"+app.courseInfo);
  },
  formReset: function () {
    console.log('form发生了reset事件');
    this.modalTap2();
  }
})  