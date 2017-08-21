package vn.lequan.lienminhsamsoi.API.Face;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import vn.lequan.lienminhsamsoi.API.Model.AccountID;
import vn.lequan.lienminhsamsoi.API.Model.History.History;
import vn.lequan.lienminhsamsoi.API.Model.MasteryTree.MasteryTree;
import vn.lequan.lienminhsamsoi.models.MatchDetail.MatchDetail;
import vn.lequan.lienminhsamsoi.models.VideoChampion.VideoChampion;

/**
 * Created by admin on 15/08/2016.
 */
public interface Face_AccountID {
    @GET("players")
    Call<AccountID> getAccountID(@Query("name") String name, @Query("region") String region);

    @GET("stats/player_history/{region}/{ID}")
    Call<History> getHistory(@Path("region") String region, @Path("ID") int ID, @Query("begIndex") int begIndex, @Query("endIndex") int endIndex);

    @GET("stats/player_history/{region}/{ID}")
    Call<History> getHistoryWithChampion(@Path("region") String region, @Path("ID") int ID, @Query("champion") String champion, @Query("begIndex") int begIndex, @Query("endIndex") int endIndex);

    @GET("stats/game/VN/{ID}")
    Call<MatchDetail> getMatcDhetail(@Path("ID") String ID);

    @GET("cdn/{ID}/data/vn_VN/mastery.json")
    Call<MasteryTree> getListMastery(@Path("ID") String ID);

    @GET("vn_vn/champions/{ID}/index.json")
    Call<VideoChampion> getVideo(@Path("ID") String ID);
}