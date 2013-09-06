/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ 
/*      */ class DifraccionApplet_jSlider_fres_umbral_keyAdapter extends KeyAdapter
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jSlider_fres_umbral_keyAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2497 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void keyPressed(KeyEvent e) {
/* 2500 */     this.adaptee.jSlider_fres_umbral_keyPressed(e);
/*      */   }
/*      */   public void keyTyped(KeyEvent e) {
/* 2503 */     this.adaptee.jSlider_fres_umbral_keyTyped(e);
/*      */   }
/*      */ }