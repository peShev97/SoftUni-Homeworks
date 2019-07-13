package InterfacesAndAbstraction.MilitaryElite;

import java.util.Collection;

public interface Commando extends Soldier{
    void addMission(Mission mission);
    Collection<Mission> getMissions();
}