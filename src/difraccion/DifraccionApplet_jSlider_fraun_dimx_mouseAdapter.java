/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ 
/*      */ class DifraccionApplet_jSlider_fraun_dimx_mouseAdapter extends MouseAdapter
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jSlider_fraun_dimx_mouseAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2105 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void mouseClicked(MouseEvent e) {
/* 2108 */     this.adaptee.jSlider_fraun_dimx_mouseClicked(e);
/*      */   }
/*      */ }