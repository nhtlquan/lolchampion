package vn.lequan.lienminhsamsoi.championgg;

import java.util.List;

public class ItemFrequent {
    private String coreBuildWinRate;
    private DataRole dataRole;
    private String header;
    private List<String> listCoreBuild;
    private List<Runes> listRunes;
    private List<String> listStartBuild;
    private List<String> listSummoner;
    private Masteries masteries;
    private SpellOrder spellOrder;
    private String startBuildWinRate;
    private String summonerWinRate;
    private String trinketStats;

    public Masteries getMasteries() {
        return this.masteries;
    }

    public void setMasteries(Masteries masteries) {
        this.masteries = masteries;
    }

    public DataRole getDataRole() {
        return this.dataRole;
    }

    public void setDataRole(DataRole dataRole) {
        this.dataRole = dataRole;
    }

    public SpellOrder getSpellOrder() {
        return this.spellOrder;
    }

    public void setSpellOrder(SpellOrder spellOrder) {
        this.spellOrder = spellOrder;
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getTrinketStats() {
        return this.trinketStats;
    }

    public void setTrinketStats(String trinketStats) {
        this.trinketStats = trinketStats;
    }

    public List<Runes> getListRunes() {
        return this.listRunes;
    }

    public void setListRunes(List<Runes> listRunes) {
        this.listRunes = listRunes;
    }

    public String getSummonerWinRate() {
        return this.summonerWinRate;
    }

    public void setSummonerWinRate(String summonerWinRate) {
        this.summonerWinRate = summonerWinRate;
    }

    public List<String> getListCoreBuild() {
        return this.listCoreBuild;
    }

    public void setListCoreBuild(List<String> listCoreBuild) {
        this.listCoreBuild = listCoreBuild;
    }

    public String getCoreBuildWinRate() {
        return this.coreBuildWinRate;
    }

    public void setCoreBuildWinRate(String coreBuildWinRate) {
        this.coreBuildWinRate = coreBuildWinRate;
    }

    public List<String> getListStartBuild() {
        return this.listStartBuild;
    }

    public void setListStartBuild(List<String> listStartBuild) {
        this.listStartBuild = listStartBuild;
    }

    public String getStartBuildWinRate() {
        return this.startBuildWinRate;
    }

    public void setStartBuildWinRate(String startBuildWinRate) {
        this.startBuildWinRate = startBuildWinRate;
    }

    public List<String> getListSummoner() {
        return this.listSummoner;
    }

    public void setListSummoner(List<String> listSummoner) {
        this.listSummoner = listSummoner;
    }
}
