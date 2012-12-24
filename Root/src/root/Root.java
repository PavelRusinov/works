
package root;

public class Root {
    private final double delta = 0.0000000001;
    public double getRoot(double numb) throws Exception{
        if(numb < 0) {
            throw new IllegalArgumentException("число меньше 0");
        }
        if(numb == 0){
            return 0;
        }
        double res = numb/2;
        double pr;
        do{
            pr = res;
            res = (res + numb/res)/2;
        } while (Math.abs(pr - res) > delta*pr);
        return res;
    }
    
    public double getDelta(){
        return delta;
    }
}
