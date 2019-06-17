import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void constructorTest() {
        Integer age = 21;
        Double wallet = 100.0;
        String name = "Foo";
        Person p = new Person(wallet, name, age);
        assertNotNull(p);
        Integer actualAge = p.getAge();
        assertEquals(age, actualAge);
        Double actualWallet = 100.0;
        assertEquals(wallet, actualWallet);
        String actualName = p.getName();
        assertEquals(name, actualName);
    }
}