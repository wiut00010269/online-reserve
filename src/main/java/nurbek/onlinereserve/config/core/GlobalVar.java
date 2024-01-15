package nurbek.onlinereserve.config.core;

// Abduraximov Nurbek  1/9/2024   11:54 AM

public class GlobalVar {

    private final static ThreadLocal<String> H_REQUEST_ID = ThreadLocal.withInitial(String::new);

    public static void setRequestId(String requestId) {
        GlobalVar.H_REQUEST_ID.set(requestId);
    }

    public static String getRequestId() {
        return GlobalVar.H_REQUEST_ID.get();
    }


}
