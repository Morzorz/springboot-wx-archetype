package ${package}.${artifactIdPath}.dto;

/**
 * @Aouthor:yangjinhgting
 * @Description:文本卡片消息
 * @Date 11:01 2018/1/23
 */
public class TextCardMessage extends BaseDTO{
    /**
     * 成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送
     */
    private String touser;
    /**
     * 部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
     */
    private String toparty;
    /**
     * 标签ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
     */
    private String totag;
    /**
     * 消息类型，此时固定为：textcard
     */
    private String msgtype="textcard";
    /**
     * 	企业应用的id，整型。可在应用的设置页面查看
     */
    private int agentid;

    /**
     * 卡片内容
     */
    private TextCard textcard;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getToparty() {
        return toparty;
    }

    public void setToparty(String toparty) {
        this.toparty = toparty;
    }

    public String getTotag() {
        return totag;
    }

    public void setTotag(String totag) {
        this.totag = totag;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public int getAgentid() {
        return agentid;
    }

    public void setAgentid(int agentid) {
        this.agentid = agentid;
    }

    public TextCard getTextcard() {
        return textcard;
    }

    public void setTextcard(TextCard textcard) {
        this.textcard = textcard;
    }
}
