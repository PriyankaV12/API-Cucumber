package POJO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;

public class dataReader {

    public static ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());


    public static baseDataGS readData() throws Exception {
        File file = new File(  System.getProperty("user.dir") + "/src/main/java/POJO/data.yaml");
        baseDataGS data=objectMapper.readValue(file,baseDataGS.class);
        return data;
    }
}
