package projectResources;

import POJO.baseClass;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class utils extends baseClass {

    public static RequestSpecification request;
    public static ResponseSpecification response;


    public utils() throws Exception {
    }

    public static RequestSpecification requestSpecifications() throws FileNotFoundException
    {
        if (request == null)
        {
            PrintStream log = new PrintStream(new FileOutputStream("Logging.txt"));
            request = new RequestSpecBuilder().setBaseUri(data.getBaseURI())
                    .addQueryParam(data.getQueryKey(), data.getQueryValue()).setContentType(ContentType.JSON)
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .build();
            return request;
        }
        return request;
    }

    public static ResponseSpecification responseSpecifications()
    {
        response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
                .build();

        return response;
    }

    public String jsonPathFunctionality(Response res , String key)
    {

        String values = res.asString();
        JsonPath js  = new JsonPath(values);

        return js.getString(key);

    }

}
