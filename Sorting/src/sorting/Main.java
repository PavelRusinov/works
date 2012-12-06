
package sorting;

public class Main {
    
    public static void main(String[] args) {
        Integer []m = {2,7,5,3,0,12,45};
        Sort s = new Sort();
        s.sort(m, new MCompare());
        for(int i = 0; i < m.length; i++) {
            System.out.print(m[i] + " ");
        }
    }
}
