/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ 
/*      */ class DifraccionApplet_jSlider_fraun_umbral_keyAdapter extends KeyAdapter
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jSlider_fraun_umbral_keyAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2218 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void keyPressed(KeyEvent e) {
/* 2221 */     this.adaptee.jSlider_fraun_umbral_keyPressed(e);
/*      */   }
/*      */   public void keyTyped(KeyEvent e) {
/* 2224 */     this.adaptee.jSlider_fraun_umbral_keyTyped(e);
/*      */   }
/*      */ }