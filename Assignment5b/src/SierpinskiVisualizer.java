// Alan Birmaher
// 4/16/13
// COP 3330-001
// Purpose: To print out a Sierpinski triangle the way the user 
// defines through GUI settings and such.

//Imports
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//Public class
public class SierpinskiVisualizer implements ActionListener, KeyListener {
	
//This is a static value to be used for dimensions of our canvas
private static final int SIZE = 512; // should be a power of 2
	
	// GUI components
	private JFrame frame;
	private Canvas canvas;
	private Graphics graphics;
	private JTextField recDepthTextField;
	private JCheckBox randomizeCheckBox;

	//Storage of color info
	JLabel nameColors[]= new JLabel[5];
	JComboBox realColors[]= new JComboBox[5];
	Color choice[]= new Color[0];

	// Array of all possible color choices
	String colors[]={
			"Dark Gray",
			"Gray",
			"Light Gray",
			"White",
			"Red",
			"Orange",
			"Yellow",
			"Green",
			"Cyan",
			"Blue",
			"Magenta",
			"Pink",		
	};
	
	//Sets up panels for use later in the code
	final JPanel userPanel= new JPanel();
	final JPanel textField= new JPanel();
	final JPanel comboBox1= new JPanel();
	final JPanel comboBox2= new JPanel();
	final JPanel comboBox3= new JPanel();
	final JPanel comboBox4= new JPanel();
	final JPanel comboBox5= new JPanel();
	final JPanel button= new JPanel();
	final JPanel checkBox= new JPanel();
	
