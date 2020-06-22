import com.sun.org.apache.regexp.internal.RE
import com.volkangurbuz.verifysystem.VerifysystemApplication
import com.volkangurbuz.verifysystem.controller.VerifyController
import com.volkangurbuz.verifysystem.domain.Person
import com.volkangurbuz.verifysystem.services.VerifyService
import com.volkangurbuz.verifysystem.utilities.results.Result
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

import static org.mockito.Mockito.when;
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view

@SpringBootTest(classes = VerifysystemApplication.class)
class VerificationController extends Specification {


    @Mock
    VerifyService service;

    VerifyController controller;

    def setup() {

        MockitoAnnotations.initMocks(this);
        controller = new VerifyController(service);

    }


    def "controllerTest"() {

        given: "initialize"
        def person = new Person();
        person.setName("volkan")
        person.setSurname("gurbuz")
        person.setTcNo("18454225214")
        person.setBirthday("1989")
        def mockMvc = MockMvcBuilders.standaloneSetup(controller).build();


        when(service.verifyPerson(person))


        mockMvc
                .perform(MockMvcRequestBuilders.get("/verify"))
                .andExpect(status().isOk())


    }


}