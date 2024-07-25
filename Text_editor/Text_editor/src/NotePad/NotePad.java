package NotePad;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Action.Action;

public class NotePad {
    private int id;
    private String Notepad[];
    private Stack<Action> undoAction;
    private Stack<Action> redoAction;
    private int capacity;
    private Queue<String> clipBoard;
    LocalDateTime dateTime = LocalDateTime.now();

    public NotePad(int capacity) {
        this.capacity = capacity;
        Notepad = new String[this.capacity];
        for (int i = 0; i < this.capacity; i++) {
            Notepad[i] = " ";
        }
        undoAction = new Stack<>();
        redoAction = new Stack<>();
        clipBoard = new LinkedList<>();
    }

    public void display() {
        for (int i = 0; i < this.capacity; i++) {
            System.out.println(Notepad[i]);
        }
    }

    public void display(int startline, int endline) {
        if (startline <= 0 || startline > endline || endline > this.capacity) {
            System.out.println("Unable to display the text please check the input");
            return;
        }
        for (int i = startline - 1; i < endline; i++) {
            System.out.println(Notepad[i]);
        }

    }

    public void insertLine(int lineNumber, String text) {
        if (lineNumber > this.capacity) {
            System.out.println("Notepad limit crossed");
            return;
        }
        Notepad[lineNumber - 1] = text;
        undoAction.push(new Action(id++, lineNumber, text, true, dateTime));
    }

    public void deleteLine(int lineNumber) {
        if (lineNumber > capacity || lineNumber <= 0) {
            System.out.println("No such row to delete");
            return;
        }
        if (Notepad[lineNumber - 1] == " ") {
            System.out.println("Nothing to delete anything");
            return;
        }
        redoAction.push(new Action(id++, lineNumber, Notepad[lineNumber - 1], false, dateTime));
        Notepad[lineNumber - 1] = "  ";
    }

    public void deleteLine(int startLine, int endLine) {
        if (startLine <= 0 || startLine > endLine || endLine > capacity) {
            System.out.println("Unable to delete check the input");
            return;
        }
        for (int i = startLine; i <= endLine; i++) {
            deleteLine(i);
        }
    }

    public void copy(int startline, int endline) {
        if (startline > endline || endline > this.capacity) {
            System.out.println("Unable to copy");
            return;
        }
        String copyText = " ";
        for (int i = startline - 1; i < endline; i++) {
            copyText = copyText + (Notepad[i] + "\n");
        }
        if (!copyText.isEmpty())
            clipBoard.add(copyText);

    }

    public void paste(int lineNumber) {
        if (this.clipBoard.isEmpty()) {
            System.out.println("Nothing to paste");
            return;
        }
        String text = clipBoard.peek();
        insertLine(lineNumber, text);
    }

    public void undo() {
        if (this.undoAction.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }
        Action action = undoAction.pop();
        deleteLine(action.getline());

    }

    public void redo() {
        if (this.redoAction.isEmpty()) {
            System.out.println("Nothing to redo");
            return;
        }
        insertLine(redoAction.pop().getline(), redoAction.pop().getText());
    }
}
