package strings;

public class S01ReorderDataLogFile {
    public static void main(String[] args) {
        String[] logs = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
        int n = logs.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                String t1 = logs[j - 1].substring(logs[j - 1].indexOf(' ') + 1);
                String t2 = logs[j].substring(logs[j].indexOf(' ') + 1);
                if (t1.matches(".*\\d.*") && t2.matches(".*\\d.*") || t2.matches(".*\\d.*")) {
                    continue;
                }

                if (t1.matches(".*\\d.*") || t1.compareTo(t2) > 0) {
                    // System.out.println(t1 +" "+ t2);
                    String tmp = logs[j - 1];
                    logs[j - 1] = logs[j];
                    logs[j] = tmp;
                    // System.out.println(logs[j-1] +" "+ logs[j]);
                } else if (t1.compareTo(t2) == 0) {
                    if (logs[j - 1].split(" ")[0].compareTo(logs[j].split(" ")[0]) > 0) {
                        String tmp = logs[j - 1];
                        logs[j - 1] = logs[j];
                        logs[j] = tmp;
                    }
                }
            }
        }

        for (String s : logs) {
            System.out.println(s);
        }
    }
}
