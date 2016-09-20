package application;

import java.sql.*;

public class PsychoModel {
	Connection connection;
	public PsychoModel(){
		connection = SQLiteConnection.Connector();
		if(connection == null)
			System.exit(1);
	}

	public boolean isDBConnected(){
		try {
			return !connection.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


}
