package ru.itis.shop.app;

import ru.itis.shop.user.api.UserConsoleOperations;
import ru.itis.shop.user.application.UserService;
import ru.itis.shop.user.infrastructure.persistence.UserRepositoryJdbcImpl;
import ru.itis.shop.user.repository.UserRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main{

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/java_2026";

    private static final String DB_USER = "proverka";

    private static final String DB_PASSWORD = "0123456789";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println(connection);

            UserRepository userRepository = new UserRepositoryJdbcImpl(connection);
            UserService userService = new UserService(userRepository);

            UserConsoleOperations operations = new UserConsoleOperations(userService);

            while (true) {
                operations.showMenu();
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}