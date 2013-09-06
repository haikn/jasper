/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ 
/*      */ class DifraccionApplet_jRadioButton_fres_showimg_actionAdapter
/*      */   implements ActionListener
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jRadioButton_fres_showimg_actionAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2511 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void actionPerformed(ActionEvent e) {
/* 2514 */     this.adaptee.jRadioButton_fres_showimg_actionPerformed(e);
/*      */   }
/*      */ }