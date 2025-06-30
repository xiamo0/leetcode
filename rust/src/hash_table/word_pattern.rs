use super::Solution;
use std::collections::HashMap;

impl Solution {
    pub fn word_pattern(pattern: String, s: String) -> bool {
        let pattern_vec: Vec<char> = pattern.chars().collect();
        let s_vec: Vec<String> = s.split(" ").map(|s| s.to_string()).collect();
        if pattern_vec.len() != s_vec.len() {
            return false;
        }
        let mut map = HashMap::new();
        for (&item1, item2) in pattern_vec.iter().zip(s_vec.iter()) {
            let exists = map.values().any(|v| *v == item2);
            let option = map.get(&item1);
            if option.is_none() && exists {
                return false;
            }
            if option.is_none() {
                map.insert(item1, item2);
                continue;
            }
            let x = option.unwrap();
            if *x != item2 {
                return false;
            }
        }
        return true;
    }
}
#[cfg(test)]
mod tests {
    use crate::hash_table::Solution;

    #[test]
    fn test_word_pattern() {
        let pattern = Solution::word_pattern("abba".to_string(), "dog cat cat dog".to_string());
        assert_ne!(false, pattern);
    }
}
