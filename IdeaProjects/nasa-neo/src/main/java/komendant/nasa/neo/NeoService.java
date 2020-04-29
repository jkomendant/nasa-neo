package komendant.nasa.neo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NeoService {

    @GET("/neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&api_key=DEMO_KEY\n")
    Call<NeoFeed> getAsteroids(@Query("start_date") String startDat, @Query("end_date") String endDate);

    @GET("https://api.nasa.gov/neo/rest/v1/neo/3542519?api_key+DEMO_KEY")
    Call<NeoFeed.NearEarthObjects> getAsteroid(@Path("id") String id);

}
