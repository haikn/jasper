/*
 * @(#)EduDescription.java
 *
 * Copyright (c) 2013 JASPER DISPLAY, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * JASPER DISPLAY PROPRIETARY:  Distribution of this source code
 * without permission from the copyright holder is strictly forbidden.
 */
package com.jasper.ui;

import java.util.ResourceBundle;
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
        final ResourceBundle labels = ResourceBundle
                .getBundle("resources/description", EduUIMainView.supportedLocales[0]);

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
