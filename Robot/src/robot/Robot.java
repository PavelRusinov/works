
package robot;

public class Robot {
    private int fact(int x){
        if(x == 1 | x == 0) {return 1;}
        return x * fact(x-1);
    }
    
    public int getNumbWays(int x, int y){
        x = Math.abs(x);
        y = Math.abs(y);
        x = x + y;
        return fact(x)/(fact(y)*fact(x-y));
    }
}
