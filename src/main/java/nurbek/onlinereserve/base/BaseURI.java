package nurbek.onlinereserve.base;

// Abduraximov Nurbek  1/8/2024   4:33 PM

public interface BaseURI {

    String API = "/api";
    String V1 = "/v1";
    String V2 = "/v2";

    String API_V1_PATH = API + V1;
    String API_V2_PATH = API + V2;

    String USER = "/user";
    String AUTH = "/auth";
    String AUTHENTICATE = "/authenticate";
    String MY = "/my";
    String ME = "/me";

    String APPOINTMENT = "/appointment";
    String BRANCH = "/branch";
    String COMMENT = "/comment";
    String NEWEST = "/newest";
    String FILE = "/file";

    String LIST = "/list";
    String TOP = "/top";
    String ONE = "/one";
    String FILTER = "/filter";

    String REGISTER = "/register";
    String GET = "/get";
    String CANCEL = "/cancel";
    String WRITE = "/write";
    String UPDATE = "/update";
    String RATE = "/rate";
    String BOOKED = "/booked";
    String FINISH = "/finish";
    String DELETE = "/delete";
    String ADD = "/add";
    String UPLOAD = "/upload";
    String PING = "/ping";

}
