package com.niit.handler;


import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

//import com.niit.bean.User;
import com.niit.model.User;

@Component
public class RegistrationHandler {

	public User initFlow(){
		return new User();
	}
	


	public String validateDetails(User user,MessageContext messageContext){
		String status = "success";
		if(user.getName().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"name").defaultText("Name cannot be Empty").build());
			status = "failure";
			System.out.println("name pass");
		}
		if(user.getUserID().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"id").defaultText("UserId cannot be Empty").build());
			status = "failure";
			System.out.println("userid pass");
		}
		if(user.getPassword().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"password").defaultText("Password cannot be Empty").build());
			status = "failure";
			System.out.println("password pass");
		}
		if(user.getCpassword().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"cpassword").defaultText("Confirmed Password cannot be Empty").build());
			status = "failure";
			System.out.println("cpassword pass");
		}
		if(!user.getCpassword().equals(user.getPassword())){
			messageContext.addMessage(new MessageBuilder().error().source(
					"cpassword").defaultText("Passwords do not match").build());
			status = "failure";
			System.out.println("check password pass");
		}
		
			if(user.getEmailid().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"email").defaultText("Email cannot be Empty").build());
			status = "failure";
			System.out.println("emailid pass");
		}
		if(user.getMobileno().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"mobile").defaultText("Mobile No. cannot be Empty").build());
			status = "failure";
			System.out.println("mob pass");
		}
		if(user.getAddress().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"address").defaultText("Address cannot be Empty").build());
			status = "failure";
			System.out.println("address pass");
		}
		
		return status;
	}
}