// pages/teacher_check_retroactive/teacher_check_retroactive.js
const app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    student:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // var stuMSG = JSON.parse(options.resignMSG.stus);
    // var resignMSG = JSON.parse(options.resignMSG.megs);
    // console.log(JSON.parse(options.resignMSG).stus)
    if('"无信息"' != options.resignMSG){

      var stuResign = new Array();
      for (var index = 0; index < JSON.parse(JSON.parse(options.resignMSG).stus).length;index++){
        stuResign[index] = {
          "stuNo": JSON.parse(JSON.parse(options.resignMSG).stus)[index].stuNo,
          "msg": JSON.parse(JSON.parse(options.resignMSG).megs)[index].reason,
          "stuName": JSON.parse(JSON.parse(options.resignMSG).stus)[index].stuName
        }
      this.setData({
        student:stuResign,
        courseNo: options.courseNo
      })
    }
      }else{
      this.setData({
        student: ""
      })
      }
  },

  agreeOne:function(e){
    var that = this;
    wx.request({
      url: 'http://192.168.0.112:5210/wechat.sign/agreeOne',
      data: {
        stuNo:e.currentTarget.id,
        monthTime:parseInt(new Date().getMonth())+1,
        courseNo:that.data.courseNo
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        wx.showModal({
          title: '提示',
          content: '操作成功',
          success: function (res) {
            wx.navigateBack({
              delta: 1
            })
          }
        })
      },
      fail: function () {
        console.log("请求失败")
      }
    })
  },

  agreeAll: function(e){
    var stus = new Array();
    for(var i=0;i<this.data.student.length;i++){
      stus[i] = this.data.student[i].stuNo
    }
    wx.request({
      url: 'http://192.168.0.112:5210/wechat.sign/agreeAll',
      data: {
        stuNos: stus,
        monthTime: parseInt(new Date().getMonth()) + 1,
        courseNo: app.courseInfo.courseNo
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {

      },
      fail: function () {
        console.log("请求失败")
      }
    })
  },
  refuseOne: function(e){
    wx.request({
      url: 'http://192.168.0.112:5210/wechat.sign/refuseOne',
      data: {
        stuNo: e.currentTarget.id,
        courseNo: app.courseInfo.courseNo
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        wx.navigateBack({
          delta:1
        })
      },
      fail: function () {
        console.log("请求失败")
      }
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