use crate::string_matching::Solution;
impl Solution {
    pub fn repeated_substring_pattern(s: String) -> bool {
        if s.len() < 2 {
            return false;
        }
        let s2 = format!("{}{}", s, s);
        let s3 = &s2[1..s2.len() - 1];
        s3.contains(&s)
    }
}
#[cfg(test)]
mod tests {
    use crate::string_matching::Solution;

    #[test]
    fn test_string_matching() {
        assert_eq!(Solution::repeated_substring_pattern("acac".to_string()), true);
    }
}