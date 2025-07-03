use super::Solution;
use std::cmp::Reverse;
use std::collections::{BinaryHeap, HashMap};

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

    pub fn top_k_frequent_1(nums: Vec<i32>, k: i32) -> Vec<i32> {
        let mut map = HashMap::new();
        for x in nums {
            *map.entry(x).or_insert(0) += 1;
        }
        let mut heap = BinaryHeap::new();
        for (num, count) in map {
            heap.push(Reverse((count, num)));
            if heap.len() > k as usize {
                heap.pop();
            }
        }
        let vec = heap.into_iter().map(|Reverse((_, num))| num).collect();
        vec
    }
}
#[cfg(test)]
mod tests {
    use crate::hash_table::Solution;

    #[test]
    fn test() {
        let vec1 = Solution::top_k_frequent(vec![1, 1, 1, 2, 2, 3], 2);
        let vec2 = Solution::top_k_frequent_1(vec![1, 1, 1, 2, 2, 3], 2);
        //  assert_eq!(vec2, vec1);
    }
}
