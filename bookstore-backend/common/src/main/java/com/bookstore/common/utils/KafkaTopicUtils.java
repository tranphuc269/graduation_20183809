package com.bookstore.common.utils;

public class KafkaTopicUtils {
    private KafkaTopicUtils() {
    }

    static final public String TOPIC_ADD_TO_CART = "topic-add-to-cart";

    static final public String TOPIC_SEND_NOTIFICATION_FROM_ORDER = "topic-send-notification-from-order";


    static final public String TOPIC_UPDATE_NOTIFICATION_INFO_FROM_USER = "user-notification";

    static final public String TOPIC_CREATE_CART_FROM_USER = "create-cart-from-user";

}
