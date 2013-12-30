/*
 * @(#)EduDescription.java
 *
 * Copyright (c) 2013 JASPER DISPLAY, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * JASPER DISPLAY PROPRIETARY:  Distribution of this source code
 * without permission from the copyright holder is strictly forbidden.
 */
package com.jasper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 * This EduDescription include the description information of application
 *
 * @version 1.0 28 Aug 2013
 *
 * @author sonnv
 *
 */
public class EduDescription {

    public static javax.swing.JLabel desTelephotoLens =
            new JLabel();
    public static javax.swing.JLabel desMicroscope =
            new JLabel();
    public static javax.swing.JLabel desAberration =
            new JLabel();
    public static javax.swing.JLabel desMichelson =
            new JLabel();
    public static javax.swing.JLabel desDiffaction =
            new JLabel();
    public static javax.swing.JLabel desSpectrometer =
            new JLabel();
    public static javax.swing.JLabel desSignalProcessing =
            new JLabel();
    public static javax.swing.JLabel desPhaseRetarder =
            new JLabel();
    public static javax.swing.JLabel desTalbotImage =
            new JLabel();
    public static javax.swing.JLabel desWavefront =
            new JLabel();
    public static javax.swing.JLabel desWavelength =
            new JLabel();
    public static javax.swing.JLabel desCalibration =
            new JLabel();
    public static javax.swing.JLabel desImportfile =
            new JLabel();

    public static void initDescription() {
        /*
        java.io.BufferedReader br = null;
        try {
        br = new java.io.BufferedReader(new java.io.FileReader("des.txt"));
        
        String line;
        String label, desc;
        
        line = br.readLine();
        System.out.println(desTelephotoLens.getName());
        
        while (line != null) {
        if (line.equals("#")) {
        label = br.readLine();
        System.out.println(label);
        desc = br.readLine();
        StringBuilder sb = new StringBuilder();
        while(!desc.equals("#")){
        sb.append(desc);
        sb.append('\n');
        desc = br.readLine();
        if(desc == null) break;
        }
        line = desc;
        desc = sb.toString();
        
        System.out.println(desc);
        if (label.equals("desTelephotoLens")) {
        desTelephotoLens.setText(desc);
        } else if (label.equals("desMicroscope")) {
        desMicroscope.setText(desc);
        } else if (label.equals("desAberration")) {
        desAberration.setText(desc);
        } else if (label.equals("desMichelson")) {
        desMichelson.setText(desc);
        } else if (label.equals("desDiffaction")) {
        desDiffaction.setText(desc);
        } else if (label.equals("desSpectrometer")) {
        desSpectrometer.setText(desc);
        } else if (label.equals("desSignalProcessing")) {
        desSignalProcessing.setText(desc);
        } else if (label.equals("desPhaseRetarder")) {
        desPhaseRetarder.setText(desc);
        } else if (label.equals("desTalbotImage")) {
        desTalbotImage.setText(desc);
        } else if (label.equals("desWavefront")) {
        desWavefront.setText(desc);
        } else if (label.equals("desWavelength")) {
        desWavelength.setText(desc);
        } else if (label.equals("desCalibration")) {
        desCalibration.setText(desc);
        } else if (label.equals("desImportfile")) {
        desImportfile.setText(desc);
        }
        }
        
        line = br.readLine();
        }
        br.close();
        } catch (FileNotFoundException ex) {
        Logger.getLogger(EduDescription.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
        Logger.getLogger(EduDescription.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         */

        final ResourceBundle labels = ResourceBundle.getBundle("resources/description", EduUIMainView.supportedLocales[0]);

        desTelephotoLens.setText(labels.getString("desTelephotoLens"));
        desMicroscope.setText(labels.getString("desMicroscope"));
        desAberration.setText(labels.getString("desAberration"));
        desMichelson.setText(labels.getString("desMichelson"));
        desDiffaction.setText(labels.getString("desDiffaction"));
        desSpectrometer.setText(labels.getString("desSpectrometer"));
        desSignalProcessing.setText(labels.getString("desSignalProcessing"));
        desPhaseRetarder.setText(labels.getString("desPhaseRetarder"));
        desTalbotImage.setText(labels.getString("desTalbotImage"));
        desWavefront.setText(labels.getString("desWavefront"));
        desWavelength.setText(labels.getString("desWavelength"));
        desCalibration.setText(labels.getString("desCalibration"));
        desImportfile.setText(labels.getString("desImportfile"));

    }
}
