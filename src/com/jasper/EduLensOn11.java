/*
 * @(#)EduLensOn11.java
 *
 * Copyright (c) 2013 JASPER DISPLAY, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * JASPER DISPLAY PROPRIETARY:  Distribution of this source code
 * without permission from the copyright holder is strictly forbidden.
 */
package com.jasper;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author sonnv
 */
public class EduLensOn11 extends JComponent
        implements MouseMotionListener {

    double zoom;
    JComponent comp;
    Point point;
    Dimension mySize;
    Robot robot;

    public EduLensOn11(JComponent comp, Dimension size, double zoom) {
        // flag to say don't draw until we get a MouseMotionEvent
        point = new Point(-1, -1);
        comp.addMouseMotionListener(this);
        this.comp = comp;
        this.mySize = size;
        this.zoom = zoom;
        comp.addMouseMotionListener(this);
        // if we can't get a robot, then we just never
        // paint anything
        try {
            robot = new Robot();
        } catch (AWTException awte) {
            System.err.println("Can't get a Robot");
            awte.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        if ((robot == null) || (point.x == -1)) {
            g.setColor(Color.black);
            g.fillRect(0, 0, mySize.width, mySize.height);
            return;
        }
        Rectangle grabRect = computeGrabRect();
        BufferedImage grabImg = robot.createScreenCapture(grabRect);
        Image scaleImg = grabImg.getScaledInstance(mySize.width, mySize.height, Image.SCALE_FAST);

        g.drawImage(scaleImg, 0, 0, null);
    }
    
    private Rectangle computeGrabRect() {
        // width, height are size of this comp / zoom
        int grabWidth = (int) ((double) mySize.width / zoom);
        int grabHeight = (int) ((double) mySize.height / zoom);
        // upper-left corner is current point
        
        PointerInfo Pointer = MouseInfo.getPointerInfo();
        Point MouseLocation = Pointer.getLocation();
        int x = (int) MouseLocation.getX();
        int y = (int) MouseLocation.getY();
        
        return new Rectangle(x - (int) grabWidth/2, y - (int) grabHeight/2, grabWidth, grabHeight);
    }

    public Dimension getPreferredSize() {
        return mySize;
    }

    public Dimension getMinimumSize() {
        return mySize;
    }

    public Dimension getMaximumSize() {
        return mySize;
    }

    // MouseMotionListener implementations
    public void mouseMoved(MouseEvent e) {
        //  Point offsetPoint = com.getLocationOnScreen();
        //  System.out.println(">>>>>>>>>E : " + e.getPoint());
        //   e.translatePoint(.x, offsetPoint.y);
        point = e.getPoint();
        
//        Point offsetPoint = comp.getLocationOnScreen();
//        e.translatePoint (offsetPoint.x, offsetPoint.y);
//        point = e.getPoint();
        
        repaint();
    }

    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }
}
