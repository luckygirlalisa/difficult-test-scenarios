package dependencyHasInitializedComplexDependencyInParent;

public class DaoImpl extends FrmDao implements DaoInterface {

    public String doSomething() {
        throw new UnsupportedOperationException();
    }
}
