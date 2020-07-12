package com.volkangurbuz.controller

import com.volkangurbuz.customercreationservice.controller.CustomerController
import com.volkangurbuz.customercreationservice.controller.RestResponseEntityExceptionHandler
import com.volkangurbuz.customercreationservice.domain.Customer
import com.volkangurbuz.customercreationservice.services.CustomerService
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.ui.Model
import spock.lang.Specification

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class CustomerControllerTest extends Specification {

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    @Mock
    Model model;

    MockMvc mockMvc;

    def setup() {
        MockitoAnnotations.initMocks(this)

        // we do not need this anymore
        // controller = new CustomerController(customerService);

        mockMvc =
                MockMvcBuilders.standaloneSetup(customerController)
                        .setControllerAdvice(new RestResponseEntityExceptionHandler())
                        .build();

    }


    def "create customer test"() {
        given: "given customer"
        Customer test = new Customer();
        test.setName("test")
        test.setPassword("13212")

        when:
        customerController.Add(test, model)

        then:
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/customers/register/"))
                .andExpect(status().isCreated())

    }

    def "fail test creating customer"() {
        given: "given customer"
        Customer test = new Customer();
        test.setName("test")
        test.setPassword("13212")

        when:
        customerController.Add(test, model)

        then:
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/customers/register11"))
                .andExpect(status().is4xxClientError())

    }


}