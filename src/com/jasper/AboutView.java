/*
 * @(#)AboutView.java
 *
 * Copyright (c) 2013 NOMOVOK, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * NOMOVOK PROPRIETARY:  The information contained in or disclosed by this
 * document is considered proprietary by NOMOVOK, Inc.  This document and/or the
 * information contained therein shall not be duplicated nor disclosed in whole
 * or in part without the specific written permission of NOMOVOK, Inc.
 */
package com.jasper;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.*;

/**
 * This AboutView include the version, customer information of application
 *
 * @version 1.0 28 Aug 2013
 *
 * @author Albert Nguyen
 *
 */
public class AboutView extends JDialog {
	private static final long serialVersionUID = 1L;

	public AboutView(Frame parent) {
            super(parent);
            initComponents();
            getRootPane().setDefaultButton(buttonClose);
	}

	private void initComponents() {
            labelJDCIcon = new JLabel();
            buttonClose = new JButton();
            labelAppVersion = new JLabel();
            labelAppName = new JLabel();
            labelJDC = new JLabel();
            jLabel1 = new JLabel();
            jLabel2 = new JLabel();
            labelJDCIcon.setHorizontalAlignment(0);
            labelJDCIcon.setIcon(new ImageIcon(getClass().getResource("/resources/jdclogo_150x155.png")));
            buttonClose.setText("Close");
            buttonClose.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                        buttonCloseActionPerformed(evt);
                }
            });
            ResourceBundle bundle = ResourceBundle.getBundle("resources/Text");
            labelAppVersion.setHorizontalAlignment(0);
            //labelAppVersion.setText(versionStr);
            labelAppVersion.setText(bundle.getString("VERSION"));
            labelAppName.setHorizontalAlignment(0);
            labelAppName.setText(bundle.getString("APPNAME"));
            labelJDC.setHorizontalAlignment(0);
            labelJDC.setText(bundle.getString("COMPANYNAME"));
            jLabel1.setText(bundle.getString("APPID"));
            jLabel2.setFont(new Font("Dialog", 0, 12));
            jLabel2.setText(bundle.getString("BUILDDATE"));
            jLabel2.setForeground(Color.RED);
            GroupLayout layout = new GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(174, 174, 174)
                            .addComponent(buttonClose)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                            .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(labelJDCIcon)
                            .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(labelJDC)
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addComponent(labelAppName)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(labelAppVersion)))));
            layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addComponent(labelJDCIcon, GroupLayout.Alignment.LEADING)
                                                            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                    .addGap(7, 7,7)
                                                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                            .addComponent(labelAppName)
                                                                            .addComponent(labelAppVersion))
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(jLabel1)
                                                                    .addGap(6, 6, 6)
                                                                    .addComponent(labelJDC)
                                                                    .addGap(24, 24,24)
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                                                    .addComponent(buttonClose)))
                                                    .addContainerGap(-1, Short.MAX_VALUE))
                                                    .addComponent(jLabel2, GroupLayout.Alignment.TRAILING))));

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setModal(true);
            setName("aboutBox");
            setTitle("About");
            setResizable(false);
            pack();
	}

	private void buttonCloseActionPerformed(ActionEvent evt) {
            dispose();
	}

	private JButton buttonClose;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel labelAppName;
	private JLabel labelAppVersion;
	private JLabel labelJDC;
	private JLabel labelJDCIcon;
}
