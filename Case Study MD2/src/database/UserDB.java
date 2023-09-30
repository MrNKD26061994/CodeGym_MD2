package database;

import model.User;

import java.io.BufferedWriter;
import java.io.IOException;

public class UserDB extends AbstractDB<User> {


    @Override
    public User splitString(String str) {
        String[] arrStr = str.split(",");
        User user = new User();
        user.setId(Integer.parseInt(arrStr[0]));
        user.setUsername(arrStr[1]);
        user.setPassword(arrStr[2]);
        user.setName(arrStr[3]);
        user.setEmail(arrStr[4]);
        user.setAddress(arrStr[5]);
        user.setPhone(arrStr[6]);
        user.setRole(Integer.parseInt(arrStr[7]));
        user.setChgWho(arrStr[8]);
        user.setChgDate(arrStr[9]);
        user.setStatus(Integer.parseInt(arrStr[10]));
        return user;
    }

    @Override
    public void bufferedWriter(BufferedWriter bufferedWriter, User user) throws IOException {
        bufferedWriter.write(user.getId() + ",");
        bufferedWriter.write(user.getUsername() + ",");
        bufferedWriter.write(user.getPassword() + ",");
        bufferedWriter.write(user.getName() + ",");
        bufferedWriter.write(user.getEmail() + ",");
        bufferedWriter.write(user.getAddress() + ",");
        bufferedWriter.write(user.getPhone() + ",");
        bufferedWriter.write(user.getRole() + ",");
        bufferedWriter.write(user.getChgWho() + ",");
        bufferedWriter.write(user.getChgDate() + ",");
        bufferedWriter.write(user.getStatus() + "");
        bufferedWriter.newLine();
    }
}
