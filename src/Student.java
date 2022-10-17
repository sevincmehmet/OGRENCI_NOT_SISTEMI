public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int mat, int fizik, int kimya) {

        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;
        }

    }
    public void addBulkQuizNote(int mat, int fizik, int kimya) {

        if (mat >= 0 && mat <= 100) {
            this.mat.quiz = mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.quiz = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.quiz = kimya;
        }
    }


    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.avarage = ((this.fizik.note*0.80 + this.fizik.quiz*0.20) + (this.kimya.note*0.80 + this.kimya.quiz*0.20)
                + (this.mat.note*0.80 + this.mat.quiz*0.20)) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=======================================");
        System.out.println("Öğrenci  : " + this.name);
        System.out.println("\nMatematik Sınav Notu : " + this.mat.note);
        System.out.println("Matematik Sözlü Notu : " + this.mat.quiz);
        System.out.println("Matematik Ortalaması : " + ((this.mat.note*0.80) + (this.mat.quiz*0.20)));
        System.out.println("\nFizik Sınav Notu     : " + this.fizik.note);
        System.out.println("Fizik Sözlü Notu     : " + this.fizik.quiz);
        System.out.println("Fizik Ortalaması     : " + ((this.fizik.note*0.80) + (this.fizik.quiz*0.20)));
        System.out.println("\nKimya Sınav Notu     : " + this.kimya.note);
        System.out.println("Kimya Sözlü Notu     : " + this.kimya.note);
        System.out.println("Kimya Ortalamsı      : " + ((this.kimya.note*0.80) + (this.kimya.quiz*0.20)) + "\n");

    }

}