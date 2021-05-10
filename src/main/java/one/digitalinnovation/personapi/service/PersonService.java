package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.response.MessageRespondeDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageRespondeDTO createPerson (Person person){
        Person savedPerson = personRepository.save(person);
        return  MessageRespondeDTO
                .builder()
                .message("Created person with ID" + savedPerson.getId())
                .build();

    }
}
