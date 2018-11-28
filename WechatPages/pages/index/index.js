//index.js
//获取应用实例
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */ 
  data: {
    ifupdate:true,
    hasUserInfo:false,
    userInfo:{},
    stuInfo:{},
    classInfo:{},
    tempFilePaths:"",
    hasTempFilePaths:false
  },


  /**
   * 生命周期函数--监听页面加载
   */
    getUser:function(){

    var that = this
    wx.getUserInfo({
      success: function (res) {
        that.setData({
          userInfo:res.userInfo
        })
      }
    })
        console.log(that.data.userInfo);
    },

  onLoad: function (options) {
    // wx.request({
    //   url: 'http://localhost:5210/wechat.sign/getStuInfo',
    //   data: {
    //     stuNo: 20162410331
    //   },
    //   header: {
    //     'content-type': 'application/json' // 默认值
    //   },
    //   success: function (res) {
    //     console.log(res.data);
    //     app.stuInfo = res.data[0];
    //     app.classInfo = res.data[1];
    //   },
    //   fail:function(){
    //     console.log("请求失败")
    //   }
    // })
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
    
  },
  getUserInfo:function(e){
    this.setData({
      userInfo:e.detail.userInfo,
      classInfo:app.classInfo,
      hasUserInfo:true,
      stuInfo:app.stuInfo
    })
  },

  updateMessage:function(){
      this.setData({
        ifupdate:false
      })
  },
  navigateToSign: function () {
    wx: wx.navigateTo({
      url: '/pages/sign/sign',
    })
  },

  navigateToQuery: function () {
    wx: wx.navigateTo({
      url: '/pages/querySign/querySign',
    })
  },

  submit:function(e){
    app.stuInfo.stuNo = e.detail.value.stuNo;
    app.stuInfo.stuName = e.detail.value.stuName;
    app.classInfo.university = e.detail.value.university;
    app.classInfo.college = e.detail.value.college;
    app.classInfo.profession = e.detail.value.profession;
    wx.request({
      url: 'http://localhost:5210/wechat.sign/updateStuInfo',
      data: {
        stu:app.stuInfo,
        classes:app.classInfo
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log("请求成功")
      },
      fail: function () {
        console.log("请求失败")
      }
    })
    // wx: wx.navigateTo({
    //   url: '/pages/person/person',
    // })
    this.setData({
      ifupdate:true,
    })
  },

  updatePic:function(){
    var that = this;
    wx.chooseImage({
      count: 1, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        var tempFilePaths = res.tempFilePaths
        that.setData({
          tempFilePaths: tempFilePaths,
          hasTempFilePaths:true
        })
      }
    })
  }

})