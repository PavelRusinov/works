
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
        } while (pr != res);
        return res;
    }
}
