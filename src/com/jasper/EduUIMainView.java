package com.jasper;

import com.jasper.michelson.Graf_Michelson;
import com.jasper.michelson.Img_Michelson;
import com.jasper.michelson.Interferometros;
import com.patterns.Drawpicture;
import com.patterns.Jdoubleslit;
import com.patterns.Jsignalprocessing;
import com.patterns.Jsingleslit;
import difraccion.DifraccionApplet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JComboBox;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;

public class EduUIMainView extends javax.swing.JFrame {

    /**
     * Creates new form EduUIMainView
     */
    public EduUIMainView() {
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

        jTabbedPaneOptics = new javax.swing.JTabbedPane();
        jPanelLens1 = new Lens ();
        jPanelLens2 = new Lens ();
        jPanelLens3 = new Lens ();
        jPanelLens4 = new Lens ();
        jPanelCylindrical1 = new CylincalLens();
        jPanelCylindrical2 = new CylincalLens();
        jPanelMicroscope1 = new Microscope();
        jPanelMirror1 = new Mirror();
        jPanelMirror2 = new Mirror();
        jPanelMirror3 = new Mirror();
        jPanelMirror4 = new Mirror();
        // Aber
        jPanelAber1 = new Mirror();
        // Mach
        jPanelMach1 = new Mach();
        // Michelson
        jPanelMich1 = new Michelson();
        jPanelMich2 = new Michelson();
        jPanelMich3 = new Michelson();
        jPanelMich4 = new Michelson();
        // Diffraction
        jPanelDiffraction1 = new Diffraction();
        // Spectrometer
        jPanelSpectrometer1 = new Spectrometer();
        // Signal Processing
        jPanelSignal1 = new Signal();
        // Phase
        jPanelPhase1 = new Phase();
        // Talbot
        jPanelTalbot1 = new Talbot();
        // Wavefront
        jPanelWavefront1 = new Wavefront();
        // Wavelength
        jPanelWavelength1 = new Wavelength();
        jPanelTest = new com.jasper.Singleslit();
        jPanelMisc = new MiscOptics(); // new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaLog = new javax.swing.JTextArea();
        jMenuBarMain = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenuOptical = new javax.swing.JMenu();
        jMenuGeometric = new javax.swing.JMenu();
        jMenuItemTelephoto = new javax.swing.JMenuItem();
        jMenuItemMicroscope = new javax.swing.JMenuItem();
        jMenuItemAberration = new javax.swing.JMenuItem();
        jMenuWave = new javax.swing.JMenu();
        jMenuItemMichelson = new javax.swing.JMenuItem();
        jMenuItemMachZender = new javax.swing.JMenuItem();
        jMenuItemDiffraction = new javax.swing.JMenuItem();
        jMenuItemSpectrometer = new javax.swing.JMenuItem();
        jMenuFourier = new javax.swing.JMenu();
        jMenuItemSignalProcessing = new javax.swing.JMenuItem();
        jMenuItemPhaseShifting = new javax.swing.JMenuItem();
        jMenuItemTalbotImages = new javax.swing.JMenuItem();
        jMenuItemWavefront = new javax.swing.JMenuItem();
        jMenuMisc = new javax.swing.JMenu();
        jMenuItemWavelength = new javax.swing.JMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuDraw = new javax.swing.JMenu();
        jMenuItemSingleSlit = new javax.swing.JMenuItem();
        jMenuItemDifractionSlit = new javax.swing.JMenuItem();
        jMenuItemDoubleSlit = new javax.swing.JMenuItem();
        jMenuItemDrawSignalProcessing = new javax.swing.JMenuItem();
        jMenuItemDrawPhaseRetarder = new javax.swing.JMenuItem();
        jMenuItemTest = new javax.swing.JMenuItem();
        jMenuItemAbout = new javax.swing.JMenuItem();
        
        // menu item for load phase to grayscale table
        jMenuItemLoadP2GTable = new javax.swing.JMenuItem();

        // add optics panes to panelist
        panelist = new ArrayList <OpticsPane>();
        panelist.add((OpticsPane)jPanelLens1);
        panelist.add((OpticsPane)jPanelLens2);
        panelist.add((OpticsPane)jPanelLens3);
        panelist.add((OpticsPane)jPanelLens4);
        panelist.add((OpticsPane)jPanelCylindrical1);
        panelist.add((OpticsPane)jPanelCylindrical2);
        // Microscope
        panelist.add((OpticsPane)jPanelMicroscope1);
        
        panelist.add((OpticsPane)jPanelMirror1);
        panelist.add((OpticsPane)jPanelMirror2);
        panelist.add((OpticsPane)jPanelMirror3);
        panelist.add((OpticsPane)jPanelMirror4);
        // Aber
        panelist.add((OpticsPane)jPanelAber1);
        // Mach
        panelist.add((OpticsPane)jPanelMach1);
        // Michelson
        panelist.add((OpticsPane)jPanelMich1);
        panelist.add((OpticsPane)jPanelMich2);
        panelist.add((OpticsPane)jPanelMich3);
        panelist.add((OpticsPane)jPanelMich4);
        // Diffraction
        panelist.add((OpticsPane)jPanelDiffraction1);
        // Spectrometer
        panelist.add((OpticsPane)jPanelSpectrometer1);
        // Signal Processing
        panelist.add((OpticsPane)jPanelSignal1);
        // Phase
        panelist.add((OpticsPane)jPanelPhase1);
        // Tabot
        panelist.add((OpticsPane)jPanelTalbot1);
        // Wavefront
        panelist.add((OpticsPane)jPanelWavefront1);
        //Wavelength
        panelist.add((OpticsPane)jPanelWavelength1);
        
        panelist.add((OpticsPane)jPanelTest);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // BEGIN paint boot screen, a lens pattern
        ((Lens)jPanelLens1).bootScreen();
//        jTabbedPaneOptics.addTab("Lens", jPanelLens1);
//
//        jTabbedPaneOptics.addTab("Cylindrical lens", jPanelCylindrical1);
//
//        jTabbedPaneOptics.addTab("Mirror", jPanelMirror1);
//
//        jTabbedPaneOptics.addTab("Misc", jPanelMisc);
        jTabbedPaneOptics.addTab("General", jPanelLens1);
        jTabbedPaneOptics.addTab("Single slit", jPanelTest);
        jTabbedPaneOptics.addTab("Double slit", jPanelMirror1);
        jTabbedPaneOptics.addTab("Signsl processing", jPanelMicroscope1);
        jTabbedPaneOptics.addTab("Phase retarder", jPanelCylindrical1);
        
        // END paint boot screen, a lens pattern

        // JAL, disable optics tabbed pane by default
        setTabPanelEnable(jTabbedPaneOptics, true);
        
        jTextAreaLog.setColumns(20);
        jTextAreaLog.setRows(5);
        jTextAreaLog.setFont(new Font("Courier New", Font.PLAIN, 12));
        jScrollPane2.setViewportView(jTextAreaLog);
        jTextAreaLog.setEditable(false);
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1. Telephoto lens", "2. Microscope", "3. Aberration (Foucault test)",
            "4. Michelson Interferometer", "5. Mach-Zender Interfrometer", "6. Diffraction and Interference", "7. Spectrometer",
        "8. Signal Processing (4-f system)", "9. Phase Shifting Digital Holography", "10. Talbot Images", "11. Wavefront Modulation", "12. Wavelength Selective Switch" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBox comboBox = (JComboBox) evt.getSource();

                Object selected = comboBox.getSelectedItem();
                if(selected.equals("1. Telephoto lens")){
                    jMenuItemTelephotoActionPerformed(evt);
                } else if(selected.equals("2. Microscope")){
                    jMenuItemMicroscopeActionPerformed(evt);
                } else if(selected.equals("3. Aberration (Foucault test)")){
                    jMenuItemAberrationActionPerformed(evt);
                } else if(selected.equals("4. Michelson Interferometer")){
                    jMenuItemMichelsonActionPerformed(evt);
                } else if(selected.equals("5. Mach-Zender Interfrometer")){
                    jMenuItemMachZenderActionPerformed(evt);
                } else if(selected.equals("6. Diffraction and Interference")){
                    jMenuItemDiffractionActionPerformed(evt);
                } else if(selected.equals("7. Spectrometer")){
                    jMenuItemSpectrometerActionPerformed(evt);
                } else if(selected.equals("8. Signal Processing (4-f system)")){
                    jMenuItemSignalProcessingActionPerformed(evt);
                } else if(selected.equals("9. Phase Shifting Digital Holography")){
                    jMenuItemPhaseShiftingActionPerformed(evt);
                } else if(selected.equals("10. Talbot Images")){
                    jMenuItemTalbotImagesActionPerformed(evt);
                } else if(selected.equals("11. Wavefront Modulation")){
                    jMenuItemWavefrontActionPerformed(evt);
                } else if(selected.equals("12. Wavelength Selective Switch")){
                    jMenuItemWavelengthActionPerformed(evt);
                }
            }
        });
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setText("Select experiment:");

        jMenuFile.setText("File");
        // menu item for loading file of phase to gray scale table 
