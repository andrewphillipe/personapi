package one.digitalinnovation.personapi.entity;


import one.digitalinnovation.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    private Long id;
    private PhoneType type;
    private String number;



}
