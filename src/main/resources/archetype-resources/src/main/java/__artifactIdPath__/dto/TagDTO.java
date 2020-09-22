package ${package}.${artifactIdPath}.dto;

/**
 * TODO
 *
 * @author yangjingting
 * @version 1.0
 * @date 2020/8/18 9:55
 */
public class TagDTO extends BaseDTO{
    private String tagid;
    private String tagname;

    public String getTagid() {
        return tagid;
    }

    public void setTagid(String tagid) {
        this.tagid = tagid;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }
}
