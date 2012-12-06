
package hashtable;
import java.io.FileNotFoundException;
import java.io.IOException;
import str.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        StringWork s = new StringWork(800);
        
        s.read("file.txt");
        s.showDistribution();
    }
}
