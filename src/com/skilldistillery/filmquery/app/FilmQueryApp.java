package com.skilldistillery.filmquery.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		// app.test();
		app.launch();
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

			Film newFilm = null;
			List<Film> films = new ArrayList<>();
			switch (userInput) {
			case "1":
				System.out.println("Enter film ID: ");
				int filmID = input.nextInt();
				System.out.println("Results: ");
				newFilm = db.findFilmById(filmID);
				if (newFilm != null) {
					System.out.println(newFilm.printFilm());
					input.nextLine();
				} else {
					input.nextLine();
					System.out.println("There is no film associated with this ID.");
				}

				break;
			case "2":
				System.out.println("Enter search keyword: ");
				String keyword = input.nextLine();
				System.out.println("Results: ");
				films = db.findFilmByKeyword(keyword);

				if (films.isEmpty()) {
					System.out.println("There is no film associated with this keyword.");
				} else {
					for (int i = 0; i < films.size(); i++) {
						System.out.println(films.get(i).printFilm());
					}
				}
				break;
			case "3":
				System.out.println("Goodbye");
				keepMenu = false;
				break;
			default:
				System.out.println("Invalid input, try again");
				break;
			}

		}

	}

}
