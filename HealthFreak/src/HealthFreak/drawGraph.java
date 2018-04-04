package HealthFreak;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.applet.Applet;    
public class drawGraph extends Applet
{
	
	private List<List<Integer>> g;
	City [] cities;
	public drawGraph(List<List<Integer>> g, City[] cities){
		this.g = g;
		this.cities = cities;
	}
	
	
	  public void paint (Graphics g)
	  {			                 // using drawRoundRect()
		  g.setColor(Color.GREEN);
		  g.drawString("Connected", 700, 700);
		  g.drawOval(700-10, 700-50, 90, 90);
		  g.setColor(Color.red);
		  g.drawString("Not", 620, 690);
		  g.drawString("Connected", 600, 700);
		  g.drawOval(600-10, 700-50, 90, 90);
		  int x = 100;
		  int y = 100;
		  Color color = Color.red;
		  for (int i =0; i<City.citiesCount; i++){
			  if (this.g.get(i).get(i) == 1){
				  color = Color.green;
			  }
			  else{
				  color = Color.red;
			  }
			  g.setColor(color);
			  g.drawString(cities[i].getCity(), x, y);
			  g.drawOval(x-10, y-50, 90, 90);
			  if (x > 500){
				  y += 100;
				  x = 0;
			  }
			  x+=100;
		  }
//	    g.drawRoundRect(40, 50, 90, 90, 200, 200);
//	    g.fillRoundRect(40, 160, 90, 90, 200, 200);
//				                 // using drawOval()
//	    g.drawOval(150, 50, 90, 90);
//	    g.fillOval(150, 160, 90, 90);
//				                // using drawArc()
//	    g.drawArc(270, 50, 90, 90, 0, 360);
//	    g.fillArc(270, 160, 90, 90, 0, 360);
	  }
}