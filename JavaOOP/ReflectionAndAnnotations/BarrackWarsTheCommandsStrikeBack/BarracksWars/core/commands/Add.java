package ReflectionAndAnnotations.Skeletons.BarracksWars.core.commands;

import ReflectionAndAnnotations.Skeletons.BarracksWars.interfaces.Repository;
import ReflectionAndAnnotations.Skeletons.BarracksWars.interfaces.Unit;
import ReflectionAndAnnotations.Skeletons.BarracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Add extends Command{

    protected Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = super.getData()[1];
        Unit unitToAdd = super.getUnitFactory().createUnit(unitType);
        super.getRepository().addUnit(unitToAdd);

        return unitType + " added!";
    }
}