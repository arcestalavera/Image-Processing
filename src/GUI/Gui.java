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
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import layer.Layer;

public class Gui extends javax.swing.JFrame {

    private static final Gui gui = new Gui();

    private final int INPUT_MODE = 0;
    private final int OUTPUT_MODE = 1;
    
    private ArrayList<BufferedImage> inputImages;
    private ArrayList<JLabel> inputLabels;

    private ArrayList<BufferedImage> outputImages;
    private ArrayList<JLabel> outputLabels;
    
    private Layer layer;

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

        outputImages = new ArrayList<>();
        outputLabels = new ArrayList<>();
        
        layer = new Layer(200, 200);

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
        labelView = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelOutput = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        spinnerK = new javax.swing.JSpinner();
        spinnerM = new javax.swing.JSpinner();
        extractButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        MenuAddImageFile = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(204, 204, 204)));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(0, 0));

        panelInput.setBackground(new java.awt.Color(249, 249, 249));
        panelInput.setPreferredSize(new java.awt.Dimension(0, 0));
        panelInput.setLayout(new javax.swing.BoxLayout(panelInput, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(panelInput);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.8;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        panelShow.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout panelShowLayout = new javax.swing.GroupLayout(panelShow);
        panelShow.setLayout(panelShowLayout);
        panelShowLayout.setHorizontalGroup(
            panelShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelView, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShowLayout.setVerticalGroup(
            panelShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.weighty = 0.8;
        getContentPane().add(panelShow, gridBagConstraints);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(204, 204, 204)));

        panelOutput.setBackground(new java.awt.Color(249, 249, 249));
        panelOutput.setPreferredSize(new java.awt.Dimension(0, 0));
        panelOutput.setLayout(new javax.swing.BoxLayout(panelOutput, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane3.setViewportView(panelOutput);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.8;
        getContentPane().add(jScrollPane3, gridBagConstraints);

        jPanel2.setPreferredSize(new java.awt.Dimension(0, 0));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Input Images");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.05;
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel3.setPreferredSize(new java.awt.Dimension(0, 0));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Output Images");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.05;
        getContentPane().add(jPanel3, gridBagConstraints);

        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));

        jLabel3.setText("K");

        jLabel4.setText("M");

        spinnerK.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        spinnerM.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        extractButton.setText("Extract");
        extractButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extractButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(extractButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(spinnerM)
                    .addComponent(spinnerK))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spinnerK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(spinnerM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(extractButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.15;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel4.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.15;
        getContentPane().add(jPanel4, gridBagConstraints);

        MenuFile.setText("File");

        MenuAddImageFile.setText("Add Image File");
        MenuFile.add(MenuAddImageFile);

        menuBar.add(MenuFile);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void extractButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extractButtonActionPerformed
        layer.whou();
        
        outputImages = new ArrayList<>();
        outputLabels = new ArrayList<>();
        
        ArrayList<BufferedImage> images = layer.extract(Integer.parseInt(spinnerK.getValue().toString()), Integer.parseInt(spinnerM.getValue().toString()));

        File[] imgArray = new File[images.size()];
        
        int num = 0;
        for (BufferedImage img : images) {
            
            try {
                ImageIO.write(img, "jpg", new File("output " + (num+1) + ".jpg"));
                imgArray[num] = new File("output " + (num+1) + ".jpg");
            } catch (IOException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }
            num++;
        }
        
        loadImage(imgArray, outputImages, outputLabels, panelOutput, OUTPUT_MODE);
        
    }//GEN-LAST:event_extractButtonActionPerformed

    public void loadImage(File[] imgFiles, ArrayList<BufferedImage> images, ArrayList<JLabel> labels, JPanel panel, int mode) {
        BufferedImage image;

        panel.setPreferredSize(new Dimension(panel.getPreferredSize().width, panel.getPreferredSize().height + (201 * imgFiles.length)));

        for (File imgFile : imgFiles) {
            if (imgFile != null) {

                try {
                    image = ImageIO.read(imgFile);

                    images.add(image);
                    if(mode == INPUT_MODE){
                        System.out.println("Hello");
                        layer.addImage(image);
                    }

                    JLabel jLabel = new JLabel();
                    jLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

                    if (image.getWidth() > 200 && image.getHeight() > 200) {
                        image = resizeImage(200, 200, image);
                    }

                    jLabel.setIcon(new ImageIcon(image));

                    labels.add(jLabel);

                    panel.add(jLabel);
                    panel.revalidate();
                    panel.repaint();

                } catch (IOException ex) {
                    Logger.getLogger(ImageView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        addLabelListeners(labels, images);

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

                JFileChooser jfc = new JFileChooser();
                jfc.addChoosableFileFilter(new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));
                jfc.setAcceptAllFileFilterUsed(false);
                jfc.setMultiSelectionEnabled(true);
                int val = jfc.showOpenDialog(gui);

                if (val == JFileChooser.APPROVE_OPTION) {
                    loadImage(jfc.getSelectedFiles(), inputImages, inputLabels, panelInput, INPUT_MODE);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
    }

    private void addLabelListeners(ArrayList<JLabel> labels, ArrayList<BufferedImage> images) {
        int len = labels.size();
        for (int i = 0; i < len; i++) {
            final int index = i;
            labels.get(i).addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    labelView.setIcon(new ImageIcon(images.get(index)));
                    labelView.setHorizontalAlignment(JLabel.CENTER);
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
    private javax.swing.JMenuItem MenuAddImageFile;
    private javax.swing.JMenu MenuFile;
    private javax.swing.JButton extractButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelView;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel panelInput;
    private javax.swing.JPanel panelOutput;
    private javax.swing.JPanel panelShow;
    private javax.swing.JSpinner spinnerK;
    private javax.swing.JSpinner spinnerM;
    // End of variables declaration//GEN-END:variables
}
