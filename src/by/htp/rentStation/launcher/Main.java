package by.htp.rentStation.launcher;

import by.htp.rentStation.comand.CommandHendler;
import by.htp.rentStation.comand.StationAction;

import by.htp.rentStation.util.Menu;

public class Main {
	public static void main(String[] args) {

		work();

	}

	private static void work() {
		CommandHendler hendler = new CommandHendler();
		StationAction action;
		while (true) {
			Menu.printMenu();
			action = hendler.defineAction(Menu.readConsole());
			action.performAction();
		}
	}
}
