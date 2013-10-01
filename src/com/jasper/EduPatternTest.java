package com.jasper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EduPatternTest {
	static public GraphicsDevice device;

	public static void setDevice() {
		GraphicsEnvironment env = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		GraphicsDevice[] devices = env.getScreenDevices();

		// if only one device is detected, then user selection is not required
		if (devices.length == 1) {
			EduPatternTest.device = devices[0];
			return;
		}

		String shortenedlist[] = new String[devices.length];
		int cnt = 0;
		for (GraphicsDevice dev : devices)
			shortenedlist[cnt++] = dev.getIDstring();
		int suggested = devices.length - 1;
		int selected = suggested;
		URL url = ClassLoader.getSystemResource("resources/jdclogo_48x48.png");
		ImageIcon icon = new ImageIcon(url, "help");
		ResourceBundle bundle = ResourceBundle.getBundle("resources/Text");
		String chosen = (String) JOptionPane.showInputDialog(null,
				bundle.getString("DISPLAY_SELECT_BODY"),
				bundle.getString("DISPLAY_SELECT_HEAD"),
				JOptionPane.INFORMATION_MESSAGE, icon, shortenedlist,
				shortenedlist[suggested]);
		if (chosen != null) {
			for (int i = 0; i < shortenedlist.length; i++) {
				if (shortenedlist[i].equals(chosen)) {
					selected = i;
					break;
				}
			}
		}
		EduPatternTest.device = devices[selected];
	}

	static PatternImage pimage;
	static EduPatternJPanel patternPanel;
	static JFrame patternFrame;
	static EduUIMainView controlFrame;

	// use 2nd display
	static boolean use2ndDisplay = true;

	static public double lambda = 5.32e-7;
	static public String lambdaStr = "532";
	
	public static void initPatternFrame() {
		patternFrame = new JFrame();

		Rectangle bounds;
		// create pattern image buffer
		if (EduPatternTest.use2ndDisplay) {
			EduPatternTest.setDevice();
			GraphicsConfiguration gc = EduPatternTest.device
					.getDefaultConfiguration();
			bounds = gc.getBounds();
		} else {
			bounds = new Rectangle(480, 270);
		}

		pimage = new PatternImage(bounds.width, bounds.height);
		pimage.init(lambda);
		//pimage.singleslit();
                

		// for debugging purpose, show wavelength
		// System.out.println("wavelength = " + pimage.getLambda());

		patternPanel = new EduPatternJPanel(pimage);
                
		patternFrame.getContentPane().add(patternPanel);

		patternFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		patternFrame.setSize(bounds.width, bounds.height);
		patternFrame.setLocation(bounds.x, bounds.y);
		// full screen
                patternFrame.setUndecorated(true);
                patternFrame.addMouseListener(new ClickListener() {
                    public void doubleClick(MouseEvent e) {
                        patternFrame.dispose();
                        // log
                        //System.out.println("double");
                    }
                });
                
//                patternPanel.addMouseListener(new ClickListener() {
//                   public void doubleClick(MouseEvent e) {
//                       //patternFrame.setVisible(true);
//                       if (patternPanel.contains(e.getPoint())) {//check if mouse is clicked within shape
//                        System.out.println("Clicked a "+patternPanel.getClass().getName());
//                    }
//                       // log
//                       //System.out.println("double");
//                   }
//               });
                
                
                
                // not run first
		patternFrame.setVisible(false);
                patternFrame.setBackground(Color.red);
	}

	public static void disablePatternFrame() {
		patternFrame.setVisible(false);
	}

	public static void disposePatternFrame() {
		patternFrame.dispose();
	}
        
    public static void updateRegenerate() {
		controlFrame.updateRegenerate();
		patternPanel.revalidate();
		patternFrame.repaint();
		controlFrame.repaint();    	
    }

	public static void updateLensPattern(PatternImage pimage, String log) {
		controlFrame.logString(log);
		patternPanel.setImage(pimage);
		patternPanel.revalidate();
		patternFrame.repaint();
		patternFrame.setVisible(true);
		controlFrame.repaint();
	}
        
        public static void updateLensPatternPattern(PatternImage pimage, String log) {
		controlFrame.logString(log);
		patternPanel.setImage(pimage);
		patternPanel.revalidate();
		patternFrame.repaint();
		//patternFrame.setVisible(true);
		controlFrame.repaint();
	}

	public static void updateCylindricalPattern(PatternImage pimage, String log) {
		controlFrame.logString(log);
		patternPanel.setImage(pimage);
		patternPanel.revalidate();
		patternFrame.repaint();
		patternFrame.setVisible(true);
		controlFrame.repaint();
	}

	public static void updateMirrorPattern(PatternImage pimage, String log) {
		controlFrame.logString(log);
		patternPanel.setImage(pimage);
		patternPanel.revalidate();
		patternFrame.repaint();
		patternFrame.setVisible(true);
		controlFrame.repaint();
	}

	public static void updatePatternScreen(PatternImage pimage, String log) {
		controlFrame.logString(log);
		patternPanel.setImage(pimage);
		patternPanel.revalidate();
		patternFrame.repaint();
		patternFrame.setVisible(false);
		controlFrame.repaint();
	}

	static int debugging = 0;
	static int logging = 0;

	public static void initControlFrame() {
		controlFrame = new EduUIMainView();
		controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controlFrame.setLocation(0, 0);
                //controlFrame.setBounds(0,0,1300,760);
                controlFrame.setPreferredSize(new Dimension(1268, 700));

		controlFrame.pack();
		controlFrame.setVisible(true);
		controlFrame.setResizable(true);

		// following line is for debugging. it's very useful when using with one
		// display only
		if (debugging == 1)
			controlFrame.setAlwaysOnTop(true);

		// put out configuration of the selected display device
		Rectangle bounds = patternFrame.getBounds();
		controlFrame.logString("Panel width=" + bounds.width + ", height="
				+ bounds.height);

		// log wavelength
		controlFrame.logString("Wavelength=" + pimage.getLambda());
	}

	enum main_opts {
		debug, pane, log, lambda;
	}

	static int parse_int(String token) throws Exception {
		try {
			int val = Integer.valueOf(token);
			return val;
		} catch (Exception e) {
			throw e;
		}
	}

	static void parse_opt(String arg) {
		String tokens[] = arg.split("=");
		try {
			main_opts opt = main_opts.valueOf(tokens[0]);
			switch (opt) {
			case debug:
				debugging = parse_int(tokens[1]);
				break;
			case log:
				logging = parse_int(tokens[1]);
				break;
			case pane:
				if (parse_int(tokens[1]) == 1)
					use2ndDisplay = false;
				break;
			case lambda:
				lambda = Double.valueOf(tokens[1]+"e-9");
				lambdaStr = tokens[1];
				break;
			}
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		// parse arguments
		for (String arg : args)
			parse_opt(arg);

		EduPatternTest.initPatternFrame();
		EduPatternTest.initControlFrame();
                
		// set icon using JDC logo
		URL url = ClassLoader.getSystemResource("resources/jdclogo_48x48.png");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.createImage(url);
		controlFrame.setIconImage(img);
		patternFrame.setIconImage(img);
	}
}
