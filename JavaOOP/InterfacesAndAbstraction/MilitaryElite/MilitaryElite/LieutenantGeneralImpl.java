package InterfacesAndAbstraction.MilitaryElite;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private Set<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new TreeSet<>((o1, o2) -> o2.getId() - o1.getId());
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());

        result.append(System.lineSeparator())
                .append("Privates:")
                .append(System.lineSeparator());

        for (Private priv : privates) {
            result.append("  " + priv.toString())
                    .append(System.lineSeparator());
        }

        return result.toString().trim();
    }
}