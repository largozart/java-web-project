package accountServer;

import resources.ResourceFactory;
import resources.TestResource;

public class ResourceServerImpl implements ResourceServer {

    TestResource testResource;

    public ResourceServerImpl() {
    }

    public ResourceServerImpl(TestResource testResource)
    {
        this.testResource= testResource;
    }

    @Override
    public String getName() {
        return testResource.getName();
    }

    @Override
    public int getAge() {
        return testResource.getAge();
    }

    @Override
    public void readResource(String path) {
        testResource = ResourceFactory.instance().getResource(path, TestResource.class);
    }
}
