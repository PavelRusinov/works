
package partly.cloudy;

import java.util.Random;

public class Wind implements IWind{
    private Random r = new Random();
    
    @Override
    public int WindStrength(){
        return r.nextInt() % 10;
    }
}
