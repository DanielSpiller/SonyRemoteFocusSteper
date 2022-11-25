package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.apache.commons.lang3.time.DurationFormatUtils;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;


public class ui {
	 private static ui INSTANCE;
	private JFrame frmAlphaFocusStep;
	private JTextField textFotoCount;
	private JTextField textKeyDelay;
	private JTextField textFdylay;
	private JTextField textschäzungZeit;
	private JTextField textGemachteFotos;
	private JTextField textVerbliebeneZeit;
	private JComboBox comboBoxBelichtung;
	private JRadioButton rdbtnVtoH;
	private JRadioButton rdbtnHtoV;
	private JButton btnAction;
	private JComboBox comboBoxfs;
	private int nanosekBel=0;
	private int millisekBel=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ui window = getInstance();
					window.frmAlphaFocusStep.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public synchronized static ui getInstance() {
	    if (INSTANCE == null) {
	        INSTANCE = new ui();
	    }
	    return INSTANCE;
	}
	public ui() {

		 initialize();    

		
	}

	public void fotop() {
		int i=Integer.parseInt(textGemachteFotos.getText())+1;
		String[] g=textschäzungZeit.getText().split(" ");
		long ms=0;
		if(g[1].contentEquals("sek")) {
			ms = TimeUnit.MILLISECONDS.convert(Integer.parseInt(g[0]), TimeUnit.SECONDS);
		} else if(g[1].contentEquals("ms")) {
			 ms = Integer.parseInt(g[0]);
		} else if(g[1].contentEquals("min")) {
			ms = TimeUnit.MILLISECONDS.convert(Integer.parseInt(g[0]), TimeUnit.MINUTES);
		}
			System.out.println(Long.parseLong(textFotoCount.getText()));
			long c=Long.parseLong(textFotoCount.getText());
			long e =ms/c;
			long r=e*i;
			long rs=ms-r;

				textVerbliebeneZeit.setText(String.valueOf(DurationFormatUtils.formatDuration(rs, "mm:ss")));
			
		

		textGemachteFotos.setText(String.valueOf(i));
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlphaFocusStep = new JFrame();
		frmAlphaFocusStep.setTitle("Alpha focus stepper");
		frmAlphaFocusStep.setBounds(100, 100, 568, 343);
		frmAlphaFocusStep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlphaFocusStep.getContentPane().setLayout(null);
		
		comboBoxBelichtung = new JComboBox();
		comboBoxBelichtung.setModel(new DefaultComboBoxModel(new String[] {"1/8000", "1/6400", "1/5000", "1/4000", "1/3200", "1/2500", "1/2000", "1/1600", "1/1250", "1/1000", "1/800", "1/640", "1/500", "1/400", "1/320", "1/250", "1/200", "1/160", "1/125", "1/100", "1/80", "1/60", "1/50", "1/40", "1/30", "1/25", "1/20", "1/15", "1/13", "1/10", "1/8", "1/6", "1/5", "1/4", "1/3", "0.4\"", "0.5\"", "0.6\"", "0.8\"", "1\"", "1.3\"", "1.6\"", "2\"", "2.5\"", "3.2\"", "4\"", "5\"", "6\"", "8\"", "10\"", "13\"", "15\"", "20\"", "25\"", "30\""}));
		comboBoxBelichtung.setBounds(225, 71, 86, 22);
		frmAlphaFocusStep.getContentPane().add(comboBoxBelichtung);
		
		JLabel lblNewLabel = new JLabel("Belichtungszeit");
		lblNewLabel.setBounds(10, 71, 111, 14);
		frmAlphaFocusStep.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Focusstaps");
		lblNewLabel_1.setBounds(10, 96, 111, 14);
		frmAlphaFocusStep.getContentPane().add(lblNewLabel_1);
		
		rdbtnVtoH = new JRadioButton("nahr-> weit");
		rdbtnVtoH.setBounds(225, 100, 109, 23);
		frmAlphaFocusStep.getContentPane().add(rdbtnVtoH);
		rdbtnVtoH.setSelected(true);
		
		rdbtnHtoV = new JRadioButton("weit-> nahr");
		rdbtnHtoV.setBounds(332, 100, 109, 23);
		frmAlphaFocusStep.getContentPane().add(rdbtnHtoV);
		
		comboBoxfs = new JComboBox();
		comboBoxfs.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3"}));
		comboBoxfs.setBounds(225, 130, 86, 22);
		frmAlphaFocusStep.getContentPane().add(comboBoxfs);
		
		JLabel lblNewLabel_2 = new JLabel("Focus schrit gr\u00F6\u00DFe");
		lblNewLabel_2.setBounds(10, 130, 111, 14);
		frmAlphaFocusStep.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("anzahl fotos");
		lblNewLabel_3.setBounds(10, 162, 111, 14);
		frmAlphaFocusStep.getContentPane().add(lblNewLabel_3);
		
		textFotoCount = new JTextField();
		textFotoCount.setText("1");
		textFotoCount.setBounds(225, 163, 86, 20);
		frmAlphaFocusStep.getContentPane().add(textFotoCount);
		textFotoCount.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ms zwischen den tasten");
		lblNewLabel_4.setBounds(10, 187, 188, 14);
		frmAlphaFocusStep.getContentPane().add(lblNewLabel_4);
		
		textKeyDelay = new JTextField();
		textKeyDelay.setText("1");
		textKeyDelay.setBounds(225, 188, 86, 20);
		textKeyDelay.setColumns(10);
		frmAlphaFocusStep.getContentPane().add(textKeyDelay);
		
		JLabel lblNewLabel_5 = new JLabel("ms zwischen den Fotos");
		lblNewLabel_5.setBounds(10, 212, 188, 14);
		frmAlphaFocusStep.getContentPane().add(lblNewLabel_5);
		
		textFdylay = new JTextField();
		textFdylay.setText("1");
		textFdylay.setColumns(10);
		textFdylay.setBounds(225, 213, 86, 20);
		frmAlphaFocusStep.getContentPane().add(textFdylay);
		
		JLabel lblNewLabel_6 = new JLabel("Ben\u00F6tigte Zeit:");
		lblNewLabel_6.setBounds(332, 251, 86, 14);
		frmAlphaFocusStep.getContentPane().add(lblNewLabel_6);
		
		textschäzungZeit = new JTextField();
		textschäzungZeit.setBounds(456, 248, 86, 20);
		frmAlphaFocusStep.getContentPane().add(textschäzungZeit);
		textschäzungZeit.setColumns(10);
		
		 btnAction = new JButton("Start");
		 btnAction.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	Thread r = new Thread(new Job(Integer.parseInt(textFotoCount.getText()) , Integer.parseInt(textKeyDelay.getText()), Integer.parseInt(textFdylay.getText()) ,Integer.parseInt(comboBoxfs.getSelectedItem().toString()), nanosekBel, millisekBel, rdbtnVtoH.isSelected()), "Job");
		 	JOptionPane.showMessageDialog (frmAlphaFocusStep, "Mit den bestätigen dieser Nachricht haben sie 5 sek zeit bis die aufnamen beginnen", "Title", JOptionPane.ERROR_MESSAGE);
		 	textGemachteFotos.setText("0");
		 	try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 	r.start();
		 	}
		 });
		btnAction.setBounds(10, 275, 92, 23);
		frmAlphaFocusStep.getContentPane().add(btnAction);
		btnAction.setEnabled(false);
		JButton btnBerechnen = new JButton("Berechnen");
		
		btnBerechnen.setBounds(10, 247, 92, 23);
		frmAlphaFocusStep.getContentPane().add(btnBerechnen);
		
		textGemachteFotos = new JTextField();
		textGemachteFotos.setBounds(456, 213, 86, 20);
		frmAlphaFocusStep.getContentPane().add(textGemachteFotos);
		textGemachteFotos.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Gemachte Fotos");
		lblNewLabel_7.setBounds(332, 216, 111, 14);
		frmAlphaFocusStep.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("verbliebene zeit");
		lblNewLabel_7_1.setBounds(332, 279, 111, 14);
		frmAlphaFocusStep.getContentPane().add(lblNewLabel_7_1);
		
		textVerbliebeneZeit = new JTextField();
		textVerbliebeneZeit.setColumns(10);
		textVerbliebeneZeit.setBounds(456, 276, 86, 20);
		frmAlphaFocusStep.getContentPane().add(textVerbliebeneZeit);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 552, 22);
		frmAlphaFocusStep.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JButton btnNewButton = new JButton("New button");
		mnNewMenu.add(btnNewButton);
		
		rdbtnVtoH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnHtoV.setSelected(false);
				rdbtnVtoH.setSelected(true);
			}
		});
		rdbtnHtoV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnVtoH.setSelected(false);
				rdbtnHtoV.setSelected(true);
			}
		});
		
		btnBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String regex = "[0-9]+";
				boolean err=false;

				if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/8000")) {
					nanosekBel=125000;
					millisekBel=0;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/6400")) {
					nanosekBel=156250;
					millisekBel=0;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/5000")) {
					nanosekBel=200000;
					millisekBel=0;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/4000")) {
					nanosekBel=250000;
					millisekBel=0;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/3200")) {
					nanosekBel=312500;
					millisekBel=0;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/2500")) {
					nanosekBel=400000;
					millisekBel=0;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/2000")) {
					nanosekBel=500000;
					millisekBel=0;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/1600")) {
					nanosekBel=625000;
					millisekBel=0;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/1250")) {
					nanosekBel=800000;
					millisekBel=0;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/1000")) {
					nanosekBel=0;
					millisekBel=1;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/800")) {
					nanosekBel=250000;
					millisekBel=1;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/640")) {
					nanosekBel=562500;
					millisekBel=1;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/500")) {
					nanosekBel=0;
					millisekBel=2;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/400")) {
					nanosekBel=500000;
					millisekBel=2;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/320")) {
					nanosekBel=125000;
					millisekBel=3;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/250")) {
					nanosekBel=0;
					millisekBel=4;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/200")) {
					nanosekBel=0;
					millisekBel=5;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/160")) {
					nanosekBel=250000;
					millisekBel=6;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/125")) {
					nanosekBel=0;
					millisekBel=8;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/100")) {
					nanosekBel=0;
					millisekBel=10;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/80")) {
					nanosekBel=0;
					millisekBel=13;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/60")) {
					nanosekBel=0;
					millisekBel=17;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/50")) {
					nanosekBel=0;
					millisekBel=20;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/40")) {
					nanosekBel=0;
					millisekBel=25;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/30")) {
					nanosekBel=0;
					millisekBel=34;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/25")) {
					nanosekBel=0;
					millisekBel=40;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/20")) {
					nanosekBel=0;
					millisekBel=50;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/15")) {
					nanosekBel=0;
					millisekBel=67;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/13")) {
					nanosekBel=0;
					millisekBel=77;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/10")) {
					nanosekBel=0;
					millisekBel=100;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/8")) {
					nanosekBel=0;
					millisekBel=125;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/6")) {
					nanosekBel=0;
					millisekBel=167;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/5")) {
					nanosekBel=0;
					millisekBel=200;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/4")) {
					nanosekBel=0;
					millisekBel=250;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1/3")) {
					nanosekBel=0;
					millisekBel=334;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("0.4\"")) {
					nanosekBel=0;
					millisekBel=400;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("0.5\"")) {
					nanosekBel=0;
					millisekBel=500;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("0.6\"")) {
					nanosekBel=0;
					millisekBel=600;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("0.8\"")) {
					nanosekBel=0;
					millisekBel=800;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1\"")) {
					nanosekBel=0;
					millisekBel=1000;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1.3\"")) {
					nanosekBel=0;
					millisekBel=1300;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("1.6\"")) {
					nanosekBel=0;
					millisekBel=1600;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("2\"")) {
					nanosekBel=0;
					millisekBel=2000;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("2.5\"")) {
					nanosekBel=0;
					millisekBel=2500;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("3.2\"")) {
					nanosekBel=0;
					millisekBel=3200;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("4\"")) {
					nanosekBel=0;
					millisekBel=4000;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("5\"")) {
					nanosekBel=0;
					millisekBel=400;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("6\"")) {
					nanosekBel=0;
					millisekBel=6000;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("8\"")) {
					nanosekBel=0;
					millisekBel=8000;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("10\"")) {
					nanosekBel=0;
					millisekBel=10000;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("13\"")) {
					nanosekBel=0;
					millisekBel=13000;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("15\"")) {
					nanosekBel=0;
					millisekBel=15000;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("20\"")) {
					nanosekBel=0;
					millisekBel=25000;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("25\"")) {
					nanosekBel=0;
					millisekBel=400;
				} else if(comboBoxBelichtung.getSelectedItem().toString().contentEquals("30\"")) {
					nanosekBel=0;
					millisekBel=30000;
				} else {
					JOptionPane.showMessageDialog (frmAlphaFocusStep, "Something went Wrong", "Title", JOptionPane.ERROR_MESSAGE);
				}
				if(textFdylay.getText().length()<1 || !textFdylay.getText().matches(regex) || Integer.parseInt(textFdylay.getText())>21000000) {
					JOptionPane.showMessageDialog (frmAlphaFocusStep, "Something went Wrong", "Title", JOptionPane.ERROR_MESSAGE);
					err=true;
				}
				if(err || textFotoCount.getText().length()<1 || !textFotoCount.getText().matches(regex) || Integer.parseInt(textFotoCount.getText())>21000000) {
					JOptionPane.showMessageDialog (frmAlphaFocusStep, "Something went Wrong", "Title", JOptionPane.ERROR_MESSAGE);
				}
				if(err || textKeyDelay.getText().length()<1 || !textKeyDelay.getText().matches(regex) || Integer.parseInt(textKeyDelay.getText())>21000000) {
					JOptionPane.showMessageDialog (frmAlphaFocusStep, "Something went Wrong", "Title", JOptionPane.ERROR_MESSAGE);
				}
				if(!err) {
				Long delayNS=(nanosekBel*Long.parseLong(textFotoCount.getText()));
					long durationInMs = TimeUnit.MILLISECONDS.convert(delayNS, TimeUnit.NANOSECONDS);
					durationInMs=durationInMs+(Long.parseLong(textFdylay.getText())*Long.parseLong(textFotoCount.getText()));
					if(durationInMs<1000) {
					textschäzungZeit.setText(String.valueOf(durationInMs)+" ms");
					} else if(TimeUnit.SECONDS.convert(durationInMs, TimeUnit.MILLISECONDS)<60) {
						 durationInMs = TimeUnit.SECONDS.convert(durationInMs, TimeUnit.MILLISECONDS);
						textschäzungZeit.setText(String.valueOf(durationInMs)+" sek");
					} else if(TimeUnit.MINUTES.convert(durationInMs, TimeUnit.MILLISECONDS)>=1) {
						textschäzungZeit.setText(String.valueOf(TimeUnit.MINUTES.convert(durationInMs, TimeUnit.MILLISECONDS))+" min");
					}
					textVerbliebeneZeit.setText("0");
					textGemachteFotos.setText("0");
					btnAction.setEnabled(true);
				}
				err=false;
			}
		});
		
	}
}
