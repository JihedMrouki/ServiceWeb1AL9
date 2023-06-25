package com.serviceweb.serviceweb;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/employes")
public class HelloResource {
  static List<Employe> employes = new ArrayList<Employe>();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String addEmploye(Employe emp) {
		
		if(employes.add(emp))
			return "Employe ajout�";
		return "Employe non ajout�";
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)//"application/json"
	public List<Employe> getAllEmploye()
	{
		return employes;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateEmploye(Employe emp) {
		int index = employes.indexOf(emp);
		if(index != -1) {
			employes.set(index, emp);
			return "employ� modifi�";
		}
		return "employ� non modifi�";
	}
	
	@DELETE
	@Path("{a}")
	public boolean deleteEmploye(@PathParam("a") String cin)
	{
		Iterator<Employe>it = employes.iterator();
		while(it.hasNext()) {
			if(it.next().getCin().equals(cin));
			it.remove();
			return true;
		}
		return false;
	}
}