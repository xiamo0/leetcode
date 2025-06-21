// Definition for a binary tree node.
use crate::binary_tree::tree_node::TreeNode;
use std::cell::RefCell;
use std::rc::Rc;

struct Solution;
impl Solution {
    pub fn has_path_sum(root: Option<Rc<RefCell<TreeNode>>>, target_sum: i32) -> bool {
        let Some(node) = root else {
            return false;
        };
        let node = node.borrow();
        let remain = target_sum - node.val;
        if node.left.is_none() && node.right.is_none() {
            return remain == 0;
        }
        return Self::has_path_sum(node.left.clone(), remain)
            || Self::has_path_sum(node.right.clone(), remain);
    }
    /*pub fn has_path_sum(root: Option<Rc<RefCell<TreeNode>>>, target_sum: i32) -> bool {
        if root.is_none() {
            return false;
        }
        let Some(node) = root;
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
    }*/
}
#[cfg(test)]
mod tests {
    use crate::binary_tree::path_sum::{Solution, TreeNode};
    use std::cell::RefCell;
    use std::rc::Rc;

    #[test]
    fn binary_tree_path_sum_test() {
        let left = Some(Rc::new(RefCell::new(TreeNode::new(2))));
        let root = Some(Rc::new(RefCell::new(TreeNode {
            val: 1,
            left: left,
            right: None,
        })));
        let sum = Solution::has_path_sum(root, 3);
        assert_eq!(true, sum);
    }
}
