package org.workfully;


/**
 * Hello world!
 */
public class Sandbox {

    public static void main(String[] args) {

        // HttpRequests.getHeaders("https://www.workfully.com");

        // HttpRequests.getStatusCode("https://www.workfully.com");

        //HttpRequests.getBody("https://httpbin.org/xml");

        // HttpRequests.postRequest("https://httpbin.org/post", "UsernameTest",
        // "tHiSiSnOtArEaLpAsSwOrD");

        // HttpRequests.postRequest("https://www.google.com", "UsernameTest",
        // "tHiSiSnOtArEaLpAsSwOrD");

        //Dialogue.init();

        //JSONHandler.jsonReader(HttpRequests.getBody("https://httpbin.org/json"));

        XMLParser.parse(HttpRequests.getBody("https://httpbin.org/xml"));

        


    }
}
