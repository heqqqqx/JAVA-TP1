import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

public class Excel extends JFrame implements ActionListener {
  JPanel panel = new JPanel();
  JPanel buttonPanel = new JPanel();
  JLabel numbersLabel = new JLabel("Enter numbers separate by spaces");
  JTextField numbers = new JTextField("");
  JLabel output = new JLabel();
  JButton calculate = new JButton("Calculate");
  ButtonGroup operations = new ButtonGroup();
  JRadioButton sum = new JRadioButton("Sum", true);
  JRadioButton average = new JRadioButton("Average");
  JRadioButton min = new JRadioButton("Min");
  JRadioButton max = new JRadioButton("Max");

  public Excel() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setSize(800, 500);
    add(panel);
    numbers.setPreferredSize(new DimensionUIResource(100, 20));

    operations.add(sum);
    operations.add(average);
    operations.add(min);
    operations.add(max);

    panel.add(numbersLabel);
    panel.add(numbers);
    panel.add(sum);
    panel.add(average);
    panel.add(min);
    panel.add(max);
    panel.add(output);
    panel.add(calculate);
    
    calculate.addActionListener(this);
    

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String[] numStrings = numbers.getText().trim().split(" ");
    if (numStrings.length > 0 && numStrings[0].equals("")) {
      String[] temp = new String[numStrings.length - 1];
      for (int i = 1; i < numStrings.length; i++) {
        temp[i - 1] = numStrings[i];
      }
      numStrings = temp;
    }
    for (String s : numStrings) {
      try {
        Double.parseDouble(s);
      } catch (NumberFormatException ex) {
        output.setText("Invalid input");
        return;
      }
    }

    if (sum.isSelected()) {
      int sum = 0;
      for (String numString : numStrings) {
        sum += Integer.parseInt(numString);
      }
      output.setText("Sum: " + String.valueOf(sum));
    } else if (average.isSelected()) {
      int sum = 0;
      for (String numString : numStrings) {
        sum += Integer.parseInt(numString);
      }
      output.setText("Average: " + String.valueOf(sum / numStrings.length));
    } else if (min.isSelected()) {
      int min = Integer.MAX_VALUE;
      for (String numString : numStrings) {
        int num = Integer.parseInt(numString);
        if (num < min) {
          min = num;
        }
      }
      output.setText("Min: " + String.valueOf(min));
    } else if (max.isSelected()) {
      int max = Integer.MIN_VALUE;
      for (String numString : numStrings) {
        int num = Integer.parseInt(numString);
        if (num > max) {
          max = num;
        }
      }
      output.setText("Max: " + String.valueOf(max));
    }
  }
}
