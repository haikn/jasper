/*
 * @(#)PatternImage.java
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

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This PatternImage include the algorithms of application
 *
 * @version 1.0 28 Aug 2013
 *
 * @author Albert Nguyen
 *
 */
public class PatternImage {
	private double lambda;
	private double xoff;
	private double yoff;
	private double angle;
	private double pxsize;
	private double focal;
	private double mirrorTheta;
	private double mirrorPhy;
	public BufferedImage canvas;

	public static int width;
	public static int height;
	public static int gray2phase[];
	
	// title string
	public String title;

	public PatternImage(int w, int h) {
		width = w;
		height = h;
		canvas = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		title = "";
	}

	public PatternImage() {
		canvas = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
	}

	public void init(double lambda) {
		this.lambda = lambda;
		this.xoff = 0.0;
		this.yoff = 0.0;
		this.angle = 0.0;
		this.pxsize = 6.4e-6;
		this.focal = 1.0;
		gray2phase = new int[256];
		initGray2phase();
	}

	public double getLambda() {
		return lambda;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(width, height);
	}

	void updateLensParameter(double xoff, double yoff, double focal) {
		this.xoff = xoff;
		this.yoff = yoff;
		this.focal = focal;
		title = "lens "+xoff+" "+yoff+" "+focal;
	}

	void updateCyllindricalParameter(double xoff, double angle, double focal) {
		this.xoff = xoff;
		this.angle = angle;
		this.focal = focal;
		title = "cylindrical "+xoff+" "+angle+" "+focal;
	}

	void updateMirrorParameter(double phy, double theta) {
		this.mirrorPhy = phy;
		this.mirrorTheta = theta;
		title = "mirror "+phy+" "+theta;
	}

	private void initGray2phase() {
		for (int i = 0; i < gray2phase.length; i++)
			gray2phase[i] = i;
	}

	private int phase2gray(double phase) {
		int scale = gray2phase.length;
		phase = phase / 2.0d / Math.PI;
		phase -= Math.floor(phase);
		int gray = Math.min((int) Math.round(phase * scale), scale-1);
		return gray2phase[gray];
	}
        
        // Telephoto Lens algorithms
	public void paintLens() {
		WritableRaster raster = canvas.getRaster();
		int[] iArray = new int[1];
		double x2, y2, phase;
		double y1;
		double fixpart = Math.PI / lambda / focal;

		// 2*pi/la*0.1*x*psize
		double fixpart2 = 2.0 * Math.PI / lambda * 0.1; 

		// calculate phase of each pixel;
		for (int i = 0; i < height; i++) {
			x2 = (double) (i - height/2 + 1) * pxsize;
			x2 -= xoff;
			x2 = Math.pow(x2, 2.0);
			for (int j = 0; j < width; j++) {
				y2 = (double) (j - width/2 + 1) * pxsize;
				y2 -= yoff;
				y1 = y2;
				y2 = Math.pow(y2, 2.0);
                                phase = fixpart * (x2 + y2);
				//phase = fixpart * (22*x2 + 10*y2) ;
//                                phase=exp(i*pi/wavelength/focallength*(x.^2+y.^2));
//                                hologram=((angle(phase)+pi)/2/pi);

                                //wave=exp(j*pi/wl*(xt.^2+yt.^2));
				// added fixpart2 from David's LensMaekr0402_2013
				//phase += fixpart2 * y1 ;
                                phase += (fixpart2 * y1);
                                //phase += (fixpart2 * y1)/2/Math.PI ;

				iArray[0] = phase2gray(phase);
				raster.setPixel(j, i, iArray);
			}
		}
	}
        
        // Microscope algorithms
        public void paintMicroscope() {
		WritableRaster raster = canvas.getRaster();

		int[] iArray = new int[1];
		double x2, y2, phase;
		double y1;

		double fixpart = Math.PI / lambda / focal;

		// 2*pi/la*0.1*x*psize
		double fixpart2 = 2.0 * Math.PI / lambda * 0.1; 

		// calculate phase of each pixel;
		for (int i = 0; i < height; i++) {
			x2 = (double) (i - height/2 + 1) * pxsize;
			x2 -= xoff;
			x2 = Math.pow(x2, 2.0);
			for (int j = 0; j < width; j++) {
				y2 = (double) (j - width/2 + 1) * pxsize;
				y2 -= yoff;
				y1 = y2;
				y2 = Math.pow(y2, 2.0);
				phase = (fixpart * (x2 + y2));
                                
				//phase += ((fixpart2 * y1)/200/Math.PI);

				iArray[0] = phase2gray(phase);
				raster.setPixel(j, i, iArray);
			}
		}
	}
        
        // Cylindircal algorithms
	public void paintCylindircal() {
		WritableRaster raster = canvas.getRaster();

		int[] iArray = new int[1];
		double x1, y1, x2, phase;

		double fixpart2 = 2.0 * Math.PI / lambda * Math.cos(Math.toRadians(3.0));
		double fixpart = Math.PI / lambda / focal;

		double costheta = Math.cos(Math.toRadians(angle));
		double sintheta = Math.sin(Math.toRadians(angle));

// following statement is for debugging
//		System.out.println("paintCylindircal");
		
		for (int i = 0; i < height; i++) {
			x1 = (double) (i - height/2 + 1) * pxsize;
			x1 -= xoff;
			for (int j = 0; j < width; j++) {
				y1 = (double) (j - width/2 + 1) * pxsize;
				x2 = x1 * costheta - y1 * sintheta;
				x2 = Math.pow(x2, 2.0);
				phase = fixpart * x2 + fixpart2 * y1;

// following two statements are for debugging
//				phase = fixpart2 * y1;
//				System.out.println("i="+i+" j="+j+" phase="+phase);
				
				iArray[0] = phase2gray(phase);
				raster.setPixel(j, i, iArray);
			}
		}
	}
        
