// pages/teacher_get_allInfo/teacher_get_allInfo.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    sasddf: 123,
    gps:false
  },
  /**
   *获取wmxl上的信息并处理
   */
  formSubmit: function (e) {
    console.log('form发生了submit事件，携带数据为：', e.detail.value);
    var e=e
    if (e.detail.value.gps=="0"){
        wx.request({
          url: 'http://localhost:5210/wechat.sign/getClassesByCourseNo',
        data: {
          courseNo: e.detail.value.courseNo
        },
        header: {
          'content-type': 'application/json' // 默认值
        },
        success: function (res) {
          console.log(res.data)
          var classInfo = JSON.stringify(res.data);
          wx.navigateTo({
            url: '../teacher_get_allInfo/teacher_get_allInfo?classInfo=' + classInfo + '&courseNo=' + e.detail.value.courseNo
          });
        },
        fail: function () {
          console.log("请求失败")
        }
      })
    } else if (e.detail.value.gps=="1"){
      wx.navigateTo({
        url: '../teacher_GPS/teacher_GPS?courseNo=' + e.detail.value.courseNo
    })
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.gps=="0")
    console.log(options.gps=="1")
    if(options.gps=="0"){
      this.setData({
        courseInfo:app.courseInfo,
        gps:false
      })
    } else if (options.gps == "1"){
      this.setData({
        courseInfo:app.courseInfo,
        gps:true
      })
    }
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