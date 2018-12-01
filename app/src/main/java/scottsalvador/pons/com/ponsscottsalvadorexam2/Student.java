package scottsalvador.pons.com.ponsscottsalvadorexam2;


public class Student {
    String fname, lname;
    double exam1, exam2, avg;

    public Student(){

    }

    public Student(String fname, String lname, double exam1, double exam2) {
        this.fname = fname;
        this.lname = lname;
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.avg = (exam1+exam2)/2;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public Double getExam1() {
        return exam1;
    }

    public Double getExam2() {
        return exam2;
    }

    public Double getAVG() {
        return avg;
    }
}