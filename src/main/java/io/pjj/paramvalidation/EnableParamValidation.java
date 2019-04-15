package io.pjj.paramvalidation;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({BeanValidAdvice.class, BeanValidator.class})
@EnableAspectJAutoProxy
public @interface EnableParamValidation {
}
