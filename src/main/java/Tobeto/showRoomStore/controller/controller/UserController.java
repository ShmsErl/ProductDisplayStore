package Tobeto.showRoomStore.controller.controller;
import Tobeto.showRoomStore.dto.request.DeleteUsersRequests;
import Tobeto.showRoomStore.dto.request.UpdateUsersRequests;
import Tobeto.showRoomStore.dto.response.GetAllUsersResponses;
import Tobeto.showRoomStore.service.Abstract.IUserService;
import Tobeto.showRoomStore.core.utilities.result.DataResult;
import Tobeto.showRoomStore.core.utilities.result.Result;
import Tobeto.showRoomStore.dto.request.CreateUsersRequests;
import Tobeto.showRoomStore.dto.request.GetByIdRequests;
import Tobeto.showRoomStore.dto.response.GetByIdResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
//@AllArgsConstructor
@RequiredArgsConstructor
public class UserController {

    private final IUserService iUserService;


        @GetMapping("/getAll")
        public DataResult<List<GetAllUsersResponses>> getAllUser() {
            return this.iUserService.getAllUser();
        }

        @PostMapping()
        public Result add(@RequestBody CreateUsersRequests user) {
            return this.iUserService.add(user);
        }

        @DeleteMapping("/{id}")
        public Result delete(@PathVariable DeleteUsersRequests deleteUsersRequests) throws Exception {
            return this.iUserService.delete(deleteUsersRequests);
        }
        @PutMapping("/{id}")
        public Result update(@PathVariable int id, @RequestBody UpdateUsersRequests updateUsersRequests){
            return  this.iUserService.update(id,updateUsersRequests);


        }
        @GetMapping("/{id}")
        public DataResult<GetByIdResponses> GET_BY_ID_RESPONSES(GetByIdRequests getByIdRequests) {

                return this.iUserService.GET_BY_ID_RESPONSES(getByIdRequests);
        }








}
