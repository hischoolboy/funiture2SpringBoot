package io.hischoolboy.common;

import io.hischoolboy.schedule.AutoRegisterScheduleJob;
import io.hischoolboy.schedule.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Slf4j
@Component("applicationContextHelper")
public class ApplicationContextHelper implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringHelper.setApplicationContext(applicationContext);
        InitData.start();
        AutoRegisterScheduleJob.registerWhenStartUp();
        ScheduleService scheduleService = SpringHelper.popBean(ScheduleService.class);
        scheduleService.scheduleAll();
    }
}