package no.freelanceInit.api.data.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import no.freelanceInit.api.data.entity.User;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {
    private Date timestamp;
    private Integer statusCode;
    private HttpStatus statusText;
    private String message;
    private List<User> user;
}
