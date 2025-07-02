use super::Solution;
use super::TreeNode;
use std::cell::RefCell;
use std::rc::Rc;
impl Solution {
    pub fn build_tree(inorder: Vec<i32>, postorder: Vec<i32>) -> Option<Rc<RefCell<TreeNode>>> {}
}
#[cfg(test)]
mod tests {
    use crate::hash_table::Solution;

    #[test]
    fn test_build_tree() {
        Solution::build_tree(vec![2, 1, 3, 5, 6, 7], vec![2, 3, 5, 6, 1]);
    }
}
