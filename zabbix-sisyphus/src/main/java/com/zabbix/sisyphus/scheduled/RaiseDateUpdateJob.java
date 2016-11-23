package com.zabbix.sisyphus.scheduled;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.Charsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.zabbix.sisyphus.fortune.entity.TenderPlan;
import com.zabbix.sisyphus.fortune.repository.TenderPlanDao;
import com.zabbix.sisyphus.licaipro.entity.ProjectInfo;
import com.zabbix.sisyphus.licaipro.repository.ProjectInfoDao;
import com.zabbix.sisyphus.util.SmsRequest;

//@Lazy(false)  
//@Component
//@Transactional
public class RaiseDateUpdateJob {
	@Autowired
	private TenderPlanDao tenderPlanDao;
	@Autowired
	private ProjectInfoDao projectInfoDao;
	@Value("${mobiles}")  
    private String mobiles;   
	
	
	@Scheduled(cron="0 0/2 * * * ? ")  
	public void excute(){
		
		//更新募集结束时间
		List<TenderPlan> planList = tenderPlanDao.findByRaiseEndTimeIsNull();
		if (planList!=null){
			for (Object obj:planList){
				TenderPlan  tenderPlan = (TenderPlan)obj;
				ProjectInfo projectInfo = projectInfoDao.getOne(tenderPlan.getOldLicaiProId());
				if(projectInfo!=null  && "15".equals(String.valueOf(projectInfo.getProjectStatus()) )){
					String[] mobile = mobiles.split("[,]");
					
					for(int i=0;i<=mobile.length-1;i++){
						String msg =  String.format("Hi [%s] 小伙伴,[%s]标的已于[%s]满标, 融资总额为:[%s],总融资时间为:[%s]!",mobile,projectInfo.getProjectName(),projectInfo.getCreateTime(),projectInfo.getTotalNum(),getTimeString(projectInfo.getCreateTime()));
						sendingSMS(mobile[i] ,msg);
					}

					tenderPlan.setRaiseEndTime(new Date());
					tenderPlanDao.save(tenderPlan);
				}
			
			}
		}
	}

	public long getDiffDateTime(Date date){
		Calendar dateOne=Calendar.getInstance(),dateTwo=Calendar.getInstance();
		dateOne.setTime(new Date());	//设置为当前系统时间 
		dateTwo.setTime(date);		//设置为2015年1月15日
		long timeOne=dateOne.getTimeInMillis();
		long timeTwo=dateTwo.getTimeInMillis();
		long minute=(timeOne-timeTwo)/(1000*60);//转化minute
		return minute;
	}
	
	public String getTimeString(Date date){
		long min = getDiffDateTime(date);
		int h = (int) (min/60) ;
		int m = (int) (min%60) ;
		return h+"小时 "+m+"分钟";
	}
	
	public static void main(String[] args) throws ParseException {
		RaiseDateUpdateJob r = new RaiseDateUpdateJob();
		DateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(d.parse("2016-10-27 13:12:12"));
		long min = r.getDiffDateTime(d.parse("2016-10-27 13:12:12"));
		int h = (int) (min/60) ;
		int m = (int) (min%60) ;
		System.out.println(h+"   "+m);
		
	}
	
	public static void sendingSMS(String mobile, String content) {
        RestTemplate restTemplate = new RestTemplate();
        SmsRequest smsBean = new SmsRequest(mobile, content);
        String smsSendResult = restTemplate.postForObject("http://wt.3tong.net/json/sms/Submit", smsBean, String.class);
        smsSendResult = (new String(smsSendResult.getBytes(Charsets.ISO_8859_1), Charsets.UTF_8));
    }
}
