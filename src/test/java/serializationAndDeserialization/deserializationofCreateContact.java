package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassSerializationAndDeserialization.CreateContact;

public class deserializationofCreateContact {
	@Test
	public void deserializationofCreateContact() throws JsonParseException, JsonMappingException, IOException
	{
		//step1 create the object of object mapper
		ObjectMapper obj=new ObjectMapper();
		
		//read the value from object mapper
		CreateContact c1 = obj.readValue(new File("CreateContact.json"), CreateContact.class);
		
		System.out.println(c1.getCompanyname());
		System.out.println(c1.getAddress());
		System.out.println(c1.getFn());
		System.out.println(c1.getLn());
		System.out.println(c1.getEmail());
		System.out.println(c1.getUrl());
	}

}
