package org.firstarr.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.firstarr") //你需要注入的Bean所在的包
public class IBasePointAspectConfig {
}
