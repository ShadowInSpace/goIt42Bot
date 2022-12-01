package jsonConverter.bankRate;
import com.google.gson.annotations.SerializedName;

public class MonoBankCurrency {
  private String currencyCodeA;
  private String currencyCodeB;
  private Integer date;
  private Double rateSell;
  private Double rateBuy;
  private Double rateCross;

    public String getCurrencyCodeA() {
        return currencyCodeA;
    }
    public void setCurrencyCodeA(String s) {
        currencyCodeA = s;
    }

    public String getCurrencyCodeB() {
        return currencyCodeB;
    }
    public void setCurrencyCodeB(String s) {
        currencyCodeB = s;
    }

    public Integer getDate() {
        return date;
    }

    public Double getRateSell() {
        return rateSell;
    }

    public Double getRateBuy() {
        return rateBuy;
    }

    public Double getRateCross() {
        return rateCross;
    }
}
