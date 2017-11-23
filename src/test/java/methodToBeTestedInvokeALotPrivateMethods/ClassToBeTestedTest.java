package methodToBeTestedInvokeALotPrivateMethods;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ClassToBeTested.class)
public class ClassToBeTestedTest {

    @Test
    public void shouldMockPrivateMethod() throws Exception {
        ClassToBeTested spyClassToBeTested = PowerMockito.spy(new ClassToBeTested());

        PowerMockito.doReturn(true).when(spyClassToBeTested, "someActionInThisClass");

        assertEquals("Inter action excuted: true", spyClassToBeTested.toBeTested());
    }
}