package ReflectionAndAnnotations.Skeletons.BarracksWars.core.factories;

import ReflectionAndAnnotations.Skeletons.BarracksWars.interfaces.Unit;
import ReflectionAndAnnotations.Skeletons.BarracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"ReflectionAndAnnotations.Skeletons.BarracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
		String className = UNITS_PACKAGE_NAME + unitType;

		try {
			Class aClass = Class.forName(className);

			Constructor constructor = aClass.getDeclaredConstructors()[0];
			constructor.setAccessible(true);

			return (Unit) constructor.newInstance();
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
			e.printStackTrace();
		}

		throw new IllegalArgumentException("Wrong unit type: " + unitType);
	}
}