
package multmatr;

public class Main {

    public static void main(String[] args) throws Exception {
        Mult m = new Mult();
        int[][] a = {{1,2,3},{1,2,3},{1,2,3},{1,2,3}};
        int[][] b = {{6,6,6,6},{6,6,6,6},{6,6,6,6}};
        int [][]res = m.multMatr(a, b);
        
         for(int []x : res) {
            for(int i = 0; i < x.length; i++) {
                System.out.print(x[i]+" ");
            }
            System.out.println();
        }
    }
}
