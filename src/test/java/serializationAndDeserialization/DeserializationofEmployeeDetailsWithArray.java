package serializationAndDeserialization;

import java.io.File;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassSerializationAndDeserialization.EmployeeDetailsWithArray;


public class DeserializationofEmployeeDetailsWithArray {
	@Test
	public void deserializationEmpDetailsWithTest() throws Throwable, Throwable, Throwable
	{
		//step1:create the object for object mapper
		ObjectMapper obj =new ObjectMapper();
		//step2:read the value from object mapper
		EmployeeDetailsWithArray e1 = obj.readValue(new File("./EmployeeDetailsWithArray.json"), EmployeeDetailsWithArray.class);
	    //fetch the required value
		String[] value=e1.getPhoneNo();
		for(String string:value) {
			System.out.println(string);
			
		}

}
}
