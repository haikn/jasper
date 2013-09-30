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
public class SignalProcessing extends OpticsPane {

    EduPatternJPanel panelPatternSet = new EduPatternJPanel();
    public BufferedImage canvas = new BufferedImage(500, 600, 12);
    PatternImage image1 = new PatternImage();
    LayoutStyle layuotStyle = new DefaultLayoutStyle();

    /**
     * Creates new form FSingleslit
     */
    public SignalProcessing() {
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

        text_single_rotation = new javax.swing.JTextField();
        text_single_height_y = new javax.swing.JTextField();
        s_single_gray = new javax.swing.JSlider();
        s_single_position_x = new javax.swing.JSlider();
        text_single_position_x = new javax.swing.JTextField();
        l_position_x = new javax.swing.JLabel();
        l_rotation = new javax.swing.JLabel();
        text_single_width_y = new javax.swing.JTextField();
        l_gaylevel = new javax.swing.JLabel();
        l_width_y = new javax.swing.JLabel();
        l_height_y = new javax.swing.JLabel();
        s_single_height_y = new javax.swing.JSlider();
        s_single_rotation = new javax.swing.JSlider();
        s_single_width_y = new javax.swing.JSlider();
        layOutCanvas = new javax.swing.JLayeredPane();
        b_ganerate = new javax.swing.JButton();
        l_width_x = new javax.swing.JLabel();
        text_single_width_x = new javax.swing.JTextField();
        s_single_width_x = new javax.swing.JSlider();
        l_height_x = new javax.swing.JLabel();
        text_single_height_x = new javax.swing.JTextField();
        s_single_height_x = new javax.swing.JSlider();
        l_position_y = new javax.swing.JLabel();
        text_single_position_y = new javax.swing.JTextField();
        s_single_position_y = new javax.swing.JSlider();
        text_single_gray = new javax.swing.JTextField();


        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, s_single_rotation, org.jdesktop.beansbinding.ELProperty.create("${value}"), text_single_rotation, org.jdesktop.beansbinding.BeanProperty.create("text"));
        s_single_rotation.setMaximum(180);
        s_single_rotation.setValue(0);
        s_single_rotation.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGenerateActionPerformed(evt);
            }
        });
        bindingGroup.addBinding(binding);



        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, s_single_width_x, org.jdesktop.beansbinding.ELProperty.create("${value}"), text_single_width_x, org.jdesktop.beansbinding.BeanProperty.create("text"));
        s_single_width_x.setMaximum(image1.getBounds().width);
        s_single_width_x.setValue(image1.getBounds().width);
        s_single_width_x.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGenerateActionPerformed(evt);
            }
        });
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, s_single_width_y, org.jdesktop.beansbinding.ELProperty.create("${value}"), text_single_width_y, org.jdesktop.beansbinding.BeanProperty.create("text"));
        s_single_width_y.setMaximum(image1.getBounds().width);
        s_single_width_y.setValue(100);
        s_single_width_y.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGenerateActionPerformed(evt);
            }
        });
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, s_single_height_x, org.jdesktop.beansbinding.ELProperty.create("${value}"), text_single_height_x, org.jdesktop.beansbinding.BeanProperty.create("text"));
        s_single_height_x.setMaximum(image1.getBounds().height);
        s_single_height_x.setValue(100);
        s_single_height_x.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGenerateActionPerformed(evt);
            }
        });
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, s_single_height_y, org.jdesktop.beansbinding.ELProperty.create("${value}"), text_single_height_y, org.jdesktop.beansbinding.BeanProperty.create("text"));
        s_single_height_y.setMaximum(image1.getBounds().height);
        s_single_height_y.setValue(image1.getBounds().height);
        s_single_height_y.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGenerateActionPerformed(evt);
            }
        });
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, s_single_position_x, org.jdesktop.beansbinding.ELProperty.create("${value}"), text_single_position_x, org.jdesktop.beansbinding.BeanProperty.create("text"));
        s_single_position_x.setMaximum(image1.getBounds().height);
        s_single_position_x.setValue((image1.getBounds().height / 2));
        s_single_position_x.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGenerateActionPerformed(evt);
            }
        });
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, s_single_position_y, org.jdesktop.beansbinding.ELProperty.create("${value}"), text_single_position_y, org.jdesktop.beansbinding.BeanProperty.create("text"));
        s_single_position_y.setMaximum(image1.getBounds().width);
        s_single_position_y.setValue((image1.getBounds().width / 2));
        s_single_position_y.addChangeListener(new javax.swing.event.ChangeListener() {
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

        l_width_x.setText("Width X");
        l_width_y.setText("Width Y");
        l_height_y.setText("Height Y");
        l_height_x.setText("Height X");
        l_position_x.setText("PostionsX");
        l_position_y.setText("PostionY");
        l_rotation.setText("Rotation");
        l_gaylevel.setText("GrayLevel");
        b_ganerate.setText("Generate");
        b_ganerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panelPattern, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(l_position_x, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(l_position_y, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(35, 35, 35))
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(l_gaylevel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(l_rotation)
                .addComponent(l_height_y)
                .addComponent(l_width_y)
                .addComponent(l_height_x)
                .addComponent(l_width_x))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(layout.createSequentialGroup()
                .addComponent(text_single_gray, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(s_single_gray, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                .addComponent(text_single_position_y, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(s_single_position_y, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                .addComponent(text_single_position_x, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(s_single_position_x, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                .addComponent(text_single_rotation, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(s_single_rotation, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                .addComponent(text_single_height_y, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(s_single_height_y, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                .addComponent(text_single_width_y, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(s_single_width_y, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(text_single_width_x, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(text_single_height_x, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(s_single_width_x, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addComponent(s_single_height_x, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addComponent(b_ganerate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(s_single_width_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(l_width_x)
                .addComponent(text_single_width_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(l_height_x)
                .addComponent(text_single_height_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(s_single_height_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(s_single_width_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(text_single_width_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(l_width_y)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(s_single_height_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(text_single_height_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(l_height_y)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(l_rotation)
                .addComponent(text_single_rotation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(s_single_rotation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(l_position_x)
                .addComponent(text_single_position_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(s_single_position_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(l_position_y)
                .addComponent(text_single_position_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(s_single_position_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(s_single_gray, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(text_single_gray, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(l_gaylevel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(b_ganerate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(panelPattern, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE)));
        panelPatternSet = (EduPatternJPanel) panelPattern;
        bindingGroup.bind();
    }// </editor-fold>         
    private double widthX = Double.valueOf(image1.getBounds().width), widthY = 100, heightX = 100, heightY = Double.valueOf(image1.getBounds().height), rotation = 0, positionX = Double.valueOf(image1.getBounds().height) / 2, positionY = Double.valueOf(image1.getBounds().width) / 2, grayLevel = 255;

    private boolean parseArguments() {
        boolean ret = false;
        try {
            widthX = Double.valueOf(s_single_width_x.getValue());
            widthY = Double.valueOf(s_single_width_y.getValue());
            heightX = Double.valueOf(s_single_height_x.getValue());
            heightY = Double.valueOf(s_single_height_y.getValue());
            rotation = Double.valueOf(s_single_rotation.getValue());
            positionX = Double.valueOf(s_single_position_x.getValue());
            positionY = Double.valueOf(s_single_position_y.getValue());
            grayLevel = Double.valueOf(s_single_gray.getValue());
            ret = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, warnings);
            s_single_width_x.setValue((int) (widthY));
            s_single_width_y.setValue((int) (widthX));
            s_single_height_x.setValue((int) (heightX));
            s_single_height_y.setValue((int) (heightY));
            s_single_rotation.setValue((int) (rotation));
            s_single_position_x.setValue((int) (positionX));
            s_single_position_y.setValue((int) (positionY));
            s_single_gray.setValue((int) (grayLevel));

        }
        return ret;
    }

    private String genLog() {
        return String.format(logmessage, Double.toString(widthX), Double.toString(heightX), Double.toString(positionX), Double.toString(rotation), Double.toString(grayLevel));
    }

    private void sliderGenerateActionPerformed(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
        if (parseArguments()) {
            PatternImage image = ((EduPatternJPanel) panelPattern).pimage;
            image.updateParameterDrawSignalProcessing(widthX, widthY, heightX, heightY, positionX, positionY, rotation, grayLevel);
            image.signalProcessing();
            EduPatternTest.updateLensPatternPattern(image, genLog());
            imageGenerated = true;
        }
    }//GEN-LAST:event_sliderGenerateActionPerformed

    private void buttonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
        if (parseArguments()) {
            PatternImage image = ((EduPatternJPanel) panelPattern).pimage;
            image.updateParameterDrawSignalProcessing(widthX, widthY, heightX, heightY, positionX, positionY, rotation, grayLevel);
            image.signalProcessing();
            EduPatternTest.updateLensPattern(image, genLog());
            imageGenerated = true;
        }
    }
    // Variables declaration - do not modify   
    private javax.swing.JButton b_ganerate;
    private javax.swing.JLabel l_gaylevel;
    private javax.swing.JLabel l_height_x;
    private javax.swing.JLabel l_height_y;
    private javax.swing.JLabel l_position_x;
    private javax.swing.JLabel l_position_y;
    private javax.swing.JLabel l_rotation;
    private javax.swing.JLabel l_width_x;
    private javax.swing.JLabel l_width_y;
    private javax.swing.JLayeredPane layOutCanvas;
    private javax.swing.JSlider s_single_gray;
    private javax.swing.JSlider s_single_height_x;
    private javax.swing.JSlider s_single_height_y;
    private javax.swing.JSlider s_single_position_x;
    private javax.swing.JSlider s_single_position_y;
    private javax.swing.JSlider s_single_rotation;
    private javax.swing.JSlider s_single_width_x;
    private javax.swing.JSlider s_single_width_y;
    private javax.swing.JTextField text_single_gray;
    private javax.swing.JTextField text_single_height_x;
    private javax.swing.JTextField text_single_height_y;
    private javax.swing.JTextField text_single_position_x;
    private javax.swing.JTextField text_single_position_y;
    private javax.swing.JTextField text_single_rotation;
    private javax.swing.JTextField text_single_width_x;
    private javax.swing.JTextField text_single_width_y;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    private javax.swing.JPanel panelPattern;
    // End of variables declaration         

    @Override
    void updatePatternScreen() {
        PatternImage image = ((EduPatternJPanel) panelPattern).pimage;
        if (!imageGenerated) {
            image.updateParameterDrawSignalProcessing(widthX, widthY, heightX, heightY, positionX, positionY, rotation, grayLevel);
            image.signalProcessing();
            imageGenerated = true;
        }
        EduPatternTest.updatePatternScreen(image, genLog());
    }

    // paint boot screen, lens only
    void bootScreen() {
        PatternImage image = ((EduPatternJPanel) panelPattern).pimage;
//        double xoff = 0.0;
//        double yoff = 0.0;
//        double focal = 0.0;
        image.updateParameterDrawSignalProcessing(widthX, widthY, heightX, heightY, positionX, positionY, rotation, grayLevel);
        image.signalProcessing();
    }

    void updateRegenerate() {
        PatternImage image = ((EduPatternJPanel) panelPattern).pimage;
        if (imageGenerated) {
            image.updateParameterDrawSignalProcessing(widthX, widthY, heightX, heightY, positionX, positionY, rotation, grayLevel);
            image.signalProcessing();
        }
    }
    static String logmessage = "Single Slit width=%s height=%s positiont=%s rotationt=%s grayLevelt=%s ";
}
