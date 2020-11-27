package fehlzeiten_orga;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Color;
import java.awt.SystemColor;



public class GUI extends JFrame {
	public String col[] = {"Name","Tage","Grund", "Personalnr", "Stunden", "Kürzel"};
	public String col2[] = {"Vorname", "Nachname", "Kürzel", "Personalnr", "PLZ", "Straße", "TelNr.", "Mail"};
	public DefaultTableModel tableModel = new DefaultTableModel(col, 0);
	public DefaultTableModel tableModel2 = new DefaultTableModel(col2, 0);
	public String[] grundarray = {"Krankheit", "Tod eines Familienmitglieds", "Umzug aus dienstl. Gründen", "Arbeitsjubiläum", "Schwere Erkrankung Angehöriger, betreute Person" , "Fortbildung" , "Ausübung öffentlicher Ehrenämter" , "Ausbildung von LiV" , "sonstige"};
	public JComboBox persontxt = new JComboBox();
	public JComboBox krzlctxt = new JComboBox();
	public JComboBox grundtxt = new JComboBox(grundarray);
	public JComboBox krzlctxt1 = new JComboBox();
	public JComboBox krzlctxt1_fz = new JComboBox();
	public JComboBox fzload = new JComboBox();
	public Object[] arraypers;
	public List<String> personri = new ArrayList<String>();
	public List<String> krzlri = new ArrayList<String>();
	public List<String> fehlzeitri = new ArrayList<String>();
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
	private JTextField grundsonstigetxt;
	
	private DateFormat formatter = new SimpleDateFormat("dd.MM.yyy");
	
	public static JFileChooser chooser = new JFileChooser();
	
