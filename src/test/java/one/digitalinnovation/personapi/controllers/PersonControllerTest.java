package one.digitalinnovation.personapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import one.digitalinnovation.personapi.dto.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entities.Person;
import one.digitalinnovation.personapi.services.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static one.digitalinnovation.personapi.utils.PersonUtils.createNewFakeDTO;
import static one.digitalinnovation.personapi.utils.PersonUtils.createNewFakeEntity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    static String PERSON_API = "/api/v1/people";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PersonService personService;

    @Test
    public void testCreatePersonController() throws Exception {
        PersonDTO personDTO = createNewFakeDTO();
        Person expectedPersonModel = createNewFakeEntity();

        MessageResponseDTO expectedSuccessMessage = MessageResponseDTO.builder()
                .message("Created person with ID " + expectedPersonModel.getId())
                .build();

        BDDMockito.given(personService.createPerson(Mockito.any(PersonDTO.class))).willReturn(expectedSuccessMessage);

        String json = new ObjectMapper().writeValueAsString(personDTO);

        MockHttpServletRequestBuilder requestBuilder = post(PERSON_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("message").value(expectedSuccessMessage.getMessage()));

    }

}
