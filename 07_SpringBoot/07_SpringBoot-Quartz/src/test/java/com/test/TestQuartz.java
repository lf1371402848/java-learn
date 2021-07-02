package com.test;

import com.test.quartz.MyJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class )
public class TestQuartz {
    //获取任务调度器
    @Autowired
    private Scheduler scheduler;

    //声明方法:新增任务调度
    @Test
    public void testAddQuartz() throws SchedulerException {
        //1. 创建任务的JobDetail:描述任务执行的细节以及其他要求，比如任务的名字，任务的分组
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).
                withIdentity("name1", "group1").
                build();
        //2.创建触发器:描述任务触发的时机
        Trigger trigger = TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .withIdentity("t1", "g1")
                .build();
        //3.将任务和触发器绑定在一起，并让任务调度器开始监听
        scheduler.scheduleJob(jobDetail, trigger);//新增调度
        scheduler.start();//开始调度
    }

    //声明方法:修改任务调度
    @Test
    public void testUpdateQuartz() throws SchedulerException {
        //1.获取当前任务的触发器
        //根据触发器的名字和组名获取触发器的key
        TriggerKey triggerKey = TriggerKey.triggerKey("t1", "g1");
        //获取触发器
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        //2.修改触发器中的数据
        trigger = trigger.getTriggerBuilder()
                .withIdentity(triggerKey)
                .withSchedule(CronScheduleBuilder.cronSchedule("0/4 * * * * ?"))
                .build();
        //3.资源调度器重新加载触发器
        scheduler.rescheduleJob(triggerKey, trigger);
    }

    //声明方法:删除任务调度
    @Test
    public void testDelQuartz() throws SchedulerException {
        //1.获取要暂停的任务的JobKey
        JobKey jobKey = new JobKey("name1", "group1");
        //让任务调度器删除调度任务
        scheduler.deleteJob(jobKey);
    }

    //声明方法:暂停任务调度
    @Test
    public void testPauseQuartz() throws SchedulerException {
        //1.获取要暂停的任务的JobKey
        JobKey jobKey = new JobKey("name1", "group1");
        //2.让任务调度器，暂停任务的调度
        scheduler.pauseJob(jobKey);
    }

    //声明方法：重启任务调度
    @Test
    public void testReQuartz() throws SchedulerException {
        //1.获取重启的任务的jobkey
        JobKey jobKey = new JobKey("name1", "group1");
        //2.让任务调度器重新调用该任务
        scheduler.resumeJob(jobKey);

    }

    @Test
    public void testQueryQuartz(){
        try {
            GroupMatcher<JobKey> groupMatcher = GroupMatcher.anyJobGroup();
            Set<JobKey> jobKeySet = scheduler.getJobKeys(groupMatcher);
            for(JobKey jobKey : jobKeySet){
                List<? extends Trigger> listTriggers = scheduler.getTriggersOfJob(jobKey);
                System.out.println("=========================================");
                for(Trigger trigger : listTriggers){
                    System.out.println(jobKey.getName());
                    System.out.println(jobKey.getGroup());
                    System.out.println(scheduler.getTriggerState(trigger.getKey()));
                    System.out.println(((CronTrigger) trigger).getCronExpression());
                }
                System.out.println("==========================================");
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
