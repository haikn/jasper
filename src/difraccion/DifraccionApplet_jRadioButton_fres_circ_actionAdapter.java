/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ 
/*      */ class DifraccionApplet_jRadioButton_fres_circ_actionAdapter
/*      */   implements ActionListener
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jRadioButton_fres_circ_actionAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2453 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void actionPerformed(ActionEvent e) {
/* 2456 */     this.adaptee.jRadioButton_fres_circ_actionPerformed(e);
/*      */   }
/*      */ }