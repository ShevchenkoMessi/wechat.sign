// pages/teacher_get_allInfo/teacher_get_allInfo.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    sasddf:123,
  },
/**
 *获取wmxl上的信息并处理
 */
  formSubmit: function (e) {
    var that = this
    console.log('form发生了submit事件，携带数据为：', e.detail.value.classID)
    wx.navigateTo({
      url: '../teacher_check/teacher_check?classInformation=' + JSON.stringify(this.data.classInformation[e.detail.value.classID]) + '&index=' + e.detail.value.classID + '&courseNo=' + this.data.courseNo
    })
  },
// /**
//  * 
//  */
//   testAAA:function(){
//     var that = this
//     console.log(that.data.sasddf),
//     console.log(that.data.studentInformation)
//   },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log("hahaha"+options.courseNo)
    this.setData({
      classInformation: JSON.parse(options.classInfo),
      courseNo: options.courseNo
    })
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