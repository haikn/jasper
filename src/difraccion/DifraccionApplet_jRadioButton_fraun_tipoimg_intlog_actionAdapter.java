/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ 
/*      */ class DifraccionApplet_jRadioButton_fraun_tipoimg_intlog_actionAdapter
/*      */   implements ActionListener
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jRadioButton_fraun_tipoimg_intlog_actionAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2276 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void actionPerformed(ActionEvent e) {
/* 2279 */     this.adaptee.jRadioButton_fraun_tipoimg_intlog_actionPerformed(e);
/*      */   }
/*      */ }