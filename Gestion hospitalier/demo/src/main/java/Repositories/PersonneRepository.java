package Repositories;
import java.util.List;

public interface PersonneRepository {
    void save(Personne personne);
    Personne findById(int id);
    List<Personne> findAll();
    // autres méthodes communes à toutes les classes qui implémentent cette interface
}

