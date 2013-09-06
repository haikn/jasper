/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.MouseMotionAdapter;
/*      */ 
/*      */ class DifraccionApplet_jSlider_fraun_dimx_mouseMotionAdapter extends MouseMotionAdapter
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jSlider_fraun_dimx_mouseMotionAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2116 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void mouseDragged(MouseEvent e) {
/* 2119 */     this.adaptee.jSlider_fraun_dimx_mouseDragged(e);
/*      */   }
/*      */ }