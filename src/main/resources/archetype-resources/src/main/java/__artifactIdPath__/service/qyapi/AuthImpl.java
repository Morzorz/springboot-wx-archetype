package ${package}.${artifactIdPath}.service.qyapi;


import com.alibaba.fastjson.JSONObject;
import ${basepackage}.dto.AccessToken;
import ${basepackage}.propreties.AppsPropreties;
import ${basepackage}.redis.WxRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger;

/**
 * TODO
 *
 * @author yangjingting
 * @version 1.0
 * @date 2020/8/17 16:09
 */
@Service
public class AuthImpl implements Auth{
    private static final Logger logger = Logger.getLogger("AuthImpl.class");

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WxRedisTemplate wxRedisTemplate;

    @Value("${qywxapi.getaccesstoken}")
    private String getAccessToken;

    @Value("${qywxapi.getuserinfo}")
    private String getUserInfo;

    @Value("${qywxapi.authorize}")
    private String authorize;
    /**
     * 获取accesstoken
     *
     * @param appConfigs
     *
     * @return
     */
    @Override
    public AccessToken getAccessToken(AppsPropreties.Appconfigs appConfigs,String type)  {
        AccessToken accessToken = new AccessToken();
        Assert.notNull(type,"type can't be null");
        if(type.equals("1")){//1 表示需要先检测缓存是否存在
            String  strToken = wxRedisTemplate.get("accesstoken",appConfigs.getAgentId());
            if(StringUtils.isEmpty(strToken)){
                accessToken = getAccessToken(appConfigs, accessToken);
            }else{
                accessToken.setAccessToken(strToken);
                accessToken.setAppName(appConfigs.getAppName());
            }
        }
        accessToken = getAccessToken(appConfigs, accessToken);
        return accessToken;
    }


    private AccessToken getAccessToken(AppsPropreties.Appconfigs appConfigs, AccessToken accessToken) {
        String body = restTemplate.getForObject(String.format(getAccessToken, appConfigs.getCorpid(), appConfigs.getCorpsecret()), String.class);
        String access_token = JSONObject.parseObject(body).get("access_token").toString();
        accessToken.setAppName(appConfigs.getAppName());
        accessToken.setAccessToken(access_token);
        return accessToken;
    }

    /**
     * oauth2认证
     *
     * @param appid
     * @param redirectUrl
     * @return
     */
    @Override
    public void authorize(String appid, String redirectUrl,String state)  {
        restTemplate.getForObject(String.format(authorize,appid,redirectUrl,state),null);
    }

    /**
     * 获取userinfo
     *
     * @param code
     * @param accessToken
     * @return
     */
    @Override
    public String getUserInfo(String code, String accessToken) {
        String body = restTemplate.getForObject(String.format(getUserInfo, accessToken, code),String.class);
        return body;
    }

}
