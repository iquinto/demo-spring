package com.example.demospring

import com.example.demospring.controller.HomeController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

@WebMvcTest(controllers = [HomeController])
@AutoConfigureMockMvc
class HomeControllerSpec extends Specification {

    @Autowired
    private MockMvc mockMvc


    def setup() {
    }

    def "test something"(){
        expect:
        true
    }


}


