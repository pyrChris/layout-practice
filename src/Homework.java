import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Homework implements ActionListener {
    private JFrame mainFrame;

    private JPanel top;
    private JPanel inputPanel;
    private JPanel controlPanel;

    private JScrollPane scrollPane;
    private JTextArea display; //typing area
    private int WIDTH=800;
    private int HEIGHT=700;

    public Homework() {
        prepareGUI();
    }

    public static void main(String[] args) {
        Homework Homework = new Homework();
        Homework.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new BorderLayout(0,50));

        top = new JPanel();
        top.setLayout(new BorderLayout());


        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout()); //set the layout of the pannel


        top.add(inputPanel,BorderLayout.CENTER);
        top.add(controlPanel,BorderLayout.SOUTH);
        mainFrame.add(top,BorderLayout.NORTH);


        display = new JTextArea();
        display.setEditable(false);
        display.setLineWrap(true);
        scrollPane = new JScrollPane(display);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainFrame.add(scrollPane,BorderLayout.CENTER);

        mainFrame.setVisible(true);
    }

    JTextField inputField = new JTextField();
    void showEventDemo() {
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Reset");
        submitButton.setActionCommand("Submit");
        cancelButton.setActionCommand("Reset");
        submitButton.addActionListener(new ButtonClickListener());
        cancelButton.addActionListener(new ButtonClickListener());

        controlPanel.add(submitButton);
        controlPanel.add(cancelButton);


        JLabel inputSign = new JLabel("Input:");
        inputField.setPreferredSize(new Dimension(600,25));
        inputPanel.add(inputSign);
        inputPanel.add(inputField);

        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if(command.equals("Submit")){
                display.setText(display.getText() + inputField.getText());
            }else if(command.equals("Reset")){
                display.setText("");
                inputField.setText("");
            }
        }
    }
}