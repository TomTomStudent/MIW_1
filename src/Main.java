import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> {
            View view = new View();
            Model model = new Model();
            Controller controller = new Controller(view, model);
            view.setController(controller);
        });
    }
}
