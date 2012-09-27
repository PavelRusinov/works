
package world;

public class HealerCat extends Cat{
    
    public HealerCat (String N, String NAc) {Health = 100; Name = N; NameAc =NAc; NameClass = "Лечебный кот"; NameClassAc = "Лечебного кота";}
    
    public void heal(Creature s){
        System.out.println(NameClass  +" "+ Name + " исцелил " + s.NameClassAc  +" "+  s.NameAc);
        s.handler(Actions.HEAL);
    }
}
