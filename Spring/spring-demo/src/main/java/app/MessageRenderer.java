package app;

public class MessageRenderer {

    private Message message;

    public MessageRenderer(Message message) {
        this.message = message;
    }

    public void printMessage(){
        System.out.println("Hello Spring");
        System.out.println(message.getText());
    }
}