//        jMenuItemLoadP2GTable.setText("Load map table");
//        jMenuItemLoadP2GTable.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jMenuItemLoadP2GActionPerformed(evt);
//            }
//        });
//        jMenuFile.add(jMenuItemLoadP2GTable);


        jMenuItemExit.setText("Exit");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemExit);

        jMenuBarMain.add(jMenuFile);
        
        jMenuOptical.setText("Optical Experiments");

        jMenuGeometric.setText(catTitleGeom);

        jMenuItemTelephoto.setText(labTitleTele);
        jMenuItemTelephoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTelephotoActionPerformed(evt);
            }
        });
        jMenuGeometric.add(jMenuItemTelephoto);

        jMenuItemMicroscope.setText(labTitleMicr);
        jMenuItemMicroscope.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMicroscopeActionPerformed(evt);
            }
        });
        jMenuGeometric.add(jMenuItemMicroscope);

        jMenuItemAberration.setText(labTitleAber);
        jMenuItemAberration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAberrationActionPerformed(evt);
            }
        });
        jMenuGeometric.add(jMenuItemAberration);

        jMenuOptical.add(jMenuGeometric);

        jMenuWave.setText(catTitleWave);

        jMenuItemMichelson.setText(labTitleMich);
        jMenuItemMichelson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jMenuItemMichelsonActionPerformed(evt);
                String [] args = new String[1];
                args[0] = "EN";
                new Interferometros().main(args);
            }
        });
        jMenuWave.add(jMenuItemMichelson);

        jMenuItemMachZender.setText(labTitleMach);
        jMenuItemMachZender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMachZenderActionPerformed(evt);
            }
        });
        jMenuWave.add(jMenuItemMachZender);

        jMenuItemDiffraction.setText(labTitleDiff);
        jMenuItemDiffraction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDiffractionActionPerformed(evt);
            }
        });
        jMenuWave.add(jMenuItemDiffraction);

        jMenuItemSpectrometer.setText(labTitleSpec);
        jMenuItemSpectrometer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSpectrometerActionPerformed(evt);
            }
        });
        jMenuWave.add(jMenuItemSpectrometer);

        jMenuOptical.add(jMenuWave);

        jMenuFourier.setText(catTitleFour);

        jMenuItemSignalProcessing.setText(labTitleSign);
        jMenuItemSignalProcessing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSignalProcessingActionPerformed(evt);
            }
        });
        jMenuFourier.add(jMenuItemSignalProcessing);

        jMenuItemPhaseShifting.setText(labTitlePhas);
        jMenuItemPhaseShifting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPhaseShiftingActionPerformed(evt);
            }
        });
        jMenuFourier.add(jMenuItemPhaseShifting);

        jMenuItemTalbotImages.setText(labTitleTalb);
        jMenuItemTalbotImages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTalbotImagesActionPerformed(evt);
            }
        });
        jMenuFourier.add(jMenuItemTalbotImages);

        jMenuItemWavefront.setText(labTitleFron);
        jMenuItemWavefront.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemWavefrontActionPerformed(evt);
            }
        });
        jMenuFourier.add(jMenuItemWavefront);

        jMenuOptical.add(jMenuFourier);

        jMenuMisc.setText(catTitleOthe);

        jMenuItemWavelength.setText(labTitleLeng);
        jMenuItemWavelength.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemWavelengthActionPerformed(evt);
            }
        });
        jMenuMisc.add(jMenuItemWavelength);

        jMenuOptical.add(jMenuMisc);

        jMenuBarMain.add(jMenuOptical);
        
         // Draw
