
package world;

public class Creature {
       
    protected int Health;
    protected String Name;
    protected String NameAc;
    protected String NameClass;
    protected String NameClassAc;
    protected States State;
    
    public void handler(Actions a, Creature c){};
    public void action(Actions a, Creature c){};
    
    public void eat(Creature s){
        this.action(Actions.EAT, s);
        s.handler(Actions.EAT, this);
    }
    
    public void attack(Creature s) {
        this.action(Actions.ATTACK, s);
        s.handler(Actions.ATTACK, this);
    }
        
}
