package Tobeto.showRoomStore.mapper.user;

import org.modelmapper.ModelMapper;
public interface UserMapperService {

    ModelMapper forRequest();
    ModelMapper forResponse();
}
