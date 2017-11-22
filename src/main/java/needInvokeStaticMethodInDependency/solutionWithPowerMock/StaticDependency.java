package needInvokeStaticMethodInDependency.solutionWithPowerMock;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class StaticDependency {
    public static String generateSomeId(String test) {
        throw new NotImplementedException();
    }
}
