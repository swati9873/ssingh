package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassSerializationAndDeserialization.EmployeeDetails;

public class serializationEmpDetails {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		// create object for pojo class
		EmployeeDetails emp=new EmployeeDetails("swatha", "TYSS007", "41852", "asdfg@gmail.com", "bangalore");
		
		//create object for object mapper
		ObjectMapper obj=new ObjectMapper();
		
		//write the values
		obj.writeValue(new File("./employeeDetails.json"), emp);

	}

}
