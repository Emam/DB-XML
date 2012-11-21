
public class Controller {

	private String path;
	private SQLStatement SQL;
	private String currentUser;
	public Controller(String pathP){
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
		//new user & pass
		return false;
	}
	
	public boolean logOut(String user){
		currentUser=null;
		return false;
	}
	
	public Object[][] sendSQL(String sql){
		if(currentUser!=null){
			//create statement
			//wait for its result
		}
		return null;
	}
}
