package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.response.MessageRespondeDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {


    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageRespondeDTO createPerson(@RequestBody Person person){
        Person savedPerson = personRepository.save(person);
        return MessageRespondeDTO
                .builder()
                .message("Criada a pessoa com o ID" + savedPerson.getId())
                .build();
    }

}