	// Generate the GUI
	public SierpinskiVisualizer() {
		
		// Build the frame.
		frame = new JFrame("Sierpinski Visualizer");
		frame.setSize(790,545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());
		
		// Create the canvas.
		canvas=new Canvas();
		canvas.setSize(SIZE, SIZE);
		canvas.setBackground(Color.black);
		frame.add(canvas);
		
		//Sets up JPanel for the user options
		userPanel.setLayout(new GridLayout(15,1));
		
		//Make space until we reach where we want to place objects
		JPanel blank_a= new JPanel();
		JPanel blank_b= new JPanel();
		JPanel blank_c= new JPanel();
		JLabel blank_1= new JLabel(" ");
		JLabel blank_2= new JLabel(" ");
		JLabel blank_3= new JLabel(" ");
		
		//Place space makers
		blank_a.add(blank_1);
		blank_b.add(blank_2);
		blank_c.add(blank_3);
		
		//Add this space to out panel
		userPanel.add(blank_a);
		userPanel.add(blank_b);
		userPanel.add(blank_c);
		
		// Add recursive depth input field
		JLabel recDepthLabel = new JLabel("Recusrive Depth: ");
		recDepthTextField = new JTextField(6);
		
		//Watches for keystroke
		recDepthTextField.addKeyListener(this);
		//Not sure about type cast in line before
		textField.setLayout(new FlowLayout());
		textField.add(recDepthLabel);
		textField.add(recDepthTextField);
		userPanel.add(textField);
		
		//Set us arrays for color labels and boxes
		for(int i=0; i< realColors.length; i++){
			nameColors[i]= new JLabel("Color "+(i+1)+": ");
			realColors[i]= new JComboBox(colors);
		}
		
		// Add ComboBox1 and label to GUI
		comboBox1.setLayout(new FlowLayout());
		comboBox1.add(nameColors[0]);
		comboBox1.add(realColors[0]);
		userPanel.add(comboBox1);
		
		// Add ComboBox2 and label to GUI
		comboBox2.setLayout(new FlowLayout());
		comboBox2.add(nameColors[1]);
		comboBox2.add(realColors[1]);
		userPanel.add(comboBox2);
		
		// Add ComboBox3 and label to GUI
		comboBox3.setLayout(new FlowLayout());
		comboBox3.add(nameColors[2]);
		comboBox3.add(realColors[2]);
		userPanel.add(comboBox3);
		
		// Add ComboBox4 and label to GUI
		comboBox4.setLayout(new FlowLayout());
		comboBox4.add(nameColors[3]);
		comboBox4.add(realColors[3]);
		userPanel.add(comboBox4);
		
		// Add ComboBox5 and label to GUI
		comboBox5.setLayout(new FlowLayout());
		comboBox5.add(nameColors[4]);
		comboBox5.add(realColors[4]);
		userPanel.add(comboBox5);
		
		//Adds the userPanel 
		frame.add(userPanel);		
		
		// Makes random label and checkbox
		JLabel random= new JLabel("Randomize Colors at Each Level");
		randomizeCheckBox = new JCheckBox();
		
		//Adds label and checkbox to GUI
		checkBox.add(randomizeCheckBox);
		checkBox.add(random);
		userPanel.add(checkBox);
		
		//Watches for check box being checked and adds changes if needed
		randomizeCheckBox.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e){
				for(JComboBox box: realColors){
					box.setEnabled(!randomizeCheckBox.isSelected());
				}
			}
		});
		
		// Draw button and add listener. 
		JButton btn= new JButton("Draw!");
		btn.addActionListener((ActionListener) this);
		button.add(btn);
		userPanel.add(button);
		
		//Shows the contents and does not allow resizing
		frame.setResizable(false);
		frame.setVisible(true);
		
		// Get the graphics object of the canvas. It's important to do this AFTER the frame is
		//	visible, since before this there is no graphics object associated with the canvas.
		graphics = canvas.getGraphics();
	}
		
	// Recursive function to draw triangles at a given depth at the specified square given.
	private void draw(int d, int x, int y, int S) {
		
		//Create array of x values
		if (d==depth()){
			int [] x1= new int[]{
					x+S/2,
					x+S,
					x
			};
			
			//Create array of y values
			int [] y1= new int[]{
					y,
					y+S,
					y+S,
			};
			
			//Draws outline of triangle so can see through
			graphics.setColor(Color.white);
			graphics.drawPolygon(x1, y1, 3);
		}
		
		//When finished drawing stop
		if(d<=0){
			return;
		}
		
		// Otherwise, draw big triangle at this level, between the points
		// shown in the figure. You can use the fillPolygon() method of
		// the Graphics object of your Canvas. Make sure you get the color
		// right!
		
		//Dimentions for x
		int xCorners[]={
				(x+S/4),
				(x+3*S/4),
				(x+S/2),
				(x+S/4),
		};
		
		//Dimentions for y
		int yCorners[]={
			(y+S/2),
			(y+S/2),
			(y+S),
			(y+S/2),
		};
		
		//Drws triangles
		graphics.setColor(choice[depth()-d]);
		graphics.fillPolygon(xCorners, yCorners, 3);
		
		
		
		// Draw the subtriangles. The self-similarity of fractals means
		// that they are themselves Sierpinski triangles of depth d-1.
		draw(d-1, x+S/4, y, S/2);
		draw(d-1, x, y+S/2, S/2);
		draw(d-1, x+S/2, y+S/2, S/2);
	}
	
	//Main method
	public static void main(String[] args) {
		new SierpinskiVisualizer();
	}

	//Necessary when implementing KeyListener
	public void keyReleased(KeyEvent e) {	
	}
	
	//Necessary when implementing KeyListener
	@Override
	public void keyPressed(KeyEvent e) {
	}

	//Necessary when implementing KeyListener
	@Override
	public void keyTyped(KeyEvent e) {
	}

	//Method to process input and call recursive draw method
	public void actionPerformed(ActionEvent e) {
		
		//Clear canvas if we are starting over
		graphics.clearRect(0,0,512,512);
		
		//Get input for depth
		int givenDepth= depth();
		
		//Check that depth is in range, if not alert user
		if(givenDepth>10){
			JOptionPane.showMessageDialog(null, "Invalid entry.");
			
			return;
		}
		
		//Check that depth is in range, if not alert user
		else if(0>givenDepth){
			JOptionPane.showMessageDialog(null, "Invalid entry.");
		
			return;
		}
		
		//If random is selected
		if(randomizeCheckBox.isSelected()){
			choice=new Color[colors.length];
			
			//Saves Color values into array
			Random rand= new Random();
			for(int i=0; i<colors.length; i++){
				choice[i]=colorName(colors[i]);
			}
			
			//Randomize with temp array
			for(int i=0; i<choice.length; i++){
				int temp=rand.nextInt(choice.length);
				Color tempColor= choice[i];
				choice[i]= choice[temp];
				choice[temp]=tempColor;
			}
		}
		
		//If not random do user decisions
		else{
			choice=new Color[colors.length];
			
			//For under 5 layers
			for(int i=0; i<5; i++){
				choice[i]=colorName(realColors[i].getSelectedItem().toString());
			}
			
			//In case we have more than 5 layers
			for(int i=5; i< colors.length; i++){
				choice[i]=choice[i-5];
			}
		}
		
		//Calls the draw method
		draw(givenDepth, 0, 0, 512);
	}
	
	//Depth method to find the depth
	public int depth(){
		int depth=0;
		
		//Try catch to be used to decide if something was entered
		try{
			depth= Integer.parseInt(recDepthTextField.getText());
		} catch (NumberFormatException ex){
			//Check if something is in the field and if not will throw error
			if(!recDepthTextField.hasFocus()){
				recDepthTextField.setText("0");
			}
			depth=0;
		}
		return depth;
		
	}
	
	//Method to return a string color choice to actual color
	public Color colorName(String color){
		
		//Compares the name to strings in order to return real color
		if(color.compareTo("Dark Gray")==0){
			return Color.darkGray;
		}
		else if(color.compareTo("Gray")==0){
			return Color.gray;
		}
		else if(color.compareTo("Light Gray")==0){
			return Color.lightGray;
		}
		else if(color.compareTo("White")==0){
			return Color.white;
		}
		else if(color.compareTo("Red")==0){
			return Color.red;
		}
		else if(color.compareTo("Orange")==0){
			return Color.orange;
		}
		else if(color.compareTo("Yellow")==0){
			return Color.yellow;
		}
		else if(color.compareTo("Green")==0){
			return Color.green;
		}
		else if(color.compareTo("Cyan")==0){
			return Color.cyan;
		}
		else if(color.compareTo("Blue")==0){
			return Color.blue;
		}
		else if(color.compareTo("Magenta")==0){
			return Color.magenta;
		}
		else if(color.compareTo("Pink")==0){
			return Color.pink;
		}
		
		return Color.white;
	}

}
