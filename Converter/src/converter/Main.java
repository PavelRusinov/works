package converter;

public class Main{
    
    public static void main(String args[]) {
        Model m = new Model();
        Controller c = new Controller(m);
        MainFrame app = new MainFrame(c);
        app.setVisible(true);
    }
}