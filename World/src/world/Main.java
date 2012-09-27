package world;

public class Main {

    public static void main(String[] args) {
        CombatCat egor = new CombatCat("Егор", "Егора");
                
        HealerCat valeriy = new HealerCat("Валерий", "Валерия");
                
        Dog igor = new Dog("Игорь", "Игоря");
                
        egor.attack(igor);
        igor.attack(egor);
        valeriy.heal(egor);
        igor.attack(egor);
        egor.SavageBlow(igor);
        igor.eat(egor);
        valeriy.heal(egor);
        egor.SavageBlow(igor);
        egor.eat(igor);
    }
}
