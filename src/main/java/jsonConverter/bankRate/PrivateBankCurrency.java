package jsonConverter.bankRate;

import com.google.gson.annotations.SerializedName;

public class PrivateBankCurrency {
    @SerializedName("ccy")
    private String currency;
    @SerializedName("base_ccy")
    private String baseCurrency;
    private String buy;
    private String sale;

    public String getCurrency() {
        return currency;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getBuy() {
        return buy;
    }

    public String getSale() {
        return sale;
    }
}
