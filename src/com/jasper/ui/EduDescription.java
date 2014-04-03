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
    static String a = "<html>"
            + "<div style=\"padding-left:5px;padding-top:5px;margin: 0 0.07em 0 -0.13em;background-color:white;width:100%;word-spacing:30px;font-family:MS Mincho;font-size:11px;font-weight: normal;\">"
            + "&nbsp; &nbsp; &nbsp; LCoS-SLM (Liquid Crystal on Silicon-Spatial Light Modulator) can modulate amplitude,<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + " phase, or polarization of light waves in space and time.<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + " The structure of LCoS SLM is like normal liquid crystal display,<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + " it consists of many square shape pixels and form a matrix structure,<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + " when voltage is applied every liquid crystal in each pixel will rotate with different<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + " angle and different rotating angle causes different index of refraction to achieve modulation.<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + " When the voltage is not applied, the basic structure of SLM will affect the light including<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + " diffraction efficiency, and the change in polarization state,<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + " using these characteristics we can calculate the basic SLM parameters such as:<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + " the pixel size, the aperture ratio, and with the angle.<br /></div></html>";
    static String b = "<html><div style=\"padding-left:5px;padding-top:5px;margin: 0 0.07em 0 -0.13em;background-color:white;width:100%;word-spacing:30px;font-family:MS Mincho;font-size:11px;font-weight: normal;\">"
            + "&nbsp; &nbsp; &nbsp; SLM can be used as Phase modulator or Amplitude modulator "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "with the angle adjustment of polarizer and analyzer."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "In this experiment, the polarizer and the analyzer are arranged at an angle"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "of 45 degree to the rubbing angle such that SLM acts as amplitude modulator."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "The whole set of optical projection is simple system"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "and this can also be used to understand the parameters of imaging system, "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "such as the f-number, aperture stop, "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "entrance pupil and exit pupil and so on."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "<br /></div></html>";
    static String c = "<html><div style=\"padding-left:5px;padding-top:5px;margin: 0 0.07em 0 -0.13em;background-color:white;width:100%;word-spacing:30px;font-family:MS Mincho;font-size:11px;font-weight: normal;\">"
            + "&nbsp; &nbsp; &nbsp; In the second experiment, the analyzer and polarized arranged at"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "the angle of 45 degrees to the rubbing angle."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "In this experiment, the polarizer and analyzer are arranged in parallel to rubbing angle such that"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "SLM can be used as phase modulator. Then we use "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "the tilted grating (Blazed Grating) which allows the phase modulator to do"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "simple beam control (Beam Steering) experiments to understand the limits "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "of diffraction angles. "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + ""
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "<br /></div></html>";
    static String d = "<html><div style=\"padding-left:5px;padding-top:5px;margin: 0 0.07em 0 -0.13em;background-color:white;width:100%;word-spacing:30px;font-family:MS Mincho;font-size:11px;font-weight: normal;\">"
            + "&nbsp; &nbsp; &nbsp; The Michelson interferometer is the most common configuration for optical interferometry"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "and was invented by Albert Abraham Michelson."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "The basic operation of the interferometer is as follows. "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "Light from a light source is split into two parts."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "One part of the light travels a different path length than the other. "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "After traversing these different path lengths, the two parts of the light "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "are brought together and recombined to form an interference pattern."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "Interference will occur when the pathlength difference is less"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "than the coherence length of the light source."
            + "<br /></div></html>";
    static String e = "<html><div style=\"padding-left:5px;padding-top:5px;margin: 0 0.07em 0 -0.13em;background-color:white;width:100%;word-spacing:30px;font-family:MS Mincho;font-size:11px;font-weight: normal;\">"
            + "&nbsp; &nbsp; &nbsp; The phenomenon of diffraction can be understood using Huygens ’"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "principle which states that every unobstructed point on a wavefront will"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "act as a source of secondary spherical waves."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "A long slit of infinitesimal width which is illuminated by light "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "diffracts the light into a series of circular waves and the"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "wavefront which emerges from the slit is a cylindrical wave of uniform intensity."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "The light from one portion of the slit can interfere with light from another portion and all the "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "waves that originate at the slit are in phase. If the path difference is exactly half of a wavelength,"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "the two waves cancel each other and resulting in destructive interference."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "The double-slit experiment, sometimes called Young's experiment (after Young's"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "interference experiment), is a demonstration that matter and energy can display "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "characteristics of both waves and particles, and demonstrates the fundamentally probabilistic"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "nature of quantum mechanical phenomena. A monochromatic light source is incident on the first"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "screen which contains a slit. The emerging light then arrives at"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "the second screen which has two parallel slits which serve as the sources of coherent light. "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "The light waves emerging from the two slits of the second screen then interfere and form an "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "interference pattern on the viewing screen. The bright bands (fringes)"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "correspond to interference maxima, and the dark bands correspond to interference minima."
            + "<br /></div></html>";
    
    static String g = "<html><div style=\"padding-left:5px;padding-top:5px;margin: 0 0.07em 0 -0.13em;background-color:white;width:100%;word-spacing:30px;font-family:MS Mincho;font-size:11px;font-weight: normal;\">"
            + "&nbsp; &nbsp; &nbsp; A spectrophotometer is employed to measure the amount of light that a"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "sample absorbs. The instrument operates by passing a beam of light through"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "a sample and measuring the intensity of light reaching a detector. "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "The angles at which these bright fringes occur can be measured with a device called a spectrometer."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "These angles, along with the diffraction grating line spacing can then be used to calculate"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "the wavelength of the light passing through the grating via the grating equation "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "<div style=\\\"font-size:16px;font-weight:bold;\\\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; dsinθm = mλ, m = 1, 2, 3, …, </div>"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "where the order of the spectrum is given by the integer values of m. "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "Spectroscopy is often used in optical properties of various materials, "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "because the spectrometer can analyze and measure the spectral intensity distribution of each wavelength. "
            + "<br /></div></html>";
    
    static String h = "<html><div style=\"padding-left:5px;padding-top:5px;margin: 0 0.07em 0 -0.13em;background-color:white;width:100%;word-spacing:30px;font-family:MS Mincho;font-size:11px;font-weight: normal;\">"
            + "&nbsp; &nbsp; &nbsp; 4f optical system on a common signal processing system consist lenses "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "and filter as the two main components. "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "The input signal is applied to the front focal plane of first lens and will "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "be Fourier transformed by the first lens to obtain spectrum result in the back focal plane."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "A second lens is behind the spectrum and the spectrum is in the front focal plane of"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "second lens and is Fourier transformed again by the second lens. If we want to filter out some signal,"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "we can block any frequency in the spectrum plane, and get the result at the back focal plane of second lens."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "<br /></div></html>";
    
    static String i = "<html><div style=\"padding-left:5px;padding-top:5px;margin: 0 0.07em 0 -0.13em;background-color:white;width:100%;word-spacing:30px;font-family:MS Mincho;font-size:11px;font-weight: normal;\">"
            + "&nbsp; &nbsp; &nbsp; Holography is one popular choice among several techniques for "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "the imaging and display of three-dimensional (3D) objects."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "Storage of the hologram in a computer enables us to reduce the noise through image processing"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "techniques and numerically reconstruct the object with arbitrary views. Phase shift digital "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "holography uses the object beam and three to four different sets of the initial phase of reference light interference fringes."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "The in-line configuration makes use of the full pixel count in forming the holographic"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "image, but the zero-order and the twin image terms are superposed"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "on the image. The complex field at the hologram is obtained by phase-shifting interferometry."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "From the complex field at the hologram plane, including the amplitude and phase information, "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "the optical field at any other plane can be obtained by one of the numerical diffraction methods."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "In four-step phase-shifting digital holography (PSDH), four holograms with phase shifts"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "ψ = 0, π/2, π, 3π/2 are acquired, which are then numerically combined to extract the amplitude and phase profiles."
            + "<br /></div></html>";
    
    static String k = "<html><div style=\"padding-left:5px;padding-top:5px;margin: 0 0.07em 0 -0.13em;background-color:white;width:100%;word-spacing:30px;font-family:MS Mincho;font-size:11px;font-weight: normal;\">"
            + "&nbsp; &nbsp; &nbsp; The near field diffraction theory (Fresnel Diffraction) has a very "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "complicated integral formula. However, periodic diffraction grating has simpler "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "and specific results from imaging phenomenon. Periodic structures diffract light, and such diffracted"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "light interferes in the vicinity of the structure. Potentially the simplest example for a periodic "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "structure is an amplitude grating that diffracts the light into discrete directions."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "In the Fresnel diffraction regime, these diffraction orders interfere and cause a self-imaging phenomenon of the grating."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "This phenomenon is known as the Talbot effect. "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + ""
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + ""
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + ""
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + ""
            + "<br /></div></html>";
    
    static String l = "<html><div style=\"padding-left:5px;padding-top:5px;margin: 0 0.07em 0 -0.13em;background-color:white;width:100%;word-spacing:30px;font-family:MS Mincho;font-size:11px;font-weight: normal;\">"
            + "&nbsp; &nbsp; &nbsp; A Spatial Light Modulator (SLM) is a device that is used to modulate amplitude, "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "phase, or polarization of light waves in space and time."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "Arbitrary complex field modulation is produced by the use of the pixels of an SLM."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "The phase modulation capability of an SLM spatially encodes the complex data on pixels and these data "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "can produce many kinds of Diffractive Optical Elements (DOE)."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "By the flexibility of spatial light modulation, we can even apply some function to these DOE. "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "For example, a blazed grating can change the orientation of light propagation, "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "a zone plate can change the imaging plane backward or forward and other"
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "functions can apply to different application."
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + ""
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + ""
            + "<br /></div></html>";
    
    static String m = "<html><div style=\"padding-left:5px;padding-top:5px;margin: 0 0.07em 0 -0.13em;background-color:white;width:100%;word-spacing:30px;font-family:MS Mincho;font-size:11px;font-weight: normal;\">"
            + "&nbsp; &nbsp; &nbsp; "
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + ""
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + ""
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + ""
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + ""
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + ""
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + ""
            + "<br /><div style=\\\"width:100%;height:3px;\\\"></div>"
            + "<br /></div></html>";

    public static void initDescription() {
        final ResourceBundle labels = ResourceBundle
                .getBundle("resources/description", EduUIMainView.supportedLocales[0]);

//        desTelephotoLens.setText(labels.getString("desTelephotoLens"));
//        desMicroscope.setText(labels.getString("desMicroscope"));
//        desAberration.setText(labels.getString("desAberration"));
//        desMichelson.setText(labels.getString("desMichelson"));
//        desDiffaction.setText(labels.getString("desDiffaction"));
//        desSpectrometer.setText(labels.getString("desSpectrometer"));
//        desSignalProcessing.setText(labels.getString("desSignalProcessing"));
//        desPhaseRetarder.setText(labels.getString("desPhaseRetarder"));
//        desTalbotImage.setText(labels.getString("desTalbotImage"));
//        desWavefront.setText(labels.getString("desWavefront"));
//        desWavelength.setText(labels.getString("desWavelength"));
//        desCalibration.setText(labels.getString("desCalibration"));
//        desImportfile.setText(labels.getString("desImportfile"));
        desTelephotoLens.setText(a);
        desMicroscope.setText(b);
        desAberration.setText(c);
        desMichelson.setText(d);
        desDiffaction.setText(e);
        desSpectrometer.setText(g);
        desSignalProcessing.setText(h);
        desPhaseRetarder.setText(i);
        desTalbotImage.setText(k);
        desWavefront.setText(l);
        desWavelength.setText(m);
        desCalibration.setText(labels.getString("desCalibration"));
        desImportfile.setText(labels.getString("desImportfile"));

    }
}
