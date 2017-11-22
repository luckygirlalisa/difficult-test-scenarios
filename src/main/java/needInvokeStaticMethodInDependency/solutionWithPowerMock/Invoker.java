package needInvokeStaticMethodInDependency.solutionWithPowerMock;


public class Invoker {
    public String generateSomethingFromStaticDependency(String test) {
        String someId = StaticDependency.generateSomeId(test);

        return "Id is " + someId;
    }
}
