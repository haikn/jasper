/*     */ package difraccion;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.image.MemoryImageSource;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class ImagenFraunhofer extends JPanel
/*     */ {
/*     */   int lambda;
/*     */   int tipo_objeto;
/*     */   double dim_x;
/*     */   double dim_y;
/*     */   double dist_f;
/*     */   int num_objetos;
/*     */   int label_tipoimg;
/*     */   double umbral;
/*  29 */   int dim_Lx = 256;
/*  30 */   int dim_Ly = 256;
/*  31 */   int[] pixels = new int[this.dim_Lx * this.dim_Ly];
/*     */   MemoryImageSource source;
/*     */   Image img;
/*     */ 
/*     */   public ImagenFraunhofer()
/*     */   {
/*     */     try
/*     */     {
/*  37 */       jbInit();
/*     */     }
/*     */     catch (Exception e) {
/*  40 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jbInit() throws Exception {
/*  45 */     setBackground(Color.black);
/*  46 */     setMinimumSize(new Dimension(256, 256));
/*  47 */     setPreferredSize(new Dimension(256, 256));
/*     */ 
/*  54 */     int dim_Total = this.dim_Lx * this.dim_Ly;
/*  55 */     this.pixels = new int[dim_Total];
/*     */ 
/*  57 */     int value = getBackground().getRGB();
/*  58 */     for (int i = 0; i < dim_Total; i++) {
/*  59 */       this.pixels[i] = value;
/*     */     }
/*     */ 
/*  62 */     this.source = new MemoryImageSource(this.dim_Lx, this.dim_Ly, this.pixels, 0, this.dim_Lx);
/*  63 */     this.source.setAnimated(true);
/*  64 */     this.img = createImage(this.source);
/*     */   }
/*     */ 
/*     */   public void putAtributos(int tipo_obj, double tam_x, double tam_y, int num_obj, int l_onda, double distancia_focal, int tipoimg, double fraun_umbral)
/*     */   {
/*  70 */     this.num_objetos = num_obj;
/*  71 */     this.lambda = l_onda;
/*  72 */     this.tipo_objeto = tipo_obj;
/*  73 */     this.dim_x = tam_x;
/*  74 */     this.dim_y = tam_y;
/*  75 */     this.dist_f = distancia_focal;
/*  76 */     this.label_tipoimg = tipoimg;
/*  77 */     this.umbral = fraun_umbral;
/*  78 */     calculaImagen();
/*     */   }
/*     */ 
/*     */   public void paint(Graphics g) {
/*  82 */     g.drawImage(this.img, 0, 0, this);
/*     */   }
/*     */ 
/*     */   public void calculaImagen()
/*     */   {
/*  93 */     int dim_Total = this.dim_Lx * this.dim_Ly;
/*  94 */     double half_dim_Lx = this.dim_Lx / 2.0D;
/*  95 */     double half_dim_Ly = this.dim_Ly / 2.0D;
/*     */ 
/*  97 */     YoungColor ycolores = new YoungColor();
/*  98 */     Color ncolor = ycolores.lambda2RGB(this.lambda);
/*     */ 
/* 100 */     double delta_pix = 5.0D / this.dim_Lx;
/* 101 */     double dim_x_max = 3.0D;
/* 102 */     double dist_separa = 0.0D;
/*     */ 
/* 105 */     double[] int_objeto = new double[dim_Total];
/*     */ 
/* 111 */     double[] int_difred = new double[dim_Total];
/*     */ 
/* 115 */     double[] brillo = new double[dim_Total];
/*     */ 
/* 117 */     this.pixels = new int[dim_Total];
/*     */ 
/* 120 */     if (this.num_objetos < 5) dist_separa = 2.0D * dim_x_max;
/* 121 */     else if ((this.num_objetos > 4) && (this.num_objetos < 9)) dist_separa = dim_x_max / 2.0D;
/* 122 */     else if ((this.num_objetos > 8) && (this.num_objetos < 11)) dist_separa = dim_x_max / 4.0D;
/*     */ 
/* 126 */     double semi_periodo = 0.0D;
/*     */ 
/* 129 */     if (this.num_objetos == 1) {
/* 130 */       if (this.tipo_objeto == 0) {
/* 131 */         if (this.dim_x > this.dim_y) {
/* 132 */           semi_periodo = this.lambda * 1.0E-006D * this.dist_f / (2.0D * this.dim_x);
/*     */         }
/*     */         else
/*     */         {
/* 136 */           semi_periodo = this.lambda * 1.0E-006D * this.dist_f / (2.0D * this.dim_y);
/*     */         }
/*     */       }
/* 139 */       else if (this.tipo_objeto == 1) {
/* 140 */         semi_periodo = this.lambda * 1.0E-006D * this.dist_f * 1.22D / (8.0D * this.dim_x);
/*     */       }
/*     */       else {
/* 143 */         semi_periodo = this.lambda * 1.0E-006D * this.dist_f / (2.0D * this.dim_x);
/*     */       }
/*     */     }
/*     */     else {
/* 147 */       semi_periodo = this.lambda * 1.0E-006D * this.dist_f / (2.0D * this.num_objetos * (dim_x_max + dist_separa));
/*     */     }
/*     */ 
/* 150 */     if (semi_periodo * this.dim_Lx > 7.5D) delta_pix = 5.0D / this.dim_Lx;
/* 151 */     else if ((semi_periodo * this.dim_Lx <= 7.5D) && (semi_periodo * this.dim_Lx > 5.0D)) delta_pix = 3.0D / this.dim_Lx;
/* 152 */     else if ((semi_periodo * this.dim_Lx <= 5.0D) && (semi_periodo * this.dim_Lx > 2.0D)) delta_pix = 2.5D / this.dim_Lx;
/* 153 */     else if ((semi_periodo * this.dim_Lx <= 2.0D) && (semi_periodo * this.dim_Lx > 1.0D)) delta_pix = 0.5D / this.dim_Lx; else {
/* 154 */       delta_pix = 0.25D / this.dim_Lx;
/*     */     }
/*     */ 
/* 167 */     float[] hsb = new float[3];
/* 168 */     hsb = Color.RGBtoHSB(ncolor.getRed(), ncolor.getGreen(), ncolor.getBlue(), hsb);
/*     */ 
/* 172 */     double lambda_f = this.lambda * 1.0E-006D * this.dist_f;
/* 173 */     double inv_lambda_f = 1.0D / lambda_f;
/* 174 */     if (this.tipo_objeto == 0) {
/* 175 */       double factor_rect = this.dim_x * this.dim_y * inv_lambda_f;
/*     */ 
/* 177 */       for (int i = 0; i < this.dim_Ly; i++) {
/* 178 */         for (int j = 0; j < this.dim_Lx; j++) {
/* 179 */           double x = this.dim_x * ((j - half_dim_Lx) * delta_pix) * inv_lambda_f;
/* 180 */           double y = this.dim_y * ((i - half_dim_Ly) * delta_pix) * inv_lambda_f;
/*     */           double sinc_x;
/* 181 */           if (x != 0.0D) {
/* 182 */             sinc_x = Math.abs(Math.sin(3.141592653589793D * x) / (3.141592653589793D * x));
/*     */           }
/*     */           else
/* 185 */             sinc_x = 1.0D;
/*     */           double sinc_y;
/* 187 */           if (y != 0.0D) {
/* 188 */             sinc_y = Math.abs(Math.sin(3.141592653589793D * y) / (3.141592653589793D * y));
/*     */           }
/*     */           else {
/* 191 */             sinc_y = 1.0D;
/*     */           }
/* 193 */           int_objeto[(j + i * this.dim_Lx)] = (factor_rect * sinc_x * sinc_y);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/* 198 */     else if (this.tipo_objeto == 1) {
/* 199 */       double radio = Math.sqrt(this.dim_x * this.dim_x + this.dim_y * this.dim_y);
/* 200 */       for (int i = 0; i < this.dim_Ly; i++)
/* 201 */         for (int j = 0; j < this.dim_Lx; j++) {
/* 202 */           double r_x = (j - half_dim_Lx) * delta_pix;
/* 203 */           double r_y = (i - half_dim_Ly) * delta_pix;
/* 204 */           double r = Math.sqrt(r_x * r_x + r_y * r_y);
/* 205 */           if (r != 0.0D) {
/* 206 */             double var_bessel = 6.283185307179586D * radio * r * inv_lambda_f;
/*     */ 
/* 210 */             double bessel = Math.abs(bessj1(var_bessel));
/*     */ 
/* 212 */             int_objeto[(j + i * this.dim_Lx)] = (bessel / var_bessel);
/*     */           }
/*     */           else
/*     */           {
/* 216 */             int_objeto[(j + i * this.dim_Lx)] = 0.5D;
/*     */           }
/*     */         }
/*     */     }
/*     */     else
/*     */     {
/* 222 */       double factor_rend = this.dim_x * 64.0D * inv_lambda_f;
/*     */ 
/* 224 */       for (int i = 0; i < this.dim_Ly; i++) {
/* 225 */         for (int j = 0; j < this.dim_Lx; j++) {
/* 226 */           double x = this.dim_x * ((j - half_dim_Lx) * delta_pix) * inv_lambda_f;
/* 227 */           double y = 64.0D * ((i - half_dim_Ly) * delta_pix) * inv_lambda_f;
/*     */           double sinc_x;
/* 228 */           if (x != 0.0D) {
/* 229 */             sinc_x = Math.abs(Math.sin(3.141592653589793D * x) / (3.141592653589793D * x));
/*     */           }
/*     */           else
/* 232 */             sinc_x = 1.0D;
/*     */           double sinc_y;
/* 234 */           if (y != 0.0D) {
/* 235 */             sinc_y = Math.abs(Math.sin(3.141592653589793D * y) / (3.141592653589793D * y));
/*     */           }
/*     */           else {
/* 238 */             sinc_y = 1.0D;
/*     */           }
/* 240 */           int_objeto[(j + i * this.dim_Lx)] = (factor_rend * sinc_x * sinc_y);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 247 */     if (this.num_objetos == 1) {
/* 248 */       for (int i = 0; i < dim_Total; i++)
/* 249 */         int_difred[i] = 1.0D;
/*     */     }
/*     */     else
/*     */     {
/* 253 */       double periodo_x = dist_separa + dim_x_max;
/* 254 */       double param = 3.141592653589793D * periodo_x * inv_lambda_f;
/* 255 */       for (int i = 0; i < this.dim_Ly; i++) {
/* 256 */         for (int j = 0; j < this.dim_Lx; j++) {
/* 257 */           double x = (j - half_dim_Lx) * delta_pix;
/* 258 */           double sin_x = Math.sin(param * x);
/* 259 */           double sin_nx = Math.sin(this.num_objetos * param * x);
/* 260 */           if (sin_x != 0.0D) {
/* 261 */             int_difred[(j + i * this.dim_Lx)] = Math.abs(sin_nx / sin_x);
/*     */           }
/*     */           else
/*     */           {
/* 265 */             int_difred[(j + i * this.dim_Lx)] = (this.num_objetos * 1.0D);
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 295 */     for (int i = 0; i < dim_Total; i++) {
/* 296 */       int_objeto[i] *= int_difred[i];
/*     */     }
/*     */ 
/* 300 */     if (this.label_tipoimg == 1) {
/* 301 */       for (int i = 0; i < dim_Total; i++) {
/* 302 */         brillo[i] *= brillo[i];
/*     */       }
/*     */     }
/*     */ 
/* 306 */     if (this.label_tipoimg == 2) {
/* 307 */       for (int i = 0; i < dim_Total; i++) {
/* 308 */         brillo[i] *= brillo[i];
/* 309 */         brillo[i] = Math.log(brillo[i]);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 314 */     double max_brillo = brillo[0];
/* 315 */     double min_brillo = brillo[0];
/* 316 */     for (int i = 0; i < dim_Total; i++) {
/* 317 */       if (max_brillo < brillo[i]) max_brillo = brillo[i];
/* 318 */       if (min_brillo <= brillo[i]) continue; min_brillo = brillo[i];
/*     */     }
/*     */ 
/* 321 */     for (int i = 0; i < dim_Total; i++) {
/* 322 */       if (this.label_tipoimg != 2) {
/* 323 */         if (brillo[i] > max_brillo * this.umbral) {
/* 324 */           brillo[i] = 1.0D;
/*     */         }
/*     */         else {
/* 327 */           brillo[i] = ((brillo[i] - min_brillo) / (max_brillo * this.umbral - min_brillo));
/*     */         }
/*     */       }
/*     */       else {
/* 331 */         brillo[i] = ((brillo[i] - min_brillo) / (max_brillo - min_brillo));
/*     */       }
/*     */ 
/* 334 */       hsb[2] = (float)brillo[i];
/* 335 */       Color clin = new Color(Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]));
/*     */ 
/* 339 */       this.pixels[i] = clin.getRGB();
/*     */     }
/*     */ 
/* 344 */     this.img = createImage(new MemoryImageSource(this.dim_Lx, this.dim_Ly, this.pixels, 0, this.dim_Lx));
/*     */   }
/*     */ 
/*     */   public double bessj1(double x)
/*     */   {
/*     */     double ax;
/*     */     double ans;
/* 357 */     if ((ax = Math.abs(x)) < 8.0D) {
/* 358 */       double y = x * x;
/* 359 */       double ans1 = x * (72362614232.0D + y * (-7895059235.0D + y * (242396853.09999999D + y * (-2972611.4389999998D + y * (15704.482599999999D + y * -30.160366060000001D)))));
/* 360 */       double ans2 = 144725228442.0D + y * (2300535178.0D + y * (18583304.739999998D + y * (99447.433940000003D + y * (376.9991397D + y * 1.0D))));
/* 361 */       ans = ans1 / ans2;
/*     */     } else {
/* 363 */       double z = 8.0D / ax;
/* 364 */       double y = z * z;
/* 365 */       double xx = ax - 2.356194491D;
/* 366 */       double ans1 = 1.0D + y * (0.00183105D + y * (-3.516396496E-005D + y * (2.457520174E-006D + y * -2.40337019E-007D)));
/* 367 */       double ans2 = 0.04687499995D + y * (-0.0002002690873D + y * (8.449199096E-006D + y * (-8.8228987E-007D + y * 1.05787412E-007D)));
/* 368 */       ans = Math.sqrt(0.636619772D / ax) * (Math.cos(xx) * ans1 - z * Math.sin(xx) * ans2);
/* 369 */       if (x < 0.0D) ans = -ans;
/*     */     }
/* 371 */     return ans;
/*     */   }
/*     */ }