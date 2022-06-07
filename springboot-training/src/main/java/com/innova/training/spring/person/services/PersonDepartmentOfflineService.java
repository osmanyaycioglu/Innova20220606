package com.innova.training.spring.person.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PersonDepartmentOfflineService {

    @Scheduled(fixedDelay = 24*60*60*1000,initialDelay = 1_000)
    public void readDepartment(){
        System.out.println("Çalıştı");
        // Read işlemi sync db
    }

}
