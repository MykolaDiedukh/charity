package pl.coderslab.charity.user;

import pl.coderslab.charity.user.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    Long User(User user);

    User update(User user, Long id);

    void delete(Long id);
}
