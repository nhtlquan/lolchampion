package vn.lequan.lienminhsamsoi.championgg;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.actions.SearchIntents;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import vn.lequan.lienminhsamsoi.Debug;

public class ChampionGG {
    private static ChampionGG instance;

    private ChampionGG() {
    }

    public static ChampionGG getInstance() {
        if (instance == null) {
            instance = new ChampionGG();
        }
        return instance;
    }

    public String getDocument(String champId, String role) {
        try {
            return Jsoup.connect("http://champion.gg/champion/" + champId + "/" + role).data(SearchIntents.EXTRA_QUERY, "Java").userAgent("Mozilla").cookie("auth", "token").timeout(15000).get().toString();
        } catch (IOException e) {
            Debug.e(e.toString());
            e.printStackTrace();
            return null;
        }
    }

    public String getDocument(String link) {
        try {
            return Jsoup.connect("https://champion.gg" + link).data(SearchIntents.EXTRA_QUERY, "Java").userAgent("Mozilla").cookie("auth", "token").timeout(15000).get().toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getAllLinkRole() {
        try {
            Elements allChamp = Jsoup.connect("https://champion.gg/").data(SearchIntents.EXTRA_QUERY, "Java").userAgent("Mozilla").cookie("auth", "token").timeout(15000).get().getElementById("home").getElementsByAttributeValueContaining("class", "champ-index-img");
            List<String> arrayList = new ArrayList();
            Iterator it = allChamp.iterator();
            while (it.hasNext()) {
                Elements imports = ((Element) it.next()).select("a[href]");
                for (int i = 0; i < imports.size(); i++) {
                    if (i != 0) {
                        arrayList.add(((Element) imports.get(i)).attr(ShareConstants.WEB_DIALOG_PARAM_HREF));
                    }
                }
            }
            return arrayList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getRoleName(String html) {
        Elements li = Jsoup.parse(html).getElementsByClass("champion-area").first().getElementsByClass("champion-profile").first().select("li");
        List<String> lstRole = new ArrayList();
        Iterator it = li.iterator();
        while (it.hasNext()) {
            lstRole.add(((Element) it.next()).select("a").text());
        }
        return lstRole;
    }

    private DataRole getRole(String html) {
        DataRole rolesData = new DataRole();
        Document doc = Jsoup.parse(html);
        Elements li = doc.getElementsByClass("champion-area").first().getElementsByClass("champion-profile").first().select("li");
        List<Role> lstRole = new ArrayList();
        Iterator it = li.iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            lstRole.add(new Role(element.select("a").text(), element.select("small").first().text().replace("Role Rate", "").trim()));
        }
        rolesData.setRoles(lstRole);
        rolesData.setHeader(doc.getElementsByClass("analysis-holder").text());
        return rolesData;
    }

    public ItemFrequent getDataChampionGG(String html) {
        String[] split;
        int len;
        Document doc = Jsoup.parse(html);
        ItemFrequent model = new ItemFrequent();
        List<String> listCoreItemBuild = new ArrayList();
        Elements buildWrapper = doc.getElementsByClass("build-wrapper");
        Iterator it = buildWrapper.first().select("img[src$=.png]").iterator();
        while (it.hasNext()) {
            String itemId = ((Element) it.next()).attr("src").replace(".png", "");
            listCoreItemBuild.add(itemId.substring(itemId.length() - 4, itemId.length()));
        }
        String coreBuildWinrate = buildWrapper.first().getElementsByClass("build-text").text();
        model.setListCoreBuild(listCoreItemBuild);
        model.setCoreBuildWinRate(coreBuildWinrate);
        List<String> listItemStart = new ArrayList();
        it = ((Element) buildWrapper.get(2)).select("img[src$=.png]").iterator();
        while (it.hasNext()) {
           String itemId = ((Element) it.next()).attr("src").replace(".png", "");
            listItemStart.add(itemId.substring(itemId.length() - 4, itemId.length()));
        }
        String startBuildWinrate = ((Element) buildWrapper.get(2)).getElementsByClass("build-text").text();
        model.setListStartBuild(listItemStart);
        model.setStartBuildWinRate(startBuildWinrate);
        List<String> listSummoner = new ArrayList();
        Elements summonerWrapper = doc.getElementsByClass("summoner-wrapper");
        it = summonerWrapper.first().select("img[src$=.png]").iterator();
        while (it.hasNext()) {
            split = ((Element) it.next()).attr("src").replace(".png", "").split(File.separator);
            len = split.length;
            listSummoner.add(len > 0 ? split[len - 1] : "");
        }
        model.setSummonerWinRate(summonerWrapper.first().getElementsByClass("summoner-text").text());
        model.setListSummoner(listSummoner);
        List<Runes> listRunes = new ArrayList();
        Iterator it2 = doc.getElementsByClass("rune-collection").first().getElementsByClass("rune-type-area").iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            split = element.select("img[src$=.png]").first().attr("src").split(File.separator);
            len = split.length;
            listRunes.add(new Runes(len > 0 ? split[len - 1] : "", ((Element) element.select("span").get(1)).text(), element.text().substring(0, 2)));
        }
        model.setListRunes(listRunes);
        split = doc.getElementsByClass("trinket-stats").select("img[src$=.png]").first().attr("src").split(File.separator);
        len = split.length;
        model.setTrinketStats((len > 0 ? split[len - 1] : "").replace(".png", ""));
        SpellOrder spellOrder = new SpellOrder();
        List<String> urlSkin = new ArrayList();
        String[] lever = new String[]{"", AppEventsConstants.EVENT_PARAM_VALUE_YES, "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"};
        Elements elementSkin = ((Element) doc.getElementsByClass("champion-area").get(1)).select("div.skill");
        Element spell = (Element) elementSkin.get(1);
        Elements spellQ = spell.select("span");
        List<Boolean> lstQ = new ArrayList();
        lstQ.add(Boolean.valueOf(false));
        it = spellQ.iterator();
        while (it.hasNext()) {
            Element eleSplell = (Element) it.next();
            if (eleSplell.text().equals("") || eleSplell.text() == null) {
                lstQ.add(Boolean.valueOf(false));
            } else {
                lstQ.add(Boolean.valueOf(true));
            }
        }
        urlSkin.add("http:" + spell.select("img[src$=.png]").first().attr("src"));
        Element spell2 = (Element) elementSkin.get(2);
        Elements spellW = spell2.select("span");
        List<Boolean> lstW = new ArrayList();
        lstW.add(Boolean.valueOf(false));
        it = spellW.iterator();
        while (it.hasNext()) {
            Element  eleSplell = (Element) it.next();
            if (eleSplell.text().equals("") || eleSplell.text() == null) {
                lstW.add(Boolean.valueOf(false));
            } else {
                lstW.add(Boolean.valueOf(true));
            }
        }
        urlSkin.add("http:" + spell2.select("img[src$=.png]").first().attr("src"));
        Element spell3 = (Element) elementSkin.get(3);
        Elements spellE = spell3.select("span");
        List<Boolean> lstE = new ArrayList();
        lstE.add(Boolean.valueOf(false));
        it = spellE.iterator();
        while (it.hasNext()) {
            Element eleSplell = (Element) it.next();
            if (eleSplell.text().equals("") || eleSplell.text() == null) {
                lstE.add(Boolean.valueOf(false));
            } else {
                lstE.add(Boolean.valueOf(true));
            }
        }
        urlSkin.add("http:" + spell3.select("img[src$=.png]").first().attr("src"));
        Element spell4 = (Element) elementSkin.get(4);
        Elements spellR = spell4.select("span");
        List<Boolean> lstR = new ArrayList();
        lstR.add(Boolean.valueOf(false));
        it = spellR.iterator();
        while (it.hasNext()) {
            Element  eleSplell = (Element) it.next();
            if (eleSplell.text().equals("") || eleSplell.text() == null) {
                lstR.add(Boolean.valueOf(false));
            } else {
                lstR.add(Boolean.valueOf(true));
            }
        }
        urlSkin.add("http:" + spell4.select("img[src$=.png]").first().attr("src"));
        spellOrder.setLever(lever);
        spellOrder.setSpellQ(lstQ);
        spellOrder.setSpellW(lstW);
        spellOrder.setSpellE(lstE);
        spellOrder.setSpellR(lstR);
        spellOrder.setUrlSkin(urlSkin);
        model.setSpellOrder(spellOrder);
        model.setMasteries(getMasteries(doc));
        model.setDataRole(getRole(html));
        return model;
    }

    private Masteries getMasteries(Document doc) {
        Masteries masteries = new Masteries();
        try {
            Element masteryContainer = doc.getElementsByAttributeValueContaining("class", "mastery-container").first();
            Element mastery0 = masteryContainer.getElementsByClass("mastery0").first();
            Element mastery1 = masteryContainer.getElementsByClass("mastery1").first();
            Element mastery2 = masteryContainer.getElementsByClass("mastery2").first();
            List<Mastery> cuongBao = getMatery(mastery0);
            List<Mastery> kheoLeo = getMatery(mastery1);
            List<Mastery> kienDinh = getMatery(mastery2);
            int sumCuongBao = 0;
            int sumKheoLeo = 0;
            int sumKienDinh = 0;
            for (Mastery mastery : kienDinh) {
                sumKienDinh += mastery.getPoint();
            }
            for (Mastery mastery3 : kheoLeo) {
                sumKheoLeo += mastery3.getPoint();
            }
            for (Mastery mastery32 : cuongBao) {
                sumCuongBao += mastery32.getPoint();
            }
            masteries.setSumCuongBao(sumCuongBao);
            masteries.setSumKheoLeo(sumKheoLeo);
            masteries.setSumKienDinh(sumKienDinh);
            masteries.setCuongBao(cuongBao);
            masteries.setKheoLeo(kheoLeo);
            masteries.setKienDinh(kienDinh);
            return masteries;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Mastery> getMatery(Element eMastery) {
        List<Mastery> masteries = new ArrayList();
        try {
            Iterator it = eMastery.getElementsByAttributeValueContaining("class", "mastery-row").iterator();
            while (it.hasNext()) {
                Iterator it2 = ((Element) it.next()).children().iterator();
                while (it2.hasNext()) {
                    Element row = (Element) it2.next();
                    Mastery mastery = new Mastery();
                    String id = row.attr("data-id");
                    Elements ePoint = row.getElementsByClass("points");
                    int count = 0;
                    if (ePoint.size() > 0) {
                        count = ePoint.first().children().size();
                    }
                    mastery.setId(id);
                    mastery.setPoint(count);
                    masteries.add(mastery);
                }
            }
            return masteries;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