        // Mirror algorithms
	public void paintMirror() {
		WritableRaster raster = canvas.getRaster();

		int[] iArray = new int[1];
		double phase, x, y;

		double phy = Math.toRadians(mirrorPhy);
		double theta = Math.toRadians(mirrorTheta);
		
// following statement is for debugging
//		pi = Math.toRadians(3.0);

		double xcomp = Math.sin(phy) * Math.cos(theta);
		double ycomp = Math.sin(phy) * Math.sin(theta);

		double fixpart = 2.0 * Math.PI / lambda;

// following statement is for debugging
//		System.out.println("paintMirror");
		
		for (int i = 0; i < height; i++) {
			x = (double) (i - height/2 + 1) * pxsize;
			x = xcomp * x;
			for (int j = 0; j < width; j++) {
				y = (double) (j - width/2 + 1) * pxsize;
				y = ycomp * y;
				phase = fixpart * (x + y);
				
// following statement is for debugging
//				System.out.println("i="+i+" j="+j+" phase="+phase);
				
				iArray[0] = phase2gray(phase);
				raster.setPixel(j, i, iArray);
			}
		}
	}

	private static int[] parseElement(String s) throws IOException {
		int[] ret = new int[gray2phase.length];
		int idx=0;
		int scale = gray2phase.length;
		String elements[] = s.split(",");
		for (String element: elements) {
			if (element.contains(":")) {
				String ends[]=element.split(":");
				if (ends.length != 2)
					throw new IOException();
				int front = Integer.valueOf(ends[0]);
				int rear = Integer.valueOf(ends[1]);
				if (front > scale-1 || front < 0 || rear > scale-1 || rear < 0)
					throw new IOException();
				int offset = (rear-front)/Math.abs(rear-front);
				for(int val= front; true ; val += offset) {
					ret[idx++]=val;
					if (val == rear)
						break;
				}
			} else {
				int p = Integer.valueOf(element);
				if (p > scale-1 || p < 0)
					throw new IOException();
				ret[idx++]=p;				
			}
		}

		// prepare the return array
		int[] retVal= new int[idx];
		for(int i=0; i<idx; i++)
			retVal[i]=ret[i];

		return retVal;
	}
	
	public static boolean openFile(String filename) {
		boolean retValue = false;
		BufferedReader br = null;

		// initialize new table with values in the old table
		int newTable[] = new int[gray2phase.length];
		for (int i=0; i<gray2phase.length; i++) 
			newTable[i]=gray2phase[i];
		try {
                    br = new BufferedReader(new FileReader(filename));
                    String strLine;
                    while ((strLine = br.readLine()) != null) {
                            if (strLine.length() != 0 && strLine.charAt(0) != '#') {
                                    String[] tokens = strLine.trim().split("[\t ]+");
                                    for (String token: tokens) {
                                            String lrhs[]= token.split("=");
                                            if (lrhs.length != 2)
                                                    throw new IOException();
                                            int lhs[] = parseElement(lrhs[0]);
                                            int rhs[] = parseElement(lrhs[1]);
                                            if (lhs.length != rhs.length)
                                                    throw new IOException();
                                            for (int i=0; i < lhs.length; i++)
                                                    newTable[lhs[i]]=rhs[i];
                                    }
                                }
                    }
                    // update with the new table values
                    for (int i=0; i<gray2phase.length; i++) 
                            gray2phase[i] = newTable[i];
                    retValue = true;
		} catch (Exception e) {
			// System.out.println("parse or IO error");
		} finally {
                    try {
                        if (br != null)
                        br.close();
                    } catch (IOException e) {
                    }
		}
		return retValue;
	}
        
        public void paintMichelson() {
		WritableRaster raster = canvas.getRaster();
                //System out to make sure the code run thru this function
                System.out.println("Enter the Michelson");
		int[] iArray = new int[1];
		double phase, x, y;

		double phy = Math.toRadians(mirrorPhy);
		double theta = Math.toRadians(mirrorTheta);
		

		double xcomp = Math.sin(phy) * Math.cos(theta);
		double ycomp = Math.sin(phy) * Math.sin(theta);

		//double fixpart = 2.0 * Math.PI / lambda;
                double fixpart = 5.0 * Math.PI / lambda;

		for (int i = 0; i < height; i++) {
			x = (double) (i - height/2 + 1) * pxsize;
			x = xcomp * x;
			for (int j = 0; j < width; j++) {
				y = (double) (j - width/2 + 1) * pxsize;
				y = ycomp * y;
				phase = fixpart * (x + y);
				
				iArray[0] = phase2gray(phase);
				raster.setPixel(j, i, iArray);
			}
		}            
        }
}
