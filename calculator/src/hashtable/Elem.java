
package hashtable;

public class Elem {
   protected String key;
   protected Object data;
   
   public Elem(String k, Object d){
       key = k;
       data = d;
   }
   
   public String getKey(){
      return key;
   }
   
   public Object getData(){
       return data;
   }
   
   public void setData(Object d){
       data = d;
   }
}
