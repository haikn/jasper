/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ 
/*      */ class DifraccionApplet_jRadioButton_fraun_showimg_actionAdapter
/*      */   implements ActionListener
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jRadioButton_fraun_showimg_actionAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2232 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void actionPerformed(ActionEvent e) {
/* 2235 */     this.adaptee.jRadioButton_fraun_showimg_actionPerformed(e);
/*      */   }
/*      */ }