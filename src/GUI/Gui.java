package GUI;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
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
        panelOutput.setLayout(new java.awt.GridLayout());
        jScrollPane3.setViewportView(panelOutput);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane3, gridBagConstraints);

        MenuFile.setText("File");

        MenuAddImageFile.setText("Add Image File");
        MenuAddImageFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAddImageFileActionPerformed(evt);
            }
        });
        MenuFile.add(MenuAddImageFile);

        menuBar.add(MenuFile);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuAddImageFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAddImageFileActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));
        fc.setAcceptAllFileFilterUsed(false);
        fc.setMultiSelectionEnabled(true);
        int returnVal = fc.showOpenDialog(gui.getContentPane());

        if (returnVal == 0) {

            File[] files = fc.getSelectedFiles();

            try {
                int len = files.length;
                //GridLayout layout = (GridLayout)panelInput.getLayout();
                //layout.setRows(inputLabels.size() + len);
                panelInput.setPreferredSize(new Dimension(panelInput.getPreferredSize().width, panelInput.getPreferredSize().height + (201 * len)));

                for (int i = 0; i < len; i++) {
                    BufferedImage image = ImageIO.read(files[i]);

                    inputImages.add(image);

                    JLabel jLabel = new JLabel();
                    jLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                    jLabel.setIcon(new ImageIcon(resizeImage(200, 200, image)));

                    //jLabel.setIcon(new ImageIcon(image));
                    inputLabels.add(jLabel);

                    panelInput.add(jLabel);
                }
                addInputImagesListeners();
            } catch (IOException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_MenuAddImageFileActionPerformed

    private BufferedImage resizeImage(int width, int height, BufferedImage image) {
        BufferedImage bImg = image;

        bImg = new BufferedImage((int) width, (int) height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = bImg.createGraphics();
        g2d.drawImage(image, 0, 0, (int) width, (int) height, null);
        g2d.dispose();

        return bImg;
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
