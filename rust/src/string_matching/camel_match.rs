use crate::string_matching::Solution;
use regex::Regex;

impl Solution {
    pub fn camel_match(queries: Vec<String>, pattern: String) -> Vec<bool> {
        let mut regexP = String::new();
        regexP.push_str("^[a-z]*");
        pattern.chars().for_each(|c| {
            regexP.push(c);
            regexP.push_str("[a-z]*");
        });
        regexP.push_str("$");
        let regex = Regex::new(&regexP).unwrap();

        let r: Vec<bool> = queries.iter().map(|item| regex.is_match(&item)).collect();
        r
    }
}
#[cfg(test)]
mod tests {
    use crate::string_matching::Solution;

    #[test]
    fn test() {
        let queries: Vec<String> = vec![
            String::from("FooBar"),
            "FooBarTest".to_string(),
            "FootBall".to_string(),
            "FrameBuffer".to_string(),
            "ForceFeedBack".to_string(),
        ];
        let result: Vec<bool> = vec![true, false, true, true, false];
        assert_eq!(Solution::camel_match(queries, "FB".to_string()), result)
    }
}
