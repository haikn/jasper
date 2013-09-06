/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ 
/*      */ class DifraccionApplet_jSlider_fraun_distFocal_keyAdapter extends KeyAdapter
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jSlider_fraun_distFocal_keyAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2055 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void keyPressed(KeyEvent e) {
/* 2058 */     this.adaptee.jSlider_fraun_distFocal_keyPressed(e);
/*      */   }
/*      */   public void keyTyped(KeyEvent e) {
/* 2061 */     this.adaptee.jSlider_fraun_distFocal_keyTyped(e);
/*      */   }
/*      */ }