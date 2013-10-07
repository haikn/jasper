/*
 * @(#)OpticsPane.java
 *
 * Copyright (c) 2013 JASPER DISPLAY, Inc.
 * An Unpublished Work.  All Rights Reserved.
 *
 * JASPER DISPLAY PROPRIETARY:  Distribution of this source code
 * without permission from the copyright holder is strictly forbidden.
 */
package com.jasper;

import java.awt.Component;


public abstract class OpticsPane extends javax.swing.JPanel {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    protected String warnings="One or more parameters with incorrect input!";

	protected boolean imageGenerated = false;

	@Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        for (Component component : getComponents())
            component.setEnabled(enabled);
    }
    
    abstract void updatePatternScreen();
    
    abstract void updateRegenerate();
}
