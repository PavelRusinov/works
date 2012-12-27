
package converter;

public interface MObserveble {
    public void registerObserver(MObserver o);
    public void removeObserver(MObserver o);
    public void notifyObservers();
}
