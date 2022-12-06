package com.jc8pg2.telegrambot.currency.convertion;

import com.google.gson.annotations.SerializedName;

public class MonoBankRate {
  private String currencyCodeA;
  private String currencyCodeB;
  private Integer date;
  @SerializedName("rateSell")
  private Double sell;
  @SerializedName("rateBuy")
  private Double buy;
  private Double rateCross;

    public MonoBankRate() {
    }

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

    public Double getRateSell() {
        return sell;
    }

    public Double getRateBuy() {
        return buy;
    }


}
