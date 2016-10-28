import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

/**
 * Created by Denis on 28.10.2016.
 */
public class ALT implements ActionListener {

    private  Termin t;
    private  LocalDateTime start;
    private  LocalDateTime ende;
    private  String ort;
    private  String thema;

    public ALT(TerminEditor e) {
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
