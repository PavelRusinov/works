
package hashtable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HashTable<type> {
    private List<List<Elem<type>>> table = new ArrayList<>();
    int size;
    
    public HashTable(int _size){
        size = _size;
        int i;
        for(i = 0; i < size; i++){
            table.add(new ArrayList<Elem<type>>());
        }
    }
    
    private int hashFunc(String s){
        long hash = 5381;
        int len = s.length();
        for(int i = 0; i < len; i++) {
            hash = ((hash << 5) + hash) + s.charAt(i);
        }
        
        return Integer.parseInt(Long.toString(Math.abs(hash % size)));
    }
    
    public void distr(){
        int min = Integer.MAX_VALUE;
        int max = 0 ;
        int numwords = 0;
        int n = 0;
        double stand_dev = 0.0f;
        double avdev = 0.0f;
        List<Integer> wordsNumb = new ArrayList<>(size);
        for(List<Elem<type>> list : table)
        {
            for(Elem elem : list)
            {
                n ++;
            }
            numwords += n;
            wordsNumb.add(n);
            if (n > max)
            {
                max = n;
            }
            if (n < min)
            {
                min = n;
            }
            n = 0;
        }
        for(Integer i : wordsNumb)
        {
            avdev += i - numwords/size;
            stand_dev += (i - numwords/size)^2;
        }
        stand_dev = (double) Math.sqrt(stand_dev/size);
        System.out.println("number of words: " + Integer.toString(numwords));
        System.out.println("min:" + Integer.toString(min));
        System.out.println("max:" + Integer.toString(max));
        System.out.println("average:" + Float.toString(numwords/size));
        System.out.println("average dev:" + Double.toString(avdev/size));
        System.out.println("standart dev:" + Double.toString(stand_dev));
    }
    
    public void put(String s, type el){
        if (s != null) {
           int hash = hashFunc(s); 
           List<Elem<type>> list;
           list = table.get(hash);
           
           if (table.get(hash).isEmpty()) {
                list.add(new Elem(s, el));
           } 
           else {
                for(Elem<type> e : list) {
                    if (s.equals(e.key)) {
                        e.data = el;
                        return;
                    }
                }
                list.add(new Elem(s, el));
           }
        }
    }
    
    public type get(String s){
        if (s != null) {
           int hash = hashFunc(s); 
           List<Elem<type>> list;
           
           list = table.get(hash);
           if (list.isEmpty()) {
               return null;
           } else {
               for(Elem<type> e : list) {
                    if (s.equals(e.key)) {
                        return e.getData();
                    }
                }
           }
                   
        }
        return null;
    }
    
    public boolean isInTable(String s){
       if (s != null){
           int hash = hashFunc(s);
           if(table.get(hash).isEmpty()){
               return false;
           }
           else{
              List<Elem<type>> list = table.get(hash); 
              for(Elem e:list){
                  if (s.equals(e.key)) {
                        return true;
                  }
              }
              return false;
           }
       }
       return false;
    }
    
    public void delete(String s){
         if (s != null) {
           int hash = hashFunc(s); 
           List<Elem<type>> list = table.get(hash);
           
           if (!list.isEmpty()) {
               Iterator i = list.iterator(); 
               Elem<type> e;
                
               while(i.hasNext()) {
                    e = (Elem<type>)i.next();
                    if (s.equals(e.key)) {
                        i.remove();
                        return;
                    }
                }
           }
        }
    }
    
    public void clear() {
        if (!table.isEmpty()) {
            table.clear();
        }
    }
    
}
