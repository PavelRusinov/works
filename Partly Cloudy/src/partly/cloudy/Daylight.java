
package partly.cloudy;

import java.util.Random;

public class Daylight implements IDaylight{
    private Random r = new Random();
    
    @Override
    public DaylightType current(){
        int i = r.nextInt() % 4;
        switch(i){
            case 0: return DaylightType.Evening;
            case 1: return DaylightType.Morning;
            case 2: return DaylightType.Noon;
            case 3: return DaylightType.Night;
        }
        return DaylightType.Evening;
    }
}
