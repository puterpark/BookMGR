package com.kosmo.book;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SelectMem extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JPanel infoPane;
	private JButton selectBtn;
	private JLabel mcodeLabel1;
	private JLabel mnameLabel1;
	private JLabel mbirthLabel1;
	private JLabel mphoneLabel1;
	private JLabel mcodeLabel2;
	private JLabel mnameLabel2;
	private JLabel mbirthLabel2;
	private JLabel mphoneLabel2;
	private JButton cancelBtn;
	
	private BookMgr bookmgr = null;
	private JTextField searchText;
	private JButton searchBtn;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SelectMem frame = new SelectMem();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public ImageIcon imageResize(String path, int s) {
		ImageIcon fi = new ImageIcon(BookMgr.class.getResource(path));
		Image si = fi.getImage();
		Image ti = si.getScaledInstance(s, s, java.awt.Image.SCALE_SMOOTH);
		ImageIcon li = new ImageIcon(ti);
		return li;
	}

	public Object[][] memTableList() {
		// DB 리스트 가져오기
		ArrayList<MemVO> list = new ArrayList<MemVO>();
		MemCrud mc = new MemCrud();
		
		list = mc.memList();
		
//		System.out.println("db 갖다와서..");
		Object data[][] = new Object[list.size()][5];
		for (int i = 0; i < list.size(); i++) {
			
			data[i][0] = list.get(i).getMcode();
			data[i][1] = list.get(i).getMname();
			data[i][2] = list.get(i).getMbirth();
			data[i][3] = list.get(i).getMphone();
			data[i][4] = list.get(i).getMregdate();
		}
		return data;
	}
	
	public void memTablePrint() {
		Object data[][] = memTableList();

		String[] colName = {"회원코드", "이름", "생년월일", "전화번호", "회원등록일"};
		
		System.out.println("memTablePrint(); call");
		
		DefaultTableModel model = new DefaultTableModel(data, colName);
		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();   

		table.setModel(model);
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

//		bookTable.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(4).setMinWidth(0);
		table.getColumnModel().getColumn(4).setMaxWidth(0);
		
//		table.getColumnModel().getColumn(7).setMinWidth(55);
//		table.getColumnModel().getColumn(7).setMaxWidth(55);
//		table.getColumnModel().getColumn(9).setMinWidth(60);
//		table.getColumnModel().getColumn(9).setMaxWidth(60);
//
//		
//		bookTable.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);//가운데정렬
//		bookTable.getColumnModel().getColumn(1).setPreferredWidth(200);
//		bookTable.getColumnModel().getColumn(4).setPreferredWidth(10);
//		bookTable.getColumnModel().getColumn(9).setCellRenderer(celAlignCenter);//가운데정렬
		System.out.println("memTablePrint call Success");
	}
	
	public Object[][] searchMemTableList() {
		// DB 리스트 가져오기
		ArrayList<MemVO> list = new ArrayList<MemVO>();
		MemCrud mc = new MemCrud();
		
		String searchStr = searchText.getText();
		
		list = mc.searchMem(searchStr);
		
//		System.out.println("db 갖다와서..");
		Object data[][] = new Object[list.size()][5];
		for (int i = 0; i < list.size(); i++) {
			
			data[i][0] = list.get(i).getMcode();
			data[i][1] = list.get(i).getMname();
			data[i][2] = list.get(i).getMbirth();
			data[i][3] = list.get(i).getMphone();
			data[i][4] = list.get(i).getMregdate();
		}
		return data;
	}
	
	public void searchMemTablePrint() {
		Object data[][] = searchMemTableList();

		String[] colName = {"회원코드", "이름", "생년월일", "전화번호", "회원등록일"};
		
		System.out.println("searchMemTablePrint(); call");
		
		DefaultTableModel model = new DefaultTableModel(data, colName);
		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();   

		table.setModel(model);
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

//		bookTable.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(4).setMinWidth(0);
		table.getColumnModel().getColumn(4).setMaxWidth(0);
		
//		table.getColumnModel().getColumn(7).setMinWidth(55);
//		table.getColumnModel().getColumn(7).setMaxWidth(55);
//		table.getColumnModel().getColumn(9).setMinWidth(60);
//		table.getColumnModel().getColumn(9).setMaxWidth(60);
//
//		
//		bookTable.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);//가운데정렬
//		bookTable.getColumnModel().getColumn(1).setPreferredWidth(200);
//		bookTable.getColumnModel().getColumn(4).setPreferredWidth(10);
//		bookTable.getColumnModel().getColumn(9).setCellRenderer(celAlignCenter);//가운데정렬
		System.out.println("searchMemTablePrint call Success");
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public SelectMem(BookMgr bookMgr) {
		this.bookmgr = bookMgr;
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 588, 330);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("회원 선택");
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int irow = table.getSelectedRow();
				int icol = table.getSelectedColumn();
				System.out.println(table.getValueAt(irow, icol));; //n행, n열 데이터는 무엇?

				mcodeLabel2.setText(table.getValueAt(irow, 0).toString());
				mnameLabel2.setText(table.getValueAt(irow, 1).toString());
				mbirthLabel2.setText(table.getValueAt(irow, 2).toString());
				mphoneLabel2.setText(table.getValueAt(irow, 3).toString());
			
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"회원코드", "이름", "생년월일", "전화번호", "회원등록일"
			}
		));
		memTablePrint();
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 7, 359, 251);
		panel.add(scrollPane);
		
		infoPane = new JPanel();
		infoPane.setFont(new Font("D2Coding", Font.PLAIN, 12));
		infoPane.setBorder(new TitledBorder(new LineBorder(new Color(130, 135, 144), 1),"대여할 회원"));
		infoPane.setBounds(361, 0, 213, 290);
		panel.add(infoPane);
		infoPane.setLayout(null);
		
		mcodeLabel1 = new JLabel("회원코드");
		mcodeLabel1.setBounds(12, 35, 60, 30);
		infoPane.add(mcodeLabel1);
		mcodeLabel1.setFont(new Font("D2Coding", Font.PLAIN, 15));
		
		mnameLabel1 = new JLabel("이름");
		mnameLabel1.setBounds(12, 85, 60, 30);
		infoPane.add(mnameLabel1);
		mnameLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		mnameLabel1.setFont(new Font("D2Coding", Font.PLAIN, 15));
		
		mbirthLabel1 = new JLabel("생년월일");
		mbirthLabel1.setBounds(12, 135, 60, 30);
		infoPane.add(mbirthLabel1);
		mbirthLabel1.setFont(new Font("D2Coding", Font.PLAIN, 15));
		
		mphoneLabel1 = new JLabel("전화번호");
		mphoneLabel1.setBounds(12, 185, 60, 30);
		infoPane.add(mphoneLabel1);
		mphoneLabel1.setFont(new Font("D2Coding", Font.PLAIN, 15));
		
		mcodeLabel2 = new JLabel("");
		mcodeLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		mcodeLabel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(130,135,144), null));
		mcodeLabel2.setFont(new Font("D2Coding", Font.PLAIN, 15));
		mcodeLabel2.setBounds(89, 35, 115, 30);
		infoPane.add(mcodeLabel2);
		
		mnameLabel2 = new JLabel("");
		mnameLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		mnameLabel2.setFont(new Font("D2Coding", Font.PLAIN, 15));
		mnameLabel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(130,135,144), null));
		mnameLabel2.setBounds(89, 85, 115, 30);
		infoPane.add(mnameLabel2);
		
		mbirthLabel2 = new JLabel("");
		mbirthLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		mbirthLabel2.setFont(new Font("D2Coding", Font.PLAIN, 15));
		mbirthLabel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(130,135,144), null));
		mbirthLabel2.setBounds(89, 135, 115, 30);
		infoPane.add(mbirthLabel2);
		
		mphoneLabel2 = new JLabel("");
		mphoneLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		mphoneLabel2.setFont(new Font("D2Coding", Font.PLAIN, 15));
		mphoneLabel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(130,135,144), null));
		mphoneLabel2.setBounds(89, 185, 115, 30);
		infoPane.add(mphoneLabel2);
		
		selectBtn = new JButton("선택", imageResize("/com/test/swing/check.png", 15));
		selectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int rowCount = 0;
				
				if(bookMgr.yCheckPossibleBookTable.getModel() != null) {
					rowCount = bookMgr.yCheckPossibleBookTable.getModel().getRowCount();
				}
				
				RentalCrud rc = new RentalCrud();
				
				String bcode = "";
				String mcode = mcodeLabel2.getText();
				
				System.out.println(bookMgr.yCheckPossibleBookTable.getModel().getRowCount() + "-------");
								
				for(int i=0; i<rowCount; i++) {
					//bookMgr.yCheckPossibleBookTable.getValueAt(i,0)
					//-------대여정보입력-------------
					bcode = bookMgr.yCheckPossibleBookTable.getValueAt(i, 0).toString();
					System.out.println(bcode + ", " + mcode);
					rc.rentBook(bcode, mcode);
					//-------북대여상태코드 변경 <<------
					BookVO bvo = new BookVO();
					bvo.setBcode(bcode);
					rc.nCheckRent(bvo);
				}
				
				bookMgr.nCheckReturnEvent();
				bookMgr.nCheckRentEvent();
				dispose();
			}
		});
		selectBtn.setBounds(12, 248, 85, 30);
		infoPane.add(selectBtn);
		selectBtn.setFont(new Font("D2Coding", Font.PLAIN, 15));
		
		cancelBtn = new JButton("취소", imageResize("/com/test/swing/cancel.png", 15));
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelBtn.setBounds(116, 248, 85, 30);
		infoPane.add(cancelBtn);
		cancelBtn.setFont(new Font("D2Coding", Font.PLAIN, 15));
		
		searchText = new JTextField();
		searchText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchMemTablePrint();
				} else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					searchText.setText("");
					memTablePrint();
				}	
			}
		});
		searchText.setBounds(33, 259, 239, 30);
		panel.add(searchText);
		searchText.setColumns(10);
		
		
		searchBtn = new JButton("검색", imageResize("/com/test/swing/search.png", 15));
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchMemTablePrint();				
			}
		});
		searchBtn.setFont(new Font("D2Coding", Font.PLAIN, 15));
		searchBtn.setBounds(275, 259, 85, 30);
		panel.add(searchBtn);
		
		
		ImageIcon fi = new ImageIcon(SelectMem.class.getResource("/com/test/swing/refresh.png"));
		Image si = fi.getImage();
		Image ti = si.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		ImageIcon li = new ImageIcon(ti);
		JButton memPrintBtn = new JButton(li);
		memPrintBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memTablePrint();
			}
		});
		memPrintBtn.setFont(new Font("굴림", Font.PLAIN, 5));
		memPrintBtn.setBounds(0, 259, 30, 30);
		panel.add(memPrintBtn);
		
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("C:\\34DEV\\Java\\workspaceJava\\JAVA_PRJ\\src\\com\\test\\swing\\book.png");
		setIconImage(img);
		
		setVisible(true);
		setResizable(false);
	}
}
