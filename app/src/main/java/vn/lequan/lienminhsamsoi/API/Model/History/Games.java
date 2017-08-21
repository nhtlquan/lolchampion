
package vn.lequan.lienminhsamsoi.API.Model.History;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Games {

    @SerializedName("gameIndexBegin")
    @Expose
    private Integer gameIndexBegin;
    @SerializedName("gameIndexEnd")
    @Expose
    private Integer gameIndexEnd;
    @SerializedName("gameTimestampBegin")
    @Expose
    private Integer gameTimestampBegin;
    @SerializedName("gameTimestampEnd")
    @Expose
    private Integer gameTimestampEnd;
    @SerializedName("gameCount")
    @Expose
    private Integer gameCount;
    @SerializedName("games")
    @Expose
    private List<Game> games = null;

    public Integer getGameIndexBegin() {
        return gameIndexBegin;
    }

    public void setGameIndexBegin(Integer gameIndexBegin) {
        this.gameIndexBegin = gameIndexBegin;
    }

    public Integer getGameIndexEnd() {
        return gameIndexEnd;
    }

    public void setGameIndexEnd(Integer gameIndexEnd) {
        this.gameIndexEnd = gameIndexEnd;
    }

    public Integer getGameTimestampBegin() {
        return gameTimestampBegin;
    }

    public void setGameTimestampBegin(Integer gameTimestampBegin) {
        this.gameTimestampBegin = gameTimestampBegin;
    }

    public Integer getGameTimestampEnd() {
        return gameTimestampEnd;
    }

    public void setGameTimestampEnd(Integer gameTimestampEnd) {
        this.gameTimestampEnd = gameTimestampEnd;
    }

    public Integer getGameCount() {
        return gameCount;
    }

    public void setGameCount(Integer gameCount) {
        this.gameCount = gameCount;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

}
