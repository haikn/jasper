/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ 
/*      */ class DifraccionApplet_jSlider_fraun_umbral_mouseAdapter extends MouseAdapter
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jSlider_fraun_umbral_mouseAdapter(DifraccionApplet adaptee)
/*      */   {
/* 2196 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void mouseClicked(MouseEvent e) {
/* 2199 */     this.adaptee.jSlider_fraun_umbral_mouseClicked(e);
/*      */   }
/*      */ }