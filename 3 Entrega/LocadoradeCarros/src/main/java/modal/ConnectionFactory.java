package modal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection conectaBD() throws SQLException {
		
        String connectionUrl = "jdbc:sqlserver://fluffyapi.database.windows.net:1433;databaseName=API;user=fluffyapifatec;password=Fluffyapi123";


        Connection con = DriverManager.getConnection(connectionUrl);

        return con;
        }
	}





