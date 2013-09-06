/*     */ package com.jasper.michelson;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
/*     */ import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class Esq_Conceptual extends JPanel
/*     */ {
/*  17 */   BorderLayout borderLayout1 = new BorderLayout();
/*  18 */   int lambda = 633;
/*  19 */   double distancia = 0.0D;
/*     */   double indice_n;
/*     */   boolean twyman;
/*  23 */   double delta = 0.05D;
/*  24 */   double deltad = 25.0D;
/*  25 */   double angle = 0.0D;
/*  26 */   YoungColor l2rgb = new YoungColor();
/*     */ 
/*     */   public Esq_Conceptual() {
/*     */     try {
/*  30 */       jbInit();
/*     */     }
/*     */     catch (Exception ex) {
/*  33 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   void jbInit() throws Exception {
/*  37 */     setLayout(this.borderLayout1);
/*  38 */     setBackground(Color.darkGray);
/*  39 */     setMinimumSize(new Dimension(350, 350));
/*  40 */     setPreferredSize(new Dimension(350, 350));
/*     */   }
/*     */ 
/*     */   void putAtributos(int l, double d, double n) {
/*  44 */     this.lambda = l;
/*  45 */     this.distancia = d;
/*  46 */     this.indice_n = n;
/*     */ 
/*  48 */     this.twyman = Interferometros.tipoFuente;
/*     */   }
/*     */ 
/*     */   public void paint(Graphics g) {
/*  52 */     Graphics2D g2 = (Graphics2D)g;
/*  53 */     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*  54 */     Dimension dim = getSize();
/*  55 */     int dim_x = dim.width;
/*  56 */     int dim_y = dim.height;
/*  57 */     int[] puntos_x = { dim_x / 2 - 30 + 21 - 2, dim_x / 2 - 30 + 21 + 2, dim_x / 2 - 30 - 21 + 2, dim_x / 2 - 30 - 21 - 2 };
/*  58 */     int[] puntos2_x = { puntos_x[1], puntos_x[1] + 2, puntos_x[2] + 2, puntos_x[2] };
/*  59 */     int[] puntos_y = { dim_y / 2 - 21 - 2, dim_y / 2 - 21 + 2, dim_y / 2 + 21 + 2, dim_y / 2 + 21 - 2 };
/*  60 */     int[] puntos2_y = { puntos_y[1], puntos_y[1] + 2, puntos_y[2] + 2, puntos_y[2] };
/*     */ 
/*  66 */     double theta = 60.0D;
/*  67 */     if (this.twyman == true) theta = 0.0D;
/*  68 */     double rayo = 75.0D;
/*  69 */     double punto_a_x = dim_x / 2 + 5.0D;
/*  70 */     double punto_a_y = dim_y / 2 - 80.0D;
/*  71 */     double punto_b_x = punto_a_x;
/*  72 */     double punto_b_y = punto_a_y + this.distancia * this.deltad;
/*  73 */     double punto_c_x = punto_a_x - this.distancia * this.deltad * Math.cos(theta) * Math.sin(theta);
/*  74 */     double punto_c_y = punto_a_y + this.distancia * this.deltad * Math.cos(theta) * Math.cos(theta);
/*  75 */     double punto_d_x = punto_a_x - this.distancia * this.deltad * Math.tan(theta);
/*  76 */     double punto_d_y = punto_b_y;
/*  77 */     double punto_e_x = punto_d_x - rayo * Math.tan(theta);
/*  78 */     double punto_e_y = punto_c_y + rayo;
/*  79 */     double punto_f_x = punto_a_x - rayo * Math.tan(theta);
/*  80 */     double punto_f_y = punto_b_y + rayo;
/*  81 */     double punto_g_x = punto_a_x;
/*  82 */     double punto_g_y = punto_b_y + rayo;
/*  83 */     double punto_h_y = punto_a_y + this.distancia * this.deltad / 2.0D;
/*  84 */     double punto_i_x = punto_a_x - Math.tan(theta) * (this.distancia * this.deltad) / 2.0D - 15.0D;
/*  85 */     double punto_i_y = punto_a_y + this.distancia * this.deltad / 2.0D;
/*  86 */     int[] vertice1_x = { (int)punto_e_x, (int)punto_e_x - 4, (int)punto_e_x + 10 };
/*  87 */     int[] vertice1_y = { (int)punto_e_y + 1, (int)punto_e_y - 10, (int)punto_e_y - 3 };
/*  88 */     int[] vertice2_x = { (int)punto_f_x, (int)punto_f_x - 4, (int)punto_f_x + 10 };
/*  89 */     int[] vertice2_y = { (int)punto_f_y + 1, (int)punto_f_y - 10, (int)punto_f_y - 3 };
/*  90 */     int[] vertice3_x = { (int)punto_i_x, (int)punto_i_x + 5, (int)punto_i_x - 5 };
/*  91 */     int[] vertice3_y = { (int)punto_i_y, (int)punto_i_y + 10, (int)punto_i_y + 10 };
/*  92 */     int[] vertice4_x = { (int)punto_e_x, (int)punto_e_x - 7, (int)punto_e_x + 8 };
/*  93 */     int[] vertice4_y = { (int)punto_e_y + 1, (int)punto_e_y - 7, (int)punto_e_y - 7 };
/*  94 */     int[] vertice5_x = { dim_x / 2 - 45, dim_x / 2 - 50, dim_x / 2 - 40 };
/*  95 */     int[] vertice5_y = { 23, 33, 33 };
/*     */ 
/*  97 */     g2.setColor(new Color(191, 237, 245));
/*  98 */     g2.fill(new Rectangle2D.Double(punto_a_x - 80.0D, punto_a_y, 150.0D, 10.0D));
/*  99 */     g2.fill(new Rectangle2D.Double(punto_b_x - 80.0D, punto_b_y, 150.0D, 10.0D));
/*     */ 
/* 102 */     BasicStroke bs = new BasicStroke(2.0F);
/* 103 */     BasicStroke bs2 = new BasicStroke(4.0F);
/* 104 */     g2.setStroke(bs);
/*     */ 
/* 106 */     g2.setColor(Color.lightGray);
/* 107 */     g2.draw(new Line2D.Double(punto_a_x, punto_a_y, punto_b_x, punto_b_y));
/* 108 */     g2.draw(new Line2D.Double(punto_c_x, punto_c_y, punto_b_x, punto_b_y));
/* 109 */     g2.draw(new Line2D.Double(punto_b_x, punto_b_y, punto_g_x, punto_g_y));
/* 110 */     g2.draw(new Line2D.Double(punto_a_x - 90.0D, punto_a_y + 5.0D, punto_b_x - 90.0D, punto_b_y + 5.0D));
/* 111 */     g2.draw(new Line2D.Double(punto_a_x - 93.0D, punto_a_y + 5.0D, punto_a_x - 87.0D, punto_a_y + 5.0D));
/* 112 */     g2.draw(new Line2D.Double(punto_b_x - 93.0D, punto_b_y + 5.0D, punto_b_x - 87.0D, punto_b_y + 5.0D));
/* 113 */     g2.setFont(new Font("Dialog", 1, 16));
/* 114 */     g2.drawString("2d", (int)punto_a_x - 115, (int)punto_h_y + 5);
/* 115 */     g2.drawString(" = 2nd cos", dim_x / 2 - 35, 35);
/* 116 */     g2.drawPolygon(vertice5_x, vertice5_y, 3);
/* 117 */     g2.draw(new Ellipse2D.Double(dim_x / 2 + 54, 25.0D, 6.0D, 10.0D));
/* 118 */     g2.draw(new Line2D.Double(dim_x / 2 + 55, 30.0D, dim_x / 2 + 59, 30.0D));
/* 119 */     if (!this.twyman) {
/* 120 */       g2.draw(new Ellipse2D.Double(punto_a_x - 13.0D, punto_b_y + rayo * 3.0D / 4.0D, 6.0D, 10.0D));
/* 121 */       g2.draw(new Line2D.Double(punto_a_x - 12.0D, punto_b_y + rayo * 3.0D / 4.0D + 5.0D, punto_a_x - 8.0D, punto_b_y + rayo * 3.0D / 4.0D + 5.0D));
/*     */     }
/* 123 */     if (this.distancia > 1.0D) g2.drawPolygon(vertice3_x, vertice3_y, 3);
/* 124 */     g2.setColor(this.l2rgb.lambda2RGB(this.lambda));
/* 125 */     g2.draw(new Line2D.Double(punto_c_x, punto_c_y, punto_e_x, punto_e_y));
/* 126 */     g2.draw(new Line2D.Double(punto_b_x, punto_b_y, punto_f_x, punto_f_y));
/* 127 */     g2.setStroke(bs2);
/* 128 */     g2.draw(new Line2D.Double(punto_a_x, punto_a_y, punto_c_x, punto_c_y));
/* 129 */     if (!this.twyman) {
/* 130 */       g2.fillPolygon(vertice1_x, vertice1_y, 3);
/* 131 */       g2.fillPolygon(vertice2_x, vertice2_y, 3);
/*     */     } else {
/* 133 */       g2.fillPolygon(vertice4_x, vertice4_y, 3);
/* 134 */       g2.fillPolygon(vertice4_x, vertice4_y, 3);
/*     */     }
/*     */   }
/*     */ }