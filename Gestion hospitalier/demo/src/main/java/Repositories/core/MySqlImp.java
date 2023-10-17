// MySqlImp.java
package Repositories.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySqlImp implements ITables<Categorie> {
    private static final String INSERT_SQL = "INSERT INTO categories (libelle) VALUES (?)";
    private static final String UPDATE_SQL = "UPDATE categories SET libelle = ? WHERE id = ?";
    private static final String SELECT_ALL_SQL = "SELECT id, libelle FROM categories";
    private static final String SELECT_BY_ID_SQL = "SELECT id, libelle FROM categories WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM categories WHERE id = ?";

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    @Override
    public int insert(Categorie data) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, data.getLibelle());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    data.setId(generatedKeys.getInt(1));
                }
            }
            return rowsAffected;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(Categorie data) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            statement.setString(1, data.getLibelle());
            statement.setInt(2, data.getId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public ArrayList<Categorie> findAll() {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL);
             ResultSet resultSet = statement.executeQuery()) {
            ArrayList<Categorie> categories = new ArrayList<>();
            while (resultSet.next()) {
                Categorie categorie = new Categorie();
                categorie.setId(resultSet.getInt("id"));
                categorie.setLibelle(resultSet.getString("libelle"));
                categories.add(categorie);
            }
            return categories;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Categorie findById(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_SQL)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Categorie categorie = new Categorie();
                    categorie.setId(resultSet.getInt("id"));
                    categorie.setLibelle(resultSet.getString("libelle"));
                    return categorie;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int delete(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int indexOf(int id) {
        ArrayList<Categorie> categories = findAll();
        for (int i = 0; i < categories.size(); i++) {
             if (categories.get(i).getId() == id) {
                return i;
            }
        }
        return -1; // Retourne -1 si l'ID n'est pas trouvé
    }
}