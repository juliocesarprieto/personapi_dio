package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.PersonDTO;
import one.digitalinnovation.personapi.entities.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .id(1L)
                .firstName("Julio")
                .lastName("Cesar")
                .cpf("386.010.920-04")
                .birthDate("2021-05-05")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(1L)
                .firstName("Julio")
                .lastName("Cesar")
                .cpf("386.010.920-04")
                .birthDate(LocalDate.parse("2021-05-05"))
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }

    public static PersonDTO createNewFakeDTO() {
        return PersonDTO.builder()
                .firstName("Julio")
                .lastName("Cesar")
                .cpf("386.010.920-04")
                .birthDate("2021-05-05")
                .phones(Collections.singletonList(PhoneUtils.createNewFakeDTO()))
                .build();
    }

    public static Person createNewFakeEntity() {
        return Person.builder()
                .firstName("Julio")
                .lastName("Cesar")
                .cpf("386.010.920-04")
                .birthDate(LocalDate.parse("2021-05-05"))
                .phones(Collections.singletonList(PhoneUtils.createNewFakeEntity()))
                .build();
    }
}
