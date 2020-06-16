package com.notification.stage;

import com.notification.dto.Message;

/**
 * Created by Junior on 16/06/2020.
 */
public class ReadNotificationStage implements Stage<Message> {


    @Override
    public Message execute(Message input) {
        System.out.println("Reading Message");
        return input;
    }
}
