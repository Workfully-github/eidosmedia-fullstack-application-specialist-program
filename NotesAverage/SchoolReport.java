package NotesAverage;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class SchoolReport {
    public static HashMap<String, Double> getMonthlyAverages(String month, List<Double> monthlyData) {
        HashMap<String, Double> monthlyAverages = new HashMap<>();
            List<Double> values = monthlyData;
            double sum = 0.0;
            for (double value : values) {
                sum += value;
            }
            double average = sum / values.size();
            monthlyAverages.put(month, average);
        return monthlyAverages;
    }

    public static void main(String[] args) {
        HashMap<String, List<Double>> monthlyData = new HashMap<>();
        monthlyData.put("January", new ArrayList<Double>() {{
            add(1.0);
            add(2.0);
            add(3.0);
        }});
        monthlyData.put("February", new ArrayList<Double>() {{
            add(4.0);
            add(5.0);
            add(6.0);
        }});
        monthlyData.put("March", new ArrayList<Double>() {{
            add(7.0);
            add(8.0);
            add(9.0);
        }});
        monthlyData.put("April", new ArrayList<Double>() {{
            add(10.0);
            add(11.0);
            add(12.0);
        }});
        monthlyData.put("May", new ArrayList<Double>() {{
            add(13.0);
            add(14.0);
            add(15.0);
        }});
        monthlyData.put("June", new ArrayList<Double>() {{
            add(16.0);
            add(17.0);
            add(18.0);
        }});
        monthlyData.put("July", new ArrayList<Double>() {{
            add(19.0);
            add(20.0);
            add(21.0);
        }});
        monthlyData.put("August", new ArrayList<Double>() {{
            add(22.0);
            add(23.0);
            add(24.0);
        }});
        monthlyData.put("September", new ArrayList<Double>() {{
            add(25.0);
            add(26.0);
            add(27.0);
        }});
        monthlyData.put("October", new ArrayList<Double>() {{
            add(28.0);
            add(29.0);
            add(30.0);
        }});
        monthlyData.put("November", new ArrayList<Double>() {{
            add(31.0);
            add(32.0);
            add(33.0);
        }});
        monthlyData.put("December", new ArrayList<Double>() {{
            add(31.0);
            add(32.0);
            add(33.0);
        }});
    
        for (String key : monthlyData.keySet()) {
            HashMap<String, Double> averagebymonth = SchoolReport.getMonthlyAverages(key, monthlyData.get(key));
            System.out.println("month: " + key + ", average: " + averagebymonth.get(key));
        }

    }

}