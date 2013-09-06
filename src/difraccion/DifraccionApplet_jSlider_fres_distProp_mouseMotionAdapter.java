/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.MouseMotionAdapter;
/*      */ 
/*      */ class DifraccionApplet_jSlider_fres_distProp_mouseMotionAdapter extends MouseMotionAdapter
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jSlider_fres_distProp_mouseMotionAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2359 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void mouseDragged(MouseEvent e) {
/* 2362 */     this.adaptee.jSlider_fres_distProp_mouseDragged(e);
/*      */   }
/*      */ }