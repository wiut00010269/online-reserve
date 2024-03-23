package nurbek.onlinereserve.base;

// Abduraximov Nurbek  1/8/2024   4:33 PM

public interface BaseURI {

    String API = "/api";
    String V1 = "/v1";
    String V2 = "/v2";

    String API_V1_PATH = API + V1;
    String API_V2_PATH = API + V2;

    String APPOINTMENT = "/appointment";
    String BRANCH = "/branch";

    String REGISTER = "/register";
    String LIST = "/list";
    String GET = "/get";
    String CANCEL = "/cancel";

}
