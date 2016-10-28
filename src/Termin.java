import java.time.LocalDateTime;

/**
 * Created by doetken on 26.10.2016.
 */
public class Termin {
    private final LocalDateTime start;
    private final LocalDateTime ende;
    private final String thema;
    private final String ort;

    public Termin(LocalDateTime start, LocalDateTime ende, String thema, String ort) {
        this.start = start;
        this.ende = ende;
        this.thema = thema;
        this.ort = ort;

        if (ende.isBefore(start) || ende.isEqual(start)) {
            System.out.println("Der Start ist nicht vor dem Ende");
        }
    }

    public LocalDateTime getStart() {

        return start;
    }

    public LocalDateTime getEnde() {
        return ende;
    }

    public String getThema() {
        return thema;
    }

    public String getOrt() {
        return ort;
    }
}
