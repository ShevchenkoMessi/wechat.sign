// pages/teacher_check/teacher_check.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    classInformation:"",
    mRegister: "",
    hRegister: "",
    openM:false,
    openH:false,
    resignMSG:"h",
    condition:false
  },
  /**
   * 跳转到补签界面
   */
  retroactive:function(){
    var that = this;
    wx.request({
      url: 'http://localhost:5210/wechat.sign/getAddMSG',
      data: {
        courseNo: that.data.courseNo,
        classId:parseInt(that.data.index)+1
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        that.setData({
          resignMSG:JSON.stringify(res.data)
        })
        wx.navigateTo({
          url: '../teacher_check_retroactive/teacher_check_retroactive?resignMSG=' + that.data.resignMSG + "&courseNo=" + that.data.courseNo
        })
      },
      fail: function () {
        console.log("请求失败")
      }
    })
  },
  /**
   * 开合
   */
  openAndCloseM:function(){
    var that = this;
        var stuInfo = new Array();
    wx.request({
      url: 'http://localhost:5210/wechat.sign/getMessageHistory',
      data: {
        courseNo: that.data.courseNo,
        classId: that.data.classInformation.classId
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data);
        console.log(res.data == "无信息");
        if (res.data == "无信息") {
          that.setData({
            condition: true
          })
        }else{
          var stus = JSON.parse(res.data.stus);
          var msgs = JSON.parse(res.data.msgs);
          for(var i=0;i<stus.length;i++){
            stuInfo[i] = {
              "stuNo":stus[i].stuNo,
              "stuName": stus[i].stuName,
              "times": msgs[i]
            }
          }
          that.setData({
            openH: !that.data.openH,
            hRegister: stuInfo
          })
        }
      },
      fail: function () {
        console.log("请求失败")
      }
    })
    console.log(this.data.hRegister);
  },
  openAndCloseH: function () {
    var that = this
    var stuInfo1 = new Array();
    wx.request({
      url: 'http://localhost:5210/wechat.sign/getMessageMonth',
      data: {
        courseNo: that.data.courseNo,
        monthTime:new Date().getMonth() + 1,
        classId: that.data.classInformation.classId
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data);
        console.log(res.data == "无信息");
        if(res.data=="无信息"){
          that.setData({
            condition:true
          })
        }else{
          var stus = JSON.parse(res.data.stus);
          var msgs = JSON.parse(res.data.msgs);
          for (var i = 0; i < stus.length; i++) {
            stuInfo1[i] = {
              "stuNo": stus[i].stuNo,
              "stuName": stus[i].stuName,
              "times": msgs[i]
            }
          }
          that.setData({
            openM: !that.data.openM,
            mRegister: stuInfo1
          })
        }
      },
      fail: function () {
        console.log("请求失败")
      }
    })
    that.setData({
      openH: !this.data.openH
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log("班级信息------------->" + options.courseNo);
    var that = this
    that.setData({
      classInformation: JSON.parse(options.classInformation),
      index:options.index,
      courseNo:options.courseNo
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
  
  },
})