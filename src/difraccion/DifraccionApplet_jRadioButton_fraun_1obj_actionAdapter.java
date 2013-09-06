/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ 
/*      */ class DifraccionApplet_jRadioButton_fraun_1obj_actionAdapter
/*      */   implements ActionListener
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jRadioButton_fraun_1obj_actionAdapter(DifraccionApplet adaptee)
/*      */   {
/* 1986 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void actionPerformed(ActionEvent e) {
/* 1989 */     this.adaptee.jRadioButton_fraun_1obj_actionPerformed(e);
/*      */   }
/*      */ }