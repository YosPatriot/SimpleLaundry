
package app.services;

public class UserSession {
    
    private static String userLogin;
    private static int UserId;
    
    public static void setUserLogin(String userLogin) {
        UserSession.userLogin = userLogin;
    }
    public static void setUserId(int UserId) {
        UserSession.UserId = UserId;
    }
    
    public static String getUserLogin() {
        return userLogin;
    }
    public static int GetUserId(){
        return UserId;
    }
}