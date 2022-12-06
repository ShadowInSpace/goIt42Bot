package telegrambot.user;

public class UserSettings {

   static   {
        notificationTime = "9";
        bank = "Privat";
        precession = "3";
        currency = new String[]{"USD", "EUR"};
    }
    private static String notificationTime; // 9 - 18, off
    private static String bank; // Privat, NBU, Mono
    private static String precession; // -2,-3,-4
    private static final String[] currency; //"EUR", "USD", "null"

    public String getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(String notificationTime) {
        UserSettings.notificationTime = notificationTime;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        UserSettings.bank = bank;
    }

    public String getPrecession() {
        return precession;
    }

    public void setPrecession(String precession) {
        UserSettings.precession = precession;
    }

    public String[] getCurrency() {
        return currency;
    }

    public void setCurrency0(String currency) {
        UserSettings.currency[0] = currency;
    }
    public void setCurrency1(String currency){
        UserSettings.currency[1] = currency;
    }
}
