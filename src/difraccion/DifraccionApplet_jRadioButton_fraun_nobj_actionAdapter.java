/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ 
/*      */ class DifraccionApplet_jRadioButton_fraun_nobj_actionAdapter
/*      */   implements ActionListener
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jRadioButton_fraun_nobj_actionAdapter(DifraccionApplet adaptee)
/*      */   {
/* 1997 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void actionPerformed(ActionEvent e) {
/* 2000 */     this.adaptee.jRadioButton_fraun_nobj_actionPerformed(e);
/*      */   }
/*      */ }