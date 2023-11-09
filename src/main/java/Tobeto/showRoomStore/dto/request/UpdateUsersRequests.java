package Tobeto.showRoomStore.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUsersRequests {
    private String firstName;
    private String lastName;
    private String eMail;
    private String country;
    private int age;

}
