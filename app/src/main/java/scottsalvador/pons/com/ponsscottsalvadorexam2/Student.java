package scottsalvador.pons.com.ponsscottsalvadorexam2;

import android.widget.Toast;

public class Student {
    String fname, lname;
    Long exam1, exam2, avg;

    public Student(){

    }

    public Student(String fname, String lname, Long exam1, Long exam2) {
        this.fname = fname;
        this.lname = lname;
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.avg = (long)((exam1+exam2)/2);
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public Long getExam1() {
        return exam1;
    }

    public Long getExam2() {
        return exam2;
    }

    public Long getAVG() {
        return avg;
    }
}