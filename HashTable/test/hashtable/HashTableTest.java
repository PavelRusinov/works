
package hashtable;

import static org.junit.Assert.*;
import org.junit.Test;

public class HashTableTest {
    
    public HashTableTest() {
    }

    
    @Test
    public void testPutInt() {
        System.out.println("");
        Integer a[] = {10,20,30,40,50};
        String s[] = {"10","20","30","40","50"};
        HashTable<Integer> instance = new HashTable(100);
        int i;
        System.out.println("put");
        for(i=0;i<5;i++){
            System.out.println("put");
            instance.put(s[i],a[i]);
        }
        
        for(i=0;i<5;i++){
            System.out.println("get "+i);
            int result = instance.get(s[i]);
            int expResult = a[i];
            instance.delete(s[i]);
            assertEquals(expResult, result);
        }
        
        for(i=0;i<5;i++){
            System.out.println("get null");
            Integer result = instance.get(s[i]);
            assertNull(result);
        }
    }

}
