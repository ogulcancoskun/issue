package com.aski.issue.service;

import com.aski.issue.dto.UserDto;
import com.aski.issue.util.TPage;
import org.springframework.data.domain.Pageable;

/**
 * Created by temelt on 4.02.2019.
 */
public interface UserService {

    UserDto save(UserDto user);

    UserDto getById(Long id);

    TPage<UserDto> getAllPageable(Pageable pageable);

    UserDto getByUsername(String username);
}
