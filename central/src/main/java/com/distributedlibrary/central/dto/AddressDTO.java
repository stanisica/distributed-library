package com.distributedlibrary.central.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressDTO {
    String city;
    String street;
    String number;
}
