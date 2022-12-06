package com.jc8pg2.telegrambot.telegram.notification;

import com.jc8pg2.telegrambot.user.UserSettings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NotifierStream {

    public void idler(UserSettings userSettings) {

    }

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

    }
}