//        jMenuDraw.setText("Draw Image");
//        
////        jMenuItemDifractionSlit.setText("Difraction");
////        jMenuItemDifractionSlit.addActionListener(new java.awt.event.ActionListener() {
////            public void actionPerformed(java.awt.event.ActionEvent evt) {
////                 String [] args = new String[1];
////                args[0] = "EN";
////                new DifraccionApplet().main(args);
////            }
////        });
////        jMenuDraw.add(jMenuItemDifractionSlit);
//
//        jMenuItemSingleSlit.setText("Signle Slit");
//        jMenuItemSingleSlit.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jMenuItemTestActionPerformed(evt);
//            }
//        });
//        jMenuDraw.add(jMenuItemSingleSlit);
//        
//        jMenuItemDoubleSlit.setText("Double Slit");
//        jMenuItemDoubleSlit.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                new Jdoubleslit().setVisible(true);
//            }
//        });
//        jMenuDraw.add(jMenuItemDoubleSlit);
//        
//        jMenuItemDrawSignalProcessing.setText("Signal Processing");
//        jMenuItemDrawSignalProcessing.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                new Jsignalprocessing().setVisible(true);
//            }
//        });
//        jMenuDraw.add(jMenuItemDrawSignalProcessing);
//        
//        jMenuItemDrawPhaseRetarder.setText("Phase Retarder");
//        jMenuItemDrawPhaseRetarder.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                new Drawpicture().setVisible(true);
//            }
//        });
//        jMenuDraw.add(jMenuItemDrawPhaseRetarder);
//        
////        jMenuItemTest.setText("Test 123");
////        jMenuItemTest.addActionListener(new java.awt.event.ActionListener() {
////            public void actionPerformed(java.awt.event.ActionEvent evt) {
////                jMenuItemTestActionPerformed(evt);
////            }
////        });
////        jMenuDraw.add(jMenuItemTest);
//
//        jMenuBarMain.add(jMenuDraw);
        
        // END Draw image

        jMenuHelp.setText("Help");

        jMenuItemAbout.setText("About");
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuItemAbout);

        jMenuBarMain.add(jMenuHelp);
        
       

        setJMenuBar(jMenuBarMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(20, 20, 20)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 368, 368)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(307, Short.MAX_VALUE))    
                .addGap(120, 120, 120)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGap(50, 50, 50)
                    .addComponent(jScrollPane2)
                    .addComponent(jTabbedPaneOptics))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(412, Short.MAX_VALUE))   
                
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addContainerGap()
                .addComponent(jTabbedPaneOptics)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        pack();
        
        jTabbedPaneOptics.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
