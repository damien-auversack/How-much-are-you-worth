package serialisation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import application.SceneManager;
import exceptions.AlreadyPresentException;
import exceptions.NotPresentException;
import exceptions.TooLittleException;
import javafx.collections.ObservableList;

import java.io.FileWriter;

import model.BasicCard;
import model.Board;
import model.Deck;
import util.Constants;

public class Serialisation implements Serializable {
	private static final long serialVersionUID = 1L;

	public static void saveDeckClear(Deck q, String nom) {

		try (FileWriter writer = new FileWriter(nom); BufferedWriter bw = new BufferedWriter(writer)) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(q);
			bw.write(json);
			bw.close();

		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public static Deck loadDeckClear(String nom) {

		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(nom));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new Gson().fromJson(bufferedReader, Deck.class);
	}

	public static Board loadBoardClear(String nom) {

		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(nom));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new Gson().fromJson(bufferedReader, Board.class);
	}

	public static void updateDeck(BasicCard oldbc, BasicCard newbc, Deck deck) {
		try {
			deck.removeBasicCard(oldbc);
			SceneManager.getCardsManagement().getTvCards().getItems().remove(oldbc);
		} catch (TooLittleException | NotPresentException e) {
			e.printStackTrace();
		}
		try {
			deck.addBasicCard(newbc);
			SceneManager.getCardsManagement().getTvCards().getItems().add(newbc);
		} catch (AlreadyPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		saveDeckClear(deck, Constants.DECK_PATH);
	}

	public static void addCard(BasicCard bc, Deck deck) {
		try {
			deck.addBasicCard(bc);
			SceneManager.getCardsManagement().getTvCards().getItems().add(bc);
		} catch (AlreadyPresentException e) {
			e.printStackTrace();
		}
		saveDeckClear(deck, Constants.DECK_PATH);
	}

	public static void removeCard(ObservableList<BasicCard> toRemove, Deck deck) {
		for (BasicCard b : deck.getBasicCards()) {
			if (toRemove.contains(b)) {
				try {
					deck.removeBasicCard(b);
				} catch (TooLittleException | NotPresentException e) {
					e.printStackTrace();
				}
			}
		}
		Serialisation.saveDeckClear(deck, Constants.DECK_PATH);
	}
}
