package services.recipe;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import Command.Createuser;
import Command.Deleteuser;
import Command.Listusers;
import Command.Updateuser;
import model.User;

//import main.java.Command.Createuser;
//import main.java.model.User;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("/user")
public class UserServices {

	ObjectMapper mapper = new ObjectMapper();

	@POST
	@Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response POST(String Newuser) {
		
		Createuser create = new Createuser();
		User u = null;
		String i = "";
		
		try {
			u=mapper.readValue(Newuser, User.class);	} 
	catch (Exception ex) {
		ex.printStackTrace();
		Response.status(400).entity("could not read string").build();
	}
		try{
			i = create.execute(u);
		}
	catch (Exception e) {
		return Response.status(500).entity(e.toString()).build();
	}
		return Response.status(200).entity(i).build();

	}
	
	
	
	
//get users by id	
	@GET
	@Path("{user_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getUser(@PathParam("user_id") int user_id) {
		Listusers command = new Listusers ();
		String newuser = null;
		try {
			newuser = mapper.writeValueAsString(command.execute(user_id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(newuser).build();
	}
	
//update user by id
	
	@PUT
	@Path("{user_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response updateUsers(String newuser, @PathParam("user_id") int user_id) {
		Updateuser update = new Updateuser();
		User u = null;
		String i = "";
		try {
			u = mapper.readValue(newuser, User.class);
			System.out.println("bhanu");
			u.setUser_id(user_id);
		} catch (Exception ex) {
			ex.printStackTrace();
			Response.status(400).entity("could not read string").build();
		}
		try {
			i=update.execute(u);
		} catch (Exception e) {
			e.printStackTrace();
			Response.status(500).build();
		}
		return Response.status(200).entity(i).build();
	}
	
	
	
//Delete user by id
	
	
	@DELETE
	@Path("{user_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Response deleteUsers(String newuser, @PathParam("user_id") int user_id){
		Deleteuser delete = new Deleteuser();
		User u = null;
		String i = "";
		try {
			u = mapper.readValue(newuser, User.class);
			u.setUser_id(user_id);
		} catch (Exception ex) {
			ex.printStackTrace();
			Response.status(400).entity("could not read string").build();
		}
		try {
			i=delete.execute(user_id);
		} catch (Exception e) {
			e.printStackTrace();
			Response.status(500).build();
		}
		return Response.status(200).entity(i).build();
	}
		
	
	
	
	
	
	}
	
	
	
	

	
	
	
	
	
	