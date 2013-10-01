package com.jasper;

import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Albert
 */
public class Mirror extends OpticsPane {

    /**
     * Creates new form CylincalLens
     */
    public Mirror() {
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
        textYpos = new javax.swing.JTextField();

        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        sliderFocal = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        textXpos = new javax.swing.JTextField();
        sliderXpos = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        textYpos = new javax.swing.JTextField();
        sliderYPos = new javax.swing.JSlider();
        ok = new javax.swing.JButton();

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, sliderFocal, org.jdesktop.beansbinding.ELProperty.create("${value}"), org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel2.setText("Phy");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, sliderXpos, org.jdesktop.beansbinding.ELProperty.create("${value}"), textXpos, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);
        
        //textXpos.setText("" + sliderXpos.getValue() / 100.0D);
        sliderXpos.setMaximum(10000);
        sliderXpos.setMinimum(-10000);
        sliderXpos.setValue(522);
        sliderXpos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGenerateActionPerformed(evt);
            }
        });

        jLabel3.setText("Theta");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, sliderYPos, org.jdesktop.beansbinding.ELProperty.create("${value}"), textYpos, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        sliderYPos.setMaximum(10000);
        sliderYPos.setMinimum(-10000);
        sliderYPos.setValue(522);
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
                .addComponent(panelPattern, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(textYpos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textXpos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sliderXpos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(sliderYPos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPattern, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
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
                        .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    // Optical arguments, which will be parsed before reassigning the values
    private double phy=522.0D, theta=522.0D;
    private boolean parseArguments() {
    	boolean ret = false;
    	try {
                double phy = Double.valueOf(textXpos.getText());
        	double theta = Double.valueOf(textYpos.getText());	    	
	    	ret = true;	    	
	    	this.phy=phy;
	    	this.theta=theta;
    	}
    	catch (Exception e) {
                JOptionPane.showMessageDialog(null, warnings);
    		textXpos.setText(String.valueOf(this.phy));
    		textYpos.setText(String.valueOf(this.theta));
    	}
    	return ret;
    }
    
    private String genLog() {
		return String.format(logmessage, Double.toString(phy), Double.toString(theta));
    }

    private void buttonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
		if (parseArguments()) {
			PatternImage image = ((EduPatternJPanel)panelPattern).pimage; 
			image.updateMirrorParameter(phy, theta);
			image.paintMirror();
			EduPatternTest.updateLensPattern(image, genLog());
			imageGenerated = true;
		}
    }//GEN-LAST:event_buttonGenerateActionPerformed
    
    private void sliderGenerateActionPerformed(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderGenerateActionPerformed
		if (parseArguments()) {
			PatternImage image = ((EduPatternJPanel)panelPattern).pimage; 
			image.updateMirrorParameter(phy, theta);
			image.paintMirror();
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
    private javax.swing.JPanel panelPattern;
    
    private javax.swing.JSlider sliderXpos;
    private javax.swing.JSlider sliderYPos;
    private javax.swing.JSlider sliderFocal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton ok;
    private javax.swing.JTextField textXpos;
    private javax.swing.JTextField textYpos;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    @Override
    void updatePatternScreen() {
        PatternImage image = ((EduPatternJPanel)panelPattern).pimage; 
        if (!imageGenerated) {
                image.updateMirrorParameter(phy, theta);
                image.paintMirror();
                imageGenerated = true;
        }
        EduPatternTest.updatePatternScreen(image, genLog());
    }
    
    void updateRegenerate() {
    	PatternImage image = ((EduPatternJPanel)panelPattern).pimage;
        if (imageGenerated) {
            image.updateMirrorParameter(phy, theta);
            image.paintMirror();
        }
    }

    static String logmessage="pattern Mirror phy=%s theta=%s";
}
