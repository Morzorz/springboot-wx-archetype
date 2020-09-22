package ${package}.${artifactIdPath}.service.qyapi;

import ${basepackage}.dto.TagDTO;
import ${basepackage}.dto.TagUserDTO;

import java.io.IOException;

public interface TagService {

    /**
     * 创建标签
     * @return
     */
    String createTag(TagDTO tagDTO, String appName) throws IOException;

    /**
     * 增加标签成员
     * @return
     */
    String addTagUsers(TagUserDTO tagUserDTO, String appName) throws IOException;


    /**
     * 获取标签成员
     * @return
     */
    String getTagUsers(String appName, String tagid) throws IOException;

    /**
     * 删除标签成员
     * @return
     */
    String delTagUsers(TagUserDTO tagUserDTO, String appName) throws IOException;
}
