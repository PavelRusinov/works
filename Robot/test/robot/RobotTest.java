package robot;

import static org.junit.Assert.*;
import org.junit.Test;

public class RobotTest {
    
    public RobotTest() {
    }

    @Test
    public void beg() {
        System.out.println("(x,y) = (0,0)");
        int x = 0;
        int y = 0;
        Robot instance = new Robot();
        int expResult = 1;
        int result = instance.getNumbWays(x, y);
        assertEquals(expResult, result);
    }
    @Test
    public void point() {
        System.out.println("(x,y) = (4,5)");
        int x = 4;
        int y = 5;
        Robot instance = new Robot();
        int expResult = 126;
        int result = instance.getNumbWays(x, y);
        assertEquals(expResult, result);
    }
}
