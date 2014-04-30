import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Input extends JFrame implements KeyListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea out;
    private JTextField in;
    public Input(){
        out = new JTextArea();
        in = new JTextField();
        this.add(out, BorderLayout.CENTER);
        this.add(in, BorderLayout.SOUTH);
        in.addKeyListener(this);
    }
    public void keyPressed(KeyEvent e) {
    }
    public void keyReleased(KeyEvent e) {
    }
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());     }

    public void process(String s){
        String text = out.getText();
        out.setText(text + ((text.length() == 0) ? "" : "\n") + s);
        String query = s.substring(0, s.indexOf(' '));
        String param = s.substring(s.indexOf(' ') + 1);
        ArrayList<String> args = new ArrayList<String>();
        int i = 0;
        boolean inQuotes = false;
        StringBuffer activeString = new StringBuffer();
        while(i < param.length()){
            if(param.charAt(i) == ' ' && !inQuotes){
                args.add(activeString.toString());
                System.out.println(activeString.toString());
                activeString.setLength(0); //FIXME:works???
            } else if(param.charAt(i) == '"'){
                inQuotes = !inQuotes;
            } else {
                activeString.append(param.charAt(i));
            }
            i++;
        }
        args.add(activeString.toString());
        System.out.println(activeString.toString());
        activeString.setLength(0); //FIXME:works???
        for (String string : args) {
            activeString.append(string + ", ");
        }
        out.setText(out.getText() + "\n\t" + "Query: " + query + "; args: " + activeString.toString());
    }

    public static void main(String[] args){
        Input x = new Input();
        x.setVisible(true);
        x.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}