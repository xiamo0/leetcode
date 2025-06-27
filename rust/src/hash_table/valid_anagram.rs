use super::Solution;
impl Solution {
    pub fn is_anagram(s: String, t: String) -> bool {

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