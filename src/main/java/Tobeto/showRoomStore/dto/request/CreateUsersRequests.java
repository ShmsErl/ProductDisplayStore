package Tobeto.showRoomStore.dto.request;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUsersRequests {

    private String firstName;
    private String lastName;
    private String eMail;
    private String country;
    private int age;




}
