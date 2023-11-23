package Tobeto.showRoomStore.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUsersRequests {

    private int id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String password;
    private String country;
    private int age;

}
