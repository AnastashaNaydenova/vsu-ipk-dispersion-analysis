package by.vsu.analysis;

import by.vsu.domain.Data;
import by.vsu.domain.FactorValue;
import by.vsu.domain.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskSolver {
    public static void solve(Task task) {
        Map<Integer, List<Double>> x = new HashMap<>();
        // подготовка данных (представление их в более удобной форме)
        for(FactorValue value : task.getFactor().getValues()) {
            x.put(value.getId(), new ArrayList<>());
        }
        for(Data data : task.getData()) {
            x.get(data.getFactorValue().getId()).add(data.getValue());
        }
        // вычисление Cx
        Map<Integer, Double> groupAverages = new HashMap<>();
        double totalSum = 0;
        int totalCount = 0;
        for(Integer factorValueId : x.keySet()) {
            double sum = 0;
            for(double xi : x.get(factorValueId)) {
                sum += xi;
            }
            groupAverages.put(factorValueId, sum / x.get(factorValueId).size());
            totalSum += sum;
            totalCount += x.get(factorValueId).size();
        }
        double totalAverage = totalSum / totalCount;
        double Cx = 0;
        for(double groupAverage : groupAverages.values()) {
            Cx += (groupAverage - totalAverage) * (groupAverage - totalAverage);
        }
        Cx *= (double) totalCount / x.size();
        // вычисление Cz
        double Cz = 0;
        for(Integer factorValueId : x.keySet()) {
            double groupAverage = groupAverages.get(factorValueId);
            for(double xi : x.get(factorValueId)) {
                Cz += (xi - groupAverage) * (xi - groupAverage);
            }
        }
        // вычисление Cy
        double Cy = Cx + Cz;
        task.setInfluenceProportion(100 * Cx / Cy);
        // вычисление достоверности
        int v1 = x.size() - 1; // число степеней свободы по группам
        int v2 = totalCount - x.size(); // число степеней свободы по объектам
        double deltaX = Cx / v1;
        double deltaZ = Cz / v2;
        double Femp = deltaX / deltaZ;
        double Ftable = FTest.get(v1, v2);
        task.setVeracity(Femp > Ftable);
    }
}
