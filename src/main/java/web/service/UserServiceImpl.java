package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao dao;
    public UserServiceImpl(UserDao dao) { this.dao = dao; }

    @Override public List<User> findAll() { return dao.findAll(); }
    @Override public User findById(Long id) { return dao.findById(id); }
    @Override public void save(User user) { dao.save(user); }
    @Override public void update(User user) { dao.update(user); }
    @Override public void delete(Long id) { dao.delete(id); }
}