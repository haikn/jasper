/*      */ package difraccion;
/*      */ 
/*      */ import java.applet.Applet;
/*      */ import java.awt.BorderLayout;
/*      */ import java.awt.Color;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.FlowLayout;
/*      */ import java.awt.Frame;
/*      */ import java.awt.Toolkit;
import java.awt.Window;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.io.IOException;
/*      */ import java.io.PrintStream;
/*      */ import java.net.URL;
/*      */ import java.text.DecimalFormat;
/*      */ import java.text.DecimalFormatSymbols;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.ButtonGroup;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRadioButton;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSlider;
/*      */ import javax.swing.JSplitPane;
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.JTextPane;
/*      */ import javax.swing.JToggleButton;
/*      */ import javax.swing.JViewport;
import javax.swing.SwingUtilities;
/*      */ 
/*      */ public class DifraccionApplet extends Applet
/*      */ {
/*   25 */   String[][] acerca_etiqueta = { { "Acerca de", "En quant a", "About" }, { "Aceptar", "Acceptar", "OK" }, { "Javaoptics: Applet de Difracción de Fresnel y Fraunhofer v2.0a \n Grup d'Innovació Docent en Òptica Física i Fotònica \n Universitat de Barcelona, 2003 \n La utilización de este programa está bajo una licencia de Creative Commons \n Ver condiciones en http://creativecommons.org/license/by-nc-sa/2.0/ \n \n Curso de Óptica en Java DOI: 10.1344/401.000000050 \n Applet de Difracción de Fresnel y Fraunhofer DOI: 10.1344/203.000000094", "Javaoptics: Applet de Difracció de Fresnel i Fraunhofer v2.0a \n Grup d'Innovació Docent en Òptica Física i Fotònica \n Universitat de Barcelona, 2003 \n La utilització d'aquest programa està sota una llicència de Creative Commons \n Veure condicions a http://www.publicacions.ub.es/doi/licencia/resum-deriv.htm \n \n Curs d'Òptica en Java DOI: 10.1344/401.000000050 \n Applet de Difracció de Fresnel i Fraunhofer DOI: 10.1344/203.000000094", "Javaoptics: Fresnel and Fraunhofer Diffraction Applet v2.0a \n Grup d'Innovació Docent en Òptica Física i Fotònica \n Universitat de Barcelona, 2003 \n The use of this program is under a Creative Commons license \n See conditions in http://creativecommons.org/license/by-nc-sa/2.0/ \n \n Java Optics Course DOI: 10.1344/401.000000050 \n Fresnel and Fraunhofer Diffraction applet DOI: 10.1344/203.000000094" } };
/*      */ 
/*   31 */   String[][] fraun_etiqueta = { { "Parámetros del sistema:", "Paràmetres del sistema", "System parameters" }, { "Longitud de onda:", "Longitud d'ona:", "Wavelength:" }, { "Distancia focal:", "Distància focal:", "Focal distance:" }, { "Objeto:", "Objecte:", "Object:" }, { "Rectángulo", "Rectangle", "Rectangle" }, { "Círculo", "Cercle", "Circle" }, { "Rendija", "Escletxa", "Slit" }, { "Lado x:", "Costat x:", "X side:" }, { "Lado y:", "Costat y:", "Y side:" }, { "N objetos:", "N objectes:", "N objects:" }, { "Período objetos:", "Període objectes:", "Objects period:" }, { "Tamaño imagen objeto:", "Mida imatge objecte:", "Object image size:" }, { "Umbral:", "Llindar:", "Threshold:" }, { "Mostrar:", "Mostrar:", "Show:" }, { "Imagen", "Imatge", "Image" }, { "Perfil fila central", "Perfil fila central", "Central row profile" }, { "Amplitud", "Amplitud", "Amplitude" }, { "Intensidad", "Intensitat", "Intensity" }, { "Log Intensidad", "Log Intensitat", "Log Intensity" }, { "Tamaño imagen difracción:", "Mida imatge difracció:", "Diffraction image size:" }, { "Distancia 1º mínimo difracción:", "Distància 1º mínim difracció:", "Distance 1st diffraction min:" }, { "Distancia entre máximos:", "Distància entre màxims:", "Distance between maximums:" }, { "Distancia entre mínimos:", "Distància entre mínims:", "Distance between minimums:" }, { "Diámetro:", "Diàmetre", "Diameter:" }, { "Dist. 1º min difracción en x: ", "Dist. 1º min difracció en x: ", "Dist. 1st diffraction min in x: " }, { ", en y: ", ", en y: ", ", in y: " }, { "Radio de Airy: ", "Radi d'Airy: ", "Airy's radius: " }, { "Distancia entre máximos: ", "Distància entre màxims: ", "Distance between maximums: " }, { "Distancia entre mínimos: ", "Distància entre mínims: ", "Distance between minimums: " } };
/*      */ 
/*   61 */   String[] boton_salir = { "Salir", "Sortir", "Exit" };
/*   62 */   String[] info_etiqueta = { "Resumen Teoría", "Resum Teoria", "Theory Summary" };
/*   63 */   String[][] fres_etiqueta = { { "Semiplano", "Semipla", "Semiplane" }, { "Dist. propagación:", "Dist. propagació:", "Propagation dist.:" }, { "Calcular difracción", "Calcular diffracció", "Compute diffraction" } };
/*      */   int long_onda;
/*      */   double dist_focal;
/*   72 */   int num_objetos = 0;
/*      */   int n_objetos;
/*   74 */   int tipo_objeto = 0;
/*      */   double dim_x;
/*      */   double dim_y;
/*      */   double fraun_periodo;
/*      */   double fraun_tam_img;
/*      */   int label_fraun_show;
/*   83 */   int label_fraun_tipoimg = 1;
/*      */   double fraun_umbral;
/*      */   boolean label_fraun_zoom;
/*   86 */   boolean label_fraun_activaimg = true;
/*      */ 
/*   90 */   int tipo_objeto_fresnel = 0;
/*      */   int long_onda_fres;
/*      */   double dist_prop;
/*      */   double dim_x_fres;
/*      */   double dim_y_fres;
/*      */   boolean label_fres_calcula;
/*   96 */   int numpto_x = 256;
/*   97 */   int numpto_y = 256;
/*   98 */   int numpto_total = this.numpto_x * this.numpto_y;
/*   99 */   double[] matriz_fres_re = new double[this.numpto_total];
/*  100 */   double[] matriz_fres_im = new double[this.numpto_total];
/*  101 */   int label_fres_tipoimg = 1;
/*      */   double fres_umbral;
/*  103 */   TransformadaFresnel transformadaFresnel = new TransformadaFresnel();
/*  104 */   boolean label_fres_activaimg = true;
/*      */ 
/*  106 */   DecimalFormatSymbols df_symb = new DecimalFormatSymbols();
/*  107 */   DecimalFormat df = new DecimalFormat("#.###", this.df_symb);
/*      */ 
/*  109 */   private boolean isStandalone = false;
/*      */   static int lang;
/*  112 */   BorderLayout borderLayout1 = new BorderLayout();
/*  113 */   JPanel jPanel_Base = new JPanel();
/*  114 */   BorderLayout borderLayout2 = new BorderLayout();
/*  115 */   JPanel jPanel_Norte = new JPanel();
/*  116 */   JPanel jPanel_Centro = new JPanel();
/*  117 */   JPanel jPanel_Sur = new JPanel();
/*  118 */   FlowLayout flowLayout1 = new FlowLayout();
/*  119 */   BorderLayout borderLayout3 = new BorderLayout();
/*  120 */   FlowLayout flowLayout2 = new FlowLayout();
/*  121 */   JButton jButton_Salir = new JButton();
/*  122 */   JButton jButton_Acercade = new JButton();
/*  123 */   JTabbedPane jTabbedPane1 = new JTabbedPane();
/*  124 */   JPanel jPanel_Fresnel = new JPanel();
/*  125 */   BorderLayout borderLayout4 = new BorderLayout();
/*  126 */   JPanel jPanel_Fraunhofer = new JPanel();
/*  127 */   BorderLayout borderLayout5 = new BorderLayout();
/*  128 */   JPanel jPanel_Info = new JPanel();
/*  129 */   BorderLayout borderLayout6 = new BorderLayout();
/*  130 */   JPanel jPanel_Fraun_w = new JPanel();
/*  131 */   BorderLayout borderLayout7 = new BorderLayout();
/*  132 */   JPanel jPanel_Fraun_c = new JPanel();
/*  133 */   BorderLayout borderLayout8 = new BorderLayout();
/*  134 */   JPanel jPanel_Fraun_w_n = new JPanel();
/*  135 */   BorderLayout borderLayout9 = new BorderLayout();
/*  136 */   JPanel jPanel_Fraun_w_c = new JPanel();
/*  137 */   FlowLayout flowLayout3 = new FlowLayout();
/*  138 */   JPanel jPanel_Fraun_w_n_n = new JPanel();
/*  139 */   BorderLayout borderLayout10 = new BorderLayout();
/*  140 */   JPanel jPanel_Fraun_w_n_c = new JPanel();
/*  141 */   BorderLayout borderLayout11 = new BorderLayout();
/*  142 */   JPanel jPanel_Fraun_w_n_s = new JPanel();
/*  143 */   BorderLayout borderLayout12 = new BorderLayout();
/*  144 */   JPanel jPanel_Fraun_w_n_w = new JPanel();
/*  145 */   BorderLayout borderLayout13 = new BorderLayout();
/*  146 */   JPanel jPanel_Fraun_w_n_e = new JPanel();
/*  147 */   BorderLayout borderLayout14 = new BorderLayout();
/*  148 */   JPanel jPanel_Fraun_c_n = new JPanel();
/*  149 */   BorderLayout borderLayout15 = new BorderLayout();
/*  150 */   JPanel jPanel_fraun_c_c = new JPanel();
/*  151 */   FlowLayout flowLayout4 = new FlowLayout();
/*  152 */   JPanel jPanel_Fraun_c_n_n = new JPanel();
/*  153 */   BorderLayout borderLayout16 = new BorderLayout();
/*  154 */   JPanel jPanel_Fraun_c_n_c = new JPanel();
/*  155 */   BorderLayout borderLayout17 = new BorderLayout();
/*  156 */   JPanel jPanel_Fraun_c_n_s = new JPanel();
/*  157 */   BorderLayout borderLayout18 = new BorderLayout();
/*  158 */   JPanel jPanel_Fraun_c_n_w = new JPanel();
/*  159 */   BorderLayout borderLayout19 = new BorderLayout();
/*  160 */   JPanel jPanel_Fraun_c_n_e = new JPanel();
/*  161 */   BorderLayout borderLayout20 = new BorderLayout();
/*  162 */   JPanel jPanel_fres_w = new JPanel();
/*  163 */   BorderLayout borderLayout21 = new BorderLayout();
/*  164 */   JPanel jPanel_fres_c = new JPanel();
/*  165 */   BorderLayout borderLayout22 = new BorderLayout();
/*  166 */   JPanel jPanel_fres_w_n = new JPanel();
/*  167 */   BorderLayout borderLayout23 = new BorderLayout();
/*  168 */   JPanel jPanel_fres_w_c = new JPanel();
/*  169 */   JPanel jPanel_fres_w_n_n = new JPanel();
/*  170 */   BorderLayout borderLayout25 = new BorderLayout();
/*  171 */   JPanel jPanel_fres_w_n_c = new JPanel();
/*  172 */   BorderLayout borderLayout26 = new BorderLayout();
/*  173 */   JPanel jPanel_fres_w_n_s = new JPanel();
/*  174 */   BorderLayout borderLayout27 = new BorderLayout();
/*  175 */   JPanel jPanel_fres_w_n_w = new JPanel();
/*  176 */   BorderLayout borderLayout28 = new BorderLayout();
/*  177 */   JPanel jPanel_fres_w_n_e = new JPanel();
/*  178 */   BorderLayout borderLayout29 = new BorderLayout();
/*  179 */   FlowLayout flowLayout5 = new FlowLayout();
/*  180 */   JPanel jPanel_fres_c_n = new JPanel();
/*  181 */   BorderLayout borderLayout24 = new BorderLayout();
/*  182 */   JPanel jPanel_fres_c_c = new JPanel();
/*  183 */   FlowLayout flowLayout6 = new FlowLayout();
/*  184 */   JPanel jPanel_fres_c_n_n = new JPanel();
/*  185 */   BorderLayout borderLayout30 = new BorderLayout();
/*  186 */   JPanel jPanel_fres_c_n_c = new JPanel();
/*  187 */   JPanel jPanel_fres_c_n_s = new JPanel();
/*  188 */   BorderLayout borderLayout31 = new BorderLayout();
/*  189 */   BorderLayout borderLayout32 = new BorderLayout();
/*  190 */   JPanel jPanel_fres_c_n_w = new JPanel();
/*  191 */   BorderLayout borderLayout33 = new BorderLayout();
/*  192 */   JPanel jPanel_fres_c_n_e = new JPanel();
/*  193 */   BorderLayout borderLayout34 = new BorderLayout();
/*      */ 
/*  195 */   JLabel jLabel_fraun_param = new JLabel();
/*  196 */   JLabel jLabel_fraun_longOnda = new JLabel();
/*  197 */   JSlider jSlider_fraun_longOnda = new JSlider(0, 400, 700, 633);
/*  198 */   JLabel jLabel_fraun_nlongOnda = new JLabel();
/*  199 */   JLabel jLabel_fraun_distFocal = new JLabel();
/*  200 */   JSlider jSlider_fraun_distFocal = new JSlider(0, 100, 1000, 1000);
/*  201 */   JLabel jLabel_fraun_ndistFocal = new JLabel();
/*  202 */   JLabel jLabel_fraun_objeto = new JLabel();
/*  203 */   JRadioButton jRadioButton_fraun_rectang = new JRadioButton();
/*  204 */   JRadioButton jRadioButton_fraun_circ = new JRadioButton();
/*  205 */   JRadioButton jRadioButton_fraun_rend = new JRadioButton();
/*  206 */   ButtonGroup group_fraun_tipoobj = new ButtonGroup();
/*  207 */   JPanel jPanel_fraun_dimObjeto = new JPanel();
/*  208 */   FlowLayout flowLayout7 = new FlowLayout();
/*  209 */   JLabel jLabel_fraun_dimx = new JLabel();
/*  210 */   JSlider jSlider_fraun_dimx = new JSlider(0, 5, 50, 5);
/*  211 */   JLabel jLabel_fraun_ndimx = new JLabel();
/*  212 */   JLabel jLabel_fraun_dimy = new JLabel();
/*  213 */   JSlider jSlider_fraun_dimy = new JSlider(0, 5, 50, 5);
/*  214 */   JLabel jLabel_fraun_ndimy = new JLabel();
/*      */ 
/*  217 */   JLabel jLabel_fraun_nObjetos = new JLabel();
/*      */ 
/*  223 */   JSlider jSlider_fraun_nobjetos = new JSlider(0, 1, 10, 1);
/*  224 */   JLabel jLabel_fraun_numobj = new JLabel();
/*  225 */   JLabel jLabel_fraun_periodo = new JLabel();
/*  226 */   JLabel jLabel_fraun_dimimag = new JLabel();
/*      */ 
/*  228 */   PanelObjeto objetoFraunhofer = new PanelObjeto();
/*  229 */   ImagenFraunhofer imagenFraun = new ImagenFraunhofer();
/*  230 */   PerfilFraunhofer perfilFraun = new PerfilFraunhofer();
/*  231 */   JSplitPane jSplitPane_Fraun = new JSplitPane(1, this.perfilFraun, this.imagenFraun);
/*  232 */   JLabel jLabel_fraun_umbral = new JLabel();
/*  233 */   JSlider jSlider_fraun_umbral = new JSlider(0, 1, 100, 100);
/*  234 */   JLabel jLabel_fraun_numbral = new JLabel();
/*  235 */   JLabel jLabel_fraun_show = new JLabel();
/*  236 */   JRadioButton jRadioButton_fraun_showimg = new JRadioButton();
/*  237 */   JRadioButton jRadioButton_fraun_showperf = new JRadioButton();
/*  238 */   ButtonGroup group_fraun_show = new ButtonGroup();
/*  239 */   JLabel jLabel_fraun_tipoimg = new JLabel();
/*  240 */   JRadioButton jRadioButton_fraun_tipoimg_amp = new JRadioButton();
/*  241 */   JRadioButton jRadioButton_fraun_tipoimg_int = new JRadioButton();
/*  242 */   JRadioButton jRadioButton_fraun_tipoimg_intlog = new JRadioButton();
/*  243 */   ButtonGroup group_fraun_tipoimg = new ButtonGroup();
/*  244 */   JLabel jLabel_fraun_tamdiff = new JLabel();
/*  245 */   JLabel jLabel_fraun_distmindif = new JLabel();
/*  246 */   JLabel jLabel_fraun_distnmax = new JLabel();
/*  247 */   JLabel jLabel_fraun_distnmin = new JLabel();
/*  248 */   JToggleButton jToggleButton_fraun_zoom = new JToggleButton("Zoom", false);
/*  249 */   JPanel jPanel_fraun_showimg = new JPanel();
/*  250 */   FlowLayout flowLayout8 = new FlowLayout();
/*      */ 
/*  254 */   JLabel jLabel_fres_param = new JLabel();
/*  255 */   JLabel jLabel_fres_longOnda = new JLabel();
/*  256 */   JSlider jSlider_fres_longOnda = new JSlider(0, 400, 700, 633);
/*  257 */   JLabel jLabel_fres_nlongOnda = new JLabel();
/*  258 */   JLabel jLabel_fres_distProp = new JLabel();
/*  259 */   JSlider jSlider_fres_distProp = new JSlider(0, 100, 1000, 100);
/*  260 */   JLabel jLabel_fres_ndistProp = new JLabel();
/*  261 */   JLabel jLabel_fres_objeto = new JLabel();
/*  262 */   JLabel jLabel_fres_nada = new JLabel();
/*  263 */   JRadioButton jRadioButton_fres_rectang = new JRadioButton();
/*  264 */   JRadioButton jRadioButton_fres_circ = new JRadioButton();
/*  265 */   JRadioButton jRadioButton_fres_rend = new JRadioButton();
/*  266 */   JRadioButton jRadioButton_fres_semip = new JRadioButton();
/*  267 */   ButtonGroup group_fres_tipoobj = new ButtonGroup();
/*  268 */   JPanel jPanel_fres_dimObjeto = new JPanel();
/*  269 */   FlowLayout flowLayoutx7 = new FlowLayout();
/*  270 */   JLabel jLabel_fres_dimx = new JLabel();
/*  271 */   JSlider jSlider_fres_dimx = new JSlider(0, 5, 50, 5);
/*  272 */   JLabel jLabel_fres_ndimx = new JLabel();
/*  273 */   JLabel jLabel_fres_dimy = new JLabel();
/*  274 */   JSlider jSlider_fres_dimy = new JSlider(0, 5, 50, 5);
/*  275 */   JLabel jLabel_fres_ndimy = new JLabel();
/*  276 */   JButton jButton_fres_calcdif = new JButton();
/*  277 */   PanelObjetoFresnel objetoFresnel = new PanelObjetoFresnel();
/*  278 */   ImagenFresnel imagenFresnel = new ImagenFresnel();
/*  279 */   PerfilFresnel perfilFresnel = new PerfilFresnel();
/*  280 */   JSplitPane jSplitPane_fres = new JSplitPane(1, this.perfilFresnel, this.imagenFresnel);
/*      */ 
/*  282 */   JLabel jLabel_fres_umbral = new JLabel();
/*  283 */   JSlider jSlider_fres_umbral = new JSlider(0, 1, 100, 100);
/*  284 */   JLabel jLabel_fres_numbral = new JLabel();
/*  285 */   JLabel jLabel_fres_show = new JLabel();
/*  286 */   JRadioButton jRadioButton_fres_showimg = new JRadioButton();
/*  287 */   JRadioButton jRadioButton_fres_showperf = new JRadioButton();
/*  288 */   ButtonGroup group_fres_show = new ButtonGroup();
/*  289 */   JLabel jLabel_fres_tipoimg = new JLabel();
/*  290 */   JRadioButton jRadioButton_fres_tipoimg_amp = new JRadioButton();
/*  291 */   JRadioButton jRadioButton_fres_tipoimg_int = new JRadioButton();
/*  292 */   JRadioButton jRadioButton_fres_tipoimg_intlog = new JRadioButton();
/*  293 */   ButtonGroup group_fres_tipoimg = new ButtonGroup();
/*  294 */   JLabel jLabel_fres_dimimag = new JLabel();
/*  295 */   JLabel jLabel_fres_tamdiff = new JLabel();
/*  296 */   JPanel jPanel_fres_showimg = new JPanel();
/*  297 */   FlowLayout flowLayoutx8 = new FlowLayout();
/*      */ 
/*  299 */   static ImageIcon icon_joc = null;
/*  300 */   JLabel jLabel_fres_nada2 = new JLabel();
/*      */   URL info_page;
/*  302 */   JScrollPane jScrollPane_teoria = new JScrollPane();
/*  303 */   JTextPane jTextPane_teoria = new JTextPane();
/*      */ 
/*      */   public String getParameter(String key, String def)
/*      */   {
/*  313 */     return getParameter(key) != null ? getParameter(key) : this.isStandalone ? System.getProperty(key, def) : def;
/*      */   }
/*      */ 
/*      */   public DifraccionApplet()
/*      */   {
/*      */     try
/*      */     {
/*  321 */       String st_icon = "jocon.jpg";
/*  322 */       URL url_icon = getClass().getResource(st_icon);
/*  323 */       icon_joc = new ImageIcon(url_icon, "Difracción");
/*      */     } catch (Exception eicon) {
/*  325 */       System.out.println("No carga icono");
/*      */     }
/*      */   }
/*      */ 
/*      */   public void init()
/*      */   {
/*      */     try
/*      */     {
/*  338 */       jbInit();
/*      */     }
/*      */     catch (Exception e) {
/*  341 */       e.printStackTrace();
/*      */     }
/*  343 */     actuaParametrosFraunhofer();
/*  344 */     actuaParametrosFresnel();
/*  345 */     calculaDifraccionFresnel();
/*  346 */     actuaImagenFresnel();
/*  347 */     carga_info(lang);
/*      */   }
/*      */ 
/*      */   private void jbInit() throws Exception {
/*  351 */     setLayout(this.borderLayout1);
/*  352 */     this.jPanel_Base.setLayout(this.borderLayout2);
/*  353 */     this.jPanel_Base.setMinimumSize(new Dimension(750, 550));
/*  354 */     this.jPanel_Base.setPreferredSize(new Dimension(750, 550));
/*  355 */     this.jPanel_Norte.setPreferredSize(new Dimension(750, 10));
/*  356 */     this.jPanel_Norte.setLayout(this.flowLayout1);
/*  357 */     this.jPanel_Sur.setMinimumSize(new Dimension(750, 25));
/*  358 */     this.jPanel_Sur.setPreferredSize(new Dimension(750, 25));
/*  359 */     this.jPanel_Sur.setLayout(this.flowLayout2);
/*  360 */     this.jPanel_Centro.setPreferredSize(new Dimension(750, 500));
/*  361 */     this.jPanel_Centro.setLayout(this.borderLayout3);
/*  362 */     this.flowLayout2.setAlignment(2);
/*  363 */     this.jButton_Salir.setMaximumSize(new Dimension(110, 20));
/*  364 */     this.jButton_Salir.setMinimumSize(new Dimension(110, 20));
/*  365 */     this.jButton_Salir.setPreferredSize(new Dimension(110, 20));
/*  366 */     this.jButton_Salir.setText(this.boton_salir[lang]);
/*  367 */     this.jButton_Salir.addActionListener(new DifraccionApplet_jButton_Salir_actionAdapter(this));
/*  368 */     this.jButton_Acercade.setForeground(Color.darkGray);
/*  369 */     this.jButton_Acercade.setMaximumSize(new Dimension(110, 20));
/*  370 */     this.jButton_Acercade.setMinimumSize(new Dimension(110, 20));
/*  371 */     this.jButton_Acercade.setPreferredSize(new Dimension(110, 20));
/*  372 */     this.jButton_Acercade.setText(this.acerca_etiqueta[0][lang]);
/*  373 */     this.jButton_Acercade.addActionListener(new DifraccionApplet_jButton_Acercade_actionAdapter(this));
/*  374 */     this.jTabbedPane1.setPreferredSize(new Dimension(750, 500));
/*  375 */     this.jPanel_Fresnel.setPreferredSize(new Dimension(750, 465));
/*  376 */     this.jPanel_Fresnel.setLayout(this.borderLayout4);
/*  377 */     this.jPanel_Fraunhofer.setMinimumSize(new Dimension(10, 10));
/*  378 */     this.jPanel_Fraunhofer.setPreferredSize(new Dimension(750, 465));
/*  379 */     this.jPanel_Fraunhofer.setLayout(this.borderLayout5);
/*  380 */     this.jPanel_Info.setLayout(this.borderLayout6);
/*  381 */     this.jPanel_Info.setPreferredSize(new Dimension(750, 465));
/*  382 */     this.jPanel_Fraun_w.setLayout(this.borderLayout7);
/*  383 */     this.jPanel_Fraun_w.setBorder(BorderFactory.createEtchedBorder());
/*  384 */     this.jPanel_Fraun_w.setPreferredSize(new Dimension(375, 465));
/*  385 */     this.jPanel_Fraun_c.setLayout(this.borderLayout8);
/*  386 */     this.jPanel_Fraun_c.setBorder(BorderFactory.createEtchedBorder());
/*  387 */     this.jPanel_Fraun_c.setPreferredSize(new Dimension(375, 465));
/*  388 */     this.jPanel_Fraun_w_n.setLayout(this.borderLayout9);
/*  389 */     this.jPanel_Fraun_w_n.setBackground(Color.black);
/*  390 */     this.jPanel_Fraun_w_n.setPreferredSize(new Dimension(375, 265));
/*  391 */     this.jPanel_Fraun_w_c.setLayout(this.flowLayout3);
/*  392 */     this.jPanel_Fraun_w_c.setPreferredSize(new Dimension(375, 210));
/*  393 */     this.jPanel_Fraun_w_n_n.setLayout(this.borderLayout10);
/*  394 */     this.jPanel_Fraun_w_n_c.setBackground(Color.black);
/*  395 */     this.jPanel_Fraun_w_n_c.setPreferredSize(new Dimension(256, 256));
/*  396 */     this.jPanel_Fraun_w_n_c.setLayout(this.borderLayout11);
/*  397 */     this.jPanel_Fraun_w_n_s.setLayout(this.borderLayout12);
/*  398 */     this.jPanel_Fraun_w_n_s.setPreferredSize(new Dimension(375, 5));
/*  399 */     this.jPanel_Fraun_w_n_n.setPreferredSize(new Dimension(375, 4));
/*  400 */     this.jPanel_Fraun_w_n_w.setLayout(this.borderLayout13);
/*  401 */     this.jPanel_Fraun_w_n_w.setPreferredSize(new Dimension(60, 256));
/*  402 */     this.jPanel_Fraun_w_n_e.setLayout(this.borderLayout14);
/*  403 */     this.jPanel_Fraun_w_n_e.setPreferredSize(new Dimension(59, 256));
/*  404 */     this.jPanel_Fraun_c_n.setPreferredSize(new Dimension(375, 265));
/*  405 */     this.jPanel_Fraun_c_n.setLayout(this.borderLayout15);
/*  406 */     this.jPanel_fraun_c_c.setLayout(this.flowLayout4);
/*  407 */     this.jPanel_fraun_c_c.setPreferredSize(new Dimension(375, 210));
/*  408 */     this.jPanel_Fraun_c_n_n.setLayout(this.borderLayout16);
/*  409 */     this.jPanel_Fraun_c_n_n.setPreferredSize(new Dimension(375, 5));
/*  410 */     this.jPanel_Fraun_c_n_c.setLayout(this.borderLayout17);
/*  411 */     this.jPanel_Fraun_c_n_c.setBackground(Color.black);
/*  412 */     this.jPanel_Fraun_c_n_c.setPreferredSize(new Dimension(256, 256));
/*  413 */     this.jPanel_Fraun_c_n_s.setLayout(this.borderLayout18);
/*  414 */     this.jPanel_Fraun_c_n_s.setPreferredSize(new Dimension(375, 4));
/*  415 */     this.jPanel_Fraun_c_n_w.setLayout(this.borderLayout19);
/*  416 */     this.jPanel_Fraun_c_n_w.setPreferredSize(new Dimension(59, 256));
/*  417 */     this.jPanel_Fraun_c_n_e.setLayout(this.borderLayout20);
/*  418 */     this.jPanel_Fraun_c_n_e.setPreferredSize(new Dimension(60, 256));
/*  419 */     this.jPanel_fres_w.setLayout(this.borderLayout21);
/*  420 */     this.jPanel_fres_w.setBorder(BorderFactory.createEtchedBorder());
/*  421 */     this.jPanel_fres_w.setPreferredSize(new Dimension(375, 465));
/*  422 */     this.jPanel_fres_c.setLayout(this.borderLayout22);
/*  423 */     this.jPanel_fres_c.setBorder(BorderFactory.createEtchedBorder());
/*  424 */     this.jPanel_fres_c.setPreferredSize(new Dimension(375, 465));
/*  425 */     this.jPanel_fres_w_n.setLayout(this.borderLayout23);
/*  426 */     this.jPanel_fres_w_n.setPreferredSize(new Dimension(375, 265));
/*  427 */     this.jPanel_fres_w_n.setBackground(Color.black);
/*  428 */     this.jPanel_fres_w_c.setLayout(this.flowLayout5);
/*  429 */     this.jPanel_fres_w_c.setPreferredSize(new Dimension(375, 210));
/*  430 */     this.jPanel_fres_w_n_n.setLayout(this.borderLayout25);
/*  431 */     this.jPanel_fres_w_n_n.setPreferredSize(new Dimension(375, 5));
/*  432 */     this.jPanel_fres_w_n_c.setLayout(this.borderLayout26);
/*  433 */     this.jPanel_fres_w_n_c.setPreferredSize(new Dimension(256, 256));
/*  434 */     this.jPanel_fres_w_n_c.setBackground(Color.black);
/*  435 */     this.jPanel_fres_w_n_s.setLayout(this.borderLayout27);
/*  436 */     this.jPanel_fres_w_n_s.setPreferredSize(new Dimension(375, 4));
/*  437 */     this.jPanel_fres_w_n_w.setLayout(this.borderLayout28);
/*  438 */     this.jPanel_fres_w_n_w.setPreferredSize(new Dimension(60, 256));
/*  439 */     this.jPanel_fres_w_n_e.setLayout(this.borderLayout29);
/*  440 */     this.jPanel_fres_w_n_e.setPreferredSize(new Dimension(59, 256));
/*  441 */     this.jPanel_fres_c_n.setLayout(this.borderLayout24);
/*  442 */     this.jPanel_fres_c_n.setPreferredSize(new Dimension(375, 265));
/*  443 */     this.jPanel_fres_c_c.setLayout(this.flowLayout6);
/*  444 */     this.jPanel_fres_c_c.setPreferredSize(new Dimension(375, 210));
/*  445 */     this.jPanel_fres_c_n_n.setLayout(this.borderLayout30);
/*  446 */     this.jPanel_fres_c_n_n.setPreferredSize(new Dimension(375, 5));
/*  447 */     this.jPanel_fres_c_n_c.setBackground(Color.black);
/*  448 */     this.jPanel_fres_c_n_c.setPreferredSize(new Dimension(256, 256));
/*  449 */     this.jPanel_fres_c_n_c.setBackground(Color.black);
/*  450 */     this.jPanel_fres_c_n_c.setLayout(this.borderLayout32);
/*  451 */     this.jPanel_fres_c_n_s.setLayout(this.borderLayout31);
/*  452 */     this.jPanel_fres_c_n_s.setPreferredSize(new Dimension(375, 4));
/*  453 */     this.jPanel_fres_c_n_w.setLayout(this.borderLayout33);
/*  454 */     this.jPanel_fres_c_n_w.setPreferredSize(new Dimension(59, 256));
/*  455 */     this.jPanel_fres_c_n_e.setLayout(this.borderLayout34);
/*  456 */     this.jPanel_fres_c_n_e.setPreferredSize(new Dimension(60, 256));
/*      */ 
/*  468 */     this.jLabel_fraun_param.setForeground(new Color(102, 102, 153));
/*  469 */     this.jLabel_fraun_param.setPreferredSize(new Dimension(365, 16));
/*  470 */     this.jLabel_fraun_param.setHorizontalAlignment(0);
/*  471 */     this.jLabel_fraun_param.setText(this.fraun_etiqueta[0][lang]);
/*  472 */     this.jLabel_fraun_longOnda.setForeground(new Color(102, 102, 153));
/*  473 */     this.jLabel_fraun_longOnda.setMinimumSize(new Dimension(120, 16));
/*  474 */     this.jLabel_fraun_longOnda.setPreferredSize(new Dimension(120, 16));
/*  475 */     this.jLabel_fraun_longOnda.setText(this.fraun_etiqueta[1][lang]);
/*  476 */     this.jSlider_fraun_longOnda.setMaximum(700);
/*  477 */     this.jSlider_fraun_longOnda.setMinimum(400);
/*  478 */     this.jSlider_fraun_longOnda.setPreferredSize(new Dimension(140, 16));
/*  479 */     this.jSlider_fraun_longOnda.addMouseMotionListener(new DifraccionApplet_jSlider_fraun_longOnda_mouseMotionAdapter(this));
/*  480 */     this.jSlider_fraun_longOnda.addMouseListener(new DifraccionApplet_jSlider_fraun_longOnda_mouseAdapter(this));
/*  481 */     this.jSlider_fraun_longOnda.addKeyListener(new DifraccionApplet_jSlider_fraun_longOnda_keyAdapter(this));
/*  482 */     this.jLabel_fraun_nlongOnda.setForeground(new Color(102, 102, 153));
/*  483 */     this.jLabel_fraun_nlongOnda.setMinimumSize(new Dimension(50, 16));
/*  484 */     this.jLabel_fraun_nlongOnda.setPreferredSize(new Dimension(60, 16));
/*  485 */     this.jLabel_fraun_nlongOnda.setText("400 nm");
/*  486 */     this.jLabel_fraun_distFocal.setForeground(new Color(102, 102, 153));
/*  487 */     this.jLabel_fraun_distFocal.setMinimumSize(new Dimension(120, 16));
/*  488 */     this.jLabel_fraun_distFocal.setPreferredSize(new Dimension(120, 16));
/*  489 */     this.jLabel_fraun_distFocal.setText(this.fraun_etiqueta[2][lang]);
/*  490 */     this.jSlider_fraun_distFocal.setMaximum(1000);
/*  491 */     this.jSlider_fraun_distFocal.setMinimum(500);
/*  492 */     this.jSlider_fraun_distFocal.setPreferredSize(new Dimension(140, 16));
/*  493 */     this.jSlider_fraun_distFocal.addMouseMotionListener(new DifraccionApplet_jSlider_fraun_distFocal_mouseMotionAdapter(this));
/*  494 */     this.jSlider_fraun_distFocal.addMouseListener(new DifraccionApplet_jSlider_fraun_distFocal_mouseAdapter(this));
/*  495 */     this.jSlider_fraun_distFocal.addKeyListener(new DifraccionApplet_jSlider_fraun_distFocal_keyAdapter(this));
/*  496 */     this.jLabel_fraun_ndistFocal.setForeground(new Color(102, 102, 153));
/*  497 */     this.jLabel_fraun_ndistFocal.setMinimumSize(new Dimension(50, 16));
/*  498 */     this.jLabel_fraun_ndistFocal.setPreferredSize(new Dimension(60, 16));
/*  499 */     this.jLabel_fraun_ndistFocal.setText("100 mm");
/*  500 */     this.jLabel_fraun_objeto.setForeground(new Color(102, 102, 153));
/*  501 */     this.jLabel_fraun_objeto.setMinimumSize(new Dimension(80, 16));
/*  502 */     this.jLabel_fraun_objeto.setPreferredSize(new Dimension(80, 16));
/*  503 */     this.jLabel_fraun_objeto.setText(this.fraun_etiqueta[3][lang]);
/*  504 */     this.jRadioButton_fraun_rectang.setForeground(new Color(102, 102, 153));
/*  505 */     this.jRadioButton_fraun_rectang.setText(this.fraun_etiqueta[4][lang]);
/*  506 */     this.jRadioButton_fraun_rectang.setSelected(true);
/*  507 */     this.jRadioButton_fraun_rectang.addActionListener(new DifraccionApplet_jRadioButton_fraun_rectang_actionAdapter(this));
/*  508 */     this.jRadioButton_fraun_circ.setForeground(new Color(102, 102, 153));
/*  509 */     this.jRadioButton_fraun_circ.setPreferredSize(new Dimension(75, 24));
/*  510 */     this.jRadioButton_fraun_circ.setText(this.fraun_etiqueta[5][lang]);
/*  511 */     this.jRadioButton_fraun_circ.addActionListener(new DifraccionApplet_jRadioButton_fraun_circ_actionAdapter(this));
/*  512 */     this.jRadioButton_fraun_rend.setForeground(new Color(102, 102, 153));
/*  513 */     this.jRadioButton_fraun_rend.setMinimumSize(new Dimension(75, 24));
/*  514 */     this.jRadioButton_fraun_rend.setPreferredSize(new Dimension(75, 24));
/*  515 */     this.jRadioButton_fraun_rend.setText(this.fraun_etiqueta[6][lang]);
/*  516 */     this.jRadioButton_fraun_rend.addActionListener(new DifraccionApplet_jRadioButton_fraun_rend_actionAdapter(this));
/*  517 */     this.jPanel_fraun_dimObjeto.setPreferredSize(new Dimension(375, 50));
/*  518 */     this.jPanel_fraun_dimObjeto.setLayout(this.flowLayout7);
/*  519 */     this.jLabel_fraun_dimx.setForeground(new Color(102, 102, 153));
/*  520 */     this.jLabel_fraun_dimx.setMinimumSize(new Dimension(120, 16));
/*  521 */     this.jLabel_fraun_dimx.setPreferredSize(new Dimension(120, 16));
/*  522 */     this.jLabel_fraun_dimx.setText(this.fraun_etiqueta[7][lang]);
/*  523 */     this.jSlider_fraun_dimx.setMaximum(30);
/*  524 */     this.jSlider_fraun_dimx.setMinimum(5);
/*  525 */     this.jSlider_fraun_dimx.setPreferredSize(new Dimension(150, 16));
/*  526 */     this.jSlider_fraun_dimx.addMouseMotionListener(new DifraccionApplet_jSlider_fraun_dimx_mouseMotionAdapter(this));
/*  527 */     this.jSlider_fraun_dimx.addMouseListener(new DifraccionApplet_jSlider_fraun_dimx_mouseAdapter(this));
/*  528 */     this.jSlider_fraun_dimx.addKeyListener(new DifraccionApplet_jSlider_fraun_dimx_keyAdapter(this));
/*  529 */     this.jLabel_fraun_ndimx.setForeground(new Color(102, 102, 153));
/*  530 */     this.jLabel_fraun_ndimx.setMinimumSize(new Dimension(50, 16));
/*  531 */     this.jLabel_fraun_ndimx.setPreferredSize(new Dimension(50, 16));
/*  532 */     this.jLabel_fraun_ndimx.setText("0.5 mm");
/*  533 */     this.jLabel_fraun_dimy.setForeground(new Color(102, 102, 153));
/*  534 */     this.jLabel_fraun_dimy.setMinimumSize(new Dimension(120, 16));
/*  535 */     this.jLabel_fraun_dimy.setPreferredSize(new Dimension(120, 16));
/*  536 */     this.jLabel_fraun_dimy.setText(this.fraun_etiqueta[8][lang]);
/*  537 */     this.jSlider_fraun_dimy.setMaximum(30);
/*  538 */     this.jSlider_fraun_dimy.setMinimum(5);
/*  539 */     this.jSlider_fraun_dimy.setPreferredSize(new Dimension(150, 16));
/*  540 */     this.jSlider_fraun_dimy.addMouseMotionListener(new DifraccionApplet_jSlider_fraun_dimy_mouseMotionAdapter(this));
/*  541 */     this.jSlider_fraun_dimy.addMouseListener(new DifraccionApplet_jSlider_fraun_dimy_mouseAdapter(this));
/*  542 */     this.jSlider_fraun_dimy.addKeyListener(new DifraccionApplet_jSlider_fraun_dimy_keyAdapter(this));
/*  543 */     this.jLabel_fraun_ndimy.setForeground(new Color(102, 102, 153));
/*  544 */     this.jLabel_fraun_ndimy.setPreferredSize(new Dimension(50, 16));
/*  545 */     this.jLabel_fraun_ndimy.setText("0.5 mm");
/*      */ 
/*  554 */     this.jLabel_fraun_nObjetos.setForeground(new Color(102, 102, 153));
/*  555 */     this.jLabel_fraun_nObjetos.setMinimumSize(new Dimension(120, 16));
/*  556 */     this.jLabel_fraun_nObjetos.setPreferredSize(new Dimension(120, 16));
/*  557 */     this.jLabel_fraun_nObjetos.setText(this.fraun_etiqueta[9][lang]);
/*      */ 
/*  574 */     this.jSlider_fraun_nobjetos.setMaximum(10);
/*  575 */     this.jSlider_fraun_nobjetos.setMinimum(1);
/*  576 */     this.jSlider_fraun_nobjetos.setPreferredSize(new Dimension(150, 16));
/*  577 */     this.jSlider_fraun_nobjetos.addKeyListener(new DifraccionApplet_jSlider_fraun_nobjetos_keyAdapter(this));
/*  578 */     this.jSlider_fraun_nobjetos.addMouseMotionListener(new DifraccionApplet_jSlider_fraun_nobjetos_mouseMotionAdapter(this));
/*  579 */     this.jSlider_fraun_nobjetos.addMouseListener(new DifraccionApplet_jSlider_fraun_nobjetos_mouseAdapter(this));
/*  580 */     this.jLabel_fraun_numobj.setForeground(new Color(102, 102, 153));
/*  581 */     this.jLabel_fraun_numobj.setMaximumSize(new Dimension(50, 16));
/*  582 */     this.jLabel_fraun_numobj.setMinimumSize(new Dimension(50, 16));
/*  583 */     this.jLabel_fraun_numobj.setPreferredSize(new Dimension(50, 16));
/*  584 */     this.jLabel_fraun_numobj.setText("1");
/*  585 */     this.jLabel_fraun_periodo.setForeground(new Color(102, 102, 153));
/*  586 */     this.jLabel_fraun_periodo.setMaximumSize(new Dimension(375, 16));
/*  587 */     this.jLabel_fraun_periodo.setMinimumSize(new Dimension(100, 16));
/*  588 */     this.jLabel_fraun_periodo.setPreferredSize(new Dimension(300, 16));
/*  589 */     this.jLabel_fraun_periodo.setText(this.fraun_etiqueta[10][lang] + " xx mm");
/*  590 */     this.jLabel_fraun_dimimag.setForeground(new Color(102, 102, 153));
/*  591 */     this.jLabel_fraun_dimimag.setMaximumSize(new Dimension(375, 16));
/*  592 */     this.jLabel_fraun_dimimag.setMinimumSize(new Dimension(300, 16));
/*  593 */     this.jLabel_fraun_dimimag.setPreferredSize(new Dimension(300, 16));
/*  594 */     this.jLabel_fraun_dimimag.setText(this.fraun_etiqueta[11][lang] + " xx mm");
/*  595 */     this.objetoFraunhofer.setBackground(Color.black);
/*  596 */     this.jSplitPane_Fraun.setBackground(Color.black);
/*  597 */     this.jSplitPane_Fraun.setContinuousLayout(true);
/*  598 */     this.jSplitPane_Fraun.setOneTouchExpandable(false);
/*  599 */     this.jSplitPane_Fraun.setDividerLocation(0);
/*  600 */     this.jSplitPane_Fraun.setDividerSize(0);
/*      */ 
/*  602 */     this.jLabel_fraun_umbral.setForeground(new Color(102, 102, 153));
/*  603 */     this.jLabel_fraun_umbral.setMinimumSize(new Dimension(80, 16));
/*  604 */     this.jLabel_fraun_umbral.setPreferredSize(new Dimension(80, 16));
/*  605 */     this.jLabel_fraun_umbral.setText(this.fraun_etiqueta[12][lang]);
/*  606 */     this.jSlider_fraun_umbral.setPreferredSize(new Dimension(100, 16));
/*  607 */     this.jSlider_fraun_umbral.addKeyListener(new DifraccionApplet_jSlider_fraun_umbral_keyAdapter(this));
/*  608 */     this.jSlider_fraun_umbral.addMouseMotionListener(new DifraccionApplet_jSlider_fraun_umbral_mouseMotionAdapter(this));
/*  609 */     this.jSlider_fraun_umbral.addMouseListener(new DifraccionApplet_jSlider_fraun_umbral_mouseAdapter(this));
/*  610 */     this.jLabel_fraun_numbral.setForeground(new Color(102, 102, 153));
/*  611 */     this.jLabel_fraun_numbral.setMinimumSize(new Dimension(50, 16));
/*  612 */     this.jLabel_fraun_numbral.setPreferredSize(new Dimension(50, 16));
/*  613 */     this.jLabel_fraun_numbral.setText("100 %");
/*  614 */     this.jLabel_fraun_show.setForeground(new Color(102, 102, 153));
/*  615 */     this.jLabel_fraun_show.setMinimumSize(new Dimension(55, 16));
/*  616 */     this.jLabel_fraun_show.setPreferredSize(new Dimension(55, 16));
/*  617 */     this.jLabel_fraun_show.setText(this.fraun_etiqueta[13][lang]);
/*  618 */     this.jRadioButton_fraun_showimg.setForeground(new Color(102, 102, 153));
/*  619 */     this.jRadioButton_fraun_showimg.setMaximumSize(new Dimension(95, 24));
/*  620 */     this.jRadioButton_fraun_showimg.setMinimumSize(new Dimension(75, 24));
/*  621 */     this.jRadioButton_fraun_showimg.setPreferredSize(new Dimension(75, 24));
/*  622 */     this.jRadioButton_fraun_showimg.setText(this.fraun_etiqueta[14][lang]);
/*  623 */     this.jRadioButton_fraun_showimg.setSelected(true);
/*  624 */     this.jRadioButton_fraun_showimg.addActionListener(new DifraccionApplet_jRadioButton_fraun_showimg_actionAdapter(this));
/*  625 */     this.jRadioButton_fraun_showperf.setForeground(new Color(102, 102, 153));
/*  626 */     this.jRadioButton_fraun_showperf.setMinimumSize(new Dimension(130, 24));
/*  627 */     this.jRadioButton_fraun_showperf.setPreferredSize(new Dimension(130, 24));
/*  628 */     this.jRadioButton_fraun_showperf.setText(this.fraun_etiqueta[15][lang]);
/*  629 */     this.jRadioButton_fraun_showperf.addActionListener(new DifraccionApplet_jRadioButton_fraun_showperf_actionAdapter(this));
/*  630 */     this.jLabel_fraun_tipoimg.setForeground(new Color(102, 102, 153));
/*  631 */     this.jLabel_fraun_tipoimg.setMaximumSize(new Dimension(75, 16));
/*  632 */     this.jLabel_fraun_tipoimg.setMinimumSize(new Dimension(75, 16));
/*  633 */     this.jLabel_fraun_tipoimg.setPreferredSize(new Dimension(50, 16));
/*  634 */     this.jLabel_fraun_tipoimg.setText(this.fraun_etiqueta[14][lang] + ":");
/*  635 */     this.jRadioButton_fraun_tipoimg_amp.setForeground(new Color(102, 102, 153));
/*  636 */     this.jRadioButton_fraun_tipoimg_amp.setText(this.fraun_etiqueta[16][lang]);
/*  637 */     this.jRadioButton_fraun_tipoimg_amp.addActionListener(new DifraccionApplet_jRadioButton_fraun_tipoimg_amp_actionAdapter(this));
/*  638 */     this.jRadioButton_fraun_tipoimg_int.setForeground(new Color(102, 102, 153));
/*  639 */     this.jRadioButton_fraun_tipoimg_int.setText(this.fraun_etiqueta[17][lang]);
/*  640 */     this.jRadioButton_fraun_tipoimg_int.setSelected(true);
/*  641 */     this.jRadioButton_fraun_tipoimg_int.addActionListener(new DifraccionApplet_jRadioButton_fraun_tipoimg_int_actionAdapter(this));
/*  642 */     this.jRadioButton_fraun_tipoimg_intlog.setForeground(new Color(102, 102, 153));
/*  643 */     this.jRadioButton_fraun_tipoimg_intlog.setText(this.fraun_etiqueta[18][lang]);
/*  644 */     this.jRadioButton_fraun_tipoimg_intlog.addActionListener(new DifraccionApplet_jRadioButton_fraun_tipoimg_intlog_actionAdapter(this));
/*  645 */     this.jLabel_fraun_tamdiff.setForeground(new Color(102, 102, 153));
/*  646 */     this.jLabel_fraun_tamdiff.setMinimumSize(new Dimension(300, 16));
/*  647 */     this.jLabel_fraun_tamdiff.setPreferredSize(new Dimension(300, 16));
/*  648 */     this.jLabel_fraun_tamdiff.setText(this.fraun_etiqueta[19][lang] + " xx mm");
/*  649 */     this.jLabel_fraun_distmindif.setForeground(new Color(102, 102, 153));
/*  650 */     this.jLabel_fraun_distmindif.setMinimumSize(new Dimension(300, 16));
/*  651 */     this.jLabel_fraun_distmindif.setPreferredSize(new Dimension(300, 16));
/*  652 */     this.jLabel_fraun_distmindif.setText(this.fraun_etiqueta[20][lang] + " xx mm");
/*  653 */     this.jLabel_fraun_distnmax.setForeground(new Color(102, 102, 153));
/*  654 */     this.jLabel_fraun_distnmax.setMinimumSize(new Dimension(300, 16));
/*  655 */     this.jLabel_fraun_distnmax.setPreferredSize(new Dimension(300, 16));
/*  656 */     this.jLabel_fraun_distnmax.setText(this.fraun_etiqueta[21][lang] + " xx mm");
/*  657 */     this.jLabel_fraun_distnmin.setForeground(new Color(102, 102, 153));
/*  658 */     this.jLabel_fraun_distnmin.setMinimumSize(new Dimension(300, 16));
/*  659 */     this.jLabel_fraun_distnmin.setPreferredSize(new Dimension(300, 16));
/*  660 */     this.jLabel_fraun_distnmin.setText(this.fraun_etiqueta[22][lang] + " xx mm");
/*  661 */     this.jToggleButton_fraun_zoom.setForeground(new Color(102, 102, 153));
/*  662 */     this.jToggleButton_fraun_zoom.setMinimumSize(new Dimension(65, 15));
/*  663 */     this.jToggleButton_fraun_zoom.setPreferredSize(new Dimension(70, 15));
/*  664 */     this.jToggleButton_fraun_zoom.setText("Zoom");
/*  665 */     this.jToggleButton_fraun_zoom.addActionListener(new DifraccionApplet_jToggleButton_fraun_zoom_actionAdapter(this));
/*  666 */     this.jPanel_fraun_showimg.setLayout(this.flowLayout8);
/*  667 */     this.jPanel_fraun_showimg.setMinimumSize(new Dimension(375, 30));
/*  668 */     this.jPanel_fraun_showimg.setPreferredSize(new Dimension(375, 30));
/*      */ 
/*  670 */     this.jLabel_fres_param.setForeground(new Color(102, 102, 153));
/*  671 */     this.jLabel_fres_param.setPreferredSize(new Dimension(365, 16));
/*  672 */     this.jLabel_fres_param.setHorizontalAlignment(0);
/*  673 */     this.jLabel_fres_param.setText(this.fraun_etiqueta[0][lang]);
/*  674 */     this.jLabel_fres_longOnda.setForeground(new Color(102, 102, 153));
/*  675 */     this.jLabel_fres_longOnda.setMinimumSize(new Dimension(120, 16));
/*  676 */     this.jLabel_fres_longOnda.setPreferredSize(new Dimension(120, 16));
/*  677 */     this.jLabel_fres_longOnda.setText(this.fraun_etiqueta[1][lang]);
/*  678 */     this.jSlider_fres_longOnda.setMaximum(700);
/*  679 */     this.jSlider_fres_longOnda.setMinimum(400);
/*  680 */     this.jSlider_fres_longOnda.setPreferredSize(new Dimension(140, 16));
/*  681 */     this.jSlider_fres_longOnda.addMouseMotionListener(new DifraccionApplet_jSlider_fres_longOnda_mouseMotionAdapter(this));
/*  682 */     this.jSlider_fres_longOnda.addMouseListener(new DifraccionApplet_jSlider_fres_longOnda_mouseAdapter(this));
/*  683 */     this.jSlider_fres_longOnda.addKeyListener(new DifraccionApplet_jSlider_fres_longOnda_keyAdapter(this));
/*  684 */     this.jLabel_fres_nlongOnda.setForeground(new Color(102, 102, 153));
/*  685 */     this.jLabel_fres_nlongOnda.setMinimumSize(new Dimension(50, 16));
/*  686 */     this.jLabel_fres_nlongOnda.setPreferredSize(new Dimension(60, 16));
/*  687 */     this.jLabel_fres_nlongOnda.setText("400 nm");
/*  688 */     this.jLabel_fres_distProp.setForeground(new Color(102, 102, 153));
/*  689 */     this.jLabel_fres_distProp.setMinimumSize(new Dimension(120, 16));
/*  690 */     this.jLabel_fres_distProp.setPreferredSize(new Dimension(120, 16));
/*  691 */     this.jLabel_fres_distProp.setText(this.fres_etiqueta[1][lang]);
/*  692 */     this.jSlider_fres_distProp.setMaximum(1000);
/*  693 */     this.jSlider_fres_distProp.setMinimum(100);
/*  694 */     this.jSlider_fres_distProp.setPreferredSize(new Dimension(140, 16));
/*  695 */     this.jSlider_fres_distProp.addMouseMotionListener(new DifraccionApplet_jSlider_fres_distProp_mouseMotionAdapter(this));
/*  696 */     this.jSlider_fres_distProp.addMouseListener(new DifraccionApplet_jSlider_fres_distProp_mouseAdapter(this));
/*  697 */     this.jSlider_fres_distProp.addKeyListener(new DifraccionApplet_jSlider_fres_distProp_keyAdapter(this));
/*  698 */     this.jLabel_fres_ndistProp.setForeground(new Color(102, 102, 153));
/*  699 */     this.jLabel_fres_ndistProp.setMinimumSize(new Dimension(50, 16));
/*  700 */     this.jLabel_fres_ndistProp.setPreferredSize(new Dimension(60, 16));
/*  701 */     this.jLabel_fres_ndistProp.setText("100 mm");
/*  702 */     this.jLabel_fres_objeto.setForeground(new Color(102, 102, 153));
/*  703 */     this.jLabel_fres_objeto.setMinimumSize(new Dimension(80, 16));
/*  704 */     this.jLabel_fres_objeto.setPreferredSize(new Dimension(80, 16));
/*  705 */     this.jLabel_fres_objeto.setText(this.fraun_etiqueta[3][lang]);
/*  706 */     this.jRadioButton_fres_rectang.setForeground(new Color(102, 102, 153));
/*  707 */     this.jRadioButton_fres_rectang.setPreferredSize(new Dimension(120, 24));
/*  708 */     this.jRadioButton_fres_rectang.setText(this.fraun_etiqueta[4][lang]);
/*  709 */     this.jRadioButton_fres_rectang.setSelected(true);
/*  710 */     this.jRadioButton_fres_rectang.addActionListener(new DifraccionApplet_jRadioButton_fres_rectang_actionAdapter(this));
/*  711 */     this.jRadioButton_fres_circ.setForeground(new Color(102, 102, 153));
/*  712 */     this.jRadioButton_fres_circ.setPreferredSize(new Dimension(120, 24));
/*  713 */     this.jRadioButton_fres_circ.setText(this.fraun_etiqueta[5][lang]);
/*  714 */     this.jRadioButton_fres_circ.addActionListener(new DifraccionApplet_jRadioButton_fres_circ_actionAdapter(this));
/*  715 */     this.jRadioButton_fres_rend.setForeground(new Color(102, 102, 153));
/*  716 */     this.jRadioButton_fres_rend.setPreferredSize(new Dimension(120, 24));
/*  717 */     this.jRadioButton_fres_rend.setText(this.fraun_etiqueta[6][lang]);
/*  718 */     this.jRadioButton_fres_rend.addActionListener(new DifraccionApplet_jRadioButton_fres_rend_actionAdapter(this));
/*  719 */     this.jRadioButton_fres_semip.setForeground(new Color(102, 102, 153));
/*  720 */     this.jRadioButton_fres_semip.setMinimumSize(new Dimension(75, 24));
/*  721 */     this.jRadioButton_fres_semip.setPreferredSize(new Dimension(120, 24));
/*  722 */     this.jRadioButton_fres_semip.setText(this.fres_etiqueta[0][lang]);
/*  723 */     this.jRadioButton_fres_semip.addActionListener(new DifraccionApplet_jRadioButton_fres_semip_actionAdapter(this));
/*  724 */     this.jLabel_fres_nada.setPreferredSize(new Dimension(80, 0));
/*  725 */     this.jLabel_fres_nada.setText(" ");
/*  726 */     this.jPanel_fres_dimObjeto.setPreferredSize(new Dimension(375, 50));
/*  727 */     this.jPanel_fres_dimObjeto.setLayout(this.flowLayoutx7);
/*  728 */     this.jLabel_fres_dimx.setForeground(new Color(102, 102, 153));
/*  729 */     this.jLabel_fres_dimx.setMinimumSize(new Dimension(120, 16));
/*  730 */     this.jLabel_fres_dimx.setPreferredSize(new Dimension(120, 16));
/*  731 */     this.jLabel_fres_dimx.setText(this.fraun_etiqueta[7][lang]);
/*  732 */     this.jSlider_fres_dimx.setMaximum(30);
/*  733 */     this.jSlider_fres_dimx.setMinimum(5);
/*  734 */     this.jSlider_fres_dimx.setPreferredSize(new Dimension(150, 16));
/*  735 */     this.jSlider_fres_dimx.addMouseMotionListener(new DifraccionApplet_jSlider_fres_dimx_mouseMotionAdapter(this));
/*  736 */     this.jSlider_fres_dimx.addMouseListener(new DifraccionApplet_jSlider_fres_dimx_mouseAdapter(this));
/*  737 */     this.jSlider_fres_dimx.addKeyListener(new DifraccionApplet_jSlider_fres_dimx_keyAdapter(this));
/*  738 */     this.jLabel_fres_ndimx.setForeground(new Color(102, 102, 153));
/*  739 */     this.jLabel_fres_ndimx.setMinimumSize(new Dimension(50, 16));
/*  740 */     this.jLabel_fres_ndimx.setPreferredSize(new Dimension(50, 16));
/*  741 */     this.jLabel_fres_ndimx.setText("0.5 mm");
/*  742 */     this.jLabel_fres_dimy.setForeground(new Color(102, 102, 153));
/*  743 */     this.jLabel_fres_dimy.setMinimumSize(new Dimension(120, 16));
/*  744 */     this.jLabel_fres_dimy.setPreferredSize(new Dimension(120, 16));
/*  745 */     this.jLabel_fres_dimy.setText(this.fraun_etiqueta[8][lang]);
/*  746 */     this.jSlider_fres_dimy.setMaximum(30);
/*  747 */     this.jSlider_fres_dimy.setMinimum(5);
/*  748 */     this.jSlider_fres_dimy.setPreferredSize(new Dimension(150, 16));
/*  749 */     this.jSlider_fres_dimy.addMouseMotionListener(new DifraccionApplet_jSlider_fres_dimy_mouseMotionAdapter(this));
/*  750 */     this.jSlider_fres_dimy.addMouseListener(new DifraccionApplet_jSlider_fres_dimy_mouseAdapter(this));
/*  751 */     this.jSlider_fres_dimy.addKeyListener(new DifraccionApplet_jSlider_fres_dimy_keyAdapter(this));
/*  752 */     this.jLabel_fres_ndimy.setForeground(new Color(102, 102, 153));
/*  753 */     this.jLabel_fres_ndimy.setPreferredSize(new Dimension(50, 16));
/*  754 */     this.jLabel_fres_ndimy.setText("0.5 mm");
/*  755 */     this.jButton_fres_calcdif.setPreferredSize(new Dimension(150, 26));
/*  756 */     this.jButton_fres_calcdif.setText(this.fres_etiqueta[2][lang]);
/*  757 */     this.jButton_fres_calcdif.addActionListener(new DifraccionApplet_jButton_fres_calcdif_actionAdapter(this));
/*  758 */     this.jSplitPane_fres.setBackground(Color.black);
/*  759 */     this.jSplitPane_fres.setContinuousLayout(true);
/*  760 */     this.jSplitPane_fres.setOneTouchExpandable(false);
/*  761 */     this.jSplitPane_fres.setDividerLocation(0);
/*  762 */     this.jSplitPane_fres.setDividerSize(0);
/*  763 */     this.objetoFresnel.setBackground(Color.black);
/*      */ 
/*  765 */     this.jLabel_fres_dimimag.setForeground(new Color(102, 102, 153));
/*  766 */     this.jLabel_fres_dimimag.setMaximumSize(new Dimension(375, 16));
/*  767 */     this.jLabel_fres_dimimag.setMinimumSize(new Dimension(300, 16));
/*  768 */     this.jLabel_fres_dimimag.setPreferredSize(new Dimension(300, 16));
/*  769 */     this.jLabel_fres_dimimag.setText(this.fraun_etiqueta[11][lang] + " xx mm");
/*  770 */     this.jLabel_fres_umbral.setForeground(new Color(102, 102, 153));
/*  771 */     this.jLabel_fres_umbral.setMinimumSize(new Dimension(80, 16));
/*  772 */     this.jLabel_fres_umbral.setPreferredSize(new Dimension(80, 16));
/*  773 */     this.jLabel_fres_umbral.setText(this.fraun_etiqueta[12][lang]);
/*  774 */     this.jSlider_fres_umbral.setPreferredSize(new Dimension(100, 16));
/*  775 */     this.jSlider_fres_umbral.addKeyListener(new DifraccionApplet_jSlider_fres_umbral_keyAdapter(this));
/*  776 */     this.jSlider_fres_umbral.addMouseMotionListener(new DifraccionApplet_jSlider_fres_umbral_mouseMotionAdapter(this));
/*  777 */     this.jSlider_fres_umbral.addMouseListener(new DifraccionApplet_jSlider_fres_umbral_mouseAdapter(this));
/*  778 */     this.jLabel_fres_numbral.setForeground(new Color(102, 102, 153));
/*  779 */     this.jLabel_fres_numbral.setMinimumSize(new Dimension(50, 16));
/*  780 */     this.jLabel_fres_numbral.setPreferredSize(new Dimension(50, 16));
/*  781 */     this.jLabel_fres_numbral.setText("100 %");
/*  782 */     this.jLabel_fres_show.setForeground(new Color(102, 102, 153));
/*  783 */     this.jLabel_fres_show.setMinimumSize(new Dimension(75, 16));
/*  784 */     this.jLabel_fres_show.setPreferredSize(new Dimension(75, 16));
/*  785 */     this.jLabel_fres_show.setText(this.fraun_etiqueta[13][lang]);
/*  786 */     this.jRadioButton_fres_showimg.setForeground(new Color(102, 102, 153));
/*  787 */     this.jRadioButton_fres_showimg.setMaximumSize(new Dimension(95, 24));
/*  788 */     this.jRadioButton_fres_showimg.setMinimumSize(new Dimension(75, 24));
/*  789 */     this.jRadioButton_fres_showimg.setPreferredSize(new Dimension(75, 24));
/*  790 */     this.jRadioButton_fres_showimg.setText(this.fraun_etiqueta[14][lang]);
/*  791 */     this.jRadioButton_fres_showimg.setSelected(true);
/*  792 */     this.jRadioButton_fres_showimg.addActionListener(new DifraccionApplet_jRadioButton_fres_showimg_actionAdapter(this));
/*  793 */     this.jRadioButton_fres_showperf.setForeground(new Color(102, 102, 153));
/*  794 */     this.jRadioButton_fres_showperf.setMinimumSize(new Dimension(130, 24));
/*  795 */     this.jRadioButton_fres_showperf.setPreferredSize(new Dimension(130, 24));
/*  796 */     this.jRadioButton_fres_showperf.setText(this.fraun_etiqueta[15][lang]);
/*  797 */     this.jRadioButton_fres_showperf.addActionListener(new DifraccionApplet_jRadioButton_fres_showperf_actionAdapter(this));
/*  798 */     this.jLabel_fres_tipoimg.setForeground(new Color(102, 102, 153));
/*  799 */     this.jLabel_fres_tipoimg.setMaximumSize(new Dimension(75, 16));
/*  800 */     this.jLabel_fres_tipoimg.setMinimumSize(new Dimension(50, 16));
/*  801 */     this.jLabel_fres_tipoimg.setPreferredSize(new Dimension(50, 16));
/*  802 */     this.jLabel_fres_tipoimg.setText(this.fraun_etiqueta[14][lang] + ":");
/*  803 */     this.jRadioButton_fres_tipoimg_amp.setForeground(new Color(102, 102, 153));
/*  804 */     this.jRadioButton_fres_tipoimg_amp.setText(this.fraun_etiqueta[16][lang]);
/*  805 */     this.jRadioButton_fres_tipoimg_amp.addActionListener(new DifraccionApplet_jRadioButton_fres_tipoimg_amp_actionAdapter(this));
/*  806 */     this.jRadioButton_fres_tipoimg_int.setForeground(new Color(102, 102, 153));
/*  807 */     this.jRadioButton_fres_tipoimg_int.setText(this.fraun_etiqueta[17][lang]);
/*  808 */     this.jRadioButton_fres_tipoimg_int.setSelected(true);
/*  809 */     this.jRadioButton_fres_tipoimg_int.addActionListener(new DifraccionApplet_jRadioButton_fres_tipoimg_int_actionAdapter(this));
/*  810 */     this.jRadioButton_fres_tipoimg_intlog.setForeground(new Color(102, 102, 153));
/*  811 */     this.jRadioButton_fres_tipoimg_intlog.setText(this.fraun_etiqueta[18][lang]);
/*  812 */     this.jRadioButton_fres_tipoimg_intlog.addActionListener(new DifraccionApplet_jRadioButton_fres_tipoimg_intlog_actionAdapter(this));
/*  813 */     this.jLabel_fres_tamdiff.setForeground(new Color(102, 102, 153));
/*  814 */     this.jLabel_fres_tamdiff.setMinimumSize(new Dimension(300, 16));
/*  815 */     this.jLabel_fres_tamdiff.setPreferredSize(new Dimension(300, 16));
/*  816 */     this.jLabel_fres_tamdiff.setText(this.fraun_etiqueta[19][lang] + " xx mm");
/*  817 */     this.jPanel_fres_showimg.setLayout(this.flowLayoutx8);
/*  818 */     this.jPanel_fres_showimg.setMinimumSize(new Dimension(375, 30));
/*  819 */     this.jPanel_fres_showimg.setPreferredSize(new Dimension(375, 30));
/*      */ 
/*  822 */     this.jLabel_fres_nada2.setPreferredSize(new Dimension(350, 16));
/*  823 */     this.jLabel_fres_nada2.setText(" ");
/*  824 */     this.jTextPane_teoria.setBackground(new Color(204, 204, 204));
/*  825 */     this.jTextPane_teoria.setText("");
/*  826 */     add(this.jPanel_Base, "Center");
/*  827 */     this.jPanel_Base.add(this.jPanel_Norte, "North");
/*  828 */     this.jPanel_Base.add(this.jPanel_Centro, "Center");
/*  829 */     this.jPanel_Centro.add(this.jTabbedPane1, "Center");
/*  830 */     this.jTabbedPane1.add(this.jPanel_Fresnel, "Fresnel");
/*  831 */     this.jPanel_Fresnel.add(this.jPanel_fres_w, "West");
/*  832 */     this.jTabbedPane1.add(this.jPanel_Fraunhofer, "Fraunhofer");
/*  833 */     this.jPanel_Fraunhofer.add(this.jPanel_Fraun_w, "West");
/*  834 */     this.jPanel_Fraun_w.add(this.jPanel_Fraun_w_n, "North");
/*  835 */     this.jTabbedPane1.add(this.jPanel_Info, this.info_etiqueta[lang]);
/*  836 */     this.jPanel_Info.add(this.jScrollPane_teoria, "Center");
/*  837 */     this.jPanel_Base.add(this.jPanel_Sur, "South");
/*  838 */     this.jPanel_Sur.add(this.jButton_Acercade, null);
/*  839 */     this.jPanel_Sur.add(this.jButton_Salir, null);
/*  840 */     this.jPanel_Fraunhofer.add(this.jPanel_Fraun_c, "Center");
/*  841 */     this.jPanel_Fraun_c.add(this.jPanel_Fraun_c_n, "North");
/*  842 */     this.jPanel_Fraun_w.add(this.jPanel_Fraun_w_c, "Center");
/*  843 */     this.jPanel_Fraun_w_c.add(this.jLabel_fraun_param, null);
/*  844 */     this.jPanel_Fraun_w_n.add(this.jPanel_Fraun_w_n_n, "South");
/*  845 */     this.jPanel_Fraun_w_n.add(this.jPanel_Fraun_w_n_c, "Center");
/*  846 */     this.jPanel_Fraun_w_n.add(this.jPanel_Fraun_w_n_s, "North");
/*  847 */     this.jPanel_Fraun_w_n.add(this.jPanel_Fraun_w_n_w, "West");
/*  848 */     this.jPanel_Fraun_w_n.add(this.jPanel_Fraun_w_n_e, "East");
/*  849 */     this.jPanel_Fraun_c.add(this.jPanel_fraun_c_c, "Center");
/*      */ 
/*  851 */     this.jPanel_Fraun_c_n.add(this.jPanel_Fraun_c_n_n, "North");
/*  852 */     this.jPanel_Fraun_c_n.add(this.jPanel_Fraun_c_n_c, "Center");
/*  853 */     this.jPanel_Fraun_c_n_c.add(this.jSplitPane_Fraun, "Center");
/*  854 */     this.jPanel_Fraun_c_n.add(this.jPanel_Fraun_c_n_s, "South");
/*  855 */     this.jPanel_Fraun_c_n.add(this.jPanel_Fraun_c_n_w, "West");
/*  856 */     this.jPanel_Fraun_c_n.add(this.jPanel_Fraun_c_n_e, "East");
/*  857 */     this.jPanel_Fresnel.add(this.jPanel_fres_c, "Center");
/*  858 */     this.jPanel_fres_w.add(this.jPanel_fres_w_n, "North");
/*  859 */     this.jPanel_fres_w.add(this.jPanel_fres_w_c, "Center");
/*  860 */     this.jPanel_fres_w_n.add(this.jPanel_fres_w_n_n, "North");
/*  861 */     this.jPanel_fres_w_n.add(this.jPanel_fres_w_n_c, "Center");
/*  862 */     this.jPanel_fres_w_n.add(this.jPanel_fres_w_n_s, "South");
/*  863 */     this.jPanel_fres_w_n.add(this.jPanel_fres_w_n_w, "West");
/*  864 */     this.jPanel_fres_w_n.add(this.jPanel_fres_w_n_e, "East");
/*  865 */     this.jPanel_fres_c.add(this.jPanel_fres_c_n, "North");
/*  866 */     this.jPanel_fres_c.add(this.jPanel_fres_c_c, "Center");
/*  867 */     this.jPanel_fres_c_n.add(this.jPanel_fres_c_n_n, "North");
/*  868 */     this.jPanel_fres_c_n.add(this.jPanel_fres_c_n_c, "Center");
/*  869 */     this.jPanel_fres_c_n.add(this.jPanel_fres_c_n_s, "South");
/*  870 */     this.jPanel_fres_c_n.add(this.jPanel_fres_c_n_w, "West");
/*  871 */     this.jPanel_fres_c_n.add(this.jPanel_fres_c_n_e, "East");
/*      */ 
/*  873 */     this.jPanel_Fraun_w_c.add(this.jLabel_fraun_longOnda, null);
/*  874 */     this.jPanel_Fraun_w_c.add(this.jSlider_fraun_longOnda, null);
/*  875 */     this.jPanel_Fraun_w_c.add(this.jLabel_fraun_nlongOnda, null);
/*  876 */     this.jPanel_Fraun_w_c.add(this.jLabel_fraun_distFocal, null);
/*  877 */     this.jPanel_Fraun_w_c.add(this.jSlider_fraun_distFocal, null);
/*  878 */     this.jPanel_Fraun_w_c.add(this.jLabel_fraun_ndistFocal, null);
/*  879 */     this.jPanel_Fraun_w_c.add(this.jLabel_fraun_objeto, null);
/*      */ 
/*  881 */     this.jPanel_Fraun_w_c.add(this.jRadioButton_fraun_rectang, null);
/*  882 */     this.jPanel_Fraun_w_c.add(this.jRadioButton_fraun_circ, null);
/*  883 */     this.jPanel_Fraun_w_c.add(this.jRadioButton_fraun_rend, null);
/*  884 */     this.group_fraun_tipoobj.add(this.jRadioButton_fraun_rectang);
/*  885 */     this.group_fraun_tipoobj.add(this.jRadioButton_fraun_circ);
/*  886 */     this.group_fraun_tipoobj.add(this.jRadioButton_fraun_rend);
/*  887 */     this.jPanel_Fraun_w_c.add(this.jPanel_fraun_dimObjeto, null);
/*  888 */     this.jPanel_fraun_dimObjeto.add(this.jLabel_fraun_dimx, null);
/*  889 */     this.jPanel_fraun_dimObjeto.add(this.jSlider_fraun_dimx, null);
/*  890 */     this.jPanel_fraun_dimObjeto.add(this.jLabel_fraun_ndimx, null);
/*  891 */     this.jPanel_fraun_dimObjeto.add(this.jLabel_fraun_dimy, null);
/*  892 */     this.jPanel_fraun_dimObjeto.add(this.jSlider_fraun_dimy, null);
/*  893 */     this.jPanel_fraun_dimObjeto.add(this.jLabel_fraun_ndimy, null);
/*  894 */     this.jPanel_Fraun_w_c.add(this.jLabel_fraun_nObjetos, null);
/*      */ 
/*  902 */     this.jPanel_Fraun_w_c.add(this.jSlider_fraun_nobjetos, null);
/*  903 */     this.jPanel_Fraun_w_c.add(this.jLabel_fraun_numobj, null);
/*  904 */     this.jPanel_fraun_c_c.add(this.jLabel_fraun_periodo, null);
/*  905 */     this.jPanel_fraun_c_c.add(this.jLabel_fraun_dimimag, null);
/*  906 */     this.jPanel_fraun_c_c.add(this.jLabel_fraun_tamdiff, null);
/*  907 */     this.jPanel_fraun_c_c.add(this.jLabel_fraun_distmindif, null);
/*  908 */     this.jPanel_fraun_c_c.add(this.jLabel_fraun_distnmax, null);
/*  909 */     this.jPanel_fraun_c_c.add(this.jLabel_fraun_distnmin, null);
/*  910 */     this.jPanel_fraun_c_c.add(this.jPanel_fraun_showimg, null);
/*  911 */     this.jPanel_fraun_showimg.add(this.jLabel_fraun_show, null);
/*      */ 
/*  915 */     this.jPanel_Fraun_w_n_c.add(this.objetoFraunhofer, null);
/*  916 */     this.jPanel_fraun_showimg.add(this.jRadioButton_fraun_showimg, null);
/*  917 */     this.jPanel_fraun_showimg.add(this.jRadioButton_fraun_showperf, null);
/*  918 */     this.jPanel_fraun_showimg.add(this.jToggleButton_fraun_zoom, null);
/*  919 */     this.group_fraun_show.add(this.jRadioButton_fraun_showimg);
/*  920 */     this.group_fraun_show.add(this.jRadioButton_fraun_showperf);
/*  921 */     this.jPanel_fraun_c_c.add(this.jLabel_fraun_tipoimg, null);
/*  922 */     this.jPanel_fraun_c_c.add(this.jRadioButton_fraun_tipoimg_amp, null);
/*  923 */     this.jPanel_fraun_c_c.add(this.jRadioButton_fraun_tipoimg_int, null);
/*  924 */     this.jPanel_fraun_c_c.add(this.jRadioButton_fraun_tipoimg_intlog, null);
/*  925 */     this.group_fraun_tipoimg.add(this.jRadioButton_fraun_tipoimg_amp);
/*  926 */     this.group_fraun_tipoimg.add(this.jRadioButton_fraun_tipoimg_int);
/*  927 */     this.group_fraun_tipoimg.add(this.jRadioButton_fraun_tipoimg_intlog);
/*  928 */     this.jPanel_fraun_c_c.add(this.jLabel_fraun_umbral, null);
/*  929 */     this.jPanel_fraun_c_c.add(this.jSlider_fraun_umbral, null);
/*  930 */     this.jPanel_fraun_c_c.add(this.jLabel_fraun_numbral, null);
/*      */ 
/*  932 */     this.jPanel_fres_w_c.add(this.jLabel_fres_param, null);
/*  933 */     this.jPanel_fres_w_c.add(this.jLabel_fres_longOnda, null);
/*  934 */     this.jPanel_fres_w_c.add(this.jSlider_fres_longOnda, null);
/*  935 */     this.jPanel_fres_w_c.add(this.jLabel_fres_nlongOnda, null);
/*  936 */     this.jPanel_fres_w_c.add(this.jLabel_fres_distProp, null);
/*  937 */     this.jPanel_fres_w_c.add(this.jSlider_fres_distProp, null);
/*  938 */     this.jPanel_fres_w_c.add(this.jLabel_fres_ndistProp, null);
/*  939 */     this.jPanel_fres_w_c.add(this.jLabel_fres_objeto, null);
/*      */ 
/*  941 */     this.jPanel_fres_w_c.add(this.jRadioButton_fres_rectang, null);
/*  942 */     this.jPanel_fres_w_c.add(this.jRadioButton_fres_circ, null);
/*  943 */     this.jPanel_fres_w_c.add(this.jLabel_fres_nada, null);
/*  944 */     this.jPanel_fres_w_c.add(this.jRadioButton_fres_rend, null);
/*  945 */     this.jPanel_fres_w_c.add(this.jRadioButton_fres_semip, null);
/*  946 */     this.group_fres_tipoobj.add(this.jRadioButton_fres_rectang);
/*  947 */     this.group_fres_tipoobj.add(this.jRadioButton_fres_circ);
/*  948 */     this.group_fres_tipoobj.add(this.jRadioButton_fres_rend);
/*  949 */     this.group_fres_tipoobj.add(this.jRadioButton_fres_semip);
/*  950 */     this.jPanel_fres_w_c.add(this.jPanel_fres_dimObjeto, null);
/*  951 */     this.jPanel_fres_dimObjeto.add(this.jLabel_fres_dimx, null);
/*  952 */     this.jPanel_fres_dimObjeto.add(this.jSlider_fres_dimx, null);
/*  953 */     this.jPanel_fres_dimObjeto.add(this.jLabel_fres_ndimx, null);
/*  954 */     this.jPanel_fres_dimObjeto.add(this.jLabel_fres_dimy, null);
/*  955 */     this.jPanel_fres_dimObjeto.add(this.jSlider_fres_dimy, null);
/*  956 */     this.jPanel_fres_dimObjeto.add(this.jLabel_fres_ndimy, null);
/*  957 */     this.jPanel_fres_w_c.add(this.jButton_fres_calcdif, null);
/*  958 */     this.jPanel_fres_w_n_c.add(this.objetoFresnel, null);
/*  959 */     this.jPanel_fres_c_n_c.add(this.jSplitPane_fres, "Center");
/*      */ 
/*  962 */     this.jPanel_fres_c_c.add(this.jLabel_fres_nada2, null);
/*  963 */     this.jPanel_fres_c_c.add(this.jLabel_fres_dimimag, null);
/*  964 */     this.jPanel_fres_c_c.add(this.jLabel_fres_tamdiff, null);
/*  965 */     this.jPanel_fres_c_c.add(this.jPanel_fres_showimg, null);
/*  966 */     this.jPanel_fres_showimg.add(this.jLabel_fres_show, null);
/*  967 */     this.jPanel_fres_showimg.add(this.jRadioButton_fres_showimg, null);
/*  968 */     this.jPanel_fres_showimg.add(this.jRadioButton_fres_showperf, null);
/*  969 */     this.group_fres_show.add(this.jRadioButton_fres_showimg);
/*  970 */     this.group_fres_show.add(this.jRadioButton_fres_showperf);
/*  971 */     this.jPanel_fres_c_c.add(this.jLabel_fres_tipoimg, null);
/*  972 */     this.jPanel_fres_c_c.add(this.jRadioButton_fres_tipoimg_amp, null);
/*  973 */     this.jPanel_fres_c_c.add(this.jRadioButton_fres_tipoimg_int, null);
/*  974 */     this.jPanel_fres_c_c.add(this.jRadioButton_fres_tipoimg_intlog, null);
/*  975 */     this.group_fres_tipoimg.add(this.jRadioButton_fres_tipoimg_amp);
/*  976 */     this.group_fres_tipoimg.add(this.jRadioButton_fres_tipoimg_int);
/*  977 */     this.group_fres_tipoimg.add(this.jRadioButton_fres_tipoimg_intlog);
/*  978 */     this.jPanel_fres_c_c.add(this.jLabel_fres_umbral, null);
/*  979 */     this.jPanel_fres_c_c.add(this.jSlider_fres_umbral, null);
/*  980 */     this.jPanel_fres_c_c.add(this.jLabel_fres_numbral, null);
/*  981 */     this.jScrollPane_teoria.getViewport().add(this.jTextPane_teoria, null);
/*      */ 
/*  983 */     this.jSplitPane_Fraun.setDividerLocation(0);
/*  984 */     this.jSplitPane_fres.setDividerLocation(0);
/*      */   }
/*      */ 
/*      */   public String getAppletInfo()
/*      */   {
/*  993 */     return "Información del applet";
/*      */   }
/*      */ 
/*      */   public String[][] getParameterInfo() {
/*  997 */     String[][] pinfo = { { "lengua", "int", "" } };
/*      */ 
/* 1001 */     return pinfo;
/*      */   }
/*      */ 
/*      */   public static void main(String[] args)
/*      */   {
/*      */     try
/*      */     {
/* 1008 */       String dato = args[0].toUpperCase().intern();
/*      */ 
/* 1010 */       if (dato == "CA")
/*      */       {
/* 1012 */         lang = 1;
/*      */       }
/* 1014 */       else if (dato == "ES")
/*      */       {
/* 1016 */         lang = 0;
/*      */       }
/* 1018 */       else if (dato == "EN")
/*      */       {
/* 1020 */         lang = 2;
/*      */       }
/*      */       else {
/* 1023 */         lang = 0;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e2)
/*      */     {
/* 1029 */       lang = 0;
/*      */     }
/*      */ 
/* 1034 */     DifraccionApplet applet = new DifraccionApplet();
/* 1035 */     applet.isStandalone = true;
/*      */ 
/* 1037 */     Frame frame = new Frame();
/* 1038 */     frame.setTitle("Applet Difracción");
/* 1039 */     frame.setResizable(false);
               
/* 1040 */     frame.add(applet, "Center");
/* 1041 */     if (icon_joc != null) frame.setIconImage(icon_joc.getImage());
/*      */     
/* 1043 */     applet.init();
/* 1044 */     applet.start();
/* 1045 */     frame.setSize(750, 570);
/* 1046 */     Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
/* 1047 */     frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
/* 1048 */     frame.setVisible(true);
/*      */   }
/*      */   void jButton_Salir_actionPerformed(ActionEvent e) {
/*      */     try {
/* 1052 */       //System.exit(0);
                Window window = SwingUtilities.getWindowAncestor(this);
                window.dispose();
/*      */     }
/*      */     catch (Exception e1) {
/* 1055 */       System.out.println("Error al salir");
/*      */     }
/*      */   }
/*      */ 
/*      */   void jButton_Acercade_actionPerformed(ActionEvent e)
/*      */   {
/* 1062 */     Frame f = new Frame();
/* 1063 */     Object[] options = { this.acerca_etiqueta[1][lang] };
/* 1064 */     ImageIcon icon_joc = null;
/*      */     try {
/* 1066 */       String st_icon = "jocon.jpg";
/* 1067 */       URL url_icon = getClass().getResource(st_icon);
/* 1068 */       icon_joc = new ImageIcon(url_icon, "Difracción");
/*      */     } catch (Exception eicon) {
/* 1070 */       System.out.println("No carga icono");
/*      */     }
/* 1072 */     JOptionPane option = new JOptionPane(this.acerca_etiqueta[2][lang], 1, -1, icon_joc, options);
/*      */ 
/* 1074 */     JDialog dialog = option.createDialog(f, this.acerca_etiqueta[0][lang]);
/* 1075 */     dialog.setResizable(false);
/* 1076 */     dialog.show();
/*      */   }
/*      */ 
/*      */   void actuaParametrosFraunhofer()
/*      */   {
/* 1082 */     double delta_pix = 6.0D;
/* 1083 */     double dim_x_max = 3.0D;
/* 1084 */     double dist_separa = 0.0D;
/* 1085 */     double fraun_tam_dif = 0.0D;
/* 1086 */     double fraun_mindif = 0.0D; double fraun_mindif_y = 0.0D;
/* 1087 */     double fraun_distnmax = 0.0D; double fraun_distnmin = 0.0D;
/*      */ 
/* 1090 */     if (this.tipo_objeto == 0) {
/* 1091 */       this.jLabel_fraun_dimx.setText(this.fraun_etiqueta[7][lang]);
/* 1092 */       this.jLabel_fraun_dimy.setVisible(true);
/* 1093 */       this.jSlider_fraun_dimy.setVisible(true);
/* 1094 */       this.jLabel_fraun_ndimy.setVisible(true);
/*      */     }
/* 1096 */     else if (this.tipo_objeto == 1) {
/* 1097 */       this.jLabel_fraun_dimx.setText(this.fraun_etiqueta[23][lang]);
/* 1098 */       this.jLabel_fraun_dimy.setVisible(false);
/* 1099 */       this.jSlider_fraun_dimy.setVisible(false);
/* 1100 */       this.jLabel_fraun_ndimy.setVisible(false);
/*      */     }
/*      */     else {
/* 1103 */       this.jLabel_fraun_dimx.setText(this.fraun_etiqueta[7][lang]);
/* 1104 */       this.jLabel_fraun_dimy.setVisible(false);
/* 1105 */       this.jSlider_fraun_dimy.setVisible(false);
/* 1106 */       this.jLabel_fraun_ndimy.setVisible(false);
/*      */     }
/* 1108 */     this.long_onda = this.jSlider_fraun_longOnda.getValue();
/* 1109 */     this.jLabel_fraun_nlongOnda.setText(this.long_onda + " nm");
/*      */ 
/* 1125 */     this.n_objetos = this.jSlider_fraun_nobjetos.getValue();
/* 1126 */     this.jLabel_fraun_numobj.setText(this.n_objetos + "");
/* 1127 */     this.dist_focal = this.jSlider_fraun_distFocal.getValue();
/* 1128 */     this.jLabel_fraun_ndistFocal.setText((int)this.dist_focal + " mm");
/* 1129 */     this.dim_x = (this.jSlider_fraun_dimx.getValue() / 10.0D);
/* 1130 */     this.jLabel_fraun_ndimx.setText(this.dim_x + " mm");
/* 1131 */     this.dim_y = (this.jSlider_fraun_dimy.getValue() / 10.0D);
/* 1132 */     this.jLabel_fraun_ndimy.setText(this.dim_y + " mm");
/*      */ 
/* 1134 */     this.objetoFraunhofer.putAtributos(this.tipo_objeto, this.dim_x, this.dim_y, this.n_objetos, this.long_onda);
/* 1135 */     this.jPanel_Fraun_w_n.repaint();
/*      */ 
/* 1138 */     char pto = '.';
/* 1139 */     this.df_symb.setDecimalSeparator(pto);
/* 1140 */     this.df.setDecimalFormatSymbols(this.df_symb);
/*      */ 
/* 1142 */     if (this.n_objetos < 5) dist_separa = 2.0D * dim_x_max;
/* 1143 */     else if ((this.n_objetos > 4) && (this.n_objetos < 9)) dist_separa = dim_x_max / 2.0D;
/* 1144 */     else if ((this.n_objetos > 8) && (this.n_objetos < 11)) dist_separa = dim_x_max / 4.0D;
/*      */ 
/* 1146 */     double semi_periodo = 0.0D;
/* 1147 */     if (this.n_objetos == 1) {
/* 1148 */       if (this.tipo_objeto == 0) {
/* 1149 */         if (this.dim_x > this.dim_y) {
/* 1150 */           semi_periodo = this.long_onda * 1.0E-006D * this.dist_focal / (2.0D * this.dim_x);
/*      */         }
/*      */         else
/*      */         {
/* 1154 */           semi_periodo = this.long_onda * 1.0E-006D * this.dist_focal / (2.0D * this.dim_y);
/*      */         }
/*      */       }
/* 1157 */       else if (this.tipo_objeto == 1) {
/* 1158 */         semi_periodo = this.long_onda * 1.0E-006D * this.dist_focal * 1.22D / (8.0D * this.dim_x);
/*      */       }
/*      */       else {
/* 1161 */         semi_periodo = this.long_onda * 1.0E-006D * this.dist_focal / (2.0D * this.dim_x);
/*      */       }
/*      */     }
/*      */     else {
/* 1165 */       semi_periodo = this.long_onda * 1.0E-006D * this.dist_focal / (2.0D * this.n_objetos * (dim_x_max + dist_separa));
/*      */     }
/*      */ 
/* 1168 */     double dim_Lx = 256.0D;
/* 1169 */     if (semi_periodo * dim_Lx > 7.5D) fraun_tam_dif = 5.0D;
/* 1170 */     else if ((semi_periodo * dim_Lx <= 7.5D) && (semi_periodo * dim_Lx > 5.0D)) fraun_tam_dif = 3.0D;
/* 1171 */     else if ((semi_periodo * dim_Lx <= 5.0D) && (semi_periodo * dim_Lx > 2.0D)) fraun_tam_dif = 2.5D;
/* 1172 */     else if ((semi_periodo * dim_Lx <= 2.0D) && (semi_periodo * dim_Lx > 1.0D)) fraun_tam_dif = 0.5D; else {
/* 1173 */       fraun_tam_dif = 0.25D;
/*      */     }
/*      */ 
/* 1176 */     this.fraun_periodo = (dist_separa + dim_x_max);
/* 1177 */     this.fraun_tam_img = (256.0D / delta_pix);
/*      */ 
/* 1179 */     if (this.n_objetos > 1) {
/* 1180 */       this.jLabel_fraun_periodo.setText(this.fraun_etiqueta[10][lang] + " " + this.fraun_periodo + " mm");
/* 1181 */       this.jLabel_fraun_periodo.setEnabled(true);
/*      */     }
/*      */     else {
/* 1184 */       this.jLabel_fraun_periodo.setText(this.fraun_etiqueta[10][lang] + " " + "-- mm");
/* 1185 */       this.jLabel_fraun_periodo.setEnabled(false);
/*      */     }
/*      */ 
/* 1190 */     this.jLabel_fraun_dimimag.setText(this.fraun_etiqueta[11][lang] + " " + this.df.format(this.fraun_tam_img) + " X " + this.df.format(this.fraun_tam_img) + " mm^2");
/*      */ 
/* 1192 */     this.jLabel_fraun_tamdiff.setText(this.fraun_etiqueta[19][lang] + " " + this.df.format(fraun_tam_dif) + " X " + this.df.format(fraun_tam_dif) + " mm^2");
/*      */ 
/* 1194 */     if (this.tipo_objeto == 0) {
/* 1195 */       fraun_mindif = this.long_onda * 1.0E-006D * this.dist_focal / this.dim_x;
/* 1196 */       fraun_mindif_y = this.long_onda * 1.0E-006D * this.dist_focal / this.dim_y;
/* 1197 */       this.jLabel_fraun_distmindif.setText(this.fraun_etiqueta[24][lang] + this.df.format(fraun_mindif) + this.fraun_etiqueta[25][lang] + this.df.format(fraun_mindif_y) + " mm");
/*      */     }
/* 1199 */     else if (this.tipo_objeto == 1) {
/* 1200 */       fraun_mindif = 1.22D * this.long_onda * 1.0E-006D * this.dist_focal / this.dim_x;
/* 1201 */       this.jLabel_fraun_distmindif.setText(this.fraun_etiqueta[26][lang] + this.df.format(fraun_mindif) + " mm");
/*      */     }
/*      */     else {
/* 1204 */       fraun_mindif = this.long_onda * 1.0E-006D * this.dist_focal / this.dim_x;
/* 1205 */       this.jLabel_fraun_distmindif.setText(this.fraun_etiqueta[20][lang] + " " + this.df.format(fraun_mindif) + " mm");
/*      */     }
/*      */ 
/* 1208 */     if (this.n_objetos > 1) {
/* 1209 */       fraun_distnmax = this.long_onda * 1.0E-006D * this.dist_focal / this.fraun_periodo;
/* 1210 */       if (this.n_objetos == 2) fraun_distnmin = fraun_distnmax; else
/* 1211 */         fraun_distnmin = this.long_onda * 1.0E-006D * this.dist_focal / (this.n_objetos * this.fraun_periodo);
/* 1212 */       this.jLabel_fraun_distnmax.setText(this.fraun_etiqueta[27][lang] + this.df.format(fraun_distnmax) + " mm");
/* 1213 */       this.jLabel_fraun_distnmax.setEnabled(true);
/* 1214 */       this.jLabel_fraun_distnmin.setText(this.fraun_etiqueta[28][lang] + this.df.format(fraun_distnmin) + " mm");
/* 1215 */       this.jLabel_fraun_distnmin.setEnabled(true);
/*      */     }
/*      */     else {
/* 1218 */       this.jLabel_fraun_distnmax.setText(this.fraun_etiqueta[27][lang] + "-- mm");
/* 1219 */       this.jLabel_fraun_distnmax.setEnabled(false);
/* 1220 */       this.jLabel_fraun_distnmin.setText(this.fraun_etiqueta[28][lang] + "-- mm");
/* 1221 */       this.jLabel_fraun_distnmin.setEnabled(false);
/*      */     }
/*      */ 
/* 1224 */     if (!this.label_fraun_activaimg) {
/* 1225 */       if (fraun_tam_dif < 2.0D * fraun_mindif) {
/* 1226 */         this.jToggleButton_fraun_zoom.setEnabled(false);
/* 1227 */         this.label_fraun_zoom = false;
/*      */       }
/*      */       else {
/* 1230 */         this.jToggleButton_fraun_zoom.setEnabled(true);
/* 1231 */         if (this.jToggleButton_fraun_zoom.isSelected() == true) {
/* 1232 */           this.label_fraun_zoom = true;
/* 1233 */           this.jLabel_fraun_tamdiff.setText(this.fraun_etiqueta[19][lang] + " " + this.df.format(2.0D * fraun_mindif) + " mm");
/*      */         }
/*      */         else {
/* 1236 */           this.label_fraun_zoom = false;
/*      */         }
/*      */       }
/*      */     }
/*      */     else {
/* 1241 */       this.jToggleButton_fraun_zoom.setEnabled(false);
/* 1242 */       this.label_fraun_zoom = false;
/*      */     }
/*      */ 
/* 1247 */     if (this.label_fraun_activaimg == true) {
/* 1248 */       this.jRadioButton_fraun_tipoimg_amp.setEnabled(true);
/* 1249 */       this.jRadioButton_fraun_tipoimg_int.setEnabled(true);
/* 1250 */       this.jRadioButton_fraun_tipoimg_intlog.setEnabled(true);
/*      */ 
/* 1252 */       if (this.label_fraun_tipoimg == 0) {
/* 1253 */         this.jRadioButton_fraun_tipoimg_amp.setSelected(true);
/* 1254 */         this.jRadioButton_fraun_tipoimg_int.setSelected(false);
/* 1255 */         this.jRadioButton_fraun_tipoimg_intlog.setSelected(false);
/* 1256 */         this.jSlider_fraun_umbral.setEnabled(true);
/* 1257 */         this.fraun_umbral = (this.jSlider_fraun_umbral.getValue() / 100.0D);
/*      */       }
/* 1260 */       else if (this.label_fraun_tipoimg == 1) {
/* 1261 */         this.jRadioButton_fraun_tipoimg_amp.setSelected(false);
/* 1262 */         this.jRadioButton_fraun_tipoimg_int.setSelected(true);
/* 1263 */         this.jRadioButton_fraun_tipoimg_intlog.setSelected(false);
/* 1264 */         this.jSlider_fraun_umbral.setEnabled(true);
/* 1265 */         this.fraun_umbral = (this.jSlider_fraun_umbral.getValue() / 100.0D);
/*      */       }
/*      */       else
/*      */       {
/* 1269 */         this.jRadioButton_fraun_tipoimg_amp.setSelected(false);
/* 1270 */         this.jRadioButton_fraun_tipoimg_int.setSelected(false);
/* 1271 */         this.jRadioButton_fraun_tipoimg_intlog.setSelected(true);
/* 1272 */         this.jSlider_fraun_umbral.setEnabled(false);
/* 1273 */         this.jSlider_fraun_umbral.setValue(100);
/* 1274 */         this.fraun_umbral = 1.0D;
/*      */       }
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 1280 */       this.jRadioButton_fraun_tipoimg_amp.setEnabled(false);
/* 1281 */       this.jRadioButton_fraun_tipoimg_int.setEnabled(false);
/* 1282 */       this.jRadioButton_fraun_tipoimg_intlog.setEnabled(false);
/* 1283 */       this.jRadioButton_fraun_tipoimg_amp.setSelected(true);
/* 1284 */       this.jSlider_fraun_umbral.setEnabled(false);
/* 1285 */       this.jSlider_fraun_umbral.setValue(100);
/* 1286 */       this.fraun_umbral = 1.0D;
/*      */     }
/*      */ 
/* 1290 */     this.jLabel_fraun_numbral.setText(this.jSlider_fraun_umbral.getValue() + " %");
/*      */ 
/* 1307 */     this.imagenFraun.putAtributos(this.tipo_objeto, this.dim_x, this.dim_y, this.n_objetos, this.long_onda, this.dist_focal, this.label_fraun_tipoimg, this.fraun_umbral);
/* 1308 */     this.perfilFraun.putAtributos(this.tipo_objeto, this.dim_x, this.dim_y, this.n_objetos, this.long_onda, this.dist_focal, this.label_fraun_zoom);
/* 1309 */     this.jPanel_Fraun_c_n.repaint();
/*      */   }
/*      */ 
/*      */   void actuaParametrosFresnel()
/*      */   {
/* 1316 */     if (this.tipo_objeto_fresnel == 0) {
/* 1317 */       this.jLabel_fres_dimx.setVisible(true);
/* 1318 */       this.jSlider_fres_dimx.setVisible(true);
/* 1319 */       this.jLabel_fres_ndimx.setVisible(true);
/* 1320 */       this.jLabel_fres_dimx.setText(this.fraun_etiqueta[7][lang]);
/* 1321 */       this.jLabel_fres_dimy.setVisible(true);
/* 1322 */       this.jSlider_fres_dimy.setVisible(true);
/* 1323 */       this.jLabel_fres_ndimy.setVisible(true);
/*      */     }
/* 1325 */     else if (this.tipo_objeto_fresnel == 1) {
/* 1326 */       this.jLabel_fres_dimx.setVisible(true);
/* 1327 */       this.jSlider_fres_dimx.setVisible(true);
/* 1328 */       this.jLabel_fres_ndimx.setVisible(true);
/* 1329 */       this.jLabel_fres_dimx.setText(this.fraun_etiqueta[23][lang]);
/* 1330 */       this.jLabel_fres_dimy.setVisible(false);
/* 1331 */       this.jSlider_fres_dimy.setVisible(false);
/* 1332 */       this.jLabel_fres_ndimy.setVisible(false);
/*      */     }
/* 1334 */     else if (this.tipo_objeto_fresnel == 3) {
/* 1335 */       this.jLabel_fres_dimx.setVisible(true);
/* 1336 */       this.jSlider_fres_dimx.setVisible(true);
/* 1337 */       this.jLabel_fres_ndimx.setVisible(true);
/* 1338 */       this.jLabel_fres_dimx.setText(this.fraun_etiqueta[7][lang]);
/* 1339 */       this.jLabel_fres_dimy.setVisible(false);
/* 1340 */       this.jSlider_fres_dimy.setVisible(false);
/* 1341 */       this.jLabel_fres_ndimy.setVisible(false);
/*      */     }
/*      */     else {
/* 1344 */       this.jLabel_fres_dimx.setVisible(false);
/* 1345 */       this.jSlider_fres_dimx.setVisible(false);
/* 1346 */       this.jLabel_fres_ndimx.setVisible(false);
/*      */ 
/* 1348 */       this.jLabel_fres_dimy.setVisible(false);
/* 1349 */       this.jSlider_fres_dimy.setVisible(false);
/* 1350 */       this.jLabel_fres_ndimy.setVisible(false);
/*      */     }
/* 1352 */     this.long_onda_fres = this.jSlider_fres_longOnda.getValue();
/* 1353 */     this.jLabel_fres_nlongOnda.setText(this.long_onda_fres + " nm");
/*      */ 
/* 1355 */     this.dist_prop = this.jSlider_fres_distProp.getValue();
/* 1356 */     this.jLabel_fres_ndistProp.setText((int)this.dist_prop + " mm");
/* 1357 */     this.dim_x_fres = (this.jSlider_fres_dimx.getValue() / 10.0D);
/* 1358 */     this.jLabel_fres_ndimx.setText(this.dim_x_fres + " mm");
/* 1359 */     this.dim_y_fres = (this.jSlider_fres_dimy.getValue() / 10.0D);
/* 1360 */     this.jLabel_fres_ndimy.setText(this.dim_y_fres + " mm");
/*      */ 
/* 1362 */     this.objetoFresnel.putAtributos(this.tipo_objeto_fresnel, this.dim_x_fres, this.dim_y_fres, this.long_onda_fres);
/* 1363 */     this.jPanel_fres_w_n.repaint();
/*      */ 
/* 1365 */     this.label_fres_calcula = false;
/* 1366 */     this.jButton_fres_calcdif.setForeground(Color.red);
/*      */ 
/* 1368 */     char pto = '.';
/* 1369 */     this.df_symb.setDecimalSeparator(pto);
/* 1370 */     this.df.setDecimalFormatSymbols(this.df_symb);
/*      */ 
/* 1372 */     double delta_pix = 42.0D;
/* 1373 */     double fres_tam_img = 256.0D / delta_pix;
/* 1374 */     double fres_tam_dif = 256.0D / delta_pix;
/*      */ 
/* 1376 */     this.jLabel_fres_dimimag.setText(this.fraun_etiqueta[11][lang] + " " + this.df.format(fres_tam_img) + " X " + this.df.format(fres_tam_img) + " mm^2");
/*      */ 
/* 1378 */     this.jLabel_fres_tamdiff.setText(this.fraun_etiqueta[19][lang] + " " + this.df.format(fres_tam_dif) + " X " + this.df.format(fres_tam_dif) + " mm^2");
/*      */   }
/*      */ 
/*      */   void calculaDifraccionFresnel()
/*      */   {
/* 1388 */     double delta_pix = 42.0D;
/* 1389 */     double pix_x = 1.0D / delta_pix;
/* 1390 */     double pix_y = 1.0D / delta_pix;
/*      */ 
/* 1394 */     this.label_fres_calcula = true;
/* 1395 */     this.jButton_fres_calcdif.setForeground(Color.black);
/*      */ 
/* 1398 */     for (int i = 0; i < this.numpto_total; i++) {
/* 1399 */       this.matriz_fres_re[i] = 0.0D;
/* 1400 */       this.matriz_fres_im[i] = 0.0D;
/*      */     }
/* 1402 */     if (this.tipo_objeto_fresnel == 0) {
/* 1403 */       int x_inicio = (int)(this.numpto_x * 0.5D - this.dim_x_fres * delta_pix * 0.5D);
/* 1404 */       int x_final = x_inicio + (int)(this.dim_x_fres * delta_pix);
/* 1405 */       int y_inicio = (int)(this.numpto_y * 0.5D - this.dim_y_fres * delta_pix * 0.5D);
/* 1406 */       int y_final = y_inicio + (int)(this.dim_y_fres * delta_pix);
/* 1407 */       for (int i = y_inicio; i < y_final; i++) {
/* 1408 */         for (int j = x_inicio; j < x_final; j++) {
/* 1409 */           this.matriz_fres_re[(j + i * this.numpto_x)] = 1.0D;
/*      */         }
/*      */       }
/*      */     }
/* 1413 */     else if (this.tipo_objeto_fresnel == 1) {
/* 1414 */       for (int i = 0; i < this.numpto_y; i++) {
/* 1415 */         for (int j = 0; j < this.numpto_x; j++) {
/* 1416 */           double x = (j - this.numpto_x / 2.0D) * pix_x;
/* 1417 */           double y = (i - this.numpto_y / 2.0D) * pix_y;
/* 1418 */           double radio = 2.0D * Math.sqrt(x * x + y * y);
/* 1419 */           if (radio < this.dim_x_fres) {
/* 1420 */             this.matriz_fres_re[(j + i * this.numpto_x)] = 1.0D;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 1425 */     else if (this.tipo_objeto_fresnel == 3) {
/* 1426 */       int lado = (int)(this.dim_x_fres * delta_pix);
/* 1427 */       int xorig = (int)(this.numpto_x / 2 - this.dim_x_fres * delta_pix * 0.5D);
/* 1428 */       for (int i = 0; i < this.numpto_y; i++) {
/* 1429 */         for (int j = xorig; j < xorig + lado; j++)
/* 1430 */           this.matriz_fres_re[(j + i * this.numpto_x)] = 1.0D;
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 1435 */       for (int i = 0; i < this.numpto_y; i++) {
/* 1436 */         for (int j = 0; j < (int)(this.numpto_x * 0.5D); j++) {
/* 1437 */           this.matriz_fres_re[(j + i * this.numpto_x)] = 1.0D;
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1444 */     if (this.tipo_objeto_fresnel == 2)
/*      */     {
/* 1446 */       this.transformadaFresnel.transformadaFresnelSemiplano(this.dist_prop, this.numpto_x, this.numpto_y, this.matriz_fres_re, pix_x, pix_y, this.long_onda_fres);
/*      */     }
/*      */     else {
/* 1449 */       this.transformadaFresnel.transformadaFresnel(this.dist_prop, this.numpto_x, this.numpto_y, this.matriz_fres_re, this.matriz_fres_im, pix_x, pix_y, this.long_onda_fres);
/* 1450 */       for (int i = 0; i < this.numpto_total; i++) {
/* 1451 */         this.matriz_fres_re[i] = Math.sqrt(this.matriz_fres_re[i] * this.matriz_fres_re[i] + this.matriz_fres_im[i] * this.matriz_fres_im[i]);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1459 */     actuaImagenFresnel();
/*      */   }
/*      */ 
/*      */   void actuaImagenFresnel()
/*      */   {
/* 1465 */     if (this.label_fres_activaimg == true) {
/* 1466 */       this.jRadioButton_fres_tipoimg_amp.setEnabled(true);
/* 1467 */       this.jRadioButton_fres_tipoimg_int.setEnabled(true);
/* 1468 */       this.jRadioButton_fres_tipoimg_intlog.setEnabled(true);
/*      */ 
/* 1470 */       if (this.label_fres_tipoimg == 0) {
/* 1471 */         this.jRadioButton_fres_tipoimg_amp.setSelected(true);
/* 1472 */         this.jRadioButton_fres_tipoimg_int.setSelected(false);
/* 1473 */         this.jRadioButton_fres_tipoimg_intlog.setSelected(false);
/* 1474 */         this.jSlider_fres_umbral.setEnabled(true);
/* 1475 */         this.fres_umbral = (this.jSlider_fres_umbral.getValue() / 100.0D);
/*      */       }
/* 1478 */       else if (this.label_fres_tipoimg == 1) {
/* 1479 */         this.jRadioButton_fres_tipoimg_amp.setSelected(false);
/* 1480 */         this.jRadioButton_fres_tipoimg_int.setSelected(true);
/* 1481 */         this.jRadioButton_fres_tipoimg_intlog.setSelected(false);
/* 1482 */         this.jSlider_fres_umbral.setEnabled(true);
/* 1483 */         this.fres_umbral = (this.jSlider_fres_umbral.getValue() / 100.0D);
/*      */       }
/*      */       else
/*      */       {
/* 1487 */         this.jRadioButton_fres_tipoimg_amp.setSelected(false);
/* 1488 */         this.jRadioButton_fres_tipoimg_int.setSelected(false);
/* 1489 */         this.jRadioButton_fres_tipoimg_intlog.setSelected(true);
/* 1490 */         this.jSlider_fres_umbral.setEnabled(false);
/* 1491 */         this.jSlider_fres_umbral.setValue(100);
/* 1492 */         this.fres_umbral = 1.0D;
/*      */       }
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 1498 */       this.jRadioButton_fres_tipoimg_amp.setEnabled(false);
/* 1499 */       this.jRadioButton_fres_tipoimg_int.setEnabled(false);
/* 1500 */       this.jRadioButton_fres_tipoimg_intlog.setEnabled(false);
/* 1501 */       this.jRadioButton_fres_tipoimg_amp.setSelected(true);
/* 1502 */       this.jSlider_fres_umbral.setEnabled(false);
/* 1503 */       this.jSlider_fres_umbral.setValue(100);
/* 1504 */       this.fres_umbral = 1.0D;
/*      */     }
/*      */ 
/* 1508 */     this.jLabel_fres_numbral.setText(this.jSlider_fres_umbral.getValue() + " %");
/*      */ 
/* 1521 */     this.imagenFresnel.putAtributos(this.dim_x, this.dim_y, this.matriz_fres_re, this.long_onda_fres, this.label_fres_tipoimg, this.fres_umbral);
/* 1522 */     this.perfilFresnel.putAtributos(this.numpto_x, this.numpto_y, this.matriz_fres_re, this.long_onda_fres);
/* 1523 */     this.jPanel_fres_c_n.repaint();
/* 1524 */     this.jPanel_fres_c_n.repaint();
/*      */   }
/*      */ 
/*      */   private void carga_info(int lengua)
/*      */   {
/* 1529 */     String s = null;
/*      */     try
/*      */     {
/* 1536 */       if (lengua == 1) s = "DocA_DifracCa.htm";
/* 1537 */       else if (lengua == 2) s = "DocA_DifracEn.htm"; else {
/* 1538 */         s = "DocA_DifracEs.htm";
/*      */       }
/* 1540 */       this.info_page = getClass().getResource(s);
/*      */     }
/*      */     catch (Exception eee) {
/* 1543 */       System.err.println("Couldn't create help URL: " + s);
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 1549 */       this.jTextPane_teoria.setPage(this.info_page);
/*      */     } catch (IOException e) {
/* 1551 */       System.err.println("Attempted to read a bad URL: " + this.info_page);
/*      */     }
/*      */   }
/*      */ 
/*      */   void jRadioButton_fraun_rectang_actionPerformed(ActionEvent e)
/*      */   {
/* 1558 */     this.tipo_objeto = 0;
/* 1559 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jRadioButton_fraun_circ_actionPerformed(ActionEvent e) {
/* 1563 */     this.tipo_objeto = 1;
/* 1564 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jRadioButton_fraun_rend_actionPerformed(ActionEvent e)
/*      */   {
/* 1569 */     this.tipo_objeto = 2;
/* 1570 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_longOnda_keyPressed(KeyEvent e)
/*      */   {
/* 1575 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_longOnda_keyTyped(KeyEvent e) {
/* 1579 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_longOnda_mouseClicked(MouseEvent e) {
/* 1583 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_longOnda_mouseDragged(MouseEvent e) {
/* 1587 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jRadioButton_fraun_1obj_actionPerformed(ActionEvent e) {
/* 1591 */     this.num_objetos = 0;
/* 1592 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jRadioButton_fraun_nobj_actionPerformed(ActionEvent e) {
/* 1596 */     this.num_objetos = 1;
/* 1597 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jRadioButton_fraun_red_actionPerformed(ActionEvent e) {
/* 1601 */     this.num_objetos = 2;
/* 1602 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_nobjetos_mouseClicked(MouseEvent e) {
/* 1606 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_nobjetos_mouseDragged(MouseEvent e) {
/* 1610 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_nobjetos_keyPressed(KeyEvent e) {
/* 1614 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_nobjetos_keyTyped(KeyEvent e) {
/* 1618 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_distFocal_keyPressed(KeyEvent e) {
/* 1622 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_distFocal_keyTyped(KeyEvent e) {
/* 1626 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_distFocal_mouseClicked(MouseEvent e) {
/* 1630 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_distFocal_mouseDragged(MouseEvent e) {
/* 1634 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_dimx_keyPressed(KeyEvent e) {
/* 1638 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_dimx_keyTyped(KeyEvent e) {
/* 1642 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_dimx_mouseClicked(MouseEvent e) {
/* 1646 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_dimx_mouseDragged(MouseEvent e) {
/* 1650 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_dimy_keyPressed(KeyEvent e) {
/* 1654 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_dimy_keyTyped(KeyEvent e) {
/* 1658 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_dimy_mouseClicked(MouseEvent e) {
/* 1662 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_dimy_mouseDragged(MouseEvent e) {
/* 1666 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_umbral_mouseClicked(MouseEvent e)
/*      */   {
/* 1697 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_umbral_mouseDragged(MouseEvent e) {
/* 1701 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_umbral_keyPressed(KeyEvent e) {
/* 1705 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jSlider_fraun_umbral_keyTyped(KeyEvent e) {
/* 1709 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jRadioButton_fraun_showimg_actionPerformed(ActionEvent e) {
/* 1713 */     this.jSplitPane_Fraun.setDividerLocation(0);
/* 1714 */     this.label_fraun_activaimg = true;
/*      */ 
/* 1716 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jRadioButton_fraun_showperf_actionPerformed(ActionEvent e) {
/* 1720 */     this.jSplitPane_Fraun.setDividerLocation(1.0D);
/* 1721 */     this.label_fraun_activaimg = false;
/*      */ 
/* 1723 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jRadioButton_fraun_tipoimg_amp_actionPerformed(ActionEvent e) {
/* 1727 */     this.label_fraun_tipoimg = 0;
/* 1728 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jRadioButton_fraun_tipoimg_int_actionPerformed(ActionEvent e) {
/* 1732 */     this.label_fraun_tipoimg = 1;
/* 1733 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jRadioButton_fraun_tipoimg_intlog_actionPerformed(ActionEvent e) {
/* 1737 */     this.label_fraun_tipoimg = 2;
/* 1738 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jToggleButton_fraun_zoom_actionPerformed(ActionEvent e)
/*      */   {
/* 1750 */     actuaParametrosFraunhofer();
/*      */   }
/*      */ 
/*      */   void jButton_fres_calcdif_actionPerformed(ActionEvent e) {
/* 1754 */     calculaDifraccionFresnel();
/*      */   }
/*      */ 
/*      */   void jSlider_fres_longOnda_keyPressed(KeyEvent e) {
/* 1758 */     actuaParametrosFresnel();
/*      */   }
/*      */ 
/*      */   void jSlider_fres_longOnda_keyTyped(KeyEvent e) {
/* 1762 */     actuaParametrosFresnel();
/*      */   }
/*      */ 
/*      */   void jSlider_fres_longOnda_mouseClicked(MouseEvent e) {
/* 1766 */     actuaParametrosFresnel();
/*      */   }
/*      */ 
/*      */   void jSlider_fres_longOnda_mouseDragged(MouseEvent e) {
/* 1770 */     actuaParametrosFresnel();
/*      */   }
/*      */   void jRadioButton_fres_rectang_actionPerformed(ActionEvent e) {
/* 1773 */     this.tipo_objeto_fresnel = 0;
/* 1774 */     actuaParametrosFresnel();
/*      */   }
/*      */ 
/*      */   void jRadioButton_fres_circ_actionPerformed(ActionEvent e) {
/* 1778 */     this.tipo_objeto_fresnel = 1;
/* 1779 */     actuaParametrosFresnel();
/*      */   }
/*      */ 
/*      */   void jRadioButton_fres_semip_actionPerformed(ActionEvent e)
/*      */   {
/* 1784 */     this.tipo_objeto_fresnel = 2;
/* 1785 */     actuaParametrosFresnel();
/*      */   }
/*      */ 
/*      */   void jRadioButton_fres_rend_actionPerformed(ActionEvent e) {
/* 1789 */     this.tipo_objeto_fresnel = 3;
/* 1790 */     actuaParametrosFresnel();
/*      */   }
/*      */ 
/*      */   void jSlider_fres_distProp_keyPressed(KeyEvent e) {
/* 1794 */     actuaParametrosFresnel();
/*      */   }
/*      */ 
/*      */   void jSlider_fres_distProp_keyTyped(KeyEvent e) {
/* 1798 */     actuaParametrosFresnel();
/*      */   }
/*      */ 
/*      */   void jSlider_fres_distProp_mouseClicked(MouseEvent e) {
/* 1802 */     actuaParametrosFresnel();
/*      */   }
/*      */ 
/*      */   void jSlider_fres_distProp_mouseDragged(MouseEvent e) {
/* 1806 */     actuaParametrosFresnel();
/*      */   }
/*      */ 
/*      */   void jSlider_fres_dimx_keyPressed(KeyEvent e) {
/* 1810 */     actuaParametrosFresnel();
/*      */   }
/*      */ 
/*      */   void jSlider_fres_dimx_keyTyped(KeyEvent e) {
/* 1814 */     actuaParametrosFresnel();
/*      */   }
/*      */ 
/*      */   void jSlider_fres_dimx_mouseClicked(MouseEvent e) {
/* 1818 */     actuaParametrosFresnel();
/*      */   }
/*      */ 
/*      */   void jSlider_fres_dimx_mouseDragged(MouseEvent e) {
/* 1822 */     actuaParametrosFresnel();
/*      */   }
/*      */ 
/*      */   void jSlider_fres_dimy_keyPressed(KeyEvent e) {
/* 1826 */     actuaParametrosFresnel();
/*      */   }
/*      */ 
/*      */   void jSlider_fres_dimy_keyTyped(KeyEvent e) {
/* 1830 */     actuaParametrosFresnel();
/*      */   }
/*      */ 
/*      */   void jSlider_fres_dimy_mouseClicked(MouseEvent e) {
/* 1834 */     actuaParametrosFresnel();
/*      */   }
/*      */ 
/*      */   void jSlider_fres_dimy_mouseDragged(MouseEvent e) {
/* 1838 */     actuaParametrosFresnel();
/*      */   }
/*      */ 
/*      */   void jSlider_fres_umbral_mouseClicked(MouseEvent e) {
/* 1842 */     actuaImagenFresnel();
/*      */   }
/*      */ 
/*      */   void jSlider_fres_umbral_mouseDragged(MouseEvent e) {
/* 1846 */     actuaImagenFresnel();
/*      */   }
/*      */ 
/*      */   void jSlider_fres_umbral_keyPressed(KeyEvent e) {
/* 1850 */     actuaImagenFresnel();
/*      */   }
/*      */ 
/*      */   void jSlider_fres_umbral_keyTyped(KeyEvent e) {
/* 1854 */     actuaImagenFresnel();
/*      */   }
/*      */ 
/*      */   void jRadioButton_fres_showimg_actionPerformed(ActionEvent e) {
/* 1858 */     this.jSplitPane_fres.setDividerLocation(0);
/* 1859 */     this.label_fres_activaimg = true;
/* 1860 */     actuaImagenFresnel();
/*      */   }
/*      */ 
/*      */   void jRadioButton_fres_showperf_actionPerformed(ActionEvent e) {
/* 1864 */     this.jSplitPane_fres.setDividerLocation(1.0D);
/* 1865 */     this.label_fres_activaimg = false;
/* 1866 */     actuaImagenFresnel();
/*      */   }
/*      */ 
/*      */   void jRadioButton_fres_tipoimg_amp_actionPerformed(ActionEvent e) {
/* 1870 */     this.label_fres_tipoimg = 0;
/* 1871 */     actuaImagenFresnel();
/*      */   }
/*      */ 
/*      */   void jRadioButton_fres_tipoimg_int_actionPerformed(ActionEvent e) {
/* 1875 */     this.label_fres_tipoimg = 1;
/* 1876 */     actuaImagenFresnel();
/*      */   }
/*      */ 
/*      */   void jRadioButton_fres_tipoimg_intlog_actionPerformed(ActionEvent e) {
/* 1880 */     this.label_fres_tipoimg = 2;
/* 1881 */     actuaImagenFresnel();
/*      */   }
/*      */ }