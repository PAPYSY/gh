import com.example.ism.Entities.Patient;
import com.example.ism.Entities.Personne;

import Repositories.PatientRepository;
import services.PersonneService;

public class PatientService implements PersonneService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void save(Personne personne) {
        if (personne instanceof Patient) {
            Patient patient = (Patient) personne;
            patientRepository.save(patient);
        } else {
            throw new IllegalArgumentException("Invalid personne type");
        }
    }

    @Override
    public void creerPersonne(String nom, String prenom) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creerPersonne'");
    }

    @Override
    public void save(Repositories.IMP.Personne personne) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    // Autres méthodes spécifiques au service PatientService
}