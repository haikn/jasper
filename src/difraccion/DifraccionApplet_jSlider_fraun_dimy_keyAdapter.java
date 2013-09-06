/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ 
/*      */ class DifraccionApplet_jSlider_fraun_dimy_keyAdapter extends KeyAdapter
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jSlider_fraun_dimy_keyAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2127 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void keyPressed(KeyEvent e) {
/* 2130 */     this.adaptee.jSlider_fraun_dimy_keyPressed(e);
/*      */   }
/*      */   public void keyTyped(KeyEvent e) {
/* 2133 */     this.adaptee.jSlider_fraun_dimy_keyTyped(e);
/*      */   }
/*      */ }