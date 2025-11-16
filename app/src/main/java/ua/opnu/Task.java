package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {
    }

    public void removeShorterStrings(List<String> list) {
        if (list == null || list.size() < 2) return;
        int pos = 0;
        while (pos + 1 < list.size()) {
            String first = list.get(pos);
            String second = list.get(pos + 1);
            if (first.length() <= second.length()) {
                list.remove(pos);
            } else {
                list.remove(pos + 1);
            }
            pos += 1;
        }
    }

    public void stutter(List<String> list) {
        if (list == null || list.isEmpty()) return;
        int cursor = 0;
        while (cursor < list.size()) {
            String current = list.get(cursor);
            list.add(cursor + 1, current);
            cursor += 2;
        }
    }

    public void switchPairs(List<String> list) {
        if (list == null || list.size() < 2) return;
        for (int i = 0; i + 1 < list.size(); i += 2) {
            String a = list.get(i);
            String b = list.get(i + 1);
            list.set(i, b);
            list.set(i + 1, a);
        }
    }

    public void removeDuplicates(List<String> list) {
        if (list == null || list.size() < 2) return;
        int i = 0;
        while (i + 1 < list.size()) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i);
            } else {
                i += 1;
            }
        }
    }

    public void markLength4(List<String> list) {
        if (list == null || list.isEmpty()) return;
        int index = 0;
        while (index < list.size()) {
            String value = list.get(index);
            if (value != null && value.length() == 4) {
                list.add(index, "****");
                index += 2;
            } else {
                index += 1;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue == null) return true;
        Deque<Integer> helper = new ArrayDeque<>();
        int n = queue.size();
        for (int i = 0; i < n; i++) {
            Integer item = queue.remove();
            helper.push(item);
            queue.add(item);
        }
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            Integer front = queue.remove();
            Integer mirror = helper.pop();
            if (!Objects.equals(front, mirror)) ok = false;
            queue.add(front);
        }
        return ok;
    }

    public void reorder(Queue<Integer> queue) {
        if (queue == null || queue.size() < 2) return;
        List<Integer> buffer = new ArrayList<>();
        while (!queue.isEmpty()) buffer.add(queue.remove());
        Collections.sort(buffer);
        for (Integer v : buffer) queue.add(v);
    }

    public void rearrange(Queue<Integer> queue) {
        if (queue == null || queue.size() < 2) return;
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer val = queue.remove();
            if (val % 2 == 0) evenList.add(val);
            else oddList.add(val);
        }
        for (Integer e : evenList) queue.add(e);
        for (Integer o : oddList) queue.add(o);
    }

    public int maxLength(Set<String> set) {
        if (set == null || set.isEmpty()) return 0;
        int longest = 0;
        for (String s : set) {
            if (s != null) longest = Math.max(longest, s.length());
        }
        return longest;
    }

    public void removeEvenLength(Set<String> set) {
        if (set == null || set.isEmpty()) return;
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String cur = iterator.next();
            if (cur != null && cur.length() % 2 == 0) iterator.remove();
        }
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null) return 0;
        Set<Integer> seen = new HashSet<>(list1);
        Set<Integer> intersection = new HashSet<>();
        for (Integer v : list2) {
            if (seen.contains(v)) intersection.add(v);
        }
        return intersection.size();
    }

    public boolean isUnique(Map<String, String> map) {
        if (map == null) return true;
        Set<String> seenValues = new HashSet<>();
        for (String val : map.values()) {
            if (!seenValues.add(val)) return false;
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> out = new HashMap<>();
        if (map1 == null || map2 == null) return out;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (map2.containsKey(key) && Objects.equals(map2.get(key), value)) {
                out.put(key, value);
            }
        }
        return out;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> flipped = new HashMap<>();
        if (map == null || map.isEmpty()) return flipped;
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            Integer k = e.getKey();
            String v = e.getValue();
            if (!flipped.containsKey(v) || k > flipped.get(v)) {
                flipped.put(v, k);
            }
        }
        return flipped;
    }

    public int rarest(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) return 0;
        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer v : map.values()) {
            counts.put(v, counts.getOrDefault(v, 0) + 1);
        }
        int minCount = Integer.MAX_VALUE;
        for (Integer c : counts.values()) minCount = Math.min(minCount, c);
        int candidate = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
            int val = e.getKey();
            int cnt = e.getValue();
            if (cnt == minCount && val < candidate) candidate = val;
        }
        return candidate;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list == null || list.isEmpty()) return 0;
        Map<Integer, Integer> counts = new HashMap<>();
        int best = 0;
        for (Integer v : list) {
            int now = counts.getOrDefault(v, 0) + 1;
            counts.put(v, now);
            if (now > best) best = now;
        }
        return best;
    }
}
