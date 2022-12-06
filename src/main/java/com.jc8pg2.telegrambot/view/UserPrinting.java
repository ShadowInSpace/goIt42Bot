package com.jc8pg2.telegrambot.view;



import com.jc8pg2.telegrambot.currency.bankrates.MonoBankGetRate;
import com.jc8pg2.telegrambot.currency.bankrates.NationalBankGetRate;
import com.jc8pg2.telegrambot.currency.bankrates.PrivateBankGetRate;
import com.jc8pg2.telegrambot.currency.convertion.MonoBankRate;
import com.jc8pg2.telegrambot.currency.convertion.NationalBankRate;
import com.jc8pg2.telegrambot.currency.convertion.PrivateBankRate;
import com.jc8pg2.telegrambot.user.UserSettings;

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
