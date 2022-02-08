package com.fatihhernn.notification;

//bu class kuyruğu dinleyecek olan class
//noti leri sağa sola gönderecek class..

import com.fatihhernn.messaging.TicketNotification;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@EnableBinding(Sink.class) //kuyruğa clint olacak bunu yapması için gerekli olan configurasyon ayarlarını config-server'dan alacak
public class NotificationDistributionService {

    //ticket service queue yazıyor olacak => yazılan bilgiler bu class sayesinde dinleniyor olacak

    @StreamListener(Sink.INPUT)
    public void onNotification(TicketNotification ticketNotification){
        System.out.println("----------------------------------------------");
        System.out.println("Notification alındı kullanıcılara gönderiliyor");
        System.out.println("Notification : "+ticketNotification.toString());
    }

}
