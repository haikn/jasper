/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ 
/*      */ class DifraccionApplet_jSlider_fres_dimx_mouseAdapter extends MouseAdapter
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jSlider_fres_dimx_mouseAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2384 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void mouseClicked(MouseEvent e) {
/* 2387 */     this.adaptee.jSlider_fres_dimx_mouseClicked(e);
/*      */   }
/*      */ }