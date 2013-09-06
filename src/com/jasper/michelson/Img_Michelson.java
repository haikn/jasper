/*    */ package com.jasper.michelson;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import java.awt.Container;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.RenderingHints;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class Img_Michelson extends JPanel
/*    */ {
/* 18 */   BorderLayout borderLayout1 = new BorderLayout();
/* 19 */   double focal = 50.0D;
/* 20 */   double lambda = 633.0D;
/* 21 */   double n = 1.0D;
/* 22 */   double d = 0.0D;
/* 23 */   double angle = 0.0D;
/* 24 */   double d1 = 10.0D;
/*    */   double d2;
/*    */   boolean twyman;
/*    */ 
/*    */   public Img_Michelson()
/*    */   {
/*    */     try
/*    */     {
/* 30 */       jbInit();
/*    */     }
/*    */     catch (Exception ex) {
/* 33 */       ex.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   void jbInit() throws Exception {
/* 37 */     setLayout(this.borderLayout1);
/* 38 */     setBackground(Color.black);
/* 39 */     setMinimumSize(new Dimension(2300, 230));
/* 40 */     setPreferredSize(new Dimension(230, 230));
/*    */   }
/*    */ 
/*    */   public void putAtributos(double l, double dist, double nref) {
/* 44 */     this.lambda = l;
/* 45 */     this.n = nref;
/* 46 */     this.d = dist;
/*    */ 
/* 48 */     this.d2 = (this.d1 + this.d);
/* 49 */     this.twyman = Interferometros.tipoFuente;
/*    */   }
/*    */ 
/*    */   public void paint(Graphics g) {
/* 53 */     Graphics2D g2 = (Graphics2D)g;
/*    */ 
/* 55 */     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/* 56 */     Dimension dim = getSize();
/* 57 */     int dim_x = dim.width;
/* 58 */     int dim_y = dim.height;
/*    */ 
/* 60 */     YoungColor ycolor = new YoungColor();
/*    */ 
/* 62 */     Color color_r = ycolor.lambda2RGB((int)this.lambda);
/* 63 */     double r_max_d = Math.sqrt(Math.pow(dim_x / 2, 2.0D) + Math.pow(dim_y / 2, 2.0D));
/* 64 */     int r_max = (int)r_max_d;
/* 65 */     double[] brillo = new double[r_max];
/* 66 */     double cos = 0.0D;
/* 67 */     double x = 0.0D;
/* 68 */     double y = 0.0D;
/* 69 */     double pix = Interferometros.finestra / r_max_d;
/* 70 */     if ((dim_x > 0) && (dim_y > 0))
/* 71 */       if (this.twyman != true) {
/* 72 */         for (int i = 0; i < r_max; i++) {
/* 73 */           cos = Math.cos(6.283185307179586D * this.n * this.d * Math.cos(Math.atan2(pix * i, this.focal)) / (this.lambda * 1.0E-006D));
/* 74 */           brillo[i] = (cos * cos);
/*    */         }
/*    */ 
/* 77 */         double brillo_max = brillo[0];
/* 78 */         double brillo_min = brillo[0];
/* 79 */         for (int i = 0; i < r_max; i++) {
/* 80 */           if (brillo[i] > brillo_max) brillo_max = brillo[i];
/* 81 */           if (brillo[i] >= brillo_min) continue; brillo_min = brillo[i];
/*    */         }
/*    */ 
/* 85 */         float[] hsb = new float[3];
/* 86 */         hsb = Color.RGBtoHSB(color_r.getRed(), color_r.getGreen(), color_r.getBlue(), hsb);
/* 87 */         Color clin = new Color(0, 0, 0);
/*    */ 
/* 89 */         for (int j = 0; j < r_max; j++) {
/* 90 */           int i = r_max - j - 1;
/* 91 */           if (brillo_max - brillo_min < 1.E-005D) brillo[i] = 1.0D;
/*    */           else {
/* 93 */             brillo[i] = ((brillo[i] - brillo_min) / (brillo_max - brillo_min));
/*    */           }
/* 95 */           hsb[2] = (float)brillo[i];
/*    */ 
/* 99 */           x = dim_x / 2 - i;
/* 100 */           y = dim_y / 2 - i;
/*    */ 
/* 103 */           clin = new Color(Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]));
/* 104 */           g2.setPaint(clin);
/* 105 */           g2.fillOval((int)x, (int)y, 2 * i, 2 * i);
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/* 110 */         cos = Math.cos(6.283185307179586D * this.n * this.d / (this.lambda * 1.0E-006D));
/* 111 */         cos *= cos;
/*    */ 
/* 113 */         float[] hsb = new float[3];
/* 114 */         hsb = Color.RGBtoHSB(color_r.getRed(), color_r.getGreen(), color_r.getBlue(), hsb);
/* 115 */         Color clin = new Color(0, 0, 0);
/* 116 */         hsb[2] = (float)cos;
/* 117 */         clin = new Color(Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]));
/* 118 */         g2.setPaint(clin);
/* 119 */         g2.fillRect(0, 0, dim_x, dim_y);
/*    */       }
/*    */   }
/*    */ }