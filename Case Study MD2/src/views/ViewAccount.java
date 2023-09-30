package views;

import model.User;
import service.UserService;
import utils.DateUtils;
import utils.MyScanner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ViewAccount extends ViewAbstract{

    private static ViewAccount viewAccount;
    Scanner scanner;
    UserService userService;

    public ViewAccount() {
        scanner = MyScanner.scannerInstance();
        userService = UserService.userServiceInstance();
    }
    public static ViewAccount viewUserInstance() {
        if(viewAccount == null) {
            viewAccount = new ViewAccount();
        }
        return viewAccount;
    }

    private String getStringRole(int role) {
        if(role == 1) {
            return "ADMIN";
        } else {
            return "USER";
        }
    }

    private String inputId() {
        System.out.print("Enter id: ");
        return scanner.nextLine();
    }

    private String inputUsername() {
        System.out.print("Enter username: ");
        return scanner.nextLine();
    }

    private String inputPassword() {
        System.out.print("Enter password: ");
        return scanner.nextLine();
    }

    private String inputRePassword() {
        System.out.print("Enter rePassword: ");
        return scanner.nextLine();
    }

    private String inputEmail() {
        System.out.print("Enter email: ");
        return scanner.nextLine();
    }

    private String inputAddress() {
        System.out.print("Enter address: ");
        return scanner.nextLine();
    }

    private String inputPhone() {
        System.out.print("Enter phone: ");
        return scanner.nextLine();
    }

    private String inputRole() {
        System.out.print("Enter role Manage/Customer: ");
        return scanner.nextLine();
    }

    public int getInputId(){
        do {
            try {
                int id = Integer.parseInt(inputId());
                if(!userService.existsById(id)) {
                    System.out.println("Error: Id not exist");
                } else {
                    return id;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter string");
            }
        } while (true);
    }

    public String getInputUsername(String username, String action) {
        do {
            String usernameTemp = inputUsername();
            if(usernameTemp.isEmpty()) {
                if(action.equals("create") || action.equals("login")) {
                    System.out.println("Error: No username Entered");
                } else {
                    return username;
                }
            } else {
                if(userService.existsByUsername(usernameTemp)) {
                    if(action.equals("create") || action.equals("update")) {
                        System.out.println("Error: Username exist");
                    } else {
                        return usernameTemp;
                    }
                } else {
                    if(action.equals("login")) {
                        System.out.println("Error: Username not exist");
                    } else {
                        return usernameTemp;
                    }
                }
            }
        } while (true);
    }

    public String getInputPassword(String password, String action) {
        do {
            String passTemp = inputPassword();
            if(passTemp.isEmpty()) {
                if (action.equals("create") || action.equals("login")) {
                    System.out.println("Error: No password Entered");
                } else {
                    return password;
                }
            } else {
                return passTemp;
            }
        } while (true);
    }

    private void inputRePassword(String password) {
        do {
            String rePassword = inputRePassword();
            if(rePassword.isEmpty()) {
                System.out.println("Error: No password Entered");
            } else {
                if(rePassword.equals(password)) {
                    break;
                } else {
                    System.out.println("Error: Incorrect password");
                }
            }
        } while (true);
    }

    public String getInputEmail(String email, String action) {
        do {
            String emailTemp = inputEmail();
            if(emailTemp.isEmpty()) {
                if (action.equals("create")) {
                    System.out.println("Error: No email Entered");
                } else {
                    return email;
                }
            } else {
                return emailTemp;
            }
        } while (true);
    }

    public String getInputAddress(String address, String action) {
        do {
            String addressTemp = inputAddress();
            if(addressTemp.isEmpty()) {
                if (action.equals("create")) {
                    System.out.println("Error: No address Entered");
                } else {
                    return address;
                }
            } else {
                return addressTemp;
            }
        } while (true);
    }

    public String getInputPhone(String phone, String action) {
        do {
            String phoneTemp = inputPhone();
            if(phoneTemp.isEmpty()) {
                if (action.equals("create")) {
                    System.out.println("Error: No phone Entered");
                } else {
                    return phone;
                }
            } else {
                return phoneTemp;
            }
        } while (true);
    }

    public int getInputRole(int id, String action) {
        do {
            String roleStr = inputRole();
            if(roleStr.isEmpty()) {
                if(action.equals("create")) {
                    System.out.println("Error: No role Entered");
                } else {
                    return id;
                }
            } else {
                if (roleStr.equals("Manage")) {
                    return 1;
                } else if(roleStr.equals("Customer")) {
                    return 0;
                } else {
                    System.out.println("Error: Error role");
                }
            }
        } while (true);
    }

    public User formCU(User user) {
        String action;
        if(user.getId() != 0) {
            action = "update";
        } else {
            action = "create";
        }
        user.setUsername(getInputUsername(user.getUsername(), action));
        String rePass = user.getPassword();
        user.setPassword(getInputPassword(user.getPassword(), action));
        if(rePass == null) {
            inputRePassword(user.getPassword());
        } else {
            if(!rePass.equals(user.getPassword())) {
                inputRePassword(user.getPassword());
            }
        }
        user.setName(getInputName(user.getName(), action));
        user.setEmail(getInputEmail(user.getEmail(), action));
        user.setAddress(getInputAddress(user.getAddress(), action));
        user.setPhone(getInputPhone(user.getPhone(), action));
        user.setRole(0);
        user.setStatus(1);
        user.setChgDate(DateUtils.converter(LocalDateTime.now(), "dd-MM-yyyy HH:mm:ss"));
        return user;
    }

    public User formLogin() {
        User user = new User();
        user.setUsername(getInputUsername(user.getUsername(), "login"));
        user.setPassword(getInputPassword(user.getPassword() ,"login"));
        return user;
    }

    public void displayUser(User user) {
        System.out.printf("%-5s%-12s%-20s%-20s%-12s%-12s%s\n", "Id", "Username", "Name", "Email", "Address", "Phone", "Role");
        System.out.printf("%-5s%-12s%-20s%-20s%-12s%-12s%s\n", user.getId(), user.getUsername(), user.getName(), user.getEmail(), user.getAddress(), user.getPhone(), getStringRole(user.getRole()));
    }

    public void displayUsers(List<User> list) {
        System.out.printf("%-5s%-12s%-20s%-20s%-12s%-12s%s\n", "Id", "Username", "Name", "Email", "Address", "Phone", "Role");
        for (User item : list) {
            System.out.printf("%-5s%-12s%-20s%-20s%-12s%-12s%s\n", item.getId(), item.getUsername(), item.getName(), item.getEmail(), item.getAddress(), item.getPhone(), getStringRole(item.getRole()));
        }
    }

    public void userOrPassError() {
        System.out.println("Username or Password not active!");
    }


}
