package ${package}.${artifactIdPath}.dto;

import java.io.Serializable;

/**
 * TODO
 *
 * @author yangjingting
 * @version 1.0
 * @date 2020/8/18 9:58
 */
public class BaseDTO implements Serializable {
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
