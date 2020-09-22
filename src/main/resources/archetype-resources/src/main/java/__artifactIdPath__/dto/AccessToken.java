package ${package}.${artifactIdPath}.dto;

/**
 * TODO
 *
 * @author yangjingting
 * @version 1.0
 * @date 2020/8/18 14:07
 */
public class AccessToken {
    public String appName;


    private String accessToken;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
