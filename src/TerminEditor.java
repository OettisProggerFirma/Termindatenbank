import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Created by doetken on 26.10.2016.
 */
public class TerminEditor extends javax.swing.JPanel {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
    private javax.swing.JTextField start = new JTextField(15);
    private javax.swing.JTextField ende = new JTextField(15);
    private javax.swing.JTextArea thema = new JTextArea(20, 20);
    private javax.swing.JTextField ort = new JTextField(20);
    private javax.swing.JButton speichern = new JButton("Speichern");

    public TerminEditor() {
        super(new BorderLayout());

        JPanel header = new JPanel(new FlowLayout());
        JPanel footer = new JPanel(new FlowLayout());
        header.add(this.start);
        header.add(this.ende);
        header.add(this.ort);
        this.speichern.addActionListener(new SpeichernListener(this);
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
        LocalDateTime startAktuell;
        LocalDateTime endeAktuell;
        String themaAktuell;
        String ortAktuell;
        startAktuell = (LocalDateTime) formatter.parse(this.start.getText());
        endeAktuell = (LocalDateTime) formatter.parse(this.ende.getText());
        themaAktuell = this.thema.getText();
        ortAktuell = this.ende.getText();
        terminAktuell = new Termin(startAktuell, endeAktuell, themaAktuell, ortAktuell);
        return terminAktuell;
    }
}
