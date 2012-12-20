
package str;

import hashtable.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StringWork {
    private HashTable<Integer> table;
    public StringWork(int size){
        table = new HashTable(size);
    }
    
    public void add(String s){
        s = s.toLowerCase();
        Integer n = table.get(s);
        if(n == null){
            table.put(s, 1);
        }
        else{
            table.put(s, n+1);
        }
    }
    
    public int get(String s) {
        if (s == null) {
            return 0;
        } else {
            s = s.toLowerCase();
            Integer e = table.get(s);
            
            if (e != null) {
                return e;
            }
            
            return 0;
        }
    }
    
    public void read(String fname) throws FileNotFoundException, IOException{
        BufferedReader f;
        f = new BufferedReader(new FileReader(fname));
        int c;
        String key = "";
        c = f.read();
        while(c != -1){
            while(Character.isLetterOrDigit(c)){
                key = key + Character.toString((char)c);
                c = f.read();
            }
            c = f.read();
            if(!key.equals("")){
                add(key);
                key = "";
            }
        }
        f.close();
    }
    public void showDistribution(){
        table.distr();
    }
}
