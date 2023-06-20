package softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni (int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }
    public int getCount() {
        return data.size();
    }
    public String insert (Student student) {
        if (data.size() < capacity) {
            if (data.contains(student)) {
                return "Student is already in the hall.";
            } else {
                data.add(student);
                return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
            }
        } else {
            return "The hall is full.";
        }
    }
    public String remove (Student student) {
        if (data.contains(student)) {
            data.remove(student);
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        } else {
            return String.format("Student not found.");
        }
    }
    public Student getStudent(String firstName, String lastName) {
        for (Student student : data) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                return student;
        }
        return null;
    }
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append("Hall size: ").append(data.size());
        builder.append(System.lineSeparator());
        for (Student student : data) {
            builder.append("Student: ").append(student.getFirstName()).append(" ").append(student.getLastName());
            builder.append(", Best Course = ").append(student.getBestCourse());
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
