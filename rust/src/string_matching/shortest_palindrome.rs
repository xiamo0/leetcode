use crate::string_matching::Solution;
impl Solution {
    pub fn shortest_palindrome(s: String) -> String {
        
        if s.chars().count()<=1 {
            return s;
        }
        let mut clone_s = s.clone();

        let mut r = String::from("");
        let mut index = 0;
        while let Some(last) = clone_s.pop() {

            if r.contains(&s) {
                break;
            }
            if r.chars().count() ==0 {
                r.push(last);
                r.insert(index, last);
            }else {
                r.insert(index, last);
                if r.contains(&s) {
                    break;
                }
                r.insert(r.chars().count() - index, last);
            }
            index+=1;
        }
        r
    }
}
#[cfg(test)]
mod tests {
    use super::Solution;
    #[test]
    fn test_shortest_palindrome() {
        let string = Solution::shortest_palindrome("aacecaaa".to_owned());
        assert_eq!(string, "aaacecaaa".to_string());
    }
}