//                System.out.println("stateChanged " + jTabbedPaneOptics.getSelectedComponent());
                OpticsPane comp = (OpticsPane)(jTabbedPaneOptics.getSelectedComponent());
                if (comp != null) 
                	comp.updatePatternScreen();
            }
        });

        setTitle(eduKitTitle);
        
    }// </editor-fold>//GEN-END:initComponents

    public void jMenuItemTelephotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTelephotoActionPerformed
        changeLabTitle(labTitleTele);
        
        jTabbedPaneOptics.removeAll();
        jTabbedPaneOptics.addTab("General", jPanelLens1);
        jTabbedPaneOptics.addTab("Single slit", jPanelTest);
        jTabbedPaneOptics.addTab("Double slit", jPanelMirror1);
        jTabbedPaneOptics.addTab("Signsl processing", jPanelMicroscope1);
        jTabbedPaneOptics.addTab("Phase retarder", jPanelCylindrical1);
        setTabPanelEnable(jTabbedPaneOptics, true);
        
    }//GEN-LAST:event_jMenuItemTelephotoActionPerformed

    public void jMenuItemMicroscopeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMicroscopeActionPerformed
        changeLabTitle(labTitleMicr);
        jTabbedPaneOptics.removeAll();
        
        jTabbedPaneOptics.addTab("General", jPanelMicroscope1);
        jTabbedPaneOptics.addTab("Single slit", jPanelTest);
        jTabbedPaneOptics.addTab("Double slit", jPanelMirror1);
        jTabbedPaneOptics.addTab("Signsl processing", null);
        jTabbedPaneOptics.addTab("Phase retarder", jPanelCylindrical1);
        setTabPanelEnable(jTabbedPaneOptics, true);        
    }//GEN-LAST:event_jMenuItemMicroscopeActionPerformed

    private void jMenuItemAberrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAberrationActionPerformed
        changeLabTitle(labTitleAber);
        
        jTabbedPaneOptics.removeAll();
        jTabbedPaneOptics.addTab("General", jPanelAber1);
        jTabbedPaneOptics.addTab("Single slit", jPanelTest);
        jTabbedPaneOptics.addTab("Double slit", jPanelMirror1);
        jTabbedPaneOptics.addTab("Signsl processing", jPanelMicroscope1);
        jTabbedPaneOptics.addTab("Phase retarder", jPanelCylindrical1);
         
        setTabPanelEnable(jTabbedPaneOptics, true);        
    }//GEN-LAST:event_jMenuItemAberrationActionPerformed

    private void jMenuItemMichelsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMichelsonActionPerformed
        changeLabTitle(labTitleMich);        
        
        jTabbedPaneOptics.removeAll();
