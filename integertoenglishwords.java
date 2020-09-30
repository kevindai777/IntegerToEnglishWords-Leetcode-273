//Java Solution

class Solution {
    public String numberToWords(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1000000000, "Billion");
        map.put(1000000, "Million");
        map.put(1000, "Thousand");
        map.put(100, "Hundred");
        map.put(90, "Ninety");
        map.put(80, "Eighty");
        map.put(70, "Seventy");
        map.put(60, "Sixty");
        map.put(50, "Fifty");
        map.put(40, "Forty");
        map.put(30, "Thirty");
        map.put(20, "Twenty");
        map.put(19, "Nineteen");
        map.put(18, "Eighteen");
        map.put(17, "Seventeen");
        map.put(16, "Sixteen");
        map.put(15, "Fifteen");
        map.put(14, "Fourteen");
        map.put(13, "Thirteen");
        map.put(12, "Twelve");
        map.put(11, "Eleven");
        map.put(10, "Ten");
        map.put(9, "Nine");
        map.put(8, "Eight");
        map.put(7, "Seven");
        map.put(6, "Six");
        map.put(5, "Five");
        map.put(4, "Four");
        map.put(3, "Three");
        map.put(2, "Two");
        map.put(1, "One");
        
        List<Pair<Integer, String>> sorted = new ArrayList<>();
        for (Map.Entry<Integer, String> set : map.entrySet()) {
            sorted.add(new Pair(set.getKey(), set.getValue()));
        }
        Collections.sort(sorted, (a,b) -> b.getKey() - a.getKey());
        
        if (num == 0) {
            return "Zero";
        }
        
        if (num <= 20) {
            return map.get(num);
        }
        
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < sorted.size(); i++) {
            int value = sorted.get(i).getKey();
            String translation = sorted.get(i).getValue();
            
            int repeat = num / value;
            
            if (repeat == 0) {
                continue;
            }
            
            num -= (repeat * value);
            
            if (repeat == 1 && value >= 100) {
                result.add("One");
                result.add(translation);
                continue;
            }
            
            if (repeat == 1) {
                result.add(translation);
                continue;
            }
            
            result.add(numberToWords(repeat));
            result.add(translation);
        }
        
        String[] sentence = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            sentence[i] = result.get(i);
        }
        
        return String.join(" ", sentence);
    }
}