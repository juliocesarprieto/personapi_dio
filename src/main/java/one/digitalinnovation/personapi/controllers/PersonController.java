package one.digitalinnovation.personapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.exceptions.PersonNotFoundException;
import one.digitalinnovation.personapi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService personService;

    @Operation(summary = "Create a person")
    @ApiResponse(responseCode = "201",
            description = "Created person with ID",
            content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MessageResponseDTO.class))
            })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @Operation(summary = "Get all persons")
    @ApiResponse(responseCode = "200",
            description = "Found all persons",
            content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class)))
            })
    @GetMapping
    public List<PersonDTO> findAll() {
        return personService.findAll();
    }

    @Operation(summary = "Get person by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the person",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PersonDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Person not found with ID", content = @Content)
    })
    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @Operation(summary = "Update a person by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Updated person with ID",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Person not found with ID", content = @Content)
    })
    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updatePerson(id, personDTO);
    }

    @Operation(summary = "Delete a person by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Not Content",
                    content = {@Content}),
            @ApiResponse(responseCode = "404", description = "Person not found with ID", content = @Content)
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePerson(@PathVariable Long id) throws PersonNotFoundException {
        personService.removePerson(id);
    }
}
