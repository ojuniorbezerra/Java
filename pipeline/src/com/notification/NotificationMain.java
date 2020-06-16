package com.notification;

import com.notification.pipeline.NotificationPipeline;
import com.notification.pipeline.Pipeline;
import com.notification.stage.GenerateNotificateStage;
import com.notification.stage.ReadNotificationStage;
import com.notification.stage.RemoveDuplicateStage;

/**
 * Created by Junior on 16/06/2020.
 */
public class NotificationMain {

    public static void main(String[] args) {

        Pipeline pipeline = new NotificationPipeline();
        pipeline.addPipe( new ReadNotificationStage());
        pipeline.addPipe( new RemoveDuplicateStage());
        pipeline.addPipe( new GenerateNotificateStage());

        pipeline.execute();
    }
}
