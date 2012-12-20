
package partly.cloudy;

public class TestLuminary implements ILuminary{

    private boolean result;
    
    public TestLuminary(boolean a){
        result = a;
    }
    
    @Override
    public boolean isShining() {
        return result;
    }
    
}
