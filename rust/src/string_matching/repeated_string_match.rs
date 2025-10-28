use super::Solution;
impl Solution {
    pub fn repeated_string_match(a: String, b: String) -> i32 {
        let mut r = -1_i32;
        let mut str = "".to_string();
        let max_length = a.len() + b.len();
        loop {
            r += 1;
            if str.contains(&b) {
                return r;
            }
            if str.len() >= max_length {
                return -1;
            }
            str = format!("{}{}", str, a);
        }
    }
}
#[cfg(test)]
mod tests {
    use crate::string_matching::Solution;

    #[test]
    fn repeated_string_match() {
        let a = "abcd".to_string();
        let b = "cdabcdab".to_string();
        assert_eq!(Solution::repeated_string_match(a, b), 3);
    }
}
