package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassSerializationAndDeserialization.EmployeeDetails;

public class DeserializationOfEmployeeDetails {
	
	public void deserializationEmpDetailsTest() throws JsonParseException, JsonMappingException, IOException
	{
		//step1:create the object for object mapper
		ObjectMapper obj=new ObjectMapper();
		//step2 read the value from object mapper
		EmployeeDetails e1=obj.readValue(new File("./EmployeeDetails.json"),EmployeeDetails.class);
		//fetch the required value
		
		System.out.println(e1.geteName());
		e1.getAddress();
		e1.getClass();
		e1.getEmail();

}
}
