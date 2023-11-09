package Tobeto.showRoomStore.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetByIdResponses {

    private String firstName;
    private String lastName;
    private String eMail;
    private String country;
    private int age;


}
