package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import main.Game;

/**
 * TRON PROJECT
 * 
 * @author lborruto
 * @version 1.0
 */
public class Database {

	/**
	 * 
	 * Set the database communication to write the winner and the time
	 * 
	 */
	public void Database() {

		try {
			System.out.println(Game.temps);
			System.out.println(Game.winner);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String URL = "jdbc:mysql://localhost:3306/tron?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String USER = "root";
			String PASS = "";

			// Connection to the Database
			Connection conn = DriverManager.getConnection(URL, USER, PASS);

			// Statement to set our variables
			PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO score(player, time) VALUES(?, ?)");
			preparedStatement.setObject(1, Game.winner, Types.CHAR);
			preparedStatement.setObject(2, Game.temps, Types.DOUBLE);
			preparedStatement.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
