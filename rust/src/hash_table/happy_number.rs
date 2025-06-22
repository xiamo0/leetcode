use std::collections::HashMap;
use super::Solution;
impl Solution {
    pub fn is_happy(n: i32) -> bool {
        if n == 1 {
            return true;
        }
        let cache = HashMap::new();

        let count = 0;
        while count < i32::MAX {
            let i = Self::sum(n);
            if i==1 {
                return true;
            }else {
                n=i;
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