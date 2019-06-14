import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void constructorTest() {
        Person p = new Person(100.0, "Foo Bar", 21);
        assertNotNull(p);
    }
}