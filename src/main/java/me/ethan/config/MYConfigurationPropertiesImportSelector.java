package me.ethan.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

public class MYConfigurationPropertiesImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        MultiValueMap<String, Object> allAnnotationAttributes = importingClassMetadata.getAllAnnotationAttributes(EnableMyConfigurationProperties.class.getName());
        Class propertyClass = (Class) allAnnot용ationAttributes.getFirst("value");
        return new String[]{propertyClass.getName()};
    }
}
