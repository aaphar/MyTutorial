package packages;

import java.awt.*; // abstract - window toolkit
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindow extends Frame {

    public MyWindow(String title) {
        super(title);
        setSize(500, 400);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) { // called during process of closing
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font sanSerifLarge=new Font("SanSerif", Font.BOLD, 18);
        Font sanSerifSmall=new Font("SanSerif", Font.BOLD, 12);
        g.setFont(sanSerifLarge);
        g.drawString("The complete Java developer course", 60, 60);
        g.setFont(sanSerifSmall);
        g.drawString("by Aphar Magaramova", 60, 100);
    }
}