//        jTabbedPaneOptics.addTab("Lens", jPanelMich1);        
//        jTabbedPaneOptics.addTab("Cylindrical lens", jPanelCylindrical1);
//        jTabbedPaneOptics.addTab("Mirror", jPanelMirror1);
        jTabbedPaneOptics.addTab("General", jPanelMich1);
        jTabbedPaneOptics.addTab("Single slit", jPanelTest);
        jTabbedPaneOptics.addTab("Double slit", jPanelMirror1);
        jTabbedPaneOptics.addTab("Signsl processing", jPanelMicroscope1);
        jTabbedPaneOptics.addTab("Phase retarder", jPanelCylindrical1);
        setTabPanelEnable(jTabbedPaneOptics, true);
    }//GEN-LAST:event_jMenuItemMichelsonActionPerformed

    private void jMenuItemMachZenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMachZenderActionPerformed
        changeLabTitle(labTitleMach);
        
        jTabbedPaneOptics.removeAll();
        //jTabbedPaneOptics.addTab("Misc", jPanelMach1);
        jTabbedPaneOptics.addTab("General", jPanelMach1);
        jTabbedPaneOptics.addTab("Single slit", jPanelTest);
        jTabbedPaneOptics.addTab("Double slit", jPanelMirror1);
        jTabbedPaneOptics.addTab("Signsl processing", jPanelMicroscope1);
        jTabbedPaneOptics.addTab("Phase retarder", jPanelCylindrical1);
        
        setTabPanelEnable(jTabbedPaneOptics, true);        
    }//GEN-LAST:event_jMenuItemMachZenderActionPerformed

    private void jMenuItemDiffractionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDiffractionActionPerformed
        changeLabTitle(labTitleDiff);
        
        //jTabbedPaneOptics.removeAll();
        //jTabbedPaneOptics.addTab("Misc", jPanelDiffraction1);
        jTabbedPaneOptics.addTab("General", jPanelDiffraction1);
        jTabbedPaneOptics.addTab("Single slit", jPanelTest);
        jTabbedPaneOptics.addTab("Double slit", jPanelMirror1);
        jTabbedPaneOptics.addTab("Signsl processing", jPanelMicroscope1);
        jTabbedPaneOptics.addTab("Phase retarder", jPanelCylindrical1);
        setTabPanelEnable(jTabbedPaneOptics, true);        
    }//GEN-LAST:event_jMenuItemDiffractionActionPerformed

    private void jMenuItemSpectrometerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSpectrometerActionPerformed
        changeLabTitle(labTitleSpec);
        
        jTabbedPaneOptics.removeAll();
        //jTabbedPaneOptics.addTab("Lens", jPanelSpectrometer1);        
        //jTabbedPaneOptics.addTab("Mirror", jPanelMirror2);
        jTabbedPaneOptics.addTab("General", jPanelSpectrometer1);
        jTabbedPaneOptics.addTab("Single slit", jPanelTest);
        jTabbedPaneOptics.addTab("Double slit", jPanelMirror1);
        jTabbedPaneOptics.addTab("Signsl processing", jPanelMicroscope1);
        jTabbedPaneOptics.addTab("Phase retarder", jPanelCylindrical1);
        setTabPanelEnable(jTabbedPaneOptics, true);
    }//GEN-LAST:event_jMenuItemSpectrometerActionPerformed

    private void jMenuItemSignalProcessingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSignalProcessingActionPerformed
        changeLabTitle(labTitleSign);
        
        jTabbedPaneOptics.removeAll();
        //jTabbedPaneOptics.addTab("Misc", jPanelSignal1);     
        jTabbedPaneOptics.addTab("General", jPanelSignal1);
        jTabbedPaneOptics.addTab("Single slit", jPanelTest);
        jTabbedPaneOptics.addTab("Double slit", jPanelMirror1);
        jTabbedPaneOptics.addTab("Signsl processing", jPanelMicroscope1);
        jTabbedPaneOptics.addTab("Phase retarder", jPanelCylindrical1);
        setTabPanelEnable(jTabbedPaneOptics, true);        
    }//GEN-LAST:event_jMenuItemSignalProcessingActionPerformed

    private void jMenuItemPhaseShiftingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPhaseShiftingActionPerformed
        changeLabTitle(labTitlePhas);
        
        jTabbedPaneOptics.removeAll();
        //jTabbedPaneOptics.addTab("Misc", jPanelPhase1);   
        jTabbedPaneOptics.addTab("General", jPanelPhase1);
        jTabbedPaneOptics.addTab("Single slit", jPanelTest);
        jTabbedPaneOptics.addTab("Double slit", jPanelMirror1);
        jTabbedPaneOptics.addTab("Signsl processing", jPanelMicroscope1);
        jTabbedPaneOptics.addTab("Phase retarder", jPanelCylindrical1);
        setTabPanelEnable(jTabbedPaneOptics, true);        
    }//GEN-LAST:event_jMenuItemPhaseShiftingActionPerformed

    private void jMenuItemTalbotImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTalbotImagesActionPerformed
        changeLabTitle(labTitleTalb);       
        
        jTabbedPaneOptics.removeAll();
        //jTabbedPaneOptics.addTab("Misc", jPanelTalbot1);   
        jTabbedPaneOptics.addTab("General", jPanelTalbot1);
        jTabbedPaneOptics.addTab("Single slit", jPanelTest);
        jTabbedPaneOptics.addTab("Double slit", jPanelMirror1);
        jTabbedPaneOptics.addTab("Signsl processing", jPanelMicroscope1);
        jTabbedPaneOptics.addTab("Phase retarder", jPanelCylindrical1);
        setTabPanelEnable(jTabbedPaneOptics, true);        
    }//GEN-LAST:event_jMenuItemTalbotImagesActionPerformed

    private void jMenuItemWavefrontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemWavefrontActionPerformed
        changeLabTitle(labTitleFron);               

        jTabbedPaneOptics.removeAll();
