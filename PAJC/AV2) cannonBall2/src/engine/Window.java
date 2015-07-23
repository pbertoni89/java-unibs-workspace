package engine;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * <p>
 * Title: Window
 * </p>
 * 
 * <p>
 * Description: Questa classe rappresenta l'applet che gestisce il Canvas Landscape e il Panel di controllo.
 * </p>
 *
 * <p>
 * Copyright: Pillars of Software 2010
 * </p>
 * 
 * <p>
 * Company: Pillars of Software
 * </p>
 * 
 * @author Patrizio Bertoni
 * @version 0.1
 */


public class Window extends Applet implements MouseListener, KeyListener {
	
	final static long serialVersionUID = 7;
	
	public final static int altezzaLandscape = 350;
	public final static int larghezzaWindow = 700;
	final static int altezzaPanel = 25;

	Panel control;
	Dimension dimControlPanel;
	Landscape world;
	static JFrame messages;
	
	Label cannonball, author, blank, powerLabel, angleLabel, powerValue, angleValue;
	Button powerDown, powerUp, angleDown, angleUp, boom, reset;
	
	final static int powerDefault = 50; static int power;
	final static int angleDefault = 45; static int angle;
	
	public void init() { 
		
		power = powerDefault;
		angle = angleDefault;
		
		world = new Landscape();
		
		setLayout( new FlowLayout() );
		dimControlPanel = new Dimension( larghezzaWindow, altezzaPanel );
	
		control = new Panel();
		control.setBounds(0, 0, larghezzaWindow, altezzaPanel);
		control.setLayout(new FlowLayout());
		control.setBackground( Color.RED);

		cannonball = new Label("CannonBall!");
		cannonball.setBackground( Color.RED );
		cannonball.setForeground( Color.YELLOW );
		control.add(cannonball);
		
		blank = new Label("   ");
		blank.setBackground( Color.RED );
		control.add(blank);

		powerLabel = new Label("POWER");
		control.add(powerLabel);
		
		powerValue = new Label( new Integer(powerDefault).toString() );
		powerValue.setBackground(Color.WHITE);
		control.add(powerValue);
		
		powerDown = new Button("-");
		control.add(powerDown);
		
		powerUp = new Button("+");
		control.add(powerUp);
		
		blank = new Label("   ");
		blank.setBackground( Color.RED );
		control.add(blank);
			
		angleLabel = new Label("ANGLE");
		control.add(angleLabel);
		
		angleValue = new Label( new Integer(angleDefault).toString() );
		angleValue.setBackground(Color.WHITE);
		control.add(angleValue);
		
		angleDown = new Button("-");
		control.add(angleDown);
		
		angleUp = new Button("+");
		control.add(angleUp);
		
		blank = new Label("  ");
		blank.setBackground( Color.RED );
		control.add(blank);
		
		boom = new Button("BOOM!");
		control.add(boom);
		
		reset = new Button("RESET");
		control.add(reset);
		
		blank = new Label("   ");
		blank.setBackground( Color.RED );
		control.add(blank);
		
		author = new Label("Patrizio Bertoni");
		author.setBackground( Color.RED );
		author.setForeground( Color.YELLOW );
		control.add(author);
	
		powerDown.addMouseListener(this); powerDown.addKeyListener(this);
		powerUp.addMouseListener(this);   powerUp.addKeyListener(this);
		angleDown.addMouseListener(this);  angleDown.addKeyListener(this);
		angleUp.addMouseListener(this);  angleUp.addKeyListener(this);
		boom.addMouseListener(this);  boom.addKeyListener(this);
		reset.addMouseListener(this); reset.addKeyListener(this);
		
	}
	
	public void start() {
		
		prepareMessages();
		this.add(control); 
		this.add(world);
	}

	public static int getPower() {
		return power;
	}
	
	public static int getAngle() {
		return angle;
	}
	
	public void resetEvent() {  
		
		power = powerDefault;
		powerValue.setText( new Integer(powerDefault).toString() );
		angle = angleDefault;
		angleValue.setText( new Integer(angleDefault).toString() );
		
		world.reset();
	}
	
	public void prepareMessages() {
		
		messages = null;
		messages = new JFrame("test dei messaggi");
	    messages.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    messages.setBounds(50,50,250,150);
	    messages.setContentPane(new JDesktopPane());
	}
	
	/** Apre un frame informativo indipendente dall'applet, mostrando una determinata stringa.
	 * 
	 * @param text  Il messaggio
	 * @param title  Il titolo del frame
	 */
	public static void msgBox(String text, String title) {
		
		JOptionPane.showMessageDialog(messages, text, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	/** @method Interazioni da mouse.
	 * 	@param  un evento mouse ben determinato.
	 */
	public void mouseClicked(MouseEvent src) {
		
		boolean changed = false;
		
		if (src.getSource() == powerDown) {
				
				if(power>1) {  //non è consentita potenza nulla
					power--; changed=true;
					powerValue.setText( new Integer(power).toString() );
				}
			}
		else
		
			if (src.getSource() == powerUp) {
				
				if(power<100) {
					power++; changed=true;
					powerValue.setText( new Integer(power).toString() );
				}
			}
			else
				
				if (src.getSource() == angleDown) {  //non è consentito alzo di zero gradi
					
					if(angle>1) {
						angle--; changed=true;
						angleValue.setText( new Integer(angle).toString() );
					}
				}
				else
				
					if (src.getSource() == angleUp) {
						
						if(angle<89) {  //non è consentito alzo di novanta gradi
							angle++; changed=true;
							angleValue.setText( new Integer(angle).toString() );
						}
					}
					else
						
						if (src.getSource() == boom) {
							// mostra traiettoria? NO
							world.boom();
							 
						}
						else 
							
							if (src.getSource() == reset) {
								changed=true;
								resetEvent();
							}
		if(changed)
				world.repaint();
	}

	/** @method Interazioni da tastiera.
	 * 	@param  un evento tastiera ben determinato.
	 */
	public void keyPressed(KeyEvent src) {   
		
		boolean changed = false;
		
		if (src.getKeyCode() == KeyEvent.VK_DOWN) {
			
			if(power>1) {  //non è consentita potenza nulla
				power--; changed=true;
				powerValue.setText( new Integer(power).toString() );
			}
		}
		else
		
			if (src.getKeyCode() == KeyEvent.VK_UP) {
				
				if(power<100) {  //non è consentita potenza nulla
					power++; changed=true;
					powerValue.setText( new Integer(power).toString() );
				}
			}
			else
				
				if (src.getKeyCode() == KeyEvent.VK_RIGHT) {
					
					if(angle>1) {  //non è consentita angolo nullo
						angle--; changed=true;
						angleValue.setText( new Integer(angle).toString() );
					}
				}
				else
				
					if (src.getKeyCode() == KeyEvent.VK_LEFT) {
						
						if(angle<89) {  //non è consentita angolo nullo
							angle++; changed=true;
							angleValue.setText( new Integer(angle).toString() );
						}
					}
					else
						
						if (src.getKeyCode() == KeyEvent.VK_ENTER) {
							// mostra traiettoria? NO
							world.boom();
						}
						else 
							
							if (src.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
								changed=true;
								resetEvent();
							}
		if(changed)
				world.repaint();
		
	}

	/* unuseful overridings  */
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	public void keyTyped(KeyEvent src) {}
	public void keyReleased(KeyEvent arg0) {}
}
