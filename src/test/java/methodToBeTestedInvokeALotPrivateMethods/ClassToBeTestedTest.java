package methodToBeTestedInvokeALotPrivateMethods;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ClassToBeTested.class)
public class ClassToBeTestedTest {

    @Test
    public void shouldMockPrivateMethod() throws Exception {
        ClassToBeTested spyClassToBeTested = PowerMockito.spy(new ClassToBeTested());

        PowerMockito.doReturn(true).when(spyClassToBeTested, "someActionInThisClass");

        assertEquals("Inter action excuted: true", spyClassToBeTested.toBeTested());
    }

    @Test
    public void shouldStubPrivateMethodWithOutReturn() throws Exception {
        ClassToBeTested classToBeTested = PowerMockito.spy(new ClassToBeTested());

        PowerMockito.doNothing().when(classToBeTested, "someAction", anyString());
        String updated = classToBeTested.updateFlag("updated");

        assertThat("flag is not updated since method inside update flag is not called", updated, is("initial"));
    }
}