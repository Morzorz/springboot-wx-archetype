package ${package}.${artifactIdPath}.dto;


import java.util.List;

/**
 * TODO
 * 用于新增/删除标签成员的入参
 * @author yangjingting
 * @version 1.0
 * @date 2020/8/18 10:01
 */
public class TagUserDTO extends BaseDTO{
    /**
     * 标签ID
     */
    private String tagid;
    /**
     * 企业成员ID列表，注意：userlist、partylist不能同时为空，单次请求个数不超过1000
     */
    private List<String> userlist;
    /**
     * 企业部门ID列表，注意：userlist、partylist不能同时为空，单次请求个数不超过100
     */
    private List<Long> partylist;


    public String getTagid() {
        return tagid;
    }

    public void setTagid(String tagid) {
        this.tagid = tagid;
    }
}
