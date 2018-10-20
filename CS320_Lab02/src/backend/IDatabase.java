package backend;

import java.sql.SQLException;

//import entity.Item;

public interface IDatabase {
	//boolean registerAccount(String username, String password, String email) throws SQLException;
	
	//int createArea(String name, String para, ArrayList<String> options) throws SQLException;
	boolean accountExist(String username, String password);
	boolean registerAccount(String userName, String pass, String email, String name, String gender, String age, String location) throws SQLException;
	void printDB(String dbName);
	//ArrayList<String> getArea(String id) throws SQLException;
	
	//void insertPlayerLocation(String area);
	
	//String checkAccess(String username);

}