package bd.uz;

import bd.uz.Bot.Bot;

import bd.uz.service.Service;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
       Service service = new Service();
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
              telegramBotsApi.registerBot( new Bot());
            System.out.println("Bot run ");
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }



    }
}
