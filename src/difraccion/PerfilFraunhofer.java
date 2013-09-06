/*     */ package difraccion;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
import java.awt.geom.Line2D;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class PerfilFraunhofer extends JPanel
/*     */ {
/*     */   int lambda;
/*     */   int tipo_objeto;
/*     */   double dim_x;
/*     */   double dim_y;
/*     */   double dist_f;
/*     */   int num_objetos;
/*  25 */   boolean label_int_log = false;
/*  26 */   boolean zoom = false;
/*     */ 
/*  28 */   int dim_Lx = 256;
/*  29 */   int dim_Ly = 256;
/*     */ 
/*     */   public PerfilFraunhofer()
/*     */   {
/*     */     try {
/*  34 */       jbInit();
/*     */     }
/*     */     catch (Exception e) {
/*  37 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jbInit() throws Exception {
/*  42 */     setBackground(Color.black);
/*  43 */     setMinimumSize(new Dimension(256, 256));
/*  44 */     setPreferredSize(new Dimension(256, 256));
/*     */   }
/*     */ 
/*     */   public void putAtributos(int tipo_obj, double tam_x, double tam_y, int num_obj, int l_onda, double distancia_focal, boolean label_zoom) {
/*  48 */     this.num_objetos = num_obj;
/*  49 */     this.lambda = l_onda;
/*  50 */     this.tipo_objeto = tipo_obj;
/*  51 */     this.dim_x = tam_x;
/*  52 */     this.dim_y = tam_y;
/*  53 */     this.dist_f = distancia_focal;
/*  54 */     this.zoom = label_zoom;
/*     */   }
/*     */ 
/*     */   public void paint(Graphics g)
/*     */   {
/*  59 */     Graphics2D g2 = (Graphics2D)g;
/*  60 */     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*  61 */     Dimension dim = getSize();
/*     */ 
/*  66 */     int dim_Total = this.dim_Lx * this.dim_Ly;
/*  67 */     double half_dim_Lx = this.dim_Lx / 2.0D;
/*  68 */     double half_dim_Ly = this.dim_Ly / 2.0D;
/*  69 */     YoungColor ycolores = new YoungColor();
/*  70 */     Color ncolor = ycolores.lambda2RGB(this.lambda);
/*     */ 
/*  72 */     double delta_pix = 10.0D / this.dim_Lx;
/*  73 */     double dim_x_max = 3.0D;
/*  74 */     double dist_separa = 0.0D;
/*     */ 
/*  77 */     double[] int_objeto = new double[dim_Total];
/*     */ 
/*  83 */     double[] int_difred = new double[dim_Total];
/*     */ 
/*  87 */     double[] brillo = new double[dim_Total];
/*     */ 
/*  92 */     if (this.num_objetos < 5) dist_separa = 2.0D * dim_x_max;
/*  93 */     else if ((this.num_objetos > 4) && (this.num_objetos < 9)) dist_separa = dim_x_max / 2.0D;
/*  94 */     else if ((this.num_objetos > 8) && (this.num_objetos < 11)) dist_separa = dim_x_max / 4.0D;
/*     */ 
/*  98 */     double semi_periodo = 0.0D;
/*     */ 
/* 101 */     if (this.num_objetos == 1) {
/* 102 */       if (this.tipo_objeto == 0) {
/* 103 */         if (this.dim_x > this.dim_y) {
/* 104 */           semi_periodo = this.lambda * 1.0E-006D * this.dist_f / (2.0D * this.dim_x);
/*     */         }
/*     */         else {
/* 107 */           semi_periodo = this.lambda * 1.0E-006D * this.dist_f / (2.0D * this.dim_y);
/*     */         }
/*     */       }
/* 110 */       else if (this.tipo_objeto == 1) {
/* 111 */         semi_periodo = this.lambda * 1.0E-006D * this.dist_f * 1.22D / (8.0D * this.dim_x);
/*     */       }
/*     */       else {
/* 114 */         semi_periodo = this.lambda * 1.0E-006D * this.dist_f / (2.0D * this.dim_x);
/*     */       }
/*     */     }
/*     */     else {
/* 118 */       semi_periodo = this.lambda * 1.0E-006D * this.dist_f / (2.0D * this.num_objetos * (dim_x_max + dist_separa));
/*     */     }
/*     */ 
/* 121 */     if (semi_periodo * this.dim_Lx > 7.5D) delta_pix = 5.0D / this.dim_Lx;
/* 122 */     else if ((semi_periodo * this.dim_Lx <= 7.5D) && (semi_periodo * this.dim_Lx > 5.0D)) delta_pix = 3.0D / this.dim_Lx;
/* 123 */     else if ((semi_periodo * this.dim_Lx <= 5.0D) && (semi_periodo * this.dim_Lx > 2.0D)) delta_pix = 2.5D / this.dim_Lx;
/* 124 */     else if ((semi_periodo * this.dim_Lx <= 2.0D) && (semi_periodo * this.dim_Lx > 1.0D)) delta_pix = 0.5D / this.dim_Lx; else {
/* 125 */       delta_pix = 0.25D / this.dim_Lx;
/*     */     }
/* 127 */     if (this.zoom == true)
/*     */     {
/*     */       double fraun_mindif;
/* 129 */       if (this.tipo_objeto == 0) {
/* 130 */         fraun_mindif = this.lambda * 1.0E-006D * this.dist_f / this.dim_x;
/*     */       }
/*     */       else
/*     */       {
/* 132 */         if (this.tipo_objeto == 1) {
/* 133 */           fraun_mindif = 1.22D * this.lambda * 1.0E-006D * this.dist_f / (2.0D * this.dim_x);
/*     */         }
/*     */         else
/* 136 */           fraun_mindif = this.lambda * 1.0E-006D * this.dist_f / this.dim_x;
/*     */       }
/* 138 */       delta_pix = 2.0D * fraun_mindif / this.dim_Lx;
/*     */     }
/*     */ 
/* 158 */     double lambda_f = this.lambda * 1.0E-006D * this.dist_f;
/* 159 */     double inv_lambda_f = 1.0D / lambda_f;
/* 160 */     if (this.tipo_objeto == 0) {
/* 161 */       double factor_rect = this.dim_x * this.dim_x * this.dim_y * this.dim_y * (inv_lambda_f * inv_lambda_f);
/*     */ 
/* 163 */       for (int i = 0; i < this.dim_Ly; i++) {
/* 164 */         for (int j = 0; j < this.dim_Lx; j++) {
/* 165 */           double x = this.dim_x * ((j - half_dim_Lx) * delta_pix) * inv_lambda_f;
/*     */           double sinc_x;
/* 167 */           if (x != 0.0D) {
/* 168 */             sinc_x = Math.sin(3.141592653589793D * x) / (3.141592653589793D * x);
/*     */           }
/*     */           else {
/* 171 */             sinc_x = 1.0D;
/*     */           }
/*     */ 
/* 174 */           int_objeto[(j + i * this.dim_Lx)] = (factor_rect * sinc_x * sinc_x);
/*     */         }
/*     */       }
/*     */     }
/* 178 */     else if (this.tipo_objeto == 1) {
/* 179 */       double radio = Math.sqrt(this.dim_x * this.dim_x + this.dim_y * this.dim_y);
/* 180 */       for (int i = 0; i < this.dim_Ly; i++)
/* 181 */         for (int j = 0; j < this.dim_Lx; j++) {
/* 182 */           double r_x = (j - half_dim_Lx) * delta_pix;
/*     */ 
/* 184 */           double r = Math.sqrt(r_x * r_x);
/* 185 */           if (r != 0.0D) {
/* 186 */             double var_bessel = 6.283185307179586D * radio * r * inv_lambda_f;
/*     */ 
/* 190 */             double bessel = bessj1(var_bessel);
/*     */ 
/* 192 */             int_objeto[(j + i * this.dim_Lx)] = (bessel * bessel / (var_bessel * var_bessel));
/*     */           }
/*     */           else {
/* 195 */             int_objeto[(j + i * this.dim_Lx)] = 0.25D;
/*     */           }
/*     */         }
/*     */     }
/*     */     else
/*     */     {
/* 201 */       double factor_rend = this.dim_x * this.dim_x * 64.0D * 64.0D * (inv_lambda_f * inv_lambda_f);
/*     */ 
/* 203 */       for (int i = 0; i < this.dim_Ly; i++) {
/* 204 */         for (int j = 0; j < this.dim_Lx; j++) {
/* 205 */           double x = this.dim_x * ((j - half_dim_Lx) * delta_pix) * inv_lambda_f;
/*     */           double sinc_x;
/* 206 */           if (x != 0.0D) {
/* 207 */             sinc_x = Math.sin(3.141592653589793D * x) / (3.141592653589793D * x);
/*     */           }
/*     */           else {
/* 210 */             sinc_x = 1.0D;
/*     */           }
/* 212 */           int_objeto[(j + i * this.dim_Lx)] = (factor_rend * sinc_x * sinc_x);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 217 */     if (this.num_objetos == 1) {
/* 218 */       for (int i = 0; i < dim_Total; i++) {
/* 219 */         int_difred[i] = 1.0D;
/*     */       }
/*     */     }
/* 222 */     else if ((this.num_objetos > 1) && (this.num_objetos < 11)) {
/* 223 */       double periodo_x = dist_separa + dim_x_max;
/* 224 */       double param = 3.141592653589793D * periodo_x * inv_lambda_f;
/* 225 */       for (int i = 0; i < this.dim_Ly; i++) {
/* 226 */         for (int j = 0; j < this.dim_Lx; j++) {
/* 227 */           double x = (j - half_dim_Lx) * delta_pix;
/* 228 */           double sin_x = Math.sin(param * x);
/* 229 */           double sin_nx = Math.sin(this.num_objetos * param * x);
/* 230 */           if (sin_x != 0.0D) {
/* 231 */             int_difred[(j + i * this.dim_Lx)] = (sin_nx * sin_nx / (sin_x * sin_x));
/*     */           }
/*     */           else
/* 234 */             int_difred[(j + i * this.dim_Lx)] = (this.num_objetos * this.num_objetos * 1.0D);
/*     */         }
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 240 */       double periodo_x = dist_separa + dim_x_max;
/* 241 */       double periodo_y = dist_separa + dim_x_max;
/* 242 */       double param = 3.141592653589793D * periodo_x * inv_lambda_f;
/*     */ 
/* 244 */       for (int i = 0; i < this.dim_Ly; i++) {
/* 245 */         for (int j = 0; j < this.dim_Lx; j++) {
/* 246 */           double x = (j - half_dim_Lx) * delta_pix;
/*     */ 
/* 248 */           double sin_x = Math.sin(param * x);
/* 249 */           double sin_nx = Math.sin(this.num_objetos / 100 * param * x);
/*     */ 
/* 252 */           if (sin_x != 0.0D) {
/* 253 */             int_difred[(j + i * this.dim_Lx)] = (sin_nx * sin_nx / (sin_x * sin_x));
/*     */           }
/*     */           else {
/* 256 */             int_difred[(j + i * this.dim_Lx)] = (this.num_objetos * this.num_objetos * 1.0D);
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 263 */     for (int i = 0; i < dim_Total; i++) {
/* 264 */       int_objeto[i] *= int_difred[i];
/*     */     }
/*     */ 
/* 268 */     double brillo_0 = brillo[0];
/* 269 */     double max_brillo = brillo[0];
/* 270 */     double min_brillo = brillo[0];
/* 271 */     for (int i = 0; i < dim_Total; i++) {
/* 272 */       if (max_brillo < brillo[i]) max_brillo = brillo[i];
/* 273 */       if (min_brillo <= brillo[i]) continue; min_brillo = brillo[i];
/*     */     }
/* 275 */     brillo_0 = (brillo_0 - min_brillo) / (max_brillo - min_brillo);
/* 276 */     if ((brillo_0 >= 0.0D) && (brillo_0 <= 1.0D)) {
/* 277 */       brillo_0 = this.dim_Ly - 10.0D + 5.0D - brillo_0 * (this.dim_Ly - 10);
/*     */     }
/*     */     else {
/* 280 */       brillo_0 = 0.0D;
/*     */     }
/*     */ 
/* 283 */     for (int i = 0; i < dim_Total; i++) {
/* 284 */       brillo[i] = ((brillo[i] - min_brillo) / (max_brillo - min_brillo));
/* 285 */       brillo[i] = (this.dim_Ly - 10.0D + 5.0D - brillo[i] * (this.dim_Ly - 10));
/*     */     }
/*     */ 
/* 288 */     g2.setPaint(ncolor);
/* 289 */     for (int i = 0; i < this.dim_Lx; i++) {
/* 290 */       g2.draw(new Line2D.Double(i - 1, brillo_0, i, brillo[i]));
/* 291 */       brillo_0 = brillo[i];
/*     */     }
/*     */   }
/*     */ 
/*     */   public double bessj1(double x)
/*     */   {
/*     */     double ax;
/*     */     double ans;
/* 307 */     if ((ax = Math.abs(x)) < 8.0D) {
/* 308 */       double y = x * x;
/* 309 */       double ans1 = x * (72362614232.0D + y * (-7895059235.0D + y * (242396853.09999999D + y * (-2972611.4389999998D + y * (15704.482599999999D + y * -30.160366060000001D)))));
/* 310 */       double ans2 = 144725228442.0D + y * (2300535178.0D + y * (18583304.739999998D + y * (99447.433940000003D + y * (376.9991397D + y * 1.0D))));
/* 311 */       ans = ans1 / ans2;
/*     */     } else {
/* 313 */       double z = 8.0D / ax;
/* 314 */       double y = z * z;
/* 315 */       double xx = ax - 2.356194491D;
/* 316 */       double ans1 = 1.0D + y * (0.00183105D + y * (-3.516396496E-005D + y * (2.457520174E-006D + y * -2.40337019E-007D)));
/* 317 */       double ans2 = 0.04687499995D + y * (-0.0002002690873D + y * (8.449199096E-006D + y * (-8.8228987E-007D + y * 1.05787412E-007D)));
/* 318 */       ans = Math.sqrt(0.636619772D / ax) * (Math.cos(xx) * ans1 - z * Math.sin(xx) * ans2);
/* 319 */       if (x < 0.0D) ans = -ans;
/*     */     }
/* 321 */     return ans;
/*     */   }
/*     */ }