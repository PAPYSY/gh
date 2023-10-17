package entities;

public class AbstractEntities extends com.example.ism.Entities.Personne {
    public AbstractEntities(int id, String nom, String prenom) {
        super(id, nom, prenom);
        //TODO Auto-generated constructor stub
    }

    protected int id;
    protected String nom;

    // getters et setters pour chaque attribut

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void afficherInformations() {
    System.out.println("ID : " + id);
    System.out.println("Nom : " + nom);
    System.out.println("Prénom : " + prenom);
}
}