
package converter;


public class About extends javax.swing.JFrame {

    public About() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        this.setResizable(false);
        
        appName = new javax.swing.JLabel();
        author = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        appName.setText("Конвертер температур");
        appName.setName("appName"); 

        author.setText("Автор: Русинов Павел");

        returnButton.setText("Назад");
        
        returnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(returnButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(appName, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(author)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(appName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(author)
                .addGap(18, 18, 18)
                .addComponent(returnButton)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }

    private void returnButtonMouseClicked(java.awt.event.MouseEvent evt) {
        this.setVisible(false);
    }

    
    
    private javax.swing.JLabel appName;
    private javax.swing.JLabel author;
    private javax.swing.JButton returnButton;
}