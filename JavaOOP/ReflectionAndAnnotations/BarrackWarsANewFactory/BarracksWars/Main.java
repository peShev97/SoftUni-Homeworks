package ReflectionAndAnnotations.Skeletons.BarracksWars;

import ReflectionAndAnnotations.Skeletons.BarracksWars.interfaces.Repository;
import ReflectionAndAnnotations.Skeletons.BarracksWars.interfaces.Runnable;
import ReflectionAndAnnotations.Skeletons.BarracksWars.interfaces.UnitFactory;
import ReflectionAndAnnotations.Skeletons.BarracksWars.core.Engine;
import ReflectionAndAnnotations.Skeletons.BarracksWars.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotations.Skeletons.BarracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}