package services;
import entities.RendezVous;

public interface RvService{
    void planifierRv(RendezVous rv);
    void annulerRv(int id);
    List<RendezVous> getRvDuJour();
    List<RendezVous> getRvParMedecin(int medecinId);
RvRepository rvRepository = new RvRepository(); // Replace ConcreteRvRepository with the actual implementation class
RvService rvService = new DefaultRvService(rvRepository);
    // autres méthodes communes à toutes les classes qui implémentent cette interface

public class DefaultRvService implements RvService {
    private RvRepository rvRepository;

    public DefaultRvService(RvRepository rvRepository) {
        this.rvRepository = rvRepository;
    }

    @Override
    public void planifierRv(RendezVous rv) {
        // Implémentation de la méthode planifierRv
    }

    @Override
    public void annulerRv(int id) {
        // Implémentation de la méthode annulerRv
    }

    @Override
    public List<RendezVous> getRvDuJour() {
        // Implémentation de la méthode getRvDuJour
    }

    @Override
    public List<RendezVous> getRvParMedecin(int medecinId) {
        // Implémentation de la méthode getRvParMedecin
    }
}
}