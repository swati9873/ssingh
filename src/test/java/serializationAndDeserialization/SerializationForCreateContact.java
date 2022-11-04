package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassSerializationAndDeserialization.CreateContact;
import pojoClassSerializationAndDeserialization.Family;

public class SerializationForCreateContact {
	@Test
	public void pojoSerialization() throws JsonGenerationException, JsonMappingException, IOException
	{   int[]phno= {1234,5678};
	    String[]relatedname= {"swat","def"};
	    int[]phno1= {3456,9876};
	    String[]email= {"swa@g","abc@g"};
	    Family f=new Family("priya",phno1,email);
		CreateContact obj=new CreateContact("swa", "sin",phno, "swat@78gmail.com", "abc", "httsdf45t6", "fgvhjf", "12/08/1994", "single",relatedname, f);
	    ObjectMapper obj1=new ObjectMapper();
	    obj1.writeValue(new File("./CreateContact.json"),obj);
	}

}
