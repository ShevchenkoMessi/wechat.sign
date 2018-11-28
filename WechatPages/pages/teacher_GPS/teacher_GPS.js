// pages/teacher_GPS/teacher_GPS.js

const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    success:"",
    fail:"",
    stop:false
  },
  /**
   * 检查GPS是否发送成功    
   */
  sengGPS:function(){
    var that = this;
    var latitude;
    var longitude;
    wx.getLocation({
      type: 'wgs84',
      success: function (res) {
        latitude = res.latitude
        longitude = res.longitude
      wx.request({
        url: 'http://localhost:5210/wechat.sign/getTeacherLocation',
        data: {
          teacherNo:app.teacherInfo.teacherNo,
          latitude: latitude,
          longitude: longitude
        },
        header: {
          'content-type': 'application/xijson' // 默认值
        },
        success: function (res) {
          that.setData({
            stop:true
          });
          wx.showModal({
            title: '提示',
            content: '发布成功',
          })
        },
        fail: function () {
          console.log("请求失败")
        }
      })
      }
    })
  },

  deleteLocation:function(){
    var that = this;
    wx.request({
      url: 'http://localhost:5210/wechat.sign/deleteLocation',
      data: {
        teacherNo: app.teacherInfo.teacherNo
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log("请求成功")
        that.setData({
          stop: false
        });
        wx.showModal({
          title: '提示',
          content: '关闭成功',
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
    // var that = this,
    // var option = options
   for(var i=0;i<app.courseInfo.length;i++){
     console.log("options.courseNo" + options.courseNo)
     if (app.courseInfo[i].courseNo == options.courseNo){
       this.setData({
         courseInfo:app.courseInfo[i]
       })
     }
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