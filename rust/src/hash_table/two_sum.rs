use super::Solution;
use std::collections::HashMap;
impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut map = HashMap::new();
        for (index, val) in nums.iter().enumerate() {
            let remain = target - val;
            if let Some(&item) = map.get(&remain) {
                return vec![index as i32, item];
            }
            map.insert(*val, index as i32);
        }
        vec![]
    }
}
#[cfg(test)]
mod tests {
    use super::Solution;
    #[test]
    fn test_hash_table() {
        Solution::two_sum(vec![2, 7, 11, 15], 9);
    }
}
