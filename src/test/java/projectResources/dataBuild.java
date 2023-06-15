package projectResources;

import POJO.Location;
import POJO.gettersSetters;

import java.util.ArrayList;
import java.util.List;

public class dataBuild {

    public  gettersSetters gs;

    public gettersSetters addPlacePayload()
    {
        gs = new gettersSetters();
        gs.setAccuracy(50);
        gs.setAddress("789, song bird cres, cohen 09");
        gs.setLanguage("French-IN");
        gs.setPhone_number("(+91) 983 893 3937");
        gs.setWebsite("http://google.com");
        gs.setName("Northern Lights House");
        List<String> myList = new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");

        gs.setTypes(myList);

        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);

        gs.setLocation(location);

        return gs;
    }


    public String deletePayload(String placeID)
    {

        return "{\r\n    \"place_id\": \"" + placeID + "\"\r\n}";
    }
}
