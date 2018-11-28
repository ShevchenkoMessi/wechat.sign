// pages/teacherImResult/teacherImResult.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    ifUpdate:false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      datas:JSON.parse(options.datas)
    });
    console.log(this.data.datas)
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
  ifUpdate:function(){
    this.setData({
      ifUpdate:true
    })
  },
  formSubmit: function (e) {
    var that = this;
    var e = e;
    console.log(this.data.datas+'form发生了submit事件，携带数据为：', e.detail.value);
    this.setData({
      ifUpdate:false,
    })
    wx.request({
      url: 'http://localhost:5210/wechat.sign/updateTeacherByWorker',
      data: {
        teacherName: e.detail.value.teacherName,
        teacherWork: e.detail.value.teacherWork,
        teacherNo: e.detail.value.teacherNo,
        courseName: e.detail.value.courseName,
        courseNo: e.detail.value.courseNo
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
  },
  deleteTeacher:function(e){
    var e = e;
    console.log(e.currentTarget.dataset.delete)
    wx.showModal({
      title: '提示',
      content: '确认删除?',
      success: function (res) {
        if(res.confirm){
          wx.request({
            url: 'http://localhost:5210/wechat.sign/deleteTeacher',
            data: {
              teacherNo: e.currentTarget.dataset.delete
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
        }else{
          wx.navigateBack({
            delta: 4
          })
        }
      }
    })
  }
})