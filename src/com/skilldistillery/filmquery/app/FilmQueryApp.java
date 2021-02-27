package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.test();
//    app.launch();
	}

	private void test() {
		Film film = db.findFilmById(1);
		System.out.println(film);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		boolean keepMenu = true;

		while (keepMenu) {

			System.out.println("Please select from the options below by typing a number:");
			System.out.println("1. Look up film by ID");
			System.out.println("2. Look up film by keyword");
			System.out.println("3. Exit");

			String userInput = input.nextLine();
			switch (userInput) {
			case "1":
				System.out.println("Enter film ID: ");
				int filmID = input.nextInt();
				System.out.println("Results: ");
				Film newFilm = db.findFilmById(filmID);
				if (newFilm != null) {
					System.out.println(newFilm);
				} else {
					System.out.println("There is no film associated with this ID.");
				}

				break;
			case "2":
				break;
			case "3":
				keepMenu = false;
				break;
			default:
				System.out.println("Invalid input, try again");
				break;
			}

		}

	}

}
