use crate::string_matching::Solution;

impl Solution {
    pub fn rotate_string(s: String, goal: String) -> bool {
        let x = s.len() == goal.len();
        if !x {
            return false;
        }
        let s2 = format!("{}{}", s, s);
        s2.contains(goal.as_str())
    }
}
#[cfg(test)]
mod tests {
    use crate::string_matching::Solution;

    #[test]
    fn test_rotate_string() {
        assert_eq!(
            Solution::rotate_string("abcde".to_string(), "bcdea".to_string()),
            true
        );
    }
}
