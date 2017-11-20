package dependencyHasInitializedComplexDependencyInParent;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.powermock.api.mockito.PowerMockito.mock;

public class InvokerTestWithInterfaceSeparation {
    Invoker invoker;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldNotCallDAOAndItsParentWithMockInterface() throws Exception {
        DaoInterface dao = mock(DaoInterface.class);

        Invoker invoker = new Invoker(dao);
        when(dao.doSomething()).thenReturn("mocked result");

        String result = invoker.invokeDao();

        assertEquals("mocked result", result);
    }

    @Test
    public void shouldNotCallDAOAndItsParentWithCreateClassOfInterface() throws Exception {
        Invoker invoker = new Invoker(new DaoInterface() {
            public String doSomething() {
                return "mocked result";
            }
        });

        String result = invoker.invokeDao();

        assertEquals("mocked result", result);
    }
}