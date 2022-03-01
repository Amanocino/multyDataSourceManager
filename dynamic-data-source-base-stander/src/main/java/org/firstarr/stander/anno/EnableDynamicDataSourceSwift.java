package org.firstarr.stander.anno;

import org.firstarr.stander.Config.IBasePointAspectConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import({IBasePointAspectConfig.class})
public @interface EnableDynamicDataSourceSwift {
}
