# Proje Genel Yapisi
  ![](https://github.com/fatihhernn/springboot-microservice-app/blob/master/arch.png)


##Rabbit Mq ile message kuyruğa mesaj göndermek ve yazmak
- Ticket olustur
- assigne'sini cassandradan çekti.
- ticket'a mysql ve elastic search'e, assignee çekildikten sonra kaydetti
- kaydetme işlemleri bittikten sonra queue ya messajını yazdı
- queue dinleyen Notification servisi bu mesajı handle edecek bir şekilde handle edildi ve bunun sonucunda console oluşturulan ticket hakkında bilgiler yazdırıldı
