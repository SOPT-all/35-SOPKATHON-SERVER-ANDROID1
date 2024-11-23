package sopkathon.android1.service;

import org.springframework.stereotype.Service;
import sopkathon.android1.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
