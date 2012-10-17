
package world;

public class HealerCat extends Cat{
    
    public HealerCat (String N, String NAc) {
        Health = 100; 
        Name = N; 
        NameAc = NAc; 
        NameClass = "Лечебный кот"; 
        NameClassAc = "Лечебного кота";
        State = States.ALIVE;
        System.out.println("создан " + NameClass +" " + Name);
    }
    
    @Override
    public void action(Actions a, Creature s) {
        switch (a){
            case ATTACK: System.out.println(NameClass +" " + Name + " атакует " +s.NameClassAc  +" "+ s.NameAc);
                         break;
                
            case EAT: if(s.State == States.DEAD){
                          System.out.println(NameClass + " " + Name + " cъел " + s.NameClassAc + " " + s.NameAc);
                      }
                      else {
                          System.out.println(NameClass  + " " + Name + " попытался съесть " + s.NameClassAc + " " + s.NameAc);
                      }
                      break;
            
            case MEOW: System.out.println (NameClass  +" "+ Name + " мяукает на " + s.NameClassAc +" "+ s.NameAc);
                       break;
                
            case HISS: System.out.println (NameClass  +" "+ Name + " шипит на " + s.NameClassAc +" "+ s.NameAc);
                       break;
                
            case HEAL: System.out.println(NameClass  +" "+ Name + " исцелил " + s.NameClassAc  +" "+  s.NameAc);
                       break;
            
            default: System.out.println(NameClass  +" "+ Name + "не смог"); break;
        }
    }
    
    public void heal(Creature s){
        if (State != States.DEAD) {
            this.action(Actions.HEAL, s);
            s.handler(Actions.HEAL, this);
        }
    }
}
