
package world;

public class Creature {
       
    protected int Health;
    protected String Name;
    protected String NameAc;
    protected String NameClass;
    protected String NameClassAc;
    protected States State;
    
    public void handler(Actions a){};
    
    public void eat(Creature s){
        if(s.State == States.DEAD){
            System.out.println(NameClass + " " + Name + " cъел " + s.NameClassAc + " " + s.NameAc);
        }
        else {
            System.out.println(NameClass  + " " + Name + " попытался съесть " + s.NameClassAc + " " + s.NameAc);
        }
        s.handler(Actions.EAT);
    }
    
    public void attack(Creature s) {
        System.out.println(NameClass +" " + Name + " атакует " +s.NameClassAc  +" "+ s.NameAc);
        s.handler(Actions.ATTACK);
    }
        
}
