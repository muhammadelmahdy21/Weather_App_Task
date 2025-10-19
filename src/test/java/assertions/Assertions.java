package assertions;

import org.testng.Assert;

public class Assertions {

    public void assertCompare(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    public void assertElementExist(boolean element)
    {
        Assert.assertTrue(element);
    }

    public void assertElementNotExist(boolean element) { Assert.assertFalse(element); }
}
