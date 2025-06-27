use super::Solution;
use std::collections::HashMap;
impl Solution {
    pub fn is_anagram(s: String, t: String) -> bool {
        if s.len() != t.len() {
            return false;
        }
        let mut map = HashMap::new();
        for (sc, tc) in s.chars().zip(t.chars()) {
            *map.entry(sc).or_insert(0) += 1;
            *map.entry(tc).or_insert(0) -= 1;
        }
        map.values().all(|&c| c == 0)
    }
}
#[cfg(test)]
mod tests {
    use crate::hash_table::Solution;

    #[test]
    fn test_is_anagram() {
        let anagram = Solution::is_anagram("anagram".to_string(), "nagaram".to_string());
        assert_eq!(anagram, true);
    }
}
