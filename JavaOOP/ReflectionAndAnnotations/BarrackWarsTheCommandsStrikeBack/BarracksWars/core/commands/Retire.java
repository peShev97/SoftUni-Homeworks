package ReflectionAndAnnotations.Skeletons.BarracksWars.core.commands;

import ReflectionAndAnnotations.Skeletons.BarracksWars.interfaces.Repository;
import ReflectionAndAnnotations.Skeletons.BarracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Retire extends Command {
    protected Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String result;

        try {
            super.getRepository().removeUnit(super.getData()[1]);
            result = super.getData()[1] + " retired!";
        } catch (Exception e) {
            result = e.getMessage();
        }

        return result;
    }
}