
package world;

public class CombatCat extends Cat{
    
    public CombatCat (String N, String NAc) {Health = 100; Name = N; NameAc =NAc; NameClass = "Боевой кот"; NameClassAc = "Боевого кота";}
    
    public void SavageBlow(Creature s){
        System.out.println(NameClass  +" "+ Name + " свирепо ударил " + s.NameClassAc  +" "+  s.NameAc);
        s.handler(Actions.BLOW);
    }
    
}
