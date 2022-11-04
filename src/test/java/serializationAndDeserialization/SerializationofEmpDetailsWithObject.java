package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassSerializationAndDeserialization.EmployeeDetailWithObjectArray;
import pojoClassSerializationAndDeserialization.Spouse;

public class SerializationofEmpDetailsWithObject {
	@Test
	public void SerializationofEmpDetailsWithObjectTest() throws JsonGenerationException, JsonMappingException, IOException {
		String[] phoneNo= {"1212344","9876765"};
	Spouse s=new Spouse("swati",987654,"swati7250@gmail.com");
	EmployeeDetailWithObjectArray emp=new EmployeeDetailWithObjectArray("swati", "0987", phoneNo, "swati7250@gmail.com", "benglore",s);
	ObjectMapper obj=new ObjectMapper();
	obj.writeValue(new File("./name.json"), emp);
	

}
}