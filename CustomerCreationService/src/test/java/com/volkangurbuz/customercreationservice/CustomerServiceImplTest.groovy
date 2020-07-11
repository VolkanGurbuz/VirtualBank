package com.volkangurbuz.customercreationservice

import com.volkangurbuz.customercreationservice.domain.Customer
import com.volkangurbuz.customercreationservice.repositories.CustomerRepository
import com.volkangurbuz.customercreationservice.services.CustomerServiceImpl
import com.volkangurbuz.customercreationservice.utilities.results.Result
import org.junit.Before
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification


class CustomerServiceImplTest extends Specification {

    @Mock
    CustomerRepository customerRepository;

    CustomerServiceImpl customerService;


    def setup() {
        MockitoAnnotations.initMocks(this);
        customerService = new CustomerServiceImpl(customerRepository);
    }

    def "test create new customer"() {
        given: "customer creating"
        Customer customer = new Customer();
        customer.setName("test")
        customer.setPassword("1324")

        when:
        Result result = customerService.addCustomer(customer)

        then:
        assert true == result.success;

    }
    
}

