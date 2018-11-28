// pages/tExactSearch/tExactSearch.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
  
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
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
  formSubmit: function (e) {
    console.log('form发生了submit事件，携带数据为：', e.detail.value);
    if(e.detail.value.teacherName == ""){
      wx.showModal({
        title: '提示',
        content: '教师姓名不能为空',
      })
    }else{
      wx.request({
        url: 'http://localhost:5210/wechat.sign/getTeachers',
        data: {
          teacherNo: e.detail.value.teacherNo,
          teacherName: e.detail.value.teacherName
        },
        header: {
          'content-type': 'application/json' // 默认值
        },
        success: function (res) {
          console.log(res.data)
          if(res.data == "无信息") {
            wx.showModal({
              title: '提示',
              content: '没有找到教师信息'
            })
          } else {
            wx.navigateTo({
              url: '../tSByDepartmentResult/tSByDepartmentResult?teachers=' + JSON.stringify(res.data),
            })
          }
        },
        fail: function () {
          console.log("请求失败")
        }
      })
    }
  },
})