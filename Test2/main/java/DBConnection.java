package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Double checked singleton class (singleton means that only one instance of this class could be
 * created) getting database connection.
 * 
 * @author Pavel �eda (154208)
 *
 */
public class DBConnection {

  private static volatile Connection dbConnection;

  private DBConnection() {}

  public static Connection getDBConnection() {
    if (dbConnection == null) {
      synchronized (DBConnection.class) {
        if (dbConnection == null) {
          try {
            Class.forName("java.sql.Driver");
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/projekt_db?user=root&password=heslo");
          } catch (SQLException | ClassNotFoundException e) {
          }
        }
      }
    }
    return dbConnection;
  }

  public static void closeConnection() {
    try {
      dbConnection.close();
    } catch (SQLException e) {
  }

  

}
}
