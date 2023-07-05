package CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDOperations {
    public void create(String nome, int idade) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO pessoa (nome, idade) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nome);
            statement.setInt(2, idade);
            statement.executeUpdate();
            System.out.println("Registro criado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar registro: " + e.getMessage());
        }
    }

    public void read() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM pessoa";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                int idade = resultSet.getInt("idade");
                System.out.println("Nome: " + nome + ", Idade: " + idade);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao ler registros: " + e.getMessage());
        }
    }
    public void update(String nomeAntigo, String nomeNovo) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE pessoa SET nome = ? WHERE nome = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nomeNovo);
            statement.setString(2, nomeAntigo);
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Registro atualizado com sucesso.");
            } else {
                System.out.println("Registro não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar registro: " + e.getMessage());
        }
    }
    
    public void delete(String nome) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM pessoa WHERE nome = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nome);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Registro excluído com sucesso.");
            } else {
                System.out.println("Registro nãoencontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir registro: " + e.getMessage());
        }
    }
}