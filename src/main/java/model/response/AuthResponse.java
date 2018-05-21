package model.response;

/**
 * Created by 986296 on 5/21/2018.
 */
public class AuthResponse {
    private String auth;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}
