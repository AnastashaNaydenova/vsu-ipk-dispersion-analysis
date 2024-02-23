package by.vsu.analysis;

import java.util.Collections;
import java.util.Map;

public class FTest {
    private static final Map<Integer, Map<Integer, Double>> table = Map.ofEntries(
            Map.entry(1, Map.ofEntries(Map.entry(1, 161.4), Map.entry(2, 199.5), Map.entry(3, 215.7), Map.entry(4, 224.6), Map.entry(5, 230.2), Map.entry(6, 234.0), Map.entry(8, 238.9), Map.entry(12, 243.9), Map.entry(16, 246.5), Map.entry(24, 249.0), Map.entry(50, 251.8), Map.entry(0, 254.3))),
            Map.entry(2, Map.ofEntries(Map.entry(1, 18.51), Map.entry(2, 19.0), Map.entry(3, 19.16), Map.entry(4, 19.25), Map.entry(5, 19.3), Map.entry(6, 19.33), Map.entry(8, 19.37), Map.entry(12, 19.41), Map.entry(16, 19.43), Map.entry(24, 19.45), Map.entry(50, 19.47), Map.entry(0, 19.5))),
            Map.entry(3, Map.ofEntries(Map.entry(1, 10.13), Map.entry(2, 9.55), Map.entry(3, 9.28), Map.entry(4, 9.12), Map.entry(5, 9.01), Map.entry(6, 8.94), Map.entry(8, 8.84), Map.entry(12, 8.74), Map.entry(16, 8.69), Map.entry(24, 8.64), Map.entry(50, 8.58), Map.entry(0, 8.53))),
            Map.entry(4, Map.ofEntries(Map.entry(1, 7.71), Map.entry(2, 6.94), Map.entry(3, 6.59), Map.entry(4, 6.39), Map.entry(5, 6.26), Map.entry(6, 6.16), Map.entry(8, 6.04), Map.entry(12, 5.91), Map.entry(16, 5.84), Map.entry(24, 5.77), Map.entry(50, 5.7), Map.entry(0, 5.63))),
            Map.entry(5, Map.ofEntries(Map.entry(1, 6.61), Map.entry(2, 5.79), Map.entry(3, 5.41), Map.entry(4, 5.19), Map.entry(5, 5.05), Map.entry(6, 4.95), Map.entry(8, 4.82), Map.entry(12, 4.68), Map.entry(16, 4.6), Map.entry(24, 4.53), Map.entry(50, 4.44), Map.entry(0, 4.36))),
            Map.entry(6, Map.ofEntries(Map.entry(1, 5.99), Map.entry(2, 5.14), Map.entry(3, 4.76), Map.entry(4, 4.53), Map.entry(5, 4.39), Map.entry(6, 4.28), Map.entry(8, 4.15), Map.entry(12, 4.0), Map.entry(16, 3.92), Map.entry(24, 3.84), Map.entry(50, 3.75), Map.entry(0, 3.67))),
            Map.entry(7, Map.ofEntries(Map.entry(1, 5.59), Map.entry(2, 4.74), Map.entry(3, 4.35), Map.entry(4, 4.12), Map.entry(5, 3.97), Map.entry(6, 3.87), Map.entry(8, 3.73), Map.entry(12, 3.57), Map.entry(16, 3.49), Map.entry(24, 3.41), Map.entry(50, 3.32), Map.entry(0, 3.23))),
            Map.entry(8, Map.ofEntries(Map.entry(1, 5.32), Map.entry(2, 4.48), Map.entry(3, 4.07), Map.entry(4, 3.84), Map.entry(5, 3.69), Map.entry(6, 3.58), Map.entry(8, 3.44), Map.entry(12, 3.28), Map.entry(16, 3.2), Map.entry(24, 3.12), Map.entry(50, 3.02), Map.entry(0, 2.93))),
            Map.entry(9, Map.ofEntries(Map.entry(1, 5.12), Map.entry(2, 4.26), Map.entry(3, 3.86), Map.entry(4, 3.63), Map.entry(5, 3.48), Map.entry(6, 3.37), Map.entry(8, 3.23), Map.entry(12, 3.07), Map.entry(16, 2.98), Map.entry(24, 2.9), Map.entry(50, 2.8), Map.entry(0, 2.71))),
            Map.entry(10, Map.ofEntries(Map.entry(1, 4.96), Map.entry(2, 4.1), Map.entry(3, 3.71), Map.entry(4, 3.48), Map.entry(5, 3.33), Map.entry(6, 3.22), Map.entry(8, 3.07), Map.entry(12, 2.91), Map.entry(16, 2.82), Map.entry(24, 2.74), Map.entry(50, 2.64), Map.entry(0, 2.54))),
            Map.entry(11, Map.ofEntries(Map.entry(1, 4.84), Map.entry(2, 3.98), Map.entry(3, 3.59), Map.entry(4, 3.36), Map.entry(5, 3.2), Map.entry(6, 3.09), Map.entry(8, 2.95), Map.entry(12, 2.79), Map.entry(16, 2.7), Map.entry(24, 2.61), Map.entry(50, 2.5), Map.entry(0, 2.4))),
            Map.entry(12, Map.ofEntries(Map.entry(1, 4.75), Map.entry(2, 3.88), Map.entry(3, 3.49), Map.entry(4, 3.26), Map.entry(5, 3.11), Map.entry(6, 3.0), Map.entry(8, 2.85), Map.entry(12, 2.69), Map.entry(16, 2.6), Map.entry(24, 2.5), Map.entry(50, 2.4), Map.entry(0, 2.3))),
            Map.entry(13, Map.ofEntries(Map.entry(1, 4.67), Map.entry(2, 3.8), Map.entry(3, 3.41), Map.entry(4, 3.18), Map.entry(5, 3.02), Map.entry(6, 2.92), Map.entry(8, 2.77), Map.entry(12, 2.6), Map.entry(16, 2.51), Map.entry(24, 2.42), Map.entry(50, 2.32), Map.entry(0, 2.21))),
            Map.entry(14, Map.ofEntries(Map.entry(1, 4.6), Map.entry(2, 3.74), Map.entry(3, 3.34), Map.entry(4, 3.11), Map.entry(5, 2.96), Map.entry(6, 2.85), Map.entry(8, 2.7), Map.entry(12, 2.53), Map.entry(16, 2.44), Map.entry(24, 2.35), Map.entry(50, 2.24), Map.entry(0, 2.13))),
            Map.entry(15, Map.ofEntries(Map.entry(1, 4.54), Map.entry(2, 3.68), Map.entry(3, 3.29), Map.entry(4, 3.06), Map.entry(5, 2.9), Map.entry(6, 2.79), Map.entry(8, 2.64), Map.entry(12, 2.48), Map.entry(16, 2.39), Map.entry(24, 2.29), Map.entry(50, 2.18), Map.entry(0, 2.07))),
            Map.entry(16, Map.ofEntries(Map.entry(1, 4.49), Map.entry(2, 3.63), Map.entry(3, 3.24), Map.entry(4, 3.01), Map.entry(5, 2.85), Map.entry(6, 2.74), Map.entry(8, 2.59), Map.entry(12, 2.42), Map.entry(16, 2.33), Map.entry(24, 2.24), Map.entry(50, 2.13), Map.entry(0, 2.01))),
            Map.entry(17, Map.ofEntries(Map.entry(1, 4.45), Map.entry(2, 3.59), Map.entry(3, 3.2), Map.entry(4, 2.96), Map.entry(5, 2.81), Map.entry(6, 2.7), Map.entry(8, 2.55), Map.entry(12, 2.38), Map.entry(16, 2.29), Map.entry(24, 2.19), Map.entry(50, 2.08), Map.entry(0, 1.96))),
            Map.entry(18, Map.ofEntries(Map.entry(1, 4.41), Map.entry(2, 3.55), Map.entry(3, 3.16), Map.entry(4, 2.93), Map.entry(5, 2.77), Map.entry(6, 2.66), Map.entry(8, 2.51), Map.entry(12, 2.34), Map.entry(16, 2.25), Map.entry(24, 2.15), Map.entry(50, 2.04), Map.entry(0, 1.92))),
            Map.entry(19, Map.ofEntries(Map.entry(1, 4.38), Map.entry(2, 3.52), Map.entry(3, 3.13), Map.entry(4, 2.9), Map.entry(5, 2.74), Map.entry(6, 2.63), Map.entry(8, 2.48), Map.entry(12, 2.31), Map.entry(16, 2.21), Map.entry(24, 2.11), Map.entry(50, 2.0), Map.entry(0, 1.88))),
            Map.entry(20, Map.ofEntries(Map.entry(1, 4.35), Map.entry(2, 3.49), Map.entry(3, 3.1), Map.entry(4, 2.87), Map.entry(5, 2.71), Map.entry(6, 2.6), Map.entry(8, 2.45), Map.entry(12, 2.28), Map.entry(16, 2.18), Map.entry(24, 2.08), Map.entry(50, 1.96), Map.entry(0, 1.84))),
            Map.entry(21, Map.ofEntries(Map.entry(1, 4.32), Map.entry(2, 3.47), Map.entry(3, 3.07), Map.entry(4, 2.84), Map.entry(5, 2.68), Map.entry(6, 2.57), Map.entry(8, 2.42), Map.entry(12, 2.25), Map.entry(16, 2.15), Map.entry(24, 2.05), Map.entry(50, 1.93), Map.entry(0, 1.81))),
            Map.entry(22, Map.ofEntries(Map.entry(1, 4.3), Map.entry(2, 3.44), Map.entry(3, 3.05), Map.entry(4, 2.82), Map.entry(5, 2.66), Map.entry(6, 2.55), Map.entry(8, 2.4), Map.entry(12, 2.23), Map.entry(16, 2.13), Map.entry(24, 2.03), Map.entry(50, 1.91), Map.entry(0, 1.78))),
            Map.entry(23, Map.ofEntries(Map.entry(1, 4.28), Map.entry(2, 3.42), Map.entry(3, 3.03), Map.entry(4, 2.8), Map.entry(5, 2.64), Map.entry(6, 2.53), Map.entry(8, 2.38), Map.entry(12, 2.2), Map.entry(16, 2.11), Map.entry(24, 2.0), Map.entry(50, 1.88), Map.entry(0, 1.76))),
            Map.entry(24, Map.ofEntries(Map.entry(1, 4.26), Map.entry(2, 3.4), Map.entry(3, 3.01), Map.entry(4, 2.78), Map.entry(5, 2.62), Map.entry(6, 2.51), Map.entry(8, 2.36), Map.entry(12, 2.18), Map.entry(16, 2.09), Map.entry(24, 1.98), Map.entry(50, 1.86), Map.entry(0, 1.73))),
            Map.entry(25, Map.ofEntries(Map.entry(1, 4.24), Map.entry(2, 3.38), Map.entry(3, 2.99), Map.entry(4, 2.76), Map.entry(5, 2.6), Map.entry(6, 2.49), Map.entry(8, 2.34), Map.entry(12, 2.16), Map.entry(16, 2.07), Map.entry(24, 1.96), Map.entry(50, 1.84), Map.entry(0, 1.71))),
            Map.entry(26, Map.ofEntries(Map.entry(1, 4.22), Map.entry(2, 3.37), Map.entry(3, 2.98), Map.entry(4, 2.74), Map.entry(5, 2.59), Map.entry(6, 2.47), Map.entry(8, 2.32), Map.entry(12, 2.15), Map.entry(16, 2.05), Map.entry(24, 1.95), Map.entry(50, 1.82), Map.entry(0, 1.69))),
            Map.entry(27, Map.ofEntries(Map.entry(1, 4.21), Map.entry(2, 3.35), Map.entry(3, 2.96), Map.entry(4, 2.73), Map.entry(5, 2.57), Map.entry(6, 2.46), Map.entry(8, 2.3), Map.entry(12, 2.13), Map.entry(16, 2.03), Map.entry(24, 1.93), Map.entry(50, 1.8), Map.entry(0, 1.67))),
            Map.entry(28, Map.ofEntries(Map.entry(1, 4.2), Map.entry(2, 3.34), Map.entry(3, 2.95), Map.entry(4, 2.71), Map.entry(5, 2.56), Map.entry(6, 2.44), Map.entry(8, 2.29), Map.entry(12, 2.12), Map.entry(16, 2.02), Map.entry(24, 1.91), Map.entry(50, 1.78), Map.entry(0, 1.65))),
            Map.entry(29, Map.ofEntries(Map.entry(1, 4.18), Map.entry(2, 3.33), Map.entry(3, 2.93), Map.entry(4, 2.7), Map.entry(5, 2.54), Map.entry(6, 2.43), Map.entry(8, 2.28), Map.entry(12, 2.1), Map.entry(16, 2.0), Map.entry(24, 1.9), Map.entry(50, 1.77), Map.entry(0, 1.64))),
            Map.entry(30, Map.ofEntries(Map.entry(1, 4.17), Map.entry(2, 3.32), Map.entry(3, 2.92), Map.entry(4, 2.69), Map.entry(5, 2.53), Map.entry(6, 2.42), Map.entry(8, 2.27), Map.entry(12, 2.09), Map.entry(16, 1.99), Map.entry(24, 1.89), Map.entry(50, 1.76), Map.entry(0, 1.62))),
            Map.entry(35, Map.ofEntries(Map.entry(1, 4.12), Map.entry(2, 3.26), Map.entry(3, 2.87), Map.entry(4, 2.64), Map.entry(5, 2.48), Map.entry(6, 2.37), Map.entry(8, 2.22), Map.entry(12, 2.04), Map.entry(16, 1.94), Map.entry(24, 1.83), Map.entry(50, 1.7), Map.entry(0, 1.57))),
            Map.entry(40, Map.ofEntries(Map.entry(1, 4.08), Map.entry(2, 3.23), Map.entry(3, 2.84), Map.entry(4, 2.61), Map.entry(5, 2.45), Map.entry(6, 2.34), Map.entry(8, 2.18), Map.entry(12, 2.0), Map.entry(16, 1.9), Map.entry(24, 1.79), Map.entry(50, 1.66), Map.entry(0, 1.51))),
            Map.entry(45, Map.ofEntries(Map.entry(1, 4.06), Map.entry(2, 3.21), Map.entry(3, 2.81), Map.entry(4, 2.58), Map.entry(5, 2.42), Map.entry(6, 2.31), Map.entry(8, 2.15), Map.entry(12, 1.97), Map.entry(16, 1.87), Map.entry(24, 1.76), Map.entry(50, 1.63), Map.entry(0, 1.48))),
            Map.entry(50, Map.ofEntries(Map.entry(1, 4.03), Map.entry(2, 3.18), Map.entry(3, 2.79), Map.entry(4, 2.56), Map.entry(5, 2.4), Map.entry(6, 2.29), Map.entry(8, 2.13), Map.entry(12, 1.95), Map.entry(16, 1.85), Map.entry(24, 1.74), Map.entry(50, 1.6), Map.entry(0, 1.44))),
            Map.entry(60, Map.ofEntries(Map.entry(1, 4.0), Map.entry(2, 3.15), Map.entry(3, 2.76), Map.entry(4, 2.52), Map.entry(5, 2.37), Map.entry(6, 2.25), Map.entry(8, 2.1), Map.entry(12, 1.92), Map.entry(16, 1.81), Map.entry(24, 1.7), Map.entry(50, 1.56), Map.entry(0, 1.39))),
            Map.entry(70, Map.ofEntries(Map.entry(1, 3.98), Map.entry(2, 3.13), Map.entry(3, 2.74), Map.entry(4, 2.5), Map.entry(5, 2.35), Map.entry(6, 2.23), Map.entry(8, 2.07), Map.entry(12, 1.89), Map.entry(16, 1.79), Map.entry(24, 1.67), Map.entry(50, 1.53), Map.entry(0, 1.35))),
            Map.entry(80, Map.ofEntries(Map.entry(1, 3.96), Map.entry(2, 3.11), Map.entry(3, 2.72), Map.entry(4, 2.49), Map.entry(5, 2.33), Map.entry(6, 2.21), Map.entry(8, 2.06), Map.entry(12, 1.88), Map.entry(16, 1.77), Map.entry(24, 1.65), Map.entry(50, 1.51), Map.entry(0, 1.32))),
            Map.entry(90, Map.ofEntries(Map.entry(1, 3.95), Map.entry(2, 3.1), Map.entry(3, 2.71), Map.entry(4, 2.47), Map.entry(5, 2.32), Map.entry(6, 2.2), Map.entry(8, 2.04), Map.entry(12, 1.86), Map.entry(16, 1.76), Map.entry(24, 1.64), Map.entry(50, 1.49), Map.entry(0, 1.3))),
            Map.entry(100, Map.ofEntries(Map.entry(1, 3.94), Map.entry(2, 3.09), Map.entry(3, 2.7), Map.entry(4, 2.46), Map.entry(5, 2.3), Map.entry(6, 2.19), Map.entry(8, 2.03), Map.entry(12, 1.85), Map.entry(16, 1.75), Map.entry(24, 1.63), Map.entry(50, 1.48), Map.entry(0, 1.28))),
            Map.entry(125, Map.ofEntries(Map.entry(1, 3.92), Map.entry(2, 3.07), Map.entry(3, 2.68), Map.entry(4, 2.44), Map.entry(5, 2.29), Map.entry(6, 2.17), Map.entry(8, 2.01), Map.entry(12, 1.83), Map.entry(16, 1.72), Map.entry(24, 1.6), Map.entry(50, 1.45), Map.entry(0, 1.25))),
            Map.entry(150, Map.ofEntries(Map.entry(1, 3.9), Map.entry(2, 3.06), Map.entry(3, 2.66), Map.entry(4, 2.43), Map.entry(5, 2.27), Map.entry(6, 2.16), Map.entry(8, 2.0), Map.entry(12, 1.82), Map.entry(16, 1.71), Map.entry(24, 1.59), Map.entry(50, 1.44), Map.entry(0, 1.22))),
            Map.entry(200, Map.ofEntries(Map.entry(1, 3.89), Map.entry(2, 3.04), Map.entry(3, 2.65), Map.entry(4, 2.42), Map.entry(5, 2.26), Map.entry(6, 2.14), Map.entry(8, 1.98), Map.entry(12, 1.8), Map.entry(16, 1.69), Map.entry(24, 1.57), Map.entry(50, 1.42), Map.entry(0, 1.19))),
            Map.entry(300, Map.ofEntries(Map.entry(1, 3.87), Map.entry(2, 3.03), Map.entry(3, 2.64), Map.entry(4, 2.41), Map.entry(5, 2.25), Map.entry(6, 2.13), Map.entry(8, 1.97), Map.entry(12, 1.79), Map.entry(16, 1.68), Map.entry(24, 1.55), Map.entry(50, 1.39), Map.entry(0, 1.15))),
            Map.entry(400, Map.ofEntries(Map.entry(1, 3.86), Map.entry(2, 3.02), Map.entry(3, 2.63), Map.entry(4, 2.4), Map.entry(5, 2.24), Map.entry(6, 2.12), Map.entry(8, 1.96), Map.entry(12, 1.78), Map.entry(16, 1.67), Map.entry(24, 1.54), Map.entry(50, 1.38), Map.entry(0, 1.13))),
            Map.entry(500, Map.ofEntries(Map.entry(1, 3.86), Map.entry(2, 3.01), Map.entry(3, 2.62), Map.entry(4, 2.39), Map.entry(5, 2.23), Map.entry(6, 2.11), Map.entry(8, 1.96), Map.entry(12, 1.77), Map.entry(16, 1.66), Map.entry(24, 1.54), Map.entry(50, 1.38), Map.entry(0, 1.11))),
            Map.entry(1000, Map.ofEntries(Map.entry(1, 3.85), Map.entry(2, 3.0), Map.entry(3, 2.61), Map.entry(4, 2.38), Map.entry(5, 2.22), Map.entry(6, 2.1), Map.entry(8, 1.95), Map.entry(12, 1.76), Map.entry(16, 1.65), Map.entry(24, 1.53), Map.entry(50, 1.36), Map.entry(0, 1.08))),
            Map.entry(0, Map.ofEntries(Map.entry(1, 3.84), Map.entry(2, 2.99), Map.entry(3, 2.6), Map.entry(4, 2.37), Map.entry(5, 2.21), Map.entry(6, 2.09), Map.entry(8, 1.94), Map.entry(12, 1.75), Map.entry(16, 1.64), Map.entry(24, 1.52), Map.entry(50, 1.35), Map.entry(0, 1.0)))
    );
    public static double get(int v1, int v2) {
        Integer maxRowKey = Collections.max(table.keySet());
        if(v2 > maxRowKey) {
            v2 = 0;
        }
        Map<Integer, Double> row;
        while((row = table.get(v2)) == null) {
            v2--;
        }
        Integer maxColKey = Collections.max(row.keySet());
        if(v1 > maxColKey) {
            v1 = 0;
        }
        Double value;
        while((value = row.get(v1)) == null) {
            v1++;
        }
        return value;
    }
}
