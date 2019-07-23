package ReflectionAndAnnotations.Skeletons.BarracksWars.core.commands;

import ReflectionAndAnnotations.Skeletons.BarracksWars.interfaces.Repository;
import ReflectionAndAnnotations.Skeletons.BarracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Report extends Command {
    protected Report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        return super.getRepository().getStatistics();
    }
}