package image.processing;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ViewPanel extends javax.swing.JFrame {

    private final int IMAGE_WIDTH = 176;
    private final int IMAGE_HEIGHT = 176;

    private ArrayList<BufferedImage> images;
    private ArrayList<JLabel> labels;
    
    private ImageView observer;
    
    public ViewPanel(String name) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        initComponents();

        labelName.setText(name);
        images = new ArrayList<>();
        labels = new ArrayList<>();
    }

    public void setObserver(ImageView observer){
        this.observer = observer;
    }
    
    public void addImage(BufferedImage image) {
        labels = new ArrayList<>();
        images.add(image);

        int len = images.size();

        panelImageContainer.setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT * len));
        panelImageContainer.removeAll();

        for (int i = 0; i < len; i++) {
            BufferedImage img = images.get(i);
            JLabel jLabel = new JLabel();
            jLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

            if (img.getWidth() > IMAGE_WIDTH && img.getHeight() > IMAGE_HEIGHT) {
                img = scaleImageToDisplay(IMAGE_WIDTH, IMAGE_HEIGHT, img);
            }

            jLabel.setIcon(new ImageIcon(img));

            labels.add(jLabel);

            panelImageContainer.add(jLabel);
            panelImageContainer.revalidate();
            panelImageContainer.repaint();
        }
        addListeners();
    }

    private void addListeners(){
        int len = labels.size();
        
        for(int i = 0; i < len; i++){
            int index = i;
            JLabel label = labels.get(i);
            BufferedImage image = images.get(i);
            label.addMouseListener(new MouseListener(){

                @Override
                public void mouseClicked(MouseEvent e) {
                    observer.updateCurrentImage(image, index);
                }

                @Override
                public void mousePressed(MouseEvent e) {}

                @Override
                public void mouseReleased(MouseEvent e) {}

                @Override
                public void mouseEntered(MouseEvent e) {
                    label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        labelName = new javax.swing.JLabel();
        scrollPaneImageContainer = new javax.swing.JScrollPane();
        panelImageContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(200, 726));
        setResizable(false);

        panelMain.setBackground(new java.awt.Color(255, 255, 255));

        labelName.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelName.setText("Images");
        labelName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(224, 224, 224)));

        scrollPaneImageContainer.setBackground(new java.awt.Color(255, 255, 255));
        scrollPaneImageContainer.setBorder(null);

        panelImageContainer.setLayout(new javax.swing.BoxLayout(panelImageContainer, javax.swing.BoxLayout.Y_AXIS));
        scrollPaneImageContainer.setViewportView(panelImageContainer);

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(scrollPaneImageContainer))
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneImageContainer))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelName;
    private javax.swing.JPanel panelImageContainer;
    private javax.swing.JPanel panelMain;
    private javax.swing.JScrollPane scrollPaneImageContainer;
    // End of variables declaration//GEN-END:variables

    private BufferedImage scaleImageToDisplay(int width, int height, BufferedImage image) {
        BufferedImage bImg = image;

        bImg = new BufferedImage((int) width, (int) height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = bImg.createGraphics();
        g2d.drawImage(image, 0, 0, (int) width, (int) height, null);
        g2d.dispose();

        return bImg;
    }
    
    public void emptyImages(){
        images = new ArrayList<>();
    }

}
