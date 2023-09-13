package reflection;

import java.util.Set;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reflection.annotation.Controller;
import reflection.annotation.Repository;
import reflection.annotation.Service;

class ReflectionsTest {

    private static final Logger log = LoggerFactory.getLogger(ReflectionsTest.class);

    @Test
    void showAnnotationClass() throws Exception {
        Reflections reflections = new Reflections("reflection.examples");

        // TODO 클래스 레벨에 @Controller, @Service, @Repository 애노테이션이 설정되어 모든 클래스 찾아 로그로 출력한다.
        final Set<Class<?>> classes1 = reflections.getTypesAnnotatedWith(Controller.class);
        for (Class<?> clazz : classes1) {
            log.info("Controller 어노테이션 - {}", clazz.getTypeName());
        }

        final Set<Class<?>> classes2 = reflections.getTypesAnnotatedWith(Service.class);
        for (Class<?> clazz : classes2) {
            log.info("Service 어노테이션 - {}", clazz.getTypeName());
        }

        final Set<Class<?>> classes3 = reflections.getTypesAnnotatedWith(Repository.class);
        for (Class<?> clazz : classes3) {
            log.info("Repository 어노테이션 - {}", clazz.getTypeName());
        }
    }
}
