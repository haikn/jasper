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
