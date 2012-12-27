
package converter;

import java.util.ArrayList;



public class Model implements MObserveble{
    
    private String cel;
    private String kel;
    private String fah;
    private ArrayList<MObserver> observers = new ArrayList<>();
    
    public Model(){
        cel = " ";
        kel = " ";
        fah = " ";
    }
    
    
    public void setState(ScaleType scale, int val){
        switch(scale){
            case Cel:  cel = Integer.toString(val) + " cel";
                       kel = Integer.toString(val + 273) + " kel";
                       fah = Integer.toString(val * 9/5 + 32) + " fahr";
                       break;
                      
            case Kel:  cel = Integer.toString(val - 273) + " cel";
                       kel = Integer.toString(val) + " kel";
                       fah = Integer.toString(val * 9/5 -459) + " fahr";
                       break;
            
            case Fahr: cel = Integer.toString(val * 5/9 - 32) + " cel";
                       kel = Integer.toString(val * 5/9 + 459) + " kel";
                       fah = Integer.toString(val) + " fahr";
                       break;
        }
        notifyObservers();
    }
    
    public String getCel(){
        return cel;
    }
    
    public String getKel(){
        return kel;
    }
    
    public String getFahr(){
        return fah;
    }

    @Override
    public void registerObserver(MObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(MObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (MObserver observer : observers){
            observer.update(this);
        }
    }
}
