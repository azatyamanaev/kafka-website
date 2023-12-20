package ru.kfu.kafkaWebSite.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.kfu.kafkaWebSite.dto.UserDto;
import ru.kfu.kafkaWebSite.dto.UserSignUpDto;
import ru.kfu.kafkaWebSite.mappers.base.EntityIdsMapper;
import ru.kfu.kafkaWebSite.model.User;

@Mapper(componentModel = "spring",
        uses = {EntityIdsMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    UserDto toUserDto(User user);

    User toUser(UserSignUpDto userDto);
}
