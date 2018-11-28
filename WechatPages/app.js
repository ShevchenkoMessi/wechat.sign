//app.js
App({
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

  
},
//教师信息
  teacherInfo: {
    teacherId:"",
    teacherNo:"",
    teacherName:"",
    teacherCard:"",
    teacherPhone:"",
    teacherEmail:"",
    teacherWork:"",
    teacherStudy:"",
    teacherPath:"",
    teacherPasswd:""
  },
  //班级信息
  classInfo: {
    classId: "",
    classNo: "",
    monitorName: "",
    monitorTel: "",
    stuCount: "",
    university: "",
    college: "",
    profession: ""
  },
  //课程信息
  courseInfo:{
    courseId:"",
    courseNo:"",
    teacherNo:"",
    classNo:"",
    courseName:"",
    courseTime:""
  },
  stuInfo:{
      stuId:"",
      stuName:"",
      stuNo:"",
      stuClassId: "",
      stuCard: "",
      stuPhone: "",
      stuEmail: "",
      stuPasswd:"",
  },
  
  classInfo:{
    classId: "",
    classNo: "",
    monitorName: "",
    monitorTel: "",
    stuCount: "",
    university: "",
    college: "",
    profession: ""
  },
  
   workerInfo:{
    workerId:"",
    workerNo:"",
    workerName:"",
    workerSchool:"",
    workerPhone:"",
    workerEmail:"",
    workerPasswd:"",
  },
  
  announcement:{
    id:"",
    item:"",
    text:""
  }
  
})