/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.MouseMotionAdapter;
/*      */ 
/*      */ class DifraccionApplet_jSlider_fraun_longOnda_mouseMotionAdapter extends MouseMotionAdapter
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jSlider_fraun_longOnda_mouseMotionAdapter(DifraccionApplet adaptee)
/*      */   {
/* 1975 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void mouseDragged(MouseEvent e) {
/* 1978 */     this.adaptee.jSlider_fraun_longOnda_mouseDragged(e);
/*      */   }
/*      */ }