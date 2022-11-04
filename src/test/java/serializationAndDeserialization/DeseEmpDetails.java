package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassSerializationAndDeserialization.EmployeeDetails;

public class DeseEmpDetails {
	@Test
	public void main1() throws JsonParseException, JsonMappingException, IOException {
		// create object for objmapper
		ObjectMapper obj=new ObjectMapper();
		
		EmployeeDetails e1 = obj.readValue(new File("./employeeDetails.json"), EmployeeDetails.class);
		
		System.out.println(e1.geteName());
		System.out.println(e1.getEmail());

	}

}
