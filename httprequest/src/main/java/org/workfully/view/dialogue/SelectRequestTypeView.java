package org.workfully.view.dialogue;

import java.util.Scanner;

import org.workfully.requests.HttpRequests;

public class SelectRequestTypeView {

    public static void init() {
        selectionDialogue();
    }

    private static void selectionDialogue() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter URL: ");
        String url = sc.nextLine();

        System.out.println("Select Operation;");
        System.out.println("[1] -> GET");
        System.out.println("[2] -> POST");
        System.out.println("[3] -> EXIT");
        int requestType = sc.nextInt();

        selectionMenu(url, requestType);
    }

    private static void selectionMenu(String url, int requestType) {

        Scanner sc = new Scanner(System.in);
        final int GET = 1;
        final int POST = 2;
        final int EXIT = 3;

        switch (requestType) {
            case GET:
                HttpRequests.getStatusCode(url);
                HttpRequests.getHeaders(url);
                HttpRequests.getBody(url);
                break;
            case POST:
                System.out.print("Username: ");
                String username = sc.nextLine();
                System.out.println("");
                System.out.print("Password: ");
                String password = sc.nextLine();
                HttpRequests.postRequest(url, username, password);
            case EXIT:
                System.exit(0);
            default:
                selectionDialogue();
                break;
        }
    }
}
