import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock extends JFrame implements MouseListener {
    JPanel mainPanel;
    Dimension screen_size=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int)screen_size.getWidth();
    int height=(int)screen_size.getHeight();
    SimpleDateFormat timeFormat;
    SimpleDateFormat dateFormat;
    SimpleDateFormat dayFormat;
    JLabel timelabel;
    JLabel datelabel;
    JLabel daylabel;
    String time;
    String date;
    String day;


    Clock() {
        this.setTitle("Clock");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setUndecorated(true);

        this.setShape(new RoundRectangle2D.Double(10, 10, 280, 100, 50, 50));
        this.setBounds(width/2,height/2,width/2,height/2);
        this.setOpacity(0.50f);
        this.addMouseListener(this);
        this.getRootPane().putClientProperty("apple.awt.draggableWindowBackground", true); //Works only on Macs


        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 300, 130);
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setOpaque(true);

        timeFormat = new SimpleDateFormat("HH:mm:ss");
        dateFormat = new SimpleDateFormat("dd MMMMM yyyy");
        dayFormat = new SimpleDateFormat("EEEE");

        timelabel = new JLabel();
        timelabel.setFont(new Font("Arial", Font.BOLD, 60));
        timelabel.setForeground(Color.GREEN);
        timelabel.setBackground(Color.BLACK);
        timelabel.setOpaque(true);
        datelabel = new JLabel();
        datelabel.setFont(new Font("Arial", Font.PLAIN, 25));
        datelabel.setForeground(Color.GREEN);
        datelabel.setBackground(Color.BLACK);
        datelabel.setOpaque(true);
        daylabel = new JLabel();
        daylabel.setFont(new Font("Arial", Font.PLAIN, 25));
        daylabel.setForeground(Color.GREEN);
        daylabel.setBackground(Color.BLACK);
        daylabel.setOpaque(true);




        mainPanel.add(timelabel);
        mainPanel.add(daylabel);
        mainPanel.add(datelabel);
        this.add(mainPanel);
        this.setVisible(true);
        curTime();
    }

    public void curTime() {
       while (true){
            time = timeFormat.format(Calendar.getInstance().getTime());
            timelabel.setText(time);

            date = dateFormat.format(Calendar.getInstance().getTime());
            datelabel.setText(date);

            day = dayFormat.format(Calendar.getInstance().getTime());
            daylabel.setText(day);

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.exit(0);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
