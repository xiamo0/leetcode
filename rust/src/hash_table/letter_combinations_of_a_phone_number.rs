use super::Solution;
impl Solution {
    pub fn letter_combinations(digits: String) -> Vec<String> {
        if digits.is_empty() {
            return vec![];
        }
        let digit_to_letters = vec![
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz",
        ];
        let mut vec: Vec<String> = vec!["".to_string()];
        let chars = digits.chars();
        for x in chars {
            let x1 = x as usize - '0' as usize;
            let letters = digit_to_letters[x1];
            vec = Self::result(letters, &vec);
        }
        vec
    }
    pub fn result(p0: &str, p1: &Vec<String>) -> Vec<String> {
        let mut res = Vec::new();
        for x in p0.chars() {
            for px in p1 {
                res.push(format!("{}{}", px.to_string(), x.to_string()));
            }
        }
        res
    }
}

#[cfg(test)]
mod test {
    use super::Solution;
    #[test]
    fn test_hash_combinations() {
        let vec = Solution::letter_combinations(String::from("23"));
        println!("{:?}", vec);

        // assert_eq!(vec, Vec::new())
    }
}
