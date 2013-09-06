/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ 
/*      */ class DifraccionApplet_jSlider_fres_distProp_keyAdapter extends KeyAdapter
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jSlider_fres_distProp_keyAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2334 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void keyPressed(KeyEvent e) {
/* 2337 */     this.adaptee.jSlider_fres_distProp_keyPressed(e);
/*      */   }
/*      */   public void keyTyped(KeyEvent e) {
/* 2340 */     this.adaptee.jSlider_fres_distProp_keyTyped(e);
/*      */   }
/*      */ }