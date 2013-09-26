/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jasper;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author T420
 */
public class PhaseRetarder extends OpticsPane {

    EduPatternJPanel panelPatternSet = new EduPatternJPanel();
    PatternImage image1 = new PatternImage();
    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    public PhaseRetarder() {
        initComponents();
        image1 = ((EduPatternJPanel) panelPattern).pimage;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        panelPattern = new EduPatternJPanel();
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        openFile = new javax.swing.JFileChooser();
        s_zoom = new javax.swing.JSlider();
        l_zoom = new javax.swing.JLabel();
        layOutCanvas = new javax.swing.JLayeredPane();
        b_ganerate = new javax.swing.JButton();
        b_openFile = new javax.swing.JButton();
        text_zoom = new javax.swing.JTextField();

        s_zoom.setMaximum(200);
        s_zoom.setValue(100);

        l_zoom.setText("Zoom ");

        b_ganerate.setText("Generate");
        b_ganerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateActionPerformed(evt);
            }
        });

        b_openFile.setText("Open File");
        b_openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_openFileActionPerformed(evt);
            }
        });
        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, s_zoom, org.jdesktop.beansbinding.ELProperty.create("${value}"), text_zoom, org.jdesktop.beansbinding.BeanProperty.create("text"));
        s_zoom.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGenerateActionPerformed(evt);
            }
        });
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGap(10, 10, 10)
                .addComponent(panelPattern, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(b_openFile)
                .addGap(18, 18, 18)
                .addComponent(l_zoom, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(text_zoom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(s_zoom, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(b_ganerate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 51, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(b_openFile)
                .addComponent(l_zoom, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(text_zoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(s_zoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(b_ganerate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                .addGap(20, 21, 21)
                .addComponent(panelPattern, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE)));
        panelPatternSet = (EduPatternJPanel) panelPattern;
        bindingGroup.bind();
    }// </editor-fold>                        
    private static BufferedImage buffImages = null;

    private void b_openFileActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        int returnVal = openFile.showOpenDialog(this);
        if (returnVal == openFile.APPROVE_OPTION) {
            File file = openFile.getSelectedFile();
            try {
                buffImages = ImageIO.read(new File(file.getAbsolutePath()));
                PatternImage image = ((EduPatternJPanel) panelPattern).pimage;
                image.updatePhaseRetarderParameter(zoom, grayLevel);
                image.phaseRetarder(buffImages);
                EduPatternTest.updateLensPatternPattern(image, genLog());
                imageGenerated = true;
            } catch (IOException ex) {
                System.out.println("problem accessing file" + file.getAbsolutePath());
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }
    private double zoom = 100.0, grayLevel = 255;

    private boolean parseArguments() {
        boolean ret = false;
        try {
            double zoom = Double.valueOf(s_zoom.getValue());
            // double grayLevel = Double.valueOf(s_single_gray.getValue());
            ret = true;
            this.zoom = zoom;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, warnings);
        }
        return ret;
    }

    private String genLog() {
        return String.format(logmessage, Double.toString(zoom), Double.toString(grayLevel));
    }

    private void sliderGenerateActionPerformed(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
        if (parseArguments()) {
            PatternImage image = ((EduPatternJPanel) panelPattern).pimage;
            image.updatePhaseRetarderParameter(zoom, grayLevel);
            image.phaseRetarder(buffImages);
            EduPatternTest.updateLensPatternPattern(image, genLog());
            imageGenerated = true;
        }
    }//GEN-LAST:event_sliderGenerateActionPerformed

    private void buttonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
        if (parseArguments()) {
            PatternImage image = ((EduPatternJPanel) panelPattern).pimage;
            image.updatePhaseRetarderParameter(zoom, grayLevel);
            image.phaseRetarder(buffImages);
            EduPatternTest.updateLensPattern(image, genLog());
            imageGenerated = true;
        }
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton b_ganerate;
    private javax.swing.JButton b_openFile;
    private javax.swing.JLabel l_zoom;
    private javax.swing.JLayeredPane layOutCanvas;
    private javax.swing.JFileChooser openFile;
    private javax.swing.JSlider s_zoom;
    private javax.swing.JTextField text_zoom;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    private javax.swing.JPanel panelPattern;
    // End of variables declaration     

    @Override
    void updatePatternScreen() {
        PatternImage image = ((EduPatternJPanel) panelPattern).pimage;
        if (!imageGenerated) {
            image.updatePhaseRetarderParameter(zoom, grayLevel);
            image.phaseRetarder(buffImages);
            imageGenerated = true;
        }
        EduPatternTest.updatePatternScreen(image, genLog());
    }
    // paint boot screen, lens only

    void bootScreen() {
        PatternImage image = ((EduPatternJPanel) panelPattern).pimage;
        image.updatePhaseRetarderParameter(zoom, grayLevel);
        image.phaseRetarder(buffImages);
    }

    void updateRegenerate() {
        PatternImage image = ((EduPatternJPanel) panelPattern).pimage;
        if (imageGenerated) {
            image.updatePhaseRetarderParameter(zoom, grayLevel);
            image.phaseRetarder(buffImages);
        }
    }
    static String logmessage = "PhaseRetarder zoom=%s Graylevel=%s ";
}
