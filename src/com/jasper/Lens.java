package com.jasper;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jeff Lee
 */
public class Lens extends OpticsPane {

    /**
     * Creates new form CylincalLens
     */
    public Lens() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPattern = new EduPatternJPanel();
        //labelFocal = new javax.swing.JLabel();
        textFocal = new javax.swing.JTextField();
        //labelXpos = new javax.swing.JLabel();
        //textXpos = new javax.swing.JTextField();
        //labelYpos = new javax.swing.JLabel();
        textYpos = new javax.swing.JTextField();
        //buttonGenerate = new javax.swing.JButton();

//        javax.swing.GroupLayout panelPatternLayout = new javax.swing.GroupLayout(panelPattern);
//        panelPattern.setLayout(panelPatternLayout);
//        panelPatternLayout.setHorizontalGroup(
//            panelPatternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 480, Short.MAX_VALUE)
//        );
//        panelPatternLayout.setVerticalGroup(
//            panelPatternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 270, Short.MAX_VALUE)
//        );

//        labelFocal.setText("Focal length");
//
//        textFocal.setText("0.0522");
//        textFocal.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                textFocalActionPerformed(evt);
//            }
//        });
//
//        labelXpos.setText("X Position");
//
//        textXpos.setText("0.0");
//        textXpos.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                textXposActionPerformed(evt);
//            }
//        });
//
//        labelYpos.setText("Y Position");
//
//        textYpos.setText("0.0");
//        textYpos.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                textYposActionPerformed(evt);
//            }
//        });
//
//        buttonGenerate.setText("Generate");
//        buttonGenerate.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                buttonGenerateActionPerformed(evt);
//            }
//        });

//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
//        this.setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(layout.createSequentialGroup()
//                        .addContainerGap(6, 6)
//                        .addComponent(panelPattern, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addGroup(layout.createSequentialGroup()
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                    .addComponent(labelFocal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                    .addComponent(labelXpos)
//                                    .addComponent(labelYpos))
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                    .addComponent(textYpos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                    .addComponent(textXpos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                    .addComponent(textFocal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                            .addComponent(buttonGenerate))))
//                .addContainerGap(6, 6))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addContainerGap(6, 6)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addComponent(panelPattern, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addGroup(layout.createSequentialGroup()
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                            .addComponent(labelFocal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
//                            .addComponent(textFocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                            .addComponent(labelXpos)
//                            .addComponent(textXpos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                            .addComponent(labelYpos)
//                            .addComponent(textYpos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                        .addComponent(buttonGenerate))))
//        );
        
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel1 = new javax.swing.JLabel();
        textFocal = new javax.swing.JTextField();
        sliderFocal = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        textXpos = new javax.swing.JTextField();
        sliderXpos = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        textYpos = new javax.swing.JTextField();
        sliderYPos = new javax.swing.JSlider();
        ok = new javax.swing.JButton();

        jLabel1.setText("Focal length");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, sliderFocal, org.jdesktop.beansbinding.ELProperty.create("${value}"), textFocal, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        sliderFocal.setMaximum(100000);
        sliderFocal.setValue(522);
        sliderFocal.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGenerateActionPerformed(evt);
            }
        });

        jLabel2.setText("X Postion");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, sliderXpos, org.jdesktop.beansbinding.ELProperty.create("${value}"), textXpos, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);
        
        sliderXpos.setMaximum(100);
        sliderXpos.setValue(0);
        sliderXpos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGenerateActionPerformed(evt);
            }
        });

        jLabel3.setText("Y Postion");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, sliderYPos, org.jdesktop.beansbinding.ELProperty.create("${value}"), textYpos, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        sliderYPos.setMaximum(100);
        sliderYPos.setValue(0);
        sliderYPos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGenerateActionPerformed(evt);
            }
        });

        ok.setText("Generate");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPattern, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textYpos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFocal, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textXpos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sliderXpos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(sliderFocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sliderYPos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPattern, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(textFocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sliderFocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sliderXpos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textXpos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sliderYPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(textYpos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    // Optical arguments, which will be parsed before reassigning the values
    private double xoff=0.0, yoff=0.0, focal=522;
    private boolean parseArguments() {
    	boolean ret = false;
    	try {
	    	double xoff = Double.valueOf(textXpos.getText());
	    	double yoff = Double.valueOf(textYpos.getText());
	    	double focal = Double.valueOf(sliderFocal.getValue());
	    	ret = true;	    	
	    	this.xoff=xoff;
	    	this.yoff=yoff;
	    	this.focal=focal;
    	}
    	catch (Exception e) {
    		JOptionPane.showMessageDialog(null, warnings);
                textXpos.setText(String.valueOf(this.yoff));
    		textYpos.setText(String.valueOf(this.yoff));
    		textFocal.setText(String.valueOf(this.focal));
    	}
    	return ret;
    }
    
    private String genLog() {
		return String.format(logmessage, Double.toString(xoff), Double.toString(yoff), Double.toString(focal));
    }

    private void buttonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
		if (parseArguments()) {
			PatternImage image = ((EduPatternJPanel)panelPattern).pimage; 
			image.updateLensParameter(xoff, yoff, focal);
			image.paintLens();
			EduPatternTest.updateLensPattern(image, genLog());
			imageGenerated = true;
		}
    }//GEN-LAST:event_buttonGenerateActionPerformed
    
    private void sliderGenerateActionPerformed(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderGenerateActionPerformed
		if (parseArguments()) {
			PatternImage image = ((EduPatternJPanel)panelPattern).pimage; 
			image.updateLensParameter(xoff, yoff, focal);
			image.paintLens();
			EduPatternTest.updateLensPatternPattern(image, genLog());
			imageGenerated = true;
		}
    }//GEN-LAST:event_sliderGenerateActionPerformed

    private void textFocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFocalActionPerformed

    private void textYposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textYposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textYposActionPerformed

    private void textXposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textXposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textXposActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
//    private javax.swing.JButton buttonGenerate;
//    private javax.swing.JLabel labelFocal;
//    private javax.swing.JLabel labelXpos;
//    private javax.swing.JLabel labelYpos;
    private javax.swing.JPanel panelPattern;
    //private javax.swing.JTextField textFocal;
    //private javax.swing.JTextField textYpos;
    
    private javax.swing.JSlider sliderXpos;
    private javax.swing.JSlider sliderYPos;
    private javax.swing.JSlider sliderFocal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton ok;
    private javax.swing.JTextField textXpos;
    private javax.swing.JTextField textYpos;
    private javax.swing.JTextField textFocal;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    @Override
	void updatePatternScreen() {
		PatternImage image = ((EduPatternJPanel)panelPattern).pimage; 
		if (!imageGenerated) {
			image.updateLensParameter(xoff, yoff, focal);
			image.paintLens();
			imageGenerated = true;
		}
		EduPatternTest.updatePatternScreen(image, genLog());
	}
    
    // paint boot screen, lens only
    void bootScreen() {
    	PatternImage image = ((EduPatternJPanel)panelPattern).pimage;
    	double xoff = 0.0;
    	double yoff = 0.0;
    	double focal = 522;
    	image.updateLensParameter(xoff, yoff, focal);
    	image.paintLens();    	
    }

    void updateRegenerate() {
    	PatternImage image = ((EduPatternJPanel)panelPattern).pimage;
		if (imageGenerated) {
	    	image.updateLensParameter(xoff, yoff, focal);
	    	image.paintLens();
		}
    }

    static String logmessage="pattern lens xoff=%s yoff=%s focal=%s";
}
