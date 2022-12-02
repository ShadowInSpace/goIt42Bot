package jsonConverter.bankRate;

import com.google.gson.annotations.SerializedName;

public class NationalBankCurrency {
    @SerializedName("r030")
    private Integer r030;
    @SerializedName("txt")
    private String txt;
    @SerializedName("rate")
    private Double rate;
    @SerializedName("cc")
    private String cc;
    @SerializedName("exchangedate")
    private String exchangedate;


    public Double getRate() {
        return rate;
    }

    public String getCc() {
        return cc;
    }

}
