package com.wms.service;

import com.wms.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author THX
 * @since 2024-07-20
 */
public interface IUserService extends IService<User> {
    String getUserData();
}
