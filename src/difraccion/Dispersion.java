/*    */ package difraccion;
/*    */ 
/*    */ import java.applet.Applet;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Frame;
/*    */ import java.awt.Toolkit;
/*    */ 
/*    */ public class Dispersion extends Applet
/*    */ {
/* 17 */   private boolean isStandalone = false;
/*    */   int lang;
/*    */ 
/*    */   public String getParameter(String key, String def)
/*    */   {
/* 21 */     return getParameter(key) != null ? getParameter(key) : this.isStandalone ? System.getProperty(key, def) : def;
/*    */   }
/*    */ 
/*    */   public void init()
/*    */   {
/*    */     try
/*    */     {
/* 31 */       this.lang = Integer.parseInt(getParameter("idioma", "0"));
/*    */     }
/*    */     catch (Exception e) {
/* 34 */       e.printStackTrace();
/*    */     }
/*    */     try {
/* 37 */       jbInit();
/*    */     }
/*    */     catch (Exception e) {
/* 40 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   private void jbInit() throws Exception {
/*    */   }
/*    */ 
/*    */   public String getAppletInfo() {
/* 48 */     return "Información del applet";
/*    */   }
/*    */ 
/*    */   public String[][] getParameterInfo() {
/* 52 */     String[][] pinfo = { { "idioma", "int", "" } };
/*    */ 
/* 56 */     return pinfo;
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/* 60 */     Dispersion applet = new Dispersion();
/* 61 */     applet.isStandalone = true;
/*    */ 
/* 63 */     Frame frame = new Frame();
/* 64 */     frame.setTitle("Marco del applet");
/* 65 */     frame.add(applet, "Center");
/* 66 */     applet.init();
/* 67 */     applet.start();
/* 68 */     frame.setSize(750, 570);
/* 69 */     Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
/* 70 */     frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
/* 71 */     frame.setVisible(true);
/*    */   }
/*    */ }