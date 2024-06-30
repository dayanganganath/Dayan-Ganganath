package net.javaguides.evms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EventDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String eventName;
    private String eventVenue;
    private String eventPrice;
}
