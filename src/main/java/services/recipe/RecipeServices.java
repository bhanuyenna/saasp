package main.java.services.recipe;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/recipe")
public class RecipeServices {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getRecipe() {
		return "Recipe will be returned here";
	}
}
