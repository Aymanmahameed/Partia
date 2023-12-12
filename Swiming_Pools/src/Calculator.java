import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener{
	
	  JTextField textField = new JTextField(16);
	  JPanel panel = new JPanel();
	  JPanel panel2 = new JPanel();
	  String first, second, operator;

	JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSub, btnDiv, btnMul, btnDot,
	btnClr, btnEq;
	JButton Home = new JButton("Back");
	public Calculator() {
		super("Cal");
		// designing the page
		first = second = operator = "";
		
		btn0 = new JButton("0");
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		textField.setEditable(false);
		btnEq = new JButton("=");

		btnAdd = new JButton("+");
		btnSub = new JButton("-");
		btnDiv = new JButton("/");
		btnMul = new JButton("*");
		btnClr = new JButton("C");

		btnDot = new JButton(".");
		textField.setEditable(false);
		btnMul.addActionListener(this);
		btnDiv.addActionListener(this);
		btnSub.addActionListener(this);
		btnAdd.addActionListener(this);
		btn9.addActionListener(this);
		btn8.addActionListener(this);
		btn7.addActionListener(this);
		btn6.addActionListener(this);
		btn5.addActionListener(this);
		btn4.addActionListener(this);
		btn3.addActionListener(this);
		btn2.addActionListener(this);
		btn1.addActionListener(this);
		btn0.addActionListener(this);
		btnDot.addActionListener(this);
		btnClr.addActionListener(this);
		btnEq.addActionListener(this);
		Home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				setVisible(false);
				Login.t.setVisible(true);

			}
		});
		panel2.add(textField);
		
		panel.setLayout(new GridLayout(0, 3));
		panel.add(btn0);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		panel.add(btn7);
		panel.add(btn8);
		panel.add(btn9);
		panel.add(btnDiv);
		panel.add(btnMul);
		panel.add(btnSub);
		panel.add(btnDot);
		panel.add(btnClr);
		panel.add(btnAdd);
		panel.add(btnEq);
		panel.add(Home);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(500, 200, 500, 500);
		setLayout(new BorderLayout());
		add(panel2,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
		setSize(300,400);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		String action = e.getActionCommand();
		// if the value is number
		if ((action.charAt(0) >= '0' && action.charAt(0) <= '9') || action.charAt(0) == '.') {
			if(action.equals(".") && first.contains(".")) {
				// no action
			}
			else if (!operator.equals(""))
				second = second + action;
			else
				first = first + action;

			textField.setText(first + operator + second);
		}else if (action.charAt(0) == 'C') {
			operator = second = "";
			first = "0";
			// set the value of text
			textField.setText(first + operator + second);
		}else if (action.charAt(0) == '=' && !first.equalsIgnoreCase("") && !second.equalsIgnoreCase("")) {

			double result;
			if (operator.equals("+"))
				result = (Double.parseDouble(first) + Double.parseDouble(second));
			else if (operator.equals("-"))
				result = (Double.parseDouble(first) - Double.parseDouble(second));
			else if (operator.equals("/"))
				result = (Double.parseDouble(first) / Double.parseDouble(second));
			else
				result = (Double.parseDouble(first) * Double.parseDouble(second));

			textField.setText(first + operator + second + "=" + result);
			first = Double.toString(result);
			operator = second = "";
		} else {
			if (operator.equals("") || second.equals(""))
				operator = action;
			else {
				double result;
				if (operator.equals("+"))
					result = (Double.parseDouble(first) + Double.parseDouble(second));
				else if (operator.equals("-"))
					result = (Double.parseDouble(first) - Double.parseDouble(second));
				else if (operator.equals("/"))
					result = (Double.parseDouble(first) / Double.parseDouble(second));
				else
					result = (Double.parseDouble(first) * Double.parseDouble(second));
				first = Double.toString(result);
				operator = action;
				second = "";
			}

			if (first.equals("")) {
				first = operator = second = "";
			} else if(second.equals("") && operator.equals("=")) {
				operator = "";
			}
			textField.setText(first + operator + second);
		}

	}

}
