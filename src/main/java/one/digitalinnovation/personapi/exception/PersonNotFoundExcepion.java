package one.digitalinnovation.personapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundExcepion extends Exception {
    public PersonNotFoundExcepion(Long id) {
        super("Person with ID" + id + "not found" );
    }
}
