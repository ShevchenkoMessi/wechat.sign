package com.xt.wechat.sign.manager.entity;

import java.io.Serializable;

public class Worker implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5860308491944377453L;

	private Integer workerId;
	
	private String workerNo;
	
	private String workerName;
	
	private String workerSchool;
	
	private String workerPhone;
	
	private String workerEmail;
	
	private String workerPasswd;

	public Integer getWorkerId() {
		return workerId;
	}

	public void setWorkerId(Integer workerId) {
		this.workerId = workerId;
	}

	public String getWorkerNo() {
		return workerNo;
	}

	public void setWorkerNo(String workerNo) {
		this.workerNo = workerNo;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public String getWorkerSchool() {
		return workerSchool;
	}

	public void setWorkerSchool(String workerSchool) {
		this.workerSchool = workerSchool;
	}

	public String getWorkerPhone() {
		return workerPhone;
	}

	public void setWorkerPhone(String workerPhone) {
		this.workerPhone = workerPhone;
	}

	public String getWorkerEmail() {
		return workerEmail;
	}

	public void setWorkerEmail(String workerEmail) {
		this.workerEmail = workerEmail;
	}

	public String getWorkerPasswd() {
		return workerPasswd;
	}

	public void setWorkerPasswd(String workerPasswd) {
		this.workerPasswd = workerPasswd;
	}

	@Override
	public String toString() {
		return "Worker [workerId=" + workerId + ", workerNo=" + workerNo + ", workerName=" + workerName
				+ ", workerSchool=" + workerSchool + ", workerPhone=" + workerPhone + ", workerEmail=" + workerEmail
				+ ", workerPasswd=" + workerPasswd + "]";
	}
	
}
