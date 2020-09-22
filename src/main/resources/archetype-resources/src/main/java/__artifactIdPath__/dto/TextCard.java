package ${package}.${artifactIdPath}.dto;

/**
 * @Aouthor:yangjinhgting
 * @Description:卡片内容
 * @Date 11:07 2018/1/23
 */
public class TextCard extends BaseDTO{
    /**
     * 标题，不超过128个字节，超过会自动截断
     */
    private String title;
    /**
     * 描述，不超过512个字节，超过会自动截断
     */
    private String description;
    /**
     * 点击后跳转的链接
     */
    private String url;
    /**
     * 按钮文字。 默认为“详情”， 不超过4个文字，超过自动截断。
     */
    private String btntxt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBtntxt() {
        return btntxt;
    }

    public void setBtntxt(String btntxt) {
        this.btntxt = btntxt;
    }
}
