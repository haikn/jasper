/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ 
/*      */ class DifraccionApplet_jRadioButton_fres_tipoimg_amp_actionAdapter
/*      */   implements ActionListener
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jRadioButton_fres_tipoimg_amp_actionAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2533 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void actionPerformed(ActionEvent e) {
/* 2536 */     this.adaptee.jRadioButton_fres_tipoimg_amp_actionPerformed(e);
/*      */   }
/*      */ }