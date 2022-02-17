package deliverySystem;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author 20jz0130
 */
public class DateTimeLabel extends JLabel{
    DateTimeFormatter format;
    /**
     * コンストラクタ
     * @param format
     * @param period 
     */
    public DateTimeLabel(String format, int period){
        this.format = DateTimeFormatter.ofPattern(format);
        Timer timer = new Timer();
        timer.schedule(new TimerTaskLabelInner(), 300, period);
    }
    public DateTimeLabel(String format){
        this(format, 1000);
    }
    public DateTimeLabel(){
        this("yyyy-MM-dddd HH:mm:ss");
    }
    public void showDateTime(){
        LocalDateTime now = LocalDateTime.now();
        this.setText(now.format(format));
    }
    class TimerTaskLabelInner extends TimerTask{
        @Override
        public void run(){
            showDateTime();
        }
    }
}

class TimerTaskLabel extends TimerTask{
    private DateTimeLabel dateTimeLabel;
    
    public TimerTaskLabel(DateTimeLabel dateTimeLabel){
        this.dateTimeLabel = dateTimeLabel;
    }
    @Override
    public void run(){
        dateTimeLabel.showDateTime();
    }
}