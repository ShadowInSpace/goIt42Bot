package telegrambot.currency.convertion;

import com.google.gson.annotations.SerializedName;

public class NationalBankRate {
    @SerializedName("r030")
    private Integer r030;
    @SerializedName("txt")
    private String txt;
    @SerializedName("rate")
    private Double buy;
    @SerializedName("cc")
    private String cc;
    @SerializedName("exchangedate")
    private String exchangeDate;

    public Double getRate() {
        return buy;
    }

    public String getCc() {
        return cc;
    }
}
