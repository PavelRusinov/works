package world;


public class Cat extends Creature {
    
    @Override
    public void handler(Actions a) {
        switch (a){
            case ATTACK: Health = Health - 20; System.out.println(NameClass  +" "+ Name +": Здоровье " + Health); break;
            case HEAL: Health = Health + 20; System.out.println(NameClass  +" "+ Name +": Здоровье " + Health); break;
            case BLOW: Health = Health - 40; System.out.println(NameClass  +" "+ Name +": Здоровье " + Health); break;
            case EAT: if(State != States.DEAD){hiss(); meow();} break;
        }
        if(Health <= 0 && State != States.DEAD){
            State = States.DEAD;
            System.out.println(Name + " умер");
        }
    }
    
    public void meow() {
        System.out.println(NameClass  +" "+ Name + " мяукает");
    }
    
    public void hiss() {
        System.out.println(NameClass  +" "+ Name + " шипит");
    }
    
}
