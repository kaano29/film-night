package de.volkswagen.filmnightbackend.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

        private UserRepository userRepository;

        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

    public Optional<UserEntity> getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    public Optional<List<String>> getUsersById(Long[] userIdList) {
            List<UserEntity> fetchedUsers = userRepository.findAll();
            List<String> fetchedUsernames = fetchedUsers.stream().filter(user -> {
                for (Long userId : userIdList) {
                    if (user.getId().equals(userId)) {
                        return true;
                    }
                }
                return false;
            }).map(UserEntity::getUsername).collect(Collectors.toList());
            return Optional.of(fetchedUsernames);
    }

    public UserEntity createUser(UserEntity user) {
        if (user.getId() != null && this.userRepository.findById(user.getId()).isPresent()) {
            throw new InvalidUserException();
        }
        return this.userRepository.save(user);
    }

    public UserEntity updateUser(UserEntity user) {
        Optional<UserEntity> oUser = this.userRepository.findById(user.getId());
        if (oUser.isPresent()) {
            return this.userRepository.save(user);
        }
        throw new UserNotFoundException();
    }


}
