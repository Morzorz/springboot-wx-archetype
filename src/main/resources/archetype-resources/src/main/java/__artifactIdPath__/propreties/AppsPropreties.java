package ${package}.${artifactIdPath}.propreties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author yangjingting
 * @version 1.0
 * @date 2020/8/18 14:19
 */
@Component
@PropertySource("classpath:wechatwork-${spring.profiles.active}.properties")
@ConfigurationProperties(prefix = "wechatwork")
public class AppsPropreties {

   private final static  Long DEFAULT_EXPIRES_SECOND=Long.valueOf(60*60*2);

   private Long accessTokenExpires=DEFAULT_EXPIRES_SECOND;

   public Long getAccessTokenExpires() {
      return accessTokenExpires;
   }

   public void setAccessTokenExpires(Long accessTokenExpires) {
      this.accessTokenExpires = accessTokenExpires;
   }

   public List<Appconfigs> getApp() {
      return app;
   }

   public void setApp(List<Appconfigs> app) {
      this.app = app;
   }

   private List<Appconfigs> app=new ArrayList();



   public static class Appconfigs {
      public String getAppName() {
         return appName;
      }

      public void setAppName(String appName) {
         this.appName = appName;
      }

      public String getCorpid() {
         return corpid;
      }

      public void setCorpid(String corpid) {
         this.corpid = corpid;
      }

      public String getCorpsecret() {
         return corpsecret;
      }

      public void setCorpsecret(String corpsecret) {
         this.corpsecret = corpsecret;
      }

      public String getAgentId() {
         return agentId;
      }

      public void setAgentId(String agentId) {
         this.agentId = agentId;
      }

      private String appName;

      private String corpid;

      private String corpsecret;

      private String agentId;

   }


}
