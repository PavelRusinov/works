
package multmatr;

public class Main {

    public static void main(String[] args) throws Exception {
        Mult m = new Mult();
        MultNotPar mp = new MultNotPar();
        /*int[][] a = {{1,2,3},{1,2,3},{1,2,3},{1,2,3}};
        int[][] b = {{6,6,6,6},{6,6,6,6},{6,6,6,6}};
        int [][]res = m.multMatr(a, b);
        
        for(int []x : res) {
            for(int i = 0; i < x.length; i++) {
                System.out.print(x[i]+" ");
            }
            System.out.println();
        }*/
        int[][] a = new int[1000][1000];
        int[][] b = new int[1000][1000];
        int i,j;
        for(i = 0; i< 1000; i++){
            for(j = 0; j<1000; j++){
                a[i][j]= 4;
                b[i][j]= 4;
            }
        }
        int[][] c = mp.multMatr(a, b);
    }
}
