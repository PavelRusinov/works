package sorting;

public class Sort {
    
    Compare c;
       
    public void sort(Object []m, Compare c) {
        if (c != null && m != null) {
            this.c = c;
            Sort(m);
        }
    }
    
            
    private void Sort(Object[] A) {
        int i;
        int j;
        int minNumb;
        Object min;
        
        for (i = 0; i < A.length - 1; i++){
            min = A[i];
            minNumb = i;
            for(j = i; j < A.length; j++){
                if(c.compare(A[j],A[i]) == ComRes.LT){ /*A[j] < A[i]*/
                    min = A[j];
                    minNumb = j;
                }
            }
            if(minNumb != i){
                Object temp = A[i];
                A[i] = A[minNumb];
                A[minNumb] = temp;
            }
        }
          
  }
}
