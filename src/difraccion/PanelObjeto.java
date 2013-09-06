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
/*    */ public class PanelObjeto extends JPanel
/*    */ {
/*    */   int lambda;
/*    */   int tipo_objeto;
/*    */   double dim_x;
/*    */   double dim_y;
/*    */   int num_objetos;
/*    */ 
/*    */   public PanelObjeto()
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
/*    */   public void putAtributos(int tipo_obj, double tam_x, double tam_y, int num_obj, int l_onda) {
/* 40 */     this.num_objetos = num_obj;
/* 41 */     this.lambda = l_onda;
/* 42 */     this.tipo_objeto = tipo_obj;
/* 43 */     this.dim_x = tam_x;
/* 44 */     this.dim_y = tam_y;
/*    */   }
/*    */ 
/*    */   public void paint(Graphics g) {
/* 48 */     Graphics2D g2 = (Graphics2D)g;
/* 49 */     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/* 50 */     Dimension dim = getSize();
/* 51 */     int dim_Lx = dim.width;
/* 52 */     int dim_Ly = dim.height;
/* 53 */     YoungColor ycolores = new YoungColor();
/* 54 */     Color ncolor = ycolores.lambda2RGB(this.lambda);
/*    */ 
/* 56 */     double delta_pix = 6.0D;
/* 57 */     double dim_x_max = 3.0D;
/* 58 */     double dist_separa = 0.0D;
/*    */ 
/* 62 */     if (this.num_objetos < 5) dist_separa = 2.0D * dim_x_max * delta_pix;
/* 63 */     else if ((this.num_objetos > 4) && (this.num_objetos < 9)) dist_separa = dim_x_max * delta_pix / 2.0D;
/* 64 */     else if ((this.num_objetos > 8) && (this.num_objetos < 11)) dist_separa = dim_x_max * delta_pix / 4.0D;
/*    */ 
/* 67 */     g2.setPaint(ncolor);
/*    */ 
/* 69 */     double x_cero = dim_Lx / 2.0D - this.dim_x * delta_pix / 2.0D - (this.num_objetos - 1) / 2.0D * (dist_separa + dim_x_max * delta_pix);
/* 70 */     double ladox = this.dim_x * delta_pix;
/* 71 */     double ladoy = this.dim_y * delta_pix;
/*    */ 
/* 73 */     if (this.tipo_objeto == 0) {
/* 74 */       for (int i = 0; i < this.num_objetos; i++) {
/* 75 */         double x = x_cero + (dist_separa + dim_x_max * delta_pix) * i;
/* 76 */         double y = dim_Ly / 2.0D - ladoy / 2.0D;
/* 77 */         g2.fill(new Rectangle2D.Double(x, y, ladox, ladoy));
/*    */       }
/*    */     }
/* 80 */     else if (this.tipo_objeto == 1) {
/* 81 */       for (int i = 0; i < this.num_objetos; i++) {
/* 82 */         double x = x_cero + (dist_separa + dim_x_max * delta_pix) * i;
/* 83 */         double y = dim_Ly / 2.0D - ladox / 2.0D;
/* 84 */         g2.fill(new Ellipse2D.Double(x, y, ladox, ladox));
/*    */       }
/*    */     }
/*    */     else
/* 88 */       for (int i = 0; i < this.num_objetos; i++) {
/* 89 */         double x = x_cero + (dist_separa + dim_x_max * delta_pix) * i;
/* 90 */         double y = 0.0D;
/* 91 */         g2.fill(new Rectangle2D.Double(x, y, ladox, dim_Ly));
/*    */       }
/*    */   }
/*    */ }