
package multmatr;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Mult {
   
    private class MultThread implements Callable <int[]>{
        int[] a;
        int[][] b;
        public MultThread(int[] a, int[][] b){
            this.a = a;
            this.b = b;
        }
        
        @Override
        public int[] call() {
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
    
    }
    
    private boolean checkMatr(int [][]a, int [][]b) {
        if (a == null || b == null || a.length == 0 || b.length == 0) {
            return false;
        }
        int len = a[0].length;
        for(int i = 1; i < a.length; i++) {
            if (len != a[i].length) {
                return false;
            }
        }
        len = b[0].length;
        for(int i = 1; i < b.length; i++) {
            if (len != b[i].length) {
                return false;
            }
        }
        if (a[0].length != b.length) {
            return false;
        }
        return true;
    }
    
    public int[][] multMatr(int [][]a, int [][]b) throws IllegalArgumentException{
        if(!checkMatr(a,b)){
            throw new IllegalArgumentException();
        }
        
        ExecutorService ex;
        ex = Executors.newCachedThreadPool();
        ArrayList<Future<int[]>> res = new ArrayList<>();
        int [][] r = new int[a.length][b[0].length];
        int k = -1;
        
        for(int i = 0; i < a.length; i++) {
            res.add(ex.submit(new MultThread(a[i], b)));
        }
        
        for(Future<int[]> f : res) {
            try {
                k++;
                r[k] = f.get();
            } 
            catch (InterruptedException | ExecutionException e) {} 
        }
        ex.shutdown();
        return r;
    }
}
