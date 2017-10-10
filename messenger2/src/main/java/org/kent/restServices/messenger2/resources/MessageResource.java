package org.kent.restServices.messenger2.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kent.restServices.messenger2.model.Message;
import org.kent.restServices.messenger2.service.MessageService;

@Path("/messages") //Step 4
public class MessageResource {
	
	//Step 1 Add new Class
	//Step 2 add a method that returns the response
	//Step 3 Make sure your class is in the package configured in Jersey servlet's 
	//init-param(check web.xml)
	//Step 4 Annotate class with @Path annotation
	//Step 5 Annotate method with the right HTTP method annotation i.e. @GET
	//Step 6 Annotate method with the @Produces specifying the response format
	
	MessageService messageService = new MessageService();
	
	@GET //Step 5
	@Produces(MediaType.APPLICATION_JSON) //Step 6
	public List<Message> getMessages() { //Step 2
		//return "Hello From " + getClass().getSimpleName();
		
		return messageService.getAllMessages();
	}
	
	//Implementing POST method
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}
	
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long messageId) {
		return messageService.getMessage(messageId);
		//return "Got path param " + messageId;
	}
	
	
	

}
