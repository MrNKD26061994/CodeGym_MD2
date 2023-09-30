package service;

import database.UserDB;
import model.User;

import java.util.List;

public class UserService {
    private static UserService userService;
    private final List<User> users;
    private final UserDB userDB;

    public UserService() {
        userDB = new UserDB();
        users = userDB.findAll("Users.txt");
    }

    public static UserService userServiceInstance() {
        if(userService == null) {
            userService = new UserService();
        }
        return userService;
    }
    public void create(User user) {
        user.setId(createNewId());
        userDB.writeFile("Users.txt", user);
        users.add(user);
    }
    public void update(User user) {
        for (int i = 0; i < users.size() - 1; i++) {
            if(users.get(i).getId() == user.getId()) {
                users.set(i + 1, user);
                break;
            }
        }
        userDB.writeFile("Users.txt", users);
    }
    public int login(User user) {
        if (checkLogin(user)){
            if(getRole(user.getUsername()) == 1) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }
    public boolean checkLogin(User user){
        for (User item : users) {
            if (item.getUsername().equals(user.getUsername())
            && item.getPassword().equals(user.getPassword())
            && item.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }
    public boolean existsByUsername(String username) {
        for(User item : users) {
            if(item.getUsername().equals(username)) return true;
        }
        return false;
    }
    public boolean existsById(int id) {
        for(User item : users) {
            if(item.getId() == id) return true;
        }
        return false;
    }
    private int createNewId() {
        if(users.isEmpty()){
            return 1;
        } else {
            return users.stream().max((o1, o2) -> o1.getId() - o2.getId()).get().getId() + 1;
        }
    }
    public User getUserByUserName(String username) {
        for (User item : users){
            if(item.getUsername().equals(username)) {
                return item;
            }
        }
        return null;
    }
    public List<User> getUsers() {
        return users;
    }
    public int getRole(String username) {
        for (User item : users) {
            if(item.getUsername().equals(username)) {
                return item.getRole();
            }
        }
        return -1;
    }
    public User getUserById(int id) {
        for (User item : users){
            if(item.getId() == id) {
                return item;
            }
        }
        return null;
    }


}
