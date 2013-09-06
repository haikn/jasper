/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ 
/*      */ class DifraccionApplet_jRadioButton_fraun_tipoimg_int_actionAdapter
/*      */   implements ActionListener
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jRadioButton_fraun_tipoimg_int_actionAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2265 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void actionPerformed(ActionEvent e) {
/* 2268 */     this.adaptee.jRadioButton_fraun_tipoimg_int_actionPerformed(e);
/*      */   }
/*      */ }