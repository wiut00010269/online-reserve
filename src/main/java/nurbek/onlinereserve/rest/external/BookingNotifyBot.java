package nurbek.onlinereserve.rest.external;

// Abduraximov Nurbek 25/04/2024   17:43

import lombok.RequiredArgsConstructor;
import nurbek.onlinereserve.config.prop.TelegramBotProp;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class BookingNotifyBot extends TelegramLongPollingBot {

    private final TelegramBotProp prop;

    public void sendDepositMessage(String text) {
        CompletableFuture.runAsync(() -> {
            SendMessage sendMessage = new SendMessage();
            sendMessage.enableHtml(true);
            sendMessage.setChatId("-1002123892847"); // telegram kanal chatID : https://t.me/dinetime
            sendMessage.setText(text);
            try {
                if (text.length() > 4096) {
                    sendMessage.setText(text.substring(0, 4096));
                }
                sendApiMethod(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public String getBotUsername() {
        return prop.getBooking().getUsername();
    }

    @Override
    public String getBotToken() {
        return prop.getBooking().getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

    }
}