//        jTabbedPaneOptics.addTab("Lens", jPanelWavefront1);        
//        jTabbedPaneOptics.addTab("Cylindrical lens", jPanelCylindrical2);
//        jTabbedPaneOptics.addTab("Mirror", jPanelMirror3);
        jTabbedPaneOptics.addTab("General", jPanelWavefront1);
        jTabbedPaneOptics.addTab("Single slit", jPanelTest);
        jTabbedPaneOptics.addTab("Double slit", jPanelMirror1);
        jTabbedPaneOptics.addTab("Signsl processing", jPanelMicroscope1);
        jTabbedPaneOptics.addTab("Phase retarder", jPanelCylindrical1);
        setTabPanelEnable(jTabbedPaneOptics, true);
    }//GEN-LAST:event_jMenuItemWavefrontActionPerformed

    private void jMenuItemWavelengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemWavelengthActionPerformed
        changeLabTitle(labTitleLeng);       

        jTabbedPaneOptics.removeAll();
        //jTabbedPaneOptics.addTab("Mirror", jPanelWavelength1);
        jTabbedPaneOptics.addTab("General", jPanelWavelength1);
        jTabbedPaneOptics.addTab("Single slit", jPanelTest);
        jTabbedPaneOptics.addTab("Double slit", jPanelMirror1);
        jTabbedPaneOptics.addTab("Signsl processing", jPanelMicroscope1);
        jTabbedPaneOptics.addTab("Phase retarder", jPanelCylindrical1);
        setTabPanelEnable(jTabbedPaneOptics, true);
    }//GEN-LAST:event_jMenuItemWavelengthActionPerformed
    
    private void jMenuItemTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTestActionPerformed
        changeLabTitle("Test Singelit");
        
        jTabbedPaneOptics.removeAll();
        jTabbedPaneOptics.addTab("Test", jPanelTest);        
        setTabPanelEnable(jTabbedPaneOptics, true);        
    }//GEN-LAST:event_jMenuItemTestActionPerformed

    private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutActionPerformed
    	AboutView about = new AboutView(null);
    	about.setLocationRelativeTo(null);
    	about.setVisible(true);
    }//GEN-LAST:event_jMenuAboutActionPerformed
    
    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
    	EduPatternTest.disposePatternFrame();
		dispose();
    }//GEN-LAST:event_jMenuItemExitActionPerformed
    
    private void jMenuItemLoadP2GActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLoadP2GActionPerformed
    	File file = browseForFile(pwd);    	
        if(file != null) {
        	if (PatternImage.openFile(file.getAbsolutePath())) {
    	    	logString("load table " + file.getAbsolutePath());
    	    	pwd = file.getAbsolutePath();        		
    	    	// regenerate pattern, following the behavior of updateRegenerate
    	    	EduPatternTest.updateRegenerate();
        	}
        	else {
        		JOptionPane.showMessageDialog(null, mapLoadErrorMessage + file.getAbsolutePath());        		
        	}
        }
    }//GEN-LAST:event_jMenuItemExitActionPerformed
    
    public void changeLabTitle(String msg) {
    	logString("Optical experiment " + msg);
        this.setTitle(eduKitTitle+" ("+msg+")");
        EduPatternTest.disablePatternFrame();        
    }
    
    public void logString(String msg) {
    	jTextAreaLog.append(msg + System.getProperty("line.separator"));
    	jTextAreaLog.setCaretPosition(jTextAreaLog.getText().length() - 1);

    	// start logging if user chose to
    	if (EduPatternTest.logging ==1) {
			try {
				BufferedWriter logFileOut = new BufferedWriter(new FileWriter("JDCedukit_ui.log"));
	    		jTextAreaLog.write(logFileOut);
	    		logFileOut.flush();
			} catch (Exception e) {
			}
    	}
   	}
    
    private void setTabPanelEnable(Container c, boolean enabled) {
        for (Component component : c.getComponents())
            component.setEnabled(enabled);    	
        c.setEnabled(enabled);    	
    }
    
    public void updateRegenerate() {
    	for(OpticsPane op : panelist) {
    		op.updateRegenerate();
    		op.repaint();
    	}
    }

    private String pwd = System.getProperty("user.dir");
    
    private File browseForFile(String current) {
    	// file filter
    	class TXTFilter extends FileFilter {
    	    public boolean accept(File filename) {
    	        return filename.isDirectory() || filename.getName().toLowerCase().endsWith(".txt");
    	    }

    	    public String getDescription() {
    	        return "TXT";
    	    }
    	}

		JFileChooser fileopen = new JFileChooser(new File(current));
		fileopen.setFileFilter(new TXTFilter());
		int ret = fileopen.showDialog(null, "Select");
    	File file = null;
		if(ret == 0) {
			file = fileopen.getSelectedFile();
		}
		return file;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EduUIMainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EduUIMainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EduUIMainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EduUIMainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EduUIMainView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBarMain;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuFourier;
    private javax.swing.JMenu jMenuGeometric;
    private javax.swing.JMenu jMenuDraw;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItemAberration;
    private javax.swing.JMenuItem jMenuItemSingleSlit;
    private javax.swing.JMenuItem jMenuItemDifractionSlit;
    private javax.swing.JMenuItem jMenuItemDoubleSlit;
    private javax.swing.JMenuItem jMenuItemDrawSignalProcessing;
    private javax.swing.JMenuItem jMenuItemDrawPhaseRetarder;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemDiffraction;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemLoadP2GTable;
    private javax.swing.JMenuItem jMenuItemMachZender;
    private javax.swing.JMenuItem jMenuItemMichelson;
    private javax.swing.JMenuItem jMenuItemMicroscope;
    private javax.swing.JMenuItem jMenuItemPhaseShifting;
    private javax.swing.JMenuItem jMenuItemSignalProcessing;
    private javax.swing.JMenuItem jMenuItemSpectrometer;
    private javax.swing.JMenuItem jMenuItemTalbotImages;
    private javax.swing.JMenuItem jMenuItemTelephoto;
    private javax.swing.JMenuItem jMenuItemWavefront;
    private javax.swing.JMenuItem jMenuItemWavelength;
    private javax.swing.JMenuItem jMenuItemTest;
    private javax.swing.JMenu jMenuMisc;
    private javax.swing.JMenu jMenuOptical;
    private javax.swing.JMenu jMenuWave;
    private javax.swing.JPanel jPanelCylindrical1;
    private javax.swing.JPanel jPanelCylindrical2;
    private javax.swing.JPanel jPanelLens1;
    private javax.swing.JPanel jPanelLens2;
    private javax.swing.JPanel jPanelLens3;
    private javax.swing.JPanel jPanelLens4;
    private javax.swing.JPanel jPanelMirror1;
    private javax.swing.JPanel jPanelMicroscope1;
    private javax.swing.JPanel jPanelMirror2;
    private javax.swing.JPanel jPanelMirror3;
    private javax.swing.JPanel jPanelMirror4;
    private javax.swing.JPanel jPanelAber1;
    private javax.swing.JPanel jPanelMach1;
    private javax.swing.JPanel jPanelMich1;
    private javax.swing.JPanel jPanelMich2;
    private javax.swing.JPanel jPanelMich3;
    private javax.swing.JPanel jPanelMich4;
    private javax.swing.JPanel jPanelDiffraction1;
    private javax.swing.JPanel jPanelSpectrometer1;
    private javax.swing.JPanel jPanelSignal1;
    private javax.swing.JPanel jPanelPhase1;
    private javax.swing.JPanel jPanelTalbot1;
    private javax.swing.JPanel jPanelWavefront1;
    private javax.swing.JPanel jPanelWavelength1;
    private javax.swing.JPanel jPanelMisc;
    private javax.swing.JPanel jPanelTest;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPaneOptics;
    private javax.swing.JTextArea jTextAreaLog;
    
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    
    final private String catTitleGeom ="Geometric Optics";
    final private String catTitleWave ="Wave Optics";
    final private String catTitleFour ="Fourier Optics";
    final private String catTitleOthe ="Others";

    final private String labTitleTele =" 1. Telephoto Lens";
    final private String labTitleMicr =" 2. Microscope";
    final private String labTitleAber =" 3. Aberration (Foucault test)";
    final private String labTitleMich =" 4. Michelson Interferometer";
    final private String labTitleMach =" 5. Mach-Zender Interfrometer";
    final private String labTitleDiff =" 6. Diffraction and Interference";
    final private String labTitleSpec =" 7. Spectrometer";
    final private String labTitleSign =" 8. Signal Processing (4-f system)";
    final private String labTitlePhas =" 9. Phase Shifting Digital Holography";
    final private String labTitleTalb ="10. Talbot Images";
    final private String labTitleFron ="11. Wavefront Modulation";
    final private String labTitleLeng ="12. Wavelength Selective Switch";
    
    final private String eduKitTitle  ="JDC Education Kit";
    
    private ArrayList <OpticsPane> panelist;
    
    static String mapLoadErrorMessage="Grayscale map table file load error: ";

}
