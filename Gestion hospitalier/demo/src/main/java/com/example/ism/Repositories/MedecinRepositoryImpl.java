package com.example.ism.Repositories;


import java.util.List;

import com.example.ism.Entities.Medecin;

public class MedecinRepositoryImpl implements MedecinRepository<Medecin> {
    @Override
public void insert(Medecin medecin) {
    // Connexion à la base de données
    Connection connection = // obtenir la connexion à la base de données

    // Préparer la requête SQL
    String sql = "INSERT INTO medecins (nom, specialite) VALUES (?, ?)";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, medecin.getNom());
    statement.setString(2, medecin.getSpecialite());

    // Exécuter la requête
    statement.executeUpdate();

    // Fermer la connexion et les ressources
    statement.close();
    connection.close();
}

    @Override
public void update(Medecin medecin) {
    // Connexion à la base de données
    Connection connection = // obtenir la connexion à la base de données

    // Préparer la requête SQL
    String sql = "UPDATE medecins SET nom = ?, specialite = ? WHERE id = ?";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, medecin.getNom());
    statement.setString(2, medecin.getSpecialite());
    statement.setInt(3, medecin.getId());

    // Exécuter la requête
    statement.executeUpdate();

    // Fermer la connexion et les ressources
    statement.close();
    connection.close();
}

@Override
public void delete(int id) {
    // Connexion à la base de données
    Connection connection = // obtenir la connexion à la base de données

    // Préparer la requête SQL
    String sql = "DELETE FROM medecins WHERE id = ?";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setInt(1, id);

    // Exécuter la requête
    statement.executeUpdate();

    // Fermer la connexion et les ressources
    statement.close();
    connection.close();
}

    @Override
public Medecin findById(int id) {
    // Connexion à la base de données
    Connection connection = // obtenir la connexion à la base de données

    // Préparer la requête SQL
    String sql = "SELECT * FROM medecins WHERE id = ?";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setInt(1, id);

    // Exécuter la requête
    ResultSet resultSet = statement.executeQuery();

    // Vérifier si un médecin a été trouvé
    if (resultSet.next()) {
        // Créer un nouvel objet Medecin avec les données du résultat
        Medecin medecin = new Medecin();
        medecin.setId(resultSet.getInt("id"));
        medecin.setNom(resultSet.getString("nom"));
        medecin.setSpecialite(resultSet.getString("specialite"));

        // Fermer le résultat, la requête, la connexion et les ressources
        resultSet.close();
        statement.close();
        connection.close();

        // Retourner le médecin trouvé
        return medecin;
    } else {
        // Aucun médecin trouvé, retourner null
        // Fermer le résultat, la requête, la connexion et les ressources
        resultSet.close();
        statement.close();
        connection.close();

        return null;
    }
}

   @Override
public List<Medecin> findAll() {
    // Connexion à la base de données
    Connection connection = // obtenir la connexion à la base de données

    // Préparer la requête SQL
    String sql = "SELECT * FROM medecins";
    PreparedStatement statement = connection.prepareStatement(sql);

    // Exécuter la requête
    ResultSet resultSet = statement.executeQuery();

    // Créer une liste pour stocker les médecins trouvés
    List<Medecin> medecins = new ArrayList<>();

    // Parcourir les résultats et créer des objets Medecin correspondants
    while (resultSet.next()) {
        Medecin medecin = new Medecin();
        medecin.setId(resultSet.getInt("id"));
        medecin.setNom(resultSet.getString("nom"));
        medecin.setSpecialite(resultSet.getString("specialite"));

        // Ajouter le médecin à la liste
        medecins.add(medecin);
    }

    // Fermer le résultat, la requête, la connexion et les ressources
    resultSet.close();
    statement.close();
    connection.close();

    // Retourner la liste des médecins trouvés
    return medecins;
}
  @Override
public void insert(Medecin medecin) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'insert'");
}

@Override
public void insert(Medecin medecin) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'insert'");
}

@Override
public void insert(Object medecin) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'insert'");
}
}
