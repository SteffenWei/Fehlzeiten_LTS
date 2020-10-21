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
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;



public class GUI extends JFrame {
	public String col[] = {"Name","Tag","Grund", "Personalnr", "Zeit", "test"};
	public DefaultTableModel tableModel = new DefaultTableModel(col, 0);
	public String[] grundarray = {"Krankheit", "Durchfall", "keine Lust", "Simon"};
	public JComboBox persontxt = new JComboBox();
	public Object[] arraypers;
	public List<String> personri = new ArrayList<String>();
	public String lehrercomboliste[];
	static List<Buecher> blist = new ArrayList<Buecher>();
	private JPanel contentPane;
	private JTextField datumvontxt;
	private JTextField datumbistxt;
	private JTextField stundevontxt;
	private JTextField stundebistxt;
	private JTable table;
	private JTextField textField;
	private JTable table_1;

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
			
		
		/**Buecher ist temporär und wird später durch Lehrer ausgetauscht*/
		
		Buecher btemp2 = new Buecher("herr pinther","Herr Pinther","Mathe",0,13678,1);
		blist.add(btemp2);
		Buecher btemp3 = new Buecher("weidmann","Herr Mertens","Mathe",0,13679,2);
		blist.add(btemp3);
		
		for(int i = 0; i<blist.size();i++){
			Buecher btemp1 = blist.get(i);
            String nametemp = btemp1.getName();
            Object[] tbltemp1 = {nametemp, "01.01.2020", "Simon", 1,20,5};
            
            tableModel.addRow(tbltemp1);
		}
        
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
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table_1 = new JTable(tableModel);
		scrollPane.setViewportView(table_1);

		
		
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
	/**test und test2 sind temporär*/
		JButton btntest = new JButton("test");
		btntest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**ersetzt einen Lehrer mit einem anderen*/
		        Buecher kkkktemp = new Buecher("mankeljunior","Herr Mertens","Mathe",0,13679,2);
                blist.set(0, kkkktemp);
                
				while(personri.size() > 0) {
					  personri.remove(0);
					}
				for(int i = 0; i<blist.size();i++){
					Buecher btemp1 = blist.get(i);
					personri.add(btemp1.getName());
				}
				
				Object[] arraypers = personri.toArray();
				JComboBox persontxttst = new JComboBox(arraypers);
		        System.out.println( Arrays.toString(arraypers) );
		        
			}});
		btntest.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btntest.setBounds(410, 97, 200, 50);
		panelfz.add(btntest);
		
		JButton btntest2 = new JButton("test2");
		btntest2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**fügt einen neuen Lehrer hinzu*/
				save("mankel","Herr Mertens","Mathe",0,13679,2);
			}
		});
		btntest2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btntest2.setBounds(410, 175, 200, 50);
		panelfz.add(btntest2);
		
		JButton btnrefresh = new JButton("aktualisieren");
		btnrefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				setup();
			}
		});
		btnrefresh.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnrefresh.setBounds(400, 27, 200, 50);
		panelfz.add(btnrefresh);
		
		JButton btnTest = new JButton("test3");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listerefresh();
			}
		});
		btnTest.setBounds(455, 272, 89, 23);
		panelfz.add(btnTest);
		

		

		
		
		
//setupzeugs und so
			setup();
			say("Setup fertig!");
			
	}
	
	
	
	public void setup(){
        System.out.println("aktualisiert personen:");
        
        while(personri.size() > 0) {
			  personri.remove(0);
			}
		for(int i = 0; i<blist.size();i++){
			Buecher btemp1 = blist.get(i);
			personri.add(btemp1.getName());
		}
		Object[] arraypers = personri.toArray();
		System.out.println( Arrays.toString(arraypers) );
		persontxt.setModel(new DefaultComboBoxModel(arraypers));
		
		
	}
	
	public void say(String a){System.out.println(a);}
	
	public void save(String a,String b,String c, int d, int e, int f){
		Buecher btemp4 = new Buecher(a,b,c,d,e,f);
		blist.add(btemp4);
		System.out.println("gespeichert: " + a);
	}
	
	public void listerefresh(){
		while(tableModel.getRowCount() > 0) {
			tableModel.removeRow(0);
			}
		
		for(int i = 0; i<blist.size();i++){
			Buecher btemp1 = blist.get(i);
            String nametemp = btemp1.getName();
            Object[] tbltemp1 = {nametemp, "01.01.2020", "Simon", 1,20,5};
            
            tableModel.addRow(tbltemp1);
		}
		
	}
	}



