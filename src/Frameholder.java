import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

/**
 * Created by doetken on 26.10.2016.
 */
public class Frameholder {
    public Frameholder() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new BorderLayout());

        TerminEditor editor = new TerminEditor();
        panel.add(editor);
        try {
            DBVerbindung con = new DBVerbindung();
            frame.addWindowListener(new WindowListener() {

                @Override
                public void windowOpened(WindowEvent e) {

                }

                @Override
                public void windowClosing(WindowEvent e) {
                    try {
                        con.schließen();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
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
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
