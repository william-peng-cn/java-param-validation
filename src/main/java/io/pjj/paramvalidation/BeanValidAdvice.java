package io.pjj.paramvalidation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

@Aspect
@Component
public class BeanValidAdvice {
    @Autowired
    private BeanValidator beanValidator;

    @Before("@annotation(io.pjj.paramvalidation.ParamValid)")
    public void validateParams(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Parameter[] parameters = method.getParameters();
        Object[] args = joinPoint.getArgs();

        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            Object arg = args[i];
            validateSingleParam(parameter, arg);
        }
    }

    private void validateSingleParam(Parameter parameter, Object arg) {
        Annotation[] annotations = parameter.getAnnotations();
        if (annotations == null || annotations.length == 0
                || parameter.getAnnotation(Valid.class) == null) {
            return;
        }

        List<String> msgList = beanValidator.validate(arg);
        if (msgList.size() > 0) {
            throw new IllegalArgumentException(msgList.toString());
        }
    }


}
