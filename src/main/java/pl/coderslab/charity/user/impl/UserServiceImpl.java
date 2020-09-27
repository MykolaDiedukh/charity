package pl.coderslab.charity.user.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.user.UserRepository;
import pl.coderslab.charity.user.UserService;
import pl.coderslab.charity.user.domain.User;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final static String ERROR_MESSAGE = "User not found with id: ";
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(ERROR_MESSAGE + id));
    }

    @Override
    public Long User(User user) {
        User save = userRepository.save(user);
        return save.getId();
    }

    @Override
    public User update(User user, Long id) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(ERROR_MESSAGE + id));
        return userRepository.save(existingUser);
    }

    @Override
    public void delete(Long id) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(ERROR_MESSAGE + id));
        userRepository.delete(existingUser);
    }
}
