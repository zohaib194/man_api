package no.freelanceInit.api.factory;

import no.freelanceInit.api.data.entity.User;
import no.freelanceInit.api.data.message.ResponseMessage;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface ResponseMessageFactory {

    ResponseMessage parseOnError(String err, HttpStatus status, List<User> user);

    ResponseMessage parseOnSuccess(String msg, HttpStatus status, List<User> user);
}
