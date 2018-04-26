package com.kosmo.book;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class BookMgr extends JFrame {

	public JPanel contentPane;
	public JMenuBar menuBar;
	public JMenu fileMenu;
	public JMenuItem fileMenuExit;
	public JMenu bookMenu;
	public JMenuItem menuItem;
	public JMenu mnNewMenu_2;
	public JMenu mnm;
	public JMenu mnNewMenu;
	public JPanel menuPane;
	public JPanel menuPane2;
	public JPanel menuPane3;
	public JButton bookBtn;
	public JButton rentBtn;
	public Component memberBtn;
	public JPanel mainPane;
	public JPanel bookPane;
	public JPanel rentalPane;
	public JPanel memberPane;
	
	public JTable bookTable;
	public JScrollPane scrollPane;
	public JPanel panel;
	public JButton bookaddBtn;
	public JButton bookeditBtn;
	public JButton bookdelBtn;
	public JPanel bookBottomPane;
	public JLabel bcodeLabel;
	public JLabel bpublisherLabel;
	public JLabel bisbnLabel;
	public JLabel bpriceLabel;
	public JLabel bstatusLabel;
	public JLabel bregdateLabel;
	public JTextField btitleText;
	public JTextField bauthorText;
	public JTextField bpublisherText;
	public JTextField btranslatorText;
	public JTextField bisbnText;
	public JTextField bpriceText;
	public JTextField bpageText;
	public JPanel bookTopPane;
	public JLabel bcodeLabel1;
	public JLabel bstatusLabel1;
	public JLabel bregdateLabel1;
	private JPanel memberTopPane;
	private JPanel memberBottomPane;
	private JScrollPane scrollPane_1;
	private JTable memTable;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private BookMgr bookMgrInstance;
	private JTextField mnameText;
	private JLabel label;
	private JLabel label_1;
	private JTextField mbirthText;
	private JTextField mphoneText;
	private JPanel panel_5;
	private JLabel label_2;
	private JTextField mnameText2;
	private JLabel label_3;
	private JTextField mbirthText2;
	private JLabel label_4;
	private JTextField mphoneText2;
	private JButton button;
	private JButton button_1;
	private JPanel panel_7;
	private JLabel mcodeLabel;
	private JPanel rentalUpPane;
	private JPanel rentalDownPane;
	private JPanel panel_8;
	private JPanel panel_9;
	private JTable nCheckPossibleBookTable;
	private JScrollPane scrollPane_4;
	public JTable yCheckPossibleBookTable;
	private JScrollPane scrollPane_5;
	private JScrollPane scrollPane_6;
	private JButton button_3;
	private JTable nCheckImpossibleBookTable;
	private JTable yCheckImpossibleBookTable;
	private JButton yBcheckBtn;
	private JButton nBcheckBtn;
	private JButton yBcheckBtn2;
	private JButton nBcheckBtn2;
	private JLabel rentBcode;
	private JLabel returnBcode;
	private JLabel returnRcode;
	private JPanel panel_4;
	private JScrollPane scrollPane_2;
	private JTable traceTable;
	private JButton memSearchBtn;
	private JButton memTableBtn;
	private JTextField memSearchText;
	private JButton bookTablePrintBtn;
	private JTextField bookSearchText;
	private JButton bookSearchBtn;
	private JPanel panel_6;
	private JButton possibleBookPrintBtn;
	private JTextField possibleBookSearchText;
	private JButton possibleBookSearchBtn;
	private JButton impossibleBookPrintBtn;
	private JTextField impossibleBookSearchText;
	private JButton impossibleBookSearchBtn;
	private JMenuItem menuItem_1;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JLabel lblMadeByPuter;
	private JLabel lblNewLabel_1;
	private JPanel panel_10;
	
	public void setBookMgrInstance(BookMgr b) {
		this.bookMgrInstance = b;
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					BookMgr frame = new BookMgr();
					Toolkit toolkit = Toolkit.getDefaultToolkit();
					Image img = toolkit.getImage("C:\\34DEV\\Java\\workspaceJava\\JAVA_PRJ\\src\\com\\test\\swing\\book.png");
					frame.setIconImage(img);
					frame.setBookMgrInstance(frame);  //주소 셋..
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ImageIcon imageResize(String path, int s) {
		ImageIcon fi = new ImageIcon(BookMgr.class.getResource(path));
		Image si = fi.getImage();
		Image ti = si.getScaledInstance(s, s, java.awt.Image.SCALE_SMOOTH);
		ImageIcon li = new ImageIcon(ti);
		return li;
	}
	
	public ImageIcon imageResize(String path, int w, int h) {
		ImageIcon fi = new ImageIcon(BookMgr.class.getResource(path));
		Image si = fi.getImage();
		Image ti = si.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
		ImageIcon li = new ImageIcon(ti);
		return li;
	}
	
	public Object[][] bookTableList() {
		// DB 리스트 가져오기
		ArrayList<WrapperVO> list = new ArrayList<WrapperVO>();
		BookCrud b = new BookCrud();
		
		
		list = b.bookList();
//		System.out.println("db 갖다와서..");
		Object data[][] = new Object[list.size()][12];
		for (int i = 0; i < list.size(); i++) {
			
			data[i][0] = list.get(i).bvo.getBcode();
			data[i][1] = list.get(i).bvo.getBtitle();
			data[i][2] = list.get(i).bvo.getBauthor();
			data[i][3] = list.get(i).bvo.getBtranslator();
			data[i][4] = list.get(i).bvo.getBpublisher();
			data[i][5] = list.get(i).bvo.getBisbn();
			data[i][6] = list.get(i).bvo.getBprice();
			data[i][7] = list.get(i).bvo.getBpage();
			data[i][8] = list.get(i).bvo.getBregdate();
			data[i][9] = list.get(i).rvo.getStatus();
			data[i][10] = list.get(i).bvo.getBcheckRent();
			data[i][11] = list.get(i).bvo.getBcheckReturn();
		}
		return data;
	}
	
	public void bookTablePrint() {
		Object data[][] = bookTableList();

		String[] colName = {"도서코드", "도서명", "지은이", "옮긴이", 
							"출판사", "ISBN", "가격", "페이지", 
							"등록일자", "상태", "렌트체크", "리턴체크"};
		
		System.out.println("bookTablePrint(); call");
		
		DefaultTableModel model = new DefaultTableModel(data, colName);
		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();   

		bookTable.setModel(model);
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		

//		bookTable.getColumnModel().getColumn(0).setPreferredWidth(10);
		bookTable.getColumnModel().getColumn(0).setMinWidth(60);
		bookTable.getColumnModel().getColumn(0).setMaxWidth(60);
		bookTable.getColumnModel().getColumn(1).setMinWidth(200);
		bookTable.getColumnModel().getColumn(3).setMinWidth(48);
		bookTable.getColumnModel().getColumn(3).setMaxWidth(48);
		
		bookTable.getColumnModel().getColumn(5).setMinWidth(86);
		bookTable.getColumnModel().getColumn(5).setMaxWidth(86);
		bookTable.getColumnModel().getColumn(6).setMinWidth(48);
		bookTable.getColumnModel().getColumn(6).setMaxWidth(48);
		bookTable.getColumnModel().getColumn(7).setMinWidth(48);
		bookTable.getColumnModel().getColumn(7).setMaxWidth(48);
		bookTable.getColumnModel().getColumn(8).setMinWidth(115);
		bookTable.getColumnModel().getColumn(8).setMaxWidth(115);
		bookTable.getColumnModel().getColumn(9).setMinWidth(60);
		bookTable.getColumnModel().getColumn(9).setMaxWidth(60);
		
		bookTable.getColumnModel().getColumn(10).setMinWidth(0);
		bookTable.getColumnModel().getColumn(10).setMaxWidth(0);
		
		bookTable.getColumnModel().getColumn(11).setMinWidth(0);
		bookTable.getColumnModel().getColumn(11).setMaxWidth(0);
		
		
		

		
		bookTable.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);//가운데정렬
		bookTable.getColumnModel().getColumn(3).setCellRenderer(celAlignCenter);//가운데정렬
		bookTable.getColumnModel().getColumn(6).setCellRenderer(celAlignCenter);//가운데정렬
		bookTable.getColumnModel().getColumn(7).setCellRenderer(celAlignCenter);//가운데정렬
		bookTable.getColumnModel().getColumn(8).setCellRenderer(celAlignCenter);//가운데정렬
//		bookTable.getColumnModel().getColumn(1).setPreferredWidth(200);
//		bookTable.getColumnModel().getColumn(4).setPreferredWidth(10);
		bookTable.getColumnModel().getColumn(9).setCellRenderer(celAlignCenter);//가운데정렬
		
		/*<!-- 열 숨기기 --!>*/
//		bookTable.getColumnModel().getColumn(3).setMinWidth(0);
//		bookTable.getColumnModel().getColumn(3).setMaxWidth(0);
//		bookTable.getColumnModel().getColumn(5).setMinWidth(0);
//		bookTable.getColumnModel().getColumn(5).setMaxWidth(0);
//		bookTable.getColumnModel().getColumn(6).setMinWidth(0);
//		bookTable.getColumnModel().getColumn(6).setMaxWidth(0);
//		bookTable.getColumnModel().getColumn(7).setMinWidth(0);
//		bookTable.getColumnModel().getColumn(7).setMaxWidth(0);
//		bookTable.getColumnModel().getColumn(8).setMinWidth(0);
//		bookTable.getColumnModel().getColumn(8).setMaxWidth(0);
	}
	
	public void bookUpdateEvent() {
		int result = JOptionPane.showConfirmDialog(null, "도서정보가 수정됩니다.", "도서정보 수정 확인", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.CLOSED_OPTION || result == JOptionPane.NO_OPTION) {

		} else if (result == JOptionPane.YES_OPTION) {
			BookCrud b = new BookCrud();
			BookVO vo = new BookVO();

			vo.setBcode(bcodeLabel1.getText());
			vo.setBtitle(btitleText.getText());
			vo.setBauthor(bauthorText.getText());
			vo.setBtranslator(btranslatorText.getText());
			vo.setBpublisher(bpublisherText.getText());
			vo.setBisbn(bisbnText.getText());
			vo.setBprice(Integer.parseInt((bpriceText.getText())));
			vo.setBpage(bpageText.getText());
			
			b.bookUpdate(vo);
			
			bcodeLabel1.setText("");
			btitleText.setText("");
			bauthorText.setText("");
			btranslatorText.setText("");
			bpublisherText.setText("");
			bisbnText.setText("");
			bpriceText.setText("");
			bpageText.setText("");
			bregdateLabel1.setText("");
			bstatusLabel1.setText("");

			bookTablePrint();
		}
	}
	
	public void bookDeleteEvent() {
		int result = JOptionPane.showConfirmDialog(null, "도서정보가 삭제됩니다.", "도서정보 삭제 확인", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.CLOSED_OPTION || result == JOptionPane.NO_OPTION) {

		} else if (result == JOptionPane.YES_OPTION) {
			String bcode = bcodeLabel1.getText();

			BookCrud b = new BookCrud();

			b.bookDelete(bcode);

			bcodeLabel1.setText("");

			bookTablePrint();
		}
	}
	
	public Object[][] memTableList() {
		// DB 리스트 가져오기
		ArrayList<MemVO> list = new ArrayList<MemVO>();
		MemCrud mc = new MemCrud();
		
		list = mc.memList();
		
//		System.out.println("db 갖다와서..");
		Object data1[][] = new Object[list.size()][10];
		for (int i = 0; i < list.size(); i++) {
			
			data1[i][0] = list.get(i).getMcode();
			data1[i][1] = list.get(i).getMname();
			data1[i][2] = list.get(i).getMbirth();
			data1[i][3] = list.get(i).getMphone();
			data1[i][4] = list.get(i).getMregdate();
		}
		return data1;
	}
	
	public void memTablePrint() {
		Object data1[][] = memTableList();

		String[] colName1 = {"회원코드", "이름", "생년월일", "전화번호", "회원등록일"};
		
		System.out.println("memTablePrint(); call");
		
		DefaultTableModel model1 = new DefaultTableModel(data1, colName1);
		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();   

		memTable.setModel(model1);
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		

//		bookTable.getColumnModel().getColumn(0).setPreferredWidth(10);
//		bookTable.getColumnModel().getColumn(0).setMinWidth(60);
//		bookTable.getColumnModel().getColumn(0).setMaxWidth(60);
//		
//		bookTable.getColumnModel().getColumn(7).setMinWidth(55);
//		bookTable.getColumnModel().getColumn(7).setMaxWidth(55);
//		bookTable.getColumnModel().getColumn(9).setMinWidth(60);
//		bookTable.getColumnModel().getColumn(9).setMaxWidth(60);
//
//		
//		bookTable.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);//가운데정렬
//		bookTable.getColumnModel().getColumn(1).setPreferredWidth(200);
//		bookTable.getColumnModel().getColumn(4).setPreferredWidth(10);
//		bookTable.getColumnModel().getColumn(9).setCellRenderer(celAlignCenter);//가운데정렬
		System.out.println("memTablePrint call Success");
	}
	
	public void memInsertEvent() {
		int result = JOptionPane.showConfirmDialog(null, "회원정보가 추가됩니다.", "회원정보 추가 확인", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.CLOSED_OPTION || result == JOptionPane.NO_OPTION) {
			
		} else if (result == JOptionPane.YES_OPTION) {
			MemCrud mc = new MemCrud();
			MemVO mvo = new MemVO();
			
//			pstmt.setString(1, vo.getBtitle());
//			pstmt.setString(2, vo.getBauthor());
//			pstmt.setString(3, vo.getBtranslator());
//			pstmt.setString(4, vo.getBpublisher());
//			pstmt.setString(5, vo.getBisbn());
//			pstmt.setInt(6, vo.getBprice());
//			pstmt.setString(7, vo.getBpage());
			
			mvo.setMname(mnameText.getText());
			mvo.setMbirth(mbirthText.getText());
			mvo.setMphone(mphoneText.getText());
			
			mc.memInsert(mvo);
			
			mnameText.setText("");
			mbirthText.setText("");
			mphoneText.setText("");
			
			memTablePrint();
		}
	}
	
	public Object[][] memTraceTableList() {
		// DB 리스트 가져오기
	
		ArrayList<WrapperVO> list = new ArrayList<WrapperVO>();
		MemCrud mc = new MemCrud();
		MemVO mvo = new MemVO();
		
		mvo.setMcode(mcodeLabel.getText());
		
		list = mc.memTraceList(mvo);
		
//		System.out.println("db 갖다와서..");
		Object data[][] = new Object[list.size()][3];
		for (int i = 0; i < list.size(); i++) {
			
			data[i][0] = list.get(i).bvo.getBcode();
			data[i][1] = list.get(i).bvo.getBtitle();
			data[i][2] = list.get(i).rvo.getReturndate();
		}
		return data;
	}
	
	public void memTraceTablePrint() {
		Object data[][] = memTraceTableList();

		String[] colName = {"도서코드", "도서명", "최근활동"};
		
		System.out.println("memTraceTablePrint(); call");
		
		DefaultTableModel model = new DefaultTableModel(data, colName);
		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();   

		traceTable.setModel(model);
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		traceTable.getColumnModel().getColumn(0).setMinWidth(58);
		traceTable.getColumnModel().getColumn(0).setMaxWidth(58);
		
		traceTable.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);//가운데정렬

		System.out.println("memTraceTablePrint call Success");
		
		
	}
	
	public void memUpdateEvent() {
		int result = JOptionPane.showConfirmDialog(null, "회원정보가 수정됩니다.", "회원정보 수정 확인", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.CLOSED_OPTION || result == JOptionPane.NO_OPTION) {

		} else if (result == JOptionPane.YES_OPTION) {
			
			MemCrud mc = new MemCrud();
			MemVO mvo = new MemVO();
			
			mvo.setMcode(mcodeLabel.getText());
			mvo.setMname(mnameText2.getText());
			mvo.setMbirth(mbirthText2.getText());
			mvo.setMphone(mphoneText2.getText());
			
			mc.memUpdate(mvo);
			
			mcodeLabel.setText("");
			mnameText2.setText("");
			mbirthText2.setText("");
			mphoneText2.setText("");
			
			memTablePrint();
		}
	}
	
	public void memDeleteEvent() {
		int result = JOptionPane.showConfirmDialog(null, "회원정보가 삭제됩니다.", "회원정보 삭제 확인", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.CLOSED_OPTION || result == JOptionPane.NO_OPTION) {

		} else if (result == JOptionPane.YES_OPTION) {
//			String bcode = bcodeLabel1.getText();
//
//			BookCrud b = new BookCrud();
//
//			b.bookDelete(bcode);
//
//			bcodeLabel1.setText("");
//
//			bookTablePrint();
			
			String mcode = mcodeLabel.getText();
			
			MemCrud mc = new MemCrud();
			
			mc.memDelete(mcode);
			
			mcodeLabel.setText("");
			
			memTablePrint();
		}
	}
	
	
	
	public Object[][] possibleBookTableList() {
		// DB 리스트 가져오기
		ArrayList<WrapperVO> list = new ArrayList<WrapperVO>();
		RentalCrud rc = new RentalCrud();
		
		
		list = rc.possibleBookList();
//		System.out.println("db 갖다와서..");
		Object data[][] = new Object[list.size()][10];
		for (int i = 0; i < list.size(); i++) {
			
			data[i][0] = list.get(i).bvo.getBcode();
			data[i][1] = list.get(i).bvo.getBtitle();
			data[i][2] = list.get(i).bvo.getBauthor();
			data[i][3] = list.get(i).rvo.getStatus();
		}
		return data;
	}
	
	public void possibleBookTablePrint() {
		Object data[][] = possibleBookTableList();

		String[] colName = {"도서코드", "도서명", "지은이", "상태" };
		
		System.out.println("possibleBookTablePrint(); call");
		
		DefaultTableModel model = new DefaultTableModel(data, colName);
		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();   

		nCheckPossibleBookTable.setModel(model);
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

		nCheckPossibleBookTable.getColumnModel().getColumn(0).setMinWidth(58);
		nCheckPossibleBookTable.getColumnModel().getColumn(0).setMaxWidth(58);
		
		nCheckPossibleBookTable.getColumnModel().getColumn(2).setMinWidth(95);
		nCheckPossibleBookTable.getColumnModel().getColumn(2).setMaxWidth(95);
		
		nCheckPossibleBookTable.getColumnModel().getColumn(3).setMinWidth(58);
		nCheckPossibleBookTable.getColumnModel().getColumn(3).setMaxWidth(58);
		
		nCheckPossibleBookTable.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);//가운데정렬
		nCheckPossibleBookTable.getColumnModel().getColumn(3).setCellRenderer(celAlignCenter);//가운데정렬
	}
	
	public Object[][] toRentBookTableList() {
			// DB 리스트 가져오기
			ArrayList<BookVO> list = new ArrayList<BookVO>();
			RentalCrud rc = new RentalCrud();
			
			list = rc.toRentBookList();
			
	//		System.out.println("db 갖다와서..");
			Object data[][] = new Object[list.size()][3];
			for (int i = 0; i < list.size(); i++) {
				
				data[i][0] = list.get(i).getBcode();
				data[i][1] = list.get(i).getBtitle();
				data[i][2] = list.get(i).getBauthor();
			}
			return data;
		}


	public void toRentBookTablePrint() {
			Object data[][] = toRentBookTableList();
	
			String[] colName = {"도서코드", "도서명", "지은이"};
			
			System.out.println("toRentBookTablePrint(); call");
			
			DefaultTableModel model = new DefaultTableModel(data, colName);
			
			DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();   
	
			yCheckPossibleBookTable.setModel(model);
			celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
	
			
			yCheckPossibleBookTable.getColumnModel().getColumn(0).setMinWidth(58);
			yCheckPossibleBookTable.getColumnModel().getColumn(0).setMaxWidth(58);
			yCheckPossibleBookTable.getColumnModel().getColumn(0).setMinWidth(200);

			yCheckPossibleBookTable.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);//가운데정렬
	//		impossibleBookTable.getColumnModel().getColumn(0).setMinWidth(58);
	//		impossibleBookTable.getColumnModel().getColumn(0).setMaxWidth(58);
	//		
	//		impossibleBookTable.getColumnModel().getColumn(2).setMinWidth(95);
	//		impossibleBookTable.getColumnModel().getColumn(2).setMaxWidth(95);
	//		
	//		impossibleBookTable.getColumnModel().getColumn(3).setMinWidth(58);
	//		impossibleBookTable.getColumnModel().getColumn(3).setMaxWidth(58);
	//		
	//		impossibleBookTable.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);//가운데정렬
	//		impossibleBookTable.getColumnModel().getColumn(3).setCellRenderer(celAlignCenter);//가운데정렬
		}


	public Object[][] impossibleBookTableList() {
		// DB 리스트 가져오기
		ArrayList<WrapperVO> list = new ArrayList<WrapperVO>();
		RentalCrud rc = new RentalCrud();
		
		
		list = rc.impossibleBookList();
//		System.out.println("db 갖다와서..");
		Object data[][] = new Object[list.size()][10];
		for (int i = 0; i < list.size(); i++) {
			
			data[i][0] = list.get(i).bvo.getBcode();
			data[i][1] = list.get(i).bvo.getBtitle();
			data[i][2] = list.get(i).mvo.getMname();
			data[i][3] = list.get(i).rvo.getStatus();
		}
		return data;
	}
	
	public void impossibleBookTablePrint() {
		Object data[][] = impossibleBookTableList();

		String[] colName = {"도서코드", "도서명", "대여 회원", "상태" };
		
		System.out.println("impossibleBookTablePrint(); call");
		
		DefaultTableModel model = new DefaultTableModel(data, colName);
		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();   

		nCheckImpossibleBookTable.setModel(model);
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

		nCheckImpossibleBookTable.getColumnModel().getColumn(0).setMinWidth(58);
		nCheckImpossibleBookTable.getColumnModel().getColumn(0).setMaxWidth(58);
		
		nCheckImpossibleBookTable.getColumnModel().getColumn(2).setMinWidth(65);
		nCheckImpossibleBookTable.getColumnModel().getColumn(2).setMaxWidth(65);
		
		nCheckImpossibleBookTable.getColumnModel().getColumn(3).setMinWidth(58);
		nCheckImpossibleBookTable.getColumnModel().getColumn(3).setMaxWidth(58);
		
		nCheckImpossibleBookTable.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);//가운데정렬
		nCheckImpossibleBookTable.getColumnModel().getColumn(2).setCellRenderer(celAlignCenter);//가운데정렬
		nCheckImpossibleBookTable.getColumnModel().getColumn(3).setCellRenderer(celAlignCenter);//가운데정렬
	}
	
	public Object[][] toReturnBookTableList() {
		// DB 리스트 가져오기
		ArrayList<WrapperVO> list = new ArrayList<WrapperVO>();
		RentalCrud rc = new RentalCrud();
		
		list = rc.toReturnBookList();
		
//		System.out.println("db 갖다와서..");
		Object data[][] = new Object[list.size()][4];
		for (int i = 0; i < list.size(); i++) {
			
			data[i][0] = list.get(i).bvo.getBcode();
			data[i][1] = list.get(i).bvo.getBtitle();
			data[i][2] = list.get(i).bvo.getBauthor();
			data[i][3] = list.get(i).rvo.getRcode();
		}
		return data;
	}
	
	public void toReturnBookTablePrint() {
		Object data[][] = toReturnBookTableList();

		String[] colName = {"도서코드", "도서명", "지은이", "대여코드"};
		
		System.out.println("toReturnBookTableList(); call");
		
		
		DefaultTableModel model = new DefaultTableModel(data, colName);
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();   
		yCheckImpossibleBookTable.setModel(model);
		
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		
		yCheckImpossibleBookTable.getColumnModel().getColumn(0).setMinWidth(58);
		yCheckImpossibleBookTable.getColumnModel().getColumn(0).setMaxWidth(58);
		yCheckImpossibleBookTable.getColumnModel().getColumn(0).setMinWidth(200);
		yCheckImpossibleBookTable.getColumnModel().getColumn(3).setMinWidth(0);
		yCheckImpossibleBookTable.getColumnModel().getColumn(3).setMaxWidth(0);

		
		yCheckImpossibleBookTable.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);//가운데정렬
