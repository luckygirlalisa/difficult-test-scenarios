package needInvokeStaticMethodInDependency.solutionWithWrapper;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InvokerTest {
    @Test
    public void generateSomethingFromStaticDependency() throws Exception {
        StaticDependencyWrapper dependencyWrapper = mock(StaticDependencyWrapper.class);
        when(dependencyWrapper.generateValueFromStatic()).thenReturn("preDefinedId");
        Invoker staticSample = new Invoker(dependencyWrapper);

        String result = staticSample.generateSomethingFromStaticDependency();

        assertEquals("Id is preDefinedId", result);
    }

}