
package partly.cloudy;

public class Creature {
    private CreatureType type;
    
    public Creature(CreatureType type){
        this.type = type;
    }
    
    public CreatureType getCreatureType(){
        return type;
    }
}
