package HealthFreak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * mainGui class meant display a user interface
 */
public class mainGui {
	static Container cp;
	static JFrame  f;
	private static String[] conditions = Constants.conditions;
	static City[] cities = new City[City.objArray.length];
	/**
	 * Method used to read the file first then display the UI
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Main.main(null); // initailize arrays in Main
		cities = Main.cities;
		
		
		f = new Frame("Health Freak", true); // open new window
		cp = f.getContentPane();
		cp.add(new MainMenu()); // show main menu
        f.show();
        f.setVisible(true);
	}
	/**
	 * Method used to get string representation of conditions index
	 * @param cond - condtions array
	 * @return s - string value of conditions
	 */
	public static String toString(int[]cond){
		String s="";
		for (int i =0; i<13; i++)
		{
				s = s +conditions[i]+ ": "+ cond[i]+ "\n";
				System.out.println(s);
		}
		return s;
	}
	/**
	 * Method used to get conditions
	 * @return conditions
	 */
	public static String [] getCond(){
		return conditions;
	}
	/**
	 * Method used to get cities
	 * @return city name
	 */
	public static String [] getCities(){
		String [] s = new String [cities.length]; 
		for (int i = 0; i < cities.length; i++)
		{
			s[i] = cities[i].getCity();
		}
		return s;
	}
	/**
	 * Method used to switch between UI seletions
	 * @param integer value of selected UI element
	 */
	public static void paneSwitch(int i){
		switch (i) {
	    case 0:
	    	f.getContentPane().removeAll();
	    	f.getContentPane().add(new MainMenu()); // loads main menu

	    	break;
	    case 1:
	    	f.getContentPane().removeAll();
	    	f.getContentPane().add(new SearchPanel()); // loads search panel

	        break;
	    case 2:
	    	f.getContentPane().removeAll();
	    	f.getContentPane().add(new SortPanel()); // loads sort panel

	        break;
	    case 3:
	    	f.getContentPane().removeAll();
	    	f.getContentPane().add(new GraphPanel()); // loads graph panel

	        break;
		}
        f.getContentPane().validate();
        f.getContentPane().repaint();
	}
}
/**
 * Class used open custom windows
 */
class Frame extends JFrame {
	/**
	 * Method used open custom windows
	 * @param name - name of window
	 * @param close - weather to exit program on close
	 */
	  public Frame(String name, Boolean close) {
		setTitle(name);
		setSize(800,800); //set size
		setLocation(10,10); //set topleft corner
		addWindowListener(new WindowAdapter() { //program closer on exit
		  	public void windowClosing(WindowEvent e) {
		  		if (close){
		  			System.exit(0);
		  		}
		  	}
		} );
	  }
}
/**
 * Class used to display main menu class
 */
class MainMenu extends JPanel {
	Font [] fs;
	JButton searchB;
	JButton sortB;
	JButton graphB;
	JButton backB;
	JLabel menuL;
	JTextArea tA;
	/**
	 * Method used open main menu in current window
	 */
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
			  
			  // UI elements to load in view
			  add(menuL, BorderLayout.PAGE_START);
			  add(searchB, BorderLayout.LINE_START);
			  add(sortB, BorderLayout.CENTER);
			  add(graphB, BorderLayout.LINE_END);
			  add(backB, BorderLayout.PAGE_END);
			  
			  // listens to buttons pressed
			  searchB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			          mainGui.paneSwitch(1);
			      }
			  });
			  sortB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			          mainGui.paneSwitch(2);
			      }
			  });
			  graphB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			          mainGui.paneSwitch(3);
			      }
			  });
			  backB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			          mainGui.paneSwitch(0);
			      }
			  });
		  }
}
/**
 * Class to load Search panel in existing window
 */
class SearchPanel extends JPanel {
	private static String[] conditions = new String[]{"ACCESS2","ARTHRITIS","BINGE","BPHIGH","BPMED","CANCER","CASTHMA","CHD","CSMOKING","DIABETES","HIGHCHOL","KIDNEY","OBESITY"};

	Font [] fs;
	JButton enterSB;
	JButton backB;
	JLabel menuL;
	JTextField tF;
	JTextArea tA;
	/**
	 * Method used open search panel
	 */
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
			  //tA.setPreferredSize(new Dimension( 200, 24 ));
			  tA.setEditable(false);
			  tA.setLineWrap(true);
			  
			  // loads UI elements in view
			  add(menuL, BorderLayout.PAGE_START);
			  add(tF, BorderLayout.LINE_START);
			  add(enterSB, BorderLayout.CENTER);	  
			  add(tA, BorderLayout.LINE_END);
			  add(backB, BorderLayout.PAGE_END);
			  enterSB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e) // if search is clicked
			      {
			    	  tA.setText("Loading...");
			    	  City city = Search.search(Main.cities, tF.getText()); // search the city by name
			    	  
			    	  if (city == null){
			    		  tA.setText("Couldn't find city!");
			    	  }
			    	  else{
			    		  tA.setText(mainGui.toString(city.getCond()));
			    	  }
			      }
			  });
			  backB.addActionListener( new ActionListener() // if back is clicked
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			          mainGui.paneSwitch(0); // go back to main menu
			      }
			  });
		  }
}
/**
 * Class used to display sort panel in existing window
 */
