// pages/studentImResult/studentImResult.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
  // url="../studentSign/studentSign"
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      datas:JSON.parse(options.datas)
    })
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
  getDetail:function(e){
    console.log(e.currentTarget.dataset.index)
    console.log(e.currentTarget.dataset.text)
    wx.request({
      url: 'http://localhost:5210/wechat.sign/getSubDetails',
      data: {
        stuNo: e.currentTarget.dataset.text.stuNo,
        courseNo: e.currentTarget.dataset.index.courseNo
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data)
        wx.navigateTo({
          url: '../studentSign/studentSign?msg=' + JSON.stringify(res.data) + "&course=" + JSON.stringify(e.currentTarget.dataset.index) + "&student=" + JSON.stringify(e.currentTarget.dataset.text),
        })
      },
      fail: function () {
        console.log("请求失败")
      }
    })
  },
  deleteStudent: function (e) {
    var e = e;
    console.log(e.currentTarget.dataset.delete)
    wx.showModal({
      title: '提示',
      content: '确认删除?',
      success: function (res) {
        if(res.confirm){
          wx.request({
            url: 'http://localhost:5210/wechat.sign/deleteStudent',
            data: {
              stuNo: e.currentTarget.dataset.delete
            },
            header: {
              'content-type': 'application/json' // 默认值
            },
            success: function (res) {
              console.log("请求成功")
              wx.navigateBack({
                delta: 4
              })
            },
            fail: function () {
              console.log("请求失败")
            }
          })
        }else if(res.cancel){
          wx.navigateBack({
            delta: 4
          })
        }
      }
    })
  }
})