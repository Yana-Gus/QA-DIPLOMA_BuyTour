package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {

    private static final QueryRunner runner = new QueryRunner();

    private SQLHelper() {
    }

    @SneakyThrows
    private static Connection getConn() {
        String dbUrl = System.getProperty("db.url");
        String user = System.getProperty("user");
        String password = System.getProperty("password");
        return DriverManager.getConnection(dbUrl, user, password);
    }

    @SneakyThrows
    public static String getStatusPayment() {
        var statusSQL = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        var conn = getConn();
        return runner.query(conn, statusSQL, new ScalarHandler<String>());
    }

    @SneakyThrows
    public static String getStatusCreditRequest() {
        var statusSQL = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";
        var conn = getConn();
        return runner.query(conn, statusSQL, new ScalarHandler<String>());
    }

    @SneakyThrows
    public static void cleanDatabase() {
        var connection = getConn();
        runner.execute(connection, "DELETE FROM payment_entity");
        runner.execute(connection, "DELETE FROM credit_request_entity");
    }
}
