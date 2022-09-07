package OO3opg2.src.Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowGUI extends JFrame implements WindowListener, ActionListener {

    private JButton button;
    private JButton button2;
    private String buttonName = "Band";
    private String button2Name = "Ok kammerat";
    private static String windowName = "Yeet the Name";
    private int exceptCount = 0;

    public WindowGUI(String title) throws HeadlessException {
        super(title);
        this.setLayout(new FlowLayout());
        this.addWindowListener(this);

        button = new JButton(buttonName);
        this.add(button);
        button.addActionListener(this);

        button2 = new JButton(button2Name);
        this.add(button2);
        button2.addActionListener(this);
    }

    public static void main(String[] args) {
        WindowGUI window = new WindowGUI(windowName);
        window.setSize(350, 100);
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) { //underligt nok virker det kun hvis man udelader throws... her
        try {
            if (e.getActionCommand().equalsIgnoreCase(buttonName))
                System.out.println("Jeg har desværre ikke et yndlingsband");

            if (e.getActionCommand().equalsIgnoreCase(button2Name))
                throw new ButtonException("Hovsa, det var ikke meningen");

        } catch (ButtonException buttonException) {
            exceptCount++;
            System.out.println("Exception nummer " + exceptCount);
            buttonException.printStackTrace();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
