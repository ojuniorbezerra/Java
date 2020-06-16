package com.notification.pipeline;

import com.notification.dto.Message;
import com.notification.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junior on 16/06/2020.
 */
public class NotificationPipeline implements Pipeline {

    List<Stage> stages = new ArrayList<>();
    @Override
    public void addPipe(Stage stage) {
        stages.add(stage);
    }

    @Override
    public void execute() {

        Message input = null, output;
        for(Stage stage : stages){

            output = (Message) stage.execute(input);
            input = output;
        }
    }
}
