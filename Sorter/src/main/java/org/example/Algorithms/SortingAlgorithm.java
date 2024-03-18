package org.example.Algorithms;
import java.util.List;
public interface SortingAlgorithm {
    void sort(int[] arr);

    List<int[]> getSteps();

    public boolean getAreStepsSaved();

    public void setAreStepsSaved(boolean areStepsSaved);
}
