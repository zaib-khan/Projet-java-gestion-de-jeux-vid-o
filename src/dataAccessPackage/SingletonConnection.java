package dataAccessPackage;

import exceptionPackage.ConnexionException;

import java.sql.*;


public class SingletonConnection {

    private static Connection connection;

    public static Connection getInstance() throws ConnexionException {

        if (connection == null) {
            try {

                //-Adrien Leboutte
                //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdmagasinjava2019?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","chevresommiere");

                //Zaib Khan
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdjava2019magasinjeu?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","zaib123");
            }
            catch (SQLException exception) {
                throw new ConnexionException();
            }
        }
        return connection;
    }


}




