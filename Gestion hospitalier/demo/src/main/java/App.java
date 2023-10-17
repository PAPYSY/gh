import java.util.Scanner;

import com.example.ism.Entities.Patient;
import com.example.ism.Repositories.*;
import Repositories.PatientRepository;
import Repositories.IMP.PatientRepositoryImpl;
import services.PersonneService;
import services.RvRepository;
import services.RvService;
import services.RvService.DefaultRvService;

public class App {
    public static void main(String[] args) {
        // Création des repositories
        PatientRepositoryImpl patientRepository = new PatientRepositoryImpl();
        MedecinRepositoryImpl medecinRepository = new MedecinRepositoryImpl();

        // Création des services
        App.PatientService patientService = new PatientService(patientRepository);
        MedecinService medecinService = new MedecinService();
        RvRepository rvRepository = new RvRepository();
        RvService rvService = new DefaultRvService(rvRepository);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Créer patient");
            System.out.println("2. Créer médecin");
            System.out.println("3. Planifier un Rv");
            System.out.println("4. Afficher les Rv du jour");
            System.out.println("5. Afficher les Rv d'un médecin par jour");
            System.out.println("6. Annuler un Rv");
            System.out.println("7. Quitter");
            System.out.print("Choisissez une option : ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Entrez le nom du patient : ");
                    String nom = scanner.next();
                    System.out.print("Entrez le prénom du patient : ");
                    String prenom = scanner.next();

                    // Création d'un nouvel objet Patient
                    Patient patient = new Patient();

                    // Appel de la méthode save du service PatientService
                    ((PatientRepository) patientService).save(patient);

                    System.out.println("Patient créé avec succès !");
                    break;
                case 2:
                    // Code pour créer un médecin
                    break;
                case 3:
                    // Code pour planifier un Rv
                    break;
                case 4:
                    // Code pour afficher les Rv du jour
                    break;
                case 5:
                    // Code pour afficher les Rv d'un médecin par jour
                    break;
                case 6:
                    // Code pour annuler un Rv
                    break;
                case 7:
                    System.out.println("Au revoir !");
                    System.exit(0);
            }
        }
    }
    public class PatientService extends PersonneService {
    public PatientService(PatientRepositoryImpl patientRepository) {
    }

    // Autres méthodes de la classe PatientService
}
}