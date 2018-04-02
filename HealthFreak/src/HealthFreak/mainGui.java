package HealthFreak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Arrays;
public class mainGui {
	static Container cp;
	static JFrame  f;
	private static String[] conditions = new String[]{"ACCESS2","ARTHRITIS","BINGE","BPHIGH","BPMED","CANCER","CASTHMA","CHD","CSMOKING","DIABETES","HIGHCHOL","KIDNEY","OBESITY"};
	static City[] cities = new City[City.objArray.length];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Main.main(null);
		
		
		
		f = new Frame();
		cp = f.getContentPane();
		cp.add(new MainMenu());
        f.show();
        f.setVisible(true);
	}
	
	
	public static int findCity(City[] cities, String city){
		for (int i =0; i<cities.length; i++){
			
			if (cities[i] == null){
				return i;
			}
			else if(city.equals(cities[i].getCity())){
				return i;
			}
		}
		return -1;
	}
	
	
	public static void paneSwitch(int i){
		switch (i) {
	    case 0:
	    	f.getContentPane().removeAll();
	    	f.getContentPane().add(new MainMenu());

	    	break;
	    case 1:
	    	f.getContentPane().removeAll();
	    	f.getContentPane().add(new SearchPanel());

	        break;
	    case 2:
	    	f.getContentPane().removeAll();
	    	f.getContentPane().add(new SortPanel());

	        break;
	    case 3:
	    	f.getContentPane().removeAll();
	    	f.getContentPane().add(new GraphPanel());

	        break;
		}
        f.getContentPane().validate();
        f.getContentPane().repaint();
	}
}
class Frame extends JFrame {
	  public Frame() {
		setTitle("Health Freak");
		setSize(310,200); //set size
		setLocation(10,10); //set topleft corner
		addWindowListener(new WindowAdapter() { //program closer on exit
		  	public void windowClosing(WindowEvent e) {
			   System.exit(0);
		  	}
		} );
	  }
}
class MainMenu extends JPanel {
	Font [] fs;
	JButton searchB;
	JButton sortB;
	JButton graphB;
	JButton backB;
	JLabel menuL;
	JTextArea tA;
		  public MainMenu() {
			  fs = new Font [3];
			  fs[0]  = new Font("Lato", Font.BOLD, 36);
			  fs[1]  = new Font("Open Sans", 0 , 20);
			  fs[2]  = new Font("Open Sans", 0 , 12);
			  searchB = new JButton("Search");
			  sortB = new JButton("Sort");
			  graphB = new JButton("Graph");
			  backB = new JButton("Return");
			  menuL = new JLabel ("Main Menu");
			  tA = new JTextArea ();
			  searchB.setFont(fs[1]);
			  sortB.setFont(fs[1]);
			  graphB.setFont(fs[1]);
			  backB.setFont(fs[2]);
			  menuL.setFont(fs[0]);
			  backB.setVisible(false);
			  add(menuL, BorderLayout.PAGE_START);
			  add(searchB, BorderLayout.LINE_START);
			  add(sortB, BorderLayout.CENTER);
			  add(graphB, BorderLayout.LINE_END);
			  add(backB, BorderLayout.PAGE_END);
			  searchB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			          System.out.println("searchB clicked");
			          mainGui.paneSwitch(1);
			      }
			  });
			  sortB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			          System.out.println("sortB clicked");
			          mainGui.paneSwitch(2);
			      }
			  });
			  graphB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			          System.out.println("graphhB clicked");
			          mainGui.paneSwitch(3);
			      }
			  });
			  backB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			          System.out.println("backB clicked");
			          mainGui.paneSwitch(0);
			      }
			  });
		  }
}
class SearchPanel extends JPanel {
	Font [] fs;
	JButton enterSB;
	JButton backB;
	JLabel menuL;
	JTextField tF;
	JTextArea tA;
		  public SearchPanel() {
			  fs = new Font [3];
			  fs[0]  = new Font("Lato", Font.BOLD, 36);
			  fs[1]  = new Font("Open Sans", 0 , 20);
			  fs[2]  = new Font("Open Sans", 0 , 12);
			  enterSB = new JButton("Search");
			  backB = new JButton("Return");
			  menuL = new JLabel ("Search Feature");
			  tF = new JTextField ();
			  tA = new JTextArea ();
			  enterSB.setFont(fs[1]);
			  backB.setFont(fs[2]);
			  menuL.setFont(fs[0]);
			  tF.setPreferredSize(new Dimension( 200, 24 ));
			  tA.setPreferredSize(new Dimension( 200, 24 ));
			  tA.setEditable(false);
			  add(menuL, BorderLayout.PAGE_START);
			  add(tF, BorderLayout.LINE_START);
			  add(enterSB, BorderLayout.CENTER);	  
			  add(tA, BorderLayout.LINE_END);
			  add(backB, BorderLayout.PAGE_END);
			  enterSB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			    	  //System.out.println(Search.search(Main.cities, "Alabama").getCity());
			    	  City city = Search.search(Main.cities, tF.getText());
			    	  if (city == null){
			    		  tA.setText("Couldn't find city!");
			    	  }
			    	  else{
			    		  tA.setText(city.getCity());
			    	  }
			      }
			  });
			  backB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			          System.out.println("backB clicked");
			          mainGui.paneSwitch(0);
			      }
			  });
		  }
}
class SortPanel extends JPanel {
	Font [] fs;
	JButton enterSB;
	JButton backB;
	JLabel menuL;
	JComboBox dropDown;
	JTextArea tA;
		  public SortPanel() {
			  fs = new Font [3];
			  fs[0]  = new Font("Lato", Font.BOLD, 36);
			  fs[1]  = new Font("Open Sans", 0 , 20);
			  fs[2]  = new Font("Open Sans", 0 , 12);
			  enterSB = new JButton("Sort");
			  backB = new JButton("Return");
			  menuL = new JLabel ("Sort Feature");
			  String [] cond = new String [8];
			  for (int i = 0; i<8; i++)
				  cond[i] = "Condition "+(i+1);
			  dropDown = new JComboBox<String> (cond);
			  tA = new JTextArea ();
			  enterSB.setFont(fs[1]);
			  backB.setFont(fs[2]);
			  menuL.setFont(fs[0]);
			  dropDown.setPreferredSize(new Dimension( 200, 24 ));
			  tA.setPreferredSize(new Dimension( 200, 24 ));
			  tA.setEditable(false);
			  add(menuL, BorderLayout.PAGE_START);
			  add(dropDown, BorderLayout.LINE_START);
			  add(enterSB, BorderLayout.CENTER);	  
			  add(tA, BorderLayout.LINE_END);
			  add(backB, BorderLayout.PAGE_END);
			  enterSB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			          tA.setText(dropDown.getSelectedItem().toString());
			      }
			  });
			  backB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			          System.out.println("backB clicked");
			          mainGui.paneSwitch(0);
			      }
			  });
		  }
}
class GraphPanel extends JPanel {
	Font [] fs;
	JButton enterSB;
	JButton backB;
	JLabel menuL;
	JTextArea tA;
		  public GraphPanel() {
			  fs = new Font [3];
			  fs[0]  = new Font("Lato", Font.BOLD, 36);
			  fs[1]  = new Font("Open Sans", 0 , 20);
			  fs[2]  = new Font("Open Sans", 0 , 12);
			  enterSB = new JButton("Search");
			  backB = new JButton("Return");
			  menuL = new JLabel ("Graph Feature");
			  tA = new JTextArea ("");
			  backB.setFont(fs[2]);
			  menuL.setFont(fs[0]);
			  tA.setPreferredSize(new Dimension(200, 100 ));
			  tA.setEditable(false);
			  add(menuL, BorderLayout.PAGE_START);
			  add(tA, BorderLayout.CENTER);	  
			  add(backB, BorderLayout.PAGE_END);
			  backB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			          System.out.println("backB clicked");
			          mainGui.paneSwitch(0);
			      }
			  });
		  }
}