
package hashtable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HashTable {
    private List<List<Elem>> table = new ArrayList<>();
    int size;
    
    public HashTable(int _size){
        size = _size;
        int i;
        for(i = 0; i < size; i++){
            table.add(new ArrayList<Elem>());
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
    
    public void put(String s, Object el){
        if (s != null) {
           int hash = hashFunc(s); 
           List<Elem> list;
           
           if (table.get(hash).isEmpty()) {
                list = table.get(hash);
                list.add(new Elem(s, el));
           } else {
                list = table.get(hash);
                for(Elem e : list) {
                    if (s.equals(e.key)) {
                        e.data = el;
                        return;
                    }
                }
                list.add(new Elem(s, el));
            }
        }
    }
    
    public Elem get(String s){
        if (s != null) {
           int hash = hashFunc(s); 
           List<Elem> list;
           
           list = table.get(hash);
           if (list.isEmpty()) {
               return null;
           } else {
               for(Elem e : list) {
                    if (s.equals(e.key)) {
                        return e;
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
              List<Elem> list = table.get(hash); 
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
           List<Elem> list = table.get(hash);
           
           if (!list.isEmpty()) {
               Iterator i = list.iterator(); 
               Elem e;
                
               while(i.hasNext()) {
                    e = (Elem)i.next();
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
