package com.quartz.job;

import lombok.Data;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;

/**
 * Title: Myjob
 * @author Sulin
 */
@Data
@PersistJobDataAfterExecution
public class Myjob implements Job {

    private String jobDetailParam1;
    private String jobDetailParam2;
    private String triggerParam1;
    private String triggerParam2;
    private Integer count;

    private static final Logger logger = LoggerFactory.getLogger(Myjob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //获取jobDetail中的
        JobKey key = context.getJobDetail().getKey();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("job 开始时间+++" + format.format(context.getFireTime()));
//        System.out.println();
//        System.out.println("经过::" + (end - begin));
//        System.out.println("执行时间222" + format.format(context.getFireTime()));
//        System.out.println(jobDetailParam1);
//        System.out.println(jobDetailParam2);
//        System.out.println(triggerParam1);
//        System.out.println(triggerParam2);
//        System.out.println("count的值:"+count);
        ++count;
        context.getJobDetail().getJobDataMap().put("count",count);
        context.getJobDetail().getJobDataMap().put("jobDetailParam1",jobDetailParam1+count);
        context.getJobDetail().getJobDataMap().put("jobDetailParam2",jobDetailParam2+count);
        context.getJobDetail().getJobDataMap().put("triggerParam1",triggerParam1+count);
        context.getJobDetail().getJobDataMap().put("triggerParam2",triggerParam2+count);
/*

        System.out.println(" myjob 获取  name "+key.getName());
        System.out.println(" myjob 获取  group "+key.getGroup());
        System.out.println(" myjob 获取  class "+context.getJobDetail().getJobClass().getName());
        System.out.println(" myjob 获取  class "+context.getJobDetail().getJobClass().getSimpleName());
        System.out.println(context.getJobDetail().getJobDataMap().getString("jobDetailParam1"));
        System.out.println(context.getJobDetail().getJobDataMap().getString("jobDetailParam2"));

        //获取trigger中的
        TriggerKey triggerKey = context.getTrigger().getKey();
        System.out.println("trigger 获取 name "+ triggerKey.getName());
        System.out.println("trigger 获取 group "+ triggerKey.getGroup());
        System.out.println("trigger 获取"+triggerKey.getClass());
        System.out.println("the  jod is start :::"+System.currentTimeMillis());
        JobDataMap dataMap = context.getTrigger().getJobDataMap();
        System.out.println(dataMap.getString("jobDetailParam1"));
        System.out.println(dataMap.getString("jobDetailParam2"));
*/

    }
}
