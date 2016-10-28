import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

/**
 * Created by Denis on 28.10.2016.
 */
public class SpeichernListener implements ActionListener {

    private final Termin t;
    private final LocalDateTime start;
    private final LocalDateTime ende;
    private final String ort;
    private final String thema;

    public SpeichernListener(TerminEditor e) {
        this.t = e.holeTermin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
// todo: die Connection muss Teil des TerminEditors sein
        this.start = t.getStart();
        this.ende = t.getEnde();
        this.ort = t.getOrt();
        this.thema = t.getThema();
    }
}
