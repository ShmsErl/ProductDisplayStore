package Tobeto.showRoomStore.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUsersResponses {

    private String firstName;
    private String lastName;
    private String eMail;
    private String country;
    private  int age;

}