//		impossibleBookTable.getColumnModel().getColumn(0).setMinWidth(58);
//		impossibleBookTable.getColumnModel().getColumn(0).setMaxWidth(58);
//		
//		impossibleBookTable.getColumnModel().getColumn(2).setMinWidth(95);
//		impossibleBookTable.getColumnModel().getColumn(2).setMaxWidth(95);
//		
//		impossibleBookTable.getColumnModel().getColumn(3).setMinWidth(58);
//		impossibleBookTable.getColumnModel().getColumn(3).setMaxWidth(58);
//		
//		impossibleBookTable.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);//가운데정렬
//		impossibleBookTable.getColumnModel().getColumn(3).setCellRenderer(celAlignCenter);//가운데정렬
	}
	
	public void yCheckRentEvent() {
		RentalCrud rc = new RentalCrud();
		BookVO vo = new BookVO();

		vo.setBcode(rentBcode.getText());
		
		rc.yCheckRent(vo);
		
		rentBcode.setText("");

		possibleBookTablePrint();
		toRentBookTablePrint();
	}
	
	public void nCheckRentEvent() {
		RentalCrud rc = new RentalCrud();
		BookVO vo = new BookVO();

		vo.setBcode(rentBcode.getText());
		
		rc.nCheckRent(vo);
		
		rentBcode.setText("");

		possibleBookTablePrint();
		toRentBookTablePrint();
	}
	
	public void yCheckReturnEvent() {
		RentalCrud rc = new RentalCrud();
		BookVO vo = new BookVO();
		RentalVO rvo = new RentalVO();
		
		vo.setBcode(returnBcode.getText());
		rvo.setRcode(returnRcode.getText());
				
		
		rc.yCheckReturn(vo);
		
		returnBcode.setText("");
		returnRcode.setText("");

		impossibleBookTablePrint();
		toReturnBookTablePrint();
	}
	
	public void nCheckReturnEvent() {
		RentalCrud rc = new RentalCrud();
		BookVO vo = new BookVO();

		vo.setBcode(returnBcode.getText());
		
		rc.nCheckReturn(vo);
		
		returnBcode.setText("");

		impossibleBookTablePrint();
		toReturnBookTablePrint();
	}
	
	public Object[][] searchBookTableList() {
		// DB 리스트 가져오기
		
		ArrayList<WrapperVO> list = new ArrayList<WrapperVO>();
		BookCrud b = new BookCrud();
		
		String searchStr = bookSearchText.getText();
		
		list = b.searchBook(searchStr);
		
//		System.out.println("db 갖다와서..");
		Object data[][] = new Object[list.size()][12];
		for (int i = 0; i < list.size(); i++) {
			
			data[i][0] = list.get(i).bvo.getBcode();
			data[i][1] = list.get(i).bvo.getBtitle();
			data[i][2] = list.get(i).bvo.getBauthor();
			data[i][3] = list.get(i).bvo.getBtranslator();
			data[i][4] = list.get(i).bvo.getBpublisher();
			data[i][5] = list.get(i).bvo.getBisbn();
			data[i][6] = list.get(i).bvo.getBprice();
			data[i][7] = list.get(i).bvo.getBpage();
			data[i][8] = list.get(i).bvo.getBregdate();
			data[i][9] = list.get(i).rvo.getStatus();
			data[i][10] = list.get(i).bvo.getBcheckRent();
			data[i][11] = list.get(i).bvo.getBcheckReturn();
		}
		return data;
	}
	
	public void searchBookTablePrint() {
		Object data[][] = searchBookTableList();

		String[] colName = {"도서코드", "도서명", "지은이", "옮긴이", 
							"출판사", "ISBN", "가격", "페이지", 
							"등록일자", "상태", "렌트체크", "리턴체크"};
		
		System.out.println("searchBookTablePrint(); call");
		
		DefaultTableModel model = new DefaultTableModel(data, colName);
		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();   

		bookTable.setModel(model);
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		

//		bookTable.getColumnModel().getColumn(0).setPreferredWidth(10);
		bookTable.getColumnModel().getColumn(0).setMinWidth(60);
		bookTable.getColumnModel().getColumn(0).setMaxWidth(60);
		
		bookTable.getColumnModel().getColumn(7).setMinWidth(55);
		bookTable.getColumnModel().getColumn(7).setMaxWidth(55);
		bookTable.getColumnModel().getColumn(9).setMinWidth(60);
		bookTable.getColumnModel().getColumn(9).setMaxWidth(60);
		
		bookTable.getColumnModel().getColumn(10).setMinWidth(0);
		bookTable.getColumnModel().getColumn(10).setMaxWidth(0);
		
		bookTable.getColumnModel().getColumn(11).setMinWidth(0);
		bookTable.getColumnModel().getColumn(11).setMaxWidth(0);
		
		
		

		
		bookTable.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);//가운데정렬
