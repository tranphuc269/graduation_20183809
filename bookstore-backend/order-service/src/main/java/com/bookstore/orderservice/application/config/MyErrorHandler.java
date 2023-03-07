//package com.bookstore.orderservice.application.config;
//
//import org.axonframework.eventhandling.ErrorContext;
//import org.axonframework.eventhandling.ErrorHandler;
//import org.axonframework.eventhandling.deadletter.jpa.JpaDeadLetter;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MyErrorHandler implements ErrorHandler {
//    private final JpaDeadLetter jpaDeadLetter;
//
//
//    @Autowired
//    public MyErrorHandler(JpaDeadLetter jpaDeadLetter) {
//        this.jpaDeadLetter = jpaDeadLetter;
//    }
//
//
//    @Override
//    public void handleError(@NotNull ErrorContext errorContext) throws Exception {
//
//    }
//
////    @Override
////    public void handleError(ErrorContext errorContext) {
////        Throwable cause = errorContext.error();
////        Message<?> message = errorContext.message();
////
////        // Log the error message
////        String errorMsg = String.format("Error handling message: %s", message.getPayload());
////        log.error(errorMsg, cause);
////
////        // Write the message to the dead-letter queue
////        deadLetterHandler.storeDeadLetter(message, cause, errorContext.configuration());
////    }
//}