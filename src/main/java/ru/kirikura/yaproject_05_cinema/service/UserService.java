package ru.kirikura.yaproject_05_cinema.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kirikura.yaproject_05_cinema.exceptions.ObjectNotFoundException;
import ru.kirikura.yaproject_05_cinema.exceptions.ValidationException;
import ru.kirikura.yaproject_05_cinema.model.User;
import ru.kirikura.yaproject_05_cinema.service.validation.FilmVaidation;
import ru.kirikura.yaproject_05_cinema.service.validation.UserValidation;
import ru.kirikura.yaproject_05_cinema.dao.FilmStorage;
import ru.kirikura.yaproject_05_cinema.dao.impl.UserStorageInMemory;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    FilmStorage filmStorage;
    UserStorageInMemory userStorage;
    FilmVaidation filmVaidation;
    UserValidation userValidation;
    public List<User> findAllUsers() throws ObjectNotFoundException {
        userValidation.checkIsUsersEmpty(userStorage);
        return userStorage.findAllUsers();
    }
    public User addUser(User user) throws ValidationException {
        userValidation.checkIsUserDataCorrect(user);
        return userStorage.addUser(user);
    }

    public User updateUser(User user) throws ValidationException, ObjectNotFoundException {
        userValidation.checkIsUserDataCorrect(user);
        userValidation.checkIsUserExists(userStorage, user.getId());
        return userStorage.updateUser(user);
    }

    public User getUserById(int id) throws ObjectNotFoundException {
        userValidation.checkIsUserExists(userStorage, id);
        return userStorage.getUserById(id);
    }

    public void deleteUserById(int id) throws ObjectNotFoundException {
        userValidation.checkIsUserExists(userStorage, id);
        userStorage.deleteUserById(id);
    }
    public void deleteAllUsers() {
        userStorage.deleteAllUsers();
    }
    public void addFriend(int userId, int friendId) throws ObjectNotFoundException {
        userValidation.checkIsUserExists(userStorage, userId);
        userValidation.checkIsUserExists(userStorage, friendId);
        userStorage.addFriend(userId, friendId);
    }
    public void removeFriend(int userId, int friendId) throws ObjectNotFoundException {
        userValidation.checkIsUserExists(userStorage, userId);
        userValidation.checkIsUserExists(userStorage, friendId);
        userStorage.removeFriend(userId, friendId);
    }

    public List<User> findAllFriends(int userId) throws ObjectNotFoundException {
        userValidation.checkIsUserExists(userStorage, userId);
        return userStorage.findAllFriends(userId);
    }

    public List<User> findAllSameFriends(int userId, int anotherUserId) throws ObjectNotFoundException {
        userValidation.checkIsUserExists(userStorage, userId);
        userValidation.checkIsUserExists(userStorage, anotherUserId);
        return userStorage.findAllSameFriends(userId, anotherUserId);
    }
}