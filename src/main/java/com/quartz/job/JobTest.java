package com.quartz.job;

import com.quartz.job.listener.MyJobListener;
import com.quartz.job.listener.MyTriggerListener;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.EverythingMatcher;
import org.quartz.impl.matchers.KeyMatcher;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Title: JobTest
 */
public class JobTest {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("主线程开始时间+++"+format.format(new Date()));
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

        JobDetail jobDetail = JobBuilder.newJob(Myjob.class)
                .withIdentity("job1", "group1")
                .withDescription("this is a sulin job")
                .usingJobData("jobDetailParam1", "detail1")
                .usingJobData("jobDetailParam2", "detail2")
                .usingJobData("count", 1)
                .build();
//        System.out.println("job detail dataMap print:::"+jobDetail.getJobDataMap().getString("name"));
//        System.out.println("job class full name::: "+jobDetail.getJobClass().getName());
//        System.out.println("job class simple name::: "+jobDetail.getJobClass().getSimpleName());
//        System.out.println("job description "+jobDetail.getDescription());

        Trigger trigger = TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ?"))
                .withIdentity("job1", "group1")
                .usingJobData("triggerParam1", "trigger1 trigger1 trigger1")
                .usingJobData("triggerParam2", "trigger2 trigger2 trigger2")
                .withDescription("this is a trigger")
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
        //全局监听
        //scheduler.getListenerManager().addJobListener(new MyJobListener(), EverythingMatcher.allJobs());
        //局部监听 --仅仅监听某个jobkey--  jobkey=name+group
//        scheduler.getListenerManager().addJobListener(new MyJobListener(), KeyMatcher.keyEquals(JobKey.jobKey("job1","group1")));
//        scheduler.getListenerManager().addTriggerListener(new MyTriggerListener(),EverythingMatcher.allTriggers());
        scheduler.start();


        //将schedular挂起 standBy
//        TimeUnit.SECONDS.sleep(10);
//        System.out.println("主线程暂停时间+++"+format.format(new Date()));
//        scheduler.standby();
//        TimeUnit.SECONDS.sleep(2);
//        scheduler.start();
//        TimeUnit.SECONDS.sleep(8);
//        scheduler.shutdown();
    }
}
