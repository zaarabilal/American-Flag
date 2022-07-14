import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage; 
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener{

	
	private BufferedImage back; 
	private int key; 
	private Color square;
	private Color whitestripe;
	private Color redstripe;
	
	
	
	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		key =-1; 
		square= new Color (60, 59, 110);
	    whitestripe= new Color (255, 255, 255);
	    redstripe= new Color (178, 34, 52);
		
		
	}

	
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	public Polygon get_star(int x, int y) {
		Polygon star= new Polygon();
		star.addPoint(x, y);
		star.addPoint(x+4, y+9);
		star.addPoint(x+14, y+9);
		star.addPoint(x+6, y+15);
		star.addPoint(x+8, y+24);
		star.addPoint(x, y+19);
		star.addPoint(x-8, y+24);
		star.addPoint(x-6, y+15);
		star.addPoint(x-14, y+9);
		star.addPoint(x-4, y+9);
		
		return star;
	}
	

	
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
		
		//g2d.drawImage(background.getImage(), 0, 0, getSize().width, getSize().height, this);
		
		
		
		

			for(int a=1; a<13; a+=2) {
				System.out.println("a="+a);
				g2d.setColor(whitestripe);
				g2d.fillRect(0,45*a,800,45);
				
			
			}

				for(int j=0; j<7; j++) {
					System.out.println("j="+j);
					g2d.setColor(redstripe);
					g2d.fillRect(0,90*j,800,45);
					
				
				}
			
		
		
		
		g2d.setColor(square);
		g2d.fillRect(0, 0, 350, 315);
		
		for(int c=1;c<11; c++) {
			for(int d=0; d<5; d++) {
				System.out.println("c="+c);
				System.out.println("d="+d);
				g2d.setColor(whitestripe);
				g2d.fillPolygon(get_star(30*c,65*d));
				
			
			}
		}
		
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Times New Roman", Font.BOLD, 40));
		g2d.drawString("KEY"+ key, 450, 40);

		twoDgraph.drawImage(back, null, 0, 0);

	}

private void reset(){
	square= new Color (60, 59, 110);
    whitestripe= new Color (255, 255, 255);
    redstripe= new Color (178, 34, 52);
}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);
		
		if(key==16) {
			square= new Color(195,196,145);
			whitestripe= new Color(0,0,0);
			redstripe= new Color(77,221,203);
			
		}
		if(key==32) {
			reset();
		}
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
	
		
		
		
	}
	
	
	

	
}
