
package converter;

public class Controller {
    Model m;
    
    public Controller(Model m){
        this.m = m;
    }
    
    public void changesIsMade(String s, String val){
        switch(s){
            case "Celsius": m.setState(ScaleType.Cel, Integer.parseInt(val)); break;  
            case "Kelvin": m.setState(ScaleType.Kel, Integer.parseInt(val)); break;   
            case "Fahrenheit": m.setState(ScaleType.Fahr, Integer.parseInt(val)); break;
            default: break;
        }
    }
    
    public void register(MObserver o){
        m.registerObserver(o);
    }
}
