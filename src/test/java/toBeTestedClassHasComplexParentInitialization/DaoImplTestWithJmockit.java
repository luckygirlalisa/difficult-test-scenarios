package toBeTestedClassHasComplexParentInitialization;

import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

public class DaoImplTestWithJmockit {

    class MockedDao extends MockUp<DaoImpl> {
        @Mock
        void $clinit() {
            //mock constructor do nothing
        }

    }

    @Test
    public void shouldBeAbleToInitDaoImplWithOutCallParent() throws Exception {
        new MockedDao();

        DaoImpl dao = new DaoImpl();

        dao.doSomething();
    }
}