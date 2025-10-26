use crate::string_matching::Solution;
use std::usize;
impl Solution {
    pub fn shortest_matching_substring(s: String, p: String) -> i32 {
        let mut min_len = usize::max_value();
        let mut split = p.split('*');
        let prefix = split.next().unwrap_or("");
        let middle = split.next().unwrap_or("");
        let suffix = split.next().unwrap_or("");

        let length = s.len();
        for index in 0..length {
            if !s[index..].starts_with(prefix) {
                continue;
            }
            let after_prefix_index = index + prefix.len();
            let middle_index = s[(index + prefix.len())..]
                .find(middle)
                .map(|pos| after_prefix_index + pos);
            if middle_index.is_none() {
                continue;
            }
            let middle_index = middle_index.unwrap();
            let after_middle_index = middle_index + middle.len();
            let suffix_index = s[after_middle_index..]
                .find(suffix)
                .map(|pos| after_middle_index + pos);
            if suffix_index.is_none() {
                continue;
            }
            let suffix_index = suffix_index.unwrap();
            let after_suffix_index = suffix_index + suffix.len();
            let len = after_suffix_index - index;
            if len < min_len {
                min_len = len;
            }
        }

        if min_len == usize::max_value() {
            return -1;
        }
        min_len as i32
    }
}
#[cfg(test)]
mod tests {
    use crate::string_matching::Solution;

    #[test]
    fn test_shortest_matching_substring() {
        let r = Solution::shortest_matching_substring("a".to_string(), String::from("**"));
        println!("r{}", r);
        assert_ne!(r, 2);
    }
}
