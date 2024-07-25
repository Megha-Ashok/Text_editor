package Action;

import java.time.LocalDateTime;

public class Action {
private int actionid;
private LocalDateTime datatime = LocalDateTime.now(); 
private int line;
private String text;
private boolean isAddition;
public Action(int actionid,int line,String text,boolean isAddition,LocalDateTime datatime){
    this.actionid=actionid;
    this.line=line;
    this.text=text;
    this.isAddition=isAddition;
    this.datatime=datatime;
}

public int getActionId(){
    return this.actionid;
}
public LocalDateTime getDataTime(){
    return this.datatime;
}

public int getline(){
    return this.line;
}

public String getText(){
    return this.text;
}

public boolean getIsAddition(){
    return this.isAddition;
}
}
