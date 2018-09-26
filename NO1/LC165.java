// Compare Version Numbers

class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null && version2 == null)
            return 0;

        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        for (int i = 0; i < Math.max(ver1.length, ver2.length); i++) {
            int num1 = i < ver1.length ? Integer.parseInt(ver1[i]) : 0;
            int num2 = i < ver2.length ? Integer.parseInt(ver2[i]) : 0;
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }
}