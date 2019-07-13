package InterfacesAndAbstraction.MilitaryElite;

public interface Mission {
    String getCodeName();
    State getState();
    void completeMission();
}