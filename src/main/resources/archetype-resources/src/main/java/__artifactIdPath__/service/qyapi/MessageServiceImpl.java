package ${package}.${artifactIdPath}.service.qyapi;


import ${basepackage}.dto.TextCardMessage;
import ${basepackage}.dto.TextMessage;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * TODO
 *
 * @author yangjingting
 * @version 1.0
 * @date 2020/8/17 16:20
 */
@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    private RestTemplate restTemplate;

    @Value("${qywxapi.sendmessage}")
    private String sendMessage;

    /**
     * 发送文本消息
     *
     * @param textMessage
     * @return
     */
    @Override
    public String sendTextMessage(TextMessage textMessage)  {
        String body = restTemplate.postForObject(sendMessage,textMessage,String.class);
        return body;

    }

    /**
     * 发送文本卡片消息
     *
     * @param textCardMessage
     * @return
     */
    @Override
    public String sendTextCardMessage(TextCardMessage textCardMessage) {
        String body = restTemplate.postForObject(sendMessage,textCardMessage,String.class);
        return body;
    }

}
