package methodToBeTestedInvokeALotPrivateMethods;

public class ClassToBeTested {
    private String flag = "initial";

    public String action(String updatedFlag) {
        boolean configed = buildConfiguration();
        updateFlag(updatedFlag);

        return "Configed: " + configed;
    }

    private boolean buildConfiguration() {
        //Some complex logic.
        throw new UnsupportedOperationException();
    }

    private void updateFlag(String updatedFlag) {
        flag = updatedFlag;
        //More complex logic.
        throw new UnsupportedOperationException();
    }

    public String getFlag() {
        return flag;
    }
}
