use super::Solution;

impl Solution {
    pub fn word_pattern(pattern: String, s: String) -> bool {}
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
