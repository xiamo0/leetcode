use super::Solution;
impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
0
    }
}
#[cfg(test)]
mod tests {
    #[test]
    fn test() {
        use super::Solution;
        assert_eq!(Solution::length_of_longest_substring("abcabcbb".to_string()), 3);
    }
}