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
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Scanner;

import org.w3c.dom.*;

class MainFrame extends JFrame {
	FlowLayout flow = new FlowLayout();
	private Container con; // 작업 영역을 위한 기본 패널을 담을 객체
	private ImageIcon imTitle, imMain; // 타이틀 바의 이미지를 가지는 객체
	private JButton fS = new JButton("File Select");
	private JButton sA = new JButton("Simple Analyze");
	private JButton cA = new JButton("Close Analyze");
	private JFileChooser jfc = new JFileChooser();
	private JTextField mainTxt;
	private String dfName;
	private String cmdInst;
	SimpleFrame sf;
	CloseFrame cf;

	public MainFrame() {
		super("Analysis Tool");
		super.setLayout(flow);
		this.init();
		this.start();

		this.setVisible(true);
	}

	public void init() {
		imMain = new ImageIcon("mainframe.jpg");
		imTitle = new ImageIcon("title.png"); // 특정 이미지 객체생성
		mainTxt = new JTextField("Android Package Analysis Tool");
		con = this.getContentPane(); // 다중 패널에서의 기본작업 영역 획득

		createMenu();
		this.setSize(500, 400);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension di = tk.getScreenSize();
		Dimension di1 = this.getSize();
		this.setLocation((int) (di.getWidth() / 2 - di1.getWidth() / 2),
				(int) (di.getHeight() / 2 - di1.getHeight() / 2));

		this.setIconImage(imTitle.getImage()); // 타이틀 바에 이미지
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

	public void createMenu() {
		JMenuBar mb = new JMenuBar();
		fileMenuActionListener fListener = new fileMenuActionListener();
		runMenuActionListener rListener = new runMenuActionListener();

		JMenuItem[] menuItem = new JMenuItem[2];
		String[] FileItem = { "Select File", "Exit" };
		String[] RunItem = { "Simple Analyze", "Close Analyze" };

		JMenu helpMenu = new JMenu("Help");
		helpMenu.add(new JMenuItem("About..."));

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
			switch (cmd) { // 메뉴 아이템의 종류 구분
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

	class SimpleFrame extends JFrame {
		GridBagLayout grid = new GridBagLayout();
		private Container con;
		private ImageIcon imTitle;
		private JLabel fileLabel;
		private JLabel maniLabel;
		private JLabel scoreLabel;
		private TextArea fileInfo;
		private TextArea maniInfo;
		private TextArea score;
		private JTextField maintext;
		private Button btnRun;
		btnActionListener bListener = new btnActionListener();

		public SimpleFrame(String str) {
			super("Simple Analysis");
			super.setLayout(grid);
			init();
			start(str);

		}

		public void init() {
			imTitle = new ImageIcon("title.png"); // 특정 이미지 객체생성
			this.setIconImage(imTitle.getImage()); // 타이틀 바에 이미지
			this.setSize(530, 700);

			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension di = tk.getScreenSize();
			Dimension di1 = this.getSize();
			this.setLocation((int) (di.getWidth() / 2 - di1.getWidth() / 2),
					(int) (di.getHeight() / 2 - di1.getHeight() / 2));

			GridBagConstraints c = new GridBagConstraints();

			con = this.getContentPane();

			fileInfo = new TextArea();
			fileInfo.setText(dfName);
			fileInfo.setPreferredSize(new Dimension(500, 50));
			fileInfo.setEditable(false);

			maniInfo = new TextArea();
			maniInfo.setEditable(false);
			maniInfo.setPreferredSize(new Dimension(500, 350));

			score = new TextArea();
			score.setEditable(false);
			score.setPreferredSize(new Dimension(500, 150));

			fileLabel = new JLabel("File Information");
			fileLabel.setPreferredSize(new Dimension(100, 20));
			// fileField.setHorizontalAlignment(JLabel.CENTER);

			maniLabel = new JLabel("Permission");
			maniLabel.setPreferredSize(new Dimension(100, 20));
			// maniField.setHorizontalAlignment(JLabel.CENTER);

			scoreLabel = new JLabel("Score");
			scoreLabel.setPreferredSize(new Dimension(100, 20));
			// scoreField.setHorizontalAlignment(JLabel.CENTER);

			maintext = new JTextField("Simple Analysis");
			maintext.setEditable(false);
			maintext.setHorizontalAlignment(JLabel.CENTER);

			btnRun = new Button("Run");

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
			con.add(maniLabel, c);

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 3;
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
			c.gridx = 0;
			c.gridy = 7;
			con.add(maintext, c);

			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 6;
			btnRun.addActionListener(bListener);
			con.add(btnRun, c);

			this.setVisible(true);
		}

		public void start(String str) {

		}

		class btnActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(btnRun)) {
					maintext.setText("Decompile...");
					try {
						
						Process p = Runtime.getRuntime().exec(
								"java -jar ./apktool_2.2.3.jar d " + dfName);
						BufferedReader bf = new BufferedReader(new InputStreamReader(p.getErrorStream()));
						String str = "";

						while ((str = bf.readLine()) != null) {
							System.out.println(str);
						}

						BufferedReader bf1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
						String str1 = "";

						while ((str1 = bf1.readLine()) != null) {
							maniInfo.append(str1 + "\n");
						}

						maniInfo.append("manifest create success\n\n");

					} catch (IOException e2) {

					}
					
					maintext.setText("Make Permission...");
					
					try {
						
						// DOM Document 객체를 생성하는 단계
						DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
						DocumentBuilder parser = f.newDocumentBuilder();

						// XML 파일 파싱하는 단계
						Document xmlDoc = null;
						String url = "./Amoney/AndroidManifest.xml";
						xmlDoc = parser.parse(url);

						// 루트 엘리먼트 접근
						Element root = xmlDoc.getDocumentElement();
						// System.out.println(root.getTagName());

						NodeList bookNodes = root.getElementsByTagName("uses-permission");
						int length = bookNodes.getLength();
						for (int i = 0; i < length; i++) {
							Node bookNode = bookNodes.item(i);
							NamedNodeMap bookNodeAttrs = bookNode.getAttributes(); // 속성 값을 리턴
							String isbn = bookNodeAttrs.getNamedItem("android:name").getNodeValue();
							// String kind = bookNodeAttrs.getNamedItem("kind").getNodeValue();

							NodeList bookChildNodes = bookNode.getChildNodes();
							String child = "";
							for (int k = 0; k < bookChildNodes.getLength(); k++) {
								Node bookChild = bookChildNodes.item(k);
								if (bookChild.getNodeType() == Node.ELEMENT_NODE) {
									// author 노드의 값 : 홍길동 출력
									child += bookChild.getChildNodes().item(0).getNodeValue() + "  ";
								}
							}

							maniInfo.append(isbn + "\n");
							// System.out.println(kind);
							System.out.println(child);
						}
					} catch (Exception e4) {
						System.out.println(e4.getMessage());
						System.out.println(e4.toString());
					}
					
					maintext.setText("Scoring...");
					
					try {
						BufferedReader reader  =  new BufferedReader(new InputStreamReader(new FileInputStream(dfName),"utf-8"));
						
						score.setText("");
						String line;
											
						Process p = Runtime.getRuntime().exec("python ./androguard/androrisk.py -i " + dfName);
						
						BufferedReader bf=new BufferedReader(new InputStreamReader(p.getErrorStream()));
					    String str="";
					    while((str=bf.readLine())!=null){
					    	score.append(str);
					    }
					    
					    BufferedReader bf1=new BufferedReader(new InputStreamReader(p.getInputStream()));
				        String str1="";
				        while((str1=bf1.readLine())!=null){
				           score.append(str1+"\n");
				        }
				        
				        Process p2=Runtime.getRuntime().exec("java -jar ./apktool_2.2.3.jar d " + dfName);
				        BufferedReader bf2=new BufferedReader(new InputStreamReader(p.getErrorStream()));
				        String str2="";
				        while((str=bf.readLine())!=null){
				            System.out.println(str);
				        }

				        BufferedReader bf3=new BufferedReader(new InputStreamReader(p.getInputStream()));
				        String str3="";
				        while((str1=bf1.readLine())!=null){
				            score.append(str3+"\n");
				        }
					    
						reader.close();
						
						//setTitle(dialog.getFile());
					} catch (Exception e2) {
						//JOptionPane.showMessageDialog(this, "Error");
					}
					
					maintext.setText("Finished");

				}

			}
		}

	}

	class CloseFrame extends JFrame {
		FlowLayout flow = new FlowLayout();
		private Container con;
		private ImageIcon imTitle;

		public CloseFrame(String str) {
			super("Close Analysis");
			super.setLayout(flow);
			init();
			start(str);
		}

		public void init() {
			imTitle = new ImageIcon("title.png");
			this.setIconImage(imTitle.getImage());

			this.setSize(800, 700);
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension di = tk.getScreenSize();
			Dimension di1 = this.getSize();
			this.setLocation((int) (di.getWidth() / 2 - di1.getWidth() / 2),
					(int) (di.getHeight() / 2 - di1.getHeight() / 2));

			this.setVisible(true);
		}

		public void start(String str) {
			con = this.getContentPane();

		}
	}

	/*
	public void RunProcess(String cmdInst) throws IOException {
		try {
			Process process = Runtime.getRuntime()
					.exec("python ./androguard/" + cmdInst + " -i" + dfName);
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			Scanner scanner = new Scanner(br);
			scanner.useDelimiter(System.getProperty("line.separator"));
			while (scanner.hasNext())
				System.out.println(scanner.next());
			scanner.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	*/

}

public class MwAnalysis {
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
	}

}
