/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ 
/*      */ class DifraccionApplet_jSlider_fraun_longOnda_keyAdapter extends KeyAdapter
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jSlider_fraun_longOnda_keyAdapter(DifraccionApplet adaptee)
/*      */   {
/* 1950 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void keyPressed(KeyEvent e) {
/* 1953 */     this.adaptee.jSlider_fraun_longOnda_keyPressed(e);
/*      */   }
/*      */   public void keyTyped(KeyEvent e) {
/* 1956 */     this.adaptee.jSlider_fraun_longOnda_keyTyped(e);
/*      */   }
/*      */ }