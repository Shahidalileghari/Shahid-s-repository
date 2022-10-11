import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Splash extends JFrame implements Runnable {
	
	       Thread t;
            public Splash() {
//				ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("src/elec.jpg"));
//				JLabel imageJLabel=new JLabel(i1);
//				add(imageJLabel);
            	
				int x=1;
				
            	for (int i = 2; i <600; i+=4,x+=1) {
					   
            		setSize(i+x,i);
                	setLocation(700-((i+x)/2),400-(i/2));
                	try {
						
						
						//new Login();
					} 
                	catch 
                	(Exception e) {
						JOptionPane.showMessageDialog(null, "Error");
					}
            		
				}
				//run();
            	
            	t=new Thread(this);
            	
            	t.start();
            	setVisible(true);
            	
            	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	           setTitle("Splash class");
			}
            public void run() {
				
            	try {
					Thread.sleep(3000);
					setVisible(false);
					new Login();
				} catch (Exception e) {
					e.printStackTrace();
				}
            	
			}
	public static void main(String[] args) {
		
		
		new Splash();
		
		
	          }
            }
