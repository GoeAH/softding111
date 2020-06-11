package com.softding.business.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author xian
 * @Date 20/5/11 16:30
 */
@Slf4j
@Component
public class OnStartedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null){
           // log.warn("spring启动完成!");
        }

    }
}
