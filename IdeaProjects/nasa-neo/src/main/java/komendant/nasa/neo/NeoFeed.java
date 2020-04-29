package komendant.nasa.neo;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;

public class NeoFeed {

    @SerializedName("near_earth_objects")
    HashMap<String, List<NearEarthObjects>> nearEarthObjects;

    class NearEarthObjects{
        String id;
        String name;
        @SerializedName("nasa_jpl_url")
        String nasaJplUrl;
        @SerializedName("is_potentially_hazardous_asteroid")
        boolean hazardous;
    }
}
