
package multmatr;


public class MultNotPar {
    private int[] MultRaw(int[] a, int[][] b){
        int i,j,k;
            int res[];
            res = new int[b[0].length];
            for(i = 0; i < b[0].length; i++){
                k = 0;
                for(j = 0; j < a.length; j++){
                    k += a[j]*b[j][i];
                }
                res[i] = k;
            }
            return res;
    }
    
    public int[][] multMatr(int [][]a, int [][]b){
        int [][] r = new int[a.length][b[0].length];
        for(int i = 0; i < a.length; i++){
            r[i] = MultRaw(a[i], b);
        }
        return r;
    }
}