class SortPanel extends JPanel {
	Font [] fs;
	JButton enterCondB;
	JButton enterCityB;
	JButton backB;
	JLabel menuL;
	JComboBox dropDownCond;
	JComboBox dropDownCity;	
	JTextArea tA;
	/**
	 * Method used open sort panel
	 */
		  public SortPanel() {
			  fs = new Font [3];
			  fs[0]  = new Font("Lato", Font.BOLD, 36);
			  fs[1]  = new Font("Open Sans", 0 , 20);
			  fs[2]  = new Font("Open Sans", 0 , 12);
			  enterCondB = new JButton("Sort Cities");
			  enterCityB = new JButton("Sort Conditions");
			  backB = new JButton("Return");
			  menuL = new JLabel ("Sort Feature");
			  String [] cond = new String [8];
			  dropDownCond = new JComboBox<String> (mainGui.getCond());
			  dropDownCity = new JComboBox<String> (mainGui.getCities());
			  tA = new JTextArea ();
			  enterCondB.setFont(fs[1]);
			  enterCityB.setFont(fs[1]);
			  backB.setFont(fs[2]);
			  menuL.setFont(fs[0]);
			  dropDownCond.setPreferredSize(new Dimension( 200, 24 ));
			  dropDownCity.setPreferredSize(new Dimension( 200, 24 ));
			  tA.setEditable(false);
			  
			  // loads UI elements in view
			  add(menuL, BorderLayout.PAGE_START);
			  add(dropDownCond, BorderLayout.LINE_START);
			  add(enterCondB, BorderLayout.CENTER);
			  add(dropDownCity, BorderLayout.LINE_START);
			  add(enterCityB, BorderLayout.CENTER);	  
			  add(tA, BorderLayout.LINE_END);
			  add(backB, BorderLayout.PAGE_END);
			  //listens to sort by cond button to be pressed
			  enterCondB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			    	  City[] c = mainGui.cities;
			    	  int n =  dropDownCond.getSelectedIndex();
			    	  Heapsort.sortHeap(c, c.length, n);
			    	  for(int i = 0; i < c.length / 2; i++)
			    	  {
			    	      City temp = c[i];
			    	      c[i] = c[c.length - i - 1];
			    	      c[c.length - i - 1] = temp;
			    	  }
			    	  tA.setText("Cities sorted by occurence of "+dropDownCond.getSelectedItem().toString()+":");
			    	  for (int i = 0; i < c.length; i++)
			    		  tA.append("\n"+c[i].getCity()+ ", "+c[i].getCond(n));
			      }
			  });
			  //listens to sort by city button to be pressed
			  enterCityB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			    	  String [] s = mainGui.getCond();
			    	  int [] cond = mainGui.cities[dropDownCity.getSelectedIndex()].getCond();
			  		  System.out.println(s.length+", "+cond.length);
			    	  Heapsort2.sortHeap(s, cond, cond.length);
			    	  for(int i = 0; i < s.length / 2; i++)
			    	  {
			    	      String temp = s[i];
			    	      s[i] = s[s.length - i - 1];
			    	      s[s.length - i - 1] = temp;
			    	      int t = cond[i];
			    	      cond[i] = cond[cond.length - i - 1];
			    	      cond[cond.length - i - 1] = t;
			    	  }
			    	  tA.setText("Conditions sorted by occurence in "+dropDownCity.getSelectedItem().toString()+":");
			    	  for (int i = 0; i < s.length; i++)
			    		  tA.append("\n"+s[i]+ ", " +cond[i]);
			      }
			  });
			  //listens to back button to be pressed
			  backB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			          //System.out.println("backB clicked");
			          mainGui.paneSwitch(0);
			      }
			  });
		  }
}

/**
 * Class used to display graph panel in existing window
 */
class GraphPanel extends JPanel {
	
	Font [] fs;
	JButton enterSB;
	JButton backB;
	JTextField tF;
	JComboBox dropDownCond;
	JLabel menuL;
	static Container cp;
	JTextArea tA;
	/**
	 * Method used to display graph panel in existing window
	 */
		  public GraphPanel() {
			  fs = new Font [3];
			  fs[0]  = new Font("Lato", Font.BOLD, 36);
			  fs[1]  = new Font("Open Sans", 0 , 20);
			  fs[2]  = new Font("Open Sans", 0 , 12);
			  enterSB = new JButton("Graph");
			  backB = new JButton("Return");
			  dropDownCond = new JComboBox<String> (mainGui.getCond());
			  menuL = new JLabel ("Graph Feature");
			  tA = new JTextArea ("");
			  tF = new JTextField ();
			  backB.setFont(fs[2]);
			  menuL.setFont(fs[0]);
			  enterSB.setFont(fs[1]);
			  dropDownCond.setPreferredSize(new Dimension( 200, 24 ));
			  tF.setPreferredSize(new Dimension( 200, 24 ));
			  tA.setPreferredSize(new Dimension(200, 100 ));
			  tA.setEditable(false);
			  
			  //loads UI elements in view
			  add(menuL, BorderLayout.PAGE_START);
			  add(dropDownCond, BorderLayout.LINE_START);
			  add(backB, BorderLayout.PAGE_END);
			  add(enterSB, BorderLayout.CENTER);	
			  enterSB.addActionListener( new ActionListener() // if graph button is pressed
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			    	Graph graph = new Graph();
					graph.connectedTo(Main.cities, dropDownCond.getSelectedItem().toString());
			    	JFrame f = new Frame(dropDownCond.getSelectedItem().toString(), false);
					cp = f.getContentPane();
					cp.setBounds(50, 50, 1000, 1000);
					cp.add(new drawGraph(graph.getGraph(), Main.cities));
			        f.show();
			        f.setVisible(true);
			    		
			      }
			  });
			  backB.addActionListener( new ActionListener() // if back button is pressed
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			          //System.out.println("backB clicked");
			          mainGui.paneSwitch(0);
			      }
			  });
		  }
}