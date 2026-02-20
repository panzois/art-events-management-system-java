package Music;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Η κλάση {@code MusicPerformance} αναπαριστά μια μουσική παράσταση με
 * πληροφορίες όπως κωδικός, τίτλος, τραγουδιστής, χώρος και ημερομηνία διεξαγωγής.
 */
public class MusicPerformance 
{
    /** Ο μοναδικός κωδικός της παράστασης (ως String). */
    private String code; 
     /** Ο τίτλος της μουσικής παράστασης. */
    private String title;
    /** Το όνομα του τραγουδιστή ή συγκροτήματος. */
    private String singer;
    /** Ο χώρος διεξαγωγής της παράστασης. */
    private String venue;
    /** Η ημερομηνία της παράστασης ως αντικείμενο LocalDate. */
    private LocalDate date;
    /** Ο formatter που χρησιμοποιείται για μορφοποίηση ημερομηνιών σε μορφή yyyy-MM-dd. */
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    
     /**
     * Κατασκευαστής της κλάσης {@code MusicPerformance}.
     *
     * @param code    Ο μοναδικός κωδικός της παράστασης
     * @param title   Ο τίτλος της παράστασης
     * @param singer  Ο τραγουδιστής ή το συγκρότημα
     * @param venue   Ο χώρος διεξαγωγής
     * @param dateStr Η ημερομηνία της παράστασης σε μορφή {@code yyyy-MM-dd}
     */
    public MusicPerformance(String code, String title, String singer, String venue, String dateStr) 
    { 
        
        this.code = code;
        this.title = title;
        this.singer = singer;
        this.venue = venue;
        this.date = LocalDate.parse(dateStr, formatter);
    }

    /**
     * Επιστρέφει τον κωδικό της παράστασης.
     *
     * @return Ο κωδικός της παράστασης
     */
    public String getCode() { // Ο τύπος επιστροφής άλλαξε σε String
        return code;
    }
    /**
     * Θέτει τον κωδικό της παράστασης.
     *
     * @param code Ο νέος κωδικός
     */
    public void setCode(String code) { // Ο τύπος παραμέτρου άλλαξε σε String
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

     /**
     * Επιστρέφει την ημερομηνία της παράστασης σε μορφή {@code yyyy-MM-dd}.
     *
     * @return Η ημερομηνία σε μορφή συμβολοσειράς
     */
    public String getDateString() {
        return date.format(formatter);
    }
    
    /**
     * Εμφανίζει αναλυτικά όλα τα πεδία της μουσικής παράστασης στην κονσόλα.
     */
    public void fullPrint() {
    System.out.println("Κωδικός: " + code +
        ", Τίτλος: " + title +
        ", Τραγουδιστής: " + singer +
        ", Χώρος: " + venue +
        ", Ημερομηνία: " + getDateString());
    }
}