package methodToBeTestedInvokeALotPrivateMethods.solutionWithJmockit;

import methodToBeTestedInvokeALotPrivateMethods.ClassToBeTested;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ClassToBeTestedTest {

    class MockedClassToBeTestedForBuildConfig extends MockUp<ClassToBeTested> {
        @Mock
        private boolean buildConfiguration() {
            return true;
        }

        @Mock
        private void updateFlag(String updatedFlag) {

        }
    }

    class MockedClassToBeTestedForNotBuildConfig extends MockUp<ClassToBeTested> {
        @Mock
        private boolean buildConfiguration() {
            return false;
        }

        @Mock
        private void updateFlag(String updatedFlag) {

        }
    }

    @Test
    public void shouldSpyPrivateMethod() throws Exception {
        new MockedClassToBeTestedForBuildConfig();
        ClassToBeTested classToBeTested = new ClassToBeTested();

        String configedStatus = classToBeTested.action(null);

        assertEquals("Configed: true", configedStatus);
        String updated = classToBeTested.getFlag();
        assertThat("flag is not updated since update flag is not called", updated, is("initial"));
    }

    @Test
    public void shouldSpyPrivateMethodWithOtherScenario() throws Exception {
        new MockedClassToBeTestedForNotBuildConfig();
        ClassToBeTested classToBeTested = new ClassToBeTested();

        String configedStatus = classToBeTested.action(null);

        assertEquals("Configed: false", configedStatus);
        String updated = classToBeTested.getFlag();
        assertThat("flag is not updated since update flag is not called", updated, is("initial"));
    }

}
