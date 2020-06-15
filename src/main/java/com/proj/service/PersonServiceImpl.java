package com.proj.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.proj.bean.Person;
import com.proj.bean.Response;


@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonServiceImpl implements PersonService {
	final static Logger logger = Logger.getLogger(PersonServiceImpl.class);
	
	private static Map<Integer,Person> persons = new HashMap<Integer,Person>();
	
	@Override
	@POST
    @Path("/add")
	public Response addPerson(Person p) {
		logger.info("Entered into addPerson method");
		Response response = new Response();
		if(persons.get(p.getId()) != null){
			logger.info("ID exist :"+p.getId());
			response.setStatus(false);
			response.setMessage("Person Already Exists");
			return response;
		}
		persons.put(p.getId(), p);
		response.setStatus(true);
		response.setMessage("Person created successfully");
		
		logger.warn("End");
		return response;
	}

	@Override
	@DELETE
    @Path("/{id}/delete")
	public Response deletePerson(@PathParam("id") int id) {
		Response response = new Response();
		if(persons.get(id) == null){
			response.setStatus(false);
			response.setMessage("Person Doesn't Exists");
			return response;
		}
		persons.remove(id);
		response.setStatus(true);
		response.setMessage("Person deleted successfully");
		return response;
	}
	

	@DELETE
    @Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		Response response = new Response();
		if(persons.get(id) == null){
			response.setStatus(false);
			response.setMessage("Person Doesn't Exists");
			return response;
		}
		persons.remove(id);
		response.setStatus(true);
		response.setMessage("Person deleted successfully");
		return response;
	}	

	@Override
	@GET
	@Path("/{id}/get")
	public Person getPerson(@PathParam("id") int id) {
		return persons.get(id);
	}
	
	@GET
	@Path("/helloworld")
	public String helloworld() {
		return "Hello World!";
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{id}/getxml")
	public Person getPersonXML(@PathParam("id") int id) {
		return persons.get(id);
	}	

	@GET
	@Path("/getperson")
	public Person getP(@QueryParam("id") int id,@QueryParam("name") String name,@QueryParam("age") int age) {
		System.out.println("The given value is  :"+id );
		System.out.println("The given name is :"+name );
		System.out.println("The given age is :"+age );
		
		
		return persons.get(id);
	}
	
	@GET
	@Path("/{id}/getDummy")
	public Person getDummyPerson(@PathParam("id") int id) {
		Person p = new Person();
		p.setAge(99);
		p.setName("Dummy");
		p.setId(id);
		return p;
	}

	@Override
	@GET
	@Path("/getAll")
	public Person[] getAllPersons() {
		Set<Integer> ids = persons.keySet();
		Person[] p = new Person[ids.size()];
		int i=0;
		for(Integer id : ids){
			p[i] = persons.get(id);
			i++;
		}
		return p;
	}
	

	@PUT
	@Path("/update/{id}")
	public Response updatePersons(@PathParam("id") int id,Person p) {
		Response response = new Response();
		if(id==0) {
			response.setMessage("Invalid ID");
		}else if(p==null ) {
			response.setMessage("Request body missing");
		}else if(!persons.containsKey(id)) {
			 response.setMessage("record doesnot exist");
		}else {
			persons.put(id,p);
			response.setMessage("record updated successfully");
			response.setStatus(true);
		}
		

		return response;
	}
	

}
