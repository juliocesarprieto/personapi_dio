package one.digitalinnovation.personapi.services;

import one.digitalinnovation.personapi.dto.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;

import java.util.List;

public interface PersonService {

    MessageResponseDTO createPerson(PersonDTO personDTO);

    List<PersonDTO> findAll();
}
