// Definition for a binary tree node.
#[derive(Debug, PartialEq, Eq)]
struct TreeNode {
    pub val: i32,
    pub left: Option<Rc<RefCell<TreeNode>>>,
    pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
    #[inline]
    pub fn new(val: i32) -> Self {
        TreeNode {
            val,
            left: None,
            right: None,
        }
    }
}
use std::rc::Rc;
use std::cell::RefCell;
struct Solution;
impl Solution {
    pub fn has_path_sum(root: Option<Rc<RefCell<TreeNode>>>, target_sum: i32) -> bool {
        if let Some(node) = root {
            let n = node.borrow();
            let val = n.val;
            let left = n.left.clone();
            let right = n.right.clone();
            let remain = target_sum - val;
            if remain == 0 && left.is_none() && right.is_none() {
                return true;
            }
            let mut left_flag = false;
            let mut right_flag = false;
            if let Some(left) = left {
                left_flag = Self::has_path_sum(left.borrow().left.clone(), remain);
            }
            if let Some(right) = right {
                right_flag = Self::has_path_sum(right.borrow().right.clone(), remain);
            }
            return left_flag || right_flag;
        }
        false
    }
}
#[cfg(test)]
mod tests {
    use std::cell::RefCell;
    use std::rc::Rc;
    use crate::binary_tree::path_sum::{Solution, TreeNode};

    #[test]
    fn binary_tree_path_sum_test() {
        let root=Some(Rc::new(RefCell::new(TreeNode::new(1))));
        let sum = Solution::has_path_sum(root, 1);
        assert_eq!(true, sum);
    }
}