const app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    hasNoFinger:false
  },
  verifyFingerprint:function(){
    var that = this;
    wx.startSoterAuthentication({
      requestAuthModes: ['fingerPrint'],
      challenge: '123456',
      authContent: '请验证指纹',
      success(res) {
        that.doSign();
      },
      fail(){
        wx.showModal({
          title: '提示',
          content: '没有指纹信息',
          success: function (res) {
            that.setData({
              hasNoFinger:true
            })
          }
        })
      }
    })
  },

  doSign:function(){
    var that = this;
    var latitude;
    var longitude;

    wx.getLocation({
      type: 'wgs84',
      success: function (res) {
        console.log("res.latitude" + res.latitude + "res.longitude" + res.longitude);
        latitude = res.latitude
        longitude = res.longitude
         wx.request({
           url: 'http://localhost:5210/wechat.sign/getLocationByTeacherNo',
        data: {
          courseId:that.data.index,
          stuLatitude: latitude,
          stuLongitude: longitude,
          stuNo:app.stuInfo.stuNo,
          monthTime: parseInt(new Date().getMonth()) + 1
          },
        header: {
          'content-type': 'application/json' // 默认值
        },
        success: function (res) {
          console.log(res.data)
          if(res.data=="请到教室签到"){
            wx.showModal({
              title: '提示',
              content: '当前无法签到',
              success: function (res) {
                wx.navigateBack({
                  delta: 1
                })
              }
            })
          }else{
            wx.showModal({
              title: '提示',
              content: '签到成功',
              success: function (res) {
                wx.navigateBack({
                  delta: 1
                })
              }
            })
          }
        },
        fail: function () {
          console.log("请求失败")
        }
      })
      }
    })
  },

  openGPS:function(){
    console.log("正在打开GPS定位");
  },

  getPos:function(){
    wx.getLocation({
      type: 'gcj02',
      success: function (res) {
        var latitude = res.latitude
        var longitude = res.longitude
        wx.openLocation({
          latitude: latitude,
          longitude: longitude,
          scale: 28
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      index: options.index,
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