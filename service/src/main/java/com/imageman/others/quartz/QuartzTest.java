package com.imageman.others.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;


/**
 * author: ZGF
 */

public class QuartzTest {
    /**
     * 1、Scheduler 调度器   trigger 触发器   JObdetail 任务
     * 一个Scheduler 调度器可以调度多个trigger
     * 一个trigger只能有一个JobDetail
     * 不同trigger可以调度同一个JobDetail
     *
     *
     * 2、Group 用来标记和管理，name是用来标记的
     * group 可以不传，会默认进入“DEFAULT”分组
     *   分组后，我们可以根据API进行组别的操作，比如说全部暂停等  scheduler.pauseJobs(GroupMatcher);
     *      一般根据业务模块分组，比如说 物流分组、用户分组、产品分组等
     *      至于名字name的话，可以根据需要，配置自动触发的任务和手动触发的任务   如： nameA-auto   nameA-manual  等
     *
     * 3、 SimpleTriggerImpl   ----  SimpleSchedule 根据一定间隔时间和重复次数执行
     *     CalendarIntervalTriggerImpl  ---
     *     DailyTimeIntervalImpl    ---
     *     CronTriggerImpl      ---         Cron 表达式
     *
     * @param args
     */
    public static void main(String[] args) {
        Scheduler scheduler = null;
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            // 参见配置建
            System.out.println("调度器名：" + scheduler.getSchedulerName());
            System.out.println("线程数："   + scheduler.getMetaData().getThreadPoolSize());
            System.out.println("是否开启：" + scheduler.getMetaData().isStarted());
            System.out.println("调度器名：" + scheduler.getSchedulerName());


            scheduler.start();

            /**
             * 定义任务：首先我定时任务的Job必须要有一个无参构造函数，因为我们传递Hello.class而不是自己创建Job
             *      其次可以使用JobData传递参数到Job里面去
             */
            JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("job1", "group1")  // 给任务一个 名称和组别
                    .usingJobData(/*Map*/ "key", "value")  // 添加参数
                    // .setJobData(JobDataMap)   // 覆盖参数
                    .build();

            // 定义执行器  执行频次等
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(1)
                            .repeatForever()
                    ).build();

            // 定义执行器  执行频次等
            Trigger trigger2 = TriggerBuilder.newTrigger()
                    .withIdentity("trigger2", "group1")
                    .startNow()
                    .forJob(jobDetail)
                    .withSchedule(
                            SimpleScheduleBuilder.simpleSchedule()
                                    .withIntervalInSeconds(3)
                                    // .withRepeatCount(1)  重复一次，加上原执行一共两次
                                    .repeatForever()
                            /*CronScheduleBuilder.cronSchedule("* * 1 * * ?")
                            /*DailyTimeIntervalScheduleBuilder.dailyTimeIntervalSchedule().onEveryDay().endingDailyAt(TimeOfDay)*/
                            /*CalendarIntervalScheduleBuilder.calendarIntervalSchedule().withIntervalInDays(1)*/
                    ).build();

            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.scheduleJob(trigger2);
            TimeUnit.SECONDS.sleep(5);
            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}