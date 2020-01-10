package com.krokofillLl.singlePageApp;

import com.krokofillLl.singlePageApp.service.JsoupService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        if(args.length > 0) {
            switch (args[0]) {
                case "loadTags" :
                 JsoupService.setAddTags(true);
                 break;

            }
        }
    }

}
