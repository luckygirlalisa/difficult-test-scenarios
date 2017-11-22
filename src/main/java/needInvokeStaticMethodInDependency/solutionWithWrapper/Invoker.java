package needInvokeStaticMethodInDependency.solutionWithWrapper;


public class Invoker {
    StaticDependencyWrapper wrapper = new StaticDependencyWrapper();

    public Invoker(StaticDependencyWrapper wrapper) {
        this.wrapper = wrapper;
    }

    public String generateSomethingFromStaticDependency() {
        String someId = wrapper.generateValueFromStatic();

        return "Id is " + someId;
    }

}
