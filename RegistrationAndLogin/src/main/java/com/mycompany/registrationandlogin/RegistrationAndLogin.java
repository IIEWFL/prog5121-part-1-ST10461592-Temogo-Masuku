/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.registrationandlogin;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author TEMOGO
 */
public class RegistrationAndLogin {

    // Class variables for storing user data
    public static Map<String, String> users = new HashMap<>(); // Stores username-password pairs
    private static Map<String, User> userDetails = new HashMap<>(); // Stores complete user objects

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         
        //Code Attribution
        //The case method was taken from Youtube
        //URL Link: https://www.youtube.com/watch?v=K7mwDy-U0xU
        //YouTube name:betacoding
        while (true) {
            System.out.println("\nRegistration and Login System");
            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("3.Exit");
            System.out.println("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    System.out.println("Goodbye thank you for using our services!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //Register an account
    private static void registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nRegistration");

        //Prompt user to enter username
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        
        //Code Atrribution
        //The if else method was taken from Youtube
        //URL Link: https://www.youtube.com/watch?v=yvWnj_HfG6s
        //Arthors name: Alex Lee
        
        // == method was taken from YouTube
        //URL Link:https://www.youtube.com/watch?v=9CVcmxYWm5U
        //Authors name: Alex Lee
        
        //.contains method was taken from YouTube 
        //URL Link:https://www.youtube.com/watch?v=nSYpFhlUFzM
        //Authors name: Dan Vega
        if (username == null || username.length() != 5 || !username.contains("_")) {
            System.out.println("Username not correctly captured!");
        } else {
            System.out.println("Username successfully captured!");
        }

        //Prompt user to enter password
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        
        //Code Attribution
        //The .matches method was taken from YouTube
        //URL Link:https://www.youtube.com/watch?v=KliNEG2pdYI
        //YouTube name: Ram N Java
        if (password == null || password.length() != 8 || !password.matches(".*[A-Z].*")
                || !password.matches(".*[0-9].*") || !password.matches(".*[^a-zA-Z0-9].*")) {
            System.out.println("Password not correctly formatted!");
            return;
        } else {
            System.out.println("Password successfully captured!");
        }

        //Confirm password
        while (true) {
            System.out.print("Confirm password: ");
            String confirmPassword = scanner.nextLine();

            
            //Code Attribution 
           //.equals method was taken from YouTube
           //URL Link:https://www.youtube.com/watch?v=9CVcmxYWm5U
           //Authors name: Alex Lee
            if (!password.equals(confirmPassword)) {
                System.out.println("Passwords do not match!");
            } else {
                break;
            }
        }

        //Prompt user for phone number
        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine();
      
        //Code Attribution
        // .startsWith method was taken from YouTube
        //URL Link:https://www.youtube.com/watch?v=1bGLsk8emew
        //YouTube name:Ram N Java
        if (phoneNumber == null || !phoneNumber.startsWith("(+27)") || phoneNumber.length() != 12) {
            System.out.println("Phone number is inValid!");
        } else {
            System.out.println("Phone number successfully captured!");
        }

        // Store user 
        users.put(username, password);
        userDetails.put(username, new User(username, password, phoneNumber));

        System.out.println("\nRegistration successful!");
        System.out.println("Registration Details:");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Phone Number: " + phoneNumber);
    }

    //Login to the account
    private static void loginUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nLogin");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        
        if (users.containsKey(username) && users.get(username).equals(password)) {
            User user = userDetails.get(username);
            System.out.println("\nWelcome " + username + " it is great to see you again!");
            System.out.println("\nUser Details:");
            System.out.println("Username: " + user.getUsername());
            System.out.println("Password: " + user.getPassword());
            System.out.println("Phone Number: " + user.getPhone());
        } else {
            System.out.println("Invalid username or password!");
        }
    }

    static class User {

        private String username;
        private String password;
        private String phone;

        public User(String username, String password, String phone) {
            this.username = username;
            this.password = password;
            this.phone = phone;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getPhone() {
            return phone;
        }
    }
}

class Login {

    public boolean checkUsername(String username) {
        return username != null && username.length() == 5 && username.contains("_");
    }

    public boolean checkPasswordComplexity(String password) {
        return password != null && password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*[0-9].*")
                && password.matches(".*[^a-zA-Z0-9].*");
    }

    public boolean checkCellPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.startsWith("(+27)") && phoneNumber.length() == 12;
    }

    public String registerUser(String username, String password, String phoneNumber) {
        if (!checkUsername(username)) {
            return "Username is not correctly formatted!";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted!";
        }
        return null; // Registration successful
    }

    public boolean loginUser(String username, String password) {
        return RegistrationAndLogin.users.containsKey(username)
                && RegistrationAndLogin.users.get(username).equals(password);
    }

    public String returnLoginStatus(boolean isSuccess) {
        return isSuccess ? "Login was successful!" : "Login failed. Please check your username and password.";
    }
}
