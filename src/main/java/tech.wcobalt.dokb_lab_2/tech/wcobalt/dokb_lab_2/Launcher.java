package tech.wcobalt.dokb_lab_2;

import com.mysql.cj.jdbc.MysqlDataSource;
import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.Stage;
import org.apache.logging.log4j.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Launcher {
    public static void main(String... args) {
        LogManager.getLogger(Launcher.class).info("blyat pizda prosto");
        System.out.println("Hello");
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("dokb_lab_2_db");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setServerName("localhost");

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT `id` FROM `companies`;");

            while (!resultSet.isLast()) {
                resultSet.next();
                System.out.println(resultSet.getInt("id"));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        new Application(){
            @Override
            public void start(Stage stage) throws Exception {

            }
        };
    }
}
