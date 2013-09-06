/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ 
/*      */ class DifraccionApplet_jSlider_fraun_dimx_keyAdapter extends KeyAdapter
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jSlider_fraun_dimx_keyAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2091 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void keyPressed(KeyEvent e) {
/* 2094 */     this.adaptee.jSlider_fraun_dimx_keyPressed(e);
/*      */   }
/*      */   public void keyTyped(KeyEvent e) {
/* 2097 */     this.adaptee.jSlider_fraun_dimx_keyTyped(e);
/*      */   }
/*      */ }