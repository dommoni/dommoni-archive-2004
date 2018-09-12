package jsfspike;

import java.util.Map;

import javax.faces.context.FacesContext;

import com.dommoni.roundtable.ProjectServerConnection;

public class LoginBacking {
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login() {
		try
		{
			ProjectServerConnection psc = 
				new ProjectServerConnection(username, password, "localhost", 8080);
			
			psc.login();
			
			FacesContext fc = FacesContext.getCurrentInstance();
			Map sessionMap = fc.getExternalContext().getSessionMap();
			sessionMap.put("psc", psc);
			
			return JSFConditions.SUCCESS;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return JSFConditions.FAILURE;
	}
}
