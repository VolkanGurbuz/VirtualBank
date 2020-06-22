import com.volkangurbuz.verifysystem.VerifysystemApplication
import com.volkangurbuz.verifysystem.domain.Person
import com.volkangurbuz.verifysystem.utilities.Util
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = VerifysystemApplication.class)
class VerificationTest extends Specification {


    def "person id verification success test"() {
        given: "util and person classes initialize"
        def personVerifyUtil = new Util()
        def person = new Person("123123", "VOLKAN", "GÜRBÜZ", "XX")
        def personBody = personVerifyUtil.sendMessage(person)

        when:
        def isValid = personVerifyUtil.isValid(personBody)
        //should be true with the right person information
        then:
        isValid == true


    }


    def "person id verification unsuccess test"() {
        given: "util and person classes initialize"
        def personVerifyUtil = new Util()
        def person = new Person("454646", "VOLKAN", "GÜRBÜZ", "34324")
        def personBody = personVerifyUtil.sendMessage(person)

        when:
        def isValid = personVerifyUtil.isValid(personBody)

        then:
        isValid == false

    }


}