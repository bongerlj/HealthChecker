package HealthFreak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class mainGui {
	static Container cp;
	static JFrame  f;
	private static String[] conditions = new String[]{"ACCESS2","ARTHRITIS","BINGE","BPHIGH","BPMED","CANCER","CASTHMA","CHD","CSMOKING","DIABETES","HIGHCHOL","KIDNEY","OBESITY"};
	static City[] cities = new City[City.objArray.length];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Main.main(null);
		cities = Main.cities;
		
		
		f = new Frame("Health Freak", true);
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
	public static String toString(int[]cond){
		String s="";
		for (int i =0; i<13; i++)
		{
				s = s +conditions[i]+ ": "+ cond[i]+ "\n";
				System.out.println(s);
		}
		return s;
	}
	public static String [] getCond(){
		return conditions;
	}
	public static String [] getCities(){
		String [] s = new String [cities.length]; 
		for (int i = 0; i < cities.length; i++)
		{
			s[i] = cities[i].getCity();
		}
		return s;
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
			          //System.out.println("searchB clicked");
			          mainGui.paneSwitch(1);
			      }
			  });
			  sortB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			          //System.out.println("sortB clicked");
			          mainGui.paneSwitch(2);
			      }
			  });
			  graphB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			          //System.out.println("graphhB clicked");
			          mainGui.paneSwitch(3);
			      }
			  });
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
class SearchPanel extends JPanel {
	private static String[] conditions = new String[]{"ACCESS2","ARTHRITIS","BINGE","BPHIGH","BPMED","CANCER","CASTHMA","CHD","CSMOKING","DIABETES","HIGHCHOL","KIDNEY","OBESITY"};

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
			  //tA.setPreferredSize(new Dimension( 200, 24 ));
			  tA.setEditable(false);
			  tA.setLineWrap(true);
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
			    	  tA.setText("Loading...");
			    	  City city = Search.search(Main.cities, tF.getText());
			    	  
			    	  if (city == null){
			    		  tA.setText("Couldn't find city!");
			    	  }
			    	  else{
			    		  tA.setText(mainGui.toString(city.getCond()));
			    	  }
			      }
			  });
			  backB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			         // System.out.println("backB clicked");
			          mainGui.paneSwitch(0);
			      }
			  });
		  }
}
class SortPanel extends JPanel {
	Font [] fs;
	JButton enterCondB;
	JButton enterCityB;
	JButton backB;
	JLabel menuL;
	JComboBox dropDownCond;
	JComboBox dropDownCity;	
	JTextArea tA;
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
			  add(menuL, BorderLayout.PAGE_START);
			  add(dropDownCond, BorderLayout.LINE_START);
			  add(enterCondB, BorderLayout.CENTER);
			  add(dropDownCity, BorderLayout.LINE_START);
			  add(enterCityB, BorderLayout.CENTER);	  
			  add(tA, BorderLayout.LINE_END);
			  add(backB, BorderLayout.PAGE_END);
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
class GraphPanel extends JPanel {
	
	Font [] fs;
	JButton enterSB;
	JButton backB;
	JTextField tF;
	JComboBox dropDownCond;
	JLabel menuL;
	static Container cp;
	JTextArea tA;
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
			  add(menuL, BorderLayout.PAGE_START);
			  add(dropDownCond, BorderLayout.LINE_START);
			  //add(tA, BorderLayout.CENTER);	  
			  add(backB, BorderLayout.PAGE_END);
			  add(enterSB, BorderLayout.CENTER);	
			  enterSB.addActionListener( new ActionListener()
			  {
			      @Override
			      public void actionPerformed(ActionEvent e)
			      {
			    	Graph graph = new Graph();
					graph.connectedTo(Main.cities, dropDownCond.getSelectedItem().toString());
					//System.out.println(graph.getGraph());
			    	JFrame f = new Frame(dropDownCond.getSelectedItem().toString(), false);
					cp = f.getContentPane();
					cp.setBounds(50, 50, 1000, 1000);
					cp.add(new drawGraph(graph.getGraph(), Main.cities));
			        f.show();
			        f.setVisible(true);
			    		
			      }
			  });
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