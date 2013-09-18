/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jasper;

import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;
import sun.swing.DefaultLayoutStyle;

/**
 *
 * @author T420
 */
public class Slit extends OpticsPane {

    EduPatternJPanel panelPatternSet = new EduPatternJPanel();
    public BufferedImage canvas = new BufferedImage(500, 600, 12);
    PatternImage image1 = new PatternImage();
    LayoutStyle layuotStyle = new DefaultLayoutStyle();

    /**
     * Creates new form FSingleslit
     */
    public Slit() {
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
        // layOutCanvas = new javax.swing.JLayeredPane();
        combobox = new javax.swing.JComboBox();
        b_ganerate = new javax.swing.JButton();
        text_single_rotation = new javax.swing.JTextField();
        text_single_height = new javax.swing.JTextField();
        s_single_gray = new javax.swing.JSlider();
        text_single_gray = new javax.swing.JTextField();
        s_single_position = new javax.swing.JSlider();
        text_single_position = new javax.swing.JTextField();
        l_position = new javax.swing.JLabel();
        l_rotation = new javax.swing.JLabel();
        text_single_width = new javax.swing.JTextField();
        l_gaylevel = new javax.swing.JLabel();
        l_width = new javax.swing.JLabel();
        l_height = new javax.swing.JLabel();
        s_single_height = new javax.swing.JSlider();
        s_single_rotation = new javax.swing.JSlider();
        s_single_width = new javax.swing.JSlider();

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, s_single_rotation, org.jdesktop.beansbinding.ELProperty.create("${value}"), text_single_rotation, org.jdesktop.beansbinding.BeanProperty.create("text"));
        s_single_rotation.setMaximum(180);
        s_single_rotation.setValue(0);
        s_single_rotation.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGenerateActionPerformed(evt);
            }
        });
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, s_single_height, org.jdesktop.beansbinding.ELProperty.create("${value}"), text_single_height, org.jdesktop.beansbinding.BeanProperty.create("text"));

        s_single_height.setMaximum(image1.getBounds().height);
        s_single_height.setValue(100);
        s_single_height.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGenerateActionPerformed(evt);
            }
        });
        bindingGroup.addBinding(binding);


        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, s_single_gray, org.jdesktop.beansbinding.ELProperty.create("${value}"), text_single_gray, org.jdesktop.beansbinding.BeanProperty.create("text"));

        s_single_gray.setMaximum(255);
        s_single_gray.setValue(255);
        s_single_gray.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGenerateActionPerformed(evt);
            }
        });
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, s_single_position, org.jdesktop.beansbinding.ELProperty.create("${value}"), text_single_position, org.jdesktop.beansbinding.BeanProperty.create("text"));
        s_single_position.setMaximum(image1.getBounds().height);
        s_single_position.setValue((image1.getBounds().height / 2));
        s_single_position.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGenerateActionPerformed(evt);
            }
        });
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, s_single_width, org.jdesktop.beansbinding.ELProperty.create("${value}"), text_single_width, org.jdesktop.beansbinding.BeanProperty.create("text"));
        s_single_width.setMaximum(image1.getBounds().width);
        s_single_width.setValue(image1.getBounds().width);
        s_single_width.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGenerateActionPerformed(evt);
            }
        });
        bindingGroup.addBinding(binding);

        l_position.setText("Position");
        l_rotation.setText("Rotation");
        l_gaylevel.setText("GrayLevel ");
        l_width.setText("Width");
        l_height.setText("Height");
        b_ganerate.setText("Ganerate");
        b_ganerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateActionPerformed(evt);
            }
        });
        combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Object selected = combobox.getSelectedItem();
                if (selected.equals("Single Slit")) {
                    slit = 1;
                    // updatePatternScreen();
                }
                if (selected.equals("Double Slit")) {
                    slit = 2;
                    //updatePatternScreen();
                }
                PatternImage image = ((EduPatternJPanel) panelPattern).pimage;
                image.updateLensParameterDrawSlit(slit, width, height, position, rotation, grayLevel);
                image.slit(slit);
                EduPatternTest.updateLensPatternPattern(image, genLog());
                imageGenerated = true;
            }
        });
        combobox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Single Slit", "Double Slit"}));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelPattern, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(l_position)
                .addGap(35, 35, 35))
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(l_rotation)
                .addComponent(l_height))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(l_gaylevel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(l_width))
                .addGap(30, 30, 30)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(b_ganerate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(text_single_gray, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(s_single_gray, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                .addComponent(text_single_height, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(s_single_height, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(text_single_position, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(s_single_position, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(text_single_rotation, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(s_single_rotation, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                .addComponent(text_single_width, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(s_single_width, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(s_single_width, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(text_single_width, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(l_width)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(l_height)
                .addComponent(text_single_height, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(s_single_height, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(l_rotation)
                .addComponent(text_single_rotation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(s_single_rotation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(l_position)
                .addComponent(text_single_position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(s_single_position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(l_gaylevel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(text_single_gray, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(s_single_gray, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(b_ganerate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(panelPattern, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE)));
        panelPatternSet = (EduPatternJPanel) panelPattern;
        bindingGroup.bind();
    }// </editor-fold>         
    private double width = Double.valueOf(image1.getBounds().width), height = 100, rotation = 0, position = Double.valueOf(image1.getBounds().height) / 2, grayLevel = 255;

    private boolean parseArguments() {
        boolean ret = false;
        try {
            double width = Double.valueOf(s_single_width.getValue());
            double height = Double.valueOf(s_single_height.getValue());
            double position = Double.valueOf(s_single_position.getValue());
            double rotation = Double.valueOf(s_single_rotation.getValue());
            double grayLevel = Double.valueOf(s_single_gray.getValue());

            ret = true;
            this.width = width;
            this.height = height;
            this.position = position;
            this.rotation = rotation;
            this.grayLevel = grayLevel;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, warnings);
            s_single_width.setValue((int) (width));
            s_single_height.setValue((int) (height));
            s_single_position.setValue((int) (position));
            s_single_rotation.setValue((int) (rotation));
            s_single_gray.setValue((int) (grayLevel));
        }
        return ret;
    }

    private String genLog() {
        return String.format(logmessage, Double.toString(width), Double.toString(height), Double.toString(position), Double.toString(rotation), Double.toString(grayLevel));
    }

    private void sliderGenerateActionPerformed(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
        if (parseArguments()) {
            PatternImage image = ((EduPatternJPanel) panelPattern).pimage;
            image.updateLensParameterDrawSlit(slit, width, height, position, rotation, grayLevel);
            image.slit(slit);
            EduPatternTest.updateLensPatternPattern(image, genLog());
            imageGenerated = true;
        }
    }//GEN-LAST:event_sliderGenerateActionPerformed

    private void buttonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
        if (parseArguments()) {
            PatternImage image = ((EduPatternJPanel) panelPattern).pimage;
            image.updateLensParameterDrawSlit(slit, width, height, position, rotation, grayLevel);
            image.slit(slit);
            EduPatternTest.updateLensPattern(image, genLog());
            imageGenerated = true;
        }
    }
    // Variables declaration - do not modify   
    private javax.swing.JButton b_ganerate;
    private javax.swing.JComboBox combobox;
    private javax.swing.JLabel l_gaylevel;
    private javax.swing.JLabel l_height;
    private javax.swing.JLabel l_position;
    private javax.swing.JLabel l_rotation;
    private javax.swing.JLabel l_width;
    // private javax.swing.JLayeredPane layOutCanvas;
    private javax.swing.JSlider s_single_gray;
    private javax.swing.JSlider s_single_height;
    private javax.swing.JSlider s_single_position;
    private javax.swing.JSlider s_single_rotation;
    private javax.swing.JSlider s_single_width;
    private javax.swing.JTextField text_single_gray;
    private javax.swing.JTextField text_single_height;
    private javax.swing.JTextField text_single_position;
    private javax.swing.JTextField text_single_rotation;
    private javax.swing.JTextField text_single_width;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    private javax.swing.JPanel panelPattern;
    private int slit = 1;

    // End of variables declaration         
    @Override
    void updatePatternScreen() {
        PatternImage image = ((EduPatternJPanel) panelPattern).pimage;
        if (!imageGenerated) {
            image.updateLensParameterDrawSlit(slit, width, height, position, rotation, grayLevel);
            image.slit(slit);
            imageGenerated = true;
        }
        EduPatternTest.updatePatternScreen(image, genLog());
    }

    // paint boot screen, lens only
    void bootScreen() {
        PatternImage image = ((EduPatternJPanel) panelPattern).pimage;
        image.updateLensParameterDrawSlit(slit, width, height, position, rotation, grayLevel);
        image.slit(slit);
    }

    void updateRegenerate() {
        PatternImage image = ((EduPatternJPanel) panelPattern).pimage;
        if (imageGenerated) {
            image.updateLensParameterDrawSlit(slit, width, height, position, rotation, grayLevel);
            image.slit(slit);
        }
    }
    static String logmessage = "Single Slit width=%s height=%s positiont=%s rotationt=%s grayLevelt=%s ";
}
