import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        //String url = "jdbc:mysql://localhost:3306/cars?serverTimezone=UTC";
        //String user = "root";
        //String password = "123";

        String url = "jdbc:h2:mem:";
        try (
                //Connection connection = DriverManager.getConnection(url, user, password);
                Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement()
        ) {
            statement.execute("CREATE TABLE users(id bigint, name varchar(20), age int);");
            statement.execute("INSERT INTO users (id, name, age) values (1, 'Ivan', 32)");
            statement.execute("INSERT INTO users (id, name, age) values (2, 'Vovan', 22)");
            ResultSet resultSet = statement.executeQuery("select count(*) from users");
            while (resultSet.next()) {
                int anInt = resultSet.getInt(1);
                System.out.println(anInt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
