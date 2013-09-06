/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ 
/*      */ class DifraccionApplet_jRadioButton_fraun_rend_actionAdapter
/*      */   implements ActionListener
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jRadioButton_fraun_rend_actionAdapter(DifraccionApplet adaptee)
/*      */   {
/* 1939 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void actionPerformed(ActionEvent e) {
/* 1942 */     this.adaptee.jRadioButton_fraun_rend_actionPerformed(e);
/*      */   }
/*      */ }