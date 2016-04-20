package main.java.services.recipe;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.Command.Createuser;
import main.java.model.User;

@Path("/User")
public class UserServices {
	
	ObjectMapper mapper = new ObjectMapper();

	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response post(@FormParam("fname") String firstName,
			@FormParam("lname") String lastName,@FormParam("password") String password) {
		User u = new User();
		u.setfirstName(firstName);
		u.setlastName(lastName);
		u.setpassWord(password);
		
		Createuser cmd = new Createuser();
		return Response.ok( cmd.execute(u))
				.build();
	}
	}


