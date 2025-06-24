use std::collections::{HashSet};
use super::Solution;
impl Solution {
    pub fn is_happy(n: i32) -> bool {
        let mut i = n;
        let mut cache = HashSet::new();
        while i != 1 && !cache.contains(&i) {
            cache.insert(i);
            i = Self::sum(i);
            if i == 1 {
                return true;
            }
        }
        false
    }
    fn sum(n: i32) -> i32 {
        let mut sum = 0;
        let mut n = n;
        while n > 0 {
            let digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        sum
    }
}

#[cfg(test)]
mod tests {
    use crate::hash_table::Solution;

    #[test]
    fn test_is_happy() {
        assert_eq!(Solution::is_happy(19), true);
    }
}