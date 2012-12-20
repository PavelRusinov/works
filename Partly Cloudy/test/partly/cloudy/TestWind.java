
package partly.cloudy;

public class TestWind implements IWind{
    private int result;
    
    public TestWind(int a){
        result = a;
    }
    
    @Override
    public int windStrength() {
        return result;
    }
    
}
