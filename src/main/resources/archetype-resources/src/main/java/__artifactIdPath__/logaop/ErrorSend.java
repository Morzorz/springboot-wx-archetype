package ${package}.${artifactIdPath}.logaop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Aouthor:yangjinhgting
 * @Description:
 * @Date 15:35 2019/4/18
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ErrorSend {

     String value();

     String charge() default "";

     String agentId() default "xxxx";//此处可配置一个默认的企业微信agentId
}
