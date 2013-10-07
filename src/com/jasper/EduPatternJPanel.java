/*
 * @(#)EduPatternJPanel.java
 *
 * Copyright (c) 2013 JASPER DISPLAY, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * JASPER DISPLAY PROPRIETARY:  Distribution of this source code
 * without permission from the copyright holder is strictly forbidden.
 */
package com.jasper;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 * This EduPatternJPanel include the panel information of application
 *
 * @version 1.0 28 Aug 2013
 *
 * @author Albert Nguyen
 *
 */
public class EduPatternJPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public PatternImage pimage;
        public PatternImage pimage1;
	private boolean isScreen = false;
//	Font font = new Font("Arial", Font.PLAIN, 15);
	Font font = new Font("Courier New", Font.PLAIN, 12);
	public EduPatternJPanel () {
                pimage = new PatternImage();
		pimage.init(EduPatternTest.lambda);
		pimage1 = new PatternImage();
		pimage1.init(EduPatternTest.lambda);
		isScreen = false;
	}

	public EduPatternJPanel (PatternImage pimage) {
		this.pimage = pimage;
		isScreen = true;
	}

	public void setImage(PatternImage pimage) {
		this.pimage = pimage;	
	}

	public void paint(Graphics g) {
		Rectangle bounds = getBounds();
		if (bounds.width != PatternImage.width && bounds.height != PatternImage.height) {
			g.drawImage(pimage.canvas, 0, 0, bounds.width, bounds.height, null);
		} else {
			g.drawImage(pimage.canvas, 0, 0, null);
		}
		if (isScreen) {
			// draw title string to the screen
			Graphics2D g2 = (Graphics2D) g;
			String title = "JDC EDUKIT "+PatternImage.width+"x"+bounds.height+" ("+EduPatternTest.lambdaStr+"nm)"+": "+pimage.title;
			g2.setFont(font);
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
			g2.setColor(Color.yellow);
			// calculate the bounding box the title string
			FontMetrics metrics = g.getFontMetrics(font);
			int hgt = metrics.getHeight();
			int adv = metrics.stringWidth(title);

//			g2.drawString(title, bounds.width - adv - 2, hgt + 2);
			g2.drawString(title, 2, hgt - 2);
		}
		g.dispose();
	}
}
