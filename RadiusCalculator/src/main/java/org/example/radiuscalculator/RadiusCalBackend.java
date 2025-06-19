package org.example.radiuscalculator;

public class RadiusCalBackend {
    public static double calculateRadius(double g, double f, double c) {
        double insideRoot = g * g + f * f - c;

        if (insideRoot < 0) {
            throw new IllegalArgumentException("insideRoot < 0");
        }
        return Math.sqrt(insideRoot);
    }
}
