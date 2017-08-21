
package vn.lequan.lienminhsamsoi.models.VideoChampion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Biography {

    @SerializedName("full")
    @Expose
    private String full;
    @SerializedName("quote")
    @Expose
    private String quote;
    @SerializedName("quote-author")
    @Expose
    private String quoteAuthor;

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public void setQuoteAuthor(String quoteAuthor) {
        this.quoteAuthor = quoteAuthor;
    }

}
