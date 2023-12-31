package pl.bigmurloc.checkersai.checkers.player;

import pl.bigmurloc.checkersai.checkers.board.Board;
import pl.bigmurloc.checkersai.checkers.board.CheckerColor;
import pl.bigmurloc.checkersai.checkers.board.Move;

import java.util.Scanner;

/**
 * Class representing a human player
 */
public class HumanPlayer implements Player {

    CheckerColor color;
    Scanner scanner;

public HumanPlayer(CheckerColor color, Scanner scanner) {
        this.color = color;
        this.scanner = scanner;
    }

    @Override
    public CheckerColor playingAs() {
        return color;
    }

    /**
     * The method asks the user for a move, performs it on the board and returns it
     *
     * @param board current board
     * @return player chosen move
     */
    @Override
    public Move makeMove(Board board) {
        var moves = board.availableMoves(color);
        System.out.println("Available moves: ");
        for (int i = 0; i < moves.size(); i++) {
            System.out.println(i + ": " + moves.get(i));
        }
        System.out.println("Choose move: ");
        var chosenMove = moves.get(scanner.nextInt());
        board.makeMove(chosenMove);
        return chosenMove;
    }
}
