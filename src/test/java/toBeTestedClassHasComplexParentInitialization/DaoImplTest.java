package toBeTestedClassHasComplexParentInitialization;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FrmDao.class)
public class DaoImplTest {

    @Test
    public void shouldBeAbleToInitDaoImplWithoutCallParent() throws Exception {
        PowerMockito.suppress(PowerMockito.constructor(FrmDao.class));
        PowerMockito.suppress(PowerMockito.fields(FrmDao.class));
        DaoImpl dao = new DaoImpl();

        dao.doSomething();

    }
}