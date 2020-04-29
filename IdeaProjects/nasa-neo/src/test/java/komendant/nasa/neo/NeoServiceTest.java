package komendant.nasa.neo;

import org.junit.Test;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class NeoServiceTest {

    @Test
    public void getAsteroids() throws IOException {
        //given
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NeoService service = retrofit.create(NeoService.class);

        //when
        NeoFeed feed = service.getAsteroids().execute().body();

        //then
        assertNotNull(feed);
        HashMap<String, List<NeoFeed.NearEarthObjects>> nearEarthObjects = feed.nearEarthObjects;
        assertFalse(nearEarthObjects.isEmpty());
        NeoFeed.NearEarthObjects neo = nearEarthObjects.get("2020-04-28").get(0);
        assertNotNull(neo);

        assertNotNull(neo.id);

        assertNotNull(neo.name);
        assertNotNull(neo.nasaJplUrl);
    }


}