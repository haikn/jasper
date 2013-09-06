/*     */ package com.jasper.michelson;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Polygon;
/*     */ import java.awt.RenderingHints;
import java.awt.geom.Line2D;
/*     */ import java.awt.geom.Line2D.Double;
import java.awt.geom.Rectangle2D;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class Esq_Michelson extends JPanel
/*     */ {
/*  17 */   BorderLayout borderLayout1 = new BorderLayout();
/*     */ 
/*  19 */   int lambda = 633;
/*  20 */   double distancia = 0.0D;
/*     */   double indice_n;
/*  22 */   double delta = 0.05D;
/*  23 */   double deltad = 5.0D;
/*  24 */   double angle = 0.0D;
/*  25 */   YoungColor l2rgb = new YoungColor();
/*     */ 
/*     */   public Esq_Michelson()
/*     */   {
/*     */     try
/*     */     {
/*  31 */       jbInit();
/*     */     }
/*     */     catch (Exception ex) {
/*  34 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   void jbInit() throws Exception {
/*  38 */     setBackground(Color.darkGray);
/*  39 */     setLayout(this.borderLayout1);
/*  40 */     setMinimumSize(new Dimension(350, 350));
/*  41 */     setPreferredSize(new Dimension(350, 350));
/*     */   }
/*     */ 
/*     */   void putAtributos(int l, double d, double n) {
/*  45 */     this.lambda = l;
/*  46 */     this.distancia = d;
/*     */   }
/*     */ 
/*     */   public void paint(Graphics g)
/*     */   {
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
/*  62 */     g2.setColor(Color.lightGray);
/*  63 */     g2.fill(new Rectangle2D.Double(5.0D, dim_y / 2 - 10.0D, 20.0D, 20.0D));
/*  64 */     g2.setColor(this.l2rgb.lambda2RGB(this.lambda));
/*  65 */     g2.fill(new Rectangle2D.Double(25.0D, dim_y / 2 - 10.0D, 5.0D, 20.0D));
/*     */ 
/*  67 */     g2.setColor(new Color(191, 237, 245));
/*  68 */     g2.fillOval(60, dim_y / 2 - 30, 5, 60);
/*     */ 
/*  70 */     g2.fill(new Rectangle2D.Double(dim_x / 2 - 60.0D, 10.0D, 60.0D, 5.0D));
/*  71 */     g2.setColor(new Color(52, 0, 164));
/*  72 */     g2.fill(new Rectangle2D.Double(dim_x / 2 - 60.0D, 5.0D, 60.0D, 5.0D));
/*     */ 
/*  74 */     double mov = this.distancia * this.deltad;
/*  75 */     g2.setColor(new Color(191, 237, 245));
/*     */ 
/*  78 */     int vertice_x = dim_x - 65 + (int)mov;
/*  79 */     int vertice_y = dim_y / 2 - 30 + 8;
/*  80 */     BasicStroke bs = new BasicStroke(5.0F);
/*  81 */     g2.setStroke(bs);
/*  82 */     g2.draw(new Line2D.Double(vertice_x, vertice_y, vertice_x + 60.0D * Math.sin(this.angle), vertice_y + 60.0D * Math.cos(this.angle)));
/*  83 */     g2.setColor(new Color(52, 0, 164));
/*  84 */     g2.draw(new Line2D.Double(vertice_x + 5, vertice_y, vertice_x + 60.0D * Math.sin(this.angle) + 5.0D, vertice_y + 60.0D * Math.cos(this.angle)));
/*  85 */     g2.setColor(new Color(191, 237, 245));
/*  86 */     BasicStroke bs2 = new BasicStroke();
/*  87 */     g2.setStroke(bs2);
/*     */ 
/*  90 */     g2.fill(new Polygon(puntos_x, puntos_y, 4));
/*  91 */     g2.setColor(new Color(0, 82, 194));
/*  92 */     g2.fill(new Polygon(puntos2_x, puntos2_y, 4));
/*     */ 
/*  94 */     for (int i = 0; i < 4; i++) {
/*  95 */       puntos_x[i] += dim_x / 4 - 15;
/*  96 */       puntos2_x[i] += dim_x / 4 - 15;
/*     */     }
/*  98 */     g2.setColor(new Color(191, 237, 245));
/*  99 */     g2.fill(new Polygon(puntos_x, puntos_y, 4));
/*     */ 
/* 101 */     g2.fillOval(dim_x / 2 - 60 + 5, dim_y - 40, 60, 5);
/*     */ 
/* 103 */     g2.setColor(Color.white);
/* 104 */     g2.drawLine(dim_x / 2 - 60 + 5, dim_y - 10, dim_x / 2 + 5, dim_y - 10);
/*     */ 
/* 106 */     g2.setColor(this.l2rgb.lambda2RGB(this.lambda));
/* 107 */     g2.drawLine(30, dim_y / 2, dim_x / 2 - 30 - 5, dim_y / 2);
/* 108 */     g2.drawLine(dim_x / 2 - 30 - 5, dim_y / 2, dim_x / 2 - 30 + 5, dim_y / 2 + 5);
/* 109 */     g2.drawLine(dim_x / 2 - 30, dim_y / 2 - 5, dim_x / 2 - 30 + 5, dim_y / 2 + 5);
/* 110 */     g2.drawLine(dim_x / 2 - 30, 15, dim_x / 2 - 30, dim_y / 2 - 5);
/* 111 */     g2.drawLine(dim_x / 2 - 30 + 5, dim_y / 2 + 5, dim_x / 2 + 5 + 27, dim_y / 2 + 5);
/* 112 */     g2.drawLine(dim_x / 2 + 5 + 27, dim_y / 2 + 5, dim_x / 2 + 5 + 32, dim_y / 2 + 8);
/* 113 */     g2.draw(new Line2D.Double(dim_x / 2 + 5 + 32, dim_y / 2 + 8, dim_x - 68 + mov + 30.0D * Math.sin(this.angle), dim_y / 2 + 8));
/* 114 */     g2.drawLine(dim_x / 2 - 30 + 5, dim_y / 2 + 5, dim_x / 2 - 30 + 5, dim_y - 11);
/*     */ 
/* 117 */     int x = dim_x / 4 - 15 + (int)(this.lambda * this.delta);
/* 118 */     int[] vertices_x = { x, x - 8, x - 8 };
/* 119 */     int[] vertices_y = { dim_y / 2, dim_y / 2 - 8, dim_y / 2 + 8 };
/* 120 */     g2.fill(new Polygon(vertices_x, vertices_y, 3));
/* 121 */     for (int i = 0; i < vertices_x.length; i++) {
/* 122 */       vertices_x[i] += dim_x / 2 - 90;
/* 123 */       vertices_y[i] += 5;
/*     */     }
/* 125 */     g2.fill(new Polygon(vertices_x, vertices_y, 3));
/* 126 */     for (int i = 0; i < vertices_x.length; i++)
/*     */     {
/* 128 */       vertices_y[i] += 3;
/*     */     }
/*     */ 
/* 132 */     x = dim_x - 70 - (int)(this.lambda * this.delta) + (int)mov;
/* 133 */     int[] vertices2_x = { x, x + 8, x + 8 };
/* 134 */     g2.fill(new Polygon(vertices2_x, vertices_y, 3));
/*     */ 
/* 137 */     int y = dim_y / 4 - 40 + (int)(this.lambda * this.delta);
/* 138 */     int[] verticesv_x = { dim_x / 2 - 30, dim_x / 2 - 30 - 8, dim_x / 2 - 30 + 8 };
/* 139 */     int[] verticesv_y = { y, y - 8, y - 8 };
/* 140 */     g2.fill(new Polygon(verticesv_x, verticesv_y, 3));
/* 141 */     for (int i = 0; i < verticesv_x.length; i++) {
/* 142 */       verticesv_x[i] += 5;
/* 143 */       verticesv_y[i] += dim_x / 2 - 5;
/*     */     }
/* 145 */     g2.fill(new Polygon(verticesv_x, verticesv_y, 3));
/* 146 */     for (int i = 0; i < verticesv_x.length; i++) {
/* 147 */       verticesv_y[i] -= 15 + (int)mov;
/*     */     }
/* 149 */     g2.fill(new Polygon(verticesv_x, verticesv_y, 3));
/*     */ 
/* 151 */     y = dim_y / 2 - 10 - (int)(this.lambda * this.delta);
/* 152 */     int[] verticesv2_y = { y, y + 8, y + 8 };
/* 153 */     for (int i = 0; i < verticesv_x.length; i++) verticesv_x[i] -= 5;
/* 154 */     g2.fill(new Polygon(verticesv_x, verticesv2_y, 3));
/*     */   }
/*     */ }