//		bookTable.getColumnModel().getColumn(1).setPreferredWidth(200);
//		bookTable.getColumnModel().getColumn(4).setPreferredWidth(10);
		bookTable.getColumnModel().getColumn(9).setCellRenderer(celAlignCenter);//가운데정렬
		
		/*<!-- 열 숨기기 --!>*/
//		bookTable.getColumnModel().getColumn(3).setMinWidth(0);
//		bookTable.getColumnModel().getColumn(3).setMaxWidth(0);
//		bookTable.getColumnModel().getColumn(5).setMinWidth(0);
//		bookTable.getColumnModel().getColumn(5).setMaxWidth(0);
//		bookTable.getColumnModel().getColumn(6).setMinWidth(0);
//		bookTable.getColumnModel().getColumn(6).setMaxWidth(0);
//		bookTable.getColumnModel().getColumn(7).setMinWidth(0);
//		bookTable.getColumnModel().getColumn(7).setMaxWidth(0);
//		bookTable.getColumnModel().getColumn(8).setMinWidth(0);
//		bookTable.getColumnModel().getColumn(8).setMaxWidth(0);
	}
	
	public Object[][] searchPossibleBookTableList() {
		// DB 리스트 가져오기
		ArrayList<WrapperVO> list = new ArrayList<WrapperVO>();
		RentalCrud rc = new RentalCrud();
		
		String searchStr = possibleBookSearchText.getText();
		
		list = rc.searchPossibleBook(searchStr);
//		System.out.println("db 갖다와서..");
		Object data[][] = new Object[list.size()][4];
		for (int i = 0; i < list.size(); i++) {
			
			data[i][0] = list.get(i).bvo.getBcode();
			data[i][1] = list.get(i).bvo.getBtitle();
			data[i][2] = list.get(i).bvo.getBauthor();
			data[i][3] = list.get(i).rvo.getStatus();
			
		}
		return data;
	}
	
	public void searchPossibleBookTablePrint() {
		Object data[][] = searchPossibleBookTableList();

		String[] colName = {"도서코드", "도서명", "지은이", "상태" };
		
		System.out.println("searchPossibleBookTablePrint(); call");
		
		DefaultTableModel model = new DefaultTableModel(data, colName);
		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();   

		nCheckPossibleBookTable.setModel(model);
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

		nCheckPossibleBookTable.getColumnModel().getColumn(0).setMinWidth(58);
		nCheckPossibleBookTable.getColumnModel().getColumn(0).setMaxWidth(58);
		
		nCheckPossibleBookTable.getColumnModel().getColumn(2).setMinWidth(95);
		nCheckPossibleBookTable.getColumnModel().getColumn(2).setMaxWidth(95);
		
		nCheckPossibleBookTable.getColumnModel().getColumn(3).setMinWidth(58);
		nCheckPossibleBookTable.getColumnModel().getColumn(3).setMaxWidth(58);
		
		nCheckPossibleBookTable.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);//가운데정렬
		nCheckPossibleBookTable.getColumnModel().getColumn(3).setCellRenderer(celAlignCenter);//가운데정렬
	}
	
	public Object[][] searchImpossibleBookTableList() {
		// DB 리스트 가져오기
		
		ArrayList<WrapperVO> list = new ArrayList<WrapperVO>();
		RentalCrud rc = new RentalCrud();
		
		String searchStr = impossibleBookSearchText.getText();
		
		list = rc.searchImpossibleBook(searchStr);
//		System.out.println("db 갖다와서..");
		Object data[][] = new Object[list.size()][4];
		for (int i = 0; i < list.size(); i++) {
			
			data[i][0] = list.get(i).bvo.getBcode();
			data[i][1] = list.get(i).bvo.getBtitle();
			data[i][2] = list.get(i).mvo.getMname();
			data[i][3] = list.get(i).rvo.getStatus();
			
		}
		return data;
	}
	
	public void searchImpossibleBookTablePrint() {
		Object data[][] = searchImpossibleBookTableList();

		String[] colName = {"도서코드", "도서명", "대여 회원", "상태" };
		
		System.out.println("searchImpossibleBookTablePrint(); call");
		
		DefaultTableModel model = new DefaultTableModel(data, colName);
		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();   

		nCheckImpossibleBookTable.setModel(model);
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

		nCheckImpossibleBookTable.getColumnModel().getColumn(0).setMinWidth(58);
		nCheckImpossibleBookTable.getColumnModel().getColumn(0).setMaxWidth(58);
		
		nCheckImpossibleBookTable.getColumnModel().getColumn(2).setMinWidth(95);
		nCheckImpossibleBookTable.getColumnModel().getColumn(2).setMaxWidth(95);
		
		nCheckImpossibleBookTable.getColumnModel().getColumn(3).setMinWidth(58);
		nCheckImpossibleBookTable.getColumnModel().getColumn(3).setMaxWidth(58);
		
		nCheckImpossibleBookTable.getColumnModel().getColumn(0).setCellRenderer(celAlignCenter);//가운데정렬
		nCheckImpossibleBookTable.getColumnModel().getColumn(3).setCellRenderer(celAlignCenter);//가운데정렬
	}
	
	
	public Object[][] searchMemTableList() {
		// DB 리스트 가져오기
		ArrayList<MemVO> list = new ArrayList<MemVO>();
		MemCrud mc = new MemCrud();
		
		String searchStr = memSearchText.getText();
		
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

		memTable.setModel(model);
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

//		bookTable.getColumnModel().getColumn(0).setPreferredWidth(10);
//		table.getColumnModel().getColumn(4).setMinWidth(0);
//		table.getColumnModel().getColumn(4).setMaxWidth(0);
		
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
	public BookMgr() {
		
		System.out.println("bookMGR  생성자 콜");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 900, 800);
		setLocationRelativeTo(null);
		setTitle("BookMGR");
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		fileMenu = new JMenu("파일(F)");
		fileMenu.setMnemonic('F');
		menuBar.add(fileMenu);
		
		fileMenuExit = new JMenuItem("종료");
		fileMenuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		fileMenu.add(fileMenuExit);
		
		bookMenu = new JMenu("도서(B)");
		bookMenu.setMnemonic('B');
		menuBar.add(bookMenu);
		
		menuItem = new JMenuItem("도서 현황");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(mainPane.getLayout());
				cl.show(mainPane, "bookPane");
				bookTablePrint();
			}
		});
		menuItem.setMnemonic(KeyEvent.VK_F1);
		bookMenu.add(menuItem);
		
		mnNewMenu_2 = new JMenu("대여/반납(R)");
		mnNewMenu_2.setMnemonic('R');
		menuBar.add(mnNewMenu_2);
		
		menuItem_1 = new JMenuItem("대여/반납");
		menuItem_1.setMnemonic(KeyEvent.VK_F2);
		mnNewMenu_2.add(menuItem_1);
		
		mnm = new JMenu("회원(M)");
		mnm.setMnemonic('M');
		menuBar.add(mnm);
		
		mntmNewMenuItem = new JMenuItem("회원관리");
		mntmNewMenuItem.setMnemonic(KeyEvent.VK_F3);
		mnm.add(mntmNewMenuItem);
		
		mnNewMenu = new JMenu("도움말(H)");
		mnNewMenu.setMnemonic('H');
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_1 = new JMenuItem("도움말");
		mnNewMenu.add(mntmNewMenuItem_1);
		menuPane = new JPanel();
		menuPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(menuPane);
		menuPane.setLayout(new BorderLayout(0, 0));
		
		menuPane2 = new JPanel();
		menuPane.add(menuPane2, BorderLayout.NORTH);
		menuPane2.setLayout(new BorderLayout(0, 0));
		
		menuPane3 = new JPanel();
		menuPane2.add(menuPane3, BorderLayout.NORTH);
		menuPane3.setPreferredSize(new Dimension(0, 40));
		
		ImageIcon fi0 = new ImageIcon(BookMgr.class.getResource("/com/kosmo/book/book.png"));
		Image si0 = fi0.getImage();
		Image ti0 = si0.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
		ImageIcon li0 = new ImageIcon(ti0);
		bookBtn = new JButton("도서관리", li0);
		bookBtn.setFont(new Font("D2Coding", Font.PLAIN, 15));
		bookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(mainPane.getLayout());
				cl.show(mainPane, "bookPane");
				bookTablePrint();
//				memTablePrint();
			}
		});
		menuPane3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		menuPane3.add(bookBtn);
		
		rentBtn = new JButton("대여/반납", imageResize("/com/kosmo/book/rent.png", 15));
		rentBtn.setFont(new Font("D2Coding", Font.PLAIN, 15));
		rentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(mainPane.getLayout());
				cl.show(mainPane, "rentReturnPane");
				possibleBookTablePrint();
				impossibleBookTablePrint();
				toRentBookTablePrint();
				toReturnBookTablePrint();
			}
		});
		menuPane3.add(rentBtn);
		
		memberBtn = new JButton("회원관리", imageResize("/com/kosmo/book/member.png", 15));
		memberBtn.setFont(new Font("D2Coding", Font.PLAIN, 15));
		memberBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cl = (CardLayout)(mainPane.getLayout());
				cl.show(mainPane, "memberPane");
				memTablePrint();
			}
		});
		menuPane3.add(memberBtn);
		
		panel_10 = new JPanel();
		panel_10.setPreferredSize(new Dimension(440, 0));
		menuPane3.add(panel_10);
		
		lblMadeByPuter = new JLabel("<html>made by<br>&nbsp;&nbsp;Puter</html>");
		lblMadeByPuter.setFont(new Font("D2Coding", Font.PLAIN, 12));
		menuPane3.add(lblMadeByPuter);
		
		lblNewLabel_1 = new JLabel(imageResize("/com/kosmo/book/gear_85.png", 30));
		menuPane3.add(lblNewLabel_1);
		
		
		mainPane = new JPanel(/*new CardLayout()*/);
		menuPane.add(mainPane, BorderLayout.CENTER);
		mainPane.setLayout(new CardLayout(0, 0));
		
		bookPane = new JPanel();
		mainPane.add(bookPane, "bookPane");
		bookPane.setLayout(new BorderLayout(0, 0));
		
		bookBottomPane = new JPanel();
		bookBottomPane.setPreferredSize(new Dimension(0, 200));
		bookPane.add(bookBottomPane, BorderLayout.SOUTH);
		bookBottomPane.setLayout(null);
		
		bcodeLabel = new JLabel("도서코드");
		bcodeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bcodeLabel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		bcodeLabel.setBounds(12, 27, 80, 20);
		bookBottomPane.add(bcodeLabel);
		
		JLabel btitleLable = new JLabel("도서명");
		btitleLable.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btitleLable.setHorizontalAlignment(SwingConstants.CENTER);
		btitleLable.setBounds(12, 72, 80, 20);
		bookBottomPane.add(btitleLable);
		
		JLabel bpageLabel = new JLabel("페이지");
		bpageLabel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		bpageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bpageLabel.setBounds(572, 72, 80, 20);
		bookBottomPane.add(bpageLabel);
		
		JLabel bauthorLabel = new JLabel("지은이");
		bauthorLabel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		bauthorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bauthorLabel.setBounds(12, 117, 80, 20);
		bookBottomPane.add(bauthorLabel);
		
		JLabel btranslatorLabel = new JLabel("옮긴이");
		btranslatorLabel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btranslatorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		btranslatorLabel.setBounds(292, 72, 80, 20);
		bookBottomPane.add(btranslatorLabel);
		
		bpublisherLabel = new JLabel("출판사");
		bpublisherLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bpublisherLabel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		bpublisherLabel.setBounds(12, 162, 80, 20);
		bookBottomPane.add(bpublisherLabel);
		
		bisbnLabel = new JLabel("ISBN");
		bisbnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bisbnLabel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		bisbnLabel.setBounds(292, 117, 80, 20);
		bookBottomPane.add(bisbnLabel);
		
		bpriceLabel = new JLabel("가격");
		bpriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bpriceLabel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		bpriceLabel.setBounds(292, 162, 80, 20);
		bookBottomPane.add(bpriceLabel);
		
		bstatusLabel = new JLabel("상태");
		bstatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bstatusLabel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		bstatusLabel.setBounds(572, 117, 80, 20);
		bookBottomPane.add(bstatusLabel);
		
		bregdateLabel = new JLabel("등록일자");
		bregdateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bregdateLabel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		bregdateLabel.setBounds(572, 162, 80, 20);
		bookBottomPane.add(bregdateLabel);
		
		btitleText = new JTextField();
		btitleText.setBounds(105, 72, 180, 21);
		bookBottomPane.add(btitleText);
		btitleText.setColumns(10);
		
		bauthorText = new JTextField();
		bauthorText.setBounds(105, 117, 180, 21);
		bookBottomPane.add(bauthorText);
		bauthorText.setColumns(10);
		
		bpublisherText = new JTextField();
		bpublisherText.setBounds(105, 162, 180, 21);
		bookBottomPane.add(bpublisherText);
		bpublisherText.setColumns(10);
		
		btranslatorText = new JTextField();
		btranslatorText.setBounds(378, 72, 180, 21);
		bookBottomPane.add(btranslatorText);
		btranslatorText.setColumns(10);
		
		bisbnText = new JTextField();
		bisbnText.setBounds(378, 117, 180, 21);
		bookBottomPane.add(bisbnText);
		bisbnText.setColumns(10);
		
		bpriceText = new JTextField();
		bpriceText.setBounds(378, 162, 180, 21);
		bookBottomPane.add(bpriceText);
		bpriceText.setColumns(10);
		
		bpageText = new JTextField();
		bpageText.setBounds(672, 72, 180, 21);
		bookBottomPane.add(bpageText);
		bpageText.setColumns(10);
		
		bcodeLabel1 = new JLabel("");
		bcodeLabel1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(130, 135, 144), null));
		bcodeLabel1.setFont(new Font("D2Coding", Font.PLAIN, 15));
		bcodeLabel1.setBounds(105, 27, 180, 21);
		bookBottomPane.add(bcodeLabel1);
		
		bstatusLabel1 = new JLabel("");
		bstatusLabel1.setFont(new Font("D2Coding", Font.PLAIN, 15));
		bstatusLabel1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(130, 135, 144), null));
		bstatusLabel1.setBounds(672, 117, 180, 21);
		bookBottomPane.add(bstatusLabel1);
		
		bregdateLabel1 = new JLabel("");
		bregdateLabel1.setFont(new Font("D2Coding", Font.PLAIN, 15));
		bregdateLabel1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(130, 135, 144), null));
		bregdateLabel1.setBounds(672, 162, 180, 21);
		bookBottomPane.add(bregdateLabel1);
		
		panel_7 = new JPanel();
		panel_7.setFont(new Font("D2Coding", Font.PLAIN, 12));
		panel_7.setBorder(new TitledBorder(new LineBorder(new Color(130, 135, 144), 1),"도서정보"));
		panel_7.setBounds(0, 0, 886, 200);
		bookBottomPane.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		bookTopPane = new JPanel();
		bookPane.add(bookTopPane, BorderLayout.CENTER);
		bookTopPane.setLayout(new BorderLayout(0, 0));
		
		bookTable = new JTable();
		bookTable.setRowHeight(20);
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int irow = bookTable.getSelectedRow();
				int icol = bookTable.getSelectedColumn();
				System.out.println(bookTable.getValueAt(irow, icol));; //n행, n열 데이터는 무엇?

				bcodeLabel1.setText(bookTable.getValueAt(irow, 0).toString());
				btitleText.setText(bookTable.getValueAt(irow, 1).toString());
				bauthorText.setText(bookTable.getValueAt(irow, 2).toString());
				btranslatorText.setText(bookTable.getValueAt(irow, 3).toString());
				bpublisherText.setText(bookTable.getValueAt(irow, 4).toString());
				bisbnText.setText(bookTable.getValueAt(irow, 5).toString());
				bpriceText.setText(bookTable.getValueAt(irow, 6).toString());
				bpageText.setText(bookTable.getValueAt(irow, 7).toString());
				bregdateLabel1.setText(bookTable.getValueAt(irow, 8).toString());
				bstatusLabel1.setText(bookTable.getValueAt(irow, 9).toString());
			}
		});
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"도서코드", "도서명", "지은이", "옮긴이", 
					"출판사", "ISBN", "가격", "페이지", 
					"등록일자", "상태", "렌트체크", "리턴체크"
			}
		));
		bookTablePrint();
		scrollPane = new JScrollPane(bookTable);
		bookTopPane.add(scrollPane, BorderLayout.CENTER);
		
		
		panel = new JPanel();
		bookTopPane.add(panel, BorderLayout.SOUTH);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setPreferredSize(new Dimension(0, 40));
		
				
		bookaddBtn = new JButton("추가", imageResize("/com/kosmo/book/add.png", 15));
		bookaddBtn.setPreferredSize(new Dimension(85, 30));
		bookaddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new BookAdd(bookMgrInstance); //frame //-----------------------
				
			}
		});
		panel.add(bookaddBtn);
		bookaddBtn.setFont(new Font("D2Coding", Font.PLAIN, 15));
		
		bookeditBtn = new JButton("수정", imageResize("/com/kosmo/book/edit.png", 15));
		bookeditBtn.setPreferredSize(new Dimension(85, 30));
		panel.add(bookeditBtn);
		bookeditBtn.setFont(new Font("D2Coding", Font.PLAIN, 15));
		
		bookdelBtn = new JButton("삭제", imageResize("/com/kosmo/book/cancel.png", 15));
		bookdelBtn.setPreferredSize(new Dimension(85, 30));
		bookdelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookDeleteEvent();
			}
		});
		panel.add(bookdelBtn);
		bookdelBtn.setFont(new Font("D2Coding", Font.PLAIN, 15));
		
		bookTablePrintBtn = new JButton(imageResize("/com/kosmo/book/refresh.png", 20));
		bookTablePrintBtn.setPreferredSize(new Dimension(27, 27));
		bookTablePrintBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTablePrint();
				bookSearchText.setText("");
			}
		});
		
		panel_6 = new JPanel();
		panel.add(panel_6);
		bookTablePrintBtn.setFont(new Font("굴림", Font.PLAIN, 5));
		panel_6.setPreferredSize(new Dimension(256, 0));
		panel.add(bookTablePrintBtn);
		
		bookSearchText = new JTextField();
		bookSearchText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchBookTablePrint();
				} else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					bookSearchText.setText("");
					bookTablePrint();
				}	
			}
		});
		bookSearchText.setColumns(20);
		bookSearchText.setPreferredSize(new Dimension(27, 27));
		panel.add(bookSearchText);
		
		bookSearchBtn = new JButton("검색", imageResize("/com/kosmo/book/search.png", 15));
		bookSearchBtn.setPreferredSize(new Dimension(85, 30));
		bookSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchBookTablePrint();
			}
		});
		bookSearchBtn.setFont(new Font("D2Coding", Font.PLAIN, 15));
		panel.add(bookSearchBtn);
		bookeditBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookUpdateEvent();
			}
		});
		
		rentalPane = new JPanel();
		mainPane.add(rentalPane, "rentReturnPane");
		rentalPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		rentalUpPane = new JPanel();
		rentalPane.add(rentalUpPane);
		rentalUpPane.setLayout(new BorderLayout(0, 0));
		
		panel_8 = new JPanel();
		panel_8.setFont(new Font("D2Coding", Font.PLAIN, 12));
		panel_8.setBorder(new TitledBorder(new LineBorder(new Color(130, 135, 144), 1),"도서대여"));
		rentalUpPane.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(null);
		
		nCheckPossibleBookTable = new JTable();
		nCheckPossibleBookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int irow = nCheckPossibleBookTable.getSelectedRow();
				int icol = nCheckPossibleBookTable.getSelectedColumn();
				System.out.println(nCheckPossibleBookTable.getValueAt(irow, icol));; //n행, n열 데이터는 무엇?

				rentBcode.setText(nCheckPossibleBookTable.getValueAt(irow, 0).toString());
			}
		});
		nCheckPossibleBookTable.setRowHeight(18);
		nCheckPossibleBookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"도서코드", "도서명", "지은이", "상태"
			}
		));
		JScrollPane scrollPane_3 = new JScrollPane(nCheckPossibleBookTable);
		scrollPane_3.setBounds(12, 20, 376, 280);
		panel_8.add(scrollPane_3);
		
		yCheckPossibleBookTable = new JTable();
		yCheckPossibleBookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int irow = yCheckPossibleBookTable.getSelectedRow();
				int icol = yCheckPossibleBookTable.getSelectedColumn();
				System.out.println(yCheckPossibleBookTable.getValueAt(irow, icol));; //n행, n열 데이터는 무엇?

				rentBcode.setText(yCheckPossibleBookTable.getValueAt(irow, 0).toString());
			}
		});
		yCheckPossibleBookTable.setRowHeight(18);
		yCheckPossibleBookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"도서코드", "도서명", "지은이"
			}
		));
		scrollPane_4 = new JScrollPane(yCheckPossibleBookTable);
		scrollPane_4.setBounds(486, 20, 376, 232);
		panel_8.add(scrollPane_4);
		
		JButton button_2 = new JButton(imageResize("/com/kosmo/book/rental.png", 120, 40));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectMem(bookMgrInstance);
			}
		});
		button_2.setBounds(486, 262, 376, 73);
		panel_8.add(button_2);
		
		yBcheckBtn = new JButton(imageResize("/com/kosmo/book/right.png", 30));
		yBcheckBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yCheckRentEvent();
			}
		});
		yBcheckBtn.setBounds(412, 75, 50, 50);
		panel_8.add(yBcheckBtn);
		
		nBcheckBtn = new JButton(imageResize("/com/kosmo/book/left.png", 30));
		nBcheckBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nCheckRentEvent();
			}
		});
		nBcheckBtn.setBounds(412, 167, 50, 50);
		panel_8.add(nBcheckBtn);
		
		rentBcode = new JLabel("New label");
		rentBcode.setForeground(new Color(240, 240, 240));
		rentBcode.setBounds(405, 27, 57, 15);
		panel_8.add(rentBcode);
		
		possibleBookPrintBtn = new JButton(imageResize("/com/kosmo/book/refresh.png", 20));
		possibleBookPrintBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				possibleBookTablePrint();
				possibleBookSearchText.setText("");
			}
		});
		possibleBookPrintBtn.setFont(new Font("굴림", Font.PLAIN, 5));
		possibleBookPrintBtn.setBounds(12, 305, 30, 30);
		panel_8.add(possibleBookPrintBtn);
		
		possibleBookSearchText = new JTextField();
		possibleBookSearchText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchPossibleBookTablePrint();
				} else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					possibleBookSearchText.setText("");
					possibleBookTablePrint();
				}
			}
		});
		possibleBookSearchText.setColumns(10);
		possibleBookSearchText.setBounds(45, 305, 255, 30);
		panel_8.add(possibleBookSearchText);
		
		possibleBookSearchBtn = new JButton("검색", imageResize("/com/kosmo/book/search.png", 15));
		possibleBookSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchPossibleBookTablePrint();
			}
		});
		possibleBookSearchBtn.setFont(new Font("D2Coding", Font.PLAIN, 15));
		possibleBookSearchBtn.setBounds(303, 305, 85, 30);
		panel_8.add(possibleBookSearchBtn);
		
		
		rentalDownPane = new JPanel();
		rentalPane.add(rentalDownPane);
		rentalDownPane.setLayout(new BorderLayout(0, 0));
		
		panel_9 = new JPanel();
		panel_9.setFont(new Font("D2Coding", Font.PLAIN, 12));
		panel_9.setBorder(new TitledBorder(new LineBorder(new Color(130, 135, 144), 1),"도서반납"));
		rentalDownPane.add(panel_9);
		panel_9.setLayout(null);
		
		nCheckImpossibleBookTable = new JTable();
		nCheckImpossibleBookTable.setRowHeight(18);
		nCheckImpossibleBookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int irow = nCheckImpossibleBookTable.getSelectedRow();
				int icol = nCheckImpossibleBookTable.getSelectedColumn();
				System.out.println(nCheckImpossibleBookTable.getValueAt(irow, icol));; //n행, n열 데이터는 무엇?

				returnBcode.setText(nCheckImpossibleBookTable.getValueAt(irow, 0).toString());
			}
		});
		nCheckImpossibleBookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"도서코드", "도서명", "지은이", "상태"
			}
		));
		scrollPane_5 = new JScrollPane(nCheckImpossibleBookTable);
		scrollPane_5.setBounds(12, 20, 376, 280);
		panel_9.add(scrollPane_5);
		
		
		yCheckImpossibleBookTable = new JTable();
		yCheckImpossibleBookTable.setRowHeight(18);
		yCheckImpossibleBookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int irow = yCheckImpossibleBookTable.getSelectedRow();
				int icol = yCheckImpossibleBookTable.getSelectedColumn();
				System.out.println(yCheckImpossibleBookTable.getValueAt(irow, icol));; //n행, n열 데이터는 무엇?

				returnBcode.setText(yCheckImpossibleBookTable.getValueAt(irow, 0).toString());
				returnRcode.setText(yCheckImpossibleBookTable.getValueAt(irow, 3).toString());
			}
		});
		yCheckImpossibleBookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"도서코드", "도서명", "지은이"
			}
		));
		scrollPane_6 = new JScrollPane(yCheckImpossibleBookTable);
		scrollPane_6.setBounds(486, 20, 376, 232);
		panel_9.add(scrollPane_6);
		
		
		button_3 = new JButton(imageResize("/com/kosmo/book/return.png", 120, 40));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int rowCount = 0;
				
				if(yCheckImpossibleBookTable.getModel() != null) {
					rowCount = yCheckImpossibleBookTable.getModel().getRowCount();
				}
				
				RentalCrud rc = new RentalCrud();
				
				String rcode = "";
				String bcode = "";
				
				System.out.println(yCheckImpossibleBookTable.getModel().getRowCount() + "-------");
								
				for(int i=0; i<rowCount; i++) {
					//bookMgr.yCheckPossibleBookTable.getValueAt(i,0)
					//-------대여정보입력-------------
					rcode = yCheckImpossibleBookTable.getValueAt(i, 3).toString();
					bcode = yCheckImpossibleBookTable.getValueAt(i, 0).toString();
					System.out.println(rcode + "," + bcode);
					
					//-------북대여상태코드 변경 <<------
					BookVO bvo = new BookVO();
					
//					//"update rental set status='대여가능', returndate=sysdate where rcode=?";
					rc.returnBook(rcode);
//					
//					//"update book set bcheckreturn='n' where bcode=?"
					bvo.setBcode(bcode);
					rc.nCheckReturn(bvo);
				}
				
				possibleBookTablePrint();
				toRentBookTablePrint();
				impossibleBookTablePrint();
				toReturnBookTablePrint();
			}
		});
		button_3.setBounds(486, 262, 376, 73);
		panel_9.add(button_3);
		
		yBcheckBtn2 = new JButton(imageResize("/com/kosmo/book/right.png", 30));
		yBcheckBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yCheckReturnEvent();
			}
		});
		yBcheckBtn2.setBounds(412, 75, 50, 50);
		panel_9.add(yBcheckBtn2);
		
		nBcheckBtn2 = new JButton(imageResize("/com/kosmo/book/left.png", 30));
		nBcheckBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nCheckReturnEvent();
			}
		});
		nBcheckBtn2.setBounds(412, 167, 50, 50);
		panel_9.add(nBcheckBtn2);
		
		returnBcode = new JLabel("New label");
		returnBcode.setForeground(new Color(240, 240, 240));
		returnBcode.setBounds(417, 27, 57, 15);
		panel_9.add(returnBcode);
		
		returnRcode = new JLabel("New label");
		returnRcode.setForeground(new Color(240, 240, 240));
		returnRcode.setBounds(400, 246, 57, 15);
		panel_9.add(returnRcode);
		
		
		impossibleBookPrintBtn = new JButton(imageResize("/com/kosmo/book/refresh.png", 20));
		impossibleBookPrintBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				impossibleBookTablePrint();
				impossibleBookSearchText.setText("");
			}
		});
		impossibleBookPrintBtn.setFont(new Font("굴림", Font.PLAIN, 5));
		impossibleBookPrintBtn.setBounds(12, 305, 30, 30);
		panel_9.add(impossibleBookPrintBtn);
		
		impossibleBookSearchText = new JTextField();
		impossibleBookSearchText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchImpossibleBookTablePrint();
				} else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					impossibleBookSearchText.setText("");
					impossibleBookTablePrint();
				}
			}
		});
		impossibleBookSearchText.setColumns(10);
		impossibleBookSearchText.setBounds(45, 305, 255, 30);
		panel_9.add(impossibleBookSearchText);
		
		impossibleBookSearchBtn = new JButton("검색", imageResize("/com/kosmo/book/search.png", 15));
		impossibleBookSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchImpossibleBookTablePrint();
			}
		});
		impossibleBookSearchBtn.setFont(new Font("D2Coding", Font.PLAIN, 15));
		impossibleBookSearchBtn.setBounds(303, 305, 85, 30);
		panel_9.add(impossibleBookSearchBtn);
		
		memberPane = new JPanel();
		mainPane.add(memberPane, "memberPane");
		memberPane.setLayout(new BorderLayout(0, 0));
		
		memberTopPane = new JPanel();
		memberPane.add(memberTopPane, BorderLayout.CENTER);
		memberTopPane.setLayout(new BorderLayout(0, 0));
		
		
		memTable = new JTable();
		memTable.setRowHeight(20);
		memTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int irow = memTable.getSelectedRow();
				int icol = memTable.getSelectedColumn();
				System.out.println(memTable.getValueAt(irow, icol));; //n행, n열 데이터는 무엇?

				mcodeLabel.setText(memTable.getValueAt(irow, 0).toString());
				mnameText2.setText(memTable.getValueAt(irow, 1).toString());
				mbirthText2.setText(memTable.getValueAt(irow, 2).toString());
				mphoneText2.setText(memTable.getValueAt(irow, 3).toString());
				
				memTraceTablePrint();
			}
		});
		memTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"회원코드", "이름", "생년월일", "전화번호", "회원등록일"
			}
		));
		scrollPane_1 = new JScrollPane(memTable);
		memberTopPane.add(scrollPane_1, BorderLayout.CENTER);
		
		memberBottomPane = new JPanel();
		memberBottomPane.setPreferredSize(new Dimension(0, 240));
		memberPane.add(memberBottomPane, BorderLayout.SOUTH);
		memberBottomPane.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setFont(new Font("D2Coding", Font.PLAIN, 12));
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(130, 135, 144), 1),"회원등록"));
		panel_1.setBounds(0, 3, 280, 238);
		memberBottomPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		lblNewLabel = new JLabel("이름");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblNewLabel.setBounds(12, 15, 80, 20);
		panel_2.add(lblNewLabel);
		
		mnameText = new JTextField();
		mnameText.setBounds(97, 15, 155, 21);
		panel_2.add(mnameText);
		mnameText.setColumns(10);
		
		label = new JLabel("생년월일");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("D2Coding", Font.PLAIN, 18));
		label.setBounds(12, 67, 80, 20);
		panel_2.add(label);
		
		label_1 = new JLabel("전화번호");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("D2Coding", Font.PLAIN, 18));
		label_1.setBounds(12, 120, 80, 20);
		panel_2.add(label_1);
		
		mbirthText = new JTextField();
		mbirthText.setColumns(10);
		mbirthText.setBounds(97, 67, 155, 21);
		panel_2.add(mbirthText);
		
		mphoneText = new JTextField();
		mphoneText.setColumns(10);
		mphoneText.setBounds(97, 120, 155, 21);
		panel_2.add(mphoneText);
		
		JButton btnNewButton = new JButton("등록", imageResize("/com/kosmo/book/add.png", 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memInsertEvent();
			}
		});
		btnNewButton.setFont(new Font("D2Coding", Font.PLAIN, 15));
		btnNewButton.setBounds(168, 165, 85, 30);
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setFont(new Font("D2Coding", Font.PLAIN, 12));
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(130, 135, 144), 1),"회원수정/삭제"));
		panel_3.setBounds(594, 3, 280, 238);
		memberBottomPane.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_3.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(null);
		
		label_2 = new JLabel("이름");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("D2Coding", Font.PLAIN, 18));
		label_2.setBounds(12, 15, 80, 20);
		panel_5.add(label_2);
		
		mnameText2 = new JTextField();
		mnameText2.setColumns(10);
		mnameText2.setBounds(97, 15, 155, 21);
		panel_5.add(mnameText2);
		
		label_3 = new JLabel("생년월일");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("D2Coding", Font.PLAIN, 18));
		label_3.setBounds(12, 67, 80, 20);
		panel_5.add(label_3);
		
		mbirthText2 = new JTextField();
		mbirthText2.setColumns(10);
		mbirthText2.setBounds(97, 67, 155, 21);
		panel_5.add(mbirthText2);
		
		label_4 = new JLabel("전화번호");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("D2Coding", Font.PLAIN, 18));
		label_4.setBounds(12, 120, 80, 20);
		panel_5.add(label_4);
		
		mphoneText2 = new JTextField();
		mphoneText2.setColumns(10);
		mphoneText2.setBounds(97, 120, 155, 21);
		panel_5.add(mphoneText2);
		
		button = new JButton("삭제", imageResize("/com/kosmo/book/cancel.png", 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memDeleteEvent();
			}
		});
		button.setFont(new Font("D2Coding", Font.PLAIN, 15));
		button.setBounds(168, 165, 85, 30);
		panel_5.add(button);
		
		button_1 = new JButton("수정", imageResize("/com/kosmo/book/edit.png", 15));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memUpdateEvent();
			}
		});
		button_1.setFont(new Font("D2Coding", Font.PLAIN, 15));
		button_1.setBounds(80, 165, 85, 30);
		panel_5.add(button_1);
		
		mcodeLabel = new JLabel("New label");
		mcodeLabel.setForeground(new Color(240, 240, 240));
		mcodeLabel.setBounds(97, 0, 57, 15);
		panel_5.add(mcodeLabel);
		
		panel_4 = new JPanel();
		panel_4.setFont(new Font("D2Coding", Font.PLAIN, 12));
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(130, 135, 144), 1),"회원최근활동"));
		panel_4.setBounds(280, 43, 314, 198);
		memberBottomPane.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		traceTable = new JTable();
		traceTable.setRowHeight(19);
		traceTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"도서코드", "도서명", "최근활동"
			}
		));
		traceTable.getColumnModel().getColumn(0).setMinWidth(58);
		traceTable.getColumnModel().getColumn(0).setMaxWidth(58);
		scrollPane_2 = new JScrollPane(traceTable);
		panel_4.add(scrollPane_2, BorderLayout.CENTER);
		
		ImageIcon fi1 = new ImageIcon(BookMgr.class.getResource("/com/kosmo/book/refresh.png"));
		Image si1 = fi1.getImage();
		Image ti1 = si1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		ImageIcon li1 = new ImageIcon(ti1);
		memTableBtn = new JButton(li1);
		memTableBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memTablePrint();
				memSearchText.setText("");
			}
		});
		memTableBtn.setFont(new Font("굴림", Font.PLAIN, 5));
		memTableBtn.setBounds(281, 10, 30, 30);
		memberBottomPane.add(memTableBtn);
		
		memSearchText = new JTextField();
		memSearchText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchMemTablePrint();
				} else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					memSearchText.setText("");
					memTablePrint();
				}				
			}
		});
		memSearchText.setColumns(10);
		memSearchText.setBounds(318, 10, 183, 30);
		memberBottomPane.add(memSearchText);
		
		memSearchBtn = new JButton("검색", imageResize("/com/kosmo/book/search.png", 15));
		memSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchMemTablePrint();
			}
		});
		memSearchBtn.setFont(new Font("D2Coding", Font.PLAIN, 15));
		memSearchBtn.setBounds(508, 10, 85, 30);
		memberBottomPane.add(memSearchBtn);
	}
}
