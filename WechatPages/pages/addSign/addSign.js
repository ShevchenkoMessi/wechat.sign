const app = getApp();

var sub = require("../../utils/util")

Page({

  /**
   * 页面的初始数据
   */
  data: {
    message:"",
    sub:{}
  },

  commit:function(e){
    var that=this;
    console.log(e.detail.value)
    wx.request({
      url: 'http://localhost:5210/wechat.sign/addSign',
      data: {
        courseId: this.data.index,
        stuNo:e.detail.value.stuNo,
        reason: e.detail.value.reason
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log("请求成功，")
        wx.navigateBack({
          delta: 1
        })
      },
      fail: function () {
        console.log("请求失败")
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      index:options.index,
      stuInfo:app.stuInfo,
      sub:sub.sub
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