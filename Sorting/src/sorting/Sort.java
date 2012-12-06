package sorting;

public class Sort {
    
    Compare c;
       
    public void sort(Object []m, Compare c) {
        if (c != null && m != null) {
            this.c = c;
            qSort(m, 0, m.length - 1);
        }
    }
    
            
    public void qSort(Object[] A, int low, int high) {
      int i = low;
      int j = high;
      Object x = A[low + (high - low)/2];
      do {
          while(c.compare(A[i], x) == ComRes.LT) {++i;} /*A[i] < x*/
          while(c.compare(A[i], x) == ComRes.GT) {--j;}  /*A[j] > x*/
          if(i <= j){
              Object temp = A[i];
              A[i] = A[j];
              A[j] = temp;
              i++; j--;
          }
      } while(i <= j);
 
      if(low < j) {qSort(A, low, j);}
      if(i < high) {qSort(A, i, high);}
  }
}
