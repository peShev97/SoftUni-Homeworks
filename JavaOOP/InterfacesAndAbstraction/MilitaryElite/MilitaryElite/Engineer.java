package InterfacesAndAbstraction.MilitaryElite;

import java.util.Collection;

public interface Engineer extends Soldier{
    void addRepair(Repair repair);
    Collection<Repair> getRepairs();
}