
package hashtable;

public class Elem<type>{
   protected String key;
   protected type data;
   
   public Elem(String k, type d){
       key = k;
       data = d;
   }
   
   public String getKey(){
      return key;
   }
   
   public type getData(){
       return data;
   }
   
   public void setData(type d){
       data = d;
   }
}
