/*     */ package difraccion;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import java.awt.Frame;
/*     */ import java.awt.TextArea;
/*     */ 
/*     */ public class Fft2
/*     */ {
/*     */   public static void fft2r2(int nfil, int ncol, int isign, double[] x, double[] y)
/*     */   {
/*  38 */     double[] a = new double[nfil * ncol];
/*  39 */     double[] b = new double[nfil * ncol];
/*  40 */     double[] seno = new double[nfil * ncol];
/*  41 */     double[] cose = new double[nfil * ncol];
/*     */ 
/*  44 */     int[] inte = new int[1024];
/*     */ 
/*  49 */     int nf = nfil; if (nfil < ncol) nf = ncol;
/*     */ 
/*  53 */     nf = nfil / 2;
/*  54 */     int nc = ncol / 2;
/*  55 */     double rnfil = 1.0D / Math.sqrt(nfil);
/*  56 */     double rncol = 1.0D / Math.sqrt(ncol);
/*  57 */     double rntot = rnfil * rncol;
/*  58 */     int mf = (int)(Math.log(nfil) / Math.log(2.0D) + 0.1D);
/*  59 */     int mc = (int)(Math.log(ncol) / Math.log(2.0D) + 0.1D);
/*     */ 
/*  68 */     double fd = isign * 6.283185D / ncol;
/*  69 */     int ld = ncol;
/*  70 */     for (int i = 0; i < mc; i++) {
/*  71 */       ld /= 2;
/*  72 */       inte[i] = ld;
/*     */     }
/*  74 */     for (int i = 0; i < ncol; i++) {
/*  75 */       double app = i * fd;
/*  76 */       cose[i] = Math.cos(app);
/*  77 */       seno[i] = Math.sin(app);
/*     */     }
/*     */ 
/*  82 */     for (int ii = 0; ii < nfil; ii++) {
/*  83 */       int k = ii * ncol;
/*  84 */       for (int i = 0; i < nc; i++) {
/*  85 */         int ik = k + i;
/*  86 */         int j = i + nc;
/*  87 */         int jj = k + j;
/*  88 */         a[i] = x[jj];
/*  89 */         b[i] = y[jj];
/*  90 */         a[j] = x[ik];
/*  91 */         b[j] = y[ik];
/*     */       }
/*     */ 
/*  94 */       fftr2(ncol, mc, isign, a, b, inte, seno, cose);
/*     */ 
/*  96 */       for (int i = 0; i < nc; i++) {
/*  97 */         int ik = k + i;
/*  98 */         int j = i + nc;
/*  99 */         int jj = k + j;
/* 100 */         x[jj] = a[i];
/* 101 */         y[jj] = b[i];
/* 102 */         x[ik] = a[j];
/* 103 */         y[ik] = b[j];
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 116 */     if (nfil != ncol) {
/* 117 */       fd = isign * 6.283185D / nfil;
/* 118 */       ld = nfil;
/* 119 */       for (int i = 0; i < mf; i++) {
/* 120 */         ld /= 2;
/* 121 */         inte[i] = ld;
/*     */       }
/* 123 */       for (int i = 0; i < nfil; i++) {
/* 124 */         double app = i * fd;
/* 125 */         cose[i] = Math.cos(app);
/* 126 */         seno[i] = Math.sin(app);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 131 */     int k = nf * ncol;
/* 132 */     for (int jj = 0; jj < ncol; jj++) {
/* 133 */       for (int i = 0; i < nf; i++) {
/* 134 */         int j = i + nf;
/* 135 */         int ii = i * ncol + jj;
/* 136 */         int ik = ii + k;
/* 137 */         a[i] = x[ik];
/* 138 */         b[i] = y[ik];
/* 139 */         a[j] = x[ii];
/* 140 */         b[j] = y[ii];
/*     */       }
/*     */ 
/* 143 */       fftr2(nfil, mf, isign, a, b, inte, seno, cose);
/*     */ 
/* 145 */       for (int i = 0; i < nf; i++) {
/* 146 */         int j = i + nf;
/* 147 */         int ii = i * ncol + jj;
/* 148 */         int ik = ii + k;
/* 149 */         a[i] *= rntot;
/* 150 */         b[i] *= rntot;
/* 151 */         a[j] *= rntot;
/* 152 */         b[j] *= rntot;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void fftr2(int l, int n, int s, double[] x, double[] y, int[] inte, double[] seno, double[] cose)
/*     */   {
/* 184 */     int id = 0;
/*     */ 
/* 187 */     int nd = 1;
/* 188 */     for (int m = 1; m <= n; m++) {
/* 189 */       int nt = nd;
/* 190 */       nd += nd;
/* 191 */       int lt = l / nt;
/* 192 */       int lc = lt / 2;
/* 193 */       int nc = 0;
/* 194 */       for (int ib = 0; ib < nt; ib++) {
/* 195 */         int lci = lt * ib;
/* 196 */         for (int i = 0; i < lc; i++) {
/* 197 */           int j = i + lci;
/* 198 */           int k = j + lc;
/* 199 */           double qu = x[k] * cose[nc] - y[k] * seno[nc];
/* 200 */           double qd = x[k] * seno[nc] + y[k] * cose[nc];
/* 201 */           x[j] -= qu;
/* 202 */           y[j] -= qd;
/* 203 */           x[j] += qu;
/* 204 */           y[j] += qd;
/*     */         }
/* 206 */         for (int i = 1; i < n; i++) {
/* 207 */           id = i;
/* 208 */           if (inte[i] > nc) break;
/* 209 */           nc -= inte[i];
/*     */         }
/* 211 */         nc += inte[id];
/*     */       }
/*     */     }
/*     */ 
/* 215 */     int nc = 0;
/* 216 */     for (int k = 0; k < l; k++) {
/* 217 */       if (nc > k) {
/* 218 */         double hu = x[nc];
/* 219 */         double hd = y[nc];
/* 220 */         x[nc] = x[k];
/* 221 */         y[nc] = y[k];
/* 222 */         x[k] = hu;
/* 223 */         y[k] = hd;
/*     */       }
/* 225 */       for (int i = 0; i < n; i++) {
/* 226 */         id = i;
/* 227 */         if (inte[i] > nc) break;
/* 228 */         nc -= inte[i];
/*     */       }
/* 230 */       nc += inte[id];
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void correlacioMf(int nfil, int ncol, double[] xr, double[] xi, double[] yr, double[] yi)
/*     */   {
/* 240 */     fft2r2(nfil, ncol, 1, xr, xi);
/* 241 */     fft2r2(nfil, ncol, 1, yr, yi);
/* 242 */     double xr0 = 0.0D; double yr0 = 0.0D; double xi0 = 0.0D; double yi0 = 0.0D;
/* 243 */     for (int i = 0; i < nfil * ncol; i++) {
/* 244 */       xr0 = xr[i]; xi0 = xi[i]; yr0 = yr[i]; yi0 = yi[i];
/* 245 */       xr[i] = (xr0 * yr0 + xi0 * yi0);
/* 246 */       xi[i] = (-xr0 * yi0 + xi0 * yr0);
/*     */     }
/* 248 */     fft2r2(nfil, ncol, -1, xr, xi);
/*     */   }
/*     */ 
/*     */   public static void correlacioPof(int nfil, int ncol, double[] xr, double[] xi, double[] yr, double[] yi) {
/* 252 */     fft2r2(nfil, ncol, 1, xr, xi);
/* 253 */     fft2r2(nfil, ncol, 1, yr, yi);
/* 254 */     double xr0 = 0.0D; double yr0 = 0.0D; double xi0 = 0.0D; double yi0 = 0.0D;
/* 255 */     for (int i = 0; i < nfil * ncol; i++) {
/* 256 */       xr0 = xr[i]; xi0 = xi[i]; yr0 = yr[i]; yi0 = yi[i];
/* 257 */       xr[i] = ((xr0 * yr0 + xi0 * yi0) / Math.sqrt(yr0 * yr0 + yi0 * yi0 + 1.0E-008D));
/* 258 */       xi[i] = ((-xr0 * yi0 + xi0 * yr0) / Math.sqrt(yr0 * yr0 + yi0 * yi0 + 1.0E-008D));
/*     */     }
/* 260 */     fft2r2(nfil, ncol, -1, xr, xi);
/*     */   }
/*     */ 
/*     */   public static void correlacioIf(int nfil, int ncol, double[] xr, double[] xi, double[] yr, double[] yi)
/*     */   {
/* 265 */     fft2r2(nfil, ncol, 1, xr, xi);
/* 266 */     fft2r2(nfil, ncol, 1, yr, yi);
/* 267 */     double xr0 = 0.0D; double yr0 = 0.0D; double xi0 = 0.0D; double yi0 = 0.0D;
/* 268 */     for (int i = 0; i < nfil * ncol; i++) {
/* 269 */       xr0 = xr[i]; xi0 = xi[i]; yr0 = yr[i]; yi0 = yi[i];
/* 270 */       xr[i] = ((xr0 * yr0 + xi0 * yi0) / (yr0 * yr0 + yi0 * yi0 + 1.0E-008D));
/* 271 */       xi[i] = ((-xr0 * yi0 + xi0 * yr0) / (yr0 * yr0 + yi0 * yi0 + 1.0E-008D));
/*     */     }
/* 273 */     fft2r2(nfil, ncol, -1, xr, xi);
/*     */   }
/*     */ 
/*     */   public static void convolucio(int nfil, int ncol, double[] xr, double[] xi, double[] yr, double[] yi)
/*     */   {
/* 278 */     fft2r2(nfil, ncol, 1, xr, xi);
/* 279 */     fft2r2(nfil, ncol, 1, yr, yi);
/* 280 */     double xr0 = 0.0D; double yr0 = 0.0D; double xi0 = 0.0D; double yi0 = 0.0D;
/* 281 */     for (int i = 0; i < nfil * ncol; i++) {
/* 282 */       xr0 = xr[i]; xi0 = xi[i]; yr0 = yr[i]; yi0 = yi[i];
/* 283 */       xr[i] = (xr0 * yr0 - xi0 * yi0);
/* 284 */       xi[i] = (xr0 * yi0 + xi0 * yr0);
/*     */     }
/* 286 */     fft2r2(nfil, ncol, -1, xr, xi);
/*     */   }
/*     */ 
/*     */   public static void HologramaFresnel(double z, double lambda, double[] ampli, double[] partReal, double[] partImag, double L, double N, double LR, double NR)
/*     */   {
/* 331 */     double x = 0.0D; double y = 0.0D; double x0 = 0.0D; double y0 = 0.0D; double argument = 0.0D;
/*     */ 
/* 342 */     Frame info = new Frame("Progres càlcul holograma");
/* 343 */     TextArea area = new TextArea("Progres: ", 380, 100, 0);
/* 344 */     info.setSize(400, 120);
/*     */ 
/* 347 */     area.setFont(new Font("Dialog", 1, 12));
/* 348 */     area.setEditable(false);
/* 349 */     info.add(area);
/* 350 */     info.show();
/*     */ 
/* 354 */     for (int k = 0; k < NR; k++)
/*     */     {
/* 356 */       int tpc = (int)(100.0D * k / NR);
/* 357 */       area.replaceRange("Progres: " + tpc + " %. Processant fila " + k + "/" + (int)NR + "    \n", 0, 100);
/*     */ 
/* 359 */       y0 = (k - 0.5D * NR) * LR / NR;
/*     */ 
/* 361 */       for (int l = 0; l < NR; l++)
/*     */       {
/* 363 */         if (ampli[(k * (int)NR + l)] != 0.0D) {
/* 364 */           x0 = (l - 0.5D * NR) * LR / NR;
/*     */ 
/* 366 */           for (int i = 0; i < N; i++)
/*     */           {
/* 368 */             y = (i - 0.5D * N) * L / N;
/*     */ 
/* 370 */             for (int j = 0; j < N; j++)
/*     */             {
/* 372 */               x = (j - 0.5D * N) * L / N;
/*     */ 
/* 374 */               argument = 6.283185307179586D * z / lambda + 3.141592653589793D * ((x - x0) * (x - x0) + (y - y0) * (y - y0)) / (lambda * z);
/* 375 */               partReal[(i * (int)N + j)] += ampli[(k * (int)NR + l)] / z * Math.cos(argument);
/* 376 */               partImag[(i * (int)N + j)] += ampli[(k * (int)NR + l)] / z * Math.sin(argument);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 383 */     info.hide();
/*     */   }
/*     */ 
/*     */   public static void CorbaFase(double[] partReal, double[] partImag, int[] mapa, int nfil, int ncol)
/*     */   {
/* 390 */     for (int i = 0; i < nfil * ncol; i++)
/*     */     {
/* 392 */       mapa[i] = (int)(254.0D * (Math.atan2(partImag[i], partReal[i]) + 3.141592653589793D) / 6.283185307179586D);
/* 393 */       mapa[i] = (0xFF000000 | mapa[i] << 16 | mapa[i] << 8 | mapa[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void Fresnel(int nfil, int ncol, double maxi, double mini, double[] partReal, double[] partImag, double[] intensitat, int[] mapa, int[] mapaPlot, double z, double lambda, double costat)
/*     */   {
/* 400 */     double pr = 0.0D; double pi = 0.0D; double u = 0.0D; double v = 0.0D;
/*     */ 
/* 402 */     fft2r2(nfil, ncol, 1, partReal, partImag);
/*     */ 
/* 404 */     for (int i = 0; i < nfil; i++) {
/* 405 */       for (int j = 0; j < ncol; j++)
/*     */       {
/* 409 */         u = (i - nfil / 2.0D) / costat;
/* 410 */         v = (j - ncol / 2.0D) / costat;
/*     */ 
/* 413 */         pr = partReal[(i * nfil + j)]; pi = partImag[(i * nfil + j)];
/*     */ 
/* 415 */         partReal[(i * nfil + j)] = (pr * Math.cos(3.141592653589793D * lambda * z * (u * u + v * v)) + pi * Math.sin(3.141592653589793D * lambda * z * (u * u + v * v)));
/* 416 */         partImag[(i * nfil + j)] = (pi * Math.cos(3.141592653589793D * lambda * z * (u * u + v * v)) - pr * Math.sin(3.141592653589793D * lambda * z * (u * u + v * v)));
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 424 */     fft2r2(nfil, ncol, -1, partReal, partImag);
/*     */ 
/* 426 */     normaliza(nfil, ncol, maxi, mini, partReal, partImag, mapa, mapaPlot);
/*     */ 
/* 428 */     for (int i = 0; i < nfil * ncol; i++)
/* 429 */       intensitat[i] = (partReal[i] * partReal[i] + partImag[i] * partImag[i]);
/*     */   }
/*     */ 
/*     */   public static void normaliza(int nfil, int ncol, double maxi, double mini, double[] partReal, double[] partImag, int[] mapa, int[] mapaPlot)
/*     */   {
/* 435 */     double amplitud = 0.0D;
/*     */ 
/* 437 */     for (int i = 0; i < nfil * ncol; i++) {
/* 438 */       amplitud = partReal[i] * partReal[i] + partImag[i] * partImag[i];
/* 439 */       if (maxi < amplitud) maxi = amplitud;
/* 440 */       if (mini <= amplitud) continue; mini = amplitud;
/*     */     }
/*     */ 
/* 444 */     for (int i = 0; i < nfil * ncol; i++)
/*     */     {
/*     */       int tmp122_121 = (int)(254.0D * (partReal[i] * partReal[i] + partImag[i] * partImag[i] - mini) / (maxi - mini)); mapa[i] = tmp122_121; mapaPlot[i] = tmp122_121;
/* 446 */       mapa[i] = (0xFF000000 | mapa[i] << 16 | mapa[i] << 8 | mapa[i]);
/*     */     }
/*     */   }
/*     */ }