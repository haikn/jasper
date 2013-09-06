/*     */ package difraccion;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class TransformadaFresnel
/*     */ {
/*     */   public void transformadaFresnel(double distancia, int dim_x, int dim_y, double[] parte_real, double[] parte_imag, double pix_x, double pix_y, double lambda)
/*     */   {
/*  34 */     double longonda = lambda * 1.0E-006D;
/*     */ 
/*  36 */     transformada_directa(distancia, dim_x, dim_y, parte_real, parte_imag, pix_x, pix_y, longonda);
/*     */ 
/*  38 */     Fft2.fft2r2(dim_y, dim_x, -1, parte_real, parte_imag);
/*     */ 
/*  41 */     double cosfase = Math.cos(6.283185307179586D * distancia / longonda);
/*  42 */     double senfase = Math.sin(6.283185307179586D * distancia / longonda);
/*     */ 
/*  44 */     for (int i = 0; i < dim_y; i++)
/*  45 */       for (int j = 0; j < dim_x; j++) {
/*  46 */         double temp_re = cosfase * parte_real[(j + i * dim_x)] - senfase * parte_imag[(j + i * dim_x)];
/*  47 */         double temp_im = cosfase * parte_imag[(j + i * dim_x)] + senfase * parte_real[(j + i * dim_x)];
/*     */ 
/*  50 */         parte_real[(j + i * dim_x)] = temp_re;
/*  51 */         parte_imag[(j + i * dim_x)] = temp_im;
/*     */       }
/*     */   }
/*     */ 
/*     */   public void transformada_directa(double distancia, int tam_x, int tam_y, double[] real, double[] imag, double delta_x, double delta_y, double lambda)
/*     */   {
/*  72 */     int tam_total = tam_x * tam_y;
/*     */ 
/*  74 */     double[] fase_re = new double[tam_total];
/*  75 */     double[] fase_im = new double[tam_total];
/*     */ 
/*  77 */     Fft2.fft2r2(tam_y, tam_x, 1, real, imag);
/*     */ 
/*  79 */     double longonda = lambda;
/*     */ 
/*  83 */     double factor_u = 1.0D / (tam_x * delta_x);
/*  84 */     double factor_v = 1.0D / (tam_y * delta_y);
/*     */ 
/*  86 */     for (int i = 0; i < tam_y; i++) {
/*  87 */       for (int j = 0; j < tam_x; j++) {
/*  88 */         double x_hip = factor_u * (j - tam_x * 0.5D);
/*  89 */         double y_hip = factor_v * (i - tam_y * 0.5D);
/*  90 */         double hipot = x_hip * x_hip + y_hip * y_hip;
/*  91 */         fase_re[(j + i * tam_x)] = Math.cos(-3.141592653589793D * longonda * hipot * distancia);
/*  92 */         fase_im[(j + i * tam_x)] = Math.sin(-3.141592653589793D * longonda * hipot * distancia);
/*     */       }
/*     */     }
/*     */ 
/*  96 */     for (int i = 0; i < tam_y; i++)
/*  97 */       for (int j = 0; j < tam_x; j++) {
/*  98 */         double temp_re = fase_re[(j + i * tam_x)] * real[(j + i * tam_x)] - fase_im[(j + i * tam_x)] * imag[(j + i * tam_x)];
/*  99 */         double temp_im = fase_re[(j + i * tam_x)] * imag[(j + i * tam_x)] + fase_im[(j + i * tam_x)] * real[(j + i * tam_x)];
/* 100 */         real[(j + i * tam_x)] = temp_re;
/* 101 */         imag[(j + i * tam_x)] = temp_im;
/*     */       }
/*     */   }
/*     */ 
/*     */   public void transformadaFresnelSigno(double distancia, int dim_x, int dim_y, double[] parte_real, double[] parte_imag, double pix_x, double pix_y, double lambda)
/*     */   {
/* 115 */     double longonda = lambda * 1.0E-006D;
/*     */ 
/* 117 */     double[] real = new double[dim_x * dim_y * 2 * 2];
/* 118 */     double[] imag = new double[dim_x * dim_y * 2 * 2];
/*     */ 
/* 131 */     transformada_directa_signo(distancia, dim_x, dim_y, parte_real, parte_imag, pix_x, pix_y, longonda);
/*     */ 
/* 134 */     Fft2.fft2r2(dim_y, dim_x, -1, parte_real, parte_imag);
/*     */ 
/* 138 */     double cosfase = Math.cos(6.283185307179586D * distancia / longonda);
/* 139 */     double senfase = Math.sin(6.283185307179586D * distancia / longonda);
/*     */ 
/* 141 */     for (int i = 0; i < dim_y; i++)
/* 142 */       for (int j = 0; j < dim_x; j++) {
/* 143 */         double temp_re = cosfase * parte_real[(j + i * dim_x)] - senfase * parte_imag[(j + i * dim_x)];
/* 144 */         double temp_im = cosfase * parte_imag[(j + i * dim_x)] + senfase * parte_real[(j + i * dim_x)];
/*     */ 
/* 149 */         parte_real[(j + i * dim_x)] = temp_re;
/* 150 */         parte_imag[(j + i * dim_x)] = temp_im;
/*     */       }
/*     */   }
/*     */ 
/*     */   public void transformada_directa_signo(double distancia, int tam_x, int tam_y, double[] real, double[] imag, double delta_x, double delta_y, double lambda)
/*     */   {
/* 177 */     double x_trans = 0.0D;
/*     */ 
/* 180 */     int tam_total = tam_x * tam_y;
/*     */ 
/* 182 */     double[] fase_re = new double[tam_total];
/* 183 */     double[] fase_im = new double[tam_total];
/*     */ 
/* 185 */     double longonda = lambda;
/*     */ 
/* 189 */     double factor_u = 1.0D / (tam_x * delta_x);
/* 190 */     double factor_v = 1.0D / (tam_y * delta_y);
/*     */ 
/* 232 */     double[] tf_re = new double[tam_x];
/* 233 */     double[] tf_im = new double[tam_x];
/* 234 */     for (int i = 0; i < tam_x; i++) {
/* 235 */       for (int j = 0; j < tam_x; j++) {
/* 236 */         tf_re[i] += real[(j + 128 * tam_x)] * Math.cos(6.283185307179586D * (j * i) / tam_x);
/* 237 */         tf_im[i] += real[(j + 128 * tam_x)] * Math.sin(6.283185307179586D * (j * i) / tam_x);
/*     */       }
/*     */     }
/* 240 */     for (int j = 0; j < tam_y; j++) {
/* 241 */       for (int i = 0; i < tam_y; i++) {
/* 242 */         real[(i + j * tam_x)] = tf_re[i];
/* 243 */         imag[(i + j * tam_x)] = tf_im[i];
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 250 */     for (int i = 0; i < tam_y; i++) {
/* 251 */       for (int j = 0; j < tam_x; j++) {
/* 252 */         double x_hip = factor_u * (j - tam_x * 0.5D);
/* 253 */         double y_hip = factor_v * (i - tam_y * 0.5D);
/* 254 */         double hipot = x_hip * x_hip + y_hip * y_hip;
/* 255 */         fase_re[(j + i * tam_x)] = Math.cos(-3.141592653589793D * longonda * hipot * distancia);
/* 256 */         fase_im[(j + i * tam_x)] = Math.sin(-3.141592653589793D * longonda * hipot * distancia);
/*     */       }
/*     */     }
/*     */ 
/* 260 */     for (int i = 0; i < tam_y; i++)
/* 261 */       for (int j = 0; j < tam_x; j++) {
/* 262 */         double temp_re = fase_re[(j + i * tam_x)] * real[(j + i * tam_x)] - fase_im[(j + i * tam_x)] * imag[(j + i * tam_x)];
/* 263 */         double temp_im = fase_re[(j + i * tam_x)] * imag[(j + i * tam_x)] + fase_im[(j + i * tam_x)] * real[(j + i * tam_x)];
/* 264 */         real[(j + i * tam_x)] = temp_re;
/* 265 */         imag[(j + i * tam_x)] = temp_im;
/*     */       }
/*     */   }
/*     */ 
/*     */   public void integralesFresnel_numericalRecipes(double x, double s, double c)
/*     */   {
/* 274 */     double EPS = 6.0E-008D;
/* 275 */     int MAXIT = 100;
/* 276 */     double FPMIN = 1.E-030D;
/* 277 */     double XMIN = 1.5D;
/* 278 */     double PIBY2 = 1.570796326794897D;
/*     */ 
/* 288 */     double ax = Math.abs(x);
/* 289 */     if (ax < Math.sqrt(FPMIN)) {
/* 290 */       s = 0.0D;
/* 291 */       c = ax;
/* 292 */     } else if (ax <= XMIN)
/*     */     {
/*     */       double sums;
/* 293 */       double sum = sums = 0.0D;
/* 294 */       double sumc = ax;
/* 295 */       double sign = 1.0D;
/* 296 */       double fact = PIBY2 * ax * ax;
/* 297 */       boolean odd = true;
/* 298 */       double term = ax;
/* 299 */       int n = 3;
int k = 0;
/* 300 */       for (k = 1; k <= MAXIT; k++) {
/* 301 */         term *= fact / k;
/* 302 */         sum += sign * term / n;
/* 303 */         double test = Math.abs(sum) * EPS;
/* 304 */         if (odd) {
/* 305 */           sign = -sign;
/* 306 */           sums = sum;
/* 307 */           sum = sumc;
/*     */         } else {
/* 309 */           sumc = sum;
/* 310 */           sum = sums;
/*     */         }
/* 312 */         if (term < test) break;
/* 313 */         odd = !odd;
/* 314 */         n += 2;
/*     */       }
/* 316 */       if (k > MAXIT) System.out.println("series failed in integralesFresnel");
/* 317 */       s = sums;
/* 318 */       c = sumc;
/*     */     } else {
/* 320 */       double pix2 = 3.141592653589793D * ax * ax;
/* 321 */       double b_re = 1.0D; double b_im = -pix2;
/* 322 */       double cc_re = 1.0D / FPMIN; double cc_im = 0.0D;
/* 323 */       double h_re = b_re / (b_re * b_re + b_im * b_im);
/* 324 */       double h_im = -b_im / (b_re * b_re + b_im * b_im);
/* 325 */       double d_re = h_re;
/* 326 */       double d_im = h_im;
/* 327 */       int n = -1;
int j = 0;
/* 328 */       for (j = 2; j <= MAXIT; j++) {
/* 329 */         n += 2;
/* 330 */         double a = -n * (n + 1);
/* 331 */         b_re += 4.0D;
/* 332 */         b_im = b_im;
/* 333 */         d_re = (a * d_re + b_re) / ((a * d_re + b_re) * (a * d_re + b_re) + (a * d_im + b_im) * (a * d_im + b_im));
/* 334 */         d_im = -1.0D * (a * d_im + b_im) / ((a * d_re + b_re) * (a * d_re + b_re) + (a * d_im + b_im) * (a * d_im + b_im));
/* 335 */         cc_re = b_re + a * cc_re / (cc_re * cc_re + cc_im * cc_im);
/* 336 */         cc_im = b_im + -a * cc_im / (cc_re * cc_re + cc_im * cc_im);
/* 337 */         double del_re = cc_re * d_re - cc_im * d_im;
/* 338 */         double del_im = cc_re * d_im + cc_im * d_re;
/* 339 */         h_re = h_re * del_re - h_im * del_im;
/* 340 */         h_im = h_re * del_im + h_im * del_re;
/* 341 */         if (Math.abs(del_re - 1.0D) + Math.abs(del_im) < EPS) break;
/*     */       }
/* 343 */       if (j > MAXIT) System.out.println("cf failed in integralesFresnel");
/* 344 */       h_re = ax * h_re + ax * h_im;
/* 345 */       h_im = ax * h_im - ax * h_re;
/*     */ 
/* 347 */       double cs_re = 0.5D * (1.0D + (h_re + h_im) * Math.sin(0.5D * pix2) - Math.cos(0.5D * pix2) * (h_re - h_im));
/*     */ 
/* 349 */       double cs_im = 0.5D * (1.0D - Math.cos(0.5D * pix2) * (h_re + h_im) + Math.sin(0.5D * pix2) * (h_im - h_re));
/* 350 */       c = cs_re;
/* 351 */       s = cs_im;
/*     */     }
/* 353 */     if (x < 0.0D) {
/* 354 */       c = -c;
/* 355 */       s = -s;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void transformadaFresnelSemiplano(double distancia, int dim_x, int dim_y, double[] parte_real, double pix_x, double pix_y, double lambda)
/*     */   {
/* 363 */     double cosfres = 0.0D; double senfres = 0.0D;
/* 364 */     double longonda = lambda * 1.0E-006D;
/*     */ 
/* 369 */     int MAXIT = 100;
/* 370 */     double EPS = 6.0E-008D;
/*     */ 
/* 375 */     double FPMIN = 1.E-030D;
/*     */ 
/* 378 */     for (int j = 0; j < dim_x; j++) {
/* 379 */       double x = (j - dim_x / 2.0D) * pix_x;
/* 380 */       double v = x * Math.sqrt(2.0D / (longonda * distancia));
/*     */ 
/* 385 */       double ax = Math.abs(v);
/*     */ 
/* 387 */       if (ax > 1.5D) {
/* 388 */         double g = (1.0D + 0.9260000000000001D * ax) / (2.0D + (1.792D + 3.104D * ax) * ax);
/* 389 */         double f = 1.0D / (2.0D + (4.142D + (3.492D + 6.67D * ax) * ax) * ax);
/*     */ 
/* 391 */         double cospix2 = Math.cos(1.570796326794897D * ax * ax);
/* 392 */         double senpix2 = Math.sin(1.570796326794897D * ax * ax);
/*     */ 
/* 394 */         cosfres = 0.5D - (cospix2 * g - senpix2 * f);
/* 395 */         senfres = 0.5D + (cospix2 * f + senpix2 * g);
/*     */ 
/* 397 */         if (x < 0.0D) {
/* 398 */           cosfres = -cosfres;
/* 399 */           senfres = -senfres;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/*     */         double sums;
/* 403 */         double sum = sums = 0.0D;
/* 404 */         double sumc = ax;
/* 405 */         double sign = 1.0D;
/* 406 */         double fact = 1.570796326794897D * ax * ax;
/* 407 */         boolean odd = true;
/* 408 */         double term = ax;
/* 409 */         int n = 3;
/* 410 */         for (int k = 1; k <= MAXIT; k++) {
/* 411 */           term *= fact / k;
/* 412 */           sum += sign * term / n;
/* 413 */           double test = Math.abs(sum) * EPS;
/* 414 */           if (odd) {
/* 415 */             sign = -sign;
/* 416 */             sums = sum;
/* 417 */             sum = sumc;
/*     */           }
/*     */           else {
/* 420 */             sumc = sum;
/* 421 */             sum = sums;
/*     */           }
/* 423 */           if (term < test)
/*     */             break;
/* 425 */           odd = !odd;
/* 426 */           n += 2;
/*     */         }
/*     */ 
/* 429 */         senfres = sums;
/* 430 */         cosfres = sumc;
/* 431 */         if (x < 0.0D) {
/* 432 */           cosfres = -cosfres;
/* 433 */           senfres = -senfres;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 440 */       for (int i = 0; i < dim_y; i++)
/* 441 */         parte_real[(j + i * dim_x)] = Math.sqrt(0.5D * ((0.5D - cosfres) * (0.5D - cosfres) + (0.5D - senfres) * (0.5D - senfres)));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void integralesFresnel(double x, double s, double c)
/*     */   {
/* 453 */     double ax = Math.abs(x);
/*     */ 
/* 455 */     double g = (1.0D + 0.9260000000000001D * ax) / (2.0D + 1.792D * ax + 3.104D * ax * ax);
/* 456 */     double f = 1.0D / (2.0D + 4.142D * ax + 3.492D * ax * ax + 6.67D * ax * ax * ax);
/*     */ 
/* 458 */     double cospix2 = Math.cos(1.570796326794897D * ax * ax);
/* 459 */     double senpix2 = Math.sin(1.570796326794897D * ax * ax);
/*     */ 
/* 461 */     c = 0.5D - (cospix2 * g - senpix2 * f);
/* 462 */     s = 0.5D + (cospix2 * f + senpix2 * g);
/*     */ 
/* 464 */     if (x < 0.0D) {
/* 465 */       c = -c;
/* 466 */       s = -s;
/*     */     }
/*     */   }
/*     */ }