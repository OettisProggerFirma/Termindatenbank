import sun.swing.SwingAccessor;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static java.time.format.FormatStyle.SHORT;

/**
 * Created by doetken on 26.10.2016.
 */
public class TerminEditor extends javax.swing.JPanel {

    private DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(SHORT);
    private javax.swing.JTextField start = new JTextField("Start: ", 15);
    private javax.swing.JTextField ende = new JTextField(15);
    private javax.swing.JTextArea thema = new JTextArea(20, 20);
    private javax.swing.JTextField ort = new JTextField(20);
    private javax.swing.JButton speichern = new JButton("Speichern");
    DBVerbindung con;


    public TerminEditor() {
        super(new BorderLayout());
        this.start.setText(formatter.format(LocalDateTime.now()));
        this.ende.setText(formatter.format(LocalDateTime.now()));
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        try {
            con = new DBVerbindung();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JPanel header = new JPanel(new FlowLayout());
        JPanel footer = new JPanel(new FlowLayout());
        this.start.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //  JLabel startLabel = new JLabel("Start: ");
        // header.add(startLabel);
        header.add(this.start);
        JLabel endeLabel = new JLabel("Ende: ");
        header.add(endeLabel);
        header.add(this.ende);
        JLabel ortLabel = new JLabel("Ort: ");
        footer.add(ortLabel);
        footer.add(ort);
        this.speichern.addActionListener(new SpeichernListener(this));
        footer.add(this.speichern);

        this.add(header, BorderLayout.NORTH);
        this.add(this.thema, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);

    }

    private void anzeigen(Termin termin) {
        this.start.setText(termin.getStart().toString());
        this.ende.setText(termin.getEnde().toString());
        this.ort.setText(termin.getOrt());
        this.thema.setText(termin.getThema());
    }

    public void leeren() {
        this.start.setText("");
        this.ende.setText("");
        this.ort.setText("");
        this.thema.setText("");
    }

    public Termin holeTermin() {
        Termin terminAktuell;
        LocalDateTime startAktuell = LocalDateTime.parse(this.start.getText(), formatter);
        LocalDateTime endeAktuell = LocalDateTime.parse(this.ende.getText(), formatter);
        String themaAktuell;
        String ortAktuell;
        themaAktuell = this.thema.getText();
        ortAktuell = this.ende.getText();
        terminAktuell = new Termin(startAktuell, endeAktuell, themaAktuell, ortAktuell);
        return terminAktuell;
    }


    private class SpeichernListener implements ActionListener {

        private final Termin t;
        private final LocalDateTime start;
        private final LocalDateTime ende;
        private final String ort;
        private final String thema;

        private SpeichernListener(TerminEditor e) {
            this.t = e.holeTermin();
            this.start = t.getStart();
            this.ende = t.getEnde();
            this.ort = t.getOrt();
            this.thema = t.getThema();
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}

