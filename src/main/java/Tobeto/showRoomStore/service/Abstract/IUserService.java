package Tobeto.showRoomStore.service.Abstract;

import Tobeto.showRoomStore.core.utilities.result.DataResult;
import Tobeto.showRoomStore.core.utilities.result.Result;
import Tobeto.showRoomStore.dto.request.CreateUsersRequests;
import Tobeto.showRoomStore.dto.request.DeleteUsersRequests;
import Tobeto.showRoomStore.dto.request.GetByIdRequests;
import Tobeto.showRoomStore.dto.request.UpdateUsersRequests;
import Tobeto.showRoomStore.dto.response.GetAllUsersResponses;
import Tobeto.showRoomStore.dto.response.GetByIdUserResponses;

import java.util.List;

public interface IUserService {


    DataResult<List<GetAllUsersResponses>> getAllUser() ;

    Result add(CreateUsersRequests user);

    Result delete(DeleteUsersRequests deleteUsersRequests) throws Exception;

    Result update(int id, UpdateUsersRequests updateUsersRequests);

    DataResult<GetByIdUserResponses> GET_BY_ID_RESPONSES(GetByIdRequests getByIdRequests);

}
