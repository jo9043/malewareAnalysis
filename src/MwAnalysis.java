import java.awt.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.awt.Button;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.xml.parsers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Scanner;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class MainFrame extends JFrame {
	FlowLayout flow = new FlowLayout();
	private Container con; 
	private ImageIcon imTitle, imMain; // Main Image, Icon Image
	private JButton fS = new JButton("File Select");
	private JButton sA = new JButton("Simple Analyze");
	private JButton cA = new JButton("Close Analyze");
	private JFileChooser jfc = new JFileChooser();
	private JTextField mainTxt;
	private String dfName; // Folder path
	private String cmdInst;
	private String category;
	SimpleFrame sf;
	CloseFrame cf;
	AboutFrame af;
	String packageName = null;

	public MainFrame() {
		super("Analysis Tool");
		super.setLayout(flow);
		this.init();
		this.start();

		this.setVisible(true);
	}

	public void init() {
		imMain = new ImageIcon("mainframe.jpg");
		imTitle = new ImageIcon("title.png"); 
		mainTxt = new JTextField("Android Package Analysis Tool");
		con = this.getContentPane(); 

		createMenu();
		this.setSize(500, 400);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension di = tk.getScreenSize();
		Dimension di1 = this.getSize();
		this.setLocation((int) (di.getWidth() / 2 - di1.getWidth() / 2),
				(int) (di.getHeight() / 2 - di1.getHeight() / 2));

		this.setIconImage(imTitle.getImage());
		JLabel mainImage = new JLabel(imMain);

		mainTxt.setPreferredSize(new Dimension(480, 20));
		mainTxt.setHorizontalAlignment(JLabel.CENTER);
		mainTxt.setEditable(false);

		con.add(mainImage);
		con.add(mainTxt);
	}

	public void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void createMenu() { // Menu Bar
		JMenuBar mb = new JMenuBar();
		fileMenuActionListener fListener = new fileMenuActionListener();
		runMenuActionListener rListener = new runMenuActionListener();
		helpMenuActionListener hListener = new helpMenuActionListener();

		JMenuItem[] menuItem = new JMenuItem[2];
		String[] FileItem = { "Select File", "Exit" };
		String[] RunItem = { "Simple Analyze", "Close Analyze" };

		JMenu helpMenu = new JMenu("Help");
		JMenuItem helpItem;
		helpItem = new JMenuItem("About...");
		helpItem.addActionListener(hListener);
		helpMenu.add(helpItem);

		JMenu fileMenu = new JMenu("File");
		for (int i = 0; i < menuItem.length; i++) {
			menuItem[i] = new JMenuItem(FileItem[i]);
			menuItem[i].addActionListener(fListener);
			fileMenu.add(menuItem[i]);
		}

		JMenu runMenu = new JMenu("Run");
		for (int i = 0; i < menuItem.length; i++) {
			menuItem[i] = new JMenuItem(RunItem[i]);
			menuItem[i].addActionListener(rListener);
			runMenu.add(menuItem[i]);
		}

		mb.add(fileMenu);
		mb.add(runMenu);
		mb.add(helpMenu);

		setJMenuBar(mb);

	}

	class fileMenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch (cmd) { // ¸Þ´º ¾ÆÀÌÅÛÀÇ Á¾·ù ±¸ºÐ
			case "Select File":
				FileDialog dialog = new FileDialog(new JFrame(), "Select File", FileDialog.LOAD);
				dialog.setDirectory(".");
				dialog.setVisible(true);

				dfName = dialog.getDirectory() + dialog.getFile();
				mainTxt.setText("File is Selected: " + dialog.getFile());

				if (dialog.getFile() == null) {
					mainTxt.setText("File is not Selected");
					return;
				}
				break;
			case "Exit":
				System.exit(0);
				break;
			}

		}
	}

	class runMenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch (cmd) {
			case "Simple Analyze":
				sf = new SimpleFrame("");
				break;
			case "Close Analyze":
				cf = new CloseFrame("");
				break;
			}
		}
	}

	class helpMenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch (cmd) {
			case "About...":
				af = new AboutFrame("");
				break;
			}
		}
	}

	class AboutFrame extends JFrame {
		public AboutFrame(String str) {
			super("About");
			imTitle = new ImageIcon("title.png");
			this.setIconImage(imTitle.getImage());
			this.setSize(400, 600);

			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension di = tk.getScreenSize();
			Dimension di1 = this.getSize();
			this.setLocation((int) (di.getWidth() / 2 - di1.getWidth() / 2),
					(int) (di.getHeight() / 2 - di1.getHeight() / 2));
			this.setVisible(true);
		}
	}

	class SimpleFrame extends JFrame { // Simple Analysis
		GridBagLayout grid = new GridBagLayout();
		private Container con;
		private ImageIcon imTitle;
		private JLabel fileLabel;
		private JLabel maniLabel;
		private JLabel scoreLabel;
		private JLabel logLabel;
		private JLabel dangerLabel;
		private TextArea fileInfo;
		private TextArea maniInfo;
		private TextArea score;
		private TextArea logInfo;
		private TextArea dangerInfo;
		private JTextField maintext;
		private Button btnRun;
		public JProgressBar pB;

		btnActionListener bListener = new btnActionListener();

		public SimpleFrame(String str) {
			super("Simple Analysis");
			super.setLayout(grid);
			init();
			start(str);

		}

		public void init() {
			imTitle = new ImageIcon("title.png"); 
			this.setIconImage(imTitle.getImage());
			this.setSize(910, 650);

			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension di = tk.getScreenSize();
			Dimension di1 = this.getSize();
			this.setLocation((int) (di.getWidth() / 2 - di1.getWidth() / 2),
					(int) (di.getHeight() / 2 - di1.getHeight() / 2));

			//TextArea
			dangerInfo = new TextArea();
			dangerInfo.setEditable(false);
			dangerInfo.setPreferredSize(new Dimension(500, 200));
			fileInfo = new TextArea();
			fileInfo.setText(dfName + "\n");
			fileInfo.setPreferredSize(new Dimension(500, 50));
			fileInfo.setEditable(false);
			maniInfo = new TextArea();
			maniInfo.setEditable(false);
			maniInfo.setPreferredSize(new Dimension(500, 350));
			score = new TextArea();
			score.setEditable(false);
			score.setPreferredSize(new Dimension(500, 150));
			logInfo = new TextArea();
			logInfo.setEditable(false);
			logInfo.setPreferredSize(new Dimension(500, 200));

			//Label
			fileLabel = new JLabel("File Information");
			fileLabel.setPreferredSize(new Dimension(100, 20));
			maniLabel = new JLabel("Total Permission");
			maniLabel.setPreferredSize(new Dimension(100, 20));
			scoreLabel = new JLabel("Score");
			scoreLabel.setPreferredSize(new Dimension(100, 20));
			logLabel = new JLabel("Log");
			logLabel.setPreferredSize(new Dimension(100, 20));
			dangerLabel = new JLabel("Danger Permission");
			dangerLabel.setPreferredSize(new Dimension(100, 20));

			maintext = new JTextField("Simple Analysis");
			maintext.setEditable(false);
			maintext.setHorizontalAlignment(JLabel.CENTER);
			
			//Progress Bar
			pB = new JProgressBar();
			pB.setMinimum(0);
			pB.setMaximum(100);
			// pB.setStringPainted(true);
			pB.setStringPainted(false);
			pB.setIndeterminate(true);
			Border border = BorderFactory.createTitledBorder("Progress...");
			pB.setBorder(border);

			btnRun = new Button("Run");

			this.setVisible(true);
		}

		public void start(String str) {
			GridBagConstraints c = new GridBagConstraints();
			con = this.getContentPane();
			
			//GridBag Positions
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			con.add(fileLabel, c);

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			con.add(fileInfo, c);

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 2;
			con.add(logLabel, c);

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 3;
			con.add(logInfo, c);

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 4;
			con.add(pB, c);

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 0;
			con.add(maniLabel, c);

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 1;
			con.add(maniInfo, c);

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 4;
			con.add(scoreLabel, c);

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 5;
			con.add(score, c);

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 5;
			btnRun.addActionListener(bListener);
			con.add(btnRun, c);

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 2;
			con.add(dangerLabel, c);

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 3;
			con.add(dangerInfo, c);
		}

		class btnActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				deleteDirectory(new File("./result"));

				if (e.getSource().equals(btnRun)) {
					// pB.setValue(0);
					maintext.setText("Decompile...");
					try {
						Process p = Runtime.getRuntime()
								.exec("java -jar ./tool/apktool_2.2.3.jar d " + dfName + " -o ./result");
						BufferedReader bf = new BufferedReader(new InputStreamReader(p.getErrorStream()));
						String str = "";

						while ((str = bf.readLine()) != null) {
							logInfo.append("[-] " + str + "\n");
						}

						BufferedReader bf1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
						String str1 = "";

						while ((str1 = bf1.readLine()) != null) {
							logInfo.append("[+] " + str1 + "\n");
						}

					} catch (IOException e2) {

					}

					// pB.setValue(40);
					maintext.setText("Make Permission...");

					try {
						DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
						DocumentBuilder parser = f.newDocumentBuilder();

						Document xmlDoc = null;
						String url = "./result/AndroidManifest.xml";
						xmlDoc = parser.parse(url);

						Element root = xmlDoc.getDocumentElement();
						// System.out.println(root.getTagName());

						DesiredCapabilities caps = new DesiredCapabilities();
						caps.setJavascriptEnabled(true);
						caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
								"tool/phantomjs-2.1.1-windows/bin/phantomjs.exe");

						try { // Get App Information 
							packageName = root.getAttribute("package");
							logInfo.append("[+] Get information from Google Store...\n");
							PhantomJSDriver driver = new PhantomJSDriver(caps);
							driver.get("https://play.google.com/store/apps/details?id=" + packageName);
							WebElement elmntCategory = driver
									.findElement(By.cssSelector("a.document-subtitle.category"));
							WebElement elmntCompany = driver.findElement(By.cssSelector("a.document-subtitle.primary"));
							WebElement elmntTitle = driver.findElement(By.cssSelector("div.id-app-title"));
							WebElement elmntRatingsInfo = driver.findElement(By.cssSelector("span.rating-count"));
							WebElement elmntScore = driver.findElement(By.cssSelector("div.score"));

							category = elmntCategory.getText();
							fileInfo.append("[+] Package Name : " + packageName + "\n[+] Category : "
									+ elmntCategory.getText() + "\n[+] Company : " + elmntCompany.getText()
									+ "\n[+] Title : " + elmntTitle.getText() + "\n[+] Rating : "
									+ elmntRatingsInfo.getText() + "\n[+] Score : " + elmntScore.getText());
						} catch (Exception e1) {
							// TODO: handle exception
							fileInfo.append("[-] This is an unregistered app.");
							System.out.println(packageName);
						}

						// pB.setValue(60);
						NodeList bookNodes = root.getElementsByTagName("uses-permission");

						int length = bookNodes.getLength();

						for (int i = 0; i < length; i++) {
							Node bookNode = bookNodes.item(i);
							NamedNodeMap bookNodeAttrs = bookNode.getAttributes();
							String isbn = bookNodeAttrs.getNamedItem("android:name").getNodeValue();
							// String kind = bookNodeAttrs.getNamedItem("kind").getNodeValue();

							NodeList bookChildNodes = bookNode.getChildNodes();
							String child = "";
							for (int k = 0; k < bookChildNodes.getLength(); k++) {
								Node bookChild = bookChildNodes.item(k);
								if (bookChild.getNodeType() == Node.ELEMENT_NODE) {
									child += bookChild.getChildNodes().item(0).getNodeValue() + "  ";
								}
							}

							if (category != null) {
								category = category.replace(" ", "_");
								category = category.replace("/", "_");
							}

							try {

								String path = "./tool/permissioncount/" + category + ".txt";
								File file = new File(path);
						
								if (!file.isFile()) {
									maniInfo.append(isbn + "\n");
									dangerInfo.append("This application is unregistered\n");
									continue;
								}

								BufferedReader reader = new BufferedReader(new FileReader(file));
								String line;
								String[] splitedStr = null;
							
								while ((line = reader.readLine()) != null) {
									splitedStr = line.split(":");
									if (splitedStr[0].equals("permission")) {
										System.out.println(splitedStr[1]);
									}
									if (splitedStr[0].equals("count")) {
										System.out.println(splitedStr[1]);
									}

									if (isbn.equals(splitedStr[0])) {
										if (Integer.parseInt(splitedStr[1]) < 50) {
											maniInfo.append(isbn + "\n");
											dangerInfo.append(isbn + "\n");
											continue;
										} else {
											maniInfo.append(isbn + "\n");
											continue;
										}
									}
								}
								reader.close();

							} catch (FileNotFoundException fnf) {
								fnf.printStackTrace();
							} catch (IOException e1) {
								e1.printStackTrace();
							}

						}
					} catch (Exception e4) {
						logInfo.append(e4.toString());
					}
					// pB.setValue(80);
					try {
						logInfo.append("[+] Scoring...");
						maintext.setText("Scoring...");
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(new FileInputStream(dfName), "utf-8"));

						score.setText("");
						String line;

						Process p = Runtime.getRuntime().exec("python ./tool/androguard/androrisk.py -i " + dfName);

						BufferedReader bf = new BufferedReader(new InputStreamReader(p.getErrorStream()));
						String str = "";

						BufferedReader bf1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
						String str1 = "";
						while ((str1 = bf1.readLine()) != null) {
							score.append(str1 + "\n");
						}

						reader.close();
						
					} catch (Exception e2) {
						// JOptionPane.showMessageDialog(this, "Error");
					}

					// pB.setValue(100);
					maintext.setText("Finished");

				}

			}

			public boolean deleteDirectory(File path) {
				if (!path.exists()) {
					return false;
				}

				File[] files = path.listFiles();
				for (File file : files) {
					if (file.isDirectory()) {
						deleteDirectory(file);
					} else {
						file.delete();
					}
				}
				return path.delete();
			}
		}

	}

	class CloseFrame extends JFrame { // Close Analysis
		GridBagLayout grid = new GridBagLayout();
		private Container con;
		private ImageIcon imTitle;
		private JLabel fileLabel;
		private TextArea fileInfo;
		private JLabel detectLabel;
		private TextArea detectInfo;
		private Button btnRun;
		public JProgressBar pB;

		btnActionListener bListener = new btnActionListener();

		public CloseFrame(String str) {
			super("Close Analysis");
			super.setLayout(grid);

			init();
			start(str);
		}

		public void init() {
			imTitle = new ImageIcon("title.png");
			this.setIconImage(imTitle.getImage());

			this.setSize(480, 500);
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension di = tk.getScreenSize();
			Dimension di1 = this.getSize();
			this.setLocation((int) (di.getWidth() / 2 - di1.getWidth() / 2),
					(int) (di.getHeight() / 2 - di1.getHeight() / 2));

			pB = new JProgressBar();
			pB.setMinimum(0);
			pB.setMaximum(100);
			// pB.setStringPainted(true);
			pB.setStringPainted(false);
			pB.setIndeterminate(true);
			Border border = BorderFactory.createTitledBorder("Progress...");
			pB.setBorder(border);

			fileLabel = new JLabel("File Information");
			fileLabel.setPreferredSize(new Dimension(500, 350));

			fileInfo = new TextArea();
			fileInfo.setText("[+] " + dfName);
			fileInfo.setPreferredSize(new Dimension(500, 50));
			fileInfo.setEditable(false);

			detectLabel = new JLabel("Detecting Result");
			detectLabel.setPreferredSize(new Dimension(500, 350));

			detectInfo = new TextArea();
			detectInfo.setEditable(false);
			detectInfo.setPreferredSize(new Dimension(500, 300));

			btnRun = new Button("Run");

			this.setVisible(true);
		}

		public void start(String str) {
			GridBagConstraints c = new GridBagConstraints();
			con = this.getContentPane();

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			con.add(fileLabel, c);

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			con.add(fileInfo, c);

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 2;
			con.add(detectLabel, c);

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 3;
			con.add(detectInfo, c);

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 4;
			con.add(pB, c);

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 5;
			btnRun.addActionListener(bListener);
			con.add(btnRun, c);

		}

		class btnActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				int phF = 0, evF = 0, tjF = 0, spF = 0, rwF = 0, adF = 0;

				//

				if (e.getSource().equals(btnRun)) {
					try {
						Process p = Runtime.getRuntime()
								.exec("java -jar ./tool/apktool_2.2.3.jar d " + dfName + " -o ./result");
						BufferedReader bf = new BufferedReader(new InputStreamReader(p.getErrorStream()));
						String str = "";

						// pB.setValue(25);

						while ((str = bf.readLine()) != null) {
							System.out.println(str);
						}

						BufferedReader bf1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
						String str1 = "";

						while ((str1 = bf1.readLine()) != null) {
							detectInfo.append("[+] " + str1 + "\n");
						}
					} catch (IOException e2) {

					}

					try {
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(new FileInputStream(dfName), "utf-8"));

						detectInfo.setText("");
						String line;

						Process p = Runtime.getRuntime().exec("./tool/yara64.exe -r ./tool/myrule_index.yar ./result");

						BufferedReader bf = new BufferedReader(new InputStreamReader(p.getErrorStream()));
						String str = "";
						while ((str = bf.readLine()) != null) {
							//detectInfo.append("[+] " + str);
						}

						BufferedReader bf1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
						String str1 = "";
						while ((str1 = bf1.readLine()) != null) {
							detectInfo.append("[+] " + str1 + "\n");
							if(str1 != null) {
								evF = 1;
							}
							if(str1.contains("Meterprter") | str1.contains("Metasploit") | str1.contains("Encoding") 
									| str1.contains("drop") | str1.contains("Clicker") | str1.contains("Tachi")) {
								evF = 1;
							}
							if(str1.contains("Fake") | str1.contains("backdoor") | str1.contains("Autorun") 
									| str1.contains("ASSD") | str1.contains("BaDoink") | str1.contains("Xbot") 
									| str1.contains("Viking") | str1.contains("Triada")) {
								evF = 2;
							}
							if(str1.contains("Trojan") | str1.contains("SandroRat") | str1.contains("DeathRing")
									| str1.contains("chinese") | str1.contains("battery") | str1.contains("Tordow")
									| str1.contains("Slem") | str1.contains("Pink")) {
								tjF=2;
							}
							if(str1.contains("sms") | str1.contains("Spam") | str1.contains("SMS") | str1.contains("sniffer")) {
								phF = 1;
							}
							
							if(str1.contains("bank") | str1.contains("AVITOMMS") | str1.contains("Alipay") 
									| str1.contains("Tordow") | str1.contains("Switcher") | str1.contains("Bank")
									| str1.contains("RuMMS")) {
								phF=2;
							}
							if(str1.contains("Locker")) {
								rwF = 1;
							}
							if(str1.contains("rswm") | str1.contains("Dogspectus") | str1.contains("Ransomware")) {
								rwF = 2;
							}
							if(str1.contains("Copy") | str1.contains("Towel")) {
								spF = 1;
							}
							if(str1.contains("BadMirror") | str1.contains("Spy")) {
								spF = 2;
							}
							if(str1.contains("adware") | str1.contains("adver") ) {
								adF = 2;
							}
							
							//System.out.println(str1);
							
						}

						detectInfo.append("[+] Finished");

						reader.close();

					} catch (Exception e2) {
						// JOptionPane.showMessageDialog(this, "Error");
					}

					JFrame frame = buildFrame();
					
					int[] xPoly = { 390, 455, 455, 390, 325, 325 };
					int[] yPoly = { 425, 388, 313, 275, 312, 387 };

					//final BufferedImage image = ImageIO.read(new File("C:\\Users\\CSE_USER\\Downloads\\back.png"));
					
					// 스위치문 사이에 플래그 변수 변경하면
					
					/*
					evF = 2;
					phF = 1;
					tjF = 1;
					spF = 2;
					*/
					
					System.out.println(tjF);
					//case 1 or 2
					switch (phF) {
					case 1:
						yPoly[0] = 480;
						break;
					case 2:
						yPoly[0] = 520;
						break;
					}

					switch (evF) {
					case 1:
						xPoly[1] = 503;
						yPoly[1] = 415;
						break;
					case 2:
						xPoly[1] = 537;
						yPoly[1] = 435;
						break;
					}

					switch (tjF) {
					case 1:
						yPoly[3] = 220;
						break;
					case 2:
						yPoly[3] = 180;
						break;
					}

					switch (spF) {
					case 1:
						xPoly[5] = 277;
						yPoly[5] = 415;
						break;
					case 2:
						xPoly[5] = 243;
						yPoly[5] = 435;
						break;
					}

					switch (rwF) {
					case 1:
						xPoly[2] = 503;
						yPoly[2] = 285;
						break;
					case 2:
						xPoly[2] = 537;
						yPoly[2] = 265;
						break;
					}

					switch (adF) {
					case 1:
						xPoly[4] = 277;
						yPoly[4] = 285;
						break;
					case 2:
						xPoly[4] = 243;
						yPoly[4] = 265;
						break;
					}

					// 각 악성행위마다 플래그(F) 변수를 두고, 초기값 0인경우는 초록,1이면 노랑 ,2면 빨강에 배치하게끔 만듬

					Polygon mypoly = getHexagon(390, 350, 90);
					Polygon mypoly1 = getHexagon(390, 350, 130);
					Polygon mypoly2 = getHexagon(390, 350, 170);
					// 정육각형을 먼저 만들어보고 좌표 및 위치 수정
					Polygon hazardPoly = new Polygon(xPoly, yPoly, xPoly.length);
					// 시각화 될 육각그래프 모양
					JPanel pane = new JPanel() {
						@Override
						protected void paintComponent(Graphics g) {
							super.paintComponent(g);
							BufferedImage image = null;
							try {
								image = ImageIO.read(new File("./back.png"));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							g.drawImage(image, 0, 0, this);
							g.setColor(Color.blue);
														
							Graphics2D g2 = (Graphics2D) g;
							g2.setStroke(new BasicStroke(2));
							g.drawPolygon(hazardPoly);
							
							// g.setColor(Color.black);
							// g.drawPolygon(mypoly);
							// g.drawPolygon(mypoly1);
							// g.drawPolygon(mypoly2);

						}
					};

					frame.add(pane);
					frame.setVisible(true);

				}
			}
		}
		Polygon getHexagon(int x, int y, int h) {
			Polygon hexagon = new Polygon();

			double a;
			for (int i = 0; i < 7; i++) {
				double mya = Math.PI / 3.0 * i;
				
				hexagon.addPoint((int) (Math.round(x + Math.sin(mya) * h)), (int) (Math.round(y + Math.cos(mya) * h)));
			}
			
			return hexagon;
		}
		
		private JFrame buildFrame() {
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			frame.setSize(800, 740);
			frame.setVisible(true);
			return frame;
		}
		
		
	}

	
}

public class MwAnalysis {

	public static boolean deleteDirectory(File path) {
		if (!path.exists()) {
			return false;
		}

		File[] files = path.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				deleteDirectory(file);
			} else {
				file.delete();
			}
		}

		return path.delete();

	}

	public static void main(String[] args) {
		deleteDirectory(new File("./result"));
		MainFrame mf = new MainFrame();
	}

}
