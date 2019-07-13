package InterfacesAndAbstraction.MilitaryElite;

public class SpyImpl extends SoldierImpl implements Spy {
    private String codeNumber;

    protected SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d%nCode Number: %s", this.getFirstName(), this.getLastName(), this.getId(), this.getCodeNumber());
    }
}
