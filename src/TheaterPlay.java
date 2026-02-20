package Theater;

import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author panzois
 */

/** ΘΕΑΤΡΙΚΗ ΠΑΡΑΣΤΑΣΗ. 
 */
public class TheaterPlay 
{
    private String code;
    private String title;
    private String leadActor;
    private String venue;
    private LocalDate date;
    
    /**CONSTRUCTOR ΤΗΣ ΘΕΑΤΡΙΚΗΣ ΠΑΡΑΣΤΑΣΗΣ.
     * @param code
     * @param title
     * @param leadActor
     * @param venue
     * @param date 
     */
    public TheaterPlay(String code, String title, String leadActor, String venue,LocalDate date) 
    {
        this.code = code;
        this.title = title;
        this.leadActor = leadActor;
        this.venue = venue;
        this.date = date;
      
    }
    /** GETTER ΓΙΑ ΚΩΔΙΚΟ.
     * @return  
     */
    public String getCode() {
        return code;
    }
    /** GETTER ΓΙΑ ΤΙΤΛΟ.
     * @return  
     */
    public String getTitle() {
        return title;
    }
    /** GETTER ΓΙΑ ΠΡΟΤΑΓΩΝΙΣΤΗ.
     * @return  
     */
    public String getLeadActor() {
        return leadActor;
    }
    /** GETTER ΓΙΑ VENUE .
     * @return  
     */
    public String getVenue() {
        return venue;
    }
    /** GETTER ΓΙΑ ΗΜΕΡΟΜΗΝΙΑ.
     * @return  
     */
    public LocalDate getDate() {
        return date;
    }
    /** SETTER ΓΙΑ ΚΩΔΙΚΟ.
     * @param code       
     */
    public void setCode(String code) {
        this.code = code;
    }
    /** SETTER ΓΙΑ ΤΙΤΛΟ.
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /** SETTER ΓΙΑ ΠΡΟΤΑΓΩΝΙΣΤΗ
     * @param leadActor
     */
    public void setLeadActor(String leadActor) {
        this.leadActor = leadActor;
    }
    /** SETTER ΓΙΑ VENUE.
     * @param venue
     */
    public void setVenue(String venue) {
        this.venue = venue;
    }
    /** SETTER ΓΙΑ ΗΜΕΡΟΜΗΝΙΑ.
     * @param date     
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public void fullPrintTheaterPlayinfo()
    {
        System.out.println("Κωδικός: " + code + ", Τίτλος: " + title + ", Πρωταγωνιστής: " + leadActor + ", Χώρος: " + venue + ", Ημερομηνία: " + date);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
    }
    
} 