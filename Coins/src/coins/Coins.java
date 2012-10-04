
package coins;

public class Coins {
    
    private int countWays(int sum, int[] coins, int coinsNumb){
        if (sum == 0){
            return 1;
        }
        if (sum < 0) {
            return 0;
        }
        if (coinsNumb == 0){
            return 0;
        }
        return countWays(sum, coins, coinsNumb - 1) + countWays(sum - coins[coins.length - coinsNumb], coins, coinsNumb);
    }
    
    public int search(int sum, int[] coins) throws Exception{
        int i;
        for (i = 0; i < coins.length; i++){
            if(coins[i] <= 0){
                throw new Exception("Illegal argument");
            }
        }
        if(sum <= 0){
            throw new Exception("Illegal argument");
        }
            
        return countWays(sum, coins, coins.length);
    }
}
