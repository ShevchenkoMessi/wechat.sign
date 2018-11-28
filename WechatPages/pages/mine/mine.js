//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
       
  },
  getUserInfo: function(e) {
    var that = this;
    console.log(e)
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true,
      workerInfo:app.workerInfo
    })//,
      /*wx.request({
        url: 'http://localhost:5210/wechat.sign/getWorkerInfo',
        data: {
          workerNo: 20162788666,
          workerPasswd: 123456
        },
        header: {
          'content-type': 'application/json' // 默认值
        },
        success: function (res) {
          app.workerInfo = res.data;
          that.setData({
            workerInfo: res.data
          }),
          console.log(that.data.workerInfo)
        },
        fail: function () {
          console.log("请求失败")
        }
      })*/
  },

// 画布线条设置
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
  publish:function(){
    // wx.request({
    //   url: 'http://localhost:5210/wechat.sign/getAnnouncement',
    //   data: {
    //   },
    //   header: {
    //     'content-type': 'application/json' // 默认值
    //   },
    //   success: function (res) {
    //     wx.navigateTo({
    //       url: '../announcement/announcement?announcement=' + JSON.stringify(res.data),
    //     })
    //   },
    //   fail: function () {
    //     console.log("请求失败")
    //   }
    // })
    wx.navigateTo({
      url: '../announcement/announcement?announcement=' + JSON.stringify(app.announcement),
    })
  }
})
