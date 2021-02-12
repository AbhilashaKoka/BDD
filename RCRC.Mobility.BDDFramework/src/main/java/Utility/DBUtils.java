package Utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBUtils
{   

    public Connection getConnection(final String jdbcDriver, final String username, final String password, final String jdbcUrl) throws Exception
    {
     // Instantiate driver instance.
        try {
            Class.forName(jdbcDriver).newInstance();
            }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new Exception("Unable to get driver instance.", e);
        }
        // Connect to the database
        try (Connection databaseConnection = java.sql.DriverManager.getConnection(jdbcUrl, username, password)) 
        {
            System.out.println("JDBC driver loaded");
            System.out.println("Connected to the database");
            return java.sql.DriverManager.getConnection(jdbcUrl, username, password);
        } 
        catch (SQLException e) {
            throw new Exception("Unable to connect to Sql Server.", e);
        }
    }

    public ResultSet executeSqlQuery(final Statement stmt, final String sqlQuery) throws Exception {
        ResultSet rSet = null;
        try {
            rSet = stmt.executeQuery(sqlQuery);
        } 
        catch (final SQLException e)
        {
            throw new Exception("Failed to execute sql query.", e);
        }
        return rSet;
    }

    public void executeSqlUpdateQuery(final Statement stmt, final String sqlQuery) throws Exception {
        try {
            stmt.executeUpdate(sqlQuery);
        } 
        catch (final SQLException e) 
        {
            throw new Exception("Failed to update sql query.", e);
        }
    }

    public Statement executeSqlStatement(final Connection connection) throws Exception {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } 
        catch (final SQLException e) 
        {
            throw new Exception("Failed to execute sql statement.", e);
        }
        return statement;
    }

    public void closeConnection(final Connection connection) throws Exception {
        try {
            connection.close();
        } 
        catch (final SQLException e) 
        {
            throw new Exception("Failed to close sql connection.", e);
        }
    }
}