/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.MouseMotionAdapter;
/*      */ 
/*      */ class DifraccionApplet_jSlider_fres_dimy_mouseMotionAdapter extends MouseMotionAdapter
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jSlider_fres_dimy_mouseMotionAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2431 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void mouseDragged(MouseEvent e) {
/* 2434 */     this.adaptee.jSlider_fres_dimy_mouseDragged(e);
/*      */   }
/*      */ }