	String leLaden;
	private JTextField txtSonst;
	private JTextField txtgnd;
	private JTextField txtStdVo;
	private JTextField txtTagVo;
	private JTextField txtTagBis;
	private JTextField txtStdBis;

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
		tabbedPane.setBounds(10, 22, 864, 539);
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
				System.out.println(Main.lehrerList.get(0).getVname());
				System.out.println("Lehrer "+ nnametxt.getText() +" gespeichert");
			}
		});
		btnNeuenLehrerAnlegen.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNeuenLehrerAnlegen.setBounds(24, 416, 285, 50);
		panellul.add(btnNeuenLehrerAnlegen);
		
		
		krzlctxt1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		krzlctxt1.setBounds(142, 11, 200, 59);
		panellul.add(krzlctxt1);
		
		JButton btnEinsetzen = new JButton("einsetzen");
		btnEinsetzen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  String selectedKrzl1 = (String) krzlctxt1.getSelectedItem();
				Lehrer ltemp11 = Lehrer.suche(selectedKrzl1);
				if(selectedKrzl1 == ""){
					nnametxt.setText("");
					vnametxt.setText("");
					krzltxt.setText("");
					telnrtxt.setText("");
					mailtxt.setText("");
					persnrtxt.setText("");
					plztxt.setText("");
					strassetxt.setText("");
				}else{
				nnametxt.setText(ltemp11.getNname());
				vnametxt.setText(ltemp11.getVname());
				krzltxt.setText(ltemp11.getKrzl());
				telnrtxt.setText(ltemp11.getTelnr());
				mailtxt.setText(ltemp11.getMail());
				persnrtxt.setText(ltemp11.getPersnr());
				plztxt.setText(ltemp11.getPlz());
				strassetxt.setText(ltemp11.getStrasse());
				}
			}
		});
		btnEinsetzen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnEinsetzen.setBounds(370, 23, 150, 35);
		panellul.add(btnEinsetzen);
		
		JButton btnRefresh = new JButton("aktualisieren");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  setup();
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnRefresh.setBounds(572, 0, 150, 35);
		contentPane.add(btnRefresh);
		
		JPanel panelFzLoad = new JPanel();
		panelFzLoad.setBackground(SystemColor.menu);
		tabbedPane.addTab("Fehlzeiten \u00E4ndern", null, panelFzLoad, null);
		panelFzLoad.setLayout(null);
		
		txtSonst = new JTextField();
		txtSonst.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtSonst.setBounds(533, 120, 200, 59);
		panelFzLoad.add(txtSonst);
		txtSonst.setColumns(10);
		
		txtgnd = new JTextField();
		txtgnd.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtgnd.setColumns(10);
		txtgnd.setBounds(131, 120, 200, 59);
		panelFzLoad.add(txtgnd);
		
		txtStdVo = new JTextField();
		txtStdVo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtStdVo.setColumns(10);
		txtStdVo.setBounds(131, 320, 200, 59);
		panelFzLoad.add(txtStdVo);
		
		txtTagVo = new JTextField();
		txtTagVo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtTagVo.setColumns(10);
		txtTagVo.setBounds(131, 220, 200, 59);
		panelFzLoad.add(txtTagVo);
		
		txtTagBis = new JTextField();
		txtTagBis.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtTagBis.setColumns(10);
		txtTagBis.setBounds(533, 220, 200, 59);
		panelFzLoad.add(txtTagBis);
		
		txtStdBis = new JTextField();
		txtStdBis.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtStdBis.setColumns(10);
		txtStdBis.setBounds(533, 320, 200, 59);
		panelFzLoad.add(txtStdBis);
		
		JLabel lblNewLabel = new JLabel("Grund");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(10, 133, 90, 35);
		panelFzLoad.add(lblNewLabel);
		
		JLabel lblTagVon = new JLabel("Tag von");
		lblTagVon.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTagVon.setBounds(10, 233, 90, 35);
		panelFzLoad.add(lblTagVon);
		
		JLabel lblStundeVon = new JLabel("Stunde von");
		lblStundeVon.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblStundeVon.setBounds(10, 333, 101, 35);
		panelFzLoad.add(lblStundeVon);
		
		JLabel lblBis_2 = new JLabel("bis");
		lblBis_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblBis_2.setBounds(430, 333, 53, 35);
		panelFzLoad.add(lblBis_2);
		
		JLabel lblBis_1 = new JLabel("bis");
		lblBis_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblBis_1.setBounds(430, 234, 53, 35);
		panelFzLoad.add(lblBis_1);
		
		JLabel lblSonstige = new JLabel("sonstige");
		lblSonstige.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSonstige.setBounds(430, 133, 85, 35);
		panelFzLoad.add(lblSonstige);
		krzlctxt1_fz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String auswahl = (String)krzlctxt1_fz.getSelectedItem();
				Lehrer tmpLehrer = Main.searchkrzl(auswahl);
				
				while(fehlzeitri.size() > 0) {
					  fehlzeitri.remove(0);
					}
				
				for(int i = 1; i<tmpLehrer.getFlist().size();i++){
					Fehlzeiten lfehlzeit = tmpLehrer.getFlist().get(i);	
					fehlzeitri.add(formatter.format(lfehlzeit.getFehltagevon()));
				}
				Object[] arrayfz = fehlzeitri.toArray();
				fzload.setModel(new DefaultComboBoxModel(arrayfz));
			}
		});
		
		
		krzlctxt1_fz.setFont(new Font("Tahoma", Font.PLAIN, 22));
		krzlctxt1_fz.setBounds(44, 22, 200, 59);
		panelFzLoad.add(krzlctxt1_fz);
		
		
		fzload.setFont(new Font("Tahoma", Font.PLAIN, 22));
		fzload.setBounds(309, 22, 200, 59);
		panelFzLoad.add(fzload);
		
		JButton btnLadFz = new JButton("Laden");
		btnLadFz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String auswahlLul = "";
				auswahlLul= (String)krzlctxt1_fz.getSelectedItem();
				Lehrer tmpLehrer = Main.searchkrzl(auswahlLul);
				
				String auswahlFz =  "";
				auswahlFz =(String)fzload.getSelectedItem();
				
				Fehlzeiten lfehlzeit = null;
				
				
				if( !(auswahlLul.equals("")) && !(auswahlFz.equals(""))) {
					for(int i = 1; i<tmpLehrer.getFlist().size();i++){
						lfehlzeit = tmpLehrer.getFlist().get(i);
						if (lfehlzeit.getFehltagevon().equals(fzload.getSelectedItem())) {
							break;
						} 
					}
					txtgnd.setText(lfehlzeit.getFehlgrund());
					txtSonst.setText(lfehlzeit.getGrundsonstige());
					txtTagVo.setText(formatter.format(lfehlzeit.getFehltagevon()));
					txtTagBis.setText(formatter.format(lfehlzeit.getFehltagebis()));
					txtStdVo.setText("" + lfehlzeit.getFehlstundenvon());
					txtStdBis.setText("" + lfehlzeit.getFehlstundenbis());
					
				}
				
			}
		});
		btnLadFz.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnLadFz.setBounds(572, 34, 141, 35);
		panelFzLoad.add(btnLadFz);
		
		//Speichern Fehlzeiten verändert
		JButton btnSpeichern = new JButton("speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String auswahlLul = "";
				auswahlLul= (String)krzlctxt1_fz.getSelectedItem();
				Lehrer tmpLehrer = Main.searchkrzl(auswahlLul);
				
				String auswahlFz =  "";
				auswahlFz =(String)fzload.getSelectedItem();
				
				Fehlzeiten lfehlzeit = null;
				
				
				if( !(auswahlLul.equals("")) && !(auswahlFz.equals(""))) {
					int position = 0;
					for(int i = 1; i<tmpLehrer.getFlist().size();i++){
						lfehlzeit = tmpLehrer.getFlist().get(i);
						if (lfehlzeit.getFehltagevon().equals(fzload.getSelectedItem())) {
							position = i;
							break;
						} 
					}
					
					lfehlzeit.setFehlgrund(txtgnd.getText());
					lfehlzeit.setGrundsonstige(txtSonst.getText());
					Date date1 = null;
					try {
						date1 = new SimpleDateFormat("dd.MM.yyyy").parse(txtTagVo.getText());
					} catch (ParseException e1) {
						JOptionPane.showMessageDialog(null, "Datum bitte im Format tt.mm.yyyy eingeben");
						e1.printStackTrace();
					}
					Date date2 = null;
					try {
						date2 = new SimpleDateFormat("dd.MM.yyyy").parse(txtTagBis.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					lfehlzeit.setFehltagevon(date1);
					lfehlzeit.setFehltagebis(date2);
					lfehlzeit.setFehlstundenvon(Integer.parseInt(txtStdVo.getText()));
					lfehlzeit.setFehlstundenbis(Integer.parseInt(txtStdBis.getText()));	
					
					tmpLehrer.getFlist().remove(position);
					
					tmpLehrer.getFlist().add(position, lfehlzeit);	
					
					int luLposition = Main.position(tmpLehrer.getKrzl());
					Main.lehrerList.remove(luLposition);
					Main.lehrerList.add(luLposition,tmpLehrer);
					
				}
				
			}
		});
		btnSpeichern.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSpeichern.setBounds(668, 419, 141, 35);
		panelFzLoad.add(btnSpeichern);
		
		JScrollPane scrollPanefzl = new JScrollPane();
		tabbedPane.addTab("Fehlzeitenliste", null, scrollPanefzl, null);
		
		table_1 = new JTable(tableModel);
		scrollPanefzl.setViewportView(table_1);
		
		JScrollPane scrollPanelull = new JScrollPane();
		tabbedPane.addTab("Lehrerliste", null, scrollPanelull, null);
		
		table_2 = new JTable(tableModel2);
		scrollPanelull.setViewportView(table_2);

		
		
		
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
		persontxt.setBounds(390, 23, 200, 59);
		panelfz.add(persontxt);
		
		krzlctxt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		krzlctxt.setBounds(163, 23, 200, 59);
		panelfz.add(krzlctxt);
		
		JLabel lblLehrerinn = new JLabel("LehrerIn:");
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
		
		JButton btnFehlzeitSpeichern = new JButton("Fehlzeit speichern");
		btnFehlzeitSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String selectedGrund = (String) grundtxt.getSelectedItem();
				String selectedLehrer = (String) persontxt.getSelectedItem();
				String selectedKrzl = (String) krzlctxt.getSelectedItem();
				Date date1 = null;
				try {
					date1 = new SimpleDateFormat("dd.MM.yyyy").parse(datumvontxt.getText());
				} catch (ParseException e) {
					JOptionPane.showMessageDialog(null, "Datum bitte im Format tt.mm.yyyy eingeben");
					e.printStackTrace();
				}
				Date date2 = null;
				try {
					date2 = new SimpleDateFormat("dd.MM.yyyy").parse(datumbistxt.getText());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Main.fzspeichern(selectedLehrer, selectedGrund, date1, date2, Integer.parseInt(stundevontxt.getText()), Integer.parseInt(stundebistxt.getText()), grundsonstigetxt.getText(), selectedKrzl);
			}
		});
		btnFehlzeitSpeichern.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnFehlzeitSpeichern.setBounds(422, 441, 285, 50);
		panelfz.add(btnFehlzeitSpeichern);
		
		grundsonstigetxt = new JTextField();
		grundsonstigetxt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		grundsonstigetxt.setColumns(10);
		grundsonstigetxt.setBounds(390, 93, 200, 59);
		panelfz.add(grundsonstigetxt);
		
		JButton btnFehlzeitLschen = new JButton("Fehlzeit l\u00F6schen");
		btnFehlzeitLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnFehlzeitLschen.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnFehlzeitLschen.setBounds(422, 371, 285, 50);
		panelfz.add(btnFehlzeitLschen);
		
		JLabel lblBeiSontigeBitte = new JLabel("bei sontige bitte ausf\u00FCllen");
		lblBeiSontigeBitte.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBeiSontigeBitte.setBounds(600, 82, 244, 37);
		panelfz.add(lblBeiSontigeBitte);
		
		JLabel lblOderFrWeitere = new JLabel("oder f\u00FCr weitere Informationen");
		lblOderFrWeitere.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOderFrWeitere.setBounds(600, 115, 244, 37);
		panelfz.add(lblOderFrWeitere);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 133, 22);
		contentPane.add(menuBar);
		
		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);
		
		JMenuItem mntmTeam = new JMenuItem("Team");
		mntmTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JDialog teJDi = new JDialog();
		        teJDi.setTitle("Das Team");
		        teJDi.setSize(600,400);
		        teJDi.setModal(true);
		        teJDi.getContentPane().add(new JLabel("Hier müsste unser Text stehen!"));
		        teJDi.setVisible(true);
			}
		});
		mnDatei.add(mntmTeam);
		
		JMenuItem mntmSpeichern = new JMenuItem("Speichern");
		mnDatei.add(mntmSpeichern);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnDatei.add(mntmExit);
		
		JMenu mnFunkt = new JMenu("Funktionen");
		menuBar.add(mnFunkt);
		
		JMenuItem mntmLadLehr = new JMenuItem("Lehrer laden");
		mntmLadLehr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leLaden = "" + Main.auswahl();
				Main.lehrerList = Main.loadLehrer(leLaden);
				
			}
		});
		mnFunkt.add(mntmLadLehr);
		
		JMenuItem mntmExpLehr = new JMenuItem("Lehrer exportieren");
		mntmExpLehr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leLaden = "" + Main.auswahlSpei();
				Main.export(leLaden);
			}
		});
		mnFunkt.add(mntmExpLehr);
		
		JMenuItem mntmAktu = new JMenuItem("Aktualisieren");
		mntmAktu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setup();
			}
		});
		mnFunkt.add(mntmAktu);
		
		
		

		
