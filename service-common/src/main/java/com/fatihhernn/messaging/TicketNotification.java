package com.fatihhernn.messaging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//bu class hem ticket da hem de notificationda kullanılacağı için burada ortak bir yapıl oluşturuldu
//bu üstteki önerme için bu iki projede bu service-commonu biliyor olması gerekiyor

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TicketNotification {
    private String ticketId;            //url linki oluşturmak için kullanabiliriz
    private String accountId;           //kime mail veya noti gönderebileceğimizi belirleyecek
    private String ticketDescription;   //gönderilen messajdaki başlık bilgisi
}


