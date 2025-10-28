use crate::string_matching::Solution;
impl Solution {
    pub fn generate_string(str1: String, str2: String) -> String {
        let n = str1.len();
        let m = str2.len();
        let mut word = vec!['?'; n + m - 1];

        for (i, c) in str1.chars().enumerate() {
            if c == 'T' {
                for (j, c1) in str2.chars().enumerate() {
                    if word[i + j] == '?' || word[i + j] == c1 {
                        word[i + j] = c1;
                    } else {
                        return "".to_string();
                    }
                }
            }
        }
        for (i, c) in str1.chars().enumerate() {
            if c == 'F' {
                let mut can_make_diff = false;
                for (j, c1) in str2.chars().enumerate() {
                    if word[i + j] == '?' {
                        if str2.chars().nth(j).unwrap() == 'a' {
                            word[i + j] = 'a';
                        } else {
                            word[i + j] = 'a';
                        }
                        can_make_diff = true;
                        break;
                    } else if word[i + j] != c1 {
                        can_make_diff = true;
                        break;
                    }
                }
                if !can_make_diff {
                    return "".to_string();
                }
            }
        }
        for i in 0..word.len() {
            if word[i] == '?' {
                word[i] = 'a';
            }
        }
        word.iter().collect::<String>()
    }
}
#[cfg(test)]
mod tests {
    use crate::string_matching::Solution;

    #[test]
    fn test_generate_string() {
        let str = Solution::generate_string("TFTF".to_string(), "ab".to_string());
        println!("str {}", str);
        //assert_eq!(str,"ababa".to_string());
    }
}