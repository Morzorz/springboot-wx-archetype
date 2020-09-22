package ${package}.${artifactIdPath}.init;


import ${basepackage}.dto.AccessToken;
import ${basepackage}.propreties.AppsPropreties;
import ${basepackage}.redis.WxRedisTemplate;
import ${basepackage}.service.qyapi.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 程序启动后执行
 * @author shaoml
 *
 */
@Slf4j
@Component
public class StartupRunner implements CommandLineRunner {

	@Autowired
	private WxRedisTemplate wxRedisTemplate;

	@Autowired
	private AppsPropreties appsPropreties;

	@Autowired
	private Auth auth;

	
	@Override
	public void run(String... arg0) throws Exception {
		log.info("==================程序启动后执行==========================");
		for ( AppsPropreties.Appconfigs appconfigs : appsPropreties.getApp()){
			log.info("==================开始循环==========================");
			if (!wxRedisTemplate.exit("accesstoken",appconfigs.getAgentId())){
				AccessToken accessToken=auth.getAccessToken(appconfigs,"0");//type 为 0，表示不检测是否存redis缓存
				if (!StringUtils.isEmpty(accessToken.getAccessToken())){
						log.info("==================查询结果=========================="+ toString().toString());
						wxRedisTemplate.setWithExpireTime("accesstoken",appconfigs.getAgentId(),accessToken.getAccessToken(),appsPropreties.getAccessTokenExpires().intValue());
						log.info("redis:{}",wxRedisTemplate.get("accesstoken",appconfigs.getAgentId()));

				}
			}else {
				log.info("redis已缓存:{}",wxRedisTemplate.get("accesstoken",appconfigs.getAgentId()));
			}
		}
//		log.info("系统启动完成，系统接口信息可访问：{}/xxxx/swagger-ui.html#/",host);

	}

}
