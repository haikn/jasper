/*      */ package difraccion;
/*      */ 
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ 
/*      */ class DifraccionApplet_jSlider_fraun_longOnda_mouseAdapter extends MouseAdapter
/*      */ {
/*      */   DifraccionApplet adaptee;
/*      */ 
/*      */   DifraccionApplet_jSlider_fraun_longOnda_mouseAdapter(DifraccionApplet adaptee)
/*      */   {
/* 1964 */     this.adaptee = adaptee;
/*      */   }
/*      */   public void mouseClicked(MouseEvent e) {
/* 1967 */     this.adaptee.jSlider_fraun_longOnda_mouseClicked(e);
/*      */   }
/*      */ }