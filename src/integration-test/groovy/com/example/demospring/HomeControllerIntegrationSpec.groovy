package com.example.demospring

import com.example.demospring.controller.HomeController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class HomeControllerIntegrationSpec extends Specification{

    @Autowired HomeController controller

    def "test something"(){
        when:
        String result = controller.index()

        then:
        result == "home"
    }

}
