package pt.ulisboa.tecnico.socialsoftware.tutor.user.dto;

import pt.ulisboa.tecnico.socialsoftware.tutor.user.domain.Student;

import java.io.Serializable;

public class StudentDto extends UserDto implements Serializable {
    private Integer numberOfTeacherQuizzes;
    private Integer numberOfInClassQuizzes;
    private Integer numberOfStudentQuizzes;
    private Integer numberOfAnswers;
    private Integer numberOfTeacherAnswers;
    private Integer numberOfInClassAnswers;
    private Integer numberOfStudentAnswers;
    private int percentageOfCorrectAnswers = 0;
    private int percentageOfCorrectTeacherAnswers = 0;
    private int percentageOfCorrectInClassAnswers = 0;
    private int percentageOfCorrectStudentAnswers = 0;

    public StudentDto() {}

    public StudentDto(Student student) {
        super(student);
        this.numberOfInClassQuizzes = student.getNumberOfInClassQuizzes();
        this.numberOfStudentQuizzes = student.getNumberOfStudentQuizzes();
        this.numberOfAnswers = student.getNumberOfTeacherAnswers() + student.getNumberOfInClassAnswers() + student.getNumberOfStudentAnswers();
        this.numberOfTeacherAnswers = student.getNumberOfTeacherAnswers();
        this.numberOfInClassAnswers = student.getNumberOfInClassAnswers();
        this.numberOfStudentAnswers = student.getNumberOfStudentAnswers();

        if (this.numberOfTeacherAnswers != 0)
            this.percentageOfCorrectTeacherAnswers = student.getNumberOfCorrectTeacherAnswers() * 100 / this.numberOfTeacherAnswers;
        if (this.numberOfInClassAnswers != 0)
            this.percentageOfCorrectInClassAnswers = student.getNumberOfCorrectInClassAnswers() * 100 / this.numberOfInClassAnswers;
        if (this.numberOfStudentAnswers != 0)
            this.percentageOfCorrectStudentAnswers = student.getNumberOfCorrectStudentAnswers() * 100 / this.numberOfStudentAnswers;
        if (this.numberOfAnswers != 0)
            this.percentageOfCorrectAnswers = (student.getNumberOfCorrectTeacherAnswers() + student.getNumberOfCorrectInClassAnswers() + student.getNumberOfCorrectStudentAnswers())  * 100 / this.numberOfAnswers;

    }

    public Integer getNumberOfTeacherQuizzes() {
        return numberOfTeacherQuizzes;
    }

    public void setNumberOfTeacherQuizzes(Integer numberOfTeacherQuizzes) {
        this.numberOfTeacherQuizzes = numberOfTeacherQuizzes;
    }

    public Integer getNumberOfStudentQuizzes() {
        return numberOfStudentQuizzes;
    }

    public void setNumberOfStudentQuizzes(Integer numberOfStudentQuizzes) {
        this.numberOfStudentQuizzes = numberOfStudentQuizzes;
    }

    public Integer getNumberOfAnswers() {
        return numberOfAnswers;
    }

    public void setNumberOfAnswers(Integer numberOfAnswers) {
        this.numberOfAnswers = numberOfAnswers;
    }

    public Integer getNumberOfTeacherAnswers() {
        return numberOfTeacherAnswers;
    }

    public void setNumberOfTeacherAnswers(Integer numberOfTeacherAnswers) {
        this.numberOfTeacherAnswers = numberOfTeacherAnswers;
    }

    public int getPercentageOfCorrectAnswers() {
        return percentageOfCorrectAnswers;
    }

    public void setPercentageOfCorrectAnswers(int percentageOfCorrectAnswers) {
        this.percentageOfCorrectAnswers = percentageOfCorrectAnswers;
    }

    public int getPercentageOfCorrectTeacherAnswers() {
        return percentageOfCorrectTeacherAnswers;
    }

    public void setPercentageOfCorrectTeacherAnswers(int percentageOfCorrectTeacherAnswers) {
        this.percentageOfCorrectTeacherAnswers = percentageOfCorrectTeacherAnswers;
    }

    public Integer getNumberOfInClassQuizzes() {
        return numberOfInClassQuizzes;
    }

    public void setNumberOfInClassQuizzes(Integer numberOfInClassQuizzes) {
        this.numberOfInClassQuizzes = numberOfInClassQuizzes;
    }

    public Integer getNumberOfInClassAnswers() {
        return numberOfInClassAnswers;
    }

    public void setNumberOfInClassAnswers(Integer numberOfInClassAnswers) {
        this.numberOfInClassAnswers = numberOfInClassAnswers;
    }

    public Integer getNumberOfStudentAnswers() {
        return numberOfStudentAnswers;
    }

    public void setNumberOfStudentAnswers(Integer numberOfStudentAnswers) {
        this.numberOfStudentAnswers = numberOfStudentAnswers;
    }

    public int getPercentageOfCorrectInClassAnswers() {
        return percentageOfCorrectInClassAnswers;
    }

    public void setPercentageOfCorrectInClassAnswers(int percentageOfCorrectInClassAnswers) {
        this.percentageOfCorrectInClassAnswers = percentageOfCorrectInClassAnswers;
    }

    public int getPercentageOfCorrectStudentAnswers() {
        return percentageOfCorrectStudentAnswers;
    }

    public void setPercentageOfCorrectStudentAnswers(int percentageOfCorrectStudentAnswers) {
        this.percentageOfCorrectStudentAnswers = percentageOfCorrectStudentAnswers;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "username='" + getUsername() + '\'' +
                ", name='" + getName() + '\'' +
                ", numberOfTeacherQuizzes=" + numberOfTeacherQuizzes +
                ", numberOfStudentQuizzes=" + numberOfStudentQuizzes +
                ", numberOfAnswers=" + numberOfAnswers +
                ", numberOfTeacherAnswers=" + numberOfTeacherAnswers +
                ", percentageOfCorrectAnswers=" + percentageOfCorrectAnswers +
                ", percentageOfCorrectTeacherAnswers=" + percentageOfCorrectTeacherAnswers +
                ", creationDate='" + getCreationDate() + '\'' +
                ", lastAccess='" + getLastAccess() + '\'' +
                '}';
    }
}
