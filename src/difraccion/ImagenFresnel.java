/*     */ package difraccion;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.image.MemoryImageSource;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class ImagenFresnel extends JPanel
/*     */ {
/*     */   int lambda;
/*     */   int tipo_objeto;
/*     */   double dim_x;
/*     */   double dim_y;
/*     */   int label_tipoimg;
/*     */   double umbral;
/*  29 */   int dim_Lx = 256;
/*  30 */   int dim_Ly = 256;
/*  31 */   int dim_Total = this.dim_Lx * this.dim_Ly;
/*  32 */   int[] pixels = new int[this.dim_Lx * this.dim_Ly];
/*     */   MemoryImageSource source;
/*     */   Image img;
/*     */ 
/*     */   public ImagenFresnel()
/*     */   {
/*     */     try
/*     */     {
/*  38 */       jbInit();
/*     */     }
/*     */     catch (Exception e) {
/*  41 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jbInit() throws Exception {
/*  45 */     setBackground(Color.black);
/*  46 */     setMinimumSize(new Dimension(256, 256));
/*  47 */     setPreferredSize(new Dimension(256, 256));
/*     */ 
/*  49 */     int dim_Total = this.dim_Lx * this.dim_Ly;
/*  50 */     this.pixels = new int[dim_Total];
/*     */ 
/*  52 */     int value = getBackground().getRGB();
/*  53 */     for (int i = 0; i < dim_Total; i++) {
/*  54 */       this.pixels[i] = value;
/*     */     }
/*     */ 
/*  57 */     this.source = new MemoryImageSource(this.dim_Lx, this.dim_Ly, this.pixels, 0, this.dim_Lx);
/*  58 */     this.source.setAnimated(true);
/*  59 */     this.img = createImage(this.source);
/*     */   }
/*     */ 
/*     */   public void putAtributos(double tam_x, double tam_y, double[] matriz, int l_onda, int tipoimg, double fres_umbral)
/*     */   {
/*  65 */     this.lambda = l_onda;
/*  66 */     this.dim_x = tam_x;
/*  67 */     this.dim_y = tam_y;
/*  68 */     this.label_tipoimg = tipoimg;
/*  69 */     this.umbral = fres_umbral;
/*     */ 
/*  71 */     double[] brillo = new double[this.dim_Total];
/*  72 */     YoungColor ycolores = new YoungColor();
/*  73 */     Color ncolor = ycolores.lambda2RGB(this.lambda);
/*  74 */     float[] hsb = new float[3];
/*  75 */     hsb = Color.RGBtoHSB(ncolor.getRed(), ncolor.getGreen(), ncolor.getBlue(), hsb);
/*     */ 
/*  79 */     for (int i = 0; i < this.dim_Total; i++) {
/*  80 */       brillo[i] = matriz[i];
/*     */     }
/*     */ 
/*  83 */     if (this.label_tipoimg == 1) {
/*  84 */       for (int i = 0; i < this.dim_Total; i++) {
/*  85 */         brillo[i] *= brillo[i];
/*     */       }
/*     */     }
/*     */ 
/*  89 */     if (this.label_tipoimg == 2) {
/*  90 */       for (int i = 0; i < this.dim_Total; i++) {
/*  91 */         brillo[i] *= brillo[i];
/*  92 */         brillo[i] = Math.log(brillo[i]);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  97 */     double max_brillo = brillo[0];
/*  98 */     double min_brillo = brillo[0];
/*  99 */     for (int i = 0; i < this.dim_Total; i++) {
/* 100 */       if (max_brillo < brillo[i]) max_brillo = brillo[i];
/* 101 */       if (min_brillo <= brillo[i]) continue; min_brillo = brillo[i];
/*     */     }
/*     */ 
/* 104 */     for (int i = 0; i < this.dim_Total; i++) {
/* 105 */       if (this.label_tipoimg != 2) {
/* 106 */         if (brillo[i] > max_brillo * this.umbral) {
/* 107 */           brillo[i] = 1.0D;
/*     */         }
/*     */         else {
/* 110 */           brillo[i] = ((brillo[i] - min_brillo) / (max_brillo * this.umbral - min_brillo));
/*     */         }
/*     */       }
/*     */       else {
/* 114 */         brillo[i] = ((brillo[i] - min_brillo) / (max_brillo - min_brillo));
/*     */       }
/*     */ 
/* 117 */       hsb[2] = (float)brillo[i];
/* 118 */       Color clin = new Color(Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]));
/* 119 */       this.pixels[i] = clin.getRGB();
/*     */     }
/*     */ 
/* 122 */     this.img = createImage(new MemoryImageSource(this.dim_Lx, this.dim_Ly, this.pixels, 0, this.dim_Lx));
/*     */   }
/*     */ 
/*     */   public void paint(Graphics g)
/*     */   {
/* 128 */     g.drawImage(this.img, 0, 0, this);
/*     */   }
/*     */ }