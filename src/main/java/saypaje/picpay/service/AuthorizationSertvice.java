package saypaje.picpay.service;

import org.springframework.stereotype.Service;
import saypaje.picpay.client.AuthorizationClient;
import saypaje.picpay.entity.Transfer;
import saypaje.picpay.exceptions.PicPayException;

@Service
public class AuthorizationSertvice {

    private final AuthorizationClient authorizationClient;

    public AuthorizationSertvice(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(Transfer transfer){
        var response = authorizationClient.isAuthorized();

        if(response.getStatusCode().isError()){
            throw new PicPayException();
        }

        return response.getBody().authorized();
    }


}
