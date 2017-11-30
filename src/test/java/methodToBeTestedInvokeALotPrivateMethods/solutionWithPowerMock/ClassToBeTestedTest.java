package methodToBeTestedInvokeALotPrivateMethods.solutionWithPowerMock;

import methodToBeTestedInvokeALotPrivateMethods.ClassToBeTested;
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
    public void shouldSpyPrivateMethod() throws Exception {
        ClassToBeTested spyClassToBeTested = PowerMockito.spy(new ClassToBeTested());

        PowerMockito.doReturn(true).when(spyClassToBeTested, "buildConfiguration");
        PowerMockito.doNothing().when(spyClassToBeTested, "updateFlag", anyString());

        String configedStatus = spyClassToBeTested.action(null);

        assertEquals("Configed: true", configedStatus);
        String updated = spyClassToBeTested.getFlag();
        assertThat("flag is not updated since update flag is not called", updated, is("initial"));
    }

    @Test
    public void shouldSpyPrivateMethodWithOtherScenario() throws Exception {
        ClassToBeTested spyClassToBeTested = PowerMockito.spy(new ClassToBeTested());

        PowerMockito.doReturn(false).when(spyClassToBeTested, "buildConfiguration");
        PowerMockito.doNothing().when(spyClassToBeTested, "updateFlag", anyString());

        String configedStatus = spyClassToBeTested.action(null);

        assertEquals("Configed: false", configedStatus);
        String updated = spyClassToBeTested.getFlag();
        assertThat("flag is not updated since update flag is not called", updated, is("initial"));
    }


}