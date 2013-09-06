/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ 
/*      */ class DifraccionApplet_jRadioButton_fres_tipoimg_intlog_actionAdapter
/*      */   implements ActionListener
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jRadioButton_fres_tipoimg_intlog_actionAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2555 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void actionPerformed(ActionEvent e) {
/* 2558 */     this.adaptee.jRadioButton_fres_tipoimg_intlog_actionPerformed(e);
/*      */   }
/*      */ }