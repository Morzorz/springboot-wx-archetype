package ${package}.${artifactIdPath}.service.qyapi;


import ${basepackage}.dto.TagDTO;
import ${basepackage}.dto.TagUserDTO;
import ${basepackage}.enums.TagHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



/**
 * TODO
 *
 * @author yangjingting
 * @version 1.0
 * @date 2020/8/18 9:34
 */
@Service
public class TagServiceImpl implements TagService{

    @Autowired
    private RestTemplate restTemplate;
    @Value("${qywxapi.taghandle}")
    private String tagHandle;

    /**
     * 创建标签
     *
     * @param tagDTO
     * @return
     */
    @Override
    public String createTag(TagDTO tagDTO,String appName)  {
        String url = String.format(tagHandle, TagHandle.CREATE.getValue(), tagDTO.getAccessToken());
        String body = restTemplate.postForObject(url,tagDTO,String.class);
        return body;
    }

    /**
     * 增加标签成员
     *
     * @param tagUserDTO
     * @return
     */
    @Override
    public String addTagUsers(TagUserDTO tagUserDTO,String appName) {
        String url = String.format(tagHandle, TagHandle.ADDTAGUSERS.getValue(), tagUserDTO.getAccessToken());
        String body = restTemplate.postForObject(tagHandle,tagUserDTO,String.class);
        return body;
    }

    /**
     * 获取标签成员
     *
     * @param accesstoken
     * @param tagid
     * @return
     */
    @Override
    public String getTagUsers(String accesstoken, String tagid)  {

        String url = String.format(tagHandle, TagHandle.GET.getValue(), accesstoken);
        String body = restTemplate.getForObject(url,String.class);
        return body;
    }

    /**
     * 删除标签成员
     *
     * @param tagUserDTO
     * @return
     */
    @Override
    public String delTagUsers(TagUserDTO tagUserDTO,String appName){

        String url = String.format(tagHandle, TagHandle.DELTAGUSERS.getValue(), tagUserDTO.getAccessToken());
        String body = restTemplate.postForObject(url,tagUserDTO,String.class);
        return body;
    }
}
