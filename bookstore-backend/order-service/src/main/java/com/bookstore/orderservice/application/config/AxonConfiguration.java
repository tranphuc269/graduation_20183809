//package com.bookstore.orderservice.config;
//
//import com.thoughtworks.xstream.XStream;
//import org.axonframework.common.jpa.EntityManagerProvider;
//import org.axonframework.common.transaction.TransactionManager;
//import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
//import org.axonframework.eventsourcing.eventstore.jpa.JpaEventStorageEngine;
//import org.axonframework.serialization.Serializer;
//import org.axonframework.serialization.xml.CompactDriver;
//import org.axonframework.serialization.xml.XStreamSerializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//@Configuration
//@Primary
//public class AxonConfiguration {
//
//    @Bean
//    @Primary
//    public Serializer serializer() {
//        final XStream xStream = new XStream(new CompactDriver());
//        xStream.setClassLoader(this.getClass().getClassLoader());
//        final XStreamSerializer serializer = XStreamSerializer.builder().xStream(xStream).build();
//
//        return serializer;
//    }
//
//    @Bean
//    public EventStorageEngine eventStorageEngine(Serializer serializer, EntityManagerProvider entityManagerProvider, TransactionManager transactionManager) {
////        JpaEventStorageEngine engine = new (serializer, null, null, null, entityManagerProvider, transactionManager, null, null, true);
//        return JpaEventStorageEngine
//                .builder()
//                .eventSerializer(serializer)
//                .entityManagerProvider(entityManagerProvider)
//                .transactionManager(transactionManager)
//                .explicitFlush(true)
//                .build();
//    }
//
//}