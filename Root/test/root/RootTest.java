
package root;

import static org.junit.Assert.*;
import org.junit.Test;

public class RootTest {
    
    public RootTest() {
    }

    @Test
    public void Zero() throws Exception {
        System.out.println("numb = 0");
        double numb = 0.0;
        Root instance = new Root();
        double expResult = 0.0;
        double result = instance.getRoot(numb);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void NegNumber() throws Exception {
        System.out.println("numb = -2");
        double numb = -2;
        Root instance = new Root();
        double result = instance.getRoot(numb);
    }
    
    @Test
    public void Numbers() throws Exception {
        System.out.println("numbers");
        double numb[] = {0.001, 1.0e20, 1.0e50, 3, 245};
        Root instance = new Root();
        boolean result = true;
        boolean expResult = true;
        for(double t:numb){
        result = result && (instance.getRoot(t) == Math.sqrt(t));
        }
        assertEquals(expResult, result);
    }
}
