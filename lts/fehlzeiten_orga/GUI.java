package fehlzeiten_orga;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JLabel;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;



public class GUI extends JFrame {
	public String col[] = {"Name","Tag","Grund", "Personalnr", "Zeit", "test"};
	public String col2[] = {"Vorname", "Nachname", "Kürzel", "Personalnr", "PLZ", "Straße", "TelNr.", "Mail"};
	public DefaultTableModel tableModel = new DefaultTableModel(col, 0);
	public DefaultTableModel tableModel2 = new DefaultTableModel(col2, 0);
	public String[] grundarray = {"Krankheit", "Durchfall", "keine Lust", "Simon"};
	public JComboBox persontxt = new JComboBox();
	public Object[] arraypers;
	public List<String> personri = new ArrayList<String>();
	private JPanel contentPane;
	private JTextField datumvontxt;
	private JTextField datumbistxt;
	private JTextField stundevontxt;
	private JTextField stundebistxt;
	private JTable table;
	private JTextField textField;
	private JTable table_1;
	private JTable table_2;
	private JTextField vnametxt;
	private JTextField nnametxt;
	private JTextField strassetxt;
	private JTextField plztxt;
	private JTextField mailtxt;
	private JTextField telnrtxt;
	private JTextField persnrtxt;
	private JTextField krzltxt;

//Start des Programms
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//Frame erstellen
	public GUI() {
		
		
 //guisetupzeugs


		System.out.println("running GUI");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 864, 539);
		contentPane.add(tabbedPane);
		
		JPanel panelfz = new JPanel();
		tabbedPane.addTab("Fehlzeiten", null, panelfz, null);
		panelfz.setLayout(null);
		
		JPanel panellul = new JPanel();
		tabbedPane.addTab("LehrerInnen", null, panellul, null);
		panellul.setLayout(null);
		
		vnametxt = new JTextField();
		vnametxt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		vnametxt.setColumns(10);
		vnametxt.setBounds(142, 180, 200, 59);
		panellul.add(vnametxt);
		
		nnametxt = new JTextField();
		nnametxt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		nnametxt.setColumns(10);
		nnametxt.setBounds(142, 110, 200, 59);
		panellul.add(nnametxt);
		
		strassetxt = new JTextField();
		strassetxt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		strassetxt.setColumns(10);
		strassetxt.setBounds(517, 180, 200, 59);
		panellul.add(strassetxt);
		
		plztxt = new JTextField();
		plztxt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		plztxt.setColumns(10);
		plztxt.setBounds(517, 110, 200, 59);
		panellul.add(plztxt);
		
		mailtxt = new JTextField();
		mailtxt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		mailtxt.setColumns(10);
		mailtxt.setBounds(517, 320, 200, 59);
		panellul.add(mailtxt);
		
		telnrtxt = new JTextField();
		telnrtxt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		telnrtxt.setColumns(10);
		telnrtxt.setBounds(517, 250, 200, 59);
		panellul.add(telnrtxt);
		
		persnrtxt = new JTextField();
		persnrtxt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		persnrtxt.setColumns(10);
		persnrtxt.setBounds(142, 320, 200, 59);
		panellul.add(persnrtxt);
		
		krzltxt = new JTextField();
		krzltxt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		krzltxt.setColumns(10);
		krzltxt.setBounds(142, 250, 200, 59);
		panellul.add(krzltxt);
		
		JLabel lblNachname = new JLabel("Nachname");
		lblNachname.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNachname.setBounds(10, 119, 131, 50);
		panellul.add(lblNachname);
		
		JLabel lblVorname = new JLabel("Vorname");
		lblVorname.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblVorname.setBounds(10, 189, 131, 50);
		panellul.add(lblVorname);
		
		JLabel lblKrzel = new JLabel("K\u00FCrzel");
		lblKrzel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblKrzel.setBounds(10, 259, 131, 50);
		panellul.add(lblKrzel);
		
		JLabel lblPersonalnr = new JLabel("PersonalNr.");
		lblPersonalnr.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPersonalnr.setBounds(10, 329, 131, 50);
		panellul.add(lblPersonalnr);
		
		JLabel lblPlz = new JLabel("PLZ");
		lblPlz.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPlz.setBounds(408, 119, 131, 50);
		panellul.add(lblPlz);
		
		JLabel lblStrae = new JLabel("Stra\u00DFe");
		lblStrae.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblStrae.setBounds(408, 189, 131, 50);
		panellul.add(lblStrae);
		
		JLabel lblTelnr = new JLabel("TelNr.");
		lblTelnr.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTelnr.setBounds(408, 259, 131, 50);
		panellul.add(lblTelnr);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMail.setBounds(408, 329, 131, 50);
		panellul.add(lblMail);
		
