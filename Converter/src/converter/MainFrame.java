package converter;

import java.awt.event.WindowEvent;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JTextField;



public class MainFrame extends JFrame implements SendingListener {


    public MainFrame(Controller c) {
        super("Temperature converter");
        controller = c;
        initComponents();
    }

    private void initComponents() {

        label = new javax.swing.JLabel();
        scaleBox = new javax.swing.JComboBox();
        temp = new javax.swing.JTextField();
        menu = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        SendButton = new javax.swing.JMenuItem();
        exitButton = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        aboutButton = new javax.swing.JMenuItem();
        
        cel = new MField() {

            @Override
            public void update(Model m) {
                setText(((Model) m).getCel());
            }
        };
        kel = new MField() {

            @Override
            public void update(Model m) {
                setText(((Model) m).getKel());
            }
        };
        fahr = new MField() {

            @Override
            public void update(Model m) {
                setText(((Model) m).getFahr());
            }
        };
        


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        cel.setText(" ");
        cel.setEditable(false);
        
        kel.setText(" ");
        kel.setEditable(false);
        
        fahr.setText(" ");
        fahr.setEditable(false); 
        
        controller.register(cel);
        controller.register(kel);
        controller.register(fahr);

        label.setText("Выберите шкалу и введите значение");

        scaleBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Celsius", "Kelvin", "Fahrenheit" }));
        scaleBox.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scaleBoxActionPerformed(evt);
            }
        });

        temp.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tempKeyReleased(evt);
            }
        });

        file.setText("File");

        SendButton.setText("Send");
        SendButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendButtonActionPerformed(evt);
            }
        });
        file.add(SendButton);

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        file.add(exitButton);

        menu.add(file);

        help.setText("Help");

        aboutButton.setText("About");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });
        help.add(aboutButton);

        menu.add(help);

        setJMenuBar(menu);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(label, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(cel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(kel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(6, 6, 6)
                                .add(fahr, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(scaleBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 92, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(temp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 256, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(label)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(scaleBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(temp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(kel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(fahr, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }

    private void tempKeyReleased(java.awt.event.KeyEvent evt) {
        try 
        {
            Integer.parseInt(temp.getText());
            controller.changesIsMade((String)scaleBox.getSelectedItem(), temp.getText());
        } 
        catch (Exception e)
        {
            temp.setText("");
        }      
    }

    private void scaleBoxActionPerformed(java.awt.event.ActionEvent evt) {
        try 
        {
            Integer.parseInt(temp.getText());
            controller.changesIsMade((String)scaleBox.getSelectedItem(), temp.getText());
        } 
        catch (Exception e)
        {
            temp.setText("");
        }   
    }

    private void SendButtonActionPerformed(java.awt.event.ActionEvent evt) {
        saf.setLocationRelativeTo(this);
        saf.setVisible(true);
    }

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        processWindowEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
    }

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        aboutframe.setVisible(true);
    }
  
    private javax.swing.JMenuItem SendButton;
    private javax.swing.JMenuItem aboutButton;
    private MField cel;
    private javax.swing.JMenuItem exitButton;
    private MField fahr;
    private javax.swing.JMenu file;
    private javax.swing.JMenu help;
    private MField kel;
    private javax.swing.JLabel label;
    private javax.swing.JMenuBar menu;
    private javax.swing.JComboBox scaleBox;
    private javax.swing.JTextField temp;
    private About aboutframe = new About();
    private Sender send = new Sender();
    private SendFrame sf = new SendFrame();
    private SetAddrFrame saf = new SetAddrFrame(this);
    private Controller controller;

    @Override
    public void sendingfinished(boolean success) {
        SendButton.setEnabled(true);
        sf.setVisible(false);
        String mes;
        mes = success ? "Mail was sent successfully" : "Message wasn't sent";
        ErrorFrame rf = new ErrorFrame(mes);
        rf.setLocationRelativeTo(sf);
        rf.setVisible(true);
    }

    @Override
    public void sendingbegin(String addr) {
        String mes = cel.getText() + "; " + kel.getText() + "; " + fahr.getText() + "F";
        SendButton.setEnabled(false);
        sf.setLocationRelativeTo(sf);
        sf.setVisible(true);
        send.sending(this, mes, addr);
    }
}