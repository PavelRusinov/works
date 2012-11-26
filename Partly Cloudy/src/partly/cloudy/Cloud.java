
package partly.cloudy;

public class Cloud {
    private IDaylight daylight;
    private ILuminary luminary;
    private IWind wind;
    
    public Cloud(IDaylight d, ILuminary l, IWind w){
        daylight = d;
        luminary = l;
        wind = w;
    }
    
    private Creature internalCreate() throws NotImplementedException
    {
        boolean currentLuminary = luminary.isShining();
        DaylightType currentDaylight = daylight.current();
        int currentWindStr = wind.WindStrength();
        
        if (currentLuminary){
          if(currentDaylight == DaylightType.Morning){
              if(currentWindStr <= 2){
                  return new Creature(CreatureType.Puppy);
              }
              else if(currentWindStr >= 6 && currentWindStr <= 7){
                  return new Creature(CreatureType.Bearcub);
              }
              else{
                  return new Creature(CreatureType.Baloon);
              }
          }
          
          if(currentDaylight == DaylightType.Noon){
              if(currentWindStr <= 2){
                  return new Creature(CreatureType.Puppy);
              }
              else if(currentWindStr >= 8 && currentWindStr <= 10){
                  return new Creature(CreatureType.Hedgehog);
              }
              else{
                  return new Creature(CreatureType.Baloon);
              }
          }
          
          if(currentDaylight == DaylightType.Evening){
              if(currentWindStr >= 3 && currentWindStr <= 5){
                  return new Creature(CreatureType.Kitten);
              }
              else if(currentWindStr >= 8 && currentWindStr <= 10){
                  return new Creature(CreatureType.Hedgehog);
              }
              else{
                  return new Creature(CreatureType.Baloon);
              }
          }
          
          if(currentDaylight == DaylightType.Night){
              if(currentWindStr >= 3 && currentWindStr <= 5){
                  return new Creature(CreatureType.Kitten);
              }
              else if(currentWindStr >= 6 && currentWindStr <= 7){
                  return new Creature(CreatureType.Bearcub);
              }
              else{
                  return new Creature(CreatureType.Baloon);
              }
          }
      }
      else{
          if(currentDaylight == DaylightType.Morning){
              if(currentWindStr >= 0 && currentWindStr <= 4){
                  return new Creature(CreatureType.Piglet);
              }
              else{
                  return new Creature(CreatureType.Baloon);
              }
          }
          if(currentDaylight == DaylightType.Noon){
              if(currentWindStr >= 0 && currentWindStr <= 4){
                  return new Creature(CreatureType.Piglet);
              }
              else if(currentWindStr >= 5 && currentWindStr <= 7){
                  return new Creature(CreatureType.Bat);
              }
              else{
                  return new Creature(CreatureType.Baloon);
              }
          }
          if(currentDaylight == DaylightType.Evening){
              if(currentWindStr >= 5 && currentWindStr <= 7){
                  return new Creature(CreatureType.Bat);
              }
              else{
                  return new Creature(CreatureType.Baloon);
              }
          }
          if(currentDaylight == DaylightType.Night){
              if(currentWindStr >= 0 && currentWindStr <= 4){
                  return new Creature(CreatureType.Piglet);
              }
              else{
                  return new Creature(CreatureType.Baloon);
              }
          }
      }
 

      throw new NotImplementedException();
    }

 

    public Creature create() throws NotImplementedException
    {
      Creature creature = internalCreate();
      IMagic magic = new Magic();
      switch (creature.getCreatureType()) {
          case Puppy:                
          case Piglet:               
          case Baloon:                    
              magic.callDeamon(creature.getCreatureType());  
              break;                
          case Kitten:                
          case Hedgehog:                
          case Bat:                  
          case Bearcub:                    
              magic.callStork(creature.getCreatureType());  
              break;
      }        
    

      return creature;
    }
}
