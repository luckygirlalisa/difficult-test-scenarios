package toBeTestedClassHasComplexParentInitialization;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FrmPersistenceEntityManagerAccessor {

    private static FrmPersistenceEntityManagerAccessor accessor = new FrmPersistenceEntityManagerAccessor();

    private FrmPersistenceEntityManagerAccessor() {
        //Complex code here to prepare a lot of config files and communicate with third party library.
        throw new NotImplementedException();
    }

    public static FrmPersistenceEntityManagerAccessor getAccessor() {
        return accessor;
    }
}
