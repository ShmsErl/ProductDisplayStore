package Tobeto.showRoomStore.service.concretes;

import Tobeto.showRoomStore.dto.response.GetByIdUserResponses;
import Tobeto.showRoomStore.mapper.user.UserMapperService;
import Tobeto.showRoomStore.service.Abstract.IUserService;
import Tobeto.showRoomStore.core.utilities.result.DataResult;
import Tobeto.showRoomStore.core.utilities.result.Result;
import Tobeto.showRoomStore.core.utilities.result.SuccessDataResult;
import Tobeto.showRoomStore.core.utilities.result.SuccessResult;
import Tobeto.showRoomStore.repository.concretes.IUserRepository;
import Tobeto.showRoomStore.dto.request.CreateUsersRequests;
import Tobeto.showRoomStore.dto.request.DeleteUsersRequests;
import Tobeto.showRoomStore.dto.request.GetByIdRequests;
import Tobeto.showRoomStore.dto.request.UpdateUsersRequests;
import Tobeto.showRoomStore.dto.response.GetAllUsersResponses;
import Tobeto.showRoomStore.model.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements IUserService {


    private final IUserRepository iUserRepository;
    private final UserMapperService mapperService;


    @Override
    public DataResult<List<GetAllUsersResponses>> getAllUser() {

        List<User> users = this.iUserRepository.findAll();
        List<GetAllUsersResponses> allUsersResponses = new ArrayList<>();
        for (User user : users) {

            GetAllUsersResponses responses = this.mapperService.forResponse().map(user, GetAllUsersResponses.class);
            allUsersResponses.add(responses);
        }


        return new SuccessDataResult<List<GetAllUsersResponses>>("İşlem Başarılı", allUsersResponses);

    }

    @Override
    public Result add(CreateUsersRequests user) {
        User user1 = this.mapperService.forRequest().map(user, User.class);


        this.iUserRepository.save(user1);

        return new SuccessResult("İşlem Başarılı");


    }

    @Override
    public Result delete(DeleteUsersRequests deleteUsersRequests) throws Exception {

        User user = this.iUserRepository.findAll().stream()
                .filter(u -> u.getId() == deleteUsersRequests.getId())
                .findFirst()
                .orElseThrow(() -> new Exception("do not find user " + deleteUsersRequests.getId()));

        this.iUserRepository.delete(user);
        return new SuccessResult("İşlem Başarılı" + user.getFirstName() + " Başarı ile silindi ");
    }

    @Override
    public Result update(int id, UpdateUsersRequests updateUsersRequests) {
        User updateUser = this.iUserRepository.getReferenceById(id);
        updateUser = this.mapperService.forRequest().map(updateUsersRequests, User.class);

        this.iUserRepository.save(updateUser);

        return new SuccessResult("Güncelleme Başarılı");
    }

    @Override
    public DataResult<GetByIdUserResponses> GET_BY_ID_RESPONSES(GetByIdRequests getByIdRequests) {
        User user = this.iUserRepository.getReferenceById(getByIdRequests.getId());
        GetByIdUserResponses getByIdResponses = this.mapperService.forRequest().map(user, GetByIdUserResponses.class);



        return new SuccessDataResult<GetByIdUserResponses>("İşlem Başarılı", getByIdResponses);
    }


}
