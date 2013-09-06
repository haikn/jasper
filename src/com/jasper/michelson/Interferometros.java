/*     */ package com.jasper.michelson;
/*     */ 
/*     */ import java.applet.Applet;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dialog;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.Frame;
/*     */ import java.awt.Insets;
/*     */ import java.awt.Toolkit;
import java.awt.Window;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseMotionAdapter;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.net.URL;
/*     */ import javax.swing.AbstractButton;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.ButtonGroup;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JApplet;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JEditorPane;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JRadioButton;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JSlider;
/*     */ import javax.swing.JSplitPane;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
/*     */ import javax.swing.border.TitledBorder;
/*     */ import javax.swing.text.JTextComponent;
/*     */ 
/*     */ public class Interferometros extends JApplet
/*     */ {
/*  23 */   String[][] etiqueta = { { "Parámetros del sistema", "Paràmetres del sistema", "System parameters" }, { "Longitud de onda ", "Longitud d'ona ", "Wavelength " }, { "Distancia espejos ", "Distància miralls ", "Mirrors distance " }, { "Información parámetros del sistema", "Informació paràmetres sistema", "System parameters information" }, { "Índice de refracción", "Índex de refracció", "Refraction index" }, { "Gráfico", "Gràfic", "Graphic" }, { "Imagen", "Imatge", "Image" }, { "Anchura zona de visión ", "Amplada zona de visió ", "Display area width " }, { "Tipo de fuente", "Tipus de font", "Source type" }, { "(en el vacío) ", "(al buit) ", "(in vacuum) " } };
/*     */ 
/*  33 */   String[] about = { "Acerca de", "En quant a", "About" };
/*  34 */   String[] aceptar = { "Aceptar", "Acceptar", "OK" };
/*  35 */   String[] rollo = { "JDC Education Kit for Optical Experiments", "JDC Education Kit for Optical Experiments", "JDC Education Kit for Optical Experiments" };
/*     */ 
/*  38 */   String[] exit = { "Salir", "Sortir", "Exit" };
/*  39 */   static String[] titol = { "Applet de Interferómetro de Michelson", "Applet d'Interferòmetre de Michelson", "Michelson Interferometer Applet" };
/*  40 */   String[][] radioText = { { "Extensa", "Extensa", "Extended" }, { "Puntual (Twyman)", "Puntual (Twyman)", "Point (Twyman)  " } };
/*  41 */   String[][] esquemaText = { { "Esquema", "Esquema", "Diagram" }, { "Montaje", "Muntatge", "Setup" } };
/*  42 */   String[] titolTabbed = { "Interferómetro de Michelson", "Interferòmetre de Michelson", "Michelson interferometer" };
/*  43 */   String[] focal = { "Focal lente:", "Focal lent:", "Lens focal length:" };
/*  44 */   String[] teoria = { "Resumen teoría", "Resum teoria", "Theory summary" };
/*  45 */   boolean isStandalone = false;
/*     */   static int lang;
/*  47 */   JPanel jPanelBase = new JPanel();
/*  48 */   JPanel jPanelNorte = new JPanel();
/*  49 */   BorderLayout borderLayout1 = new BorderLayout();
/*  50 */   JPanel jPanelCentro = new JPanel();
/*  51 */   JPanel jPanelSur = new JPanel();
/*  52 */   JButton jButtonSalir = new JButton();
/*  53 */   JTabbedPane jTabbedPane1 = new JTabbedPane();
/*  54 */   JPanel jPanelMichelson = new JPanel();
/*  55 */   JPanel jPanelMach = new JPanel();
/*  56 */   BorderLayout borderLayout2 = new BorderLayout();
/*  57 */   BorderLayout borderLayout3 = new BorderLayout();
/*  58 */   BorderLayout borderLayout4 = new BorderLayout();
/*  59 */   JPanel jPanel_m1_w = new JPanel();
/*  60 */   JPanel jPanel_m1_c = new JPanel();
/*     */   TitledBorder titledBorder1;
/*  62 */   JPanel jPanel_m1_w_n = new JPanel();
/*  63 */   BorderLayout borderLayout5 = new BorderLayout();
/*  64 */   BorderLayout borderLayout6 = new BorderLayout();
/*  65 */   JPanel jPanel_m1_w_c = new JPanel();
/*  66 */   JPanel jPanel_m1_w_n_n = new JPanel();
/*  67 */   JPanel jPanel_m1_w_n_w = new JPanel();
/*  68 */   JPanel jPanel_m1_w_n_e = new JPanel();
/*  69 */   JPanel jPanel_m1_w_n_c = new JPanel();
/*  70 */   BorderLayout borderLayout7 = new BorderLayout();
/*  71 */   JPanel jPanel_m1_c_n = new JPanel();
/*  72 */   BorderLayout borderLayout8 = new BorderLayout();
/*  73 */   JPanel jPanel_m1_c_c = new JPanel();
/*  74 */   JPanel jPanel_m1_c_n_n = new JPanel();
/*  75 */   JPanel jPanel_m1_c_n_w = new JPanel();
/*  76 */   JPanel jPanel_m1_c_n_e = new JPanel();
/*  77 */   JPanel jPanel_m1_c_n_c = new JPanel();
/*  78 */   JButton grafic = new JButton();
/*     */ 
/*  81 */   Esq_Michelson esqMichelson = new Esq_Michelson();
/*  82 */   Graf_Michelson grafMichelson = new Graf_Michelson();
/*  83 */   Img_Michelson imgMichelson = new Img_Michelson();
/*  84 */   Esq_Conceptual esqConceptual = new Esq_Conceptual();
/*  85 */   FlowLayout flowLayout2 = new FlowLayout();
/*  86 */   JLabel jLabel1 = new JLabel();
/*  87 */   JLabel jLabel2 = new JLabel();
/*  88 */   static JSlider jSlider_l = new JSlider();
/*  89 */   JLabel jLabel3 = new JLabel();
/*  90 */   JSlider jSlider_d = new JSlider();
/*  91 */   JLabel jLabel4 = new JLabel();
/*  92 */   JLabel jLabel5 = new JLabel();
/*  93 */   FlowLayout flowLayout3 = new FlowLayout();
/*  94 */   JLabel jLabel6 = new JLabel();
/*  95 */   JLabel jLabel7 = new JLabel();
/*  96 */   JSlider jSlider_n = new JSlider();
/*  97 */   JLabel jLabel8 = new JLabel();
/*  98 */   JLabel jLabel9 = new JLabel();
/*  99 */   JPanel jPanel_m1_c_n_s = new JPanel();
/* 100 */   BorderLayout borderLayout9 = new BorderLayout();
/* 101 */   JSplitPane jSplitPane1 = new JSplitPane(1, this.grafMichelson, this.imgMichelson);
/* 102 */   JSplitPane sp_esquema = new JSplitPane(1, this.esqConceptual, this.esqMichelson);
/*     */   int lambda;
/*     */   double n;
/*     */   double d;
/* 106 */   static double finestra = 1.25D;
/* 107 */   JLabel jLabel10 = new JLabel();
/* 108 */   JSlider jSlider_angle = new JSlider();
/* 109 */   JButton jButton1 = new JButton();
/* 110 */   FlowLayout flowLayout1 = new FlowLayout();
/* 111 */   JLabel jLabel11 = new JLabel();
/* 112 */   JRadioButton jRadioButton1 = new JRadioButton();
/* 113 */   JRadioButton jRadioButton2 = new JRadioButton();
/* 114 */   ButtonGroup grupo = new ButtonGroup();
/* 115 */   static boolean tipoFuente = false;
/* 116 */   JButton esquema = new JButton();
/* 117 */   JPanel jPanel1 = new JPanel();
/* 118 */   JLabel jLabel12 = new JLabel();
/* 119 */   JSlider jSliderFocal = new JSlider();
/* 120 */   JPanel jPanel_info = new JPanel();
/* 121 */   JScrollPane jScrollPane1 = new JScrollPane();
/* 122 */   BorderLayout borderLayout10 = new BorderLayout();
/* 123 */   JTextPane jTextPane_info = new JTextPane();
/* 124 */   static ImageIcon icon_joc = null;
/*     */ 
/*     */   public String getParameter(String key, String def) {
/* 127 */     return getParameter(key) != null ? getParameter(key) : this.isStandalone ? System.getProperty(key, def) : def;
/*     */   }
/*     */ 
/*     */   public Interferometros()
/*     */   {
/*     */     try
/*     */     {
/* 135 */       String st_icon = "jdclogo_48x48.png";
/* 136 */       URL url_icon = getClass().getResource(st_icon);
/* 137 */       icon_joc = new ImageIcon(url_icon, "JDC Education Kit for Optical Experiments");
/*     */     } catch (Exception eicon) {
/* 139 */       System.out.println("No carga icono");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void init()
/*     */   {
/* 153 */     carga_info(lang);
/*     */     try {
/* 155 */       jbInit();
/*     */     }
/*     */     catch (Exception e) {
/* 158 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jbInit() throws Exception {
/* 163 */     this.titledBorder1 = new TitledBorder("");
/* 164 */     setSize(new Dimension(750, 550));
/* 165 */     this.jPanelBase.setLayout(this.borderLayout1);
/* 166 */     this.jScrollPane1.setAutoscrolls(true);
/* 167 */     this.jButtonSalir.setMaximumSize(new Dimension(61, 127));
/* 168 */     this.jButtonSalir.setPreferredSize(new Dimension(90, 17));
/* 169 */     this.jButtonSalir.setText(this.exit[lang]);
/* 170 */     this.jButtonSalir.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 172 */         Interferometros.this.jButtonSalir_actionPerformed(e);
/*     */       }
/*     */     });
/* 175 */     this.jPanelSur.setLayout(this.flowLayout1);
/* 176 */     this.jPanelCentro.setLayout(this.borderLayout2);
/* 177 */     this.jPanelMichelson.setLayout(this.borderLayout3);
/* 178 */     this.jPanelMach.setLayout(this.borderLayout4);
/* 179 */     this.jPanel_m1_w.setBorder(BorderFactory.createEtchedBorder());
/* 180 */     this.jPanel_m1_w.setPreferredSize(new Dimension(375, 450));
/* 181 */     this.jPanel_m1_w.setLayout(this.borderLayout5);
/* 182 */     this.jPanel_m1_c.setBorder(BorderFactory.createEtchedBorder());
/* 183 */     this.jPanel_m1_c.setMaximumSize(new Dimension(379, 369));
/* 184 */     this.jPanel_m1_c.setMinimumSize(new Dimension(379, 369));
/* 185 */     this.jPanel_m1_c.setLayout(this.borderLayout7);
/* 186 */     this.jPanel_m1_w_n.setLayout(this.borderLayout6);
/* 187 */     this.jPanel_m1_w_n.setPreferredSize(new Dimension(280, 250));
/* 188 */     this.jPanel_m1_w_n_c.setBackground(Color.darkGray);
/* 189 */     this.jPanel_m1_w_n_c.setMinimumSize(new Dimension(360, 350));
/* 190 */     this.jPanel_m1_c_n.setLayout(this.borderLayout8);
/* 191 */     this.jPanel_m1_c_n.setPreferredSize(new Dimension(375, 280));
/* 192 */     this.jPanel_m1_c_n_c.setBackground(Color.black);
/* 193 */     this.jPanel_m1_c_n_c.setBorder(BorderFactory.createEtchedBorder());
/* 194 */     this.jPanel_m1_c_n_c.setPreferredSize(new Dimension(230, 230));
/* 195 */     this.jPanel_m1_c_n_c.setLayout(this.borderLayout9);
/* 196 */     this.jPanel_m1_w_c.setLayout(this.flowLayout2);
/* 197 */     this.jPanel_m1_w_c.setPreferredSize(new Dimension(1417, 150));
/* 198 */     this.jLabel1.setForeground(new Color(102, 102, 153));
/* 199 */     this.jLabel1.setPreferredSize(new Dimension(375, 17));
/* 200 */     this.jLabel1.setHorizontalAlignment(0);
/* 201 */     this.jLabel1.setText(this.etiqueta[0][lang]);
/* 202 */     this.jLabel2.setPreferredSize(new Dimension(134, 17));
/* 203 */     this.jLabel2.setForeground(new Color(102, 102, 153));
/* 204 */     this.jLabel2.setText(this.etiqueta[1][lang]);
/* 205 */     this.jLabel3.setPreferredSize(new Dimension(134, 17));
/* 206 */     this.jLabel3.setText(this.etiqueta[2][lang]);
/* 207 */     this.jLabel3.setForeground(new Color(102, 102, 153));
/*     */ 
/* 209 */     jSlider_l.setMaximum(700);
/* 210 */     jSlider_l.setMinimum(380);
/* 211 */     jSlider_l.setMinorTickSpacing(20);
/* 212 */     jSlider_l.setPaintTicks(true);
/* 213 */     jSlider_l.setValue(633);
/* 214 */     jSlider_l.addMouseMotionListener(new MouseMotionAdapter() {
/*     */       public void mouseDragged(MouseEvent e) {
/* 216 */         Interferometros.this.jSlider_l_mouseDragged(e);
/*     */       }
/*     */     });
/* 219 */     jSlider_l.addMouseListener(new MouseAdapter() {
/*     */       public void mouseDragged(MouseEvent e) {
/* 221 */         Interferometros.this.jSlider_l_mouseDragged(e);
/*     */       }
/*     */       public void mouseClicked(MouseEvent e) {
/* 224 */         Interferometros.this.jSlider_l_mouseClicked(e);
/*     */       }
/*     */     });
/* 227 */     jSlider_l.addKeyListener(new KeyAdapter() {
/*     */       public void keyPressed(KeyEvent e) {
/* 229 */         Interferometros.this.jSlider_l_keyPressed(e);
/*     */       }
/*     */       public void keyTyped(KeyEvent e) {
/* 232 */         Interferometros.this.jSlider_l_keyTyped(e);
/*     */       }
/*     */     });
/* 235 */     this.jSlider_d.setMaximum(600);
/* 236 */     this.jSlider_d.setMinimum(0);
/* 237 */     this.jSlider_d.setMinorTickSpacing(40);
/* 238 */     this.jSlider_d.setPaintTicks(true);
/* 239 */     this.jSlider_d.setValue(0);
/* 240 */     this.jSlider_d.addMouseMotionListener(new MouseMotionAdapter() {
/*     */       public void mouseDragged(MouseEvent e) {
/* 242 */         Interferometros.this.jSlider_d_mouseDragged(e);
/*     */       }
/*     */     });
/* 245 */     this.jSlider_d.addMouseListener(new MouseAdapter() {
/*     */       public void mouseDragged(MouseEvent e) {
/* 247 */         Interferometros.this.jSlider_d_mouseDragged(e);
/*     */       }
/*     */       public void mouseClicked(MouseEvent e) {
/* 250 */         Interferometros.this.jSlider_d_mouseClicked(e);
/*     */       }
/*     */     });
/* 253 */     this.jSlider_d.addKeyListener(new KeyAdapter() {
/*     */       public void keyPressed(KeyEvent e) {
/* 255 */         Interferometros.this.jSlider_d_keyPressed(e);
/*     */       }
/*     */       public void keyTyped(KeyEvent e) {
/* 258 */         Interferometros.this.jSlider_d_keyTyped(e);
/*     */       }
/*     */     });
/* 261 */     this.jSlider_n.setMajorTickSpacing(25);
/* 262 */     this.jSlider_n.setMaximum(200);
/* 263 */     this.jSlider_n.setMinimum(100);
/* 264 */     this.jSlider_n.setMinorTickSpacing(5);
/* 265 */     this.jSlider_n.setPaintTicks(true);
/* 266 */     this.jSlider_n.addMouseMotionListener(new MouseMotionAdapter() {
/*     */       public void mouseDragged(MouseEvent e) {
/* 268 */         Interferometros.this.jSlider_n_mouseDragged(e);
/*     */       }
/*     */     });
/* 271 */     this.jSlider_n.addMouseListener(new MouseAdapter() {
/*     */       public void mouseDragged(MouseEvent e) {
/* 273 */         Interferometros.this.jSlider_n_mouseDragged(e);
/*     */       }
/*     */       public void mouseClicked(MouseEvent e) {
/* 276 */         Interferometros.this.jSlider_n_mouseClicked(e);
/*     */       }
/*     */     });
/* 279 */     this.jSlider_n.addKeyListener(new KeyAdapter() {
/*     */       public void keyPressed(KeyEvent e) {
/* 281 */         Interferometros.this.jSlider_n_keyPressed(e);
/*     */       }
/*     */       public void keyTyped(KeyEvent e) {
/* 284 */         Interferometros.this.jSlider_n_keyTyped(e);
/*     */       }
/*     */     });
/* 288 */     this.jSlider_angle.setMajorTickSpacing(10);
/* 289 */     this.jSlider_angle.setMaximum(50);
/* 290 */     this.jSlider_angle.setMinimum(0);
/* 291 */     this.jSlider_angle.setMinorTickSpacing(2);
/* 292 */     this.jSlider_angle.setPaintTicks(true);
/* 293 */     this.jSlider_angle.setValue(0);
/* 294 */     this.jSlider_angle.addMouseMotionListener(new MouseMotionAdapter() {
/*     */       public void mouseDragged(MouseEvent e) {
/* 296 */         Interferometros.this.jSlider_angle_mouseDragged(e);
/*     */       }
/*     */     });
/* 299 */     this.jSlider_angle.addMouseListener(new MouseAdapter() {
/*     */       public void mouseDragged(MouseEvent e) {
/* 301 */         Interferometros.this.jSlider_angle_mouseDragged(e);
/*     */       }
/*     */       public void mouseClicked(MouseEvent e) {
/* 304 */         Interferometros.this.jSlider_angle_mouseClicked(e);
/*     */       }
/*     */     });
/* 307 */     this.jSlider_angle.addKeyListener(new KeyAdapter() {
/*     */       public void keyPressed(KeyEvent e) {
/* 309 */         Interferometros.this.jSlider_angle_keyPressed(e);
/*     */       }
/*     */       public void keyTyped(KeyEvent e) {
/* 312 */         Interferometros.this.jSlider_angle_keyTyped(e);
/*     */       }
/*     */     });
/* 316 */     this.jSliderFocal.setMajorTickSpacing(10);
/* 317 */     this.jSliderFocal.setMaximum(100);
/* 318 */     this.jSliderFocal.setMinimum(50);
/* 319 */     this.jSliderFocal.setMinorTickSpacing(5);
/* 320 */     this.jSliderFocal.setPaintTicks(true);
/* 321 */     this.jSliderFocal.setValue(50);
/* 322 */     this.jSliderFocal.addMouseMotionListener(new MouseMotionAdapter() {
/*     */       public void mouseDragged(MouseEvent e) {
/* 324 */         Interferometros.this.jSliderFocal_mouseDragged(e);
/*     */       }
/*     */     });
/* 327 */     this.jSliderFocal.addMouseListener(new MouseAdapter() {
/*     */       public void mouseDragged(MouseEvent e) {
/* 329 */         Interferometros.this.jSliderFocal_mouseDragged(e);
/*     */       }
/*     */       public void mouseClicked(MouseEvent e) {
/* 332 */         Interferometros.this.jSliderFocal_mouseClicked(e);
/*     */       }
/*     */     });
/* 335 */     this.jSliderFocal.addKeyListener(new KeyAdapter() {
/*     */       public void keyPressed(KeyEvent e) {
/* 337 */         Interferometros.this.jSliderFocal_keyPressed(e);
/*     */       }
/*     */       public void keyTyped(KeyEvent e) {
/* 340 */         Interferometros.this.jSliderFocal_keyTyped(e);
/*     */       }
/*     */     });
/* 344 */     this.jSplitPane1.setBorder(null);
/* 345 */     this.jSplitPane1.setContinuousLayout(true);
/* 346 */     this.jSplitPane1.setDividerSize(0);
/* 347 */     this.jSplitPane1.setOneTouchExpandable(false);
/* 348 */     this.jSplitPane1.setDividerLocation(1.0D);
/* 349 */     this.sp_esquema.setBorder(null);
/* 350 */     this.sp_esquema.setMinimumSize(new Dimension(350, 350));
/* 351 */     this.sp_esquema.setPreferredSize(new Dimension(350, 310));
/* 352 */     this.sp_esquema.setContinuousLayout(true);
/* 353 */     this.sp_esquema.setDividerSize(0);
/* 354 */     this.sp_esquema.setOneTouchExpandable(false);
/* 355 */     this.sp_esquema.setDividerLocation(1.0D);
/* 356 */     this.jLabel4.setPreferredSize(new Dimension(300, 17));
/* 357 */     this.jLabel4.setHorizontalAlignment(0);
/* 358 */     this.jLabel4.setText(this.etiqueta[3][lang]);
/* 359 */     this.jLabel4.setForeground(new Color(102, 102, 153));
/* 360 */     this.jLabel5.setPreferredSize(new Dimension(300, 17));
/* 361 */     this.jLabel5.setText(this.etiqueta[1][lang] + " " + this.etiqueta[9][lang] + ": 633 nm");
/* 362 */     this.jLabel5.setForeground(new Color(102, 102, 153));
/* 363 */     this.jPanel_m1_c_c.setLayout(this.flowLayout3);
/* 364 */     this.jLabel6.setPreferredSize(new Dimension(300, 17));
/* 365 */     this.jLabel6.setText(this.etiqueta[2][lang] + ": 0 mm");
/* 366 */     this.jLabel6.setForeground(new Color(102, 102, 153));
/* 367 */     this.jLabel7.setPreferredSize(new Dimension(134, 17));
/* 368 */     this.jLabel7.setText(this.etiqueta[4][lang]);
/* 369 */     this.jLabel7.setForeground(new Color(102, 102, 153));
/* 370 */     this.jLabel8.setPreferredSize(new Dimension(300, 17));
/* 371 */     this.jLabel8.setText(this.etiqueta[4][lang] + " : 1");
/* 372 */     this.jLabel8.setForeground(new Color(102, 102, 153));
/* 373 */     this.jLabel9.setText(this.etiqueta[7][lang] + " : " + finestra + " mm");
/* 374 */     this.jLabel9.setForeground(new Color(102, 102, 153));
/* 375 */     this.jPanel_m1_c_n_w.setPreferredSize(new Dimension(63, 10));
/* 376 */     this.jPanel_m1_c_n_e.setPreferredSize(new Dimension(60, 10));
/* 377 */     this.jPanel_m1_c_n_e.setPreferredSize(new Dimension(62, 10));
/* 378 */     this.jPanel_m1_c_n_s.setPreferredSize(new Dimension(10, 100));
/* 379 */     this.jPanel_m1_c_n_s.setPreferredSize(new Dimension(10, 20));
/* 380 */     this.esqMichelson.setMinimumSize(new Dimension(350, 350));
/* 381 */     this.esqMichelson.setPreferredSize(new Dimension(350, 300));
/* 382 */     this.grafic.setPreferredSize(new Dimension(100, 27));
/* 383 */     this.grafic.setText(this.etiqueta[5][lang]);
/* 384 */     this.grafic.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 386 */         Interferometros.this.grafic_actionPerformed(e);
/*     */       }
/*     */     });
/* 389 */     this.jLabel9.setPreferredSize(new Dimension(300, 17));
/* 390 */     this.jLabel10.setPreferredSize(new Dimension(134, 17));
/* 391 */     this.jLabel10.setForeground(new Color(102, 102, 153));
/* 392 */     this.jLabel10.setText(this.etiqueta[8][lang]);
/* 393 */     this.jButton1.setPreferredSize(new Dimension(120, 17));
/* 394 */     this.jButton1.setHorizontalTextPosition(0);
/* 395 */     this.jButton1.setText(this.about[lang]);
/* 396 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 398 */         Interferometros.this.jButton1_actionPerformed(e);
/*     */       }
/*     */     });
/* 401 */     this.jPanelSur.setPreferredSize(new Dimension(210, 27));
/* 402 */     this.flowLayout1.setAlignment(2);
/* 403 */     this.jLabel11.setMaximumSize(new Dimension(300, 17));
/* 404 */     this.jLabel11.setPreferredSize(new Dimension(300, 27));
/* 405 */     this.jLabel11.setForeground(new Color(102, 102, 153));
/* 406 */     this.jLabel11.setText(this.etiqueta[8][lang] + " : " + "0.0º");
/* 407 */     this.jRadioButton1.setText(this.radioText[0][lang]);
/* 408 */     this.jRadioButton1.setForeground(new Color(102, 102, 153));
/* 409 */     this.jRadioButton1.setSelected(true);
/* 410 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 412 */         Interferometros.this.jRadioButton1_actionPerformed(e);
/*     */       }
/*     */     });
/* 415 */     this.jRadioButton2.setText(this.radioText[1][lang]);
/* 416 */     this.jRadioButton2.setForeground(new Color(102, 102, 153));
/* 417 */     this.esquema.setMaximumSize(new Dimension(35, 11));
/* 418 */     this.esquema.setMinimumSize(new Dimension(35, 11));
/* 419 */     this.esquema.setPreferredSize(new Dimension(100, 27));
/* 420 */     this.esquema.setText(this.esquemaText[0][lang]);
/* 421 */     this.esquema.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 423 */         Interferometros.this.esquema_actionPerformed(e);
/*     */       }
/*     */     });
/* 426 */     this.jPanel1.setPreferredSize(new Dimension(300, 10));
/* 427 */     this.jPanel_m1_c_n_n.setPreferredSize(new Dimension(10, 30));
/* 428 */     this.jLabel12.setPreferredSize(new Dimension(195, 27));
/* 429 */     this.jLabel12.setText(this.focal[lang]);
/* 430 */     this.jLabel12.setForeground(new Color(102, 102, 153));
/* 431 */     this.jSliderFocal.setPreferredSize(new Dimension(100, 27));
/* 432 */     this.jPanel_info.setLayout(this.borderLayout10);
/* 433 */     this.jTextPane_info.setBackground(new Color(204, 204, 204));
/* 434 */     this.jTextPane_info.setEditable(false);
/* 435 */     this.jTextPane_info.setMargin(new Insets(10, 10, 10, 10));
/* 436 */     this.jPanelCentro.setMinimumSize(new Dimension(768, 429));
/* 437 */     this.grupo.add(this.jRadioButton1);
/* 438 */     this.grupo.add(this.jRadioButton2);
/* 439 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 441 */         Interferometros.this.jRadioButton2_actionPerformed(e);
/*     */       }
/*     */     });
/* 444 */     getContentPane().add(this.jPanelBase, "Center");
/* 445 */     this.jPanelBase.add(this.jPanelNorte, "North");
/* 446 */     this.jPanelBase.add(this.jPanelCentro, "Center");
/* 447 */     this.jPanelCentro.add(this.jTabbedPane1, "Center");
/* 448 */     this.jTabbedPane1.add(this.jPanelMichelson, this.titolTabbed[lang]);
/* 449 */     this.jPanelMichelson.add(this.jPanel_m1_w, "West");
/* 450 */     this.jPanel_m1_w.add(this.jPanel_m1_w_n, "Center");
/* 451 */     this.jPanelBase.add(this.jPanelSur, "South");
/* 452 */     this.jPanelSur.add(this.jButton1, null);
/* 453 */     this.jPanelSur.add(this.jButtonSalir, null);
/*     */ 
/* 456 */     this.jPanelMichelson.add(this.jPanel_m1_c, "Center");
/* 457 */     this.jPanel_m1_c_n_c.add(this.jSplitPane1, "Center");
/* 458 */     this.jPanel_m1_c.add(this.jPanel_m1_c_n, "North");
/* 459 */     this.jPanel_m1_w.add(this.jPanel_m1_w_c, "South");
/* 460 */     this.jPanel_m1_w_c.add(this.jLabel1, null);
/* 461 */     this.jPanel_m1_w_c.add(this.jLabel2, null);
/* 462 */     this.jPanel_m1_w_c.add(jSlider_l, null);
/* 463 */     this.jPanel_m1_w_c.add(this.jLabel3, null);
/* 464 */     this.jPanel_m1_w_c.add(this.jSlider_d, null);
/* 465 */     this.jPanel_m1_w_c.add(this.jLabel7, null);
/* 466 */     this.jPanel_m1_w_c.add(this.jSlider_n, null);
/* 467 */     this.jPanel_m1_w_c.add(this.jLabel10, null);
/* 468 */     this.jPanel_m1_w_c.add(this.jRadioButton1, null);
/* 469 */     this.jPanel_m1_w_c.add(this.jRadioButton2, null);
/*     */ 
/* 471 */     this.jPanel_m1_w_n.add(this.jPanel_m1_w_n_n, "North");
/* 472 */     this.jPanel_m1_w_n.add(this.jPanel_m1_w_n_w, "West");
/* 473 */     this.jPanel_m1_w_n.add(this.jPanel_m1_w_n_e, "East");
/* 474 */     this.jPanel_m1_w_n.add(this.jPanel_m1_w_n_c, "Center");
/* 475 */     this.jPanel_m1_w_n_c.add(this.sp_esquema, "Center");
/*     */ 
/* 477 */     this.jPanel_m1_c.add(this.jPanel_m1_c_c, "Center");
/* 478 */     this.jPanel_m1_c_c.add(this.jLabel4, null);
/* 479 */     this.jPanel_m1_c_c.add(this.jLabel5, null);
/* 480 */     this.jPanel_m1_c_c.add(this.jLabel6, null);
/* 481 */     this.jPanel_m1_c_c.add(this.jLabel8, null);
/* 482 */     this.jPanel_m1_c_c.add(this.jLabel9, null);
/* 483 */     this.jPanel_m1_c_c.add(this.jLabel12, null);
/* 484 */     this.jPanel_m1_c_c.add(this.jSliderFocal, null);
/*     */ 
/* 486 */     this.jPanel_m1_c_c.add(this.jPanel1, null);
/* 487 */     this.jPanel_m1_c_c.add(this.esquema, null);
/* 488 */     this.jPanel_m1_c_c.add(this.grafic, null);
/* 489 */     this.jTabbedPane1.add(this.jPanel_info, "jPanel_info");
/* 490 */     this.jTabbedPane1.add(this.jPanel_info, this.teoria[lang]);
/* 491 */     this.jPanel_info.add(this.jScrollPane1, "Center");
/* 492 */     this.jScrollPane1.getViewport().add(this.jTextPane_info, null);
/* 493 */     this.jPanel_m1_c_n.add(this.jPanel_m1_c_n_n, "North");
/* 494 */     this.jPanel_m1_c_n.add(this.jPanel_m1_c_n_w, "West");
/* 495 */     this.jPanel_m1_c_n.add(this.jPanel_m1_c_n_e, "East");
/* 496 */     this.jPanel_m1_c_n.add(this.jPanel_m1_c_n_c, "Center");
/* 497 */     this.jPanel_m1_c_n.add(this.jPanel_m1_c_n_s, "South");
/* 498 */     this.jPanel_m1_w_n.repaint();
/*     */ 
/* 500 */     actualizaSlider();
/*     */   }
/*     */ 
/*     */   public void start()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void stop() {
/*     */   }
/*     */ 
/*     */   public void destroy() {
/*     */   }
/*     */ 
/*     */   public String getAppletInfo() {
/* 514 */     return "Applet Information";
/*     */   }
/*     */ 
/*     */   public String[][] getParameterInfo() {
/* 518 */     String[][] pinfo = { { "idioma", "int", "" } };
/*     */ 
/* 522 */     return pinfo;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 529 */       String dato = args[0].toUpperCase().intern();
/*     */ 
/* 531 */       if (dato == "CA")
/*     */       {
/* 533 */         lang = 1;
/*     */       }
/* 535 */       else if (dato == "ES")
/*     */       {
/* 537 */         lang = 0;
/*     */       }
/* 539 */       else if (dato == "EN")
/*     */       {
/* 541 */         lang = 2;
/*     */       }
/*     */       else {
/* 544 */         lang = 0;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e2)
/*     */     {
/* 550 */       lang = 0;
/*     */     }
/*     */ 
/* 555 */     Interferometros applet = new Interferometros();
/* 556 */     applet.isStandalone = true;
/* 557 */     JFrame frame = new JFrame();
/*     */ 
/* 559 */     if (icon_joc != null) frame.setIconImage(icon_joc.getImage());
/* 560 */     //frame.setDefaultCloseOperation(3);
              frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
/* 561 */     frame.setTitle(titol[lang]);
/* 562 */     frame.setResizable(true);
/* 563 */     frame.getContentPane().add(applet, "Center");
/*     */ 
/* 574 */     applet.init();
/* 575 */     applet.start();
/* 576 */     frame.setSize(1016, 686);
/* 577 */     Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
/* 578 */     frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
/* 579 */     frame.setVisible(true);
/*     */   }
/*     */ 
/*     */   void jButtonSalir_actionPerformed(ActionEvent e)
/*     */   {
/*     */     try
/*     */     {
                Window window = SwingUtilities.getWindowAncestor(this);
                window.dispose();

/* 594 */       //System.exit(0);
/*     */     }
/*     */     catch (Exception e1) {
/* 597 */       System.out.println("Error al salir");
/*     */     }
/*     */   }
/*     */ 
/*     */   void jSlider_l_mouseDragged(MouseEvent e) {
/* 602 */     actualizaSlider();
/*     */   }
/*     */ 
/*     */   void jSlider_l_mouseClicked(MouseEvent e) {
/* 606 */     actualizaSlider();
/*     */   }
/*     */   void jSlider_l_keyPressed(KeyEvent e) {
/* 609 */     actualizaSlider();
/*     */   }
/*     */   void jSlider_l_keyTyped(KeyEvent e) {
/* 612 */     actualizaSlider();
/*     */   }
/*     */   void jSlider_d_mouseDragged(MouseEvent e) {
/* 615 */     actualizaSlider();
/*     */   }
/*     */ 
/*     */   void jSlider_d_mouseClicked(MouseEvent e) {
/* 619 */     actualizaSlider();
/*     */   }
/*     */   void jSlider_d_keyPressed(KeyEvent e) {
/* 622 */     actualizaSlider();
/*     */   }
/*     */   void jSlider_d_keyTyped(KeyEvent e) {
/* 625 */     actualizaSlider();
/*     */   }
/*     */ 
/*     */   void jSlider_n_mouseDragged(MouseEvent e) {
/* 629 */     actualizaSlider();
/*     */   }
/*     */ 
/*     */   void jSlider_n_mouseClicked(MouseEvent e) {
/* 633 */     actualizaSlider();
/*     */   }
/*     */   void jSlider_n_keyPressed(KeyEvent e) {
/* 636 */     actualizaSlider();
/*     */   }
/*     */   void jSlider_n_keyTyped(KeyEvent e) {
/* 639 */     actualizaSlider();
/*     */   }
/*     */   void jSlider_angle_mouseDragged(MouseEvent e) {
/* 642 */     actualizaSlider();
/*     */   }
/*     */ 
/*     */   void jSlider_angle_mouseClicked(MouseEvent e) {
/* 646 */     actualizaSlider();
/*     */   }
/*     */   void jSlider_angle_keyPressed(KeyEvent e) {
/* 649 */     actualizaSlider();
/*     */   }
/*     */   void jSlider_angle_keyTyped(KeyEvent e) {
/* 652 */     actualizaSlider();
/*     */   }
/*     */ 
/*     */   void jSliderFocal_mouseDragged(MouseEvent e) {
/* 656 */     actualizaSlider();
/*     */   }
/*     */ 
/*     */   void jSliderFocal_mouseClicked(MouseEvent e) {
/* 660 */     actualizaSlider();
/*     */   }
/*     */   void jSliderFocal_keyPressed(KeyEvent e) {
/* 663 */     actualizaSlider();
/*     */   }
/*     */   void jSliderFocal_keyTyped(KeyEvent e) {
/* 666 */     actualizaSlider();
/*     */   }
/*     */ 
/*     */   void actualizaSlider()
/*     */   {
/* 671 */     this.lambda = jSlider_l.getValue();
/* 672 */     this.n = (this.jSlider_n.getValue() / 100.0D);
/* 673 */     this.d = (this.jSlider_d.getValue() / 100.0D);
/* 674 */     int colorfondo = 50 + (int)(this.jSlider_n.getValue() * 0.2D);
/* 675 */     double a = this.jSlider_angle.getValue() / 10.0D;
/* 676 */     this.esqMichelson.putAtributos(this.lambda, this.d, this.n);
/* 677 */     this.jPanel_m1_w_n_c.setBackground(new Color(colorfondo, colorfondo, colorfondo));
/* 678 */     this.jPanel_m1_w_n.repaint();
/* 679 */     this.jLabel5.setText(this.etiqueta[1][lang] + " " + this.etiqueta[9][lang] + ": " + jSlider_l.getValue() + " nm");
/* 680 */     this.jLabel6.setText(this.etiqueta[2][lang] + ": " + this.jSlider_d.getValue() / 100.0D + " mm");
/* 681 */     this.jLabel8.setText(this.etiqueta[4][lang] + " : " + this.jSlider_n.getValue() / 100.0D);
/* 682 */     this.jLabel11.setText(this.etiqueta[8][lang] + " : " + this.jSlider_angle.getValue() / 10.0D + "º");
/* 683 */     this.imgMichelson.putAtributos(this.lambda, this.d, this.n);
/* 684 */     this.grafMichelson.putAtributos(this.lambda, this.d, this.n);
/* 685 */     this.esqConceptual.putAtributos(this.lambda, this.d, this.n);
/* 686 */     this.jLabel12.setText(this.focal[lang] + " " + this.jSliderFocal.getValue() + " mm");
/* 687 */     this.jLabel9.setText(this.etiqueta[7][lang] + " : " + finestra * this.jSliderFocal.getValue() / 50.0D + " mm");
/* 688 */     this.jPanel_m1_c_n.repaint();
/* 689 */     this.jPanel_m1_w_n.repaint();
/*     */   }
/*     */ 
/*     */   void grafic_actionPerformed(ActionEvent e) {
/* 693 */     if (this.grafic.getText().equals(this.etiqueta[5][lang])) {
/* 694 */       this.grafic.setText(this.etiqueta[6][lang]);
/* 695 */       this.jSplitPane1.setDividerLocation(1.0D);
/* 696 */       this.jPanel_m1_c_n.repaint();
/*     */     }
/*     */     else {
/* 699 */       this.grafic.setText(this.etiqueta[5][lang]);
/* 700 */       this.jSplitPane1.setDividerLocation(0.0D);
/* 701 */       this.jPanel_m1_c_n.repaint();
/*     */     }
/*     */   }
/*     */ 
/*     */   void jButton1_actionPerformed(ActionEvent e) {
/* 706 */     Frame f = new Frame();
/* 707 */     Object[] options = { this.aceptar[lang] };
/*     */ 
/* 710 */     ImageIcon icon_joc = null;
/*     */     try {
/* 712 */       String st_icon = "jdclogo_48x48.png";
/* 713 */       URL url_icon = getClass().getResource(st_icon);
/* 714 */       icon_joc = new ImageIcon(url_icon, "JDC Education Kit for Optical Experiments");
/*     */     } catch (Exception eicon) {
/* 716 */       System.out.println("No carga icono");
/*     */     }
/*     */ 
/* 721 */     JOptionPane hola = new JOptionPane(this.rollo[lang], 1, -1, icon_joc, options);
/* 722 */     JDialog dialog = hola.createDialog(f, this.about[lang]);
/* 723 */     dialog.show();
/* 724 */     repaint();
/*     */   }
/*     */ 
/*     */   void jRadioButton1_actionPerformed(ActionEvent e) {
/* 728 */     tipoFuente = false;
/* 729 */     actualizaSlider();
/*     */   }
/*     */ 
/*     */   void jRadioButton2_actionPerformed(ActionEvent e) {
/* 733 */     tipoFuente = true;
/* 734 */     actualizaSlider();
/*     */   }
/*     */ 
/*     */   void esquema_actionPerformed(ActionEvent e) {
/* 738 */     if (this.esquema.getText().equals(this.esquemaText[1][lang])) {
/* 739 */       this.esquema.setText(this.esquemaText[0][lang]);
/* 740 */       this.sp_esquema.setDividerLocation(0.0D);
/* 741 */       this.jPanel_m1_w_n.repaint();
/*     */     }
/*     */     else {
/* 744 */       this.esquema.setText(this.esquemaText[1][lang]);
/* 745 */       this.sp_esquema.setDividerLocation(1.0D);
/* 746 */       this.jPanel_m1_w_n.repaint();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void carga_info(int lengua)
/*     */   {
/* 753 */     this.jTextPane_info.setEditable(false);
/* 754 */     String s = null;
/* 755 */     URL info_page = null;
/*     */     try
/*     */     {
/* 762 */       if (lengua == 1) s = "DocA_MichelCa.htm";
/* 763 */       else if (lengua == 2) s = "DocA_MichelEn.htm"; else {
/* 764 */         s = "DocA_MichelEs.htm";
/*     */       }
/* 766 */       info_page = getClass().getResource(s);
/*     */     }
/*     */     catch (Exception eee) {
/* 769 */       System.err.println("Couldn't create help URL: " + s);
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 775 */       this.jTextPane_info.setPage(info_page);
/*     */     } catch (IOException e) {
/* 777 */       System.err.println("Attempted to read a bad URL: " + info_page);
/*     */     }
/*     */   }
/*     */ }