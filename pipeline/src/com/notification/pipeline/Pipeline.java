package com.notification.pipeline;

import com.notification.stage.Stage;

/**
 * Created by Junior on 16/06/2020.
 */
public interface Pipeline {

    void addPipe(Stage stage);

    void execute();
}
