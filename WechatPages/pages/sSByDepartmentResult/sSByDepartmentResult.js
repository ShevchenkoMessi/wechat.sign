// pages/sSByDepartmentResult/sSByDepartmentResult.js
const app = getApp()

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
    this.setData({
      students:JSON.parse(options.students)
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    // url = "../studentImResult/studentImResult" 
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

  onReady: function (e) {
    var context = wx.createContext();//创建并返回绘图上下文context对象。  
    context.beginPath();//开始一个新的路径  
    context.moveTo(20, 10);//路径的起点  
    context.lineTo(300, 10);//路径的终点  
    context.stroke();//对当前路径进行描边  
    context.closePath();//关闭当前路径  
    wx.drawCanvas({//  
      canvasId: 'canvasLine1',//画布标识，对应的cavas-id  
      actions: context.getActions()//导出context绘制的直线并显示到页面  
    });
  },

  getStudentrDetail:function(e){
    console.log(e.currentTarget.dataset.index);
    wx.request({
      url: 'http://localhost:5210/wechat.sign/getStudentdetails',
      data: {
        stuNo: e.currentTarget.dataset.index
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data);
        wx.navigateTo({
          url: '../studentImResult/studentImResult?datas=' + JSON.stringify(res.data),
        })
      },
      fail: function () {
        console.log("请求失败")
      }
    })
  }
})