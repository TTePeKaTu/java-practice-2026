package ru.itis.shop.app;

import ru.itis.shop.infrastructure.persistence.jdbc.DriverManagerDataSource;
import ru.itis.shop.user.api.UserConsoleOperations;
import ru.itis.shop.user.application.UserService;
import ru.itis.shop.user.infrastructure.persistence.jdbc.UserRepositoryJdbcImpl;
import ru.itis.shop.user.repository.UserRepository;

import javax.sql.DataSource;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        ru.itis.shop.util.PropertiesReader propertiesReader = new ru.itis.shop.util.PropertiesReader("application.properties");

        Properties properties = propertiesReader.loadProperties();

        System.out.println(properties.getProperty("db.url"));

        DataSource dataSource = new DriverManagerDataSource(
                "jdbc:postgresql://localhost:5432/java_2026",
                "postgres",
                "Manstera01"
        );

        UserRepository userRepository = new UserRepositoryJdbcImpl(dataSource);
        UserService userService = new UserService(userRepository);
        UserConsoleOperations console = new UserConsoleOperations(userService);

        console.showMenu();
    }
}