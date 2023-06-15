package stepDefinitions;

import io.cucumber.java.Before;



public class hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws Exception {
        stepDefinition sd = new stepDefinition();

        if (stepDefinition.place_id == null)
        {
            sd.add_place_payload();
            sd.user_calls_with_http_request("AddPlaceAPI", "Post");
            sd.verify_place_id_created_using("getPlaceAPI");
        }



    }
}
