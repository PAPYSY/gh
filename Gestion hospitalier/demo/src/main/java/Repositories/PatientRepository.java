package Repositories;

import java.util.List;

import com.example.ism.Entities.Patient;
import com.example.ism.Entities.Personne; // Replace com.example with the actual package name

public interface PatientRepository extends PersonneRepository {
    void save(Patient patient);
    
    // autres méthodes pour interagir avec les données des patients
}

public class MySqlPatientRepository implements PatientRepository {

    @Override
    public void save(Repositories.Personne personne) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Repositories.Personne findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Repositories.Personne> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void save(Patient patient) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
    // implémentation des méthodes
}
