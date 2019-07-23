package ReflectionAndAnnotations.Skeletons.BarracksWars.core;

import ReflectionAndAnnotations.Skeletons.BarracksWars.interfaces.Repository;
import ReflectionAndAnnotations.Skeletons.BarracksWars.interfaces.Runnable;
import ReflectionAndAnnotations.Skeletons.BarracksWars.interfaces.Unit;
import ReflectionAndAnnotations.Skeletons.BarracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// TODO: refactor for problem 4
	private String interpretCommand(String[] data, String commandName) {
		String result = "fight";

		String toUpper = commandName.substring(0,1).toUpperCase() + commandName.substring(1);

		try {
			Class aClass = Class.forName("ReflectionAndAnnotations.Skeletons.BarracksWars.core.commands." + toUpper);
			Constructor declaredConstructor = aClass.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
			declaredConstructor.setAccessible(true);

			Object o = declaredConstructor.newInstance(data, this.repository, this.unitFactory);

			Method execute = aClass.getDeclaredMethod("execute");

			Object res = execute.invoke(o);

			result = (String) res;
		} catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}
}