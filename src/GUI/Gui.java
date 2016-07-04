package GUI;

import image.processing.ImageView;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Gui extends javax.swing.JFrame {

    private static final Gui gui = new Gui();

    private ArrayList<BufferedImage> inputImages;
    private ArrayList<JLabel> inputLabels;

    private Gui() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        initComponents();
        setVisible(true);

        inputImages = new ArrayList<>();
        inputLabels = new ArrayList<>();
        addListeners();
    }

    public static Gui getInstance() {
        return Gui.gui;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        panelInput = new javax.swing.JPanel();
        panelShow = new javax.swing.JPanel();
        LabelView = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelOutput = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        MenuAddImageFile = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(0, 0));

        panelInput.setBackground(new java.awt.Color(249, 249, 249));
        panelInput.setPreferredSize(new java.awt.Dimension(0, 0));
        panelInput.setLayout(new javax.swing.BoxLayout(panelInput, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(panelInput);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        panelShow.setBackground(new java.awt.Color(243, 243, 243));
        panelShow.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout panelShowLayout = new javax.swing.GroupLayout(panelShow);
        panelShow.setLayout(panelShowLayout);
        panelShowLayout.setHorizontalGroup(
            panelShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelView, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShowLayout.setVerticalGroup(
            panelShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelView, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(panelShow, gridBagConstraints);

        panelOutput.setBackground(new java.awt.Color(249, 249, 249));
        panelOutput.setPreferredSize(new java.awt.Dimension(0, 0));
        panelOutput.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane3.setViewportView(panelOutput);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane3, gridBagConstraints);

        MenuFile.setText("File");

        MenuAddImageFile.setText("Add Image File");
        MenuFile.add(MenuAddImageFile);

        menuBar.add(MenuFile);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void loadImage() {
        BufferedImage image;
        JFileChooser jfc = new JFileChooser();
        jfc.addChoosableFileFilter(new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));
        jfc.setAcceptAllFileFilterUsed(false);
        jfc.setMultiSelectionEnabled(true);
        int val = jfc.showOpenDialog(this);
        
        if (val == JFileChooser.APPROVE_OPTION) {
            File[] imgFiles = jfc.getSelectedFiles();

            panelInput.setPreferredSize(new Dimension(panelInput.getPreferredSize().width, panelInput.getPreferredSize().height + (201 * imgFiles.length)));
            
            for (File imgFile : imgFiles) {
                if (imgFile != null) {

                    try {
                        image = ImageIO.read(imgFile);
                        
                        inputImages.add(image);
                        
                        JLabel jLabel = new JLabel();
                        jLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                        
                        if(image.getWidth() > 200 && image.getHeight() > 200)
                            image = resizeImage(200, 200, image);
                        
                        jLabel.setIcon(new ImageIcon(image));
                        
                        inputLabels.add(jLabel);

                        panelInput.add(jLabel);
                        panelInput.revalidate();
                        panelInput.repaint();

                    } catch (IOException ex) {
                        Logger.getLogger(ImageView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            addInputImagesListeners();
        }
    }
    
    private BufferedImage resizeImage(int width, int height, BufferedImage image) {
        BufferedImage bImg = image;

        bImg = new BufferedImage((int) width, (int) height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = bImg.createGraphics();
        g2d.drawImage(image, 0, 0, (int) width, (int) height, null);
        g2d.dispose();

        return bImg;
    }

    private void addListeners() {
        MenuAddImageFile.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                loadImage();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
    }

    
    
    private void addInputImagesListeners() {
        int len = inputLabels.size();
        for (int i = 0; i < len; i++) {
            final int index = i;
            inputLabels.get(i).addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    LabelView.setIcon(new ImageIcon(inputImages.get(index)));
                    LabelView.setHorizontalAlignment(JLabel.CENTER);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }

            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelView;
    private javax.swing.JMenuItem MenuAddImageFile;
    private javax.swing.JMenu MenuFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel panelInput;
    private javax.swing.JPanel panelOutput;
    private javax.swing.JPanel panelShow;
    // End of variables declaration//GEN-END:variables
}
