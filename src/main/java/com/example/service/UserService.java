package com.example.service;

/**
 * Created by Administrator on 2018/8/27.
 */

import com.example.bean.User;
import org.springframework.stereotype.Service;
import java.util.List;

public interface UserService {

    User getUserById(Integer id);

    public List<User> getUserList();

    public int add(User user);

    public int update(Integer id, User user);

    public int delete(Integer id);
}
