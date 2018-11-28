// pages/announcement/announcement.js
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
      announcement:app.announcement
    })
    console.log(this.data.announcement)
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

    // 边框设置
    var context2 = wx.createContext()
    context2.beginPath()
    context2.setStrokeStyle("red")
    context2.setLineWidth(2)
    context2.rect(10, 0, 300, 200)
    context2.stroke()
    context2.closePath();

    context2.beginPath()
    context2.fillText("欢迎使用",130,15,270)
    context2.moveTo(10, 25)
    context2.lineTo(310, 25)  
    context2.fillText("欢迎使用指纹签到系统", 95, 40, 270)
    context2.fillText("欢迎使用指纹签到系统", 95, 60, 270)
    context2.fillText("欢迎使用指纹签到系统", 95, 80, 270)
    context2.stroke()

    // 调用 wx.drawCanvas，通过 canvasId 指定在哪张画布上绘制，通过 actions 指定绘制行为
    wx.drawCanvas({
      canvasId: 'firstCanvas',
      actions: context2.getActions() // 获取绘图动作数组
    })

  },

})