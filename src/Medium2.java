import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Medium2 implements ActionListener {
    private JFrame mainFrame;
    private JLabel statusLabel;
//    private JLabel label;
    private JPanel controlPanel;
    private JMenuBar mb;
    private JMenu file, edit, help;
    private JMenuItem cut, copy, paste, selectAll;
    private JTextArea ta; //typing area
    private int WIDTH=800;
    private int HEIGHT=700;


    public Medium2() {
        prepareGUI();
    }

    public static void main(String[] args) {
        Medium2 Medium2 = new Medium2();
        Medium2.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new GridLayout(3,3));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout()); //set the layout of the panel

        JButton button1 = new JButton("button1");
        JButton button2 = new JButton("button2");
        JButton button3 = new JButton("button3");
        JButton button4 = new JButton("button4");
        JButton button5 = new JButton("button5");
        JButton button6 = new JButton("button6");
        JButton button7 = new JButton("button7");
        JButton button8 = new JButton("button8");

        mainFrame.add(button1);
        mainFrame.add(button2);
        mainFrame.add(button3);
        mainFrame.add(button4);
        mainFrame.add(controlPanel);
//        mainFrame.add(statusLabel);
        mainFrame.add(button5);
        mainFrame.add(button6);
        mainFrame.add(button7);
        mainFrame.add(button8);
        mainFrame.setVisible(true);
    }

    void showEventDemo() {
        JLabel label = new JLabel("label");
        JButton button9 = new JButton("button9");
        JButton button10 = new JButton("button10");

//        okButton.setActionCommand("OK");
//        submitButton.setActionCommand("Submit");
//        cancelButton.setActionCommand("Cancel");
//
//        okButton.addActionListener(new ButtonClickListener());
//        submitButton.addActionListener(new ButtonClickListener());
//        cancelButton.addActionListener(new ButtonClickListener());

        controlPanel.add(label,BorderLayout.WEST);
        controlPanel.add(button9,BorderLayout.EAST);
        controlPanel.add(button10,BorderLayout.SOUTH);
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cut)
            ta.cut();
        if (e.getSource() == paste)
            ta.paste();
        if (e.getSource() == copy)
            ta.copy();
        if (e.getSource() == selectAll)
            ta.selectAll();
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("OK")) {
                statusLabel.setText("Ok Button clicked.");
            } else if (command.equals("Submit")) {
                statusLabel.setText("Submit Button clicked.");
            } else {
                statusLabel.setText("Cancel Button clicked.");
            }
        }
    }
}