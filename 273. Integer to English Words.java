class Solution {
    String[] oneTo19 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen" };
    String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        int billion = num / 1000000000;
        num %= 1000000000;
        int million = num / 1000000;
        num %= 1000000;
        int thousand = num / 1000;
        num %= 1000;

        String res = "";

        if (billion != 0) {
            res += helper(billion) + " Billion ";
        }
        if (million != 0) {
            res += helper(million) + " Million ";
        }
        if (thousand != 0) {
            res += helper(thousand) + " Thousand ";
        }
        if (num != 0) {
            res += helper(num);
        }
        return res.trim();
    }

    String helper(int num) {
        if (num == 0)
            return "";
        int hundred = num / 100;
        int rest = num % 100;

        if (hundred != 0 && rest != 0) {
            return oneTo19[hundred] + " Hundred " + twoDigit(rest);
        } else if (hundred != 0) {
            return oneTo19[hundred] + " Hundred";
        } else {
            return twoDigit(rest);
        }
    }

    String twoDigit(int n) {
        if (n == 0)
            return "";
        if (n < 20)
            return oneTo19[n];
        int tenner = n / 10;
        int rest = n % 10;

        if (tenner != 0 && rest != 0) {
            return tens[tenner] + " " + oneTo19[rest];
        } else if (tenner != 0) {
            return tens[tenner];
        } else if (rest != 0) {
            return oneTo19[rest];
        }
        return "";
    }
}