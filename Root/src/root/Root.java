
package root;

public class Root {
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
        } while (Math.abs(pr - res) > 0.0000001*pr);
        return res;
    }
}
