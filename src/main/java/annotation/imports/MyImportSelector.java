package annotation.imports;

import annotation.beans.OtherBean2;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * 被 @Import 导入后，Spring 容器会识别该类，因为该类实现了 ImportSelector 接口，于是会自动执行 selectImports 方法，
 * 将该方法返回的 全限定名，依次创建 bean 实例到 Spring 容器
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        // 参数 annotationMetadata 叫做注解媒体数据，该对象内部封装的是当前使用了@Import注解的类上的其他注解的源信息
        Map<String, Object> attributes = annotationMetadata.getAnnotationAttributes(ComponentScan.class.getName());
        // 当中存在着 属性名 -> 属性值
        String[] basePackages = (String[]) attributes.get("basePackages");
        System.out.println(basePackages[0]);

        // 返回的数组封装是需要被注册到 Spring 容器中的 Bean 的全限定名
        return new String[]{OtherBean2.class.getName()};
    }
}
