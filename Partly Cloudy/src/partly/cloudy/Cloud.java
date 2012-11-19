
package partly.cloudy;

public class Cloud {
    private Daylight daylight = new Daylight();
    private Luminary luminary = new Luminary();
    private Wind wind = new Wind();

    private Creature internalCreate() throws NotImplementedException
    {
      if (luminary.isShining()){
          if(daylight.current() == DaylightType.Morning){
              if(wind.WindStrength() <= 2){
                  return new Creature(CreatureType.Puppy);
              }
              else if(wind.WindStrength() >= 6 && wind.WindStrength() <= 7){
                  return new Creature(CreatureType.Bearcub);
              }
              else{
                  return new Creature(CreatureType.Baloon);
              }
          }
          
          if(daylight.current() == DaylightType.Noon){
              if(wind.WindStrength() <= 2){
                  return new Creature(CreatureType.Puppy);
              }
              else if(wind.WindStrength() >= 8 && wind.WindStrength() <= 10){
                  return new Creature(CreatureType.Hedgehog);
              }
              else{
                  return new Creature(CreatureType.Baloon);
              }
          }
          
          if(daylight.current() == DaylightType.Evening){
              if(wind.WindStrength() >= 3 && wind.WindStrength() <= 5){
                  return new Creature(CreatureType.Kitten);
              }
              else if(wind.WindStrength() >= 8 && wind.WindStrength() <= 10){
                  return new Creature(CreatureType.Hedgehog);
              }
              else{
                  return new Creature(CreatureType.Baloon);
              }
          }
          
          if(daylight.current() == DaylightType.Night){
              if(wind.WindStrength() >= 3 && wind.WindStrength() <= 5){
                  return new Creature(CreatureType.Kitten);
              }
              else if(wind.WindStrength() >= 6 && wind.WindStrength() <= 7){
                  return new Creature(CreatureType.Bearcub);
              }
              else{
                  return new Creature(CreatureType.Baloon);
              }
          }
      }
      else{
          if(daylight.current() == DaylightType.Morning){
              if(wind.WindStrength() >= 0 && wind.WindStrength() <= 4){
                  return new Creature(CreatureType.Piglet);
              }
              else{
                  return new Creature(CreatureType.Baloon);
              }
          }
          if(daylight.current() == DaylightType.Noon){
              if(wind.WindStrength() >= 0 && wind.WindStrength() <= 4){
                  return new Creature(CreatureType.Piglet);
              }
              else if(wind.WindStrength() >= 5 && wind.WindStrength() <= 7){
                  return new Creature(CreatureType.Bat);
              }
              else{
                  return new Creature(CreatureType.Baloon);
              }
          }
          if(daylight.current() == DaylightType.Evening){
              if(wind.WindStrength() >= 5 && wind.WindStrength() <= 7){
                  return new Creature(CreatureType.Bat);
              }
              else{
                  return new Creature(CreatureType.Baloon);
              }
          }
          if(daylight.current() == DaylightType.Night){
              if(wind.WindStrength() >= 0 && wind.WindStrength() <= 4){
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
      Magic magic = new Magic();
      magic.callDaemon(creature.getCreatureType());

      return creature;
    }
}
