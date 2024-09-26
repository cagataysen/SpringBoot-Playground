package com.example.spring_boot_logging.api;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogEndpoint {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public String getDetails(){
        log.debug("get details method has been started");
        return internalLogDetail();
    }

    private String internalLogDetail() {
        try{
            log.debug("internalLogDetail method has been started");
            Thread.sleep(1000);
            return "API message";
        } catch (InterruptedException e){
            log.error("Error : {}", e);
        }
        return "";
    }

    /*
    * - Logging should be async (due to performance)
    * - printStackTrace and System.out.println() shouldn't be used. (format)
    * - Sensitive data (id, pwd) shouldn't be used.
    * - All logs should be collected in a central place, in defined formatting.
    * - Levels should be used carefully.
    * - In different levels, different appenders can be used
    * */

}
