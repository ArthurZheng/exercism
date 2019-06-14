import org.junit.Test
import kotlin.test.assertEquals

class HelloWorldTest {

    @Test
    fun helloWorldTest() {
        assertEquals("Hello, World!", hello())
    }

    @Test
    fun greetingTest(){
        assertEquals("Hello Jun", greeting("JUN"))
    }

}
