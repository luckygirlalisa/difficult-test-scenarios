package needInvokeStaticMethodInDependency.solutionWithWrapper;

public class StaticDependencyWrapper {
    public String generateValueFromStatic() {
        return StaticDependency.generateSomeId();
    }
}
