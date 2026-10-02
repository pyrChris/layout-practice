import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Easy2 implements ActionListener {
    private JFrame mainFrame;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JMenuBar mb;
    private JMenu file, edit, help;
    private JMenuItem cut, copy, paste, selectAll;
    private JTextArea ta; //typing area
    private int WIDTH=800;
    private int HEIGHT=700;


    public Easy2() {
        prepareGUI();
    }

    public static void main(String[] args) {
        Easy2 Easy2 = new Easy2();
        Easy2.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new BorderLayout());

        //menu at top
//        cut = new JMenuItem("cut");
//        copy = new JMenuItem("copy");
//        paste = new JMenuItem("paste");
//        selectAll = new JMenuItem("selectAll");
//        cut.addActionListener(this);
//        copy.addActionListener(this);
//        paste.addActionListener(this);
//        selectAll.addActionListener(this);

//        mb = new JMenuBar();
//        file = new JMenu("File");
//        edit = new JMenu("Edit");
//        help = new JMenu("Help");
//        edit.add(cut);
//        edit.add(copy);
//        edit.add(paste);
//        edit.add(selectAll);
//        mb.add(file);
//        mb.add(edit);
//        mb.add(help);
        //end menu at top

//        ta = new JTextArea();
//        ta.setBounds(50, 5, WIDTH-100, HEIGHT-50);
//        mainFrame.add(mb);  //add menu bar
//        mainFrame.add(ta);//add typing area
//        mainFrame.setJMenuBar(mb); //set menu bar

        //statusLabel = new JLabel("", JLabel.CENTER);
        //statusLabel.setSize(350, 100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout()); //set the layout of the pannel

        mainFrame.add(controlPanel);
        //mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showEventDemo() {
        JButton Button1 = new JButton("Button1");
        JButton Button2 = new JButton("Button2");
        JButton Button3 = new JButton("Button3");
        JButton Button4 = new JButton("Button4");
        JButton Button5 = new JButton("Button5");

        Button1.setActionCommand("Button1");
        Button2.setActionCommand("Button2");
        Button3.setActionCommand("Button3");
        Button4.setActionCommand("Button4");
        Button5.setActionCommand("Button5");

        Button1.addActionListener(new ButtonClickListener());
        Button2.addActionListener(new ButtonClickListener());
        Button3.addActionListener(new ButtonClickListener());
        Button4.addActionListener(new ButtonClickListener());
        Button5.addActionListener(new ButtonClickListener());

        controlPanel.add(Button1,BorderLayout.NORTH);
        controlPanel.add(Button2,BorderLayout.EAST);
        controlPanel.add(Button3,BorderLayout.SOUTH);
        controlPanel.add(Button4,BorderLayout.WEST);
        controlPanel.add(Button5,BorderLayout.CENTER);

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