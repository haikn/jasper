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
/*    */ import java.text.DecimalFormat;
/*    */ import java.text.DecimalFormatSymbols;
/*    */ import java.text.NumberFormat;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class Graf_Michelson extends JPanel
/*    */ {
/* 18 */   BorderLayout borderLayout1 = new BorderLayout();
/*    */   int lambda;
/*    */   double d;
/*    */   double n;
/* 23 */   double focal = 50.0D;
/* 24 */   double angle = 0.0D;
/* 25 */   double d1 = 10.0D;
/*    */   double d2;
/*    */   boolean twyman;
/*    */ 
/*    */   public Graf_Michelson()
/*    */   {
/*    */     try
/*    */     {
/* 31 */       jbInit();
/*    */     }
/*    */     catch (Exception ex) {
/* 34 */       ex.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   void jbInit() throws Exception {
/* 38 */     setLayout(this.borderLayout1);
/* 39 */     setBackground(Color.black);
/* 40 */     setMinimumSize(new Dimension(230, 230));
/* 41 */     setPreferredSize(new Dimension(230, 230));
/*    */   }
/*    */ 
/*    */   public void putAtributos(int l, double dist, double n_ref) {
/* 45 */     this.lambda = l;
/* 46 */     this.d = dist;
/* 47 */     this.n = n_ref;
/*    */ 
/* 49 */     this.d2 = (this.d1 + this.d);
/* 50 */     this.twyman = Interferometros.tipoFuente;
/*    */   }
/*    */ 
/*    */   public void paint(Graphics g) {
/* 54 */     Graphics2D g2 = (Graphics2D)g;
/* 55 */     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/* 56 */     Dimension dim = getSize();
/* 57 */     int dim_x = dim.width;
/* 58 */     int dim_y = dim.height;
/*    */ 
/* 60 */     double pix = Interferometros.finestra / dim_x * Math.sqrt(2.0D);
/* 61 */     YoungColor ycolores = new YoungColor();
/* 62 */     Color color = ycolores.lambda2RGB(this.lambda);
/* 63 */     double[] valor_graf = new double[dim_x];
/* 64 */     g2.setColor(Color.white);
/* 65 */     g2.drawLine(0, dim_y - 6, dim_x, dim_y - 6);
/* 66 */     g2.drawLine(dim_x / 2, 0, dim_x / 2, dim_y - 6);
/* 67 */     g2.drawString("max = 1", dim_x / 2 + 6, 10);
/* 68 */     g2.drawLine(dim_x / 2 - 6, 10, dim_x / 2 + 6, 10);
/* 69 */     g2.setPaint(color);
/* 70 */     if ((dim_x > 0) && (dim_y > 0))
/* 71 */       if (this.twyman != true) {
/* 72 */         for (int i = 0; i < dim_x; i++) {
/* 73 */           double cos = Math.cos(6.283185307179586D * this.n * this.d * Math.cos(Math.atan2(pix * (i - dim_x / 2), this.focal)) / (this.lambda * 1.0E-006D));
/* 74 */           valor_graf[i] = (cos * cos);
/*    */         }
/* 76 */         double valor_max = valor_graf[0];
/* 77 */         double valor_min = valor_graf[0];
/* 78 */         for (int i = 0; i < dim_x; i++) {
/* 79 */           if (valor_graf[i] > valor_max) valor_max = valor_graf[i];
/* 80 */           if (valor_graf[i] >= valor_min) continue; valor_min = valor_graf[i];
/*    */         }
/*    */ 
/* 83 */         for (int i = 0; i < dim_x; i++) {
/* 84 */           if (valor_max - valor_min < 0.0001D) valor_graf[i] = (dim_y - 7 - 10); else
/* 85 */             valor_graf[i] = ((valor_graf[i] - valor_min) / (valor_max - valor_min) * (dim_y - 7 - 10));
/*    */         }
/* 87 */         for (int i = 0; i < dim_x - 1; i++)
/* 88 */           g2.drawLine(i, dim_y - 7 - (int)valor_graf[i], i + 1, dim_y - 7 - (int)valor_graf[(i + 1)]);
/*    */       }
/*    */       else {
/* 91 */         double cos = Math.cos(6.283185307179586D * this.n * this.d / (this.lambda * 1.0E-006D));
/* 92 */         cos = cos * cos * (dim_y - 7 - 10);
/*    */ 
/* 94 */         for (int i = 0; i < dim_x - 1; i++) {
/* 95 */           g2.drawLine(i, dim_y - 7 - (int)cos, i + 1, dim_y - 7 - (int)cos);
/*    */         }
/* 97 */         g2.setColor(Color.white);
/* 98 */         char pto = '.';
/* 99 */         DecimalFormatSymbols df_symb = new DecimalFormatSymbols();
/* 100 */         df_symb.setDecimalSeparator(pto);
/* 101 */         DecimalFormat df = new DecimalFormat("#.###", df_symb);
/* 102 */         df.setDecimalFormatSymbols(df_symb);
/*    */ 
/* 104 */         g2.drawString(df.format(cos / (dim_y - 7 - 10)), dim_x / 2 + 6, 40);
/*    */       }
/*    */   }
/*    */ }