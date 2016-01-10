import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: 王俊超
 * Date: 2016-01-09 15:43
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class DenseLine {

    public double[] getLine(Point[] p, int n) {
        Line l = findBestLine(p);
        return new double[]{l.slope, l.intercept};

    }

    public static int countEqualLine(List<Line> lines, Line line) {
        if (lines == null) {
            return 0;
        }

        int count = 0;
        for (Line l : lines) {
            if (l.equals(line)) {
                count++;
            }
        }
        return count;
    }



    public int countEqualLine(Map<Double, List<Line>> map, Line line) {
        double key = Line.floorToNearestEpsilon(line.slope);
        int count = countEqualLine(map.get(key), line);
        count += countEqualLine(map.get(key - Line.EPSILON), line);
        count += countEqualLine(map.get(key + Line.EPSILON), line);
        return count;
    }

    public static void insertLine(Map<Double, List<Line>> linesBySlope, Line line) {
        List<Line> lines = null;
        double key = Line.floorToNearestEpsilon(line.slope);
        if (!linesBySlope.containsKey(key)) {
            lines = new ArrayList<>();
            linesBySlope.put(key, lines);
        } else {
            lines = linesBySlope.get(key);
        }
        lines.add(line);
    }

    public Line findBestLine(Point[] points) {
        Line bestLine = null;
        int bestCount = 0;
        Map<Double, List<Line>> linesBySlope = new HashMap<>();

        // 计算所有的直线
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Line line = new Line(points[i], points[j]);
                // 向集合中插入直线
                insertLine(linesBySlope, line);

				// 计算相等的直线
                int count = countEqualLine(linesBySlope, line);

				// 找过点最多的直线
                if (count > bestCount) {
                    bestLine = line;
                    bestCount = count;
                }
            }
        }

        return bestLine;
    }

    /**
     * 直线类
     */
    private static class Line {
        // 直线的误差范围
        public final static double EPSILON = 0.0001;
        // 直线的斜率
        public double slope;
        // 直线的截距
        public double intercept;
        // 斜率是否是无穷大
        private boolean infiniteSlope = false;

        public Line(Point p, Point q) {
            // 两个点的x必须是在误差范围外，否则就认为这两个点的直线与x轴垂直
            if (Math.abs(p.x - q.x) > EPSILON) {
                // 求直线的斜率
                slope = (p.y - q.y) / (p.x - q.x);
                // 直线的截距，y的截距
                intercept = p.y - slope * p.x;
            } else {
                // 直线与x轴垂直
                infiniteSlope = true;
                // 求截距，此时的截距是x的，不是y的
                intercept = p.x;
            }
        }

        /**
         * 判断两数是否相等
         *
         * @param a
         * @param b
         * @return
         */
        public boolean equals(double a, double b) {
            return Math.abs(a - b) < EPSILON;
        }

        /**
         * 误差范围内最接近d的数
         *
         * @param d
         * @return
         */
        public static double floorToNearestEpsilon(double d) {
            int r = (int) (d / EPSILON);
            return ((double) r) * EPSILON;
        }

        /**
         * 判断两条直线是否是同一条直线
         *
         * @param l
         * @return
         */
        public boolean equals(Line l) {

            if (equals(l.slope, slope) && equals(l.intercept, intercept)
                    && l.infiniteSlope == infiniteSlope) {
                return true;
            }

            return false;
        }
    }
}
