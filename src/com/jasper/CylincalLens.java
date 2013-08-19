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
public class CylincalLens extends OpticsPane {

    /**
     * Creates new form CylincalLens
     */
    public CylincalLens() {
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
        labelFocal = new javax.swing.JLabel();
        textFocal = new javax.swing.JTextField();
        labelXpos = new javax.swing.JLabel();
        textXpos = new javax.swing.JTextField();
        labelRotation = new javax.swing.JLabel();
        textRotation = new javax.swing.JTextField();
        buttonGenerate = new javax.swing.JButton();

        javax.swing.GroupLayout panelPatternLayout = new javax.swing.GroupLayout(panelPattern);
        panelPattern.setLayout(panelPatternLayout);
        panelPatternLayout.setHorizontalGroup(
            panelPatternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        panelPatternLayout.setVerticalGroup(
            panelPatternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );

        labelFocal.setText("Focal length");

        textFocal.setText("1.0");
        textFocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFocalActionPerformed(evt);
            }
        });

        labelXpos.setText("X Position");

        textXpos.setText("0.0");
        textXpos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textXposActionPerformed(evt);
            }
        });

        labelRotation.setText("Rotation");

        textRotation.setText("0.0");
        textRotation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textRotationActionPerformed(evt);
            }
        });

        buttonGenerate.setText("Generate");
        buttonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(6, 6)
                        .addComponent(panelPattern, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelFocal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelXpos)
                                    .addComponent(labelRotation))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textRotation, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textXpos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFocal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(buttonGenerate))))
                .addContainerGap(6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(6, 6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPattern, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelFocal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelXpos)
                            .addComponent(textXpos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelRotation)
                            .addComponent(textRotation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonGenerate))))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Optical arguments, which will be parsed before reassigning the values
    private double xoff=0.0, angle=0.0, focal=1.0;
    private boolean parseArguments() {
    	boolean ret = false;
    	try {
	    	double xoff = Double.valueOf(textXpos.getText());
	    	double angle = Double.valueOf(textRotation.getText());
	    	double focal = Double.valueOf(textFocal.getText());
	    	ret = true;
	    	this.xoff=xoff;
	    	this.angle=angle;
	    	this.focal=focal;
    	}
    	catch (Exception e) {
    		JOptionPane.showMessageDialog(null, warnings);
    		textXpos.setText(String.valueOf(this.xoff));
    		textRotation.setText(String.valueOf(this.angle));
    		textFocal.setText(String.valueOf(this.focal));
    	}
    	return ret;
    }
    
    private String genLog() {
		return String.format(logmessage, Double.toString(xoff), Double.toString(angle), Double.toString(focal));
    }
    
    private void buttonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
    	if (parseArguments()) {
    		PatternImage image = ((EduPatternJPanel)panelPattern).pimage; 
    		image.updateCyllindricalParameter(xoff, angle, focal);
    		image.paintCylindircal();
    		EduPatternTest.updateCylindricalPattern(image, genLog());
    		imageGenerated = true;
    	}
    }//GEN-LAST:event_buttonGenerateActionPerformed

    private void textFocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFocalActionPerformed
    }//GEN-LAST:event_textFocalActionPerformed

    private void textXposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textXposActionPerformed
    }//GEN-LAST:event_textXposActionPerformed

    private void textRotationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textRotationActionPerformed
    }//GEN-LAST:event_textRotationActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonGenerate;
    private javax.swing.JLabel labelFocal;
    private javax.swing.JLabel labelRotation;
    private javax.swing.JLabel labelXpos;
    private javax.swing.JPanel panelPattern;
    private javax.swing.JTextField textFocal;
    private javax.swing.JTextField textRotation;
    private javax.swing.JTextField textXpos;
    // End of variables declaration//GEN-END:variables

    @Override
	void updatePatternScreen() {
    	PatternImage image = ((EduPatternJPanel)panelPattern).pimage;
		if (!imageGenerated) {
	    	image.updateCyllindricalParameter(xoff, angle, focal);
	    	image.paintCylindircal();
	    	imageGenerated = true;
		}
    	EduPatternTest.updatePatternScreen(image, genLog());		
	}

    void updateRegenerate() {
    	PatternImage image = ((EduPatternJPanel)panelPattern).pimage;
		if (imageGenerated) {
	    	image.updateCyllindricalParameter(xoff, angle, focal);
	    	image.paintCylindircal();
		}
    }

    static String logmessage="pattern cylindric xoff=%s angle=%s focal=%s";
}
