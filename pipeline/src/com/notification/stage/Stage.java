package com.notification.stage;

/**
 * Created by Junior on 16/06/2020.
 */
public interface Stage<T> {

    T execute(T input);
}
