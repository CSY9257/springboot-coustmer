package com.jk.aop;

import java.util.Date;
import java.util.HashMap;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection="logInfo")
public class LogInfo {
	
	
	private String logInfoId;
	
	private String method;
	
	private String paramVal;
	
	private String returnVal;
	
	private String implUrl;
	
	private String invokeTime;
	
	private Date   methDate;
	
	private HashMap map;
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date minDate;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date maxDate;
	

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getParamVal() {
		return paramVal;
	}

	public void setParamVal(String paramVal) {
		this.paramVal = paramVal;
	}

	public String getReturnVal() {
		return returnVal;
	}

	public void setReturnVal(String returnVal) {
		this.returnVal = returnVal;
	}

	public String getImplUrl() {
		return implUrl;
	}

	public void setImplUrl(String implUrl) {
		this.implUrl = implUrl;
	}

	public String getInvokeTime() {
		return invokeTime;
	}

	public void setInvokeTime(String invokeTime) {
		this.invokeTime = invokeTime;
	}

	@Override
	public String toString() {
		return "LogInfo [ method=" + method + ", paramVal=" + paramVal + ", returnVal=" + returnVal
				+ ", implUrl=" + implUrl + ", invokeTime=" + invokeTime + "]";
	}

	public Date getMethDate() {
		return methDate;
	}

	public void setMethDate(Date methDate) {
		this.methDate = methDate;
	}

	public String getLogInfoId() {
		return logInfoId;
	}

	public void setLogInfoId(String logInfoId) {
		this.logInfoId = logInfoId;
	}

	public Date getMinDate() {
		return minDate;
	}

	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}

	public Date getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}

	public HashMap getMap() {
		return map;
	}

	public void setMap(HashMap map) {
		this.map = map;
	}
	
	

}
