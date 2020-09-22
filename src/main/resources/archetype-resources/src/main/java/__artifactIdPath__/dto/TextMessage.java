package ${package}.${artifactIdPath}.dto;


/**
 * 文本消息
 * @author guowanfeng on 2017/10/25.
 * @version 1.0
 */

public class TextMessage extends BaseDTO {

    /**
     * 成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，则向该企业应用的全部成员发送
     */
    private String touser;

    /**
     * 	部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
     */
    private String toparty;

    /**
     * 标签ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
     */
    private String totag;

    /**
     * 消息类型，此时固定为text
     */
    private String msgtype="text";

    /**
     * 企业应用的id，整型。可在应用的设置页面查看
     */
    private int agentid;

    /**
     * 消息内容，最长不超过2048个字节
     */
    private TextDTO text;

    /**
     * 表示是否是保密消息，0表示否，1表示是，默认0
     */
    private int safe=0;


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

    public TextDTO getText() {
        return text;
    }

    public void setText(TextDTO text) {
        this.text = text;
    }

    public int getSafe() {
        return safe;
    }

    public void setSafe(int safe) {
        this.safe = safe;
    }
}
