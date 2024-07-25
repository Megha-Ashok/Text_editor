import java.util.Scanner;

import NotePad.NotePad;

public class App {
    public static void main(String[] args) throws Exception {
        NotePad p = new NotePad(100);
        Scanner obj = new Scanner(System.in);
        int line, line1;
        for (;;) {
            System.out.println(
                    "choose your option\n1.display\n2.display particular line\n3.insert of text\n4.delete the text\n5.delete from particular line\n6.copy the text\n7.paste the text\n8.undo operation\n9.redo operation\nenter the choice");

            int ch = obj.nextInt();
            if (ch == -1) {
                break;
            }
            switch (ch) {
                case 1:
                    p.display();
                    break;
                case 2:
                    System.out.println("enter the start and endline to be display");
                    line = obj.nextInt();
                    line1 = obj.nextInt();
                    p.display(line, line1);
                    break;
                case 3:
                    System.out.println("enter the text and line number");
                    line = obj.nextInt();
                    String s = obj.nextLine();
                    p.insertLine(line, s);
                    p.display();
                    break;
                case 4:
                    System.out.println("enter the line number");
                    line = obj.nextInt();
                    p.deleteLine(line);
                    p.display();
                    break;
                case 5:
                    System.out.println("enter the start and endline to be delete");
                    line = obj.nextInt();
                    line1 = obj.nextInt();
                    p.deleteLine(line, line1);
                    p.display();
                    break;
                case 6:
                    System.out.println("enter the start and endline to be copied");
                    line = obj.nextInt();
                    line1 = obj.nextInt();
                    p.copy(line, line1);
                    p.display();
                    break;
                case 7:
                    System.out.println("enter the line number for pasting the text");
                    line = obj.nextInt();
                    p.paste(line);
                    p.display();
                    break;
                case 8:
                    p.undo();
                    p.display();
                    break;
                case 9:
                    p.redo();
                    p.display();
                    break;
                default:
                    System.out.println("Invalid choice please enter the correct choice");
            }
        }
        obj.close();
    }
}
