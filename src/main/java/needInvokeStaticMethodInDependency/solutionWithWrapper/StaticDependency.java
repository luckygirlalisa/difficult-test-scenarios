package needInvokeStaticMethodInDependency.solutionWithWrapper;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class StaticDependency {
    public static String generateSomeId() {
        throw new NotImplementedException();
    }
}
