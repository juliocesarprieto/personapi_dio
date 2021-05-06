package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.PhoneDTO;
import one.digitalinnovation.personapi.entities.Phone;
import one.digitalinnovation.personapi.enums.PhoneType;

public class PhoneUtils {

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .id(1L)
                .type(PhoneType.MOBILE)
                .number("123456789123456")
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(1L)
                .type(PhoneType.MOBILE)
                .number("123456789123456")
                .build();
    }
}
