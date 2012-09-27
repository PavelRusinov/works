
package world;

public class Dog extends Creature{
    
    public Dog (String N, String NAc) {Health = 100; Name = N; NameAc =NAc; NameClass = "Пёс"; NameClassAc = "Пса";}
    
    @Override
    public void handler(Actions a) {
        switch (a){
            case ATTACK: Health = Health - 20; System.out.println(NameClass  +" "+ Name +": Здоровье " + Health); break;
            case HEAL: Health = Health + 20; System.out.println(NameClass  +" "+ Name +": Здоровье " + Health); break;
            case BLOW: Health = Health - 40; System.out.println(NameClass  +" "+ Name +": Здоровье " + Health); break;
            case EAT: if (State != States.DEAD) {growl(); bark();} break;
        }
        if(Health <= 0 && State != States.DEAD){
            State = States.DEAD;
            System.out.println(NameClass +" " + Name + " умер");
        }
    }
    
    private void bark() {
        System.out.println(NameClass  +" "+ Name + " гавкает");
    }
    
    private void growl() {
        System.out.println(NameClass  +" "+ Name + " рычит");
    }
    
}

