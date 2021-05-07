package one.digitalinnovation.personapi.services;

import one.digitalinnovation.personapi.dto.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entities.Person;
import one.digitalinnovation.personapi.mappers.PersonMapper;
import one.digitalinnovation.personapi.repositories.PersonRepository;
import one.digitalinnovation.personapi.services.impl.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.personapi.utils.PersonUtils.createFakeDTO;
import static one.digitalinnovation.personapi.utils.PersonUtils.createFakeEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonServiceImpl personServiceImpl;

    @Test
    public void testGivenPersonDTOMapToPersonModel() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedPerson = createFakeEntity();

        Person personMapperToModel = personMapper.INSTANCE.toModel(personDTO);

        assertThat(expectedPerson.getId()).isEqualTo(personMapperToModel.getId());
        assertThat(expectedPerson.getFirstName()).isEqualTo(personMapperToModel.getFirstName());
        assertThat(expectedPerson.getLastName()).isEqualTo(personMapperToModel.getLastName());
        assertThat(expectedPerson.getBirthDate()).isEqualTo(personMapperToModel.getBirthDate());
        assertThat(expectedPerson.getCpf()).isEqualTo(personMapperToModel.getCpf());
        assertThat(expectedPerson.getPhones()).isNotNull();
    }

    @Test
    public void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        lenient().when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = MessageResponseDTO.builder()
                .message("Created person with ID " + expectedSavedPerson.getId())
                .build();

        MessageResponseDTO successMessage = personServiceImpl.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }
}
