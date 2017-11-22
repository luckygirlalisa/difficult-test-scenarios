package needInvokeStaticMethodInDependency.solutionWithPowerMock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StaticDependency.class)
public class InvokerTest {

    private Invoker invoker;

    @Before
    public void setUp() {
        invoker = new Invoker();
    }

    @Test
    public void shouldGetPreDefinedOutputFromStaticMethod() throws Exception {
        PowerMockito.mockStatic(StaticDependency.class);
        Mockito.when(StaticDependency.generateSomeId("test")).thenReturn("preFakedId");

        String result = invoker.generateSomethingFromStaticDependency("test");

        assertEquals("Id is preFakedId", result);
        PowerMockito.verifyStatic(StaticDependency.class, Mockito.times(1));
        StaticDependency.generateSomeId("test");
    }
}
