// pages/querySign/querySign.js
const app = getApp()
var sub = require("../../utils/util")
Page({

  /**
   * 页面的初始数据
   */
  data: {
    sub: {},
    index: 0
  },

  classDetail:function(e){
    wx.request({
      url: 'http://localhost:5210/wechat.sign/querySign',
      data: {
        courseId: e.detail.value,
        stuNo:app.stuInfo.stuNo
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        var signDetail = JSON.stringify(res.data)
        // console.log(signDetail)
        wx: wx.navigateTo({
          url: '/pages/queryDetail/queryDetail?signDetail=' + signDetail +"&index=" + e.detail.value
        })
      },
      fail: function () {
        console.log("请求失败")
      }
    })
      // wx:wx.navigateTo({
      //   url: '/pages/queryDetail/queryDetail?index=' + e.detail.value
      // })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      this.setData({
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