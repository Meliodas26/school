public class Run{
    public static void main(String[] args){
        Move move = new Move();
        Panel panel = new Panel(move);
        Frame frame = new Frame(move);
        frame.add(panel);
        panel.inicio();
    }
}
