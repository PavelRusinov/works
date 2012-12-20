
package partly.cloudy;

public class TestDaylight implements IDaylight{

    private DaylightType result;
    
    public TestDaylight(DaylightType a){
        result = a;
    }
    
    @Override
    public DaylightType current() {
        return result;
    }
    
}
