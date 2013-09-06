/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.MouseMotionAdapter;
/*      */ 
/*      */ class DifraccionApplet_jSlider_fraun_distFocal_mouseMotionAdapter extends MouseMotionAdapter
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jSlider_fraun_distFocal_mouseMotionAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2080 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void mouseDragged(MouseEvent e) {
/* 2083 */     this.adaptee.jSlider_fraun_distFocal_mouseDragged(e);
/*      */   }
/*      */ }