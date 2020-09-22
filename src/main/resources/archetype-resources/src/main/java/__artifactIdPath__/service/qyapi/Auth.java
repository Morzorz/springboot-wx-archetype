package ${package}.${artifactIdPath}.service.qyapi;

import ${basepackage}.dto.AccessToken;
import ${basepackage}.propreties.AppsPropreties;

import java.io.IOException;

/**
 * TODO
 *
 * @author yangjingting
 * @version 1.0
 * @date 2020/8/14 10:11
 */
public interface Auth {

    /**
     * 获取accesstoken
     * @param appConfigs
     * @return
     */
    AccessToken getAccessToken(AppsPropreties.Appconfigs appConfigs,String type) ;
    /**
     * oauth2认证
     * @param appid,redirectUrl
     * @return
     */
    void authorize(String appid, String redirectUrl, String state);

    /**
     * 获取userinfo
     * @param code
     * @return
     */
    String getUserInfo(String code, String appName);
}
