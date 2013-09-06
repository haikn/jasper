/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ 
/*      */ class DifraccionApplet_jSlider_fres_longOnda_keyAdapter extends KeyAdapter
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jSlider_fres_longOnda_keyAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2298 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void keyPressed(KeyEvent e) {
/* 2301 */     this.adaptee.jSlider_fres_longOnda_keyPressed(e);
/*      */   }
/*      */   public void keyTyped(KeyEvent e) {
/* 2304 */     this.adaptee.jSlider_fres_longOnda_keyTyped(e);
/*      */   }
/*      */ }