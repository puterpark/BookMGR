package com.kosmo.book;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BookAdd extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	private BookMgr bookMgr = null;//--------------------------------
//	public BookAdd(JFrame f) {
////		this.parentFrame =  f;
//////		Component component = (Component) e.getSource();
//////        JFrame frame = (JFrame) SwingUtilities.getRoot(component);
////		
////		new BookAdd();
//		
//	}
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					System.out.println("main call");
////					BookAdd frame = new BookAdd();
////					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//	
	
	public ImageIcon imageResize(String path, int s) {
		ImageIcon fi = new ImageIcon(BookMgr.class.getResource(path));
		Image si = fi.getImage();
		Image ti = si.getScaledInstance(s, s, java.awt.Image.SCALE_SMOOTH);
		ImageIcon li = new ImageIcon(ti);
		return li;
	}
	
	/**
	 * Create the frame.
	 */
	public BookAdd(BookMgr bookMgr) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.bookMgr = bookMgr;
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setBounds(100, 100, 370, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("도서추가");
		
//		System.out.println(bookMgr);
		
		JPanel panel_15 = new JPanel();
		panel_15.setFont(new Font("D2Coding", Font.PLAIN, 12));
		panel_15.setBorder(new TitledBorder(new LineBorder(new Color(130, 135, 144), 1),"도서추가"));
		contentPane.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		
		
		
		JPanel panel = new JPanel();
		panel_15.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{96, 229, 0};
		gbl_panel.rowHeights = new int[]{40, 40, 40, 40, 40, 40, 36, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(50, 0));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel label = new JLabel("도서명");
		label.setFont(new Font("D2Coding", Font.PLAIN, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(2, 2, 2, 2));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 10, 0));
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		panel.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("지은이");
		lblNewLabel.setFont(new Font("D2Coding", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(2, 2, 2, 2));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 1;
		panel.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		textField_1 = new JTextField();
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 2;
		panel.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("옮긴이");
		lblNewLabel_1.setFont(new Font("D2Coding", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EmptyBorder(2, 2, 2, 2));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 2;
		panel.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		textField_2 = new JTextField();
		panel_6.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 3;
		panel.add(panel_7, gbc_panel_7);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("출판사");
		lblNewLabel_2.setFont(new Font("D2Coding", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblNewLabel_2);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new EmptyBorder(2, 2, 2, 2));
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.gridx = 1;
		gbc_panel_8.gridy = 3;
		panel.add(panel_8, gbc_panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		textField_3 = new JTextField();
		panel_8.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.insets = new Insets(0, 0, 5, 5);
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 4;
		panel.add(panel_9, gbc_panel_9);
		panel_9.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("ISBN");
		lblNewLabel_3.setFont(new Font("D2Coding", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_3);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new EmptyBorder(2, 2, 2, 2));
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.insets = new Insets(0, 0, 5, 0);
		gbc_panel_10.gridx = 1;
		gbc_panel_10.gridy = 4;
		panel.add(panel_10, gbc_panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		textField_4 = new JTextField();
		panel_10.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.insets = new Insets(0, 0, 5, 5);
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 5;
		panel.add(panel_11, gbc_panel_11);
		panel_11.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("가격");
		lblNewLabel_4.setFont(new Font("D2Coding", Font.PLAIN, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(lblNewLabel_4);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new EmptyBorder(2, 2, 2, 2));
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.insets = new Insets(0, 0, 5, 0);
		gbc_panel_12.gridx = 1;
		gbc_panel_12.gridy = 5;
		panel.add(panel_12, gbc_panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		textField_5 = new JTextField();
		panel_12.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_13 = new JPanel();
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.fill = GridBagConstraints.BOTH;
		gbc_panel_13.insets = new Insets(0, 0, 0, 5);
		gbc_panel_13.gridx = 0;
		gbc_panel_13.gridy = 6;
		panel.add(panel_13, gbc_panel_13);
		panel_13.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("페이지");
		lblNewLabel_5.setFont(new Font("D2Coding", Font.PLAIN, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_13.add(lblNewLabel_5);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBorder(new EmptyBorder(2, 2, 2, 2));
		GridBagConstraints gbc_panel_16 = new GridBagConstraints();
		gbc_panel_16.fill = GridBagConstraints.BOTH;
		gbc_panel_16.gridx = 1;
		gbc_panel_16.gridy = 6;
		panel.add(panel_16, gbc_panel_16);
		panel_16.setLayout(new BorderLayout(0, 0));
		
		textField_6 = new JTextField();
		textField_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertEvent();
				//-------------------------------------------------------parent panel repaint
				
				bookMgr.bookTablePrint();
				dispose();
			}
		});
		panel_16.add(textField_6);
		textField_6.setColumns(10);
		
		JPanel panel_14 = new JPanel();
		panel_15.add(panel_14, BorderLayout.SOUTH);
		panel_14.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton button = new JButton("추가", imageResize("/com/test/swing/check.png", 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertEvent();
				//-------------------------------------------------------parent panel repaint
				
				bookMgr.bookTablePrint();
				dispose();
			}
		});
		button.setFont(new Font("D2Coding", Font.PLAIN, 15));
		panel_14.add(button);
		
		JLabel label_2 = new JLabel("");
		panel_14.add(label_2);
		
		JButton button_1 = new JButton("취소", imageResize("/com/test/swing/cancel.png", 15));
		button_1.setFont(new Font("D2Coding", Font.PLAIN, 15));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setActionCommand("OK");
		panel_14.add(button_1);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("C:\\34DEV\\Java\\workspaceJava\\JAVA_PRJ\\src\\com\\test\\swing\\book.png");
		setIconImage(img);		
		
		setVisible(true);
		setResizable(false);
	}
	
	

	private void insertEvent() {
		int result = JOptionPane.showConfirmDialog(null, "도서정보가 추가됩니다.", "도서정보 추가 확인", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.CLOSED_OPTION || result == JOptionPane.NO_OPTION) {
			
		} else if (result == JOptionPane.YES_OPTION) {
			
			BookCrud b = new BookCrud();
			BookVO vo = new BookVO();
			
//			pstmt.setString(1, vo.getBtitle());
//			pstmt.setString(2, vo.getBauthor());
//			pstmt.setString(3, vo.getBtranslator());
//			pstmt.setString(4, vo.getBpublisher());
//			pstmt.setString(5, vo.getBisbn());
//			pstmt.setInt(6, vo.getBprice());
//			pstmt.setString(7, vo.getBpage());
			
			vo.setBtitle(textField.getText());
			vo.setBauthor(textField_1.getText());
			vo.setBtranslator(textField_2.getText());
			vo.setBpublisher(textField_3.getText());
			vo.setBisbn(textField_4.getText());
			vo.setBprice(Integer.parseInt((textField_5.getText())));
			vo.setBpage(textField_6.getText());
			
			b.bookInsert(vo);
			
			
			
//			bm.tablePrint();
			
		}
	}
	
	
	

}
