package dbConnection;

public interface Provider {
	String DRIVER = "oracle.jdbc.driver.OracleDriver";
	String CONNECTION_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USERNAME = "monitoring";
	String PASSWORD = "twentyfifteen";

}