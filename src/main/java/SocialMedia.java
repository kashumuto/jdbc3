import java.sql.*;

public class SocialMedia {

    public Long authorization(String login, String password) {
        Long id = 0L;
        try {
            String url = "jdbc:postgresql://localhost:5432/jdbc3";
            String usernameDB = "postgres";
            String passwordDB = "postgres";

            try (Connection conn = DriverManager.getConnection(url, usernameDB, passwordDB)) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT id FROM users " +
                        "where login = '" + login + "' and password = '" + password + "' ;");
                while (resultSet.next()) {
                    id = resultSet.getLong("id");
                }
            }
        } catch (Exception ex) {
            System.out.println("Неудачная попытка авторизации...");
            System.out.println(ex);
        }
        return id;
    }


    public boolean registration(Users user) {
        boolean susses = false;

        try {
            String url = "jdbc:postgresql://localhost:5432/jdbc3";
            String username = "postgres";
            String password = "postgres";

            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String SQL = "INSERT INTO users (login, email, password, date_of_registration) VALUES (?, ?, ?, ?)";

                PreparedStatement preparedStatement = conn.prepareStatement(SQL);
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.setTimestamp(4, user.getDateOfRegistration());

                int rows = preparedStatement.executeUpdate();
                System.out.printf("%d rows added", rows);
                if (rows > 0) susses = true;
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
        return susses;
    }

    public boolean saveUsersLog(UserLogs userLog) {
        boolean susses = false;

        try {
            String url = "jdbc:postgresql://localhost:5432/jdbc3";
            String username = "postgres";
            String password = "postgres";

            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String SQL = "INSERT INTO user_logs (user_id, date_of_authorization, success) VALUES (?, ?, ?)";

                PreparedStatement preparedStatement = conn.prepareStatement(SQL);
                preparedStatement.setLong(1, userLog.getUserId());
                preparedStatement.setTimestamp(2, userLog.getDateOfAuthorization());
                preparedStatement.setBoolean(3, userLog.getSuccess());

                int rows = preparedStatement.executeUpdate();
                System.out.printf("%d rows added (saveUsersLog)", rows);
                if (rows > 0) susses = true;
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
        return susses;
    }


}
