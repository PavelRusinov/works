
package coins;

import static org.junit.Assert.*;
import org.junit.Test;

public class CoinsTest {
    
    public CoinsTest() {
    }

    
    @Test(expected = IllegalArgumentException.class)
    public void zeroSum() throws Exception {
        System.out.println("sum = 0");
        int sum = 0;
        int[] coins = {1,2};
        Coins instance = new Coins();
        int result = instance.search(sum, coins);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void incorCoins() throws Exception {
        System.out.println("coin = -1");
        int sum = 4;
        int[] coins = {1,2,-1};
        Coins instance = new Coins();
        int result = instance.search(sum, coins);
    }
    @Test
    public void correct() throws Exception {
        System.out.println("correct");
        int sum = 4;
        int[] coins = {1,2,4};
        int expResult = 4;
        Coins instance = new Coins();
        int result = instance.search(sum, coins);
        assertEquals(expResult, result);
    }
}
