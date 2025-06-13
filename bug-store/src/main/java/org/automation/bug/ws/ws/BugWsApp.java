package org.automation.bug.ws.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by shantonu on 12/18/16.
 */
@EnableTransactionManagement
//@EnableCaching
@SpringBootApplication
public class BugWsApp {
    public static void main(String[] args) {
        SpringApplication.run(BugWsApp.class, args);
        System.out.println("Bug storing web service is running");
    }

/*
    public <K,V> void Compute(K key, BiFunction<?super K, ? super V, ? extends V> remappingFunction){

    }*/

}
