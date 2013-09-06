/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ 
/*      */ class DifraccionApplet_jButton_Salir_actionAdapter
/*      */   implements ActionListener
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jButton_Salir_actionAdapter(DifraccionApplet adaptee)
/*      */   {
/* 1894 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void actionPerformed(ActionEvent e) {
/* 1897 */     this.adaptee.jButton_Salir_actionPerformed(e);
/*      */   }
/*      */ }