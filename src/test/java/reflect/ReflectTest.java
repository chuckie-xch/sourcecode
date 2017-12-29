package reflect;

import model.Person;
import org.junit.Test;

/**
 * 测试Java反射
 *
 * @author xch
 * @version 1.00
 * @date 2017-12-28
 */
public class ReflectTest {

    @Test
    public void testGetCallClass() {
        Person person = new Person();
        person.printCallClass();
    }


}
