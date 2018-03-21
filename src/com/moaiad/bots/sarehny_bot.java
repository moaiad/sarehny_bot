package com.moaiad.bots;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendSticker;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class sarehny_bot extends TelegramLongPollingBot {


    long mychat_id;
        long chat_id;
       // id t=new id() ;
        String sticker_id;


        @Override
        public void onUpdateReceived(Update update) {

            if(update.hasMessage()&&update.getMessage().hasText()) {

                chat_id=update.getMessage().getChatId();

                String massege_text = update.getMessage().getText();

//                sticker_id=  update.getMessage().getSticker().getFileId();



                System.out.println(chat_id+massege_text);

                SendMessage message =new SendMessage();
                message.setChatId(chat_id);
                message.setText(massege_text);

                try {
                    sendMessage(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }


            }



            sticker_id=  update.getMessage().getSticker().getFileId();





            System.out.println(sticker_id);

            SendSticker s =new SendSticker();
            s.setChatId(chat_id);
            s.setSticker(sticker_id);

            //sendsticker
            try {

                sendSticker(s);

            } catch (TelegramApiException e)
            {
                e.printStackTrace();
            }


        }

        @Override
        public String getBotUsername() {
            return "sarehny_bot";
        }

        @Override
        public String getBotToken() {
            return "488555910:AAG4bK6opYRJTJ0byPMVRfvT_Pn-oHVQ_20";
        }


    }



