package scottsalvador.pons.com.ponsscottsalvadorexam2;

public class Student {
    String fname, lname;
    Long exam1, exam2, avg;


    public Student(String fname, String lname, Long exam1, Long exam2) {
        this.fname = fname;
        this.lname = lname;
        this.exam1 = exam1;
        this.exam2 = exam2;
        avg = (exam1 + exam2) / 2;
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