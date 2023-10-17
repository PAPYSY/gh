package Repositories.IMP;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import com.example.Personne; // Remplacez com.example par le nom réel du package de la classe Personne

import com.example.ism.Entities.Personne;


public class PersonneRepositoryImpl {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/nom_de_la_base_de_donnees";
    private static final String DB_USER = "utilisateur";
    private static final String DB_PASSWORD = "mot_de_passe";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void save(Personne personne) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO personnes (id, nom, prenom) VALUES (?, ?, ?)")) {

            statement.setInt(1, personne.getId());
            statement.setString(2, personne.getNom());
            statement.setString(3, personne.getPrenom());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Personne findById(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT id, nom, prenom FROM personnes WHERE id=?")) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int personneId = resultSet.getInt("id");
                    String nom = resultSet.getString("nom");
                    String prenom = resultSet.getString("prenom");

                    return new Personne(personneId, nom, prenom);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Personne> findAll() {
        List<Personne> personnes = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT id, nom, prenom FROM personnes");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int personneId = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");

                personnes.add(new Personne(personneId, nom, prenom));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personnes;
    }
}