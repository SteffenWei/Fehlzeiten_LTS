package fehlzeiten_orga;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class GUI extends JFrame {
	public String lehrercomboliste[];
	static List<Buecher> blist = new ArrayList<Buecher>();
	private String[] listeg = {"hi","Hallo","soos"};
	private JPanel contentPane;
	private JTextField datumvontxt;
	private JTextField datumbistxt;
	private JTextField stundevontxt;
	private JTextField stundebistxt;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public GUI() {
		

		
		
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
		panelfz.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				
				Buecher btemp2 = new Buecher("Mathe für Dummies 1","Herr Pinther","Mathe",0,13678,1);
				blist.add(btemp2);
				Buecher btemp3 = new Buecher("Mathe für Dummies 2","Herr Mertens","Mathe",0,13679,2);
				blist.add(btemp3);
				
				for(int i = 0; i<blist.size();i++){
					Buecher btemp1 = blist.get(i);
					 
					lehrercomboliste[i] = btemp1.getName();
				}
				
			}
		});
		tabbedPane.addTab("Fehlzeiten", null, panelfz, null);
		panelfz.setLayout(null);
		
		String[] lehrercomboliste = new String[blist.size()];
		
		//JComboBox persontxt = new JComboBox(lehrercomboliste);
		JComboBox persontxt = new JComboBox(listeg);
		persontxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
                System.out.println("hi");
				
				//Buecher btemp2 = new Buecher("Mathe für Dummies 1","Herr Pinther","Mathe",0,13678,1);
				//blist.add(btemp2);
				//Buecher btemp3 = new Buecher("Mathe für Dummies 2","Herr Mertens","Mathe",0,13679,2);
				//blist.add(btemp3);
				
				//for(int i = 0; i<blist.size();i++){
					//Buecher btemp1 = blist.get(i);
					 
					//lehrercomboliste[i] = btemp1.getName();
				//}
                
                
			}
		});
		persontxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("hi");
				
				Buecher btemp2 = new Buecher("Mathe für Dummies 1","Herr Pinther","Mathe",0,13678,1);
				blist.add(btemp2);
				Buecher btemp3 = new Buecher("Mathe für Dummies 2","Herr Mertens","Mathe",0,13679,2);
				blist.add(btemp3);
				
				for(int i = 0; i<blist.size();i++){
					Buecher btemp1 = blist.get(i);
					 
					lehrercomboliste[i] = btemp1.getName();
				}
			}
		});
		persontxt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		persontxt.setBounds(163, 23, 200, 59);
		panelfz.add(persontxt);
		
		JComboBox grundtxt = new JComboBox();
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
		
		JPanel panellul = new JPanel();
		tabbedPane.addTab("LehrerInnen", null, panellul, null);
		panellul.setLayout(null);
		
		JPanel panellist = new JPanel();
		tabbedPane.addTab("Liste", null, panellist, null);
		panellist.setLayout(null);
	}
}
