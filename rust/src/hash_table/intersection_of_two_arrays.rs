use super::Solution;
impl Solution {
    pub fn intersection(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        let mut vec_copy = nums1.clone();
        vec_copy.retain(|x| nums2.contains(x));
        vec_copy.sort();
        vec_copy.dedup();
        vec_copy
    }
}
#[cfg(test)]
mod tests {
    use crate::hash_table::Solution;

    #[test]
    fn test() {
        let vec1 = Solution::intersection(vec![1, 2, 2, 1], vec![2, 2]);
        assert_eq!(vec1, vec![2]);
    }
}
