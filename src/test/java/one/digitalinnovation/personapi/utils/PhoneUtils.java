package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.PhoneDTO;
import one.digitalinnovation.personapi.entities.Phone;
import one.digitalinnovation.personapi.enums.PhoneType;

public class PhoneUtils {

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .id(1L)
                .type(PhoneType.MOBILE)
                .number("(92)999999-999")
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(1L)
                .type(PhoneType.MOBILE)
                .number("(92)999999-999")
                .build();
    }

    public static PhoneDTO createNewFakeDTO() {
        return PhoneDTO.builder()
                .type(PhoneType.MOBILE)
                .number("(92)999999-999")
                .build();
    }

    public static Phone createNewFakeEntity() {
        return Phone.builder()
                .type(PhoneType.MOBILE)
                .number("(92)999999-999")
                .build();
    }
}
