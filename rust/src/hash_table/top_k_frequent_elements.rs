use super::Solution;

impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {}
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
