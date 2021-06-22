package com.aski.issue.service.impl;


import com.aski.issue.dto.UserDto;
import com.aski.issue.service.UserService;
import com.aski.issue.util.TPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by temelt on 4.02.2019.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Override
    public UserDto save(UserDto user) {
        return null;
    }

    @Override
    public UserDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<UserDto> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public UserDto getByUsername(String username) {
        return null;
    }
}
