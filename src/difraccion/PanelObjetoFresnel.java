/*    */ package difraccion;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
/*    */ import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Rectangle2D;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class PanelObjetoFresnel extends JPanel
/*    */ {
/*    */   int lambda;
/*    */   int tipo_objeto;
/*    */   double dim_x;
/*    */   double dim_y;
/*    */ 
/*    */   public PanelObjetoFresnel()
/*    */   {
/*    */     try
/*    */     {
/* 27 */       jbInit();
/*    */     }
/*    */     catch (Exception e) {
/* 30 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   private void jbInit() throws Exception {
/* 34 */     setBackground(Color.black);
/* 35 */     setMinimumSize(new Dimension(256, 256));
/* 36 */     setPreferredSize(new Dimension(256, 256));
/*    */   }
/*    */ 
/*    */   public void putAtributos(int tipo_obj, double tam_x, double tam_y, int l_onda) {
/* 40 */     this.lambda = l_onda;
/* 41 */     this.tipo_objeto = tipo_obj;
/* 42 */     this.dim_x = tam_x;
/* 43 */     this.dim_y = tam_y;
/*    */   }
/*    */ 
/*    */   public void paint(Graphics g) {
/* 47 */     Graphics2D g2 = (Graphics2D)g;
/* 48 */     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/* 49 */     Dimension dim = getSize();
/* 50 */     int dim_Lx = dim.width;
/* 51 */     int dim_Ly = dim.height;
/* 52 */     YoungColor ycolores = new YoungColor();
/* 53 */     Color ncolor = ycolores.lambda2RGB(this.lambda);
/*    */ 
/* 55 */     double delta_pix = 42.0D;
/*    */ 
/* 61 */     g2.setPaint(ncolor);
/*    */ 
/* 63 */     double ladox = this.dim_x * delta_pix;
/* 64 */     double ladoy = this.dim_y * delta_pix;
/* 65 */     double x_cero = dim_Lx / 2.0D - ladox / 2.0D;
/* 66 */     double y_cero = dim_Ly / 2.0D - ladoy / 2.0D;
/*    */ 
/* 69 */     if (this.tipo_objeto == 0) {
/* 70 */       g2.fill(new Rectangle2D.Double(x_cero, y_cero, ladox, ladoy));
/*    */     }
/* 72 */     else if (this.tipo_objeto == 1) {
/* 73 */       g2.fill(new Ellipse2D.Double(x_cero, x_cero, ladox, ladox));
/*    */     }
/* 75 */     else if (this.tipo_objeto == 3) {
/* 76 */       g2.fill(new Rectangle2D.Double(x_cero, 0.0D, ladox, dim_Ly));
/*    */     }
/*    */     else
/* 79 */       g2.fill(new Rectangle2D.Double(0.0D, 0.0D, dim_Lx / 2.0D, dim_Ly));
/*    */   }
/*    */ }