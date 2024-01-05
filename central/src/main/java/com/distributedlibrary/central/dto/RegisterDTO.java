package com.distributedlibrary.central.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterDTO {
    String firstname;
    String lastname;
    String jmbg;
    AddressDTO address;
}
