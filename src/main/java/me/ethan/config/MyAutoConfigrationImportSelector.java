package me.ethan.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigrationImportSelector implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                "me.ethan.config.autoconfig.DispatcherServletConfig",
                "me.ethan.config.autoconfig.TomcatWebServerConfig"
        };
    }
}