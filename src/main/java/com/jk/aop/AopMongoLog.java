package com.jk.aop;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.SimpleTimeZone;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;




public class AopMongoLog  implements MethodBeforeAdvice,AfterReturningAdvice  {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	// 后置通知
	@Override
	public void afterReturning(Object returnVal, Method method, Object[] params, Object implUrl) throws Throwable {
		
		LogInfo log = new LogInfo();
		
		log.setMethod(method.toString());
		
		log.setImplUrl(implUrl.toString());
		if(returnVal != null){
			log.setReturnVal(returnVal.toString());
		}
		String paramVal = "";
		
		if(params.length > 0){
			for (Object p : params) {
				paramVal += p+",";
			}
		}
		log.setParamVal(paramVal);
		
		//解决时间
	      SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	      
	      String format = sim.format(new Date());
	      
	      sim.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
	      Date parse = sim.parse(format);
		  
		log.setInvokeTime(format);
		log.setMethDate(parse);
		mongoTemplate.insert(log);
		System.out.println("..............返回后通知 记录日志.............");
		
	}
	
	
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		
	}
	
	
	

}
