package vn.lequan.lienminhsamsoi.http;

import java.io.IOException;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class GetDataChamp {
    private static final String API_URL = "https://ddragon.leagueoflegends.com";
    private GetVersionData service = ((GetVersionData) new Builder().baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create()).build().create(GetVersionData.class));

    interface GetVersionData {
        @GET("/api/versions.json")
        Call<List<String>> getVersion();
    }

    public String getVersion() {
        try {
            return (String) ((List) this.service.getVersion().execute().body()).get(0);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
