package ${package}.${artifactIdPath}.service.qyapi;

import ${basepackage}.dto.TextCardMessage;
import ${basepackage}.dto.TextMessage;

import java.io.IOException;

public interface MessageService {
    /**
     * 发送文本消息
     * @param textMessage
     * @return
     */
    String sendTextMessage(TextMessage textMessage);

    /**
     * 发送文本卡片消息
     * @param textCardMessage
     * @return
     */
    String sendTextCardMessage(TextCardMessage textCardMessage);

}
