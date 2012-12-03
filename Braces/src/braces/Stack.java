
package braces;

import java.util.ArrayList;

public class Stack {
    private int head;
    private ArrayList<Brace> list;
    
    public Brace pop() throws Exception{
        if (head < 0){
            return new Brace(BraceType.NONE);
        }
        Brace value = list.get(head);
        head--;
        return value;
    }
    
    public void push(Brace a){
        head++;
        list.add(head, a);
    }
    
    public Stack () {
        list = new ArrayList<>();
        head = -1;
    }
}
