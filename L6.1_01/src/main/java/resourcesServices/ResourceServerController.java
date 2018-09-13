package resourcesServices;

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
    public String getname() {
        return resource.getName();
    }

    @Override
    public int getage() {
        return resource.getAge();
    }

}
