
package partly.cloudy;

import java.util.Random;

public class Luminary implements ILuminary{
    private Random r = new Random();
    
    @Override
    public boolean isShining(){
        return r.nextBoolean();
    }
}
