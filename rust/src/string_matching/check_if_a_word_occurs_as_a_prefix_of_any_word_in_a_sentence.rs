use crate::string_matching::Solution;
impl Solution {
    pub fn is_prefix_of_word(sentence: String, search_word: String) -> i32 {
        
        let d: Vec<_> = sentence.split(' ').collect();
        for (index, value) in d.iter().enumerate() {
            if value.starts_with(&search_word) {
                return (index + 1) as i32;
            }
        }
        -1
    }
}
#[cfg(test)]
mod tests {
    use crate::string_matching::Solution;

    #[test]
    fn test_is_prefix_of_word() {
        let index = Solution::is_prefix_of_word("i love eating burger".to_string(), "burger".to_string());
        assert_ne!(index, 0);

    }
}