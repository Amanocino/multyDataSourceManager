package org.firstarr.stander.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.firstarr.stander") //你需要注入的Bean所在的包
public class IBasePointAspectConfig {
}
