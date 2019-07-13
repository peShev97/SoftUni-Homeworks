package InterfacesAndAbstraction.MilitaryElite;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private Set<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());

        result.append(System.lineSeparator())
                .append("Corps: " + this.getCorps())
                .append(System.lineSeparator())
                .append("Repairs:")
                .append(System.lineSeparator());

            for (Repair repair : repairs) {
                result.append("  " + repair.toString())
                        .append(System.lineSeparator());
            }

        return result.toString().trim();
    }
}