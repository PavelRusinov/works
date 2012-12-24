
package multmatr;

import static org.junit.Assert.*;
import org.junit.Test;

public class MultTest {
    
    public MultTest() {
    }

    
    @Test (expected = IllegalArgumentException.class)
    public void testMultNullMatr() {
        System.out.println("mult Null Matrices");
        int[][] a = null;
        int[][] b = null;
        Mult instance = new Mult();
        instance.multMatr(a, b);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testIncorrectMatr1() {
        System.out.println("Mult Incorrect Matrices  1");
        int [][]a = {{1,2},
                     {3,4},
                     {5,6}
                    };
        int [][]b = {{1,2},
                     {3,4},
                     {5,6}
                    };
        Mult instance = new Mult();
        instance.multMatr(a, b);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testIncorrectMatr2() {
        System.out.println("Mult Incorrect Matrices 2");
        int [][]a = {{1,2,3},
                     {4,5,8},
                     {7,8,7,5}
                    };
        int [][]b = {{1,2},
                     {4,5},
                     {7,8}
                    };
        Mult instance = new Mult();
        instance.multMatr(a, b);
    }
    @Test
    public void testCorrectMatr() {
        System.out.println("Mult Correct Matrices");
        int [][]a = {{1,2,3,4},
                     {5,6,7,8},
                     {9,10,11,12}
                    };
        int [][]b = {{1,2,3},
                     {4,5,6},
                     {7,8,9},
                     {10,11,12}
                    };
        Mult instance = new Mult();
        int [][]expResult = {{70,80,90},
                             {158,184,210},
                             {246,288,330}
                            };
        int [][]result = instance.multMatr(a, b);
        
        for (int i = 0; i < result.length; i++) {
            assertArrayEquals(expResult[i], result[i]);
        }
    }
}
