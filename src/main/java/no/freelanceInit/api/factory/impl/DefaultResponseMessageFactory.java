package no.freelanceInit.api.factory.impl;

import no.freelanceInit.api.data.entity.User;
import no.freelanceInit.api.data.message.ResponseMessage;
import no.freelanceInit.api.factory.ResponseMessageFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DefaultResponseMessageFactory implements ResponseMessageFactory {
    @Override
    public ResponseMessage parseOnError(String err, HttpStatus status, List<User> user) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage(err);
        responseMessage.setStatusCode(status.value());
        responseMessage.setStatusText(status);
        responseMessage.setUser(user);
        responseMessage.setTimestamp(new Date());
        return responseMessage;
    }

    @Override
    public ResponseMessage parseOnSuccess(String msg, HttpStatus status, List<User> user) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage(msg);
        responseMessage.setStatusCode(status.value());
        responseMessage.setStatusText(status);
        responseMessage.setUser(user);
        responseMessage.setTimestamp(new Date());
        return responseMessage;
    }
}
