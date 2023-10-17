package entities;
import java.time.LocalDateTime;
import com.example.ism.Entities.Medecin;
import com.example.ism.Entities.Patient;;

public class RendezVous {
    private int id;
    private Patient patient;
    private Medecin medecin;
    private LocalDateTime dateHeure;
     // getter method for id
    public int getId() {
        return this.id;
    }

    // setter method for id
    public void setId(int id) {
        this.id = id;
    }
     // getter and setter for patient
    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // getter and setter for medecin
    public Medecin getMedecin() {
        return this.medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }
     public LocalDateTime getDateHeure() {
        return this.dateHeure;
    }

    public void setDateHeure(LocalDateTime dateHeure) {
        this.dateHeure = dateHeure;
    }
    // rest of your code
}