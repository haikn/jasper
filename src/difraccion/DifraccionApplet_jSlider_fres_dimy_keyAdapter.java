/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ 
/*      */ class DifraccionApplet_jSlider_fres_dimy_keyAdapter extends KeyAdapter
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jSlider_fres_dimy_keyAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2406 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void keyPressed(KeyEvent e) {
/* 2409 */     this.adaptee.jSlider_fres_dimy_keyPressed(e);
/*      */   }
/*      */   public void keyTyped(KeyEvent e) {
/* 2412 */     this.adaptee.jSlider_fres_dimy_keyTyped(e);
/*      */   }
/*      */ }