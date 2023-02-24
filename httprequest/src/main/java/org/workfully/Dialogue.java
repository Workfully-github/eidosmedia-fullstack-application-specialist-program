package org.workfully;

import java.util.Scanner;

public class Dialogue {

    public static void init(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter URL: ");
        String url = sc.nextLine();

        System.out.println("Enter Method (GET or POST)");
        String requestType = sc.nextLine();

        switch (requestType) {
            case "GET":
                HttpRequests.getBody(url);
                break;
            case "POST":
                System.out.print("Username: ");
                String username = sc.nextLine();
                System.out.println("");
                System.out.print("Password: ");
                String password = sc.nextLine();
                HttpRequests.postRequest(url, username, password);
            default:
                break;
        }
    }
}
