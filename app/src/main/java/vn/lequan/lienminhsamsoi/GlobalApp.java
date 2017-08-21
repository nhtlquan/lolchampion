package vn.lequan.lienminhsamsoi;

import retrofit2.Retrofit;
import vn.lequan.lienminhsamsoi.API.Model.MasteryTree.MasteryTree;

/**
 * Created by admin on 15/08/2016.
 */
public class GlobalApp {
    public Retrofit retrofit, retrofit1, retrofit2;
    public String region = "VN";
    public MasteryTree masteryTree;

    private static GlobalApp ourInstance = new GlobalApp();

    public static GlobalApp getInstance() {
        return ourInstance;
    }
}
