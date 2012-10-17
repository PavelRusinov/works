
package world;

public class Dog extends Creature{
    
    public Dog (String N, String NAc) {
        Health = 100; 
        Name = N; 
        NameAc = NAc; 
        NameClass = "Пёс"; 
        NameClassAc = "Пса";
        State = States.ALIVE;
        System.out.println("создан " + NameClass +" " + Name);
    }
    
    @Override
    public void handler(Actions a, Creature s) {
        if (State != States.DEAD) {
            
            switch (a){
                case ATTACK: Health = Health - 20; 
                             System.out.println(NameClass  +" "+ Name +": Здоровье " + Health); 
                             break;

                case HEAL: Health = Health + 20; 
                           System.out.println(NameClass  +" "+ Name +": Здоровье " + Health); 
                           System.out.println(NameClass  +" "+ Name +" поблагодарил " + s.NameClassAc +" "+ s.NameAc);
                           break;

                case BLOW: Health = Health - 40; 
                           System.out.println(NameClass  +" "+ Name +": Здоровье " + Health);
                           break;

                case EAT: if (State != States.DEAD) {
                    growl(s); bark(s);
                } 
                break;
            }

            if(Health <= 0 && State != States.DEAD){
                State = States.DEAD;
                System.out.println(NameClass +" " + Name + " умер");
            }
        }
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
            
            case BARK: System.out.println (NameClass  +" "+ Name + " гавкает на " + s.NameClassAc +" "+ s.NameAc);
                       break;
                
            case GROWL: System.out.println (NameClass  +" "+ Name + " рычит на " + s.NameClassAc +" "+ s.NameAc);
                       break;
            default: System.out.println(NameClass  +" "+ Name + " не смог"); break;
        }
            
            
    }
    
    public void bark(Creature s) {
        if (State != States.DEAD) {this.action(Actions.BARK, s);}
    }
    
    public void growl(Creature s) {
        if (State != States.DEAD) {this.action(Actions.GROWL, s);}
    }
    
}

