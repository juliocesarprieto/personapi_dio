package one.digitalinnovation.personapi.services;

import one.digitalinnovation.personapi.dto.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.exceptions.PersonNotFoundException;

import java.util.List;

public interface PersonService {

    MessageResponseDTO createPerson(PersonDTO personDTO);

    List<PersonDTO> findAll();

    PersonDTO findById(Long id) throws PersonNotFoundException;

    void removePerson(Long id) throws PersonNotFoundException;
}
