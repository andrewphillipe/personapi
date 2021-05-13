package one.digitalinnovation.personapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageRespondeDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.exception.PersonNotFoundExcepion;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageRespondeDTO createPerson (PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponse(savedPerson.getId(), "Created person with ID ");

    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundExcepion {
        Person person = verifyIfExists(id);

        return  personMapper.toDTO(person);
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundExcepion {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundExcepion(id));
    }

    public void delete(Long id) throws PersonNotFoundExcepion {
        verifyIfExists(id);
        personRepository.deleteById(id);

    }

    public MessageRespondeDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundExcepion {
        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatePerson = personRepository.save(personToUpdate);
        return createMessageResponse(updatePerson.getId(), "Updated person with ID ");

    }

    private MessageRespondeDTO createMessageResponse(Long id, String message) {
        return MessageRespondeDTO
                .builder()
                .message(message + id)
                .build();
    }
}
