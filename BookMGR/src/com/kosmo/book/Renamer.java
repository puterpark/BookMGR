package com.kosmo.book;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class Renamer extends JFrame {

	private JTabbedPane rPane;
	private JPanel insertPane;
	private Container panel;
	private Container framePanel;
	private JPanel removePane;
	private JPanel deletePane;
	private JPanel replacePane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JPanel bottomPane;
	private JPanel actionPane;
	private JTable nameTable;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JTable actionTable;
	private JScrollPane scrollPane_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btnNewButton;
	private JPanel panel_4;
	private JPanel panel_5;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Renamer frame = new Renamer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Renamer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 400, 600, 1000);
		framePanel = new JPanel();
		setContentPane(framePanel);
		framePanel.setLayout(new BorderLayout(0, 0));
		setTitle("renombrar");
		
		
		
		panel = new JPanel();
		framePanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		menuBar = new JMenuBar();
		panel.add(menuBar, BorderLayout.NORTH);
		
		mnNewMenu = new JMenu("파일(F)");
		mnNewMenu.setMnemonic('F');
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Open");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Close");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mnNewMenu_1 = new JMenu("편집(E)");
		mnNewMenu_1.setMnemonic('E');
		menuBar.add(mnNewMenu_1);
		
		mnNewMenu_2 = new JMenu("도움말(H)");
		mnNewMenu_2.setMnemonic('H');
		mnNewMenu_2.setMnemonic(KeyEvent.VK_F1);
		menuBar.add(mnNewMenu_2);
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
				rPane = new JTabbedPane();
				panel_1.add(rPane);
				rPane.setPreferredSize(new Dimension(250, 100));
				insertPane = new JPanel();
				insertPane.setPreferredSize(new Dimension(0, 300));
				insertPane.setBorder(new EmptyBorder(0, 20, 0, 20));
				rPane.addTab("추가", insertPane);
				insertPane.setLayout(new GridLayout(0, 1, 0, 0));
				insertPane.setToolTipText("관리자(u) 계정 추가");
				deletePane = new JPanel();
				deletePane.setBorder(new EmptyBorder(0, 20, 0, 20));
				rPane.addTab("삭제", deletePane);
				deletePane.setLayout(new GridLayout(0, 1, 0, 0));
				removePane = new JPanel();
				removePane.setBorder(new EmptyBorder(0, 20, 0, 20));
				rPane.addTab("수정", removePane);
				removePane.setLayout(new GridLayout(0, 1, 0, 0));
				
						replacePane = new JPanel();
						replacePane.setBorder(new EmptyBorder(0, 20, 0, 20));
						rPane.addTab("삭제", null, replacePane, null);
						replacePane.setLayout(new GridLayout(0, 1, 0, 0));
						
								actionTable = new JTable();
								actionTable.setModel(new DefaultTableModel(
									new Object[][] {
									},
									new String[] {
										"\uC21C\uC11C", "\uADDC\uCE59", "\uC694\uC57D"
									}
								));
								scrollPane_1 = new JScrollPane(actionTable);
								panel_1.add(scrollPane_1, BorderLayout.SOUTH);
		
		panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_5 = new JPanel();
		panel_3.add(panel_5);
		
		btnNewButton = new JButton("파일 추가");
		panel_5.add(btnNewButton);
		
		panel_4 = new JPanel();
		panel_3.add(panel_4);
		
		button = new JButton("변경");
		panel_4.add(button);
		
		bottomPane = new JPanel();
		panel_2.add(bottomPane, BorderLayout.SOUTH);
		bottomPane.setLayout(new BorderLayout(0, 0));
		
		actionPane = new JPanel();
		bottomPane.add(actionPane, BorderLayout.NORTH);
		actionPane.setLayout(new BorderLayout(0, 0));
		
		nameTable = new JTable();
		nameTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uC0C1\uD0DC", "\uD604\uC7AC\uC774\uB984", "\uBCC0\uACBD\uC774\uB984"
			}
		));
		scrollPane = new JScrollPane(nameTable);
		actionPane.add(scrollPane, BorderLayout.CENTER);
	}

}
