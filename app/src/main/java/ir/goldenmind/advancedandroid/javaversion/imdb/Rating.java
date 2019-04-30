
package ir.goldenmind.advancedandroid.javaversion.imdb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rating {

    @SerializedName("Source")
    @Expose
    private String source;
    @SerializedName("Value")
    @Expose
    private String value;

    public String abc;

    public Rating(){}

    public Rating(String source) {
        this.source = source;
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getValue(String str) {

        return  "-----" + str + "-----";
    }

    public void setValue(String value) {
        this.value = value;
    }

}
