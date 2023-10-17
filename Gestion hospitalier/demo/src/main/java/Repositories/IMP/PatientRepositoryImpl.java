package Repositories.IMP;

import com.example.ism.Entities.Patient;

import Repositories.PatientRepository;
import Repositories.Personne;

public class PatientRepositoryImpl extends PersonneRepositoryImpl implements PatientRepository {
    // implémentation de la méthode findById(int)
    @Override
    public Personne findById(int id) {
        // Ajoutez votre implémentation ici
        // Retournez l'objet Personne en fonction de l'id donné
        return null; // Remplacez null par l'objet Personne correspondant à l'id donné
    }

    @Override
    public void save(Personne personne) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void save(Patient patient) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    // implémentation des autres méthodes spécifiques à PatientRepository
}