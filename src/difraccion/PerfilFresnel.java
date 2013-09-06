/*     */ package difraccion;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
import java.awt.geom.Line2D;
/*     */ import java.awt.geom.Line2D.Double;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class PerfilFresnel extends JPanel
/*     */ {
/*     */   int lambda;
/*     */   int dim_x;
/*     */   int dim_y;
/*  28 */   int dim_Lx = 256;
/*  29 */   int dim_Ly = 256;
/*  30 */   int dim_Total = this.dim_Lx * this.dim_Ly;
/*     */ 
/*  32 */   double[] valores = new double[this.dim_Lx];
/*     */ 
/*     */   public PerfilFresnel() {
/*     */     try {
/*  36 */       jbInit();
/*     */     }
/*     */     catch (Exception e) {
/*  39 */       e.printStackTrace();
/*     */     }
/*  41 */     for (int i = 0; i < this.dim_Lx; i++) this.valores[i] = 0.0D; 
/*     */   }
/*     */ 
/*     */   private void jbInit() throws Exception {
/*  44 */     setBackground(Color.black);
/*  45 */     setMinimumSize(new Dimension(256, 256));
/*  46 */     setPreferredSize(new Dimension(256, 256));
/*     */   }
/*     */ 
/*     */   public void putAtributos(int tam_x, int tam_y, double[] matriz, int l_onda)
/*     */   {
/*  51 */     this.lambda = l_onda;
/*  52 */     this.dim_x = tam_x;
/*  53 */     this.dim_y = tam_y;
/*     */ 
/*  57 */     for (int i = 0; i < this.dim_x; i++)
/*  58 */       this.valores[i] = matriz[(i + this.dim_y / 2 * this.dim_x)];
/*     */   }
/*     */ 
/*     */   public void paint(Graphics g)
/*     */   {
/*  66 */     Graphics2D g2 = (Graphics2D)g;
/*  67 */     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*     */ 
/*  77 */     YoungColor ycolores = new YoungColor();
/*  78 */     Color ncolor = ycolores.lambda2RGB(this.lambda);
/*     */ 
/*  83 */     double[] brillo = new double[this.dim_Lx];
/*     */ 
/*  85 */     for (int i = 0; i < this.dim_Lx; i++) {
/*  86 */       brillo[i] = this.valores[i];
/*     */     }
/*     */ 
/*  89 */     double brillo_0 = brillo[0];
/*     */ 
/*  91 */     double max_brillo = brillo[0];
/*  92 */     double min_brillo = brillo[0];
/*  93 */     for (int i = 0; i < this.dim_x; i++) {
/*  94 */       if (max_brillo < brillo[i]) max_brillo = brillo[i];
/*  95 */       if (min_brillo <= brillo[i]) continue; min_brillo = brillo[i];
/*     */     }
/*  97 */     brillo_0 = (brillo_0 - min_brillo) / (max_brillo - min_brillo);
/*  98 */     if ((brillo_0 >= 0.0D) && (brillo_0 <= 1.0D)) {
/*  99 */       brillo_0 = this.dim_Ly - 10.0D + 5.0D - brillo_0 * (this.dim_Ly - 10);
/*     */     }
/*     */     else {
/* 102 */       brillo_0 = 0.0D;
/*     */     }
/*     */ 
/* 105 */     for (int i = 0; i < this.dim_Lx; i++) {
/* 106 */       brillo[i] = ((brillo[i] - min_brillo) / (max_brillo - min_brillo));
/* 107 */       brillo[i] = (this.dim_Ly - 10.0D + 5.0D - brillo[i] * (this.dim_Ly - 10));
/*     */     }
/*     */ 
/* 110 */     g2.setPaint(ncolor);
/* 111 */     for (int i = 1; i < this.dim_Lx; i++) {
/* 112 */       g2.draw(new Line2D.Double(i - 1, brillo_0, i, brillo[i]));
/* 113 */       brillo_0 = brillo[i];
/*     */     }
/*     */   }
/*     */ }