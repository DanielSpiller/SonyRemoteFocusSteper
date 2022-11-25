package GUI;

import java.awt.AWTException;
import java.awt.KeyboardFocusManager;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Job implements Runnable {

	private int anzFotos, mskeys, msFotos, focusStep, belichtungnano,  belichtungnmilli;
	private Boolean vtoh;
	
	Job(int anzFotos, int mskeys, int msFotos, int focusStep, int belichtungnano, int belichtungnmilli, Boolean vtoh) {
		this.anzFotos = anzFotos;
		this.mskeys = mskeys;
		this.msFotos = msFotos;
		this.focusStep = focusStep;
		this.belichtungnano = belichtungnano;
		this.belichtungnmilli=belichtungnmilli;
		this.vtoh=vtoh;
	}

	public void run() {
		try {

//			
//			Runtime.getRuntime().exec("notepad");
//			 
			Robot robot;

			robot = new Robot();
			
			for (int f = 0; f < anzFotos; f++) {

				System.out.println("press " + KeyEvent.VK_NUMPAD1);
				robot.keyPress(KeyEvent.VK_NUMPAD1);
				robot.delay(200);
				robot.keyRelease(KeyEvent.VK_NUMPAD1);
				try {
					Thread.sleep(belichtungnmilli, belichtungnano);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ui.getInstance().fotop();
				try {
					Thread.sleep(mskeys);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(vtoh) {
					if(focusStep==1) {
						System.out.println("press " + KeyEvent.VK_R);
						robot.keyPress(KeyEvent.VK_R);
						robot.delay(200);
						robot.keyRelease(KeyEvent.VK_R);
					} else if(focusStep==2) {
						System.out.println("press " + KeyEvent.VK_T);
						robot.keyPress(KeyEvent.VK_T);
						robot.delay(200);
						robot.keyRelease(KeyEvent.VK_T);
					} else if(focusStep==3) {
						System.out.println("press " + KeyEvent.VK_Y);
						robot.keyPress(KeyEvent.VK_Y);
						robot.delay(200);
						robot.keyRelease(KeyEvent.VK_Y);
					}
				} else {
					if(focusStep==1) {
						System.out.println("press " + KeyEvent.VK_E);
						robot.keyPress(KeyEvent.VK_E);
						robot.delay(200);
						robot.keyRelease(KeyEvent.VK_E);
					} else if(focusStep==2) {
						System.out.println("press " + KeyEvent.VK_W);
						robot.keyPress(KeyEvent.VK_W);
						robot.delay(200);
						robot.keyRelease(KeyEvent.VK_W);
					} else if(focusStep==3) {
						System.out.println("press " + KeyEvent.VK_Q);
						robot.keyPress(KeyEvent.VK_Q);
						robot.delay(200);
						robot.keyRelease(KeyEvent.VK_Q);
					}
				}
				try {
					Thread.sleep(msFotos);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			JOptionPane.showMessageDialog (null, "die aufnahmen sind abgeschlossen", "Title", JOptionPane.INFORMATION_MESSAGE);
			 
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
