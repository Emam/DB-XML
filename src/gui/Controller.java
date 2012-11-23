package gui;

import java.sql.SQLException;

public class Controller {
	
	private String path;
	private Query SQL;
	private String currentUser;
	private static Controller controller;
	
	public static synchronized Controller getInstance() throws SQLException {
		if (controller == null)
			throw new SQLException();
		else {
			return controller;
		}
	}
	
	public static synchronized Controller getInstance(String url) {
		if (controller == null)
			return new Controller(url);
		else {
			controller.path = url;
			return controller;
		}
	}
	
	private Controller(String pathP){
		path=pathP;
	}
	
	public boolean logIn(String user,String pass){
		//select user
		//check pass
		currentUser=user;
		return false;
	}
	
	public boolean newUser(String user,String pass){
		//select user
		//create folder of user
		//new user & pass
		return false;
	}
	
	public boolean logOut(){
		currentUser=null;
		return false;
	}
	
	public String[][] sendSQL(String sql){
		if(currentUser!=null){
			//create statement
			SQL.setSQL(sql);
			//wait for its result
		}
		return null;
	}
	
	public void close() {
		controller = null;
	}
}
