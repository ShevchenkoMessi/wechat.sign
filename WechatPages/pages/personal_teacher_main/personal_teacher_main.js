// pages/personal_teacher_main/personal_teacher_main.js
  const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    fail:"",
    teacherallInformation:{},
    hasGetInformation:true,
    teacherInformation: {},
    classInformation: {},
    courseInformation: {}
  },
  /**
   * 跳转到使老师得到详细信息的页面
   */
  teacherGetAllInfo:function(){
    wx.navigateTo({
          url: '../courseInfo/courseInfo?gps='+0
        });
    // wx.request({
    //   url: 'http://localhost:5210/wechat.sign/getClassesByCourseNo',
    //   data: {
    //     courseNo: app.courseInfo.courseNo
    //   },
    //   header: {
    //     'content-type': 'application/json' // 默认值
    //   },
    //   success: function (res) {
    //     console.log(res.data)
    //     var courseInfo = JSON.stringify(res.data);
    //     wx.navigateTo({
    //       url: '../courseInfo/courseInfo?courseInfo=' + courseInfo,
    //     });
    //   },
    //   fail: function () {
    //     console.log("请求失败")
    //   }
    // })
    
  },
  /**
  * 跳转到发布GPS的页面
  */
  publishPosition: function () {
    wx.navigateTo({
      url: '../courseInfo/courseInfo?gps=' + 1,
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function () {
    var that = this
    wx.getUserInfo({
      success: function (res) {
        console.log(res)
        that.setData({
          hasGetInformation: false,
          teacherAllInformation: res.userInfo
        })
      },
      fail: function () {
        console.log("获得信息失败")
        that.setData({
          fail: "获得信息失败"
        })
      }
    })
  },
  /**
   * 获取当前用户的信息
   */
  getInfomationFromActiveUser:function(){

  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    this.setData({
      teacherInformation: app.teacherInfo,
      classInformation:app.classInfo,
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})