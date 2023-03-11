package com.hailin.springboot.service;

import com.hailin.springboot.controller.dto.UserDTO;
import com.hailin.springboot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hailin.springboot.exception.ServiceException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lin
 * @since 2023-03-09
 */
public interface IUserService extends IService<User> {
    UserDTO login(UserDTO userDTO);
    User register(UserDTO userDTO);

}
