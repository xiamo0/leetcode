use std::collections::HashSet;

pub fn contains_duplicate(nums: Vec<i32>) -> bool {
    nums.iter().collect::<HashSet<_>>().iter().len() != nums.len()
}
#[cfg(test)]
mod tests {
    use crate::hash_table::contains_duplicate::contains_duplicate;

    #[test]
    fn test() {
        assert_eq!(contains_duplicate(vec![]), false);
    }
}