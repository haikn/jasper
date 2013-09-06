/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ 
/*      */ class DifraccionApplet_jSlider_fraun_nobjetos_keyAdapter extends KeyAdapter
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jSlider_fraun_nobjetos_keyAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2041 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void keyPressed(KeyEvent e) {
/* 2044 */     this.adaptee.jSlider_fraun_nobjetos_keyPressed(e);
/*      */   }
/*      */   public void keyTyped(KeyEvent e) {
/* 2047 */     this.adaptee.jSlider_fraun_nobjetos_keyTyped(e);
/*      */   }
/*      */ }