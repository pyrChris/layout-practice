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
        //https://diarycoding.com/artikel/how-do-i-create-an-uneditable-jtextarea
        display.setEditable(false);
        //https://stackoverflow.com/questions/74251435/break-string-in-javax-swing-jtextarea-without-escape-characters
        display.setLineWrap(true);
        display.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
        //https://www.cs.emory.edu/~cheung/Courses/377/Syllabus/8-JDBC/GUI/components5.html
        scrollPane = new JScrollPane(display);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainFrame.add(scrollPane,BorderLayout.CENTER);

        mainFrame.setVisible(true);
    }

    JTextField inputField = new JTextField();
    void showEventDemo() {
        JButton submitButton = new JButton("Submit");
        JButton addSubmitButton = new JButton("Add + Submit");
        JButton fontButton = new JButton("Cycle Fonts");
        JButton cancelButton = new JButton("Reset");
        submitButton.setActionCommand("Submit");
        addSubmitButton.setActionCommand("Add + Submit");
        fontButton.setActionCommand("Cycle Fonts");
        cancelButton.setActionCommand("Reset");
        addSubmitButton.addActionListener(new ButtonClickListener());
        submitButton.addActionListener(new ButtonClickListener());
        fontButton.addActionListener(new ButtonClickListener());
        cancelButton.addActionListener(new ButtonClickListener());

        controlPanel.add(addSubmitButton);
        controlPanel.add(submitButton);
        controlPanel.add(fontButton);
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
        private int fontState = 0;
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if(command.equals("Submit")){
                display.setText(inputField.getText());
            }else if(command.equals("Reset")){
                display.setText("");
                inputField.setText("");
            }else if(command.equals("Add + Submit")){
                display.setText(display.getText()+inputField.getText());
            }
            else if(command.equals("Cycle Fonts")){
                //setFont parameters: https://stackoverflow.com/questions/59763059/change-the-font-style-size-in-a-java-swing-appliation
                //https://www.scribd.com/document/947547133/GUI-4-Colors-Fonts
                switch(fontState){
                    case 0:
                        display.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18));
                        fontState++;
                        break;
                    case 1:
                        display.setFont(new Font("Arial", Font.BOLD, 18));
                        fontState++;
                        break;
                    case 2:
                        display.setFont(new Font("Arial", Font.ITALIC, 18));
                        fontState++;
                        break;
                    case 3:
                        display.setFont(new Font("Helvetica", Font.LAYOUT_LEFT_TO_RIGHT, 18));
                        fontState++;
                        break;
                    case 4:
                        display.setFont(new Font("Times", Font.LAYOUT_LEFT_TO_RIGHT, 18));
                        fontState++;
                        break;
                    case 5:
                        display.setFont(new Font("Courier", Font.LAYOUT_LEFT_TO_RIGHT, 18));
                        fontState = 0;
                        break;
                }
            }
        }
    }
}