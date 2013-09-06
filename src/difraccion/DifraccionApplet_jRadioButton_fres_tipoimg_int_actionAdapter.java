/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ 
/*      */ class DifraccionApplet_jRadioButton_fres_tipoimg_int_actionAdapter
/*      */   implements ActionListener
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jRadioButton_fres_tipoimg_int_actionAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2544 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void actionPerformed(ActionEvent e) {
/* 2547 */     this.adaptee.jRadioButton_fres_tipoimg_int_actionPerformed(e);
/*      */   }
/*      */ }