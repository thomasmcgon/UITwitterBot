package com.testframework;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TwitterAccount account = new TwitterAccount();
        System.out.println("Username: " + account.getUsername());
        System.out.println("Password: " + account.getPassword());
    }
}
