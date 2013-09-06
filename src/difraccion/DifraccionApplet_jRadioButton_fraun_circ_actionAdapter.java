/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ 
/*      */ class DifraccionApplet_jRadioButton_fraun_circ_actionAdapter
/*      */   implements ActionListener
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jRadioButton_fraun_circ_actionAdapter(DifraccionApplet adaptee)
/*      */   {
/* 1928 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void actionPerformed(ActionEvent e) {
/* 1931 */     this.adaptee.jRadioButton_fraun_circ_actionPerformed(e);
/*      */   }
/*      */ }