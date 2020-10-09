package ${package}.${artifactIdPath}.logaop;

import com.alibaba.fastjson.JSON;
import ${basepackage}.dto.TextDTO;
import ${basepackage}.dto.TextMessage;
import ${basepackage}.service.qyapi.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
/**
 * @Aouthor:yangjinhgting
 * @Description:
 * @Date 9:59 2020/09/22
 */
@Aspect
@Component
@Slf4j
public class AopLogConsole {
    @Pointcut("execution(public * ${package}.${artifactIdPath}.service.*..*..*(..))")
    public void poinCut() {
    }

    @Autowired
    private MessageService messageService;
    private static String MSG = "移动端审批-%s-接口%s返回异常。详情%s";
    private static String USERS = "yangjingting|chul|%s";

    @Around("poinCut()")
    public Object arroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object result = null;
        long currentTimeMillis = System.currentTimeMillis();
        Object[] args = joinPoint.getArgs();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        result = joinPoint.proceed(args);
        long l = System.currentTimeMillis() - currentTimeMillis;
        printLog(className,methodName,args,result,l);
        return result;


    }

    @AfterThrowing(throwing = "e", pointcut = "poinCut()")
    public void doAfterThrow(JoinPoint joinPoint, Throwable e) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        String methodName = joinPoint.getSignature().getName();
        Method declaredMethod = null;
        try {
            declaredMethod = joinPoint.getTarget()//获取被代理的对象
                    .getClass().getDeclaredMethod(joinPoint.getSignature().getName(), method.getParameterTypes());
        } catch (NoSuchMethodException ex) {
            log.error(ex.getMessage(), ex);
        }
        //根据是否存在注解 判断是否要发送错误提醒
        if (declaredMethod!=null&&declaredMethod.getAnnotation(ErrorSend.class) != null) {
            ErrorSend customAt = declaredMethod.getAnnotation(ErrorSend.class);
            //注意，不要给sendErrorMessage方法添加@CustomAt注解，可能陷入循环调用，导致栈溢出
            sendErrorMessage(String.format(MSG,customAt.value(),methodName,e),USERS,customAt.agentId());
            log.error(String.format(MSG,customAt.value(),methodName,e));
        }
    }

    private boolean isJSON(Object object) {
        if (object == null) {
            return false;
        }
        try {
            JSON.toJSONString(object);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void printLog(String className,String methodName,Object[] args,Object result,Long l){
        log.info("*******************************************接口日志***************************************");
        log.info("调用方法：{}.{}", className, methodName, isJSON(args) ? JSON.toJSONString(args) : args);
        log.info("接口入参：{}", isJSON(args) ? JSON.toJSONString(args) : args);
        log.info("接口出参：{}", isJSON(result) ? JSON.toJSONString(result) : result);
        log.info("接口耗时(ms)：{}", l);
        log.info("*****************************************************************************************");
    }

    private void sendErrorMessage(String content,String users,String agentId) {
        TextMessage textMessage = new TextMessage();
        textMessage.setTouser(users);
        TextDTO textDto = new TextDTO();
        textDto.setContent(content);
        textMessage.setText(textDto);
        textDto.setAccessToken("");
        textMessage.setAgentid(Integer.valueOf(agentId));
        log.info("消息发送返回{}",JSON.toJSONString(messageService.sendTextMessage(textMessage)));
    }
}
