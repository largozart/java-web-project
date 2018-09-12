package accountServer;

import resources.TestResource;

/**
 * @author a.akbashev
 * @author v.chibrikov
 * <p>
 * Пример кода для курса на https://stepic.org/
 * <p>
 * Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class ResourceServerController implements ResourceServerControllerMBean {


    ResourceServer resource;

    public ResourceServerController() {
    }

    public ResourceServerController(ResourceServer resource) {
        this.resource = resource;
    }

    @Override
    public String getName() {
        return resource.getName();
    }

    @Override
    public int getAge() {
        return resource.getAge();
    }

}
