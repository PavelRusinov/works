
package braces;

import java.util.ArrayList;

public class Stack {
    private int head;
    private ArrayList<Braces> list;
    
    public Braces pop() throws Exception{
        if (head < 0){
            return Braces.NONE;
        }
        Braces value = list.get(head);
        head--;
        return value;
    }
    
    public void push(Braces a){
        head++;
        list.add(head, a);
    }
    
    public Stack () {
        list = new ArrayList<>();
        head = -1;
    }
}
