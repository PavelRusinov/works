
package sorting;

import static org.junit.Assert.*;
import org.junit.Test;

public class SortTest {
    
    public SortTest() {
    }
    
    @Test
    public void NullListSort() {
        System.out.println("NullListSort");
        Object[] m = null;
        Compare c = null;
        Sort instance = new Sort();
        instance.sort(m, c);
        assertNull(m);
    }
    
    @Test
    public void ListSort() {
        System.out.println("ListSort");
        Object[] m = {9,8,7,6,5,4,3,2,1};
        Object[] sm = {1,2,3,4,5,6,7,8,9};
        Compare c = new MCompare();
        Sort instance = new Sort();
        instance.sort(m, c);
        assertArrayEquals(sm, m);
    }
    
    @Test
    public void ListOneElemSort() {
        System.out.println("ListOneElemSort");
        Object[] m = {2};
        Object[] sm = {2};
        Compare c = new MCompare();
        Sort instance = new Sort();
        instance.sort(m, c);
        assertArrayEquals(sm, m);
    }
}
