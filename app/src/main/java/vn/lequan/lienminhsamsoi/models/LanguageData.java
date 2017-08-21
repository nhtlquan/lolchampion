package vn.lequan.lienminhsamsoi.models;

public enum LanguageData {
    CZECH("cs", "cs_CZ", "čeština"),
    GERMAN("de", "de_DE", "Deutsch"),
    GREEK("el", "el_GR", "ελληνικά"),
    ENGLISH("en", "en_US", "English"),
    SPANISH("es", "es_ES", "español"),
    FRENCH("fr", "fr_FR", "français"),
    HUNGARIAN("hu", "hu_HU", "magyar"),
    INDONESIAN("in", "id_ID", "Bahasa Indonesia"),
    ITALIAN("it", "it_IT", "Italiano"),
    JAPANESE("ja", "ja_JP", "日本語"),
    KOREAN("ko", "ko_KR", "조선말"),
    MALAY("ms", "ms_MY", "Malay"),
    POLISH("pl", "pl_PL", "język polski"),
    PORTUGUESE("pt", "pt_BR", "português"),
    ROMANIAN("ro", "ro_RO", "română"),
    RUSSIAN("ru", "ru_RU", "русский язык"),
    THAI("th", "th_TH", "ภาษาไทย"),
    TURKISH("tr", "tr_TR", "Türkçe"),
    VIETNAMESE("vi", "vn_VN", "Tiếng Việt"),
    CHINESE("zh", "zh_CN", "简体字");
    
    private String code;
    private String id;
    private String name;

    private LanguageData(String id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public static LanguageData getLocationCode(String id) {
        for (LanguageData loc : values()) {
            if (loc.id.equals(id)) {
                return loc;
            }
        }
        return null;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