//setupzeugs und so
		
		    Main.laden();
			setup();
			

			
	        
			System.out.println("Setup fertig!");
			
	}
	
	
	public void tablesetup() {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
		
		 while(tableModel.getRowCount() > 0) {
			  tableModel.removeRow(0);
			}
		 
		 while(tableModel2.getRowCount() > 0) {
			  tableModel2.removeRow(0);
			}
		
		for(int i = 0; i<Main.lehrerList.size();i++){
			Lehrer ltemp1 = Main.lehrerList.get(i);
            String nametemp = ltemp1.getNname();
            
               for(int o = 1; o<ltemp1.getFlist().size();o++) {
            	   Fehlzeiten flztemp1 = ltemp1.getFlist().get(o);
            	   
            	   String grundtemp;
            	   if(flztemp1.getFehlgrund().contentEquals("sonstige")) {
            		   if(flztemp1.getGrundsonstige().contentEquals("")){
            			   grundtemp = "sonstige";
            		   }else{
            		   grundtemp = flztemp1.getGrundsonstige();
            		   }
            	   }else {
            		   grundtemp = flztemp1.getFehlgrund();
            	   }
            	   
            	   Object[] tbltemp1 = {nametemp, simpleDateFormat.format(flztemp1.getFehltagevon()) + " bis " + simpleDateFormat.format(flztemp1.getFehltagebis()), 
            			   grundtemp, ltemp1.getPersnr(),flztemp1.getFehlstundenvon() + " bis " + flztemp1.getFehlstundenbis(), ltemp1.getKrzl()};
            	   
            	   tableModel.addRow(tbltemp1);
               }
            
            
            Object[] tbltemp2 = {ltemp1.getVname(), ltemp1.getNname(), ltemp1.getKrzl(), ltemp1.getPersnr(), 
            		ltemp1.getPlz(), ltemp1.getStrasse(), ltemp1.getTelnr(), ltemp1.getMail()};
            
            
            tableModel2.addRow(tbltemp2);
		}
		
	}
	
	public void setup(){
		tablesetup();
		
        System.out.println("aktualisiert personen:");
        
        while(personri.size() > 0) {
			  personri.remove(0);
			}
        while(krzlri.size() > 0) {
			  krzlri.remove(0);
			}
        
        krzlri.add("");
        personri.add("");
        
		for(int i = 0; i<Main.lehrerList.size();i++){
			Lehrer ltemp1 = Main.lehrerList.get(i);
			personri.add(ltemp1.getNname());
			krzlri.add(ltemp1.getKrzl());
		}
		Object[] arraypers = personri.toArray();
		Object[] arraykrzl = krzlri.toArray();
		System.out.println( Arrays.toString(arraypers) );
		System.out.println( Arrays.toString(arraykrzl) );
		persontxt.setModel(new DefaultComboBoxModel(arraypers));
		krzlctxt.setModel(new DefaultComboBoxModel(arraykrzl));
		krzlctxt1.setModel(new DefaultComboBoxModel(arraykrzl));
		
		krzlctxt1_fz.setModel(new DefaultComboBoxModel(arraykrzl));
		
		// Methode zum Einfügen der Fehlzeiten noch eintragen
		
	}
	}



