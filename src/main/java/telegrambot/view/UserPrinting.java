package telegrambot.view;



import telegrambot.currency.bankrates.MonoBankGetRate;
import telegrambot.currency.bankrates.NationalBankGetRate;
import telegrambot.currency.bankrates.PrivateBankGetRate;
import telegrambot.currency.convertion.MonoBankRate;
import telegrambot.currency.convertion.NationalBankRate;
import telegrambot.currency.convertion.PrivateBankRate;
import telegrambot.user.UserSettings;

import java.util.List;

public class UserPrinting{
    public String Print(UserSettings userSettings){
        String precession = userSettings.getPrecession();
        String notificationTime = userSettings.getNotificationTime();
        String bankData = userSettings.getPrecession();

        List<MonoBankRate> mono = new MonoBankGetRate().getRate();
        List<PrivateBankRate> privat = new PrivateBankGetRate().getRate();
        List<NationalBankRate> nbu = new NationalBankGetRate().getRate();


         return "DONE!!!!! KEYBOARD CALLBACK WORKS";
        }



    }
