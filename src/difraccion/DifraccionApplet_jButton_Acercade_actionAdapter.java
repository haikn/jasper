/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ 
/*      */ class DifraccionApplet_jButton_Acercade_actionAdapter
/*      */   implements ActionListener
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jButton_Acercade_actionAdapter(DifraccionApplet adaptee)
/*      */   {
/* 1905 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void actionPerformed(ActionEvent e) {
/* 1908 */     this.adaptee.jButton_Acercade_actionPerformed(e);
/*      */   }
/*      */ }