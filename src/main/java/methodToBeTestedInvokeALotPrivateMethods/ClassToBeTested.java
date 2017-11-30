package methodToBeTestedInvokeALotPrivateMethods;

public class ClassToBeTested {
    private String flag = "initial";

    public String toBeTested() {
        boolean interAction = someActionInThisClass();

        return "Inter action excuted: " + interAction;
    }

    private boolean someActionInThisClass() {

        throw new UnsupportedOperationException();
    }

    public String updateFlag(String updatedFlag) {
        System.out.println("update flag is called");
        someAction(updatedFlag);
        return flag;
    }

    private void someAction(String updatedFlag) {
        flag = updatedFlag;
        throw new UnsupportedOperationException();
    }
}
