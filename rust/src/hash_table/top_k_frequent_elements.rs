use super::Solution;
use std::collections::HashMap;

impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        let mut map = HashMap::new();
        for x in nums {
            *map.entry(x).or_insert(0) += 1;
        }
        let mut vec: Vec<_> = map.into_iter().collect();
        vec.sort_by(|a, b| b.1.cmp(&a.1));
        vec.into_iter().take(k as usize).map(|(n, _)| n).collect()
    }
}
#[cfg(test)]
mod tests {
    use crate::hash_table::Solution;

    #[test]
    fn test() {
        let vec1 = Solution::top_k_frequent(vec![1, 1, 1, 2, 2, 3], 2);
        assert_eq!(vec![1, 2], vec1);
    }
}
