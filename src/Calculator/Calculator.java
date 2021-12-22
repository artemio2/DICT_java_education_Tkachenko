package Calculator;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class Calculator implements  ActionListener{

    JPanel textPanel, panelForTextFields, completionPanel;
    JLabel titleLabel, loanLabel, yearsLabel, rateLabel, rate2Label, payLabel;
    JTextField loanField, yearsField, rateField, payField;
    JButton loginButton;
    private double loan, years, rate, monthly;

    public JPanel createContentPane (){

        JPanel totalGUI = new JPanel();
        totalGUI.setLayout(null);

        titleLabel = new JLabel("Loan Calculator");
        titleLabel.setLocation(110,0);
        titleLabel.setSize(180, 30);
        titleLabel.setHorizontalAlignment(0);
        totalGUI.add(titleLabel);

        textPanel = new JPanel();
        textPanel.setLayout(null);
        textPanel.setLocation(10, 35);
        textPanel.setSize(180, 190);
        totalGUI.add(textPanel);

        loanLabel = new JLabel("Loan Amount");
        loanLabel.setLocation(0, 10);
        loanLabel.setSize(100, 30);
        loanLabel.setHorizontalAlignment(4);
        textPanel.add(loanLabel);


        yearsLabel = new JLabel("# of Years");
        yearsLabel.setLocation(0, 50);
        yearsLabel.setSize(100, 30);
        yearsLabel.setHorizontalAlignment(4);
        textPanel.add(yearsLabel);

        rateLabel = new JLabel("Interest Rate");
        rateLabel.setLocation(0,90);
        rateLabel.setSize(100, 30);
        rateLabel.setHorizontalAlignment(4);
        textPanel.add(rateLabel);

        rate2Label = new JLabel("ex.(5.0 for 5%)");
        rate2Label.setLocation(0,110);
        rate2Label.setSize(100,30);
        rate2Label.setHorizontalAlignment(4);
        textPanel.add(rate2Label);

        payLabel = new JLabel("Monthly Payment");
        payLabel.setLocation(0,160);
        payLabel.setSize(150,30);
        payLabel.setHorizontalAlignment(4);
        textPanel.add(payLabel);


        panelForTextFields = new JPanel();
        panelForTextFields.setLayout(null);
        panelForTextFields.setLocation(250, 40);
        panelForTextFields.setSize(100, 180);
        totalGUI.add(panelForTextFields);


        loanField = new JTextField(8);
        loanField.setLocation(0, 0);
        loanField.setSize(100, 30);
        panelForTextFields.add(loanField);
        loanField.addActionListener(this);


        yearsField = new JTextField(8);
        yearsField.setLocation(0, 40);
        yearsField.setSize(100, 30);
        panelForTextFields.add(yearsField);
        yearsField.addActionListener(this);

        rateField = new JTextField(8);
        rateField.setLocation(0, 80);
        rateField.setSize(100, 30);
        panelForTextFields.add(rateField);
        rateField.addActionListener(this);


        payField = new JTextField(8);
        payField.setEditable(false);
        payField.setLocation(0,150);
        payField.setSize(100,30);
        panelForTextFields.add(payField);
        payField.addActionListener(this);

        completionPanel = new JPanel();
        completionPanel.setLayout(null);
        completionPanel.setLocation(40, 35);
        completionPanel.setSize(170, 180);
        totalGUI.add(completionPanel);


        loginButton = new JButton("Calculate");
        loginButton.setLocation(130, 250);
        loginButton.setSize(150, 30);
        loginButton.addActionListener(this);
        totalGUI.add(loginButton);

        totalGUI.setOpaque(true);
        return totalGUI;
    }



    public void actionPerformed(ActionEvent e) {
        loan = (Double.parseDouble(loanField.getText()));
        years = (Double.parseDouble(yearsField.getText()));
        rate = (Double.parseDouble(rateField.getText()));
        double mRate = (rate)/1200.0;
        double months = (years)*12.0;
        double denom = (Math.pow((1+mRate),months)-1);
        monthly = (mRate + mRate/denom)*loan;
        DecimalFormat x = new DecimalFormat("#.##");
        monthly = Double.valueOf(x.format(monthly));
        payField.setText("");
        payField.setText(monthly +"");



    }


    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Loan Calculator");

        Calculator demo = new Calculator();
        frame.setContentPane(demo.createContentPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}