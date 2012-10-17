package world;


public class Cat extends Creature {
    
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

                case EAT: if(State != States.DEAD){
                              hiss(s); meow(s);
                          } 
                          break;
            }
        }
        
        if(Health <= 0 && State != States.DEAD){
            State = States.DEAD;
            System.out.println(Name + " умер");
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
            
            case MEOW: System.out.println (NameClass  +" "+ Name + " мяукает на " + s.NameClassAc +" "+ s.NameAc);
                       break;
                
            case HISS: System.out.println (NameClass  +" "+ Name + " шипит на " + s.NameClassAc +" "+ s.NameAc);
                       break;
            
            default: System.out.println(NameClass  +" "+ Name + " не смог"); break;
        }
            
            
    }
        
    public void hiss(Creature s) {
       if (State != States.DEAD) {this.action(Actions.HISS, s);}
    }
    
    public void meow(Creature s) {
        if (State != States.DEAD) {this.action(Actions.MEOW, s);}
    }
}
