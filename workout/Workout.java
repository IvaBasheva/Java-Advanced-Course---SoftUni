package workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        return exercises.removeIf(e -> e.getName().equals(name) && e.getMuscle().equals(muscle));
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        if (exercises.isEmpty()) {
            return null;
        } else return Collections.max(exercises, Comparator.comparingInt(Exercise::getBurnedCalories));
    }

    public int getExerciseCount() {
        return exercises.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append("Workout type: ").append(this.type);
        for (Exercise exercise : exercises) {
            builder.append(System.lineSeparator());
            builder.append("Exercise: ");
            builder.append(exercise.getName()).append(", ");
            builder.append(exercise.getMuscle()).append(", ");
            builder.append(exercise.getBurnedCalories());
        }
        return builder.toString();
    }
}