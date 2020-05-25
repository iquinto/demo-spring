package com.example.demospring

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification


@SpringBootTest(classes = DemoSpringApplication.class)
class HomeIntegrationSpec extends Specification{

    def "test something"(){
        expect:
        true
    }

}