		JButton btnNeuenLehrerAnlegen = new JButton("neuen Lehrer anlegen");
		btnNeuenLehrerAnlegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.eingabeLuL(nnametxt.getText(), vnametxt.getText(), krzltxt.getText(), persnrtxt.getText(),
						plztxt.getText(), strassetxt.getText(), telnrtxt.getText(), mailtxt.getText());
				System.out.println(Main.Lehrerlist.get(0).getVname());
				System.out.println("Lehrer "+ nnametxt.getText() +" gespeichert");
			}
		});
		btnNeuenLehrerAnlegen.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNeuenLehrerAnlegen.setBounds(24, 416, 285, 50);
		panellul.add(btnNeuenLehrerAnlegen);
		
		JScrollPane scrollPanefzl = new JScrollPane();
		tabbedPane.addTab("Fehlzeitenliste", null, scrollPanefzl, null);
		
		table_1 = new JTable(tableModel);
		scrollPanefzl.setViewportView(table_1);
		
		JScrollPane scrollPanelull = new JScrollPane();
		tabbedPane.addTab("Lehrerliste", null, scrollPanelull, null);
		
		table_2 = new JTable(tableModel2);
		scrollPanelull.setViewportView(table_2);

		
		
		JComboBox grundtxt = new JComboBox(grundarray);
		grundtxt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		grundtxt.setBounds(163, 93, 200, 59);
		panelfz.add(grundtxt);
		
		datumvontxt = new JTextField();
		datumvontxt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		datumvontxt.setBounds(163, 202, 200, 59);
		panelfz.add(datumvontxt);
		datumvontxt.setColumns(10);
		
		datumbistxt = new JTextField();
		datumbistxt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		datumbistxt.setColumns(10);
		datumbistxt.setBounds(163, 272, 200, 59);
		panelfz.add(datumbistxt);
		
		stundevontxt = new JTextField();
		stundevontxt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		stundevontxt.setColumns(10);
		stundevontxt.setBounds(163, 371, 200, 59);
		panelfz.add(stundevontxt);
		
		stundebistxt = new JTextField();
		stundebistxt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		stundebistxt.setColumns(10);
		stundebistxt.setBounds(163, 441, 200, 59);
		panelfz.add(stundebistxt);
		
		persontxt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		persontxt.setBounds(163, 23, 200, 59);
		panelfz.add(persontxt);
		
		JLabel lblLehrerinn = new JLabel("LehrerInn:");
		lblLehrerinn.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLehrerinn.setBounds(10, 27, 131, 50);
		panelfz.add(lblLehrerinn);
		
		JLabel lblGrund = new JLabel("Grund:");
		lblGrund.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblGrund.setBounds(10, 93, 131, 50);
		panelfz.add(lblGrund);
		
		JLabel lblDatum = new JLabel("Datum");
		lblDatum.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDatum.setBounds(218, 156, 131, 50);
		panelfz.add(lblDatum);
		
		JLabel lblVon = new JLabel("von:");
		lblVon.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblVon.setBounds(10, 206, 131, 50);
		panelfz.add(lblVon);
		
		JLabel lblBis = new JLabel("bis:");
		lblBis.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBis.setBounds(10, 276, 131, 50);
		panelfz.add(lblBis);
		
		JLabel lblStunden = new JLabel("Stunden");
		lblStunden.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblStunden.setBounds(218, 329, 131, 50);
		panelfz.add(lblStunden);
		
		JLabel label = new JLabel("von:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label.setBounds(10, 371, 131, 50);
		panelfz.add(label);
		
		JLabel label_1 = new JLabel("bis:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_1.setBounds(10, 441, 131, 50);
		panelfz.add(label_1);

		
//buttons
		
		JButton btnrefresh = new JButton("aktualisieren");
		btnrefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				setup();
			}
		});
		btnrefresh.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnrefresh.setBounds(400, 27, 200, 50);
		panelfz.add(btnrefresh);
		
		JButton btnladen = new JButton("laden");
		btnladen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//laden();
				Main.laden();
			}
		});
		btnladen.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnladen.setBounds(410, 329, 200, 50);
		panelfz.add(btnladen);

		
//setupzeugs und so
		
		    Main.laden();
			setup();
			
			for(int i = 0; i<Main.Lehrerlist.size();i++){
				Lehrer ltemp1 = Main.Lehrerlist.get(i);
	            String nametemp = ltemp1.getNname();
	            Object[] tbltemp1 = {nametemp, "01.01.2020", "Simon", 1,20,5};
	            Object[] tbltemp2 = {ltemp1.getVname(), ltemp1.getNname(), ltemp1.getKrzl(), ltemp1.getPersnr(), 
	            		ltemp1.getPlz(), ltemp1.getStrasse(), ltemp1.getTelnr(), ltemp1.getMail()};
	            
	            tableModel.addRow(tbltemp1);
	            tableModel2.addRow(tbltemp2);
			}
	        
			System.out.println("Setup fertig!");
			
	}
	
	
	
	public void setup(){
        System.out.println("aktualisiert personen:");
        
        while(personri.size() > 0) {
			  personri.remove(0);
			}
		for(int i = 0; i<Main.Lehrerlist.size();i++){
			Lehrer ltemp1 = Main.Lehrerlist.get(i);
			personri.add(ltemp1.getNname());
		}
		Object[] arraypers = personri.toArray();
		System.out.println( Arrays.toString(arraypers) );
		persontxt.setModel(new DefaultComboBoxModel(arraypers));
		
		
	}
	}



