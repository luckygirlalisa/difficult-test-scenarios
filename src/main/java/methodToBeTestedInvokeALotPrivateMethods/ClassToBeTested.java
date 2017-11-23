package methodToBeTestedInvokeALotPrivateMethods;

public class ClassToBeTested {

    public String toBeTested() {
        boolean interAction = someActionInThisClass();

        return "Inter action excuted: " + interAction;
    }

    private boolean someActionInThisClass() {

        throw new UnsupportedOperationException();
    }
}
