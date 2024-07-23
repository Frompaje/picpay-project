package saypaje.picpay.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import saypaje.picpay.client.NotificationClient;
import saypaje.picpay.entity.Transfer;

@Service
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    private final NotificationClient notificationClient;

    public NotificationService(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public void sendNotification(Transfer transfer) {
        try {

            logger.info("Sending notification...");
            var response = notificationClient.sendNotification(transfer);
            if(response.getStatusCode().isError()){
                logger.error("Error while sending notification, status code is not OK");
            }

        } catch (Exception error) {
            logger.error("Error while sending notification", error);
        }
    }

}
