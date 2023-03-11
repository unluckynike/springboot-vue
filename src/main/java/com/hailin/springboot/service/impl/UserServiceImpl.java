package com.hailin.springboot.service.impl;

import com.hailin.springboot.entity.User;
import com.hailin.springboot.mapper.UserMapper;
import com.hailin.springboot.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lin
 * @since 2023-03